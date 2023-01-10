/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package layout;

import dao.TurmaDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TurmaModel;

/**
 *
 * @author Beatr
 */
public class ConsultarExcluirTurma extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarExcluirTurma
     */
    public ConsultarExcluirTurma() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void PesquisarTurmas() {
        List<TurmaModel> lista = dao.getTurma();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        int t = modelo.getRowCount();
        for (int i = 0; i < t; i++) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < lista.size(); i++) {
            String campo[] = new String[4];
            campo[0] = lista.get(i).getCod_turma()+ "";
            campo[1] = lista.get(i).getNome_turma();
            campo[2] = lista.get(i).getObs_turma();
            campo[3] = lista.get(i).getTurno_turma();

            modelo.addRow(campo);

        }
    }
    
    public void PesquisarTurmasPorTurno(String turno) {
        List<TurmaModel> lista = dao.getTurma(turno);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        int t = modelo.getRowCount();
        for (int i = 0; i < t; i++) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < lista.size(); i++) {
            String campo[] = new String[4];
            campo[0] = lista.get(i).getCod_turma()+ "";
            campo[1] = lista.get(i).getNome_turma();
            campo[2] = lista.get(i).getObs_turma();
            campo[3] = lista.get(i).getTurno_turma();

            modelo.addRow(campo);

        }
    }
    TurmaDao dao = new TurmaDao();
    TurmaModel turma = new TurmaModel();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTurnoTurma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Turma", "Nome", "Obs", "Turno"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel2.setText("Turno da Turma");

        jLabel1.setText("Para excluir a turma, basta selecionar a linha que deseja excluir e apertar o botão \"Excluir.\"");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnMenu.setText("Voltar Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTurnoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnBuscar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTurnoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnMenu))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String turno = txtTurnoTurma.getText();
        if(turno.equalsIgnoreCase("")){
            PesquisarTurmas();
        }else {
           PesquisarTurmasPorTurno(turno);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cod = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
        if (tabela.getSelectedRow() >= 0) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir realmente?", "Confirmação", 0) == 0) {

                if (dao.deletarTurma(Integer.parseInt(cod))) {
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    PesquisarTurmas();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarExcluirTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarExcluirTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtTurnoTurma;
    // End of variables declaration//GEN-END:variables
}
