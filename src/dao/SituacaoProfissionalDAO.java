/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.SitP;
import entidades.Situacao_Profissional;
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
public class SituacaoProfissionalDAO {
    private Connection con;

    public SituacaoProfissionalDAO() {
        con=new Conexao().conectar();
    }
    
    public List<Situacao_Profissional> listaSituacaoProf() throws SQLException{
        List<Situacao_Profissional> situacp=new ArrayList<Situacao_Profissional>();
        String sql="call Listar_SituacaoProf";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Situacao_Profissional s=new Situacao_Profissional();
            s.setIdsituacaoprofissional(res.getInt("idsituacaoprofissional"));
            s.setNome(res.getString("nome"));
            situacp.add(s);
        }
        callableStatement.close();
        return situacp;
    }
    
    public List<SitP> listaSitP() throws SQLException{
        List<SitP> situacp=new ArrayList<SitP>();
        String sql="call ListarSitP";
        
        CallableStatement callableStatement=con.prepareCall(sql);
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            SitP s=new SitP();
            s.setId(res.getInt("idsitP"));
            s.setNome(res.getString("nome"));
            situacp.add(s);
        }
        callableStatement.close();
        return situacp;
    }
    
    
}
