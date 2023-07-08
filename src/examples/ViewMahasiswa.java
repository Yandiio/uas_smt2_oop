/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import examples.Mahasiswa;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class ViewMahasiswa extends javax.swing.JFrame {
    
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Mahasiswa> mahasiswaList;

        public ViewMahasiswa() {
        mahasiswaList = new ArrayList<>();

        // Create and configure GUI components
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("NAMA");
        tableModel.addColumn("NIM");
        tableModel.addColumn("Prodi");
        tableModel.addColumn("Kelas");
        tableModel.addColumn("IPK");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JLabel label = new JLabel("Data Mahasiswa STMIK AMIK");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 16f));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddDialog();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Mahasiswa mahasiswa = mahasiswaList.get(selectedRow);
                    showEditDialog(mahasiswa, selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris untuk diubah.");
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin dihapus?",
                            "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        mahasiswaList.remove(selectedRow);
                        tableModel.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris untuk dihapus");
                }
            }
        });

        // Configure the layout
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Data Mahasiswa STMIK AMIK BANDUNG");
        setSize(800, 600);
        setLocationRelativeTo(null); // Set to center of the screen
        setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        create_mhs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mhs = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Mahasiswa");

        create_mhs.setText("Tambah Mahasiswa");
        create_mhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_mhsActionPerformed(evt);
            }
        });

        tbl_mhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_mhs);

        jLabel1.setText("Data Mahasiswa STMIK AMIK BANDUNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create_mhs))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_mhs))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_mhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_mhsActionPerformed
        // TODO add your handling code here:
        showAddDialog();
    }//GEN-LAST:event_create_mhsActionPerformed

    private void showAddDialog() {
        JTextField idField = new JTextField();
        JTextField namaField = new JTextField();
        JTextField nimField = new JTextField();
        JTextField prodiField = new JTextField();
        JTextField kelasField = new JTextField();
        JTextField ipkField = new JTextField();

        Object[] fields = {
                "ID:", idField,
                "NAMA:", namaField,
                "NIM:", nimField,
                "Prodi:", prodiField,
                "Kelas:", kelasField,
                "IPK:", ipkField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Add Mahasiswa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String nama = namaField.getText();
            String nim = nimField.getText();
            String prodi = prodiField.getText();
            String kelas = kelasField.getText();
            double ipk = Double.parseDouble(ipkField.getText());

            Mahasiswa mahasiswa = new Mahasiswa();
            
            mahasiswa.setId(id);
            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setProdi(prodi);
            mahasiswa.setKelas(kelas);
            mahasiswa.setIpk(ipk);
            
            mahasiswaList.add(mahasiswa);
            tableModel.addRow(new Object[]{mahasiswa.getId(), mahasiswa.getNama(), mahasiswa.getNim(),
                    mahasiswa.getProdi(), mahasiswa.getKelas(), mahasiswa.getIpk()});
        }
    }

    private void showEditDialog(Mahasiswa mahasiswa, int rowIndex) {
        JTextField idField = new JTextField(mahasiswa.getId());
        JTextField namaField = new JTextField(mahasiswa.getNama());
        JTextField nimField = new JTextField(mahasiswa.getNim());
        JTextField prodiField = new JTextField(mahasiswa.getProdi());
        JTextField kelasField = new JTextField(mahasiswa.getKelas());
        JTextField ipkField = new JTextField(String.valueOf(mahasiswa.getIpk()));

        Object[] fields = {
                "ID:", idField,
                "NAMA:", namaField,
                "NIM:", nimField,
                "Prodi:", prodiField,
                "Kelas:", kelasField,
                "IPK:", ipkField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Edit Mahasiswa", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String nama = namaField.getText();
            String nim = nimField.getText();
            String prodi = prodiField.getText();
            String kelas = kelasField.getText();
            double ipk = Double.parseDouble(ipkField.getText());

            mahasiswa.setId(id);
            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setProdi(prodi);
            mahasiswa.setKelas(kelas);
            mahasiswa.setIpk(ipk);

            tableModel.setValueAt(id, rowIndex, 0);
            tableModel.setValueAt(nama, rowIndex, 1);
            tableModel.setValueAt(nim, rowIndex, 2);
            tableModel.setValueAt(prodi, rowIndex, 3);
            tableModel.setValueAt(kelas, rowIndex, 4);
            tableModel.setValueAt(ipk, rowIndex, 5);
        }
    }



     /* @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMahasiswa().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create_mhs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_mhs;
    // End of variables declaration//GEN-END:variables
    
}
