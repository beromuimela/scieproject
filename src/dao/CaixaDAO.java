/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.UtilizadorServico;
import com.toedter.calendar.DateUtil;
import entidades.Caixa;
import entidades.Utilizador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import util.DataUtilizador;

/**
 *
 * @author junito
 */
public class CaixaDAO {

    private Connection con;

    public CaixaDAO() {
        con = new Conexao().conectar();
    }

    public void abrirCaixa(Caixa caixa) throws SQLException {
        String sql = "call abrirCaixa(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setFloat(1, caixa.getAbertura());
        callableStatement.setInt(2, caixa.getUtilizador().getIdutilizador());
        callableStatement.execute();
        callableStatement.close();
    }
    
    public void FecharCaixa(Caixa caixa) throws SQLException {
        String sql = "call closeCaixa(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, caixa.getIdcaixa());
        callableStatement.execute();
        callableStatement.close();
    }

    public List<Caixa> listaCaixas() throws SQLException {
        List<Caixa> caixas = new ArrayList<Caixa>();
        String sql = "call Listar_caixa";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Caixa caixa = new Caixa();

            caixa.setIdcaixa(res.getInt("idcaixa"));
            caixa.setAberto(res.getBoolean("aberto"));
            caixa.setAbertura(res.getFloat("abertura"));
            Utilizador utilizador = new UtilizadorServico().ObterUtilizador(res.getInt("idutilizador"));
            caixa.setUtilizador(utilizador);
            DataUtilizador data=new DataUtilizador();
            data.setAno(res.getInt("ano"));
            data.setDia(res.getInt("dia"));
            data.setHora(res.getInt("hora"));
            data.setMes(res.getInt("mes"));
            data.setMinuto(res.getInt("minuto"));
            data.setSegundos(res.getInt("segundo"));
            caixa.setDatacaixa(data);
            caixas.add(caixa);
        }
        callableStatement.close();
        return caixas;
    }

   
}
