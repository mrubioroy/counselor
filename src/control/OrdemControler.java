/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseLib.GenericoComboObject;
import business.facade.OrdemFacade;
import control.services.AcaoConverter;
import control.services.CenarioConverter;
import control.support.ControlBase;
import gui.subtabs.SubTabOrdem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Ordem;
import model.PersonagemOrdem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;

/**
 *
 * @author gurgel
 */
public class OrdemControler extends ControlBase implements Serializable, ActionListener, ListSelectionListener, ItemListener {

    private static final Log log = LogFactory.getLog(OrdemControler.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private int indexModelOrdem;
    private final SubTabOrdem tabGui;
    private final OrdemFacade ordemFacade = new OrdemFacade();

    public OrdemControler(SubTabOrdem tabOrdens) {
        this.tabGui = tabOrdens;
        //registerDispatchManager();
    }

    public String getParametroDisplay(int indexParametro) {
        return getTabGui().getActor().getParametroDisplay(indexModelOrdem, indexParametro);
    }

    public PersonagemOrdem getPersonagemOrdem() {
        return getTabGui().getActor().getPersonagemOrdem(indexModelOrdem);
    }

    private void doSalvaAction() {
        try {
            doSalvaAction(indexModelOrdem);
            final int repeats = ordemFacade.getRequirementsMultiLevel(getTabGui().getOrdemQuadro().getOrdem());
            for (int ii = 0; ii < repeats; ii++) {
                doSalvaAction(getTabGui().getNextActionSlot());
            }
            getTabGui().doFindNextActionSlot();
        } catch (NullPointerException ex) {
            //nao fax nada, ordem nao existe
        }
    }

    private void doSalvaAction(int index) {
        if (index < 0) {
            return;
        }
        final String[] ordemDisplay = getTabGui().getActor().doOrderSave(index, getTabGui().getOrdemQuadro());
        getTabGui().setValueAt(ordemDisplay, index);
    }

    public ComboBoxModel getTaticasComboModel() {
        return CenarioConverter.getInstance().getTaticaComboModel();
    }

    private SubTabOrdem getTabGui() {
        return this.tabGui;
    }

    public String getOrdemAjuda(Ordem ordemSelecionada) {
        return AcaoConverter.getAjuda(ordemSelecionada);
    }

    /**
     * Alguem acionou o botao para gravar ordens(JButton)
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof JTable) {
            log.info(labels.getString("OPS.JTABLE.EVENT"));
        } else if (actionEvent.getSource() instanceof JButton) {
            JButton button = (JButton) actionEvent.getSource();
            if ("jbOk".equals(button.getActionCommand())) {
                doSalvaAction();
            } else if ("jbHelp".equals(button.getActionCommand())) {
                //exibir ajuda.
                getTabGui().doDisplayAjuda();
            } else if ("jbClear".equals(button.getActionCommand())) {
                getTabGui().setValueAt(getTabGui().getActor().doOrderClear(indexModelOrdem), indexModelOrdem);
            }
        } else if (actionEvent.getSource() instanceof JComboBox) {
            JComboBox jcMagia = (JComboBox) actionEvent.getSource();
            if ("jcMagia".equals(jcMagia.getActionCommand())) {
                try {
                    getTabGui().setOrdemParametrosMagia((GenericoComboObject) jcMagia.getModel().getSelectedItem());
                } catch (NullPointerException ex) {
                    //nao faz nada, ordens nao disponiveis...
                }
            }
        } else {
            log.info(labels.getString("OPS.GENERAL.EVENT"));
        }
    }

    /**
     * Listener para a troca na combo de ordem...
     *
     * @param event
     */
    @Override
    public void itemStateChanged(ItemEvent event) {
        //Object source = event.getItemSelectable();
        if (event.getSource() instanceof JCheckBox) {
            final JCheckBox cb = (JCheckBox) event.getSource();
            //Now that we know which button was pushed, find out
            //whether it was selected or deselected.
            if ("cbOrdersAll".equals(cb.getActionCommand())) {
                //nao faz diferenca se esta selecionado ou nao.
                //&& event.getStateChange() == ItemEvent.DESELECTED
                // eh apenas o refresh da combo.
                getTabGui().doMudaOrdem(this.indexModelOrdem);
            }
        }
        if (event.getSource() instanceof JComboBox && event.getStateChange() == ItemEvent.SELECTED) {
            final JComboBox cb = (JComboBox) event.getSource();
            try {
                if ("cbOrdem".equals(cb.getActionCommand())) {
                    getTabGui().setOrdemParametrosQuadro((GenericoComboObject) cb.getModel().getSelectedItem());
                }
            } catch (ClassCastException ex) {
                log.debug("hum... suspicious");
            }
        }
        if (event.getSource() instanceof JToggleButton) {
            final JToggleButton cb = (JToggleButton) event.getSource();
            try {
                if ("jbDetach".equals(cb.getActionCommand())) {
                    //criar floating window para ordens
                    getTabGui().doDetachOrders();
                }
            } catch (ClassCastException ex) {
                log.debug("hum... suspicious");
            }
        }
    }

    /**
     * listener para a tabela de ordens.
     *
     * @param event
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        ListSelectionModel lsm = (ListSelectionModel) event.getSource();
        if (!lsm.isSelectionEmpty()) {
            JTable table = this.getTabGui().getOrdemLista();
            //pega o index da table
            int rowIndex = lsm.getAnchorSelectionIndex();
            //convete o index da table para o index do model
            this.indexModelOrdem = table.convertRowIndexToModel(rowIndex);
            getTabGui().doMudaOrdem(this.indexModelOrdem);
            //segue daki
            //agora pega a ordem e carrega o quadro de ordens.
        }
    }
}
