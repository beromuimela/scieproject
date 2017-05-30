/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.CandidatoServico;
import Servico.UtilizadorServico;
import entidades.Candidato;
import entidades.FichaInscricao;
import entidades.Inscricao;
import entidades.Periodo;
import entidades.Utilizador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author junito
 */
public class InscricaoDAO {

    private Connection con;

    public InscricaoDAO() {
        this.con = new Conexao().conectar();
    }

    public void increver(Inscricao inscricao) throws SQLException {
        String sql = "call inserir_matricula(?,?,?,?,?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setDate(1, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        callableStatement.setInt(2, inscricao.getCandidato().getIdcandidato());
        callableStatement.setInt(3, inscricao.getCurso().getIdcurso());
        callableStatement.setFloat(4, inscricao.getValor());
        callableStatement.setInt(5, inscricao.getUtilizador().getIdutilizador());
        callableStatement.setInt(6, inscricao.getPeriodo().getNomePeriodo().getId());
        callableStatement.setDate(7, new java.sql.Date(inscricao.getPeriodo().getDatainicio().getTime()));
        callableStatement.setFloat(8, inscricao.getTroco());
        callableStatement.execute();
        callableStatement.close();

    }

    public int nrEstudantesPorPeriodo(Periodo periodo) throws SQLException {
        int numero = 0;

        String sql = "call qtdEstudantes(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, periodo.getNomePeriodo().getId());
        callableStatement.setDate(2, new java.sql.Date(periodo.getDatainicio().getTime()));

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            numero++;
        }
        callableStatement.close();
        return numero;
    }

    public int nrInscricaoByCand(int id) throws SQLException {
        int matricula = 0;
        String sql = "call obterIdInscricaoPorCand(?)";
        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, id);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            matricula = res.getInt("idmatricula");
        }
        callableStatement.close();
        return matricula;
    }

    public List<FichaInscricao> listaFichaInscricao() throws SQLException {
        List<FichaInscricao> fichaInscricao = new ArrayList<FichaInscricao>();
        String sql = "call Listar_fichaInscricao()";

        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();

        while (res.next()) {
            FichaInscricao f = new FichaInscricao();
            f.setIdmatricula(res.getInt("idmatricula"));
            Candidato cand = new Candidato();
            cand = new CandidatoServico().ObterCandidatoEst(res.getInt("idcandidato"));
            f.setCandidato(cand);
           
            f.setData(res.getDate("dataFicha"));
           
            fichaInscricao.add(f);
        }
        callableStatement.close();
        return fichaInscricao;
    }
}
