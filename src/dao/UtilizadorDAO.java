/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import java.sql.CallableStatement;
import java.sql.Connection;
import entidades.Utilizador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junito
 */
public class UtilizadorDAO {

    private Connection con;

    public UtilizadorDAO() {
        con = new Conexao().conectar();
    }

    public boolean verificarUtilizador(Utilizador util) throws SQLException {
        String sql = "call verificar_utilizador(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setString(1, util.getLogin());
        callableStatement.setString(2, util.getSenha());
        ResultSet res = callableStatement.executeQuery();

        boolean teste = false;
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        callableStatement.close();
        return teste;
    }

    public boolean verificarUtil(Utilizador util) throws SQLException {
        String sql = "call verificar_util(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setString(1, util.getLogin());
        callableStatement.setString(2, util.getNome());
        ResultSet res = callableStatement.executeQuery();

        boolean teste = false;
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        callableStatement.close();
        return teste;
    }

    public List<Utilizador> listarUtilizadoresActivos() throws SQLException {
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();
        String sql = "call Listar_utilizador";
        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Utilizador util = new Utilizador();
            util.setIdutilizador(res.getInt("idutilizador"));
            util.setNome(res.getString("nome"));
            util.setSenha(res.getString("senha"));
            util.setLogin(res.getString("login"));
            util.setIsdesactivado(res.getBoolean("desactivado"));
            util.setAcessoRetirarValor(res.getBoolean("acessoRetirarValor"));
            util.setAcessoCandidato(res.getBoolean("acessoCandidato"));
            util.setAcessoAberturaCaixa(res.getBoolean("acessoAberturaCaixa"));
            util.setAcessoAvancado(res.getBoolean("acessoAvancado"));
            util.setAcessoCaulas(res.getBoolean("acessoCaulas"));
            util.setAcessoCcandidato(res.getBoolean("acessoCcandidato"));
            util.setAcessoCestudante(res.getBoolean("acessoCestudante"));
            util.setAcessoCfaltas(res.getBoolean("acessoCfaltas"));
            util.setAcessoCformadores(res.getBoolean("acessoCformadores"));
            util.setAcessoCnotas(res.getBoolean("acessoCnotas"));
            util.setAcessoCperiodo(res.getBoolean("acessoCperiodo"));
            util.setAcessoCurso(res.getBoolean("acessoCurso"));
            util.setAcessoCutilizadores(res.getBoolean("acessoCutilizadores"));
            util.setAcessoEfectuarPagamento(res.getBoolean("acessoPagamento"));
            util.setAcessoFormadores(res.getBoolean("acessoFormadores"));
            util.setAcessoInscricao(res.getBoolean("acessoInscricao"));
            util.setAcessoLocalizacao(res.getBoolean("acessoLocalizacao"));
            util.setAcessoMovimentoCaixa(res.getBoolean("acessoMovimentoCaixa"));
            util.setAcessoPeriodo(res.getBoolean("acessoPeriodo"));
            util.setAcessoRelatorioHonorario(res.getBoolean("acessoRelatorioHonorario"));
            util.setAcessoRelatorioInscricoes(res.getBoolean("acessoRelatorioInscricoes"));
            util.setAcessoRegistarUtilizador(res.getBoolean("acessoUtilizador"));
            util.setAcessoFechocaixa(res.getBoolean("acessoFechoCaixa"));
            utilizadores.add(util);
        }
        callableStatement.close();
        return utilizadores;
    }

    public List<Utilizador> listarTodosUtilizadores() throws SQLException {
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();
        String sql = "call listar_todosutilizadores";
        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Utilizador util = new Utilizador();
            util.setIdutilizador(res.getInt("idutilizador"));
            util.setNome(res.getString("nome"));
            util.setSenha(res.getString("senha"));
            util.setLogin(res.getString("login"));
            util.setAcessoRetirarValor(res.getBoolean("acessoRetirarValor"));
            util.setIsdesactivado(res.getBoolean("desactivado"));
            util.setAcessoCandidato(res.getBoolean("acessoCandidato"));
            util.setAcessoAberturaCaixa(res.getBoolean("acessoAberturaCaixa"));
            util.setAcessoAvancado(res.getBoolean("acessoAvancado"));
            util.setAcessoCaulas(res.getBoolean("acessoCaulas"));
            util.setAcessoCcandidato(res.getBoolean("acessoCcandidato"));
            util.setAcessoCestudante(res.getBoolean("acessoCestudante"));
            util.setAcessoCfaltas(res.getBoolean("acessoCfaltas"));
            util.setAcessoCformadores(res.getBoolean("acessoCformadores"));
            util.setAcessoCnotas(res.getBoolean("acessoCnotas"));
            util.setAcessoCperiodo(res.getBoolean("acessoCperiodo"));
            util.setAcessoCurso(res.getBoolean("acessoCurso"));
            util.setAcessoCutilizadores(res.getBoolean("acessoCutilizadores"));
            util.setAcessoEfectuarPagamento(res.getBoolean("acessoPagamento"));
            util.setAcessoFormadores(res.getBoolean("acessoFormadores"));
            util.setAcessoInscricao(res.getBoolean("acessoInscricao"));
            util.setAcessoLocalizacao(res.getBoolean("acessoLocalizacao"));
            util.setAcessoMovimentoCaixa(res.getBoolean("acessoMovimentoCaixa"));
            util.setAcessoPeriodo(res.getBoolean("acessoPeriodo"));
            util.setAcessoRelatorioHonorario(res.getBoolean("acessoRelatorioHonorario"));
            util.setAcessoRelatorioInscricoes(res.getBoolean("acessoRelatorioInscricoes"));
            util.setAcessoRegistarUtilizador(res.getBoolean("acessoUtilizador"));
            util.setAcessoFechocaixa(res.getBoolean("acessoFechoCaixa"));
            utilizadores.add(util);
        }
        callableStatement.close();
        return utilizadores;
    }

    public void salvar(Utilizador util) throws SQLException {
        String sql = "call inserir_utilizador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setString(1, util.getNome());
        callableStatement.setString(2, util.getSenha());
        callableStatement.setString(3, util.getLogin());
        callableStatement.setBoolean(4, util.isIsdesactivado());
        callableStatement.setBoolean(5, util.isAcessoCandidato());
        callableStatement.setBoolean(6, util.isAcessoAberturaCaixa());
        callableStatement.setBoolean(7, util.isAcessoAvancado());
        callableStatement.setBoolean(8, util.isAcessoCaulas());
        callableStatement.setBoolean(9, util.isAcessoCcandidato());
        callableStatement.setBoolean(10, util.isAcessoCestudante());
        callableStatement.setBoolean(11, util.isAcessoCfaltas());
        callableStatement.setBoolean(12, util.isAcessoCformadores());
        callableStatement.setBoolean(13, util.isAcessoCnotas());
        callableStatement.setBoolean(14, util.isAcessoCperiodo());
        callableStatement.setBoolean(15, util.isAcessoCurso());
        callableStatement.setBoolean(16, util.isAcessoCutilizadores());
        callableStatement.setBoolean(17, util.isAcessoEfectuarPagamento());
        callableStatement.setBoolean(18, util.isAcessoFormadores());
        callableStatement.setBoolean(19, util.isAcessoInscricao());
        callableStatement.setBoolean(20, util.isAcessoLocalizacao());
        callableStatement.setBoolean(21, util.isAcessoMovimentoCaixa());
        callableStatement.setBoolean(22, util.isAcessoPeriodo());
        callableStatement.setBoolean(23, util.isAcessoRelatorioHonorario());
        callableStatement.setBoolean(24, util.isAcessoRegistarUtilizador());
        callableStatement.setBoolean(25, util.isAcessoRetirarValor());
        callableStatement.setBoolean(26, util.isAcessoRelatorioInscricoes());
        callableStatement.setBoolean(27, util.isAcessoFechocaixa());

        callableStatement.execute();
        callableStatement.close();
    }

    public void editar(Utilizador util) throws SQLException {
        String sql = "call update_utilizador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, util.getIdutilizador());
        callableStatement.setString(2, util.getNome());
        callableStatement.setString(3, util.getSenha());
        callableStatement.setString(4, util.getLogin());
        callableStatement.setBoolean(5, util.isIsdesactivado());
        callableStatement.setBoolean(6, util.isAcessoCandidato());
        callableStatement.setBoolean(7, util.isAcessoAberturaCaixa());
        callableStatement.setBoolean(8, util.isAcessoAvancado());
        callableStatement.setBoolean(9, util.isAcessoCaulas());
        callableStatement.setBoolean(10, util.isAcessoCcandidato());
        callableStatement.setBoolean(11, util.isAcessoCestudante());
        callableStatement.setBoolean(12, util.isAcessoCfaltas());
        callableStatement.setBoolean(13, util.isAcessoCformadores());
        callableStatement.setBoolean(14, util.isAcessoCnotas());
        callableStatement.setBoolean(15, util.isAcessoCperiodo());
        callableStatement.setBoolean(16, util.isAcessoCurso());
        callableStatement.setBoolean(17, util.isAcessoCutilizadores());
        callableStatement.setBoolean(18, util.isAcessoEfectuarPagamento());
        callableStatement.setBoolean(19, util.isAcessoFormadores());
        callableStatement.setBoolean(20, util.isAcessoInscricao());
        callableStatement.setBoolean(21, util.isAcessoLocalizacao());
        callableStatement.setBoolean(22, util.isAcessoMovimentoCaixa());
        callableStatement.setBoolean(23, util.isAcessoPeriodo());
        callableStatement.setBoolean(24, util.isAcessoRelatorioHonorario());
        callableStatement.setBoolean(25, util.isAcessoRegistarUtilizador());
        callableStatement.setBoolean(26, util.isAcessoRetirarValor());
        callableStatement.setBoolean(27, util.isAcessoRelatorioInscricoes());
        callableStatement.setBoolean(28, util.isAcessoFechocaixa());

        callableStatement.executeUpdate();
        callableStatement.close();
    }

    public void Desabilitar(Utilizador util) throws SQLException {
        String sql = "call desactivar_utilizador(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, util.getIdutilizador());
        callableStatement.execute();
        callableStatement.close();
    }
}
