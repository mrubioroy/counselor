/*
 * TabNacoesGui.java
 *
 * Created on April 23, 2008, 11:37 AM
 */
package gui.tabs;

import baseLib.GenericoComboObject;
import business.facade.CenarioFacade;
import business.facade.NacaoFacade;
import business.facades.WorldFacadeCounselor;
import control.FinancasControler;
import control.MapaControler;
import control.services.FiltroConverter;
import gui.TabBase;
import gui.subtabs.SubTabBaseList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Nacao;
import model.PersonagemOrdem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;
import persistence.local.WorldManager;

/**
 *
 * @author gurgel
 */
public final class TabFinancasGui extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(TabFinancasGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private FinancasControler financasControl;
    private final SubTabBaseList stForecast = new SubTabBaseList();
    private final SubTabBaseList stBalance = new SubTabBaseList();
    private final SubTabBaseList stResources = new SubTabBaseList();
    private final NacaoFacade nacaoFacade = new NacaoFacade();
    private final CenarioFacade cenarioFacade = new CenarioFacade();

    public TabFinancasGui(String titulo, String dica, MapaControler mapaControl) {
        initComponents();
        //Basico
        setIcone("/images/financas.gif");
        setTitle(titulo);
        setDica(dica);
        this.setMapaControler(mapaControl);
        initConfig();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        qtNacoes = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        detalhesCidade = new javax.swing.JTabbedPane();

        jLabel2.setText(labels.getString("TOTAL:")); // NOI18N

        comboFiltro.setModel(getDefaultComboBoxModelTodosProprio());

        jLabel1.setText(labels.getString("LISTAR:")); // NOI18N

        qtNacoes.setText("66666"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtNacoes)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(qtNacoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(null);

        jtMainLista.setAutoCreateRowSorter(true);
        jtMainLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nação", "Tamanho", "Nação", "Local", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMainLista.setName(""); // NOI18N
        jScrollPane3.setViewportView(jtMainLista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(detalhesCidade)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalhesCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JTabbedPane detalhesCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtMainLista;
    private javax.swing.JLabel qtNacoes;
    // End of variables declaration//GEN-END:variables

    public JTable getMainLista() {
        return jtMainLista;
    }

    public void setMainModel(TableModel model) {
        stBalance.setListModelClear();
        stForecast.setListModelClear();
        stResources.setListModelClear();
        this.jtMainLista.setModel(model);
        this.calcColumnWidths(jtMainLista);
        this.updateGui();
        this.doTagHide();
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    public GenericoComboObject getFiltro() {
        return (GenericoComboObject) comboFiltro.getSelectedItem();
    }

    private void updateGui() {
        this.qtNacoes.setText(getMainLista().getRowCount() + "");
    }

    public void setProjecaoModel(TableModel model) {
        if (model == null) {
            //????
        } else {
            stForecast.setListModel(model);
        }
    }

    public void doMudaNacao(Nacao nacao) {
        try {
            getMapaControler().printTag(nacaoFacade.getLocal(nacao));
        } catch (NullPointerException ex) {
            this.doTagHide();
        }
        stBalance.setListModel(financasControl.getExtratoTableModel(nacao));
        stForecast.setListModel(financasControl.getProjecaoTableModel(nacao, new ArrayList<PersonagemOrdem>()));
        stResources.setListModel(financasControl.getMercadoTableModel(nacao));
    }

    private void addTabs() {
        detalhesCidade.addTab(labels.getString("EXTRATO.TURNO"),
                new javax.swing.ImageIcon(getClass().getResource("/images/diplomacy.gif")),
                stBalance, labels.getString("EXTRATO.TURNO"));
        detalhesCidade.addTab(labels.getString("EXTRATO.PROXIMO.TURNO"),
                new javax.swing.ImageIcon(getClass().getResource("/images/diplomacy.gif")),
                stForecast, labels.getString("EXTRATO.PROXIMO.TURNO"));
        if (cenarioFacade.hasResourceManagement(WorldFacadeCounselor.getInstance().getCenario())) {
            detalhesCidade.addTab(labels.getString("MERCADO"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/diplomacy.gif")),
                    stResources, labels.getString("MERCADO"));
        }
    }

    private void initConfig() {
        //configura grid
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMainLista.setAutoCreateRowSorter(true);
        addTabs();

        comboFiltro.setName("comboFiltro");
        comboFiltro.setActionCommand("comboFiltro");
        comboFiltro.setModel(FiltroConverter.getFiltroComboModelByJogador(WorldManager.getInstance().getPartida().getJogadorAtivo(), 4));
        comboFiltro.setSelectedIndex(this.getFiltroDefault());
        //Cria o Controle da lista 
        financasControl = new FinancasControler(this);

        //adiciona listeners
        comboFiltro.addActionListener(financasControl);
        jtMainLista.getSelectionModel().addListSelectionListener(financasControl);

        final TableModel model = financasControl.getMainTableModel(this.getFiltro());
        this.setMainModel(model);
    }
}
