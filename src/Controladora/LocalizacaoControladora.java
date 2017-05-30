/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.DistritoServico;
import Servico.NivelAcademicoServico;
import Servico.PaisServico;
import Servico.ProvinciaServico;
import Servico.SexoServico;
import Servico.SituacaoProfServico;
import Servico.Tipo_idServico;
import com.sun.pisces.PiscesRenderer;
import entidades.Candidato;
import entidades.Distrito;
import entidades.Pais;
import entidades.Provincia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Localizacao;

/**
 *
 * @author junito
 */
public class LocalizacaoControladora implements ActionListener, ItemListener, MouseListener {

    private Localizacao form;
    private DefaultTableModel paisModel;
    private DefaultTableModel provinciaModel;
    private DefaultTableModel distritoModel;
    private DefaultComboBoxModel comboPaisModel;
    private DefaultComboBoxModel comboPaisDModel;
    private DefaultComboBoxModel comboProvinciaModel;
    private DefaultComboBoxModel comboDistritoModel;
    private String[] paiscolunas;
    private String[] provinciacolunas;
    private String[] distritocolunas;
    private Pais paisAbaProvincia = new Pais();
    private Pais paisAbaDistrito = new Pais();
    private Provincia provinciaAbaDistrito = new Provincia();

    private Pais paisForDelete = new Pais();
    private Provincia provinciaForDelete = new Provincia();
    private Distrito distritoForDelete = new Distrito();

    public LocalizacaoControladora(Localizacao form) {
        this.form = form;
        this.paiscolunas = new String[]{"Nr", "Pais"};
        this.provinciacolunas = new String[]{"Nr", "Provincia", "Pais"};
        this.distritocolunas = new String[]{"Nr", "Distrito", "Provincia"};
        this.paisModel = new DefaultTableModel(paiscolunas, 1);
        this.provinciaModel = new DefaultTableModel(provinciacolunas, 2);
        this.distritoModel = new DefaultTableModel(distritocolunas, 2);
        adicionarListener();
        adicionaPais();
        adicionaPaisD();
        prenncherTabelaDistrito();
        prenncherTabelaPais();
        prenncherTabelaProvincia();
    }

    public Pais formToPais() {
        Pais p = new Pais();
        if (form.getJtPais().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome do pais", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            p.setNome(form.getJtPais().getText());
        }
        return p;
    }

    public Provincia formToProvincia() {
        Provincia prov = new Provincia();
        if (form.getJtProvincia().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome da provincia", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            prov.setNome(form.getJtProvincia().getText());
        }
        return prov;
    }

    public Distrito formToDistrito() {
        Distrito dist = new Distrito();
        if (form.getJtDistrito().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome do distrito", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            dist.setNome(form.getJtDistrito().getText());
        }
        return dist;
    }

    public void prenncherTabelaPais() {
        List<Pais> pais = new PaisServico().listadPaises();

        if (pais.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem paises no banco de dados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = pais.size();
            paisModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                paisModel.setValueAt(pais.get(i).getIdpais(), i, 0);
                paisModel.setValueAt(pais.get(i).getNome(), i, 1);
            }
            form.getTablePais().setModel(paisModel);
            form.getTablePais().getColumnModel().getColumn(0).setMaxWidth(50);
        }
    }

    public void prenncherTabelaProvincia() {
        List<Provincia> provincia = new ProvinciaServico().listaProvincias();

        if (provincia.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem provincias no banco de dados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = provincia.size();
            provinciaModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                provinciaModel.setValueAt(provincia.get(i).getIdprovincia(), i, 0);
                provinciaModel.setValueAt(provincia.get(i).getNome(), i, 1);
                provinciaModel.setValueAt(new PaisServico().ObterPais(provincia.get(i).getPais().getIdpais()), i, 2);
            }
            form.getTableProvincia().setModel(provinciaModel);
            form.getTableProvincia().getColumnModel().getColumn(0).setMaxWidth(50);
        }

    }

    public void prenncherTabelaDistrito() {
        List<Distrito> distrito = new DistritoServico().listaDistritos();

        if (distrito.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem distritos no banco de dados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = distrito.size();
            distritoModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                distritoModel.setValueAt(distrito.get(i).getIddistrito(), i, 0);
                distritoModel.setValueAt(distrito.get(i).getNome(), i, 1);
                distritoModel.setValueAt(new ProvinciaServico().ObterProvincia(distrito.get(i).getProvincia().getIdprovincia()), i, 2);
            }
            form.getTableDistrito().setModel(distritoModel);
            form.getTableDistrito().getColumnModel().getColumn(0).setMaxWidth(50);
        }

    }

    public void adicionaPais() {
        List<Pais> paises = new PaisServico().listadPaises();
        if (paises != null) {
            comboPaisModel = new DefaultComboBoxModel();
            for (int i = 0; i < paises.size(); i++) {
                comboPaisModel.insertElementAt(paises.get(i).getNome(), i);
            }
            form.getJcPaisFromProvincia().setModel(comboPaisModel);
            form.getJcPaisFromProvincia().setSelectedIndex(0);
            paisAbaProvincia = new PaisServico().ObterPais((String) form.getJcPaisFromProvincia().getSelectedItem());
        } else {
            form.getJcPaisFromProvincia().setModel(comboPaisModel);
        }
    }

    public void adicionaPaisD() {
        List<Pais> paises = new PaisServico().listadPaises();
        if (paises != null) {
            comboPaisDModel = new DefaultComboBoxModel();
            for (int i = 0; i < paises.size(); i++) {
                comboPaisDModel.insertElementAt(paises.get(i).getNome(), i);
            }
            form.getJcPaisFromDistrito().setModel(comboPaisDModel);
            form.getJcPaisFromDistrito().setSelectedIndex(0);
            paisAbaDistrito = new PaisServico().ObterPais((String) form.getJcPaisFromDistrito().getSelectedItem());
            adicionaProvincia(paisAbaDistrito);
        } else {
            form.getJcPaisFromDistrito().setModel(comboPaisDModel);
        }
    }

    public void adicionaProvincia(Pais p) {

        List<Provincia> provincias = new ProvinciaServico().listaProvincias(p);
        if (!provincias.isEmpty()) {
            comboProvinciaModel = new DefaultComboBoxModel();
            for (int i = 0; i < provincias.size(); i++) {
                comboProvinciaModel.insertElementAt(provincias.get(i).getNome(), i);
            }
            form.getJcProvincia().setModel(comboProvinciaModel);
            form.getJcProvincia().setSelectedIndex(0);
            provinciaAbaDistrito = new ProvinciaServico().ObterProvincia((String) form.getJcProvincia().getSelectedItem(), paisAbaDistrito);
        } else {
            //  provinciaModel = new DefaultComboBoxModel();

            form.getJcProvincia().setModel(new DefaultComboBoxModel());
        }
    }

    public void adicionarListener() {
        form.getAddDistrito().addActionListener(this);
        form.getAddPais().addActionListener(this);
        form.getAddProvincia().addActionListener(this);
        form.getFechar().addActionListener(this);
        form.getFecharPais().addActionListener(this);
        form.getFecharProvincia().addActionListener(this);
        form.getEliminarDistrito().addActionListener(this);
        form.getEliminarPais().addActionListener(this);
        form.getEliminarProvincia().addActionListener(this);
        form.getAddDistrito().setActionCommand("addDistrito");
        form.getAddPais().setActionCommand("addPais");
        form.getAddProvincia().setActionCommand("addProvincia");
        form.getEliminarDistrito().setActionCommand("eliminardistrito");
        form.getEliminarPais().setActionCommand("eliminarpais");
        form.getEliminarProvincia().setActionCommand("eliminarprovincia");
        form.getFechar().setActionCommand("fechar");
        form.getFecharPais().setActionCommand("fecharpais");
        form.getFecharProvincia().setActionCommand("fecharprovincia");

        form.getJcPaisFromDistrito().addItemListener(this);
        form.getJcPaisFromProvincia().addItemListener(this);
        form.getJcProvincia().addItemListener(this);
        form.getTableDistrito().addMouseListener(this);
        form.getTablePais().addMouseListener(this);
        form.getTableProvincia().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "addPais":
                Pais pais = formToPais();
                pais.setIdpais(new PaisServico().ultimoId() + 1);
                if (!form.getJtPais().getText().isEmpty()) {
                    if (new PaisServico().Existe(pais)) {
                        JOptionPane.showMessageDialog(form, "Este pais ja foi cadastrado, insira outro pais!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new PaisServico().salvar(pais);
                        prenncherTabelaPais();
                        form.getJtPais().setText("");
                    }
                }
                break;
            case "addDistrito":
                Distrito distrito = formToDistrito();
                distrito.setIddistrito(new DistritoServico().utlimoId() + 1);
                if (!form.getJtDistrito().getText().isEmpty()) {
                    distrito.setProvincia(provinciaAbaDistrito);
                    if (new DistritoServico().Existe(distrito)) {
                        JOptionPane.showMessageDialog(form, "Este distrito ja foi cadastrado, insira outro distrito!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new DistritoServico().salvar(distrito);
                        prenncherTabelaDistrito();
                        form.getJtDistrito().setText("");
                    }
                }
                break;
            case "addProvincia":
                Provincia provincia = formToProvincia();
                provincia.setIdprovincia(new ProvinciaServico().utlimmoId() + 1);
                if (!form.getJtProvincia().getText().isEmpty()) {
                    provincia.setPais(paisAbaProvincia);
                    if (new ProvinciaServico().Existe(provincia)) {
                        JOptionPane.showMessageDialog(form, "Esta provincia ja foi cadastrada, insira outra provincia!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new ProvinciaServico().salvar(provincia);
                        prenncherTabelaProvincia();
                        form.getJtProvincia().setText("");
                    }
                }
                break;
            case "eliminarpais":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende apagar este pais?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    new PaisServico().apagar(paisForDelete);
                    JOptionPane.showMessageDialog(form, "Apagado com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    form.getJtPais().setText("");
                    prenncherTabelaPais();
                    adicionaPais();
                    adicionaPaisD();
                }
                break;
            case "eliminarprovincia":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende apagar esta provincia?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    new ProvinciaServico().apagar(provinciaForDelete);
                    JOptionPane.showMessageDialog(form, "Apagado com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    form.getJtProvincia().setText("");
                    prenncherTabelaProvincia();
                    adicionaPaisD();
                }
                break;
            case "eliminardistrito":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende apagar este distrito?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    new DistritoServico().apagar(distritoForDelete);
                    JOptionPane.showMessageDialog(form, "Apagado com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    form.getJtDistrito().setText("");
                    prenncherTabelaDistrito();
                    adicionaPaisD();
                }
                break;
            case "fechar":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "fecharpais":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "fecharprovincia":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcPaisFromProvincia())) {
            paisAbaProvincia = new PaisServico().ObterPais((String) form.getJcPaisFromProvincia().getSelectedItem());
        } else if (e.getSource().equals(form.getJcPaisFromDistrito())) {
            paisAbaDistrito = new PaisServico().ObterPais((String) form.getJcPaisFromDistrito().getSelectedItem());
            adicionaProvincia(paisAbaDistrito);
            provinciaAbaDistrito = new ProvinciaServico().ObterProvincia((String) form.getJcProvincia().getSelectedItem(), paisAbaDistrito);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getTablePais())) {
            String nome = (String) paisModel.getValueAt(form.getTablePais().getSelectedRow(), 1);
            paisForDelete = new PaisServico().ObterPais(nome);
            form.getJtPais().setText(paisForDelete.getNome());
        } else if (e.getSource().equals(form.getTableProvincia())) {
            String nome = (String) provinciaModel.getValueAt(form.getTableProvincia().getSelectedRow(), 1);
            Pais p = new PaisServico().ObterPais((String) provinciaModel.getValueAt(form.getTableProvincia().getSelectedRow(), 2));
            provinciaForDelete = new ProvinciaServico().ObterProvincia(nome, p);
            form.getJtProvincia().setText(provinciaForDelete.getNome());
            form.getJcPaisFromProvincia().setSelectedItem(p.getNome());

        } else if (e.getSource().equals(form.getTableDistrito())) {
            String nome = (String) distritoModel.getValueAt(form.getTableDistrito().getSelectedRow(), 1);
            Provincia prov = new ProvinciaServico().ObterProvincia((String) distritoModel.getValueAt(form.getTableDistrito().getSelectedRow(), 2));
            distritoForDelete = new DistritoServico().ObterDistrito(prov, nome);
            form.getJtDistrito().setText(distritoForDelete.getNome());
            form.getJcPaisFromDistrito().setSelectedItem(new PaisServico().ObterPais(prov.getPais().getIdpais()));
            form.getJcProvincia().setSelectedItem(prov.getNome());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
