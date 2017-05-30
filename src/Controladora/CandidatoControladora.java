/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CandidatoServico;
import Servico.DistritoServico;
import Servico.NivelAcademicoServico;
import Servico.PaisServico;
import Servico.ProvinciaServico;
import Servico.SexoServico;
import Servico.SituacaoProfServico;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import util.Imagem;
import vista.NovoCandidato;

/**
 *
 * @author junito
 */
public final class CandidatoControladora implements ActionListener, ItemListener {

    private final NovoCandidato form;
    private Pais pais;
    private Imagem foto = new Imagem();
    private Provincia provincia;
    private Distrito distrito;
    private Situacao_Profissional situacao;
    private SitP sitp ;
    private Nivel_Academico nivelAcademico;
    private Tipo_Id tipoId;
    private Sexo sexo;
    private final DefaultComboBoxModel sexoModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel IdModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel nivelModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel situacaoModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel sitPModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel paisModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel provinciaModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel distritoModel = new DefaultComboBoxModel();
    private CandidatoServico servico = new CandidatoServico();

    public CandidatoControladora(NovoCandidato form) {
        this.form = form;
        this.pais = new Pais();
        this.sexo = new Sexo();
        this.provincia = new Provincia();
        this.distrito = new Distrito();
        this.nivelAcademico = new Nivel_Academico();
        this.tipoId = new Tipo_Id();
        this.situacao = new Situacao_Profissional();
        this.sitp=new SitP();
        adicionarListener();
        mostrarImagem();
        adicionaSexo();
        adicionaId();
        adicionaNivel();
        adicionaSituacaoP();
        adicionaSitP();
        adicionaPais();
    }

    public void mostrarImagem() {
        try {
            foto.mostrarImagem(form.getFotoJPanel(), form.getFoto());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void adicionaSexo() {
        List<Sexo> sexos = new Servico.SexoServico().listaDeSexo();
        if (sexos != null) {
            for (int i = 0; i < sexos.size(); i++) {
                sexoModel.insertElementAt(sexos.get(i).getNome(), i);
            }
            form.getSexo().setModel(sexoModel);
            form.getSexo().setSelectedIndex(0);
        } else {
            form.getSexo().setModel(sexoModel);
        }
    }

    public void adicionaId() {
        List<Tipo_Id> id = new Tipo_idServico().listaID();
        if (id != null) {
            for (int i = 0; i < id.size(); i++) {
                IdModel.insertElementAt(id.get(i).getNome(), i);
            }
            form.getDocumento().setModel(IdModel);
            form.getDocumento().setSelectedIndex(0);
        } else {
            form.getDocumento().setModel(IdModel);
        }
    }

    public void adicionaNivel() {
        List<Nivel_Academico> nivel = new NivelAcademicoServico().listaNivelAcademico();
        if (nivel != null) {
            for (int i = 0; i < nivel.size(); i++) {
                nivelModel.insertElementAt(nivel.get(i).getNome(), i);
            }
            form.getNivelAcademico().setModel(nivelModel);
            form.getNivelAcademico().setSelectedIndex(0);
        } else {
            form.getNivelAcademico().setModel(nivelModel);
        }
    }

    public void adicionaSituacaoP() {
        List<Situacao_Profissional> situacaop = new SituacaoProfServico().listaSituacaoP();
        if (situacaop != null) {
            for (int i = 0; i < situacaop.size(); i++) {
                situacaoModel.insertElementAt(situacaop.get(i).getNome(), i);
            }
            form.getSituacaoProfissional().setModel(situacaoModel);
            form.getSituacaoProfissional().setSelectedIndex(0);
        } else {
            form.getSituacaoProfissional().setModel(situacaoModel);
        }
    }
    
    public void adicionaSitP() {
        List<SitP> sitprofissional = new SituacaoProfServico().listaSitP();
        if (sitprofissional != null) {
            for (int i = 0; i < sitprofissional.size(); i++) {
                sitPModel.insertElementAt(sitprofissional.get(i).getNome(), i);
            }
            form.getSProfissional().setModel(sitPModel);
            form.getSProfissional().setSelectedIndex(0);
        } else {
            form.getSProfissional().setModel(sitPModel);
        }
    }

    public void adicionaProvincia(Pais p) {

        List<Provincia> provincias = new ProvinciaServico().listaProvincias(p);
        if (!provincias.isEmpty()) {
            provinciaModel = new DefaultComboBoxModel();
            for (int i = 0; i < provincias.size(); i++) {
                provinciaModel.insertElementAt(provincias.get(i).getNome(), i);
            }
            form.getProvincia().setModel(provinciaModel);
            form.getProvincia().setSelectedIndex(0);
        } else {
            //  provinciaModel = new DefaultComboBoxModel();

            form.getProvincia().setModel(new DefaultComboBoxModel());
            provincia = null;
        }
    }

    public void adicionaDistrito(Provincia p) {
        List<Distrito> distritos = new DistritoServico().listaDistritos(p);
        if (!distritos.isEmpty()) {
            distritoModel = new DefaultComboBoxModel();
            for (int i = 0; i < distritos.size(); i++) {
                distritoModel.insertElementAt(distritos.get(i).getNome(), i);
            }
            form.getDistrito().setModel(distritoModel);
            form.getDistrito().setSelectedIndex(0);
        } else {
            // distritoModel = new DefaultComboBoxModel();
            form.getDistrito().setModel(new DefaultComboBoxModel());
            distrito = null;
        }
    }

    public void adicionaPais() {
        List<Pais> paises = new PaisServico().listadPaises();
        if (paises != null) {
            paisModel = new DefaultComboBoxModel();
            for (int i = 0; i < paises.size(); i++) {
                paisModel.insertElementAt(paises.get(i).getNome(), i);
            }
            form.getPais().setModel(paisModel);
            form.getPais().setSelectedIndex(0);
        } else {
            form.getPais().setModel(paisModel);
        }
    }

    public void limparCampos() {
        form.getNome().setText("");
        form.getApelido().setText("");
//        form.getDataNascimento().setSelectedDate(Calendar.getInstance()); 
        form.getDataNascimento().setDate(null);
        form.getNrDocumento().setText("");
        form.getLocalEmissao().setText("");
        form.getLocalTrabalho().setText("");
        form.getDataEmissao().setDate(null);
        form.getNomePai().setText("");
        form.getNomeMae().setText("");
        form.getProfissao().setText("");
        form.getTelefone().setText("");
        form.getTelefoneTrabalho().setText("");
        form.getEmail().setText("");
        form.getEmailTrabalho().setText("");
        form.getHabilidades().setText("");
        adicionaPais();
        adicionaProvincia(pais);
        adicionaId();
        adicionaNivel();
        adicionaSexo();
        adicionaSituacaoP();
        foto = new Imagem();
        mostrarImagem();
    }
/*
    public void desabilitaCampos(Situacao_Profissional s) {
        if (form.getSituacaoProfissional().getSelectedIndex() == 0) {
            form.getProfissao().setEnabled(false);
            form.getLocalTrabalho().setEnabled(false);
            form.getTelefoneTrabalho().setEnabled(false);
            form.getEmailTrabalho().setEnabled(false);
        } else {
            form.getProfissao().setEnabled(true);
            form.getLocalTrabalho().setEnabled(true);
            form.getTelefoneTrabalho().setEnabled(true);
            form.getEmailTrabalho().setEnabled(true);
        }

    }
*/
    public Candidato formParaCandidato() {
        Candidato cand = new Candidato();
        if (form.getNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getApelido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o apelido!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getDataNascimento().getDate() == null) {
            JOptionPane.showMessageDialog(form, "Informe a data de nascimento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getNrDocumento().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o numero do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getLocalEmissao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o local de emissao do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getDataEmissao().getDate() == null) {
            JOptionPane.showMessageDialog(form, "Informe a data de emissao do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (provincia == null) {
            JOptionPane.showMessageDialog(form, "Seleccione uma provincia!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getTelefone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o telefone!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (distrito == null) {
            JOptionPane.showMessageDialog(form, "Seleccione um distrito!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            /*
            ainda por terminar
             */
            cand.setNome(form.getNome().getText());
            cand.setApelido(form.getApelido().getText());
            cand.setNomepai(form.getNomePai().getText());
            cand.setNomemae(form.getNomeMae().getText());
            cand.setDatanascimento(form.getDataNascimento().getDate());
            cand.setTipoid(tipoId);
            cand.setNumerodocumento(form.getNrDocumento().getText());
            cand.setLocalemissao(form.getLocalEmissao().getText());
            cand.setDataemissao(form.getDataEmissao().getDate());
            cand.setNivelAcademico(nivelAcademico);
            cand.setEmail(form.getEmail().getText());
            cand.setTelefone(form.getTelefone().getText());
            cand.setMorada(form.getMorada().getText());
            cand.setPais(pais);
            cand.setProvincia(provincia);
            cand.setDistrito(distrito);
            cand.setSexo(sexo);
            cand.setHabilidades(form.getHabilidades().getText());
            cand.setSituacaoprof(situacao);
            cand.setSitP(sitp);
            cand.setDatacadastro(Calendar.getInstance().getTime());
            cand.setFoto(foto);

            if (situacao.getNome().equals("Instituicao")) {
                cand.setIsSingular(false);
                cand.setProfissao(form.getProfissao().getText());
                cand.setLocaldetrabalho(form.getLocalTrabalho().getText());
                cand.setEmailTrabalho(form.getEmailTrabalho().getText());
                cand.setTelefoneTrabalho(form.getTelefoneTrabalho().getText());
            } else {
                cand.setIsSingular(true);
                cand.setProfissao(form.getProfissao().getText());
                cand.setLocaldetrabalho(form.getLocalTrabalho().getText());
                cand.setEmailTrabalho(form.getEmailTrabalho().getText());
                cand.setTelefoneTrabalho(form.getTelefoneTrabalho().getText());
            }
        }

        return cand;
    }

    public void adicionarListener() {
        form.getDocumento().addItemListener(this);
        form.getNivelAcademico().addItemListener(this);
        form.getPais().addItemListener(this);
        form.getDistrito().addItemListener(this);
        form.getProvincia().addItemListener(this);
        form.getAdicionarFoto().addActionListener(this);
        form.getRemoverFoto().addActionListener(this);
        form.getSituacaoProfissional().addItemListener(this);
        form.getSProfissional().addItemListener(this);
        form.getSexo().addItemListener(this);
        form.getButtonFechar().addActionListener(this);
        form.getButtonSalvar().addActionListener(this);

        form.getButtonFechar().setActionCommand("fechar");
        form.getButtonSalvar().setActionCommand("salvar");
        form.getAdicionarFoto().setActionCommand("adicionar");
        form.getRemoverFoto().setActionCommand("remover");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        } else if (e.getActionCommand().equals("adicionar")) {
            try {
                foto.abreImagem(form.getFotoJPanel(), form.getFoto());
            } catch (MalformedURLException ex) {
                Logger.getLogger(CandidatoControladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand().equals("salvar")) {
            Candidato c = formParaCandidato();
            if (c.getNome() != null && c.getTelefone()!=null && c.getApelido() != null && c.getDatanascimento() != null && c.getNumerodocumento() != null && c.getLocalemissao() != null && c.getDataemissao() != null && c.getDistrito() != null && c.getProvincia() != null) {
                if (servico.isCadastrado(c)) {
                    JOptionPane.showMessageDialog(form, "Este candidato ja esta cadastrado!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        foto.guardarImagem();
                    } catch (IOException ex) {
                        Logger.getLogger(CandidatoControladora.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    servico.guardarCandidato(c);
                    JOptionPane.showMessageDialog(form, "Candidato cadastrado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                }
            }
        } else if (e.getActionCommand().equals("remover")) {
            foto = new Imagem();
            try {
                foto.mostrarImagem(form.getFotoJPanel(), form.getFoto());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(form, ex.getMessage());
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getPais())) {
            pais = new PaisServico().ObterPais((String) form.getPais().getSelectedItem());
            adicionaProvincia(pais);
        } else if (e.getSource().equals(form.getProvincia())) {
            provincia = new ProvinciaServico().ObterProvincia((String) form.getProvincia().getSelectedItem(), pais);
            adicionaDistrito(provincia);
        } else if (e.getSource().equals(form.getDistrito())) {
            distrito = new DistritoServico().ObterDistrito(provincia, (String) form.getDistrito().getSelectedItem());
        } else if (e.getSource().equals(form.getSituacaoProfissional())) {
            situacao = new SituacaoProfServico().ObterSituacao((String) form.getSituacaoProfissional().getSelectedItem());
           // desabilitaCampos(situacao);
        } else if (e.getSource().equals(form.getNivelAcademico())) {
            nivelAcademico = new NivelAcademicoServico().ObterNivelAcademico((String) form.getNivelAcademico().getSelectedItem());
        } else if (e.getSource().equals(form.getDocumento())) {
            tipoId = new Tipo_idServico().ObterId((String) form.getDocumento().getSelectedItem());
        } else if (e.getSource().equals(form.getSexo())) {
            sexo = new SexoServico().ObterSexo((String) form.getSexo().getSelectedItem());
        }else if(e.getSource().equals(form.getSProfissional())){
            sitp=new SituacaoProfServico().ObterSitP((String)form.getSProfissional().getSelectedItem());
        }
    }

}
