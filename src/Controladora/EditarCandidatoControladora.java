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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import util.Imagem;
import vista.EditarCandidato;

/**
 *
 * @author junito
 */
public class EditarCandidatoControladora implements ActionListener, ItemListener {

    private EditarCandidato form;
    private final DefaultComboBoxModel sexoModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel IdModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel nivelModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel situacaoModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel sitPModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel paisModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel provinciaModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel distritoModel = new DefaultComboBoxModel();
    private CandidatoServico servico = new CandidatoServico();
    private Pais pais;
    private Imagem foto = new Imagem();
    private Provincia provincia;
    private Distrito distrito;
    private Situacao_Profissional situacao;
    private SitP sitP;
    private Nivel_Academico nivelAcademico;
    private Tipo_Id tipoId;
    private Sexo sexo;

    public EditarCandidatoControladora(EditarCandidato form) {
        this.form = form;
        adicionaId();
        adicionaNivel();
        adicionaPais();
        adicionaSexo();
        adicionaSituacaoP();
        adicionaSitP();
        CandidatoParaFormulario();
        adicionarListener();
    }

    public Candidato formParaCandidato() {
        Candidato cand = new Candidato();
        if (form.getNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getApelido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o apelido!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getDataNascimento().getDate()==null) {
            JOptionPane.showMessageDialog(form, "Informe a data de nascimento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getNrDocumento().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o numero do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getLocalEmissao().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o local de emissao do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getDataEmissao().getDate()==null) {
            JOptionPane.showMessageDialog(form, "Informe a data de emissao do documento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getTelefone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o telefone!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }else if (provincia == null) {
            JOptionPane.showMessageDialog(form, "Seleccione uma provincia!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
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
            cand.setSitP(sitP);
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

    public void adicionaId() {
        List<Tipo_Id> id = new Tipo_idServico().listaID();
        if (id != null) {
            for (int i = 0; i < id.size(); i++) {
                IdModel.insertElementAt(id.get(i).getNome(), i);
            }
            form.getDocumento().setModel(IdModel);
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
        } else {
            form.getNivelAcademico().setModel(nivelModel);
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
            // form.getProvincia().setSelectedIndex(0);

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
            //form.getPais().setSelectedIndex(form.getCandidato().getPais().getIdpais());
        } else {
            form.getPais().setModel(paisModel);
        }
    }

    public void desabilitaCampos(Situacao_Profissional s) {
        if (s.getNome().equals("Singular")) {
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

    public void adicionaSituacaoP() {
        List<Situacao_Profissional> situacaop = new SituacaoProfServico().listaSituacaoP();
        if (situacaop != null) {
            for (int i = 0; i < situacaop.size(); i++) {
                situacaoModel.insertElementAt(situacaop.get(i).getNome(), i);
            }
            form.getSituacaoProfissional().setModel(situacaoModel);
        } else {
            form.getSituacaoProfissional().setModel(nivelModel);
        }
    }
    
    public void adicionaSitP() {
        List<SitP> sitprofissional = new SituacaoProfServico().listaSitP();
        if (sitprofissional != null) {
            for (int i = 0; i < sitprofissional.size(); i++) {
                sitPModel.insertElementAt(sitprofissional.get(i).getNome(), i);
            }
            form.getSProfissional().setModel(sitPModel);
        } else {
            form.getSProfissional().setModel(sitPModel);
        }
    }

    public void adicionaSexo() {
        List<Sexo> sexos = new Servico.SexoServico().listaDeSexo();
        if (sexos != null) {
            for (int i = 0; i < sexos.size(); i++) {
                sexoModel.insertElementAt(sexos.get(i).getNome(), i);
            }
            form.getSexo().setModel(sexoModel);
        } else {
            form.getSexo().setModel(sexoModel);
        }
    }

    public void limparCampos() {
        form.getNome().setText("");
        form.getApelido().setText("");
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

    public void CandidatoParaFormulario() {
        form.getNome().setText(form.getCandidato().getNome());
        form.getApelido().setText(form.getCandidato().getApelido());
        form.getNomePai().setText(form.getCandidato().getNomepai());
        form.getNomeMae().setText(form.getCandidato().getNomemae());
        form.getDataNascimento().setDate(form.getCandidato().getDatanascimento());
        
        form.getDocumento().setSelectedIndex(form.getCandidato().getTipoid().getIdtipo());
        tipoId = new Tipo_idServico().ObterId((String) form.getDocumento().getSelectedItem());
        
        form.getNrDocumento().setText(form.getCandidato().getNumerodocumento());
        form.getLocalEmissao().setText(form.getCandidato().getLocalemissao());

        form.getDataEmissao().setDate(form.getCandidato().getDataemissao());
        
        form.getNivelAcademico().setSelectedIndex(form.getCandidato().getNivelAcademico().getIdnivelacademico());
        nivelAcademico = new NivelAcademicoServico().ObterNivelAcademico((String) form.getNivelAcademico().getSelectedItem());
        form.getEmail().setText(form.getCandidato().getEmail());
        form.getTelefone().setText(form.getCandidato().getTelefone());
        form.getMorada().setText(form.getCandidato().getMorada());

        form.getPais().setSelectedIndex(form.getCandidato().getPais().getIdpais());
        pais = new PaisServico().ObterPais((String) form.getPais().getSelectedItem());
        adicionaProvincia(pais);
        
        int pindice=form.getCandidato().getProvincia().getIdprovincia();
        String prov=new ProvinciaServico().ObterProvincia(pais, pindice);
        for(int i=0;i<form.getProvincia().getItemCount();i++){
            if(form.getProvincia().getItemAt(i).equals(prov))
                pindice=i;
        }
        
        form.getProvincia().setSelectedIndex(pindice);
        provincia = new ProvinciaServico().ObterProvincia((String) form.getProvincia().getSelectedItem(), pais);
        adicionaDistrito(provincia);

        int dindice = form.getCandidato().getDistrito().getIddistrito();
        String dist = new DistritoServico().ObterDistrito(provincia, dindice);
        for (int i = 0; i < form.getDistrito().getItemCount(); i++) {
            if (form.getDistrito().getItemAt(i).equals(dist)) {
                dindice = i;
            }
        }
        form.getDistrito().setSelectedIndex(dindice);
        distrito = new DistritoServico().ObterDistrito(provincia, (String) form.getDistrito().getSelectedItem());

        form.getSexo().setSelectedIndex(form.getCandidato().getSexo().getIdsexo());
        sexo=new SexoServico().ObterSexo((String)form.getSexo().getSelectedItem());
        int sit = form.getCandidato().getSituacaoprof().getIdsituacaoprofissional();

        form.getSituacaoProfissional().setSelectedIndex(sit);
        situacao = new SituacaoProfServico().ObterSituacao((String) form.getSituacaoProfissional().getSelectedItem());
        //desabilitaCampos(situacao);
        int sitpp=form.getCandidato().getSitP().getId();
        form.getSProfissional().setSelectedIndex(sitpp);
        sitP=new SituacaoProfServico().ObterSitP((String)form.getSProfissional().getSelectedItem());

        URL url = null;
        try {
            URI uri = new URI(form.getCandidato().getFoto().getPath());
            url = uri.toURL();
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        foto.setUrl(url);
        foto.setNomedaimagem(form.getCandidato().getFoto().getNomedaimagem());
        foto.setPath(form.getCandidato().getFoto().getPath());
        mostrarImagem();
        form.getProfissao().setText(form.getCandidato().getProfissao());
        form.getLocalTrabalho().setText(form.getCandidato().getLocaldetrabalho());
        form.getTelefoneTrabalho().setText(form.getCandidato().getTelefoneTrabalho());
        form.getEmailTrabalho().setText(form.getCandidato().getEmailTrabalho());
        form.getHabilidades().setText(form.getCandidato().getHabilidades());

    }

    public void mostrarImagem() {
        try {
            foto.mostrarImagem(form.getFotoJPanel(), form.getFoto());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
        form.getEliminar().addActionListener(this);
        form.getButtonFechar().setActionCommand("fechar");
        form.getButtonSalvar().setActionCommand("salvar");
        form.getAdicionarFoto().setActionCommand("adicionar");
        form.getRemoverFoto().setActionCommand("remover");
        form.getEliminar().setActionCommand("eliminar");
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
        } else if (e.getActionCommand().equals("remover")) {
            foto = new Imagem();
            try {
                foto.mostrarImagem(form.getFotoJPanel(), form.getFoto());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(form, ex.getMessage());
            }
        } else if (e.getActionCommand().equals("eliminar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende eliminar este candidato?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                servico.deleteCandidato(form.getCandidato());
                JOptionPane.showMessageDialog(form, "Candidato eliminado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                form.dispose();
            }
        } else if (e.getActionCommand().equals("salvar")) {
            Candidato c = formParaCandidato();
            if (c.getNome() != null && c.getApelido() != null && c.getDatanascimento() != null && c.getNumerodocumento() != null && c.getLocalemissao() != null && c.getDataemissao() != null && c.getDistrito() != null && c.getProvincia() != null) {
                try {
                    foto.guardarImagem();
                } catch (IOException ex) {
                    Logger.getLogger(CandidatoControladora.class.getName()).log(Level.SEVERE, null, ex);
                }
                c.setIdcandidato(form.getCandidato().getIdcandidato());
                servico.updateCandidato(c);
                JOptionPane.showMessageDialog(form, "Candidato actualizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
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
            desabilitaCampos(situacao);
        } else if (e.getSource().equals(form.getNivelAcademico())) {
            nivelAcademico = new NivelAcademicoServico().ObterNivelAcademico((String) form.getNivelAcademico().getSelectedItem());
        } else if (e.getSource().equals(form.getDocumento())) {
            tipoId = new Tipo_idServico().ObterId((String) form.getDocumento().getSelectedItem());
        } else if (e.getSource().equals(form.getSexo())) {
            sexo = new SexoServico().ObterSexo((String) form.getSexo().getSelectedItem());
        }else if(e.getSource().equals(form.getSProfissional())){
            sitP=new SituacaoProfServico().ObterSitP((String)form.getSProfissional().getSelectedItem());
        }
    }
}
