/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhoaThiBUS;
import DTO.KhoaThiDTO;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
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
public class KhoaThiForm extends javax.swing.JPanel {

    DefaultTableModel tbModelKhoaThi, tbModelTKKT;
    private int rowKhoaThi;
    private KhoaThiDTO khoaThiSelected = new KhoaThiDTO();
    KhoaThiBUS khoaThiBUS = new KhoaThiBUS();

    /**
     * Creates new form jPanel2
     */
    public KhoaThiForm() {
        initComponents();
        jBtnCapPhatMaKT.setEnabled(true);
        jBtnThemKT.setEnabled(false);
        jBtnSuaKT.setEnabled(false);
        jBtnXoaKT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        tbModelTKKT.setRowCount(0);
    }

    public void initTable() {
        tbModelKhoaThi.setRowCount(0);
        tableModel(tbModelKhoaThi);
        jTableKhoaThi.setRowSorter(null);
        jTableKhoaThi.setAutoCreateRowSorter(true);
        jTableKhoaThi.setModel(tbModelKhoaThi);
        clear();
    }

    public void tableModel(DefaultTableModel model) {
        for (KhoaThiDTO khoaThi : DashBoard.khoaThiDTOs) {
            Vector row = new Vector();
            row.add(khoaThi.getMaKhoaThi());
            row.add(khoaThi.getTenKhoaThi());
            row.add(khoaThi.getNgayThi());
            model.addRow(row);
        }
    }

    public void themVector(DefaultTableModel model, KhoaThiDTO khoaThiDTO) {
        Vector newrow = new Vector();
        newrow.add(khoaThiDTO.getMaKhoaThi());
        newrow.add(khoaThiDTO.getTenKhoaThi());
        newrow.add(khoaThiDTO.getNgayThi());
        model.addRow(newrow);
    }

    public void suaVector(DefaultTableModel model, int row, KhoaThiDTO khoaThiDTO) {
        model.setValueAt(khoaThiDTO.getTenKhoaThi(), row, 1);
        model.setValueAt(khoaThiDTO.getNgayThi(), row, 2);
    }

    public void xoaVector(DefaultTableModel model, int row) {
        model.removeRow(row);
    }
    
    public void clear() {
        jBtnCapPhatMaKT.setEnabled(true);
        jBtnThemKT.setEnabled(false);
        jBtnSuaKT.setEnabled(false);
        jBtnXoaKT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaKT.setText("");
        jTextTenKT.setText("");
        jDateNgayThi.setCalendar(null);
        jTableKhoaThi.clearSelection();
    }
    
    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelKhoaThi);
        jTableKhoaThi.setRowSorter(tr);
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
        jTextMaKT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTenKT = new javax.swing.JTextField();
        jBtnCapPhatMaKT = new javax.swing.JButton();
        jBtnThemKT = new javax.swing.JButton();
        jBtnSuaKT = new javax.swing.JButton();
        jBtnXoaKT = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jDateNgayThi = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhoaThi = new javax.swing.JTable();
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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khóa Thi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("<html> <body> Mã Khóa Thi  <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaKT.setEditable(false);//[214,217,223]
        jTextMaKT.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaKT.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("<html> <body> Tên Khóa Thi<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextTenKT.setForeground(new java.awt.Color(51, 51, 51));

        jBtnCapPhatMaKT.setEnabled(true);
        jBtnCapPhatMaKT.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaKTActionPerformed(evt);
            }
        });

        jBtnThemKT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemKT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemKT.setText("Thêm");
        jBtnThemKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemKTActionPerformed(evt);
            }
        });

        jBtnSuaKT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaKT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaKT.setText("Sửa");
        jBtnSuaKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaKTActionPerformed(evt);
            }
        });

        jBtnXoaKT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaKT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaKT.setText("Xóa");
        jBtnXoaKT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaKTActionPerformed(evt);
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

        jDateNgayThi.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayThi.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateNgayThi.getDateEditor();
        editor.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("<html> <body>Ngày Thi<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

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
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextMaKT)
                                    .addComponent(jTextTenKT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnCapPhatMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnSuaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jDateNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnThemKT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnXoaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnCapPhatMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenKT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnThemKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnXoaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanelKhoaThi.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 410, 330));
        jPanel3.getAccessibleContext().setAccessibleName("");

        Vector tableCol=new Vector();
        tableCol.add("Mã Khóa Thi");
        tableCol.add("Tên Khóa Thi");
        tableCol.add("Ngày Thi");

        tbModelKhoaThi = new DefaultTableModel (tableCol,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableKhoaThi.setModel (tbModelKhoaThi);
        jTableKhoaThi.setShowGrid(true);
        jTableKhoaThi.setFocusable(false);
        jTableKhoaThi.setIntercellSpacing(new Dimension(0,0));
        jTableKhoaThi.setRowHeight(25);
        jTableKhoaThi.getTableHeader().setOpaque(false);
        jTableKhoaThi.setFillsViewportHeight(true);
        jTableKhoaThi.getTableHeader().setBackground(new Color(232,57,99));
        jTableKhoaThi.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableKhoaThi.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableKhoaThi.setSelectionBackground(new Color(52,152,219));
        jTableKhoaThi.setAutoCreateRowSorter(true);
        jTableKhoaThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableKhoaThi.setGridColor(new java.awt.Color(83, 86, 88));
        jTableKhoaThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhoaThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhoaThi);
        jTableKhoaThi.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jPanelKhoaThi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 530, 450));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh Sách Khóa Thi");
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
        tbModelTKKT = new DefaultTableModel(tbColThongKe, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableThongke.setModel(tbModelTKKT);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tbModelTKKT);
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

    private void jBtnCapPhatMaKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaKTActionPerformed
        // TODO add your handling code here:
        jTextMaKT.setText(khoaThiBUS.capPhat());
        jBtnCapPhatMaKT.setEnabled(false);
        jBtnThemKT.setEnabled(true);
        jBtnSuaKT.setEnabled(false);
        jBtnXoaKT.setEnabled(false);
        jBtnHuy.setEnabled(true);
    }//GEN-LAST:event_jBtnCapPhatMaKTActionPerformed

    private void jBtnThemKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemKTActionPerformed
        // TODO add your handling code here:
        String maKhoaThi = (String) jTextMaKT.getText(),
                tenKhoaThi = (String) jTextTenKT.getText(),
                ngayThi = (String) ((JTextField) jDateNgayThi.getDateEditor().getUiComponent()).getText();
        KhoaThiDTO khoaThiDTO = new KhoaThiDTO(maKhoaThi, tenKhoaThi, ngayThi);
        if (khoaThiBUS.them(khoaThiDTO, DashBoard.khoaThiDTOs)) {
            themVector(tbModelKhoaThi, khoaThiDTO);
            JOptionPane.showMessageDialog(this, "Thêm khóa thi thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm khóa thi thất bại!");
        }
        clear();
    }//GEN-LAST:event_jBtnThemKTActionPerformed


    private void jBtnSuaKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaKTActionPerformed
        // TODO add your handling code here:
        String tenKhoaThi = (String) jTextTenKT.getText(),
                ngayThi = (String) ((JTextField) jDateNgayThi.getDateEditor().getUiComponent()).getText();
        KhoaThiDTO khoaThiDTO = new KhoaThiDTO(khoaThiSelected.getMaKhoaThi(), tenKhoaThi, ngayThi);
        if (khoaThiBUS.sua(khoaThiDTO, DashBoard.khoaThiDTOs)) {
            suaVector(tbModelKhoaThi, rowKhoaThi, khoaThiDTO);
            JOptionPane.showMessageDialog(this, "Sửa khóa thi thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa khóa thi thất bại!");
        }
        clear();
    }//GEN-LAST:event_jBtnSuaKTActionPerformed

    public String checkBeforeDel(String maKhoaThi) {
        String noti = "";
        for (PhongThiDTO p : DashBoard.phongThiDTOs) {
            System.out.println(p);
            if (p.getMaKhoaThi().equals(maKhoaThi)) {
                noti += "- Còn phòng thi thuộc khóa thi này!\n";
                break;
            }
        }
        for (ThiSinhDTO ts : DashBoard.thiSinhDTOs) {
            if (ts.getMaKhoaThi().equals(maKhoaThi)) {
                noti += "- Còn thí sinh thuộc khóa thi này!\n";
                break;
            }
        }
        return noti;
    }
    
    private void jBtnXoaKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaKTActionPerformed
        // TODO add your handling code here:
        String check = checkBeforeDel(khoaThiSelected.getMaKhoaThi());
        if (check.equals("")) {
            if (khoaThiBUS.xoa(khoaThiSelected, DashBoard.khoaThiDTOs)) {
                xoaVector(tbModelKhoaThi, rowKhoaThi);
                JOptionPane.showMessageDialog(this, "Xóa khóa thi thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa khóa thi thất bại!");
            }
            clear();
        } else {
            check = "Không thể xóa\n" + check;
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnXoaKTActionPerformed

    private boolean isNullOrEmpty(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonThongKeActionPerformed
    {//GEN-HEADEREND:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jTableThongkeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThongkeMouseClicked
    {//GEN-HEADEREND:event_jTableThongkeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThongkeMouseClicked

    private void jTableKhoaThiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKhoaThiMouseClicked
    {//GEN-HEADEREND:event_jTableKhoaThiMouseClicked
        // TODO add your handling code here:
        rowKhoaThi = jTableKhoaThi.getSelectedRow();
        if (rowKhoaThi != -1) {
            khoaThiSelected.setMaKhoaThi((String) jTableKhoaThi.getModel().getValueAt(rowKhoaThi, 0));
            khoaThiSelected.setTenKhoaThi((String) jTableKhoaThi.getModel().getValueAt(rowKhoaThi, 1));
            jTextMaKT.setText(khoaThiSelected.getMaKhoaThi());
            jTextTenKT.setText(khoaThiSelected.getTenKhoaThi());
            try {
                String ngayThi = jTableKhoaThi.getModel().getValueAt(rowKhoaThi, 2).toString();
                khoaThiSelected.setNgayThi(ngayThi);
                Date dateThi = new SimpleDateFormat("yyyy-MM-dd").parse(ngayThi);
                jDateNgayThi.setDate(dateThi);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
                System.out.println("- Load sai ngày thi!");
            }
            jBtnCapPhatMaKT.setEnabled(false);
            jBtnThemKT.setEnabled(false);
            jBtnSuaKT.setEnabled(true);
            jBtnXoaKT.setEnabled(true);
            jBtnHuy.setEnabled(true);
        }
    }//GEN-LAST:event_jTableKhoaThiMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaKT;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaKT;
    private javax.swing.JButton jBtnThemKT;
    private javax.swing.JButton jBtnXoaKT;
    private javax.swing.JButton jButtonThongKe;
    private com.toedter.calendar.JDateChooser jDateNgayBDTK;
    private com.toedter.calendar.JDateChooser jDateNgayKTTK;
    private com.toedter.calendar.JDateChooser jDateNgayThi;
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
    private javax.swing.JTable jTableKhoaThi;
    private javax.swing.JTable jTableThongke;
    private javax.swing.JTextField jTextMaKT;
    private javax.swing.JTextField jTextTenKT;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
