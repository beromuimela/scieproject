/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.CursoServico;
import Servico.FormadorServico;
import Servico.PeriodoServico;
import entidades.Curso;
import entidades.Formador;
import entidades.Nome_periodo;
import entidades.Periodo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author junito
 */
public class PeriodoDAO {

    private final Connection con;

    public PeriodoDAO() {
        con = new Conexao().conectar();
    }

    public List<Nome_periodo> listaNomePeriodos() throws SQLException {
        List<Nome_periodo> nome_periodos = new ArrayList<Nome_periodo>();
        String sql = "call listar_nomePeriodo";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Nome_periodo np = new Nome_periodo();
            np.setId(res.getInt("id"));
            np.setNome(res.getString("nome"));
            nome_periodos.add(np);
        }
        callableStatement.close();
        return nome_periodos;
    }

    public List<Date> listaDatasPeriodo(Nome_periodo nomep) throws SQLException {
        List<Date> datas = new ArrayList<Date>();
        String sql = "call listar_todasDatasByNomePeriodo(?)";
        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, nomep.getId());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Date d = res.getDate("datainicio");
            datas.add(d);
        }
        callableStatement.close();
        return datas;
    }
    
    public List<Date> listaTodasDatasPeriodo(Nome_periodo nomep) throws SQLException {
        List<Date> datas = new ArrayList<Date>();
        String sql = "call listar_todasDatas(?)";
        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, nomep.getId());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Date d = res.getDate("datainicio");
            datas.add(d);
        }
        callableStatement.close();
        return datas;
    }

    public List<Periodo> listaPeriodo() throws SQLException {
        List<Periodo> periodos = new ArrayList<Periodo>();
        String sql = "call lista_periodo";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();

        while (res.next()) {
            Periodo p = new Periodo();
            Curso c = new CursoServico().ObterCurso(res.getInt("idcurso"));
            p.setCurso(c);
            Nome_periodo np = new PeriodoServico().ObterNomePeriodo(res.getInt("id_nome"));
            p.setNomePeriodo(np);
            p.setDatainicio(res.getDate("datainicio"));
            p.setDatatermino(res.getDate("datafim"));
            Formador f = new FormadorServico().obterFormador(res.getInt("idformador"));
            p.setFormador(f);
            periodos.add(p);
        }
        callableStatement.close();
        return periodos;
    }

    public boolean Exists(Periodo periodo) throws SQLException {
        String sql = "call verificar_periodo(?,?,?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setInt(1, periodo.getCurso().getIdcurso());
        funcao.setInt(2, periodo.getNomePeriodo().getId());
        funcao.setDate(3, new java.sql.Date(periodo.getDatainicio().getTime()));
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }
    
    
    public boolean periodoIsTerminado(Periodo periodo) throws SQLException {
        String sql = "call periodoIsTerminado(?,?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setInt(1, periodo.getNomePeriodo().getId());
        funcao.setDate(2, new java.sql.Date(periodo.getDatainicio().getTime()));
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var2");
        }
        funcao.close();
        return teste;
    }
    
    
    public void salvar(Periodo periodo) throws SQLException {
        String sql = "call inserir_periodo(?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, periodo.getCurso().getIdcurso());
        callableStatement.setInt(2, periodo.getNomePeriodo().getId());
        callableStatement.setDate(3, new java.sql.Date(periodo.getDatainicio().getTime()));
        callableStatement.setInt(4, periodo.getFormador().getIdformador());
        callableStatement.execute();
        callableStatement.close();
    }
    
    public void encerrar(Periodo periodo) throws SQLException{
        String sql="call encerrarPeriodo(?,?)";
        CallableStatement callableStatement=con.prepareCall(sql);
        callableStatement.setInt(1, periodo.getNomePeriodo().getId());
        callableStatement.setDate(2,new java.sql.Date(periodo.getDatainicio().getTime()));
        callableStatement.execute();
        callableStatement.close();
    }

}
