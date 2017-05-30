/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.SexoServico;
import Servico.Tipo_idServico;
import entidades.Candidato;
import entidades.Distrito;
import entidades.Nivel_Academico;
import entidades.Pais;
import entidades.Provincia;
import entidades.Sexo;
import entidades.SitP;
import entidades.Situacao_Profissional;
import entidades.Tipo_Id;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Imagem;

/**
 *
 * @author junito
 */
public class CandidatoDAO {

    private Connection con;

    public CandidatoDAO() {
        con = new Conexao().conectar();
    }

    public void guardarCandidato(Candidato candidato) throws SQLException {
        String sql = "call Inserir_candidato(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setString(1, candidato.getNome());
        callableStatement.setDate(2, new java.sql.Date(candidato.getDatanascimento().getTime()));
//        callableStatement.setString(3, candidato.getFoto().getPath());
        callableStatement.setString(3, candidato.getFoto().getUrl().toString());
        callableStatement.setInt(4, candidato.getSexo().getIdsexo());
        callableStatement.setInt(5, candidato.getDistrito().getIddistrito());
        callableStatement.setInt(6, candidato.getProvincia().getIdprovincia());
        callableStatement.setInt(7, candidato.getPais().getIdpais());
        callableStatement.setString(8, candidato.getNomepai());
        callableStatement.setString(9, candidato.getNomemae());
        callableStatement.setInt(10, candidato.getTipoid().getIdtipo());
        callableStatement.setString(11, candidato.getNumerodocumento());
        callableStatement.setDate(12, new java.sql.Date(candidato.getDataemissao().getTime()));
        callableStatement.setString(13, candidato.getLocalemissao());
        callableStatement.setString(14, candidato.getMorada());
        callableStatement.setString(15, candidato.getTelefone());
        callableStatement.setString(16, candidato.getEmail());
        callableStatement.setInt(17, candidato.getSituacaoprof().getIdsituacaoprofissional());
        callableStatement.setString(18, candidato.getProfissao());
        callableStatement.setString(19, candidato.getLocaldetrabalho());
        callableStatement.setString(20, candidato.getTelefoneTrabalho());
        callableStatement.setString(21, candidato.getEmailTrabalho());
        callableStatement.setString(22, candidato.getHabilidades());
        callableStatement.setInt(23, candidato.getNivelAcademico().getIdnivelacademico());
        callableStatement.setString(24, candidato.getApelido());
        callableStatement.setDate(25, new java.sql.Date(candidato.getDatacadastro().getTime()));
        callableStatement.setString(26, candidato.getFoto().getNomedaimagem());
        callableStatement.setBoolean(27, candidato.isIsSingular());
        callableStatement.setInt(28, candidato.getSitP().getId());

        callableStatement.execute();
        callableStatement.close();
    }

    public void updateCandidato(Candidato candidato) throws SQLException {
        String sql = "call update_candidato(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setString(1, candidato.getNome());
        callableStatement.setDate(2, new java.sql.Date(candidato.getDatanascimento().getTime()));
        callableStatement.setString(3, candidato.getFoto().getUrl().toString());
        callableStatement.setInt(4, candidato.getSexo().getIdsexo());
        callableStatement.setInt(5, candidato.getDistrito().getIddistrito());
        callableStatement.setInt(6, candidato.getProvincia().getIdprovincia());
        callableStatement.setInt(7, candidato.getPais().getIdpais());
        callableStatement.setString(8, candidato.getNomepai());
        callableStatement.setString(9, candidato.getNomemae());
        callableStatement.setInt(10, candidato.getTipoid().getIdtipo());
        callableStatement.setString(11, candidato.getNumerodocumento());
        callableStatement.setDate(12, new java.sql.Date(candidato.getDataemissao().getTime()));
        callableStatement.setString(13, candidato.getLocalemissao());
        callableStatement.setString(14, candidato.getMorada());
        callableStatement.setString(15, candidato.getTelefone());
        callableStatement.setString(16, candidato.getEmail());
        callableStatement.setInt(17, candidato.getSituacaoprof().getIdsituacaoprofissional());
        callableStatement.setString(18, candidato.getProfissao());
        callableStatement.setString(19, candidato.getLocaldetrabalho());
        callableStatement.setString(20, candidato.getTelefoneTrabalho());
        callableStatement.setString(21, candidato.getEmailTrabalho());
        callableStatement.setString(22, candidato.getHabilidades());
        callableStatement.setInt(23, candidato.getNivelAcademico().getIdnivelacademico());
        callableStatement.setString(24, candidato.getApelido());
        callableStatement.setDate(25, new java.sql.Date(candidato.getDatacadastro().getTime()));
        callableStatement.setString(26, candidato.getFoto().getNomedaimagem());
        callableStatement.setInt(27, candidato.getIdcandidato());
        callableStatement.setBoolean(28, candidato.isIsSingular());
        callableStatement.setInt(29, candidato.getSitP().getId());

        callableStatement.execute();
        callableStatement.close();
    }

    public boolean isCadastrado(Candidato candidato) throws SQLException {
        String sql = "call verificarCandidato(?,?,?,?)";

        PreparedStatement funcao = con.prepareCall(sql);
        boolean teste = false;

        funcao.setString(1, candidato.getNome());
        funcao.setString(2, candidato.getApelido());
        funcao.setInt(3, candidato.getTipoid().getIdtipo());
        funcao.setString(4, candidato.getNumerodocumento());
        ResultSet res = funcao.executeQuery();
        while (res.next()) {
            teste = res.getBoolean("var");
        }
        funcao.close();
        return teste;
    }

    public void deleteCandidato(Candidato candidato) throws SQLException {
        String sql = "call delete_candidato(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, candidato.getIdcandidato());
        callableStatement.execute();
        callableStatement.close();
    }

    public List<Candidato> listarCandidatos() throws SQLException {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        String sql = "call Listar_Candidato_excep_Estudantes";

        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Candidato c = new Candidato();
            c.setIdcandidato(res.getInt("idcandidato"));
            c.setDatanascimento(res.getDate("datanasc"));
            c.setProfissao(res.getString("profissao"));
            c.setApelido(res.getString("apelido"));
            c.setDatacadastro(res.getDate("datacadastro"));
            Imagem i = new Imagem();
            i.setPath(res.getString("foto"));
            URL url = null;
            try {
                url = new URL(res.getString("foto"));
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            i.setUrl(url);
            i.setNomedaimagem(res.getString("nomedaimagem"));
            c.setFoto(i);
            Nivel_Academico n = new Nivel_Academico();
            n.setIdnivelacademico(res.getInt("idnivelacademico"));
            c.setNivelAcademico(n);
            c.setHabilidades(res.getString("habilidades"));
            c.setEmailTrabalho(res.getString("emailtrabalho"));
            c.setTelefoneTrabalho(res.getString("telefonetrabalho"));
            c.setLocaldetrabalho(res.getString("localtrabalho"));
            c.setDataemissao(res.getDate("dataemissao"));
            c.setNome(res.getString("nome"));
            Sexo s = new SexoServico().ObterSexo(res.getInt("idsexo"));
            c.setSexo(s);
            Distrito d = new Distrito();
            d.setIddistrito(res.getInt("iddistrito"));
            d.setNome(res.getString("distrito"));
            c.setDistrito(d);
            Pais p = new Pais();
            p.setIdpais(res.getInt("idpais"));
            p.setNome(res.getString("pais"));
            c.setPais(p);
            Provincia prov = new Provincia();
            prov.setIdprovincia(res.getInt("idprovincia"));
            prov.setNome(res.getString("provincia"));
            c.setProvincia(prov);
            Tipo_Id id = new Tipo_idServico().ObterId(res.getInt("idtipo"));
            c.setTipoid(id);
            c.setNumerodocumento(res.getString("numerodocumento"));
            c.setLocalemissao(res.getString("localemissao"));
            c.setMorada(res.getString("morada"));
            Situacao_Profissional sit = new Situacao_Profissional();
            sit.setIdsituacaoprofissional(res.getInt("idsituacaoprofissional"));
            sit.setNome(res.getString("situacao"));
            c.setSituacaoprof(sit);
            SitP sitp=new SitP();
            sitp.setId(res.getInt("idsitP"));
            sitp.setNome(res.getString("nomeSitP"));
            c.setSitP(sitp);
            c.setTelefone(res.getString("telefone"));
            c.setEmail(res.getString("email"));
            c.setIsSingular(res.getBoolean("isSingular"));
            candidatos.add(c);
        }
        callableStatement.close();
        return candidatos;

    }

    public List<Candidato> listarTodosCandidatos() throws SQLException {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        String sql = "call listar_todosCandidatos";

        CallableStatement callableStatement = con.prepareCall(sql);
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Candidato c = new Candidato();
            c.setIdcandidato(res.getInt("idcandidato"));
            c.setDatanascimento(res.getDate("datanasc"));
            c.setProfissao(res.getString("profissao"));
            c.setApelido(res.getString("apelido"));
            c.setDatacadastro(res.getDate("datacadastro"));
            Imagem i = new Imagem();
            i.setPath(res.getString("foto"));
            URL url = null;
            try {
                url = new URL(res.getString("foto"));
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            i.setUrl(url);
            i.setNomedaimagem(res.getString("nomedaimagem"));
            c.setFoto(i);
            Nivel_Academico n = new Nivel_Academico();
            n.setIdnivelacademico(res.getInt("idnivelacademico"));
            c.setNivelAcademico(n);
            c.setHabilidades(res.getString("habilidades"));
            c.setEmailTrabalho(res.getString("emailtrabalho"));
            c.setTelefoneTrabalho(res.getString("telefonetrabalho"));
            c.setLocaldetrabalho(res.getString("localtrabalho"));
            c.setDataemissao(res.getDate("dataemissao"));
            c.setNome(res.getString("nome"));
            Sexo s = new SexoServico().ObterSexo(res.getInt("idsexo"));
            c.setSexo(s);
            Distrito d = new Distrito();
            d.setIddistrito(res.getInt("iddistrito"));
            d.setNome(res.getString("distrito"));
            c.setDistrito(d);
            Pais p = new Pais();
            p.setIdpais(res.getInt("idpais"));
            p.setNome(res.getString("pais"));
            c.setPais(p);
            Provincia prov = new Provincia();
            prov.setIdprovincia(res.getInt("idprovincia"));
            prov.setNome(res.getString("provincia"));
            c.setProvincia(prov);
            Tipo_Id id = new Tipo_idServico().ObterId(res.getInt("idtipo"));
            c.setTipoid(id);
            c.setNumerodocumento(res.getString("numerodocumento"));
            c.setLocalemissao(res.getString("localemissao"));
            c.setMorada(res.getString("morada"));
            Situacao_Profissional sit = new Situacao_Profissional();
            sit.setIdsituacaoprofissional(res.getInt("idsituacaoprofissional"));
            sit.setNome(res.getString("situacao"));
            c.setSituacaoprof(sit);
            SitP sitp=new SitP();
            sitp.setId(res.getInt("idsitP"));
            sitp.setNome(res.getString("nomeSit"));
            c.setSitP(sitp);
            c.setTelefone(res.getString("telefone"));
            c.setEmail(res.getString("email"));
            c.setIsSingular(res.getBoolean("isSingular"));
            candidatos.add(c);
        }
        callableStatement.close();
        return candidatos;
    }
   
}
