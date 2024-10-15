/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import controlador.ProdutoCategoriaDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProdutoCategoria;

/**
 *
 * @author Douglas Sugano
 */
public class CategoriaProdutoGerenciar extends javax.swing.JFrame {

    /**
     * Creates new form GrupoUsuarioGerenciar
     */
    public CategoriaProdutoGerenciar() {
        initComponents();
        jtfPesquisarKeyReleased(null);
    }

    private void cadastrar() {
        ProdutoCategoriaCadastrar pc = new ProdutoCategoriaCadastrar();
        pc.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jlPesquisa = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Categoria De Produtos");
        jLabel1.setToolTipText("");

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome da Categoria "
            }
        ));
        jScrollPane1.setViewportView(jtCategoria);

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.setToolTipText("");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jbAlterar.setText("Alterar");

        jlPesquisa.setText("Pesquisar:");

        jtfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 374, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPesquisar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesquisa)
                    .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jtfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisarKeyReleased
        // TODO add your handling code here:
         String campoPesquisa = jtfPesquisar.getText();
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0); // limpa os campos
        try {
            ProdutoCategoriaDao dao = new ProdutoCategoriaDao();
            List<ProdutoCategoria> lista = dao.buscar(campoPesquisa);

            for (ProdutoCategoria produtoCategoria : lista) {
                String[] linhadaTabela = {
                    String.valueOf(produtoCategoria.getId()),
                    produtoCategoria.getNomeCategoria()
                };
                modelo.addRow(linhadaTabela); // adiciona uma linha na tabela

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar: " + e.getMessage());

        }
    }//GEN-LAST:event_jtfPesquisarKeyReleased

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
         int linhaSelecionado = jtCategoria.getSelectedRow();
        if (linhaSelecionado != -1) {
            int opcao = JOptionPane.showConfirmDialog(this, "Confirmar Exclusão ?", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {

                int id = Integer.parseInt(jtCategoria.getModel().getValueAt(
                        linhaSelecionado, 0).toString());
                ProdutoCategoriaDao dao = new ProdutoCategoriaDao();
                try {
                    dao.excluir(id);
                    JOptionPane.showMessageDialog(this, "Categoria de Produto Excluido");
                    DefaultTableModel modelo = ((DefaultTableModel) jtCategoria.getModel());
                    modelo.removeRow(linhaSelecionado);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao pesquisar: " + e.getMessage());
                }

            }
        } else{
            JOptionPane.showMessageDialog(null, "Selecione um Registro para excluir");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CategoriaProdutoGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoriaProdutoGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoriaProdutoGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaProdutoGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoriaProdutoGerenciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JLabel jlPesquisa;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JTextField jtfPesquisar;
    // End of variables declaration//GEN-END:variables
}
