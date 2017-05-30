/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.SexoServico;
import entidades.Formador;
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
public class FormadorDAO {
    private Connection con;

    public FormadorDAO() {
        this.con = new Conexao().conectar();
    }
    
    public void salvar(Formador formador) throws SQLException{
        String sql="call inserir_formador(?,?,?,?,?,?,?)";
        CallableStatement callableStatement=con.prepareCall(sql);

        callableStatement.setDate(1,new java.sql.Date(formador.getDatacadastro().getTime()));
        callableStatement.setDate(2,new java.sql.Date(formador.getDatanascimento().getTime()));
        callableStatement.setString(3,formador.getEmail());
        callableStatement.setInt(4, formador.getSexo().getIdsexo());
        callableStatement.setString(5, formador.getMorada());
        callableStatement.setString(6, formador.getNome());
        callableStatement.setString(7, formador.getTelefone());
        
        callableStatement.execute();
        callableStatement.close();
    }
    
    public void actualizar(Formador formador) throws SQLException{
        String sql="call update_formador(?,?,?,?,?,?,?)";
        CallableStatement callableStatement=con.prepareCall(sql);
        
                
        callableStatement.setDate(1,new java.sql.Date(formador.getDatanascimento().getTime()));
        callableStatement.setString(2,formador.getEmail());
        callableStatement.setInt(3, formador.getSexo().getIdsexo());
        callableStatement.setString(4, formador.getMorada());
        callableStatement.setString(5, formador.getNome());
        callableStatement.setString(6, formador.getTelefone());
        callableStatement.setInt(7, formador.getIdformador());
        
        callableStatement.execute();
        callableStatement.close();
    }
    
    public List<Formador> listarFormadores() throws SQLException{
        String sql="call listar_formadores";
        List<Formador> formadores=new ArrayList<Formador>();
        CallableStatement callableStatement=con.prepareCall(sql);
        
        ResultSet res=callableStatement.executeQuery();
        while(res.next()){
            Formador f=new Formador();
            f.setDatacadastro(res.getDate("datacadastro"));
            f.setDatanascimento(res.getDate("datanascimento"));
            f.setEmail(res.getString("email"));
            f.setIdformador(res.getInt("idformador"));
            f.setMorada(res.getString("morada"));
            f.setNome(res.getString("nome"));
            f.setSexo(new SexoServico().ObterSexo(res.getInt("idsexo")));
            f.setTelefone(res.getString("telefone"));
            formadores.add(f);
        }
        callableStatement.close();
        return formadores;
    }
    
     public boolean Exists(Formador formador) throws SQLException {
        String sql = "call verificar_formador(?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setString(1, formador.getNome());
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }
}
