/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Tipo_Id;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junito
 */
public class Tipo_IdDAO {
    private Connection con;

    public Tipo_IdDAO() {
        con = new Conexao().conectar();
    }
    
    
    public List<Tipo_Id> listaTipoId() throws SQLException{
        List<Tipo_Id> doc=new ArrayList<Tipo_Id>();
        String sql="call Listar_tipoId";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        
        while(res.next()){
            Tipo_Id id=new Tipo_Id();
            id.setIdtipo(res.getInt("idtipo"));
            id.setNome(res.getString("nome"));
            doc.add(id);
        }
        callableStatement.close();
        return doc;
    }
 /*
        Main para testes
    */
    public static void main(String[] args) throws SQLException {
        Tipo_IdDAO s=new Tipo_IdDAO();
        List<Tipo_Id> sexo=s.listaTipoId();
        
        if(sexo!=null){
            for(int i=0;i<sexo.size();i++){
                System.out.println(sexo.get(i).getIdtipo());
                System.out.println(sexo.get(i).getNome());
            }
        }
    }    
}
