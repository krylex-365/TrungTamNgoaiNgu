/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.CongViecBUS;
import DTO.PhieuBaoDuThiDTO;
import DTO.ThiSinhDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import BUS.NhanVienBUS;
//import BUS.NhanVienCongViecBUS;
//import BUS.PhongBanBUS;
//import DTO.NhanVienDTO;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Hyung
 */
public class BangThiSinh extends javax.swing.JFrame {

    /**
     * Creates new form DSNV
     */
    int rowTbl;

    Vector tbCol = new Vector();
    DefaultTableModel tbModel;
    PhongThiForm phongThiForm;

    public BangThiSinh() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        jBtnXacNhan.setEnabled(true);
        jBtnQuayLai.setEnabled(true);
    }
    
    public void tableModel(ArrayList<ThiSinhDTO> thiSinhDTOs) {
        tbModel.setRowCount(0);
        System.out.println("Row count : "+thiSinhDTOs.size());
        Vector row = null;
        for (ThiSinhDTO thisinh : thiSinhDTOs) {
            row = new Vector();
            row.add(thisinh.getMaKhoaThi());
            row.add(thisinh.getMaThiSinh());
            row.add(thisinh.getHoTen());
            

            // bỏ tên trình độ vào đây
            row.add(thisinh.getMaTrinhDo());
            
            
            switch (thisinh.getTinhTrang()){
                case 1:
                    row.add("Chưa đóng tiền");
                    break;
                case 2:
                    row.add("Đã đóng tiền");
                    break;    
            }
            
            tbModel.addRow(row);

        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        jLbManv = new javax.swing.JLabel();
        jTextMaTS = new javax.swing.JTextField();
        jLbHonv = new javax.swing.JLabel();
        jTextTenTS = new javax.swing.JTextField();
        jBtnQuayLai = new javax.swing.JButton();
        jBtnXacNhan = new javax.swing.JButton();
        jLbHonv1 = new javax.swing.JLabel();
        jTextTrinhDo = new javax.swing.JTextField();
        jLbManv1 = new javax.swing.JLabel();
        jTextMaKhoaThi = new javax.swing.JTextField();
        jLbHonv2 = new javax.swing.JLabel();
        jTextTinhTrang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThiSinh = new javax.swing.JTable();
        jTextTimKiemNV = new javax.swing.JTextField();
        jBtnTimKiemNV = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 245, 252));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        setType(java.awt.Window.Type.POPUP);

        kGradientPanel1.setkEndColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setkStartColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel4.setBackground(new java.awt.Color(236, 245, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Thí Sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbManv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv.setText("<html> <body> Mã Thí Sinh<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jTextMaTS.setEditable(false);
        jTextMaTS.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaTS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextMaTSActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 204, 30));

        jLbHonv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbHonv.setText("<html><body>Tên Thí Sinh<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbHonv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        jTextTenTS.setEditable(false);
        jTextTenTS.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenTS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTenTSActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTenTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 204, 30));

        jBtnQuayLai.setBackground(new java.awt.Color(136, 193, 184));
        jBtnQuayLai.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back1_16.png"))); // NOI18N
        jBtnQuayLai.setText("Thoát");
        jBtnQuayLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnQuayLai.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnQuayLaiActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 140, 40));

        jBtnXacNhan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXacNhan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_checked_16.png"))); // NOI18N
        jBtnXacNhan.setText("Xác nhận");
        jBtnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXacNhan.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXacNhanActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 40));

        jLbHonv1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbHonv1.setText("<html><body>Trình Độ<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbHonv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

        jTextTrinhDo.setEditable(false);
        jTextTrinhDo.setForeground(new java.awt.Color(51, 51, 51));
        jTextTrinhDo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTrinhDoActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTrinhDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 204, 30));

        jLbManv1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv1.setText("<html> <body> Mã Khóa Thi<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jTextMaKhoaThi.setEditable(false);
        jTextMaKhoaThi.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaKhoaThi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextMaKhoaThiActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaKhoaThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 204, 30));

        jLbHonv2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbHonv2.setText("<html><body>Tình Trạng<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbHonv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        jTextTinhTrang.setEditable(false);
        jTextTinhTrang.setForeground(new java.awt.Color(51, 51, 51));
        jTextTinhTrang.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTinhTrangActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 204, 30));

        jTableThiSinh.setAutoCreateRowSorter(true);
        jTableThiSinh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableThiSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        tbCol.add("Mă Khóa Thi");
        tbCol.add("Mă Thí Sinh");
        tbCol.add("Tên Thí Sinh");
        tbCol.add("Trình Độ");
        tbCol.add("Tình Trạng");
        tbModel= new DefaultTableModel(tbCol,10);
        jTableThiSinh.setModel (tbModel);
        jTableThiSinh.setShowGrid(true);
        jTableThiSinh.setFocusable(false);
        jTableThiSinh.setIntercellSpacing(new Dimension(0,0));
        jTableThiSinh.setRowHeight(25);
        jTableThiSinh.getTableHeader().setOpaque(false);
        jTableThiSinh.setFillsViewportHeight(true);
        jTableThiSinh.getTableHeader().setBackground(new Color(232,57,99));
        jTableThiSinh.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableThiSinh.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableThiSinh.setSelectionBackground(new Color(52,152,219));
        jTableThiSinh.setRowSelectionAllowed(true);
        jTableThiSinh.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableThiSinh.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableThiSinhMouseClicked(evt);
            }
        });
        jTableThiSinh.getColumn (tbCol.elementAt (0)).setPreferredWidth (120);
        jTableThiSinh.getColumn (tbCol.elementAt (1)).setPreferredWidth (130);
        jTableThiSinh.getColumn (tbCol.elementAt (2)).setPreferredWidth (170);
        jTableThiSinh.getColumn (tbCol.elementAt (3)).setPreferredWidth (100);
        jTableThiSinh.getColumn (tbCol.elementAt (4)).setPreferredWidth (130);
        jTableThiSinh.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableThiSinh);

        jBtnTimKiemNV.setText("Tìm kiếm");
        jBtnTimKiemNV.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnTimKiemNVActionPerformed(evt);
            }
        });

        jBtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefresh.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel4.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnQuayLaiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnQuayLaiActionPerformed
    {//GEN-HEADEREND:event_jBtnQuayLaiActionPerformed
        jTextMaTS.setText("");
        jTextTenTS.setText("");
        dispose();
//        jTextTennv.setText("");
//        jTextPban.setText("");
//        jTextCviec.setText("");
    }//GEN-LAST:event_jBtnQuayLaiActionPerformed

    private void jTextTenTSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenTSActionPerformed
    {//GEN-HEADEREND:event_jTextTenTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenTSActionPerformed

    private void jTextMaTSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextMaTSActionPerformed
    {//GEN-HEADEREND:event_jTextMaTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaTSActionPerformed
    public String ktra() {
        String temp = "";
//        if (jTextMaNV.getText().equals("")) {
//            temp += "- Vui lòng chọn loại hình!";
//        }
        return temp;
    }
    private void jBtnXacNhanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXacNhanActionPerformed
    {//GEN-HEADEREND:event_jBtnXacNhanActionPerformed
        if (jTableThiSinh.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty!!");
        } else {

            System.out.println(jTableThiSinh.getSelectedRowCount());
            //ArrayList<String> a = new ArrayList<>();
            for (int i = 0; i < jTableThiSinh.getRowCount(); i++) {
                if (jTableThiSinh.getSelectionModel().isSelectedIndex(i)) {
                    //a.add((String) jTableThiSinh.getModel().getValueAt(i, 1));
                    ThiSinhDTO thiSinh = phongThiForm.thiSinhBUS.findByMaThiSinh((String) jTableThiSinh.getModel().getValueAt(i, 1));
                    PhieuBaoDuThiDTO pbdt;
                    if((pbdt = phongThiForm.phieuBaoDuThiBUS.Add(phongThiForm.phongThi, thiSinh, phongThiForm.caThi.getMaCaThi(), DashBoard.phieuBaoDuThiDTOs, DashBoard.trinhDoDTOs, DashBoard.khoaThiDTOs))!= null){
                        if(phongThiForm.thiSinhBUS.UpdataStatus(thiSinh.getMaThiSinh(), 3,DashBoard.thiSinhDTOs)){
                            Vector row = new Vector();
                            row.add(thiSinh.getMaThiSinh());
                            row.add(thiSinh.getHoTen());
                            row.add(pbdt.getSoBaoDanh());
                            row.add("Chưa thi");
                            phongThiForm.tbModelPTTS.addRow(row);
                            JOptionPane.showMessageDialog(this, "Thêm thí sinh thành công!");
                            dispose();
                            phongThiForm.clearPhongThiTS();
                        } else {
                            JOptionPane.showMessageDialog(this, "Thêm thí sinh thất bại!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtnXacNhanActionPerformed

    private void jTableThiSinhMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThiSinhMouseClicked
    {//GEN-HEADEREND:event_jTableThiSinhMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jTableThiSinh) {
            rowTbl = jTableThiSinh.getSelectedRow();
            if (rowTbl != -1) {
                jTextMaKhoaThi.setText((String) jTableThiSinh.getValueAt(rowTbl, 0));
                jTextMaTS.setText((String) jTableThiSinh.getValueAt(rowTbl, 1));
                jTextTenTS.setText((String) jTableThiSinh.getValueAt(rowTbl, 2));
                jTextTrinhDo.setText((String) jTableThiSinh.getValueAt(rowTbl, 3));
                jTextTinhTrang.setText((String) jTableThiSinh.getValueAt(rowTbl, 4));
                jBtnXacNhan.setEnabled(true);
                jBtnQuayLai.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableThiSinhMouseClicked

    private void jBtnTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimKiemNVActionPerformed
//        // TODO add your handling code here:
//        String manv = jTextTimKiemNV.getText();
//        if (manv.equals(""))
//        {
//            JOptionPane.showMessageDialog(this, "Má»i nháº­p mÃ£ nhÃ¢n viÃªn cáº§n tÃ¬m");
//        }
//        ArrayList<NhanVienDTO> temp = new ArrayList<NhanVienDTO>(nvBUS.getDsnv().getDsnv());
//        for (int i = 0; i < temp.size(); i++)
//        {
//            if (!(temp.get(i).getManhanvien().equalsIgnoreCase(manv)))
//            {
//                temp.remove(i);
//                i = i - 1;
//            }
//        }
//        searchlistSP(temp);
//        System.out.println("click tim kiem");
    }//GEN-LAST:event_jBtnTimKiemNVActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiemNV.setText("");
        jBtnXacNhan.setEnabled(false);
        jBtnRefresh.setEnabled(true);
        jBtnQuayLai.setEnabled(false);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jTextTrinhDoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTrinhDoActionPerformed
    {//GEN-HEADEREND:event_jTextTrinhDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTrinhDoActionPerformed

    private void jTextMaKhoaThiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextMaKhoaThiActionPerformed
    {//GEN-HEADEREND:event_jTextMaKhoaThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaKhoaThiActionPerformed

    private void jTextTinhTrangActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTinhTrangActionPerformed
    {//GEN-HEADEREND:event_jTextTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTinhTrangActionPerformed

//    public void searchlistSP(ArrayList<NhanVienDTO> nv)
//    {
//        tbModel.setRowCount(0);
//        outModel(tbModel, nv);
//    }
//    public String getTextFieldContent()
//    {
//        return bccForm.getjTextManv().getText();
//    }
//    public String getTextFieldContentLuong()
//    {
//        return luongForm.getjTextManv().getText();
//    }
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
            java.util.logging.Logger.getLogger(BangThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BangThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BangThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BangThiSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BangThiSinh().setVisible(true);
            }
        });
    }

    public JButton getjBtnQuayLai() {
        return jBtnQuayLai;
    }

    public void setjBtnQuayLai(JButton jBtnQuayLai) {
        this.jBtnQuayLai = jBtnQuayLai;
    }

    public JButton getjBtnRefresh() {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh) {
        this.jBtnRefresh = jBtnRefresh;
    }

    public JButton getjBtnTimKiemNV() {
        return jBtnTimKiemNV;
    }

    public void setjBtnTimKiemNV(JButton jBtnTimKiemNV) {
        this.jBtnTimKiemNV = jBtnTimKiemNV;
    }

    public JButton getjBtnXacNhan() {
        return jBtnXacNhan;
    }

    public void setjBtnXacNhan(JButton jBtnXacNhan) {
        this.jBtnXacNhan = jBtnXacNhan;
    }

    public JTable getjTableDsnv() {
        return jTableThiSinh;
    }

    public void setjTableDsnv(JTable jTableDsnv) {
        this.jTableThiSinh = jTableDsnv;
    }

    public JTextField getjTextTimKiemNV() {
        return jTextTimKiemNV;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV) {
        this.jTextTimKiemNV = jTextTimKiemNV;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnQuayLai;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnTimKiemNV;
    private javax.swing.JButton jBtnXacNhan;
    private javax.swing.JLabel jLbHonv;
    private javax.swing.JLabel jLbHonv1;
    private javax.swing.JLabel jLbHonv2;
    private javax.swing.JLabel jLbManv;
    private javax.swing.JLabel jLbManv1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThiSinh;
    private javax.swing.JTextField jTextMaKhoaThi;
    private javax.swing.JTextField jTextMaTS;
    private javax.swing.JTextField jTextTenTS;
    private javax.swing.JTextField jTextTimKiemNV;
    private javax.swing.JTextField jTextTinhTrang;
    private javax.swing.JTextField jTextTrinhDo;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
