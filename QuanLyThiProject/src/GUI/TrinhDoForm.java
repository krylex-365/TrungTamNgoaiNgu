/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PhongThiBUS;
import BUS.ThiSinhBUS;
import BUS.TrinhDoBUS;
import BUS.Utils;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;
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
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class TrinhDoForm extends javax.swing.JPanel {

    DefaultTableModel tbModelTrinhDo, tbModelTKTD;
    int rowTbl;
    private int rowTrinhDo;
    private String tenLoaiChiPhi;
    private TrinhDoBUS trinhDoBUS;

    /**
     * Creates new form jPanel2
     */
    public TrinhDoForm() {
        initComponents();
        jBtnCapPhatMaTD.setEnabled(true);
        jBtnThemTD.setEnabled(false);
        jBtnSuaTD.setEnabled(false);
        jBtnXoaTD.setEnabled(false);
        jBtnHuy.setEnabled(false);
        tbModelTKTD.setRowCount(0);
        jBtnCapPhatMaTD.setVisible(false);
        jBtnThemTD.setVisible(false);
        jBtnXoaTD.setVisible(false);
    }

    public void initTable() {
        trinhDoBUS = new TrinhDoBUS();
        tbModelTrinhDo.setRowCount(0);
        for (TrinhDoDTO trinhDoDTO : DashBoard.trinhDoDTOs) {
            Vector<String> vector = new Vector<>();
            vector.add(trinhDoDTO.getMaTrinhDo());
            vector.add(trinhDoDTO.getTenTrinhDo());
            vector.add(trinhDoDTO.getLePhi());
            tbModelTrinhDo.addRow(vector);
        }
        jTableTrinhDo.setRowSorter(null);
        jTableTrinhDo.setAutoCreateRowSorter(true);
        jTableTrinhDo.setModel(tbModelTrinhDo);
        clear();
    }

    public void clear() {
        jBtnCapPhatMaTD.setEnabled(true);
//        jBtnThemTD.setEnabled(false);
        jBtnSuaTD.setEnabled(false);
        jBtnXoaTD.setEnabled(false);
//        jBtnHuy.setEnabled(false);
        jTextMaTD.setText("");
        jTextTenTD.setText("");
        jTextLePhi.setText("");
        jTableTrinhDo.clearSelection();
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelTrinhDo);
        jTableTrinhDo.setRowSorter(tr);
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
        jPanelKhoaThi = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextMaTD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTenTD = new javax.swing.JTextField();
        jBtnCapPhatMaTD = new javax.swing.JButton();
        jBtnThemTD = new javax.swing.JButton();
        jBtnSuaTD = new javax.swing.JButton();
        jBtnXoaTD = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTextLePhi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTrinhDo = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Trình Độ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("<html> <body> Mã Trình Độ <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaTD.setEditable(false);//[214,217,223]
        jTextMaTD.setEditable(false);
        jTextMaTD.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaTD.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("<html> <body> Tên Trình Độ<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextTenTD.setEditable(false);
        jTextTenTD.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenTD.setForeground(new java.awt.Color(51, 51, 51));

        jBtnCapPhatMaTD.setEnabled(true);
        jBtnCapPhatMaTD.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaTD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaTDActionPerformed(evt);
            }
        });

        jBtnThemTD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemTD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemTD.setText("Thêm");
        jBtnThemTD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemTDActionPerformed(evt);
            }
        });

        jBtnSuaTD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaTD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaTD.setText("Sửa");
        jBtnSuaTD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaTDActionPerformed(evt);
            }
        });

        jBtnXoaTD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaTD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaTD.setText("Xóa");
        jBtnXoaTD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaTDActionPerformed(evt);
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

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("<html> <body>Lệ Phí <span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jTextLePhi.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnSuaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnThemTD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextMaTD)
                                    .addComponent(jTextTenTD, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnCapPhatMaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextLePhi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jBtnXoaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextMaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnCapPhatMaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLePhi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThemTD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaTD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanelKhoaThi.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 410, 330));
        jPanel3.getAccessibleContext().setAccessibleName("");

        Vector tableCol=new Vector();
        tableCol.add("Mã Trình Độ");
        tableCol.add("Tên Trình Độ");
        tableCol.add("Lệ Phí");

        tbModelTrinhDo = new DefaultTableModel (tableCol,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableTrinhDo.setModel (tbModelTrinhDo);
        jTableTrinhDo.setShowGrid(true);
        jTableTrinhDo.setFocusable(false);
        jTableTrinhDo.setIntercellSpacing(new Dimension(0,0));
        jTableTrinhDo.setRowHeight(25);
        jTableTrinhDo.getTableHeader().setOpaque(false);
        jTableTrinhDo.setFillsViewportHeight(true);
        jTableTrinhDo.getTableHeader().setBackground(new Color(232,57,99));
        jTableTrinhDo.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableTrinhDo.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableTrinhDo.setSelectionBackground(new Color(52,152,219));
        jTableTrinhDo.setAutoCreateRowSorter(true);
        jTableTrinhDo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableTrinhDo.setGridColor(new java.awt.Color(83, 86, 88));
        jTableTrinhDo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTrinhDoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTrinhDo);
        jTableTrinhDo.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jPanelKhoaThi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 530, 450));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh Sách Trình Độ");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanelKhoaThi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 180, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelKhoaThi.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelKhoaThi.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 140, 30));

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
        jPanelKhoaThi.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 40, 30));

        jTabbedPane1.addTab("Quản Lý Khóa Thi", jPanelKhoaThi);

        jPanelTKKT.setBackground(new java.awt.Color(233, 242, 249));
        jPanelTKKT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelTKKT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonThongKe.setText("Thống Kê");
        jButtonThongKe.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThongKeActionPerformed(evt);
            }
        });
        jPanelTKKT.add(jButtonThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 120, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

        Vector tbColThongKe=new Vector();
        jTableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableThongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
        tbModelTKTD = new DefaultTableModel(tbColThongKe, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
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
        jBtnThemTD.setEnabled(true);
        jBtnSuaTD.setEnabled(false);
        jBtnXoaTD.setEnabled(false);
        jBtnHuy.setEnabled(true);
        jTextMaTD.setText(trinhDoBUS.util.initMaTrinhDo());
    }//GEN-LAST:event_jBtnCapPhatMaTDActionPerformed

    private void jBtnThemTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemTDActionPerformed
        // TODO add your handling code here:
        String valString = validation();
        if (valString.equals("")) {
            String maTrinhDo = jTextMaTD.getText();
            String tenTrinhDo = jTextTenTD.getText();
            String lePhi = jTextLePhi.getText();
            if (trinhDoBUS.them(maTrinhDo, tenTrinhDo, lePhi, DashBoard.trinhDoDTOs)) {
                addRow(maTrinhDo, tenTrinhDo, lePhi);
                JOptionPane.showMessageDialog(this, "Thêm trình độ thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm trình độ thất bại!");
            }
            clear();
        } else {
            JOptionPane.showMessageDialog(this, valString);
        }

    }//GEN-LAST:event_jBtnThemTDActionPerformed

    private void addRow(String maTrinhDo, String tenTrinhDo, String lePhi) {
        Vector<String> vector = new Vector<>();
        vector.add(maTrinhDo);
        vector.add(tenTrinhDo);
        vector.add(lePhi);
        tbModelTrinhDo.addRow(vector);
    }

    private void jBtnSuaTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaTDActionPerformed
        // TODO add your handling code here:
        String valString = validation();
        if (valString.equals("")) {
            String maTrinhDo = jTextMaTD.getText();
            String tenTrinhDo = jTextTenTD.getText();
            String lePhi = jTextLePhi.getText();
            if (trinhDoBUS.sua(maTrinhDo, tenTrinhDo, lePhi, DashBoard.trinhDoDTOs)) {
                updateRow(tenTrinhDo, lePhi);
                JOptionPane.showMessageDialog(this, "Sửa trình độ thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa trình độ thất bại!");
            }
            clear();
        } else {
            JOptionPane.showMessageDialog(this, valString);
        }

    }//GEN-LAST:event_jBtnSuaTDActionPerformed

    private void updateRow(String tenTrinhDo, String lePhi) {
        tbModelTrinhDo.setValueAt(tenTrinhDo, rowTrinhDo, 1);
        tbModelTrinhDo.setValueAt(lePhi, rowTrinhDo, 2);
    }

    private void jBtnXoaTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaTDActionPerformed
        // TODO add your handling code here:
        String maTrinhDo = jTextMaTD.getText();
        String check = checkXoaTrinhDo(maTrinhDo);
        if (check.equals("")) {
            if (trinhDoBUS.xoa(maTrinhDo, DashBoard.trinhDoDTOs)) {
                deleteRow();
                JOptionPane.showMessageDialog(this, "Xóa trình độ thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa trình độ thất bại!");
            }
            clear();
        } else {
            check = "Không thể xóa\n" + check;
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnXoaTDActionPerformed

    private void deleteRow() {
        tbModelTrinhDo.removeRow(rowTrinhDo);
    }

    private String checkXoaTrinhDo(String maTrinhDo) {
        for (PhongThiDTO phongThiDTO : DashBoard.phongThiDTOs) {
            if (maTrinhDo.equals(phongThiDTO.getMaTrinhDo())) {
                return "- Còn phòng thi thuộc trình độ này!";
            }
        }
        for (ThiSinhDTO thiSinhDTO : DashBoard.thiSinhDTOs) {
            if (maTrinhDo.equals(thiSinhDTO.getMaTrinhDo())) {
                return "- Còn thí sinh thuộc trình độ này!";
            }
        }
        return "";
    }

    private boolean isNullOrEmpty(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonThongKeActionPerformed
    {//GEN-HEADEREND:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jTableThongkeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThongkeMouseClicked
    {//GEN-HEADEREND:event_jTableThongkeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThongkeMouseClicked

    private void jTableTrinhDoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTrinhDoMouseClicked
    {//GEN-HEADEREND:event_jTableTrinhDoMouseClicked
        // TODO add your handling code here:
        rowTrinhDo = jTableTrinhDo.getSelectedRow();
        if (rowTrinhDo != -1) {
            jTextMaTD.setText((String) jTableTrinhDo.getModel().getValueAt(rowTrinhDo, 0));
            jTextTenTD.setText((String) jTableTrinhDo.getModel().getValueAt(rowTrinhDo, 1));
            jTextLePhi.setText((String) jTableTrinhDo.getModel().getValueAt(rowTrinhDo, 2));
//            jBtnCapPhatMaTD.setEnabled(false);
//            jBtnThemTD.setEnabled(false);
            jBtnSuaTD.setEnabled(true);
//            jBtnXoaTD.setEnabled(true);
            jBtnHuy.setEnabled(true);
        }
    }//GEN-LAST:event_jTableTrinhDoMouseClicked

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTable();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    public void xoaLoaiChiPhi(DefaultTableModel model, int row) {
        model.removeRow(row);
    }

    public void timKiem(DefaultTableModel model, JTable jTable, String value) {
        model.setRowCount(0);
    }

    public String validation() {
        String validate = "";
        StringBuilder message = new StringBuilder();
        if (jTextTenTD.getText().equals("") || jTextLePhi.getText().equals("")) {
            validate += "Các trường thông tin không được bỏ trống!\n";
            return validate;
        } else {
            String tenPattern = "^[^-\\s][a-zA-Z0-9 ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";

            boolean flag1 = Pattern.matches(tenPattern, jTextTenTD.getText());
            if (!flag1) {
                validate += "Tên trình độ không hợp lệ!\n";
            }
            String lePhiPattern = "\\d+";
            if (!Pattern.matches(lePhiPattern, jTextLePhi.getText()) || Integer.valueOf(jTextLePhi.getText()) < 0) {
                validate += "Lệ phí thi không hợp lệ!\n";
            }
        }
        return validate;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaTD;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaTD;
    private javax.swing.JButton jBtnThemTD;
    private javax.swing.JButton jBtnXoaTD;
    private javax.swing.JButton jButtonThongKe;
    private com.toedter.calendar.JDateChooser jDateNgayBDTK;
    private com.toedter.calendar.JDateChooser jDateNgayKTTK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelKhoaThi;
    private javax.swing.JPanel jPanelTKKT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableThongke;
    private javax.swing.JTable jTableTrinhDo;
    private javax.swing.JTextField jTextLePhi;
    private javax.swing.JTextField jTextMaTD;
    private javax.swing.JTextField jTextTenTD;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
