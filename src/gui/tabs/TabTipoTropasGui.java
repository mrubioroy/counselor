/*
 * TabNacoesGui.java
 *
 * Created on April 23, 2008, 11:37 AM
 */
package gui.tabs;

import baseLib.GenericoComboObject;
import control.TipoTropaControler;
import control.services.FiltroConverter;
import gui.TabBase;
import gui.subtabs.SubTabTroopHabGui;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.TipoTropa;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;
import persistence.local.WorldManager;

/**
 *
 * @author gurgel
 */
public class TabTipoTropasGui extends TabBase {

    private static final Log log = LogFactory.getLog(TabTipoTropasGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private TipoTropaControler controler;

    public TabTipoTropasGui(String titulo, String dica) {
        initComponents();
        //Basico
        setIcone("/images/help_icon.gif");
        setTitle(titulo);
        setDica(dica);
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
        qtTropas = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jsHabilidade = new javax.swing.JScrollPane();
        jtHabilidade = new javax.swing.JTable();
        jsAtaque = new javax.swing.JScrollPane();
        jtAtaque = new javax.swing.JTable();
        jsDefesa = new javax.swing.JScrollPane();
        jtDefesa = new javax.swing.JTable();
        jsMovimentacao = new javax.swing.JScrollPane();
        jtMovimentacao = new javax.swing.JTable();
        jsTatica = new javax.swing.JScrollPane();
        jtTatica = new javax.swing.JTable();
        jsTroopHab = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jReplace = new javax.swing.JPanel();

        jLabel2.setText(labels.getString("TOTAL:")); // NOI18N

        jLabel1.setText(labels.getString("LISTAR:")); // NOI18N

        qtTropas.setText("66666"); // NOI18N

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
                .addComponent(qtTropas)
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
                    .addComponent(qtTropas))
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

        jsHabilidade.setBorder(null);

        jtHabilidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsHabilidade.setViewportView(jtHabilidade);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("labels"); // NOI18N
        jTabbedPane1.addTab(bundle.getString("TROPA.HABILIDADE"), new javax.swing.ImageIcon(getClass().getResource("/images/write-document-20x20.png")), jsHabilidade, bundle.getString("TROPA.HABILIDADE.TOOLTIP")); // NOI18N

        jsAtaque.setBorder(null);

        jtAtaque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ));
        jsAtaque.setViewportView(jtAtaque);

        jTabbedPane1.addTab(bundle.getString("TROPA.ATAQUE"), new javax.swing.ImageIcon(getClass().getResource("/images/hex_exercito.gif")), jsAtaque, bundle.getString("TROPA.ATAQUE.TOOLTIP")); // NOI18N

        jsDefesa.setBorder(null);

        jtDefesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ));
        jsDefesa.setViewportView(jtDefesa);

        jTabbedPane1.addTab(bundle.getString("TROPA.DEFESA"), new javax.swing.ImageIcon(getClass().getResource("/images/hex_exercito.gif")), jsDefesa, bundle.getString("TROPA.DEFESA.TOOLTIP")); // NOI18N

        jsMovimentacao.setBorder(null);

        jtMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsMovimentacao.setViewportView(jtMovimentacao);

        jTabbedPane1.addTab(bundle.getString("TROPA.MOVIMENTACAO"), new javax.swing.ImageIcon(getClass().getResource("/images/right.gif")), jsMovimentacao, bundle.getString("TROPA.MOVIMENTACAO.TOOLTIP")); // NOI18N

        jsTatica.setBorder(null);

        jtTatica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ));
        jsTatica.setViewportView(jtTatica);

        jTabbedPane1.addTab(bundle.getString("TATICA"), new javax.swing.ImageIcon(getClass().getResource("/images/combat.png")), jsTatica, "Defense values for all troops"); // NOI18N

        jsTroopHab.setBorder(null);

        javax.swing.GroupLayout jReplaceLayout = new javax.swing.GroupLayout(jReplace);
        jReplace.setLayout(jReplaceLayout);
        jReplaceLayout.setHorizontalGroup(
            jReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jReplaceLayout.setVerticalGroup(
            jReplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jReplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jReplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jsTroopHab.setViewportView(jPanel3);

        jTabbedPane1.addTab(labels.getString("TROOP.ABILITY.TITLE"), new javax.swing.ImageIcon(getClass().getResource("/images/book.gif")), jsTroopHab, labels.getString("TROOP.ABILITY.HINT")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jReplace;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane jsAtaque;
    private javax.swing.JScrollPane jsDefesa;
    private javax.swing.JScrollPane jsHabilidade;
    private javax.swing.JScrollPane jsMovimentacao;
    private javax.swing.JScrollPane jsTatica;
    private javax.swing.JScrollPane jsTroopHab;
    private javax.swing.JTable jtAtaque;
    private javax.swing.JTable jtDefesa;
    private javax.swing.JTable jtHabilidade;
    private javax.swing.JTable jtMainLista;
    private javax.swing.JTable jtMovimentacao;
    private javax.swing.JTable jtTatica;
    private javax.swing.JLabel qtTropas;
    // End of variables declaration//GEN-END:variables

    private void initConfig() {
        //Cria o Controle da lista
        controler = new TipoTropaControler(this);
        //configura grid
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMainLista.setAutoCreateRowSorter(true);
        jtAtaque.setAutoCreateColumnsFromModel(true);
        jtAtaque.setAutoCreateRowSorter(true);
        jtAtaque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtAtaque.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtDefesa.setAutoCreateColumnsFromModel(true);
        jtDefesa.setAutoCreateRowSorter(true);
        jtDefesa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtDefesa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtTatica.setAutoCreateColumnsFromModel(true);
        jtTatica.setAutoCreateRowSorter(true);
        jtTatica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtTatica.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMovimentacao.setAutoCreateColumnsFromModel(true);
        jtMovimentacao.setAutoCreateRowSorter(true);
        jtMovimentacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMovimentacao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtHabilidade.setAutoCreateColumnsFromModel(true);
        jtHabilidade.setAutoCreateRowSorter(true);
        jtHabilidade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtHabilidade.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        SubTabTroopHabGui newComp = new SubTabTroopHabGui();
        GroupLayout parLayout = (GroupLayout) jPanel3.getLayout();
        parLayout.replace(jReplace, newComp);

        comboFiltro.setActionCommand("comboFiltro");
        comboFiltro.setModel(FiltroConverter.getFiltroComboModelByJogador(WorldManager.getInstance().getPartida().getJogadorAtivo(), 3));

        //adiciona listeners
        comboFiltro.addActionListener(controler);
        jtMainLista.getSelectionModel().addListSelectionListener(controler);

        TableModel model = controler.getMainTableModel((GenericoComboObject) comboFiltro.getSelectedItem());
        this.setMainModel(model);
    }

    public JTable getMainLista() {
        return jtMainLista;
    }

    public final void setMainModel(TableModel model) {
        this.setAtaqueModel(null);
        this.setDefesaModel(null);
        this.setTaticaModel(null);
        this.setMovimentacaoModel(null);
        this.setHabilidadeModel(null);
        this.jtMainLista.setModel(model);
        this.calcColumnWidths(jtMainLista);
        this.updateGui();
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    private void updateGui() {
        this.qtTropas.setText(getMainLista().getRowCount() + "");
    }

    private void setAtaqueModel(TableModel model) {
        if (model == null) {
            this.jtAtaque.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("TERRENO"), labels.getString("VALOR")
                    }));
        } else {
            this.jtAtaque.setModel(model);
            calcColumnWidths(jtAtaque);
        }
    }

    private void setDefesaModel(TableModel model) {
        if (model == null) {
            this.jtDefesa.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("TERRENO"), labels.getString("VALOR")
                    }));
        } else {
            this.jtDefesa.setModel(model);
            calcColumnWidths(jtDefesa);
        }
    }

    private void setTaticaModel(TableModel model) {
        if (model == null) {
            this.jtTatica.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("TATICA"), labels.getString("VALOR")
                    }));
        } else {
            this.jtTatica.setModel(model);
            calcColumnWidths(jtTatica);
        }
    }

    private void setMovimentacaoModel(TableModel model) {
        if (model == null) {
            this.jtMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("TERRENO"), labels.getString("VALOR")
                    }));
        } else {
            this.jtMovimentacao.setModel(model);
            calcColumnWidths(jtMovimentacao);
        }
    }

    private void setHabilidadeModel(TableModel model) {
        if (model == null) {
            this.jtHabilidade.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("TERRENO"), labels.getString("VALOR")
                    }));
        } else {
            this.jtHabilidade.setModel(model);
            calcColumnWidths(jtHabilidade);
        }
    }

    public void doMuda(List<TipoTropa> lista, TipoTropa tpTropa) {
        this.setAtaqueModel(controler.getAtaqueTableModel(lista));
        this.setDefesaModel(controler.getDefesaTableModel(lista));
        this.setTaticaModel(controler.getTaticaTableModel());
        this.setMovimentacaoModel(controler.getMovimentacaoTableModel(lista));
        this.setHabilidadeModel(controler.getHabilidadeTableModel(tpTropa));
    }
}
