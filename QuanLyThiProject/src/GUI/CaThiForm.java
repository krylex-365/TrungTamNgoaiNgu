/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class CaThiForm extends javax.swing.JPanel
{

    DefaultTableModel tbModelCaThi, tbModelTKTD;
    int rowTbl;
    private int rowChiPhi;
    private String maLoaiChiPhi;
    private String tenLoaiChiPhi;

    /**
     * Creates new form jPanel2
     */
    public CaThiForm()
    {
        initComponents();
        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        tbModelTKTD.setRowCount(0);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelKhoaThi = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextMaCT = new javax.swing.JTextField();
        jBtnCapPhatMaTD = new javax.swing.JButton();
        jBtnThemCT = new javax.swing.JButton();
        jBtnSuaCT = new javax.swing.JButton();
        jBtnXoaCT = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jComboPhut1 = new javax.swing.JComboBox<>();
        jComboPhut2 = new javax.swing.JComboBox<>();
        jComboGio1 = new javax.swing.JComboBox<>();
        jComboGio2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCaThi = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextTimKiemCT = new javax.swing.JTextField();
        jBtnTimKiemCT = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jPanelTKKT = new javax.swing.JPanel();
        jButtonThongKe = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableThongke = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jDateNgayBDTK = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jDateNgayKTTK = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));

        jPanelKhoaThi.setBackground(new java.awt.Color(233, 242, 249));
        jPanelKhoaThi.setPreferredSize(new java.awt.Dimension(960, 580));
        jPanelKhoaThi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Ca Thi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel2.setText("<html> <body> Mã Ca Thi <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jTextMaCT.setEditable(false);//[214,217,223]
        jTextMaCT.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaCT.setForeground(new java.awt.Color(51, 51, 51));

        jBtnCapPhatMaTD.setEnabled(true);
        jBtnCapPhatMaTD.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaTD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaTD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnCapPhatMaTDActionPerformed(evt);
            }
        });

        jBtnThemCT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemCT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemCT.setText("Thêm");
        jBtnThemCT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemCT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnThemCTActionPerformed(evt);
            }
        });

        jBtnSuaCT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaCT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaCT.setText("Sửa");
        jBtnSuaCT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaCT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnSuaCTActionPerformed(evt);
            }
        });

        jBtnXoaCT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaCT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaCT.setText("Xóa");
        jBtnXoaCT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaCT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXoaCTActionPerformed(evt);
            }
        });

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("Hủy");
        jBtnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnHuyActionPerformed(evt);
            }
        });

        jLabel29.setText("<html> <body>Giờ Băt Đầu<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel30.setText("<html> <body>Giờ Kết Thúc<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jComboPhut1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jComboPhut2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jComboGio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));

        jComboGio2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboGio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboGio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboPhut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboPhut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jBtnSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextMaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCapPhatMaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextMaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnCapPhatMaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboPhut1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboPhut2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboGio1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboGio2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelKhoaThi.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 410, 340));
        jPanel3.getAccessibleContext().setAccessibleName("");

        Vector tableCol=new Vector();
        tableCol.add("Mã Ca Thi");
        tableCol.add("Giờ Bắt Đầu");
        tableCol.add("Giờ Kết Thúc");

        tbModelCaThi = new DefaultTableModel (tableCol,5)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableCaThi.setModel (tbModelCaThi);
        jTableCaThi.setShowGrid(true);
        jTableCaThi.setFocusable(false);
        jTableCaThi.setIntercellSpacing(new Dimension(0,0));
        jTableCaThi.setRowHeight(25);
        jTableCaThi.getTableHeader().setOpaque(false);
        jTableCaThi.setFillsViewportHeight(true);
        jTableCaThi.getTableHeader().setBackground(new Color(232,57,99));
        jTableCaThi.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableCaThi.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableCaThi.setSelectionBackground(new Color(52,152,219));
        jTableCaThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCaThi.setGridColor(new java.awt.Color(83, 86, 88));
        jTableCaThi.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableCaThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCaThi);
        jTableCaThi.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jPanelKhoaThi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 530, 450));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh Sách Ca Thi");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanelKhoaThi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 180, 30));
        jPanelKhoaThi.add(jTextTimKiemCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 160, 30));

        jBtnTimKiemCT.setText("Tìm kiếm");
        jBtnTimKiemCT.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnTimKiemCTActionPerformed(evt);
            }
        });
        jPanelKhoaThi.add(jBtnTimKiemCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 80, 30));

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
        jPanelKhoaThi.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 40, 30));

        jTabbedPane1.addTab("Quản Lý Khóa Thi", jPanelKhoaThi);

        jPanelTKKT.setBackground(new java.awt.Color(233, 242, 249));
        jPanelTKKT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelTKKT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonThongKe.setText("Thống Kê");
        jButtonThongKe.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonThongKeActionPerformed(evt);
            }
        });
        jPanelTKKT.add(jButtonThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 120, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

        Vector tbColThongKe=new Vector();
        jTableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTableThongke.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableThongkeMouseClicked(evt);
            }
        });
        tbColThongKe.add ("Mã Tour");
        tbColThongKe.add ("Tên Tour");
        tbColThongKe.add ("Mã Đoàn");
        tbColThongKe.add ("Tên Đoàn");
        tbColThongKe.add ("Ngày Đi");
        tbColThongKe.add ("Ngày Về");
        tbColThongKe.add ("Tổng Chi Phí");
        tbModelTKTD = new DefaultTableModel(tbColThongKe, 0)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableThongke.setModel(tbModelTKTD);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tbModelTKTD);
        jTableThongke.setRowSorter(rowSorter);
        jTableThongke.setShowGrid(true);
        jTableThongke.setFocusable(false);
        jTableThongke.setIntercellSpacing(new Dimension(0,0));
        jTableThongke.setRowHeight(25);
        jTableThongke.getTableHeader().setOpaque(false);
        jTableThongke.setFillsViewportHeight(true);
        jTableThongke.getTableHeader().setBackground(new Color(232,57,99));
        jTableThongke.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableThongke.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableThongke.setSelectionBackground(new Color(52,152,219));
        jTableThongke.setGridColor(new java.awt.Color(83, 86, 88));
        jScrollPane3.setViewportView(jTableThongke);

        jPanelTKKT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 950, 520));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Băt Đầu<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelTKKT.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jDateNgayBDTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayBDTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateNgayBDTK.getDateEditor();
        editor2.setEditable(false);
        jPanelTKKT.add(jDateNgayBDTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelTKKT.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 30));

        jDateNgayKTTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKTTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor3 = (JTextFieldDateEditor) jDateNgayKTTK.getDateEditor();
        editor3.setEditable(false);
        jPanelTKKT.add(jDateNgayKTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 180, 30));

        jTabbedPane1.addTab("Thống Kê", jPanelTKKT);

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

    private void jBtnCapPhatMaTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaTDActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaTD.setEnabled(false);
        jBtnThemCT.setEnabled(true);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(true);

    }//GEN-LAST:event_jBtnCapPhatMaTDActionPerformed

    private void jBtnThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemCTActionPerformed
        // TODO add your handling code here:

        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaCT.setText("");
  
        jTableCaThi.clearSelection();
    }//GEN-LAST:event_jBtnThemCTActionPerformed


    private void jBtnSuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaCTActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaCT.setText("");
     
        jTableCaThi.clearSelection();
    }//GEN-LAST:event_jBtnSuaCTActionPerformed

    private void jBtnXoaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaCTActionPerformed
        // TODO add your handling code here:

        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaCT.setText("");
       
        jTableCaThi.clearSelection();
    }//GEN-LAST:event_jBtnXoaCTActionPerformed

    private boolean isNullOrEmpty(String text)
    {
        if (text == null || text.equals(""))
        {
            return true;
        }
        return false;
    }

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaCT.setText("");
        jTableCaThi.clearSelection();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonThongKeActionPerformed
    {//GEN-HEADEREND:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jTableThongkeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThongkeMouseClicked
    {//GEN-HEADEREND:event_jTableThongkeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThongkeMouseClicked

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefreshActionPerformed
    {//GEN-HEADEREND:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextMaCT.setText("");
        jTextTimKiemCT.setText("");
        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(false);
        jBtnXoaCT.setEnabled(false);
        jBtnHuy.setEnabled(false);

    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jBtnTimKiemCTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnTimKiemCTActionPerformed
    {//GEN-HEADEREND:event_jBtnTimKiemCTActionPerformed
        // TODO add your handling code here:
        //Tìm kiếm = mã hoặc like tên
        timKiem(tbModelCaThi, jTableCaThi, jTextTimKiemCT.getText());
    }//GEN-LAST:event_jBtnTimKiemCTActionPerformed

    private void jTableCaThiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableCaThiMouseClicked
    {//GEN-HEADEREND:event_jTableCaThiMouseClicked
        // TODO add your handling code here:
        rowChiPhi = jTableCaThi.getSelectedRow();
        if (rowChiPhi != -1)
        {
//            maLoaiChiPhi = (String) jTableCaThi.getModel().getValueAt(rowChiPhi, 0);
//            tenLoaiChiPhi = (String) jTableCaThi.getModel().getValueAt(rowChiPhi, 1);
//            if (!maLoaiChiPhi.equals("null"))
//            {
//                jTextMaCT.setText(maLoaiChiPhi);
//            }
        }
        jBtnCapPhatMaTD.setEnabled(false);
        jBtnThemCT.setEnabled(false);
        jBtnSuaCT.setEnabled(true);
        jBtnXoaCT.setEnabled(true);
        jBtnHuy.setEnabled(true);
    }//GEN-LAST:event_jTableCaThiMouseClicked

    public void xoaLoaiChiPhi(DefaultTableModel model, int row)
    {
        model.removeRow(row);
    }

    public void timKiem(DefaultTableModel model, JTable jTable, String value)
    {
        model.setRowCount(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaTD;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaCT;
    private javax.swing.JButton jBtnThemCT;
    private javax.swing.JButton jBtnTimKiemCT;
    private javax.swing.JButton jBtnXoaCT;
    private javax.swing.JButton jButtonThongKe;
    private javax.swing.JComboBox<String> jComboGio1;
    private javax.swing.JComboBox<String> jComboGio2;
    private javax.swing.JComboBox<String> jComboPhut1;
    private javax.swing.JComboBox<String> jComboPhut2;
    private com.toedter.calendar.JDateChooser jDateNgayBDTK;
    private com.toedter.calendar.JDateChooser jDateNgayKTTK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelKhoaThi;
    private javax.swing.JPanel jPanelTKKT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCaThi;
    private javax.swing.JTable jTableThongke;
    private javax.swing.JTextField jTextMaCT;
    private javax.swing.JTextField jTextTimKiemCT;
    // End of variables declaration//GEN-END:variables
}
