/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Sexo;
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
public class SexoDAO {

    private Connection con;

    public SexoDAO() {
        con = new Conexao().conectar();
    }

    public List<Sexo> ListaSexo() throws SQLException {
        List<Sexo> sexo = new ArrayList<Sexo>();
        String sql = "call Listar_Sexo";

        try (CallableStatement callableStatement = con.prepareCall(sql)) {
            ResultSet res = callableStatement.executeQuery();

            while (res.next()) {
                Sexo s = new Sexo();
                s.setIdsexo(res.getInt("idsexo"));
                s.setNome(res.getString("nome"));
                sexo.add(s);
            }
            callableStatement.close();
        }
        return sexo;
    }
    
    /*
        Main para testes
    */
    public static void main(String[] args) throws SQLException {
        SexoDAO s=new SexoDAO();
        List<Sexo> sexo=s.ListaSexo();
        
        if(sexo!=null){
            for(int i=0;i<sexo.size();i++){
                System.out.println(sexo.get(i).getIdsexo());
                System.out.println(sexo.get(i).getNome());
            }
        }
    }

}
