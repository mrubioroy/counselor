/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseLib.GenericoComboObject;
import baseLib.GenericoTableModel;
import control.services.FeiticoConverter;
import gui.tabs.TabFeiticosGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Feitico;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;

/**
 *
 * @author gurgel
 */
public class FeiticoControler implements Serializable, ActionListener, ListSelectionListener {

    private static final Log log = LogFactory.getLog(FeiticoControler.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    ;
    private GenericoTableModel mainTableModel;
    private final TabFeiticosGui tabGui;
    private List listaExibida;

    public FeiticoControler(TabFeiticosGui tabGui) {
        this.tabGui = tabGui;
    }

    public ComboBoxModel getLivroComboModel() {
        return FeiticoConverter.getLivroComboModel();
    }

    public GenericoTableModel getMainTableModel(String filtro) {
        listaExibida = FeiticoConverter.listaByFiltro(filtro);
        this.mainTableModel = FeiticoConverter.getFeiticoModel(listaExibida);
        return this.mainTableModel;
    }

    public TabFeiticosGui getTabGui() {
        return tabGui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JTable) {
            log.info(labels.getString("OPS.JTABLE.EVENT"));
        } else if (event.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) event.getSource();
            if ("comboFiltro".equals(cb.getActionCommand())) {
                GenericoComboObject elem = (GenericoComboObject) cb.getSelectedItem();
                getTabGui().setMainModel(getMainTableModel(elem.getComboId()));
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        try {
            JTable table = this.getTabGui().getMainLista();
            ListSelectionModel lsm = (ListSelectionModel) event.getSource();
            if (!lsm.isSelectionEmpty()) {
                //testes
                int rowIndex = lsm.getAnchorSelectionIndex();
                int modelIndex = table.convertRowIndexToModel(rowIndex);
                Feitico feitico = (Feitico) listaExibida.get(modelIndex);
                getTabGui().doMudaFeitico(feitico);
                //PENDING atualizar table mensagens
            }
        } catch (IndexOutOfBoundsException ex) {
            //lista vazia?
        }
    }
}
