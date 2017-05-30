/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class Conexao {

    private Connection con = null;

    public Connection conectar(String usuario,String senha) {
        try {
            String url = "jdbc:mysql://localhost/scie";
            
//            String dbUrl = "jdbc:mysql://LUCINDA:3306/scie?user=root&password=root";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public Connection conectar() {
        try {
//            String dbUrl = "jdbc:mysql://localhost:3306/scie?user=root&password=root";
            String dbUrl = "jdbc:mysql://LUCINDA-PC:3306/scie?user=root&password=root";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void encerrarSessao() {
        try {
            con.commit();
            con.close();
            con = null;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            con = null;
        }

    }

}
