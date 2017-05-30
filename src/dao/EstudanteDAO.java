/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.Conexao;
import Servico.CandidatoServico;
import Servico.PeriodoServico;
import entidades.Candidato;
import entidades.Distrito;
import entidades.Estudante;
import entidades.Estudante_Pacotes;
import entidades.Nivel_Academico;
import entidades.Nome_periodo;
import entidades.Pacotes;
import entidades.Pais;
import entidades.Periodo;
import entidades.Provincia;
import entidades.Sexo;
import entidades.SitP;
import entidades.Situacao_Profissional;
import entidades.Tipo_Id;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class EstudanteDAO {

    private Connection con;

    public EstudanteDAO() {
        con = new Conexao().conectar();
    }

    public List<Estudante> listarEstudantes(Periodo periodo) throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        String sql = "call listar_estudantesPorPeriodo(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, periodo.getNomePeriodo().getId());
        callableStatement.setDate(2, new java.sql.Date(periodo.getDatainicio().getTime()));
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante e = new Estudante();
            Periodo p = new Periodo();
            p.setDatainicio(res.getDate("datainicio"));
            p.setNomePeriodo(new PeriodoServico().ObterNomePeriodo(res.getInt("id_nome")));
            Candidato candidato = new CandidatoServico().ObterCandidatoEst(res.getInt("idcandidato"));
            e.setCandidato(candidato);
            e.setIdestudante(res.getInt("idestudante"));
            e.setSaldo(res.getFloat("saldo"));
            e.setNotaexame(res.getInt("notaexame"));
            e.setActivo(res.getBoolean("activo"));
            e.setMotivo(res.getString("motivo"));
            e.setTerminouCurso(res.getBoolean("terminouCurso"));
            e.setPeriodo(p);
            estudantes.add(e);
        }
        callableStatement.close();
        return estudantes;
    }

    public List<Estudante> listarDePeriodoDadoPacote(Periodo periodo, Pacotes pacotes) throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        String sql = "call listar_estudantesDePacoteDadoPeriodo(?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, periodo.getNomePeriodo().getId());
        callableStatement.setDate(2, new java.sql.Date(periodo.getDatainicio().getTime()));
        callableStatement.setInt(3, pacotes.getIdpacotes());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante e = new Estudante();
            Periodo p = new Periodo();
            p.setDatainicio(res.getDate("datainicio"));
            p.setNomePeriodo(new PeriodoServico().ObterNomePeriodo(res.getInt("id_nome")));
            Candidato candidato = new CandidatoServico().ObterCandidatoEst(res.getInt("idcandidato"));
            e.setCandidato(candidato);
            e.setIdestudante(res.getInt("idestudante"));
            e.setSaldo(res.getFloat("saldo"));
            e.setNotaexame(res.getInt("notaexame"));
            e.setActivo(res.getBoolean("activo"));
            e.setMotivo(res.getString("motivo"));
            e.setTerminouCurso(res.getBoolean("terminouCurso"));
            e.setPeriodo(p);
            estudantes.add(e);
        }
        callableStatement.close();
        return estudantes;
    }

    public List<Estudante> listarEstudantesActivos() throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        String sql = "call listar_estudantesActivos()";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante e = new Estudante();

            Periodo p = new Periodo();
            p.setDatainicio(res.getDate("datainicio"));

            Nome_periodo np = new Nome_periodo();
            np.setNome(res.getString("nomep"));
            p.setNomePeriodo(np);
            Candidato candidato = new Candidato();
            Tipo_Id id = new Tipo_Id();
            id.setNome(res.getString("doc"));
            candidato.setTipoid(id);
            candidato.setNumerodocumento(res.getString("numerodocumento"));
            candidato.setNome(res.getString("nome"));
            candidato.setApelido(res.getString("apelido"));
            e.setCandidato(candidato);
            e.setIdestudante(res.getInt("idestudante"));
            e.setSaldo(res.getFloat("saldo"));
            e.setNotaexame(res.getInt("notaexame"));
            e.setActivo(res.getBoolean("activo"));
            e.setMotivo(res.getString("motivo"));
            e.setTerminouCurso(res.getBoolean("terminouCurso"));
            e.setPeriodo(p);
            estudantes.add(e);
        }
        callableStatement.close();
        return estudantes;
    }

    public List<Estudante> listarTodosEstudantes() throws SQLException {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        String sql = "call listar_todosEstudantes()";
        CallableStatement callableStatement = con.prepareCall(sql);

        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante e = new Estudante();
            e.setIdestudante(res.getInt("idestudante"));
            e.setSaldo(res.getFloat("saldo"));
            e.setNotaexame(res.getInt("notaexame"));
            e.setActivo(res.getBoolean("activo"));
            e.setMotivo(res.getString("motivo"));
            e.setTerminouCurso(res.getBoolean("terminouCurso"));

            Candidato candidato = new Candidato();
            candidato.setNome(res.getString("nome"));
            candidato.setDatanascimento(res.getDate("datanasc"));
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
            candidato.setFoto(i);
            candidato.setNomepai(res.getString("nomepai"));
            candidato.setNomemae(res.getString("nomemae"));
            candidato.setNumerodocumento(res.getString("numerodocumento"));
            candidato.setDataemissao(res.getDate("dataemissao"));
            candidato.setLocalemissao(res.getString("localemissao"));
            candidato.setMorada(res.getString("morada"));
            candidato.setTelefone(res.getString("telefone"));
            candidato.setEmail(res.getString("email"));
            candidato.setProfissao(res.getString("profissao"));
            candidato.setLocaldetrabalho(res.getString("localtrabalho"));
            candidato.setTelefoneTrabalho(res.getString("telefonetrabalho"));
            candidato.setEmailTrabalho(res.getString("emailtrabalho"));
            candidato.setHabilidades(res.getString("habilidades"));
            candidato.setApelido(res.getString("apelido"));
            candidato.setIsSingular(res.getBoolean("issingular"));
            Periodo p = new Periodo();
            p.setDatainicio(res.getDate("datainicio"));
            Nome_periodo np = new Nome_periodo();
            np.setNome(res.getString("periodo_nome"));
            p.setNomePeriodo(np);
            e.setPeriodo(p);
            Sexo s = new Sexo();
            s.setNome(res.getString("sexo_nome"));
            s.setIdsexo(res.getInt("idsexo"));
            candidato.setSexo(s);
            Distrito d = new Distrito();
            d.setIddistrito(res.getInt("iddistrito"));
            d.setNome(res.getString("distrito_nome"));
            candidato.setDistrito(d);
            Provincia prov = new Provincia();
            prov.setIdprovincia(res.getInt("idprov"));
            prov.setNome(res.getString("provincia_nome"));
            candidato.setProvincia(prov);
            Pais pais = new Pais();
            pais.setIdpais(res.getInt("idp"));
            pais.setNome(res.getString("pais_nome"));
            candidato.setPais(pais);
            Situacao_Profissional sit = new Situacao_Profissional();
            sit.setIdsituacaoprofissional(res.getInt("idsit"));
            sit.setNome(res.getString("sit_nome"));
            candidato.setSituacaoprof(sit);
            SitP sitp = new SitP();
            sitp.setId(res.getInt("idsitP"));
            sitp.setNome(res.getString("nome"));
            candidato.setSitP(sitp);
            Nivel_Academico n = new Nivel_Academico();
            n.setIdnivelacademico(res.getInt("idnivel"));
            n.setNome(res.getString("nivel_nome"));
            candidato.setNivelAcademico(n);
            Tipo_Id id = new Tipo_Id();
            id.setNome(res.getString("nome_id"));
            id.setIdtipo(res.getInt("idtipo"));
            candidato.setTipoid(id);

            e.setCandidato(candidato);

            estudantes.add(e);
        }
        callableStatement.close();
        return estudantes;
    }

    public List<Estudante_Pacotes> listarEstudantesPacotes(List<Estudante> estudantes, Pacotes paco) throws SQLException {
        List<Estudante_Pacotes> estp = new ArrayList<Estudante_Pacotes>();
        String sql = "call listar_estudantePacotes(?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        for (int i = 0; i < estudantes.size(); i++) {
            callableStatement.setInt(1, estudantes.get(i).getIdestudante());
            callableStatement.setInt(2, paco.getIdpacotes());
            ResultSet res = callableStatement.executeQuery();
            while (res.next()) {
                Estudante_Pacotes e = new Estudante_Pacotes();
                Pacotes p = new Pacotes();
                p.setIdpacotes(res.getInt("idpacotes"));
                Estudante est = new Estudante();
                est.setIdestudante(res.getInt("idestudante"));
                Candidato c = new Candidato();
                c.setApelido(res.getString("apelido"));
                c.setNome(res.getString("nome"));
                Sexo s = new Sexo();
                s.setNome(res.getString("sexo"));
                c.setSexo(s);
                est.setCandidato(c);
                e.setPacotes(p);
                e.setEstudante(est);
                e.setData(res.getDate("data"));
                e.setNota(res.getFloat("nota"));
                e.setNumerofaltas(res.getInt("nrdefaltas"));
                estp.add(e);
            }

        }
        callableStatement.close();
        return estp;
    }

    public List<Estudante_Pacotes> listarEstudantesPacotes(Estudante estudantes) throws SQLException {
        List<Estudante_Pacotes> estp = new ArrayList<Estudante_Pacotes>();
        String sql = "call listar_estudantepacotePorestudante(?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setInt(1, estudantes.getIdestudante());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante_Pacotes e = new Estudante_Pacotes();
            Pacotes p = new Pacotes();
            p.setIdpacotes(res.getInt("idpacotes"));
            p.setNome(res.getString("nome"));
            Estudante est = new Estudante();
            est.setIdestudante(res.getInt("idestudante"));
            e.setPacotes(p);
            e.setEstudante(est);
            e.setData(res.getDate("data"));
            e.setNota(res.getFloat("nota"));
            e.setNumerofaltas(res.getInt("nrdefaltas"));
            estp.add(e);
        }
        callableStatement.close();
        return estp;
    }

    public List<Estudante_Pacotes> listarEstudantesPacotes(Periodo p, Pacotes paco) throws SQLException {
        List<Estudante_Pacotes> estp = new ArrayList<Estudante_Pacotes>();
        String sql = "call listar_estudantePacotes2(?,?,?)";
        CallableStatement callableStatement = con.prepareCall(sql);

        callableStatement.setDate(1, new java.sql.Date(p.getDatainicio().getTime()));
        callableStatement.setInt(2, p.getNomePeriodo().getId());
        callableStatement.setInt(3, paco.getIdpacotes());
        ResultSet res = callableStatement.executeQuery();
        while (res.next()) {
            Estudante_Pacotes e = new Estudante_Pacotes();
            Pacotes pa = new Pacotes();
            pa.setIdpacotes(res.getInt("idpacotes"));
            Estudante est = new Estudante();
            est.setIdestudante(res.getInt("idestudante"));
            e.setPacotes(pa);
            e.setData(res.getDate("data"));
            e.setNota(res.getFloat("nota"));
            e.setNumerofaltas(res.getInt("nrdefaltas"));
            Candidato c = new Candidato();
            c.setNome(res.getString("nome"));
            c.setApelido(res.getString("apelido"));
            Sexo s = new Sexo();
            s.setNome(res.getString("sexo"));
            c.setSexo(s);
            est.setCandidato(c);
            e.setEstudante(est);
            estp.add(e);
        }
        callableStatement.close();
        return estp;
    }

    public void inserir_EstudantesPacotes(List<Estudante_Pacotes> estPac, Periodo periodo) throws SQLException {
        String sql = "call inserir_estudantepacote(?,?)";
        String sql2 = "call inserir_periodopacotes(?,?,?)";

        CallableStatement callableStatement = con.prepareCall(sql);
        for (int i = 0; i < estPac.size(); i++) {
            callableStatement.setInt(1, estPac.get(i).getPacotes().getIdpacotes());
            callableStatement.setInt(2, estPac.get(i).getEstudante().getIdestudante());
            callableStatement.execute();
        }
        callableStatement = con.prepareCall(sql2);
        callableStatement.setInt(1, estPac.get(0).getPacotes().getIdpacotes());
        callableStatement.setInt(2, periodo.getNomePeriodo().getId());
        callableStatement.setDate(3, new java.sql.Date(periodo.getDatainicio().getTime()));
        callableStatement.execute();
        callableStatement.close();
    }

    public void updateNotas(List<Estudante_Pacotes> estPac) throws SQLException {
        String sql = "call update_notaestudante(?,?,?)";

        CallableStatement callableStatement = con.prepareCall(sql);
        for (int i = 0; i < estPac.size(); i++) {
            callableStatement.setFloat(1, estPac.get(i).getNota());
            callableStatement.setInt(2, estPac.get(i).getEstudante().getIdestudante());
            callableStatement.setInt(3, estPac.get(i).getPacotes().getIdpacotes());
            callableStatement.execute();
        }
        callableStatement.close();
    }

    public void updateFaltas(List<Estudante_Pacotes> estPac) throws SQLException {
        String sql = "call update_faltaestudantepacote(?,?,?)";

        CallableStatement callableStatement = con.prepareCall(sql);
        for (int i = 0; i < estPac.size(); i++) {
            callableStatement.setInt(1, estPac.get(i).getNumerofaltas());
            callableStatement.setInt(2, estPac.get(i).getEstudante().getIdestudante());
            callableStatement.setInt(3, estPac.get(i).getPacotes().getIdpacotes());
            callableStatement.execute();
        }
        callableStatement.close();
    }
}
