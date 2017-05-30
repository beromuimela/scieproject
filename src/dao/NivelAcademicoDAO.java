/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Nivel_Academico;
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
public class NivelAcademicoDAO {
    private Connection con;

    public NivelAcademicoDAO() {
        con=new Conexao().conectar();
    }
    
    public List<Nivel_Academico> listaNivelAcademico() throws SQLException{
        List<Nivel_Academico> nivel=new ArrayList<Nivel_Academico>();
        String sql="call Listar_nivelAcademico";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Nivel_Academico n=new Nivel_Academico();
            n.setIdnivelacademico(res.getInt("idnivelacademico"));
            n.setNome(res.getString("nome"));
            nivel.add(n);
        }
        callableStatement.close();
        return nivel;
    }
    
    
    
}
