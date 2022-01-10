/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.*;
//import DTO.DoanDuLichDTO;
//import DTO.NhanVienDTO;
//import DTO.NhiemVuNhanVienDTO;
//import DAO.XuatExcel;
//import DTO.ChucVuDTO;
//import DTO.CongViecDTO;
//import DTO.PhongBanDTO;
import BUS.KetQuaThiBUS;
import DTO.DataThiSinh;
import DTO.KetQuaThiDTO;
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
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class KetQuaForm extends javax.swing.JPanel {

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel tbModelKQThi;
    private int flagAcc;
    private String manv;
//    private NhanVienBUS nhanVienBUS;
//    private DoanDuLichBUS doanDuLichBUS;
    private int selectedRow;
    public KetQuaThiBUS ketQuaThiBUS = new KetQuaThiBUS();
//    private Utils ult = new Utils();

    public KetQuaForm() {
        initComponents();
        //tableModelKetQua();
        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");
        //loadData();
//        tk.setVisible(false);
    }

    public void initTable() {
        tbModelKQThi.setRowCount(0);
        tableModelKetQua();
        jTableKQThi.setRowSorter(null);
        jTableKQThi.setAutoCreateRowSorter(true);
        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextSBDTS.setText("");
        jTextTenThiSinh.setText("");
        jTextSDT.setText("");
        jTextTrinhDo.setText("");
        jTextPhongThi.setText("");
        jTextCaThi.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");
        jTextDiemDoc.setText("");
        jTextDiemViet.setText("");
        jTableKQThi.clearSelection();
    }

    public String tinhDiem(String tenTrinhDo, float nghe, float noi, float doc, float viet) {
        float diem = 0;
        float diemTrungBinh = 0;
        diem += nghe + noi + doc + viet;

        diemTrungBinh = (float) Math.ceil(diem / 4 * 10) / 10;
        if (tenTrinhDo.equals("A2")) {
            if (nghe > 0 && noi > 0 && doc > 0 && viet > 0 && diemTrungBinh >= 6.5) {
                return "Đạt";
            } else {
                return "Không đạt";
            }
        } else {
            if (nghe > 0 && noi > 0 && doc > 0 && viet > 0 && diemTrungBinh >= 4) {
                return "Đạt";
            } else {
                return "Không đạt";
            }
        }
    }

    public void tableModelKetQua() {
        tbModelKQThi.setRowCount(0);
        Vector row;
        for (DataThiSinh a : ketQuaThiBUS.getMixedList()) {
            row = new Vector();
            row.add(a.thiSinhDTO.getMaThiSinh());
            row.add(a.soBaoDanh);
            row.add(a.thiSinhDTO.getHoTen());
            row.add(a.thiSinhDTO.getSdt());
            row.add(a.tenTrinhDo);
            row.add(a.tenPhongThi);
            row.add(a.maCaThi);
            if (a.nghe == -1) {
                row.add("NaN");
            } else {
                row.add(Float.toString(a.nghe));
            }
            if (a.noi == -1) {
                row.add("NaN");
            } else {
                row.add(Float.toString(a.noi));
            }
            if (a.doc == -1) {
                row.add("NaN");
            } else {
                row.add(Float.toString(a.doc));
            }
            if (a.viet == -1) {
                row.add("NaN");
            } else {
                row.add(Float.toString(a.viet));
            }
            if (a.nghe != (-1) && a.noi != (-1) && a.doc != (-1) && a.viet != (-1)) {
                row.add(tinhDiem(a.tenTrinhDo, a.nghe, a.noi, a.doc, a.viet));
            } else {
                row.add("Chưa có kết quả");
            }

            tbModelKQThi.addRow(row);
        }
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelKQThi);
        jTableKQThi.setRowSorter(tr);
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
        jPanelTS = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnSuaDiem = new javax.swing.JButton();
        jBtnHuyDiem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextMaThiSinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextTenThiSinh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextDiemNghe = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextDiemNoi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextDiemDoc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextSBDTS = new javax.swing.JTextField();
        jTextPhongThi = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextTrinhDo = new javax.swing.JTextField();
        jTextCaThi = new javax.swing.JTextField();
        jTextDiemViet = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableKQThi = new javax.swing.JTable();
        jBtnRefresh = new javax.swing.JButton();
        jTextTimKiem = new javax.swing.JTextField();
        jLbTimKiem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelTS.setBackground(new java.awt.Color(233, 242, 249));
        jPanelTS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kết Quả Thí Sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jBtnSuaDiem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaDiem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaDiem.setText("Sửa");
        jBtnSuaDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaDiemActionPerformed(evt);
            }
        });

        jBtnHuyDiem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyDiem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyDiem.setText("Hủy");
        jBtnHuyDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyDiemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> Mã Thí Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaThiSinh.setEditable(false);
        jTextMaThiSinh.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaThiSinh.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Họ Tên Thí Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenThiSinh.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>Điểm Nghe<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Phòng Thi<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Trình Độ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Điểm Nói<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("<html> <body>Điểm Đọc  <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("<html> <body>Điểm Viết <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextSBDTS.setEditable(false);

        jTextPhongThi.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("<html> <body>Ca Thi<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("<html> <body>SDB <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTrinhDo.setEditable(false);

        jTextCaThi.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("<html> <body> SÐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextSDT.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextDiemDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextDiemNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jTextDiemNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextDiemViet, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jBtnSuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnHuyDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)))
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextSBDTS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextTenThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextCaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextMaThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32))))
                .addGap(555, 555, 555))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSBDTS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextCaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDiemNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDiemNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDiemDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiemViet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuyDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelTS.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, 550));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setAutoscrolls(true);

        jTableKQThi.setAutoCreateRowSorter(true);
        jTableKQThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableKQThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKQThiMouseClicked(evt);
            }
        });
        tableCol.add ("Mã Thí Sinh");
        tableCol.add ("SBD");
        tableCol.add ("Họ Tên Thí Sinh");
        tableCol.add ("SÐT");
        tableCol.add ("Trình Độ");
        tableCol.add ("Phòng Thi");
        tableCol.add ("Ca Thi");
        tableCol.add ("Điểm Nghe");
        tableCol.add ("Điểm Nói");
        tableCol.add ("Điểm Đọc");
        tableCol.add ("Điểm Viết");
        tableCol.add ("Kết Quả");

        tbModelKQThi = new DefaultTableModel(tableCol, 20){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableKQThi.setModel(tbModelKQThi);
        jTableKQThi.setShowGrid(true);
        jTableKQThi.setFocusable(false);
        jTableKQThi.setIntercellSpacing(new Dimension(0,0));
        jTableKQThi.setRowHeight(25);
        jTableKQThi.getTableHeader().setOpaque(false);
        jTableKQThi.setFillsViewportHeight(true);
        jTableKQThi.getTableHeader().setBackground(new Color(232,57,99));
        jTableKQThi.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableKQThi.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableKQThi.setSelectionBackground(new Color(52,152,219));
        jTableKQThi.setGridColor(new java.awt.Color(83, 86, 88));

        jTableKQThi.getColumn (tableCol.elementAt (0)).setPreferredWidth (140);
        jTableKQThi.getColumn (tableCol.elementAt (1)).setPreferredWidth (140);
        jTableKQThi.getColumn (tableCol.elementAt (2)).setPreferredWidth (170);
        jTableKQThi.getColumn (tableCol.elementAt (3)).setPreferredWidth (160);
        jTableKQThi.getColumn (tableCol.elementAt (4)).setPreferredWidth (110);
        jTableKQThi.getColumn (tableCol.elementAt (5)).setPreferredWidth (130);
        jTableKQThi.getColumn (tableCol.elementAt (6)).setPreferredWidth (170);
        jTableKQThi.getColumn (tableCol.elementAt (7)).setPreferredWidth (110);
        jTableKQThi.getColumn (tableCol.elementAt (8)).setPreferredWidth (110);
        jTableKQThi.getColumn (tableCol.elementAt (9)).setPreferredWidth (110);
        jTableKQThi.getColumn (tableCol.elementAt (10)).setPreferredWidth (110);
        jTableKQThi.getColumn (tableCol.elementAt (11)).setPreferredWidth (110);
        jTableKQThi.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(jTableKQThi);

        jPanelTS.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 530, 530));

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
        jPanelTS.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 40, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelTS.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 140, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelTS.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 30));

        jTabbedPane1.addTab("Quản Lý Kết Quả", jPanelTS);

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

    private void jBtnSuaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaDiemActionPerformed
        KetQuaThiDTO ketQua = new KetQuaThiDTO();
        ketQua.setSoBaoDanh(jTextSBDTS.getText());
        String nghe = jTextDiemNghe.getText();
        String noi = jTextDiemNoi.getText();
        String doc = jTextDiemDoc.getText();
        String viet = jTextDiemViet.getText();

        String validate = "";
        String soLuongPattern = "\\f+";
        if (!jTextDiemNghe.getText().equals("") && !jTextDiemNoi.getText().equals("") && !jTextDiemDoc.getText().equals("") && !jTextDiemViet.getText().equals("")) {
//            if (!Pattern.matches(soLuongPattern, jTextDiemNghe.getText())
//                    || !Pattern.matches(soLuongPattern, jTextDiemNoi.getText())
//                    || !Pattern.matches(soLuongPattern, jTextDiemDoc.getText())
//                    || !Pattern.matches(soLuongPattern, jTextDiemViet.getText())) {
//                
//                System.out.println("Chữ");
//                validate += "Số lượng phải là số nguyên dương!\n";
//                if ((Float.parseFloat(nghe) > 0) && (Float.parseFloat(noi) > 0) && (Float.parseFloat(doc) > 0) && (Float.parseFloat(viet) > 0)) {
//                    ketQua.setNghe(Float.parseFloat(nghe));
//                    ketQua.setNoi(Float.parseFloat(noi));
//                    ketQua.setDoc(Float.parseFloat(doc));
//                    ketQua.setViet(Float.parseFloat(viet));
//                    if (ketQuaThiBUS.Update(ketQua, DashBoard.ketQuaThiDTOs)) {
//                        tbModelKQThi.setValueAt(nghe, selectedRow, 7);
//                        tbModelKQThi.setValueAt(noi, selectedRow, 8);
//                        tbModelKQThi.setValueAt(doc, selectedRow, 9);
//                        tbModelKQThi.setValueAt(viet, selectedRow, 10);
//                        tbModelKQThi.setValueAt(tinhDiem(ketQuaThiBUS.getTenTrinhDo(jTextSBDTS.getText()), ketQua.getNghe(), ketQua.getNoi(), ketQua.getDoc(), ketQua.getViet()), selectedRow, 11);
//                    }
//                }
//                
//            }else{
//                System.out.println("Số");
//            }
            try {
                float fnghe = Float.parseFloat(nghe), fnoi = Float.parseFloat(noi), fdoc = Float.parseFloat(doc), fviet = Float.parseFloat(viet);
                if ((fnghe >= 0 && fnghe <= 10) && (fnoi >= 0 && fnoi <= 10) && (fdoc >= 0 && fdoc <= 10) && (fviet >= 0 && fviet <= 10)) {
                    ketQua.setNghe(Float.parseFloat(nghe));
                    ketQua.setNoi(Float.parseFloat(noi));
                    ketQua.setDoc(Float.parseFloat(doc));
                    ketQua.setViet(Float.parseFloat(viet));
                    if (ketQuaThiBUS.Update(ketQua, DashBoard.ketQuaThiDTOs)) {
                        tbModelKQThi.setValueAt(nghe, selectedRow, 7);
                        tbModelKQThi.setValueAt(noi, selectedRow, 8);
                        tbModelKQThi.setValueAt(doc, selectedRow, 9);
                        tbModelKQThi.setValueAt(viet, selectedRow, 10);
                        tbModelKQThi.setValueAt(tinhDiem(ketQuaThiBUS.getTenTrinhDo(jTextSBDTS.getText()), ketQua.getNghe(), ketQua.getNoi(), ketQua.getDoc(), ketQua.getViet()), selectedRow, 11);
                        JOptionPane.showMessageDialog(this, "Sửa điểm thành công!");
                        initTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa điểm thất bại!");
                    }
                    jBtnSuaDiem.setEnabled(false);
                    jBtnHuyDiem.setEnabled(false);
                    jTextMaThiSinh.setText("");
                    jTextSBDTS.setText("");
                    jTextTenThiSinh.setText("");
                    jTextSDT.setText("");
                    jTextTrinhDo.setText("");
                    jTextPhongThi.setText("");
                    jTextCaThi.setText("");
                    jTextDiemNghe.setText("");
                    jTextDiemNoi.setText("");
                    jTextDiemDoc.setText("");
                    jTextDiemViet.setText("");
                    jTableKQThi.clearSelection();
                } else {
                    System.out.println("Vui lòng nhập điểm theo thang điểm 10");
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm theo thang điểm 10!");
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Vui lòng nhập số");
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
            }

        } else {
            System.out.println("Không được để trống");
            JOptionPane.showMessageDialog(this, "Các cột điểm không được bỏ trống!");
        }


    }//GEN-LAST:event_jBtnSuaDiemActionPerformed

    private void jBtnHuyDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyDiemActionPerformed

        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextSBDTS.setText("");
        jTextTenThiSinh.setText("");
        jTextSDT.setText("");
        jTextTrinhDo.setText("");
        jTextPhongThi.setText("");
        jTextCaThi.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");
        jTextDiemDoc.setText("");
        jTextDiemViet.setText("");

        jTableKQThi.clearSelection();
    }//GEN-LAST:event_jBtnHuyDiemActionPerformed

    private void jTableKQThiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKQThiMouseClicked
    {//GEN-HEADEREND:event_jTableKQThiMouseClicked
        // TODO add your handling code here:
        selectedRow = jTableKQThi.getSelectedRow();
        if (selectedRow != -1) {
            jBtnSuaDiem.setEnabled(true);
            jBtnHuyDiem.setEnabled(true);
            jTextMaThiSinh.setText((String) jTableKQThi.getValueAt(selectedRow, 0));
            jTextSBDTS.setText((String) jTableKQThi.getValueAt(selectedRow, 1));
            jTextTenThiSinh.setText((String) jTableKQThi.getValueAt(selectedRow, 2));
            jTextSDT.setText((String) jTableKQThi.getValueAt(selectedRow, 3));
            jTextTrinhDo.setText((String) jTableKQThi.getValueAt(selectedRow, 4));
            jTextPhongThi.setText((String) jTableKQThi.getValueAt(selectedRow, 5));
            jTextCaThi.setText((String) jTableKQThi.getValueAt(selectedRow, 6));
            String nghe = (String) jTableKQThi.getValueAt(selectedRow, 7);
            String noi = (String) jTableKQThi.getValueAt(selectedRow, 8);
            String doc = (String) jTableKQThi.getValueAt(selectedRow, 9);
            String viet = (String) jTableKQThi.getValueAt(selectedRow, 10);
            if (nghe.equals("NaN")) {
                jTextDiemNghe.setText("");
            } else {
                jTextDiemNghe.setText((String) jTableKQThi.getValueAt(selectedRow, 7));
            }

            if (noi.equals("NaN")) {
                jTextDiemNoi.setText("");
            } else {
                jTextDiemNoi.setText((String) jTableKQThi.getValueAt(selectedRow, 8));
            }

            if (doc.equals("NaN")) {
                jTextDiemDoc.setText("");
            } else {
                jTextDiemDoc.setText((String) jTableKQThi.getValueAt(selectedRow, 9));
            }

            if (viet.equals("NaN")) {
                jTextDiemViet.setText("");
            } else {
                jTextDiemViet.setText((String) jTableKQThi.getValueAt(selectedRow, 10));
            }

        }

    }//GEN-LAST:event_jTableKQThiMouseClicked

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTable();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

//    Vector tableRow = new Vector ();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableCol = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tableColThongKe = new Vector();

    public JPanel getjPanel1() {
        return jPanelTS;
    }

    public JTextField getjTextManv() {
        return jTextMaThiSinh;
    }

    public DefaultTableModel getModelnv() {
        return tbModelKQThi;
    }

    public int getFlagAcc() {
        return flagAcc;
    }

    public void setFlagAcc(int flagAcc) {
        this.flagAcc = flagAcc;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public JButton getjBtnRefresh() {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh) {
        this.jBtnRefresh = jBtnRefresh;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnHuyDiem;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaDiem;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTS;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableKQThi;
    private javax.swing.JTextField jTextCaThi;
    private javax.swing.JTextField jTextDiemDoc;
    private javax.swing.JTextField jTextDiemNghe;
    private javax.swing.JTextField jTextDiemNoi;
    private javax.swing.JTextField jTextDiemViet;
    private javax.swing.JTextField jTextMaThiSinh;
    private javax.swing.JTextField jTextPhongThi;
    private javax.swing.JTextField jTextSBDTS;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenThiSinh;
    private javax.swing.JTextField jTextTimKiem;
    private javax.swing.JTextField jTextTrinhDo;
    // End of variables declaration//GEN-END:variables
}
