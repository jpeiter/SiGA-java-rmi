/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.views;

import ad33s.impl.CallbackAtendenteImpl;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.IControlador;
import ad33s.model.Guiche;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author joao_
 */
public class FrmAtendente extends javax.swing.JFrame {

    /**
     * Creates new form FrmAtendente
     */
    private IControlador controlador;
    private ICallbackAtendente callback;
    private int tamanhoFila;
    private String nomeAtendente;

    public FrmAtendente() {
        initComponents();

        nomeAtendente = JOptionPane.showInputDialog(null, "Nome do atendente", "Atendente", JOptionPane.INFORMATION_MESSAGE).replace(";", "");
        try {
            Registry registro = LocateRegistry.getRegistry(1053);
            controlador = (IControlador) registro.lookup("Controlador");

            callback = new CallbackAtendenteImpl(this);
            int[] tamFilas = controlador.registrarAtendente(nomeAtendente, callback);

            counterConv.setText(String.valueOf(tamFilas[0]));
            counterPref.setText(String.valueOf(tamFilas[1]));
            counterVip.setText(String.valueOf(tamFilas[2]));

        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Já existe um atendente com esse nome!");
        } catch (NotBoundException e) {
            System.out.println("Objeto não encontrado: " + e.getMessage());
        }

        lblAtendente.setText(!nomeAtendente.isEmpty() ? nomeAtendente : "Atendente");

        System.out.println(nomeAtendente + " registrado e atendendo...");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
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
        lblAtendente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        counterPref = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        counterConv = new javax.swing.JLabel();
        counterVip = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSenhaConvencional = new javax.swing.JButton();
        btnSenhaPreferencial = new javax.swing.JButton();
        btnSenhaVIP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Janela de Atendimento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Atendente:");

        lblAtendente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAtendente.setForeground(new java.awt.Color(204, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Convencional:");

        counterPref.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        counterPref.setForeground(new java.awt.Color(204, 0, 0));
        counterPref.setText("000");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("V.I.P:");

        counterConv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        counterConv.setForeground(new java.awt.Color(204, 0, 0));
        counterConv.setText("000");

        counterVip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        counterVip.setForeground(new java.awt.Color(204, 0, 0));
        counterVip.setText("000");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Preferencial:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("na fila");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("na fila");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("na fila");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(counterPref)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(counterVip)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(counterConv)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(counterConv)
                    .addComponent(jLabel5))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(counterPref)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(counterVip)
                    .addComponent(jLabel8))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        btnSenhaConvencional.setText("Chamar Convencional");
        btnSenhaConvencional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaConvencionalActionPerformed(evt);
            }
        });

        btnSenhaPreferencial.setText("Chamar Preferencial");
        btnSenhaPreferencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaPreferencialActionPerformed(evt);
            }
        });

        btnSenhaVIP.setText("Chamar V.I.P");
        btnSenhaVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenhaVIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSenhaConvencional, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
            .addComponent(btnSenhaPreferencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSenhaVIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnSenhaConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSenhaPreferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnSenhaVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtendente)
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblAtendente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSenhaConvencionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaConvencionalActionPerformed
        atendeSenha(new Guiche().getSERVICOS()[0]);
    }//GEN-LAST:event_btnSenhaConvencionalActionPerformed

    private void btnSenhaPreferencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaPreferencialActionPerformed
        atendeSenha(new Guiche().getSERVICOS()[1]);
    }//GEN-LAST:event_btnSenhaPreferencialActionPerformed

    private void btnSenhaVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenhaVIPActionPerformed
        atendeSenha(new Guiche().getSERVICOS()[2]);
    }//GEN-LAST:event_btnSenhaVIPActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAtendente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSenhaConvencional;
    private javax.swing.JButton btnSenhaPreferencial;
    private javax.swing.JButton btnSenhaVIP;
    private javax.swing.JLabel counterConv;
    private javax.swing.JLabel counterPref;
    private javax.swing.JLabel counterVip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAtendente;
    // End of variables declaration//GEN-END:variables

    private void atendeSenha(String servico) {
        try {
            tamanhoFila = controlador.atenderSenha(servico, nomeAtendente);

            if (tamanhoFila < 0) {
                JOptionPane.showMessageDialog(null, "Não há mais senhas há serem chamadas!");
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void atualizaTamanhoFila(String tipoFila, int tamanhoFila) {
        switch (tipoFila) {
            case "Convencional":
                counterConv.setText(String.valueOf(tamanhoFila));
                break;
            case "Preferencial":
                counterPref.setText(String.valueOf(tamanhoFila));
                break;
            case "VIP":
                counterVip.setText(String.valueOf(tamanhoFila));
                break;
        }
    }

}