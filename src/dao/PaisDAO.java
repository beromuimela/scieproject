/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Candidato;
import entidades.Pais;
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
public class PaisDAO {

    private Connection con;

    public PaisDAO() {
        con = new Conexao().conectar();
    }
    
    public List<Pais> listaPaises() throws SQLException{
        List<Pais> paises =new ArrayList<Pais>();
        String sql="call Listar_pais";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Pais p=new Pais();
            p.setIdpais(res.getInt("idpais"));
            p.setNome(res.getString("nome"));
            paises.add(p);
        }
        callableStatement.close();
        return paises;
    }
    
    public void salvar(Pais pais) throws SQLException{
        String sql="call inserir_pais(?,?)";
        CallableStatement callableStatement=con.prepareCall(sql);
        
        callableStatement.setInt(1, pais.getIdpais());
        callableStatement.setString(2, pais.getNome());
        callableStatement.execute();
        callableStatement.close();
    }
    
    public boolean Exists(Pais pais) throws SQLException {
        String sql = "call verificar_pais(?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setString(1, pais.getNome());
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }

    public void delete(Pais p) throws SQLException{
       String sql="call delete_pais(?)";
       CallableStatement callableStatement=con.prepareCall(sql);
       
       callableStatement.setInt(1, p.getIdpais());
       callableStatement.execute();
       callableStatement.close();
   }

}
