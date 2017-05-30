/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.CaixaServico;
import Servico.UtilizadorServico;
import entidades.Caixa;
import entidades.Movimentos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.DataUtilizador;

/**
 *
 * @author junito
 */
public class MovimentosDAO {

    private Connection con;

    public MovimentosDAO() {
        con = new Conexao().conectar();
    }

    public List<Movimentos> listaTodosMovimentos() throws SQLException {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        String sql = "call lista_todosMovimentos";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Movimentos mov = new Movimentos();
            DataUtilizador data = new DataUtilizador();
            data.setAno(res.getInt("anomovimento"));
            data.setMes(res.getInt("mesmovimento"));
            data.setDia(res.getInt("diamovimento"));
            data.setHora(res.getInt("horamovimento"));
            data.setMinuto(res.getInt("minutomovimento"));
            data.setSegundos(res.getInt("segundomovimento"));
            mov.setDatamovimento(data);
            mov.setTipoMovimento(res.getString("tipoMovimento"));
            mov.setValor(res.getFloat("valor"));
            mov.setResponsavel(res.getString("responsavel"));
            mov.setHistorico(res.getString("historico"));
            mov.setUtilizador(new UtilizadorServico().ObterUtilizador(res.getInt("idutilizador")));
            movimentos.add(mov);

        }
        callableStatement.close();
        return movimentos;

    }

    public List<Movimentos> listaMovimentosPorCaixa(Caixa caixa) throws SQLException {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        String sql = "call list_movimentoPorCaixa(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, caixa.getIdcaixa());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Movimentos mov = new Movimentos();
            DataUtilizador data = new DataUtilizador();
            data.setAno(res.getInt("anomovimento"));
            data.setMes(res.getInt("mesmovimento"));
            data.setDia(res.getInt("diamovimento"));
            data.setHora(res.getInt("horamovimento"));
            data.setMinuto(res.getInt("minutomovimento"));
            data.setSegundos(res.getInt("segundomovimento"));
            mov.setDatamovimento(data);
            mov.setTipoMovimento(res.getString("tipoMovimento"));
            mov.setValor(res.getFloat("valor"));
            mov.setResponsavel(res.getString("responsavel"));
            mov.setHistorico(res.getString("historico"));
            mov.setUtilizador(new UtilizadorServico().ObterUtilizador(res.getInt("idutilizador")));
            movimentos.add(mov);

        }
        callableStatement.close();
        return movimentos;

    }
    public void inserirMovimento(Movimentos mov) throws SQLException {
        Caixa caixa=new CaixaServico().ultimoCaixa();
        String sql = "call inseir_movimento(?,?,?,?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, mov.getUtilizador().getIdutilizador());
        callableStatement.setString(2, mov.getResponsavel());
        callableStatement.setString(3, mov.getTipoMovimento());
        callableStatement.setFloat(4, mov.getValor());
        callableStatement.setString(5, mov.getHistorico());
        callableStatement.setInt(6, caixa.getIdcaixa());
        callableStatement.setInt(7, mov.getT());
        callableStatement.execute();
        callableStatement.close();
    }

}
