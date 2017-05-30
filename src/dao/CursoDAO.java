/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import entidades.Curso;
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
public class CursoDAO {

    private Connection con;

    public CursoDAO() {
        con = new Conexao().conectar();
    }

    public List<Curso> listaCursos() throws SQLException {
        List<Curso> cursos = new ArrayList<Curso>();
        String sql = "call listar_curso";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Curso c = new Curso();
            c.setIdcurso(res.getInt("id"));
            c.setNome(res.getString("nome"));
            c.setPrecoEmp(res.getFloat("precoEmp"));
            c.setPreco(res.getFloat("preco"));
            c.setNrestudantesSala(res.getInt("nrest_sala"));
            c.setNrFaltas(res.getInt("nrdfaltas"));
            cursos.add(c);
        }
        callableStatement.close();
        return cursos;
    }

    public void updateCurso(Curso c) throws SQLException{
        String sql = "call update_curso(?,?,?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, c.getNrFaltas());
        callableStatement.setInt(2, c.getNrestudantesSala());
        callableStatement.setFloat(3, c.getPreco());
        callableStatement.setFloat(4, c.getPrecoEmp());
        callableStatement.setInt(5, 1);
        callableStatement.execute();
        callableStatement.close();

    }

}
