/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.GiaoVienBUS;
import DTO.GiaoVienDTO;
import DTO.PhanCongDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.RowFilter;

/**
 *
 * @author Hyung
 */
public class GiaoVienForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel tbModelGV;
    private int flagAcc;
    private String manv;
//    private NhanVienBUS nhanVienBUS;
//    private DoanDuLichBUS doanDuLichBUS;
    private int selectedRow;
//    private Utils ult = new Utils();
    GiaoVienBUS giaoVienBUS = new GiaoVienBUS();
    private GiaoVienDTO giaoVienSelected = new GiaoVienDTO();

    public GiaoVienForm()
    {
        initComponents();
        jBtnCapPhatMaGV.setEnabled(true);
        jBtnThemGV.setEnabled(false);
        jBtnSuaGV.setEnabled(false);
        jBtnXoaGV.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaGiangVien.setText("");
        jTextTenGiangVien.setText("");
        jTextSDT.setText("");
        jTextEmail.setText("");
//        jDateNgaySinh.setCalendar(null);
        //loadData();
//        tk.setVisible(false);
    }

    public void initTableGV()
    {
        tbModelGV.setRowCount(0);
        tableModel(tbModelGV);
        jTableGV.setRowSorter(null);
        jTableGV.setAutoCreateRowSorter(true);
        jTableGV.setModel(tbModelGV);
        clear();
    }

    public void tableModel(DefaultTableModel model)
    {
        for (GiaoVienDTO giaovien : DashBoard.giaoVienDTOs)
        {
            Vector row = new Vector();
            row.add(giaovien.getMaGiaoVien());
            row.add(giaovien.getHoTen());
            if (giaovien.getGioiTinh().equals("1"))
            {
                row.add("Nam");
            } else
            {
                row.add("Nữ");
            }
            row.add(giaovien.getSdt());
            row.add(giaovien.getMail());
            model.addRow(row);
        }
    }

    public void clear()
    {
        jBtnCapPhatMaGV.setEnabled(true);
        jBtnThemGV.setEnabled(false);
        jBtnSuaGV.setEnabled(false);
        jBtnXoaGV.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaGiangVien.setText("");
        jTextTenGiangVien.setText("");
        jTextSDT.setText("");
        jTextEmail.setText("");
        jTableGV.clearSelection();
    }

    private void filter(String query)
    {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelGV);
        jTableGV.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelGV = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnThemGV = new javax.swing.JButton();
        jBtnSuaGV = new javax.swing.JButton();
        jBtnXoaGV = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextMaGiangVien = new javax.swing.JTextField();
        jBtnCapPhatMaGV = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTenGiangVien = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox<>();
        jTextEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGV = new javax.swing.JTable();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();
        jLbTimKiem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelGV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelGV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelGV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hồ Sơ Giảng Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jBtnThemGV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemGV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemGV.setText("Thêm");
        jBtnThemGV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemGVActionPerformed(evt);
            }
        });

        jBtnSuaGV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaGV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaGV.setText("Sửa");
        jBtnSuaGV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaGVActionPerformed(evt);
            }
        });

        jBtnXoaGV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaGV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaGV.setText("Xóa");
        jBtnXoaGV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaGVActionPerformed(evt);
            }
        });

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("Hủy");
        jBtnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> Mã Giáo Viên<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaGiangVien.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaGiangVien.setEditable(false);

        jBtnCapPhatMaGV.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaGV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaGVActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Tên Giáo Viên<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>SĐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Giới Tính <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jCbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbGioiTinhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Email<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnXoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnThemGV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnSuaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jBtnCapPhatMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jTextTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCapPhatMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTenGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThemGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelGV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 400, 410));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        jTableGV.setAutoCreateRowSorter(true);
        jTableGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGVMouseClicked(evt);
            }
        });
        tableCol.add ("Mã Giáo Viên");
        tableCol.add ("Tên Giáo Viên");
        tableCol.add ("Giới Tính");
        tableCol.add ("Số ĐT");
        tableCol.add ("Email");
        tbModelGV = new DefaultTableModel(tableCol, 10){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableGV.setModel(tbModelGV);
        jTableGV.setShowGrid(true);
        jTableGV.setFocusable(false);
        jTableGV.setIntercellSpacing(new Dimension(0,0));
        jTableGV.setRowHeight(25);
        jTableGV.getTableHeader().setOpaque(false);
        jTableGV.setFillsViewportHeight(true);
        jTableGV.getTableHeader().setBackground(new Color(232,57,99));
        jTableGV.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableGV.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableGV.setSelectionBackground(new Color(52,152,219));
        jTableGV.setGridColor(new java.awt.Color(83, 86, 88));

        jTableGV.getColumn (tableCol.elementAt (0)).setPreferredWidth (150);
        jTableGV.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTableGV.getColumn (tableCol.elementAt (2)).setPreferredWidth (120);
        jTableGV.getColumn (tableCol.elementAt (3)).setPreferredWidth (160);
        jTableGV.getColumn (tableCol.elementAt (4)).setPreferredWidth (160);
        jScrollPane2.setViewportView(jTableGV);
        jTableGV.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);

        jPanelGV.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 540, 520));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelGV.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 140, 30));

        jBtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefresh.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });
        jPanelGV.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 40, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelGV.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 30));

        jTabbedPane1.addTab("Quản Lý Giảng Viên", jPanelGV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCapPhatMaGVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaGVActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaGVActionPerformed
        // TODO add your handling code here:
//        jTextMaNhanVien.setText(ult.initMaNhanVien());
        jTextMaGiangVien.setText(giaoVienBUS.capPhat());
        jBtnCapPhatMaGV.setEnabled(false);

        jTextTenGiangVien.setText("");
        jTextSDT.setText("");
        jTextEmail.setText("");
        jTableGV.clearSelection();
        jBtnThemGV.setEnabled(true);
        jBtnSuaGV.setEnabled(false);
        jBtnXoaGV.setEnabled(false);
        jBtnHuy.setEnabled(true);

    }//GEN-LAST:event_jBtnCapPhatMaGVActionPerformed

    private void jTableGVMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableGVMouseClicked
    {//GEN-HEADEREND:event_jTableGVMouseClicked
        if (evt.getSource() == jTableGV)
        {
            selectedRow = jTableGV.getSelectedRow();
            if (selectedRow != -1)
            {
                giaoVienSelected.setMaGiaoVien((String) jTableGV.getModel().getValueAt(selectedRow, 0));
                giaoVienSelected.setHoTen((String) jTableGV.getModel().getValueAt(selectedRow, 1));
                if (jTableGV.getValueAt(selectedRow, 2).equals("Nam"))
                {
                    jCbGioiTinh.setSelectedIndex(0);
                } else
                {
                    jCbGioiTinh.setSelectedIndex(1);
                }
                giaoVienSelected.setMail((String) jTableGV.getModel().getValueAt(selectedRow, 4));
                giaoVienSelected.setSdt((String) jTableGV.getModel().getValueAt(selectedRow, 3));

                jTextTenGiangVien.setText(giaoVienSelected.getHoTen());
                jTextSDT.setText(giaoVienSelected.getSdt());
                jTextEmail.setText(giaoVienSelected.getMail());
                jTextMaGiangVien.setText(giaoVienSelected.getMaGiaoVien());

                jBtnCapPhatMaGV.setEnabled(false);
                jBtnThemGV.setEnabled(false);
                jBtnSuaGV.setEnabled(true);
                jBtnXoaGV.setEnabled(true);
                jBtnHuy.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableGVMouseClicked

    private void jBtnThemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemGVActionPerformed
        String valString = validation();
        if (valString.equals(""))
        {
            String magv = (String) jTextMaGiangVien.getText(),
                    tengv = (String) jTextTenGiangVien.getText(),
                    gioiTinh,
                    sdt = (String) jTextSDT.getText(),
                    mail = (String) jTextEmail.getText();

            Vector addRow = new Vector();
            if (jCbGioiTinh.getSelectedItem().equals("Nam"))
            {
                gioiTinh = "1";
            } else
            {
                gioiTinh = "0";
            }
//        
            GiaoVienDTO gv = new GiaoVienDTO(magv, tengv, gioiTinh, sdt, mail);
            if (giaoVienBUS.themGiaoVien(gv, DashBoard.giaoVienDTOs))
            {
                addRow = new Vector();
                addRow.add(magv);
                addRow.add(tengv);
                addRow.add(jCbGioiTinh.getSelectedItem());
                addRow.add(sdt);
                addRow.add(mail);
                tbModelGV.addRow(addRow);
                JOptionPane.showMessageDialog(this, "Thêm giáo viên thành công!");
            } else
            {
                JOptionPane.showMessageDialog(this, "Thêm giáo viên thất bại!");
            }
            clear();
        } else
        {
            JOptionPane.showMessageDialog(this, valString);
        }

    }//GEN-LAST:event_jBtnThemGVActionPerformed

    private void jBtnSuaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaGVActionPerformed
        String valString = validation();
        if (valString.equals(""))
        {
            String tengv = (String) jTextTenGiangVien.getText(),
                    sdt = (String) jTextSDT.getText(),
                    mail = (String) jTextEmail.getText(),
                    magv = (String) jTextMaGiangVien.getText();

            String gioiTinh;
            if (jCbGioiTinh.getSelectedItem().equals("Nam"))
            {
                gioiTinh = "1";
            } else
            {
                gioiTinh = "0";
            }

            GiaoVienDTO giaoVienDTO = new GiaoVienDTO(giaoVienSelected.getMaGiaoVien(), tengv, gioiTinh, sdt, mail);
            if (giaoVienBUS.suaGiaoVien(giaoVienDTO, DashBoard.giaoVienDTOs))
            {
                tbModelGV.setValueAt(magv, selectedRow, 0);
                tbModelGV.setValueAt(tengv, selectedRow, 1);
                tbModelGV.setValueAt(jCbGioiTinh.getSelectedItem(), selectedRow, 2);
                tbModelGV.setValueAt(sdt, selectedRow, 3);
                tbModelGV.setValueAt(mail, selectedRow, 4);
                JOptionPane.showMessageDialog(this, "Sửa giáo viên thành công!");
            } else
            {
                JOptionPane.showMessageDialog(this, "Sửa giáo viên thất bại!");
            }
            clear();
        } else
        {
            JOptionPane.showMessageDialog(this, valString);
        }
    }//GEN-LAST:event_jBtnSuaGVActionPerformed

    private String checkBeforeDel(String maGiaoVien)
    {
        String noti = "";
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        Date datePhancong = null;
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (GiaoVienDTO giaovien : DashBoard.giaoVienDTOs)
        {
            for (PhanCongDTO phancong : DashBoard.phanCongDTOs)
            {
                try
                {
                    datePhancong = myFormat.parse(phancong.getNgayThi());
                } catch (ParseException ex)
                {
                    Logger.getLogger(GiaoVienForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (giaovien.getMaGiaoVien().equals(maGiaoVien)
                        && giaovien.getMaGiaoVien().equals(phancong.getMaGiaoVien())
                        && datePhancong.after(date) || datePhancong.equals(date))
                {
                    noti += "- Giáo viên hiện đang được phân công!";
                    break;
                }
            }
        }

        return noti;
    }

    private void jBtnXoaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaGVActionPerformed
        String check = checkBeforeDel(giaoVienSelected.getMaGiaoVien());
        if (check.equals(""))
        {
            if (giaoVienBUS.xoaGiaoVien(giaoVienSelected, DashBoard.giaoVienDTOs))
            {
                tbModelGV.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Xóa giáo viên thành công!");
            } else
            {
                JOptionPane.showMessageDialog(this, "Xóa giáo viên thất bại!");
            }
            clear();
        } else
        {
            check = "Không thể xóa\n" + check;
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnXoaGVActionPerformed

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        clear();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jCbGioiTinhActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbGioiTinhActionPerformed
    {//GEN-HEADEREND:event_jCbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbGioiTinhActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTableGV();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

//    Vector tableRow = new Vector ();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableCol = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tableColThongKe = new Vector();

    public JPanel getjPanel1()
    {
        return jPanelGV;
    }

    public JTextField getjTextManv()
    {
        return jTextMaGiangVien;
    }

    public DefaultTableModel getModelnv()
    {
        return tbModelGV;
    }

    public JButton getjBtnCapPhatMaNV()
    {
        return jBtnCapPhatMaGV;
    }

    public int getFlagAcc()
    {
        return flagAcc;
    }

    public void setFlagAcc(int flagAcc)
    {
        this.flagAcc = flagAcc;
    }

    public String getManv()
    {
        return manv;
    }

    public void setManv(String manv)
    {
        this.manv = manv;
    }

    public JButton getjBtnRefresh()
    {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh)
    {
        this.jBtnRefresh = jBtnRefresh;
    }

    public JTabbedPane getjTabbedPane1()
    {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1)
    {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public String validation()
    {
        String validate = "";
        String tenGV = jTextTenGiangVien.getText();
        String SDT = jTextSDT.getText();
        String email = jTextEmail.getText();

        if (tenGV.equals("") || SDT.equals("") || email.equals(""))
        {
            validate += "Các trường thông tin không được bỏ trống!\n";
            return validate;
        } else
        {
            String tenPattern = "^[^-\\s][a-zA-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
            boolean flag1 = Pattern.matches(tenPattern, tenGV);
            if (!flag1)
            {
                validate += "Tên giáo viên không hợp lệ!\n";
            }

            String sdtPattern = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
            boolean flag2 = Pattern.matches(sdtPattern, SDT);
            if (!flag2)
            {
                validate += "Số điện thoại không hợp lệ!\n";
            }

            String emailPattern = "^[a-zA-Z][a-zA-Z0-9_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            boolean flag4 = Pattern.matches(emailPattern, jTextEmail.getText());
            if (!flag4)
            {
                validate += "Email không hợp lệ!\n";
            }

        }
        return validate;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaGV;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaGV;
    private javax.swing.JButton jBtnThemGV;
    private javax.swing.JButton jBtnXoaGV;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelGV;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableGV;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextMaGiangVien;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenGiangVien;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
