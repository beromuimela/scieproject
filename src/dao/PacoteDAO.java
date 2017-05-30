/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Pacotes;
import entidades.Periodo;
import entidades.Periodo_Pacotes;
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
public class PacoteDAO {
    private final Connection con;

    public PacoteDAO() {
        con = new Conexao().conectar();
    }
    
    public List<Pacotes> listaPacotes() throws SQLException{
        List<Pacotes> pacotes=new ArrayList<Pacotes>();
        String sql="call listar_pacotes";
        CallableStatement callableStatement=con.prepareCall(sql);
        
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Pacotes p=new Pacotes();
            p.setIdpacotes(res.getInt("idpacotes"));
            p.setNome(res.getString("nome"));
            pacotes.add(p);
        }
        callableStatement.close();
        return pacotes;
    }
    
    public boolean verificarPeriodoPacotes(Periodo p,Pacotes paco) throws SQLException{
        String sql="call verificar_periodoPacotes(?,?,?)";
        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setInt(1, paco.getIdpacotes());
        funcao.setInt(2, p.getNomePeriodo().getId());
        funcao.setDate(3, new java.sql.Date(p.getDatainicio().getTime()));
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }
    
}
