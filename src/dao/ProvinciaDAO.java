/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Pais;
import entidades.Provincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junito
 */
public class ProvinciaDAO {

    private Connection con;

    public ProvinciaDAO() {
        con = new Conexao().conectar();
    }
    
    public List<Provincia> listaProvincias(Pais p) throws SQLException{
        List<Provincia> provincias=new ArrayList<Provincia>();
        String sql="call Listar_prov_por_Pais(?)";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        callableStatement.setInt(1,p.getIdpais());
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Provincia prov=new Provincia();
            prov.setIdprovincia(res.getInt("idprovincia"));
            prov.setNome(res.getString("nome"));
            prov.setPais(p);
            provincias.add(prov);
        }
        callableStatement.close();
        return provincias;
    }
    
    public List<Provincia> listaProvincias() throws SQLException{
        List<Provincia> provincias=new ArrayList<Provincia>();
        String sql="call Listar_provincia";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Provincia prov=new Provincia();
            Pais p=new Pais();
            prov.setIdprovincia(res.getInt("idprovincia"));
            prov.setNome(res.getString("nome"));
            p.setIdpais(res.getInt("idpais"));
            prov.setPais(p);
            provincias.add(prov);
        }
        callableStatement.close();
        return provincias;
    }
    
   public void salvar(Provincia provincia) throws SQLException{
       String sql="call inserir_provincia(?,?,?)";
       CallableStatement callableStatement=con.prepareCall(sql);
       
       callableStatement.setInt(1, provincia.getIdprovincia());
       callableStatement.setString(2, provincia.getNome());
       callableStatement.setInt(3, provincia.getPais().getIdpais());
       callableStatement.execute();
       callableStatement.close();
   }
   
   public boolean Exists(Provincia provincia) throws SQLException {
        String sql = "call verificar_provincia(?,?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setString(1, provincia.getNome());
        funcao.setInt(2, provincia.getPais().getIdpais());
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }

   public void delete(Provincia provincia) throws SQLException{
       String sql="call delete_provincia(?)";
       CallableStatement callableStatement=con.prepareCall(sql);
       
       callableStatement.setInt(1, provincia.getIdprovincia());
       callableStatement.execute();
       callableStatement.close();
   }
}
