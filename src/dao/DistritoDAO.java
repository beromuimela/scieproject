/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Distrito;
import entidades.Provincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junito
 */
public class DistritoDAO {

    private Connection con;

    public DistritoDAO() {
        con = new Conexao().conectar();
    }

    public List<Distrito> listaDistritos(Provincia p) throws SQLException {
        List<Distrito> distritos = new ArrayList<Distrito>();
        String sql = "call Listar_distitos_por_provincia(?)";

        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, p.getIdprovincia());
        ResultSet res = callableStatement.executeQuery();

        while (res.next()) {
            Distrito d = new Distrito();
            d.setIddistrito(res.getInt("iddistrito"));
            d.setNome(res.getString("nome"));
            d.setProvincia(p);
            distritos.add(d);
        }
        callableStatement.close();
        return distritos;
    }

    public List<Distrito> listaDistritos() throws SQLException {
        List<Distrito> distritos = new ArrayList<Distrito>();
        String sql = "call Listar_distrito";

        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();

        while (res.next()) {
            Distrito d = new Distrito();
            Provincia p = new Provincia();
            d.setIddistrito(res.getInt("iddistrito"));
            d.setNome(res.getString("nome"));
            p.setIdprovincia(res.getInt("idprovincia"));
            d.setProvincia(p);
            distritos.add(d);
        }
        callableStatement.close();
        return distritos;
    }

    public void salvar(Distrito distrito) throws SQLException {
        String sql = "call inserir_distrito(?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);
        callableStatement.setInt(1, distrito.getIddistrito());
        callableStatement.setString(2, distrito.getNome());
        callableStatement.setInt(3, distrito.getProvincia().getIdprovincia());
        callableStatement.execute();
        callableStatement.close();
    }

    public boolean Exists(Distrito distrito) throws SQLException {
        String sql = "call verificar_distrito(?,?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setString(1, distrito.getNome());
        funcao.setInt(2, distrito.getProvincia().getIdprovincia());
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }

    public void delete(Distrito distrito) throws SQLException {
        String sql = "call delete_distrito(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, distrito.getIddistrito());
        callableStatement.execute();
        callableStatement.close();
    }
}
