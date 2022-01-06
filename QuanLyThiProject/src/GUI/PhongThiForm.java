/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.*;
//import DTO.DiaDiemDTO;
//import DAO.DocExcel;
//import DAO.WritePDF;
//import DAO.XuatExcel;
import BUS.GiaoVienBUS;
import BUS.KetQuaThiBUS;
import BUS.PhanCongBUS;
import BUS.PhieuBaoDuThiBUS;
import BUS.PhongThiBUS;
import BUS.ThiSinhBUS;
import DTO.CaThiDTO;
import DTO.GiaoVienDTO;
import DTO.KetQuaThiDTO;
import DTO.KhoaThiDTO;
import DTO.PhanCongDTO;
import DTO.PhieuBaoDuThiDTO;
import DTO.PhongThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;
import com.mysql.jdbc.jdbc2.optional.JDBC4StatementWrapper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
//import static ui.DashBoard.loadagain;

/**
 *
 * @author Hyung
 */
public class PhongThiForm extends javax.swing.JPanel {

    DefaultTableModel tbModelPhongThi, tbModelPTTS, tbModelPTGV;
    private int rowPhongThi, rowThiSinh, rowGiaoVien, soLuongPG;
    private PhongThiDTO phongThiSelected = new PhongThiDTO();
    private String tenKhoaThi, tenTrinhDo, tenGiaoVien;
    PhongThiDTO phongThi;
    CaThiDTO caThi;
    PhongThiBUS phongThiBUS = new PhongThiBUS();
    PhieuBaoDuThiBUS phieuBaoDuThiBUS = new PhieuBaoDuThiBUS();
    ThiSinhBUS thiSinhBUS = new ThiSinhBUS();
    GiaoVienBUS giaoVienBUS = new GiaoVienBUS();
    PhanCongBUS phanCongBUS = new PhanCongBUS();
    KetQuaThiBUS ketQuaBUS = new KetQuaThiBUS();
    boolean flagSua = false;

    /**
     * Creates new form jPanel2
     */
    public PhongThiForm() {
        initComponents();
//        diaDiemBUS = new DiaDiemBUS();
        jBtnCapPhatMaPT.setEnabled(true);
        jBtnThemPT.setEnabled(false);
        jBtnSuaPT.setEnabled(false);
        jBtnXoaPT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnChonGVPT.setEnabled(false);
        jCbNhiemVu.addItem(new NhiemVu("Canh thi", "Canh Thi"));
        jCbNhiemVu.addItem(new NhiemVu("Cham diem", "Chấm Điểm"));
    }

    public void initTable() {
        tbModelPhongThi.setRowCount(0);
        tableModel(tbModelPhongThi);
        jTablePhongThi.setRowSorter(null);
        jTablePhongThi.setAutoCreateRowSorter(true);
        jTablePhongThi.setModel(tbModelPhongThi);
        clear();
        jCbKhoaThi.removeAllItems();
        addComboKhoaThi(jCbKhoaThi, DashBoard.khoaThiDTOs);
        jCbTrinhDo.removeAllItems();
        addComboTrinhDo(jCbTrinhDo, DashBoard.trinhDoDTOs);
    }

    public void tableModel(DefaultTableModel model) {
        for (PhongThiDTO phongThi : DashBoard.phongThiDTOs) {
            Vector row = new Vector();
            row.add(phongThi.getMaPhongThi());
            row.add(phongThi.getTenPhongThi());
            row.add(phongThi.getMaKhoaThi());
            for (KhoaThiDTO khoaThi : DashBoard.khoaThiDTOs) {
                if (khoaThi.getMaKhoaThi().equals(phongThi.getMaKhoaThi())) {
                    row.add(khoaThi.getTenKhoaThi());
                }
            }
            row.add(phongThi.getMaTrinhDo());
            for (TrinhDoDTO trinhDo : DashBoard.trinhDoDTOs) {
                if (trinhDo.getMaTrinhDo().equals(phongThi.getMaTrinhDo())) {
                    row.add(trinhDo.getTenTrinhDo());
                }
            }
            row.add(phongThi.getSoLuong());
            model.addRow(row);
        }
    }

    public void tableModelThiSinh(String maPhongThi, String maCa) {
        Vector row;
        for (PhieuBaoDuThiDTO a : phieuBaoDuThiBUS.getThiSinhs(maPhongThi, maCa, DashBoard.phieuBaoDuThiDTOs)) {
            row = new Vector();
            row.add(a.getMaThiSinh());
            row.add(thiSinhBUS.getHoTenByMaThiSinh(a.getMaThiSinh(), DashBoard.thiSinhDTOs));
            row.add(a.getSoBaoDanh());
            if (thiSinhBUS.getStatusByMaThiSinh(a.getMaThiSinh(), DashBoard.thiSinhDTOs) == 3) {
                row.add("Chưa thi");
            } else {
                row.add("Đã thi");
            }
            tbModelPTTS.addRow(row);
        }
    }

    public void tableModelGiaoVien(String maPhongThi, String maCaThi) {
        Vector row;
        tbModelPTGV.setRowCount(0);
        for (PhanCongDTO a : phanCongBUS.getListByMaPhongThi_MaCaThi(maPhongThi, maCaThi, DashBoard.phanCongDTOs)) {
            row = new Vector();
            row.add(a.getMaGiaoVien());
            row.add(giaoVienBUS.findHoTenByMaGiaoVien(a.getMaGiaoVien(), DashBoard.giaoVienDTOs));
            row.add(a.getNhiemVu());
            tbModelPTGV.addRow(row);
        }
    }

    public void themVector(DefaultTableModel model, PhongThiDTO phongThiDTO, String tenKhoaThi, String tenTrinhDo) {
        Vector newrow = new Vector();
        newrow.add(phongThiDTO.getMaPhongThi());
        newrow.add(phongThiDTO.getTenPhongThi());
        newrow.add(phongThiDTO.getMaKhoaThi());
        newrow.add(tenKhoaThi);
        newrow.add(phongThiDTO.getMaTrinhDo());
        newrow.add(tenTrinhDo);
        newrow.add(phongThiDTO.getSoLuong());
        model.addRow(newrow);
    }

    public void suaVector(DefaultTableModel model, int row, PhongThiDTO phongThiDTO, String tenKhoaThi, String tenTrinhDo) {
        model.setValueAt(phongThiDTO.getTenPhongThi(), row, 1);
        model.setValueAt(phongThiDTO.getMaKhoaThi(), row, 2);
        model.setValueAt(tenKhoaThi, row, 3);
        model.setValueAt(phongThiDTO.getMaTrinhDo(), row, 4);
        model.setValueAt(tenTrinhDo, row, 5);
        model.setValueAt(phongThiDTO.getSoLuong(), row, 6);
    }

    public void xoaVector(DefaultTableModel model, int row) {
        model.removeRow(row);
    }

    public void clear() {
        jBtnCapPhatMaPT.setEnabled(true);
        jBtnThemPT.setEnabled(false);
        jBtnSuaPT.setEnabled(false);
        jBtnXoaPT.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaPT.setText("");
        jTextTenPhongThi.setText("");
        jTextSoluong.setText("");
        jTextTenPhongThi.setEnabled(true);
        jTablePhongThi.clearSelection();
        flagSua = false;
    }

    public void clearPhongThiTS() {
        jTextMaTSPT.setText("");
        jTextTenTSPT.setText("");
        jTextSBD.setText("");
        jBtnThemTSPT.setEnabled(true);
        jBtnXoaTSPT.setEnabled(false);
        jBtnHuyTSPT.setEnabled(false);
        jTablePTTS.clearSelection();
    }

    public void clearPhongThiGV() {
        jTextMaGVPT.setText("");
        jTextTenGVPT.setText("");
        jBtnChonGVPT.setEnabled(true);
        jBtnThemGVPT.setEnabled(false);
        jBtnSuaGVPT.setEnabled(false);
        jBtnXoaGVPT.setEnabled(false);
        jBtnHuyGVPT.setEnabled(false);
        jTablePTGV.clearSelection();
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelPhongThi);
        jTablePhongThi.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private void filterPTTS(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelPTTS);
        jTablePTTS.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void addComboKhoaThi(JComboBox cmb, ArrayList<KhoaThiDTO> list) {
        for (KhoaThiDTO a : list) {
            cmb.addItem(a.getMaKhoaThi() + ". " + a.getTenKhoaThi());
        }
    }

    public void addComboTrinhDo(JComboBox cmb, ArrayList<TrinhDoDTO> list) {
        for (TrinhDoDTO a : list) {
            cmb.addItem(a.getMaTrinhDo() + ". " + a.getTenTrinhDo());
        }
    }

    public void addComboCaThi(JComboBox cmb, ArrayList<CaThiDTO> list) {
        for (CaThiDTO a : list) {
            cmb.addItem(a);
        }
    }

    public String validation(String tenPhongThi, String tenTrinhDo) {
        String validate = "", soLuong = jTextSoluong.getText();
        if (jTextMaPT.getText().equals("") || jTextTenPhongThi.getText().equals("") || soLuong.equals("")) {
            validate += "Các trường thông tin không được bỏ trống!\n";
            return validate;
        }
        if (!tenPhongThi.contains(tenTrinhDo)) {
            validate += "Tên phòng thi không hợp lệ!\n";
        }
        String soLuongPattern = "\\d+";
        if (!Pattern.matches(soLuongPattern, soLuong) || Integer.valueOf(soLuong) <= 0) {
            validate += "Số lượng phải là số nguyên dương!\n";
        }
        return validate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuStatus = new javax.swing.JPopupMenu();
        jMenuItemChuaThi = new javax.swing.JMenuItem();
        jMenuItemDaThi = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPhongThi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelPT = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextMaPT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTenPhongThi = new javax.swing.JTextField();
        jBtnCapPhatMaPT = new javax.swing.JButton();
        jBtnThemPT = new javax.swing.JButton();
        jBtnSuaPT = new javax.swing.JButton();
        jBtnXoaPT = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextSoluong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jCbTrinhDo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jCbKhoaThi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePhongThi = new javax.swing.JTable();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();
        jPanelQlyPT = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePTGV = new javax.swing.JTable();
        jBtnChoose = new javax.swing.JButton();
        jPanelChonGV = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextMaGVPT = new javax.swing.JTextField();
        jBtnChonGVPT = new javax.swing.JButton();
        jBtnThemGVPT = new javax.swing.JButton();
        jBtnSuaGVPT = new javax.swing.JButton();
        jBtnXoaGVPT = new javax.swing.JButton();
        jBtnHuyGVPT = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTenGVPT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCbNhiemVu = new javax.swing.JComboBox<>();
        jPanelChonThiSinh1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextMaTSPT = new javax.swing.JTextField();
        jBtnThemTSPT = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextTenTSPT = new javax.swing.JTextField();
        jBtnHuyTSPT = new javax.swing.JButton();
        jBtnXoaTSPT = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextSBD = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePTTS = new javax.swing.JTable();
        jLabelTenPhongThi = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jCbCaThi = new javax.swing.JComboBox<>();
        jLbTimKiemPTTS = new javax.swing.JLabel();
        jTextTimKiemPTTS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jMenuItemChuaThi.setText("Chưa thi");
        jMenuItemChuaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChuaThiActionPerformed(evt);
            }
        });
        jPopupMenuStatus.add(jMenuItemChuaThi);

        jMenuItemDaThi.setText("Đã thi");
        jMenuItemDaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDaThiActionPerformed(evt);
            }
        });
        jPopupMenuStatus.add(jMenuItemDaThi);

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanelPhongThi.setBackground(new java.awt.Color(233, 242, 249));
        jPanelPhongThi.setPreferredSize(new java.awt.Dimension(960, 580));
        jPanelPhongThi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Phòng Thi");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(83, 86, 88)));
        jPanelPhongThi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 190, 30));

        jPanelPT.setBackground(new java.awt.Color(233, 242, 249));
        jPanelPT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Phòng Thi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("<html> <body> Mã Phòng Thi<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaPT.setEditable(false);//[214,217,223]
        jTextMaPT.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaPT.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("<html> <body> Tên Phòng Thi <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextTenPhongThi.setEditable(false);
        jTextTenPhongThi.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenPhongThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextTenPhongThiMouseClicked(evt);
            }
        });

        jBtnCapPhatMaPT.setEnabled(true);
        jBtnCapPhatMaPT.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaPTActionPerformed(evt);
            }
        });

        jBtnThemPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemPT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemPT.setText("Thêm");
        jBtnThemPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemPTActionPerformed(evt);
            }
        });

        jBtnSuaPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaPT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaPT.setText("Sửa");
        jBtnSuaPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaPTActionPerformed(evt);
            }
        });

        jBtnXoaPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaPT.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaPT.setText("Xóa");
        jBtnXoaPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaPTActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("<html> <body>Số Lượng <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextSoluong.setForeground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body>Trình Độ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbTrinhDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A2", "B1" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("<html> <body> Mã Khóa Thi<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jCbKhoaThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khóa 1", "Khóa 2" }));
        jCbKhoaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbKhoaThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPTLayout = new javax.swing.GroupLayout(jPanelPT);
        jPanelPT.setLayout(jPanelPTLayout);
        jPanelPTLayout.setHorizontalGroup(
            jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPTLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jTextMaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPTLayout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBtnThemPT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtnXoaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                            .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtnSuaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPTLayout.createSequentialGroup()
                            .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextTenPhongThi, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jCbTrinhDo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCbKhoaThi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextSoluong)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCapPhatMaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanelPTLayout.setVerticalGroup(
            jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPTLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextMaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnCapPhatMaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSuaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnThemPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanelPhongThi.add(jPanelPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 410, 460));
        jPanelPT.getAccessibleContext().setAccessibleName("");

        Vector tableCol=new Vector();
        tableCol.add("Mã Phòng Thi");
        tableCol.add("Tên Phòng Thi");
        tableCol.add("Mã Khóa Thi");
        tableCol.add("Tên Khóa Thi");
        tableCol.add("Mã Trình Độ");
        tableCol.add("Trình Độ");
        tableCol.add("Số Lượng");

        tbModelPhongThi = new DefaultTableModel (tableCol,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTablePhongThi.setModel (tbModelPhongThi);
        jTablePhongThi.setShowGrid(true);
        jTablePhongThi.setFocusable(false);
        jTablePhongThi.setIntercellSpacing(new Dimension(0,0));
        jTablePhongThi.setRowHeight(25);
        jTablePhongThi.getTableHeader().setOpaque(false);
        jTablePhongThi.setFillsViewportHeight(true);
        jTablePhongThi.getTableHeader().setBackground(new Color(232,57,99));
        jTablePhongThi.getTableHeader().setForeground(new Color(141, 22, 22));
        jTablePhongThi.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTablePhongThi.setSelectionBackground(new Color(52,152,219));
        jTablePhongThi.setAutoCreateRowSorter(true);
        jTablePhongThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePhongThi.setGridColor(new java.awt.Color(83, 86, 88));
        jTablePhongThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePhongThiMouseClicked(evt);
            }
        });
        jTablePhongThi.getColumn (tableCol.elementAt (0)).setPreferredWidth (120);
        jTablePhongThi.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTablePhongThi.getColumn (tableCol.elementAt (2)).setPreferredWidth (120);
        jTablePhongThi.getColumn (tableCol.elementAt (3)).setPreferredWidth (150);
        jTablePhongThi.getColumn (tableCol.elementAt (4)).setPreferredWidth (120);
        jTablePhongThi.getColumn (tableCol.elementAt (5)).setPreferredWidth (150);
        jTablePhongThi.getColumn (tableCol.elementAt (6)).setPreferredWidth (100);
        jTablePhongThi.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTablePhongThi);

        jPanelPhongThi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 530, 450));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelPhongThi.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelPhongThi.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 140, 30));

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
        jPanelPhongThi.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 40, 30));

        jTabbedPane1.addTab("Quản Lý Phòng Thi", jPanelPhongThi);

        jPanelQlyPT.setBackground(new java.awt.Color(233, 242, 249));
        jPanelQlyPT.setPreferredSize(new java.awt.Dimension(960, 580));
        jPanelQlyPT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Vector tableCol2=new Vector();
        tableCol2.add("Mã Giáo Viên");
        tableCol2.add("Tên Giáo Viên");
        tableCol2.add("Nhiệm Vụ");

        tbModelPTGV = new DefaultTableModel (tableCol2,0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTablePTGV.setModel (tbModelPTGV);
        jTablePTGV.setShowGrid(true);
        jTablePTGV.setFocusable(false);
        jTablePTGV.setIntercellSpacing(new Dimension(0,0));
        jTablePTGV.setRowHeight(25);
        jTablePTGV.getTableHeader().setOpaque(false);
        jTablePTGV.setFillsViewportHeight(true);
        jTablePTGV.getTableHeader().setBackground(new Color(232,57,99));
        jTablePTGV.getTableHeader().setForeground(new Color(141, 22, 22));
        jTablePTGV.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTablePTGV.setSelectionBackground(new Color(52,152,219));
        jTablePTGV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePTGV.setGridColor(new java.awt.Color(83, 86, 88));
        jTablePTGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePTGVMouseClicked(evt);
            }
        });
        jTablePTGV.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(jTablePTGV);

        jPanelQlyPT.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 530, 220));

        jBtnChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_checked_16.png"))); // NOI18N
        jBtnChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChoose.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnChoose.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnChoose.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChooseActionPerformed(evt);
            }
        });
        jPanelQlyPT.add(jBtnChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 30, 30));

        jPanelChonGV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelChonGV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Giáo Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> Mã Giáo Viên<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaGVPT.setEditable(false);//[214,217,223]
        jTextMaGVPT.setEditable(false);
        jTextMaGVPT.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaGVPT.setForeground(new java.awt.Color(51, 51, 51));

        jBtnChonGVPT.setEnabled(true);
        jBtnChonGVPT.setBackground(new java.awt.Color(81, 113, 131));
        jBtnChonGVPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnChonGVPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonGVPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonGVPTActionPerformed(evt);
            }
        });

        jBtnThemGVPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemGVPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnThemGVPT.setText("Thêm");
        jBtnThemGVPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemGVPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemGVPTActionPerformed(evt);
            }
        });

        jBtnSuaGVPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaGVPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnSuaGVPT.setText("Sửa");
        jBtnSuaGVPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaGVPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaGVPTActionPerformed(evt);
            }
        });

        jBtnXoaGVPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaGVPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnXoaGVPT.setText("Xóa");
        jBtnXoaGVPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaGVPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaGVPTActionPerformed(evt);
            }
        });

        jBtnHuyGVPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyGVPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnHuyGVPT.setText("Hủy");
        jBtnHuyGVPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyGVPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyGVPTActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Nhiệm Vụ<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenGVPT.setEditable(false);
        jTextTenGVPT.setBackground(new java.awt.Color(214, 217, 223));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("<html> <body>Tên Giáo Viên<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        javax.swing.GroupLayout jPanelChonGVLayout = new javax.swing.GroupLayout(jPanelChonGV);
        jPanelChonGV.setLayout(jPanelChonGVLayout);
        jPanelChonGVLayout.setHorizontalGroup(
            jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChonGVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChonGVLayout.createSequentialGroup()
                        .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChonGVLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextTenGVPT))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChonGVLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jTextMaGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnChonGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelChonGVLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCbNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChonGVLayout.createSequentialGroup()
                        .addComponent(jBtnThemGVPT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnXoaGVPT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnSuaGVPT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnHuyGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelChonGVLayout.setVerticalGroup(
            jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChonGVLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextMaGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnChonGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTenGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelChonGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThemGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuyGVPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        jPanelQlyPT.add(jPanelChonGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 390, 230));

        jPanelChonThiSinh1.setBackground(new java.awt.Color(233, 242, 249));
        jPanelChonThiSinh1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Thí Sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("<html> <body> Mã Thí Sinh<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaGVPT.setEditable(false);//[214,217,223]
        jTextMaTSPT.setEditable(false);
        jTextMaTSPT.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaTSPT.setForeground(new java.awt.Color(51, 51, 51));

        jBtnThemTSPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemTSPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnThemTSPT.setText("Thêm");
        jBtnThemTSPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemTSPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemTSPTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("<html> <body>Họ Tên Thí Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenTSPT.setEditable(false);
        jTextTenTSPT.setBackground(new java.awt.Color(214, 217, 223));

        jBtnHuyTSPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyTSPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnHuyTSPT.setText("Hủy");
        jBtnHuyTSPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyTSPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyTSPTActionPerformed(evt);
            }
        });

        jBtnXoaTSPT.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaTSPT.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jBtnXoaTSPT.setText("Xóa");
        jBtnXoaTSPT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaTSPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaTSPTActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("<html> <body>SBD <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextSBD.setEditable(false);
        jTextSBD.setBackground(new java.awt.Color(214, 217, 223));
        jTextSBD.setForeground(new java.awt.Color(51, 51, 51));
        jTextSBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextSBDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelChonThiSinh1Layout = new javax.swing.GroupLayout(jPanelChonThiSinh1);
        jPanelChonThiSinh1.setLayout(jPanelChonThiSinh1Layout);
        jPanelChonThiSinh1Layout.setHorizontalGroup(
            jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChonThiSinh1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelChonThiSinh1Layout.createSequentialGroup()
                        .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChonThiSinh1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jTextSBD, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChonThiSinh1Layout.createSequentialGroup()
                                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextMaTSPT, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(jTextTenTSPT))))
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(jPanelChonThiSinh1Layout.createSequentialGroup()
                        .addComponent(jBtnThemTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnXoaTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jBtnHuyTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanelChonThiSinh1Layout.setVerticalGroup(
            jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChonThiSinh1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSBD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChonThiSinh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnHuyTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnXoaTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnThemTSPT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanelQlyPT.add(jPanelChonThiSinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 390, 240));

        Vector tableCol1=new Vector();
        tableCol1.add("Mã Thí Sinh");
        tableCol1.add("Tên Thí Sinh");
        tableCol1.add("SBD");
        tableCol1.add("Tình Trạng");

        tbModelPTTS = new DefaultTableModel (tableCol1,2){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTablePTTS.setModel (tbModelPTTS);
        jTablePTTS.setShowGrid(true);
        jTablePTTS.setFocusable(false);
        jTablePTTS.setIntercellSpacing(new Dimension(0,0));
        jTablePTTS.setRowHeight(25);
        jTablePTTS.getTableHeader().setOpaque(false);
        jTablePTTS.setFillsViewportHeight(true);
        jTablePTTS.getTableHeader().setBackground(new Color(232,57,99));
        jTablePTTS.getTableHeader().setForeground(new Color(141, 22, 22));
        jTablePTTS.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTablePTTS.setSelectionBackground(new Color(52,152,219));
        jTablePTTS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePTTS.setGridColor(new java.awt.Color(83, 86, 88));
        jTablePTTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePTTSMouseClicked(evt);
            }
        });
        //jTablePTTS.getColumn (tableCol1.elementAt (0)).setPreferredWidth (100);
        //        jTablePTTS.getColumn (tableCol1.elementAt (1)).setPreferredWidth (170);
        //        jTablePTTS.getColumn (tableCol1.elementAt (2)).setPreferredWidth (120);
        //        jTablePTTS.getColumn (tableCol1.elementAt (3)).setPreferredWidth (150);
        //        jTablePTTS.getColumn (tableCol1.elementAt (4)).setPreferredWidth (150);
        jTablePTTS.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(jTablePTTS);

        jPanelQlyPT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 530, 280));

        jLabelTenPhongThi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTenPhongThi.setForeground(new java.awt.Color(153, 153, 255));
        jLabelTenPhongThi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTenPhongThi.setText("A1P01");
        jLabelTenPhongThi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanelQlyPT.add(jLabelTenPhongThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 110, 30));

        jBtnBack.setText("Quay Lại");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });
        jPanelQlyPT.add(jBtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("<html> <body>   PHÒNG THI <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanelQlyPT.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 30));
        jPanelQlyPT.add(jCbCaThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 240, 32));

        jLbTimKiemPTTS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiemPTTS.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelQlyPT.add(jLbTimKiemPTTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, 30));

        jTextTimKiemPTTS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemPTTSKeyReleased(evt);
            }
        });
        jPanelQlyPT.add(jTextTimKiemPTTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 140, 30));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Danh Sách Thí Sinh");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(83, 86, 88)));
        jPanelQlyPT.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 190, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Danh Sách Giáo Viên");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(83, 86, 88)));
        jPanelQlyPT.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 190, 30));

        jTabbedPane1.addTab("Sắp Xếp Phòng Thi", jPanelQlyPT);

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

    private void jBtnCapPhatMaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaPTActionPerformed
        // TODO add your handling code here:
        jTextMaPT.setText(phongThiBUS.capPhat());
        jBtnCapPhatMaPT.setEnabled(false);
        jBtnThemPT.setEnabled(true);
        jBtnSuaPT.setEnabled(false);
        jBtnXoaPT.setEnabled(false);
        jBtnHuy.setEnabled(true);
    }//GEN-LAST:event_jBtnCapPhatMaPTActionPerformed

    private void jBtnThemPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemPTActionPerformed
        // TODO add your handling code here:
        String maPhongThi = (String) jTextMaPT.getText(),
                tenPhongThi = (String) jTextTenPhongThi.getText(),
                soLuong = (String) jTextSoluong.getText(),
                maKhoaThi = jCbKhoaThi.getSelectedItem().toString().substring(0, 8),
                tenKhoaThi = jCbKhoaThi.getSelectedItem().toString().substring(10),
                maTrinhDo = jCbTrinhDo.getSelectedItem().toString().substring(0, 8),
                tenTrinhDo = jCbTrinhDo.getSelectedItem().toString().substring(10);
//        System.out.println("- maKhoa: /" + maKhoaThi + "/" + tenKhoaThi + "/");
//        System.out.println("- maTrinh: /" + maTrinhDo + "/" + tenTrinhDo + "/");
        String check = validation(tenPhongThi, tenTrinhDo);
        if (check.equals("")) {
            PhongThiDTO phongThiDTO = new PhongThiDTO(maPhongThi, tenPhongThi, Integer.valueOf(soLuong), maKhoaThi, maTrinhDo);
            if (phongThiBUS.them(phongThiDTO, DashBoard.phongThiDTOs, soLuongPG, DashBoard.trinhDoDTOs)) {
                themVector(tbModelPhongThi, phongThiDTO, tenKhoaThi, tenTrinhDo);
                JOptionPane.showMessageDialog(this, "Thêm phòng thi thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm phòng thi thất bại!");
            }
            clear();
        } else {
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnThemPTActionPerformed

    public String checkBeforeUpdate(PhongThiDTO phongThi) {
        String noti = "";
        int count, soLuongTS = -1;
        for (CaThiDTO caThi : DashBoard.caThiDTOs) {
            count = 0;
            for (PhieuBaoDuThiDTO phieuBao : DashBoard.phieuBaoDuThiDTOs) {
                if (phieuBao.getMaPhongThi().equals(phongThi.getMaPhongThi())
                        && caThi.getMaCaThi().equals(phieuBao.getMaCaThi())) {
                    count++;
                }
            }
            if (count > soLuongTS) {
                soLuongTS = count;
            }
        }
        if (soLuongTS > 0 && !phongThi.getMaTrinhDo().equals(phongThiSelected.getMaTrinhDo())) {
            noti += "\n- Phòng thi tồn tại thí sinh khác trình độ muốn sửa!";
        }
        if (Integer.valueOf(phongThi.getSoLuong()) < soLuongTS) {
            noti += "\n- Số lượng muốn sửa nhỏ hơn số lượng thí sinh dự thi thuộc phòng này!";
        }
        return noti;
    }

    private void jBtnSuaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaPTActionPerformed
        // TODO add your handling code here:
        String maPhongThi = phongThiSelected.getMaPhongThi(),
                tenPhongThi = (String) jTextTenPhongThi.getText(),
                soLuong = (String) jTextSoluong.getText(),
                maKhoaThi = jCbKhoaThi.getSelectedItem().toString().substring(0, 8),
                tenKhoaThi = jCbKhoaThi.getSelectedItem().toString().substring(10),
                maTrinhDo = jCbTrinhDo.getSelectedItem().toString().substring(0, 8),
                tenTrinhDo = jCbTrinhDo.getSelectedItem().toString().substring(10);
        String check = validation(tenPhongThi, tenTrinhDo);
        if (check.equals("")) {
            PhongThiDTO phongThiDTO = new PhongThiDTO(maPhongThi, tenPhongThi, Integer.valueOf(soLuong), maKhoaThi, maTrinhDo);
            if (phongThiDTO.toString().equals(phongThiSelected.toString())) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không thay đổi!");
                clear();
                return;
            }
            String checkUp = checkBeforeUpdate(phongThiDTO);
            if (checkUp.equals("")) {
                if (phongThiBUS.sua(phongThiDTO, phongThiSelected, DashBoard.phongThiDTOs)) {
                    suaVector(tbModelPhongThi, rowPhongThi, phongThiDTO, tenKhoaThi, tenTrinhDo);
                    JOptionPane.showMessageDialog(this, "Sửa phòng thi thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa phòng thi thất bại!");
                }
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể sửa" + checkUp);
            }
        } else {
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnSuaPTActionPerformed

    public String checkBeforeDel(String maPhongThi) {
        String noti = "";
        for (PhieuBaoDuThiDTO phieuBao : DashBoard.phieuBaoDuThiDTOs) {
            if (phieuBao.getMaPhongThi().equals(maPhongThi)) {
                noti += "\n- Còn thí sinh thuộc phòng thi này!";
                break;
            }
        }
        return noti;
    }

    private void jBtnXoaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaPTActionPerformed
        // TODO add your handling code here:
        String check = checkBeforeDel(phongThiSelected.getMaPhongThi());
        if (check.equals("")) {
            if (phongThiBUS.xoa(phongThiSelected, DashBoard.phongThiDTOs)) {
                xoaVector(tbModelPhongThi, rowPhongThi);
                JOptionPane.showMessageDialog(this, "Xóa phòng thi thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa phòng thi thất bại!");
            }
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể xóa" + check);
        }
    }//GEN-LAST:event_jBtnXoaPTActionPerformed

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

    private void jTablePTGVMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablePTGVMouseClicked
    {//GEN-HEADEREND:event_jTablePTGVMouseClicked
        // TODO add your handling code here:
        rowGiaoVien = jTablePTGV.getSelectedRow();

        jTextMaGVPT.setText((String) tbModelPTGV.getValueAt(rowGiaoVien, 0));
        jTextTenGVPT.setText((String) tbModelPTGV.getValueAt(rowGiaoVien, 1));
        String nhiemVu = (String) tbModelPTGV.getValueAt(rowGiaoVien, 2);
        System.out.println();
        if (nhiemVu.equals("Canh thi")) {
            jCbNhiemVu.setSelectedIndex(0);
        } else {
            jCbNhiemVu.setSelectedIndex(1);
        }
        jBtnSuaGVPT.setEnabled(true);
        jBtnXoaGVPT.setEnabled(true);
        jBtnHuyGVPT.setEnabled(true);
        jBtnThemGVPT.setEnabled(false);
        jBtnChonGVPT.setEnabled(false);
    }//GEN-LAST:event_jTablePTGVMouseClicked

    private void jBtnChooseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChooseActionPerformed
    {//GEN-HEADEREND:event_jBtnChooseActionPerformed
        // TODO add your handling code here:
        jBtnChonGVPT.setEnabled(true);
        caThi = (CaThiDTO) jCbCaThi.getSelectedItem();
        tbModelPTTS.setRowCount(0);
        tableModelThiSinh(phongThi.getMaPhongThi(), caThi.getMaCaThi());
        jTablePTTS.setRowSorter(null);
        jTablePTTS.setAutoCreateRowSorter(true);
        jTablePTTS.setModel(tbModelPTTS);
        tableModelGiaoVien(phongThi.getMaPhongThi(), caThi.getMaCaThi());
        System.out.println("MaPhongThi:" + phongThi.getMaPhongThi() + "   MaCaThi:" + caThi.getMaCaThi());
        clearPhongThiTS();
        clearPhongThiGV();
    }//GEN-LAST:event_jBtnChooseActionPerformed

    private void jCbKhoaThiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbKhoaThiActionPerformed
    {//GEN-HEADEREND:event_jCbKhoaThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbKhoaThiActionPerformed

    private void jTablePhongThiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablePhongThiMouseClicked
    {//GEN-HEADEREND:event_jTablePhongThiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            jBtnThemGVPT.setEnabled(false);
            jBtnThemTSPT.setEnabled(false);
            jBtnSuaGVPT.setEnabled(false);
            jBtnXoaGVPT.setEnabled(false);
            jBtnXoaTSPT.setEnabled(false);
            jBtnHuyGVPT.setEnabled(false);
            jBtnHuyTSPT.setEnabled(false);
            jBtnChonGVPT.setEnabled(false);
            JTable tempJTable = (JTable) evt.getSource();
            int row = tempJTable.getSelectedRow();
            tbModelPTTS.setRowCount(0);
            tbModelPTGV.setRowCount(0);
            phongThi = phongThiBUS.findPhongThiByMaPhongThi((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 0), DashBoard.phongThiDTOs);

//            System.out.println((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 0));
//            System.out.println(phongThi);
            if (row != -1) {
                jTabbedPane1.add(jPanelQlyPT, 1);
                jTabbedPane1.setTitleAt(1, "Sắp Xếp Phòng Thi");
                jTabbedPane1.setSelectedIndex(1);
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setSelectedIndex(1);
                jLabelTenPhongThi.setText((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 1));

                jCbCaThi.removeAllItems();
                addComboCaThi(jCbCaThi, DashBoard.caThiDTOs);
            }
        } else {
            JTable tempJTable = (JTable) evt.getSource();
            rowPhongThi = tempJTable.getSelectedRow();
            if (rowPhongThi != -1) {
                phongThiSelected.setMaPhongThi((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 0));
                phongThiSelected.setTenPhongThi((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 1));
                phongThiSelected.setMaKhoaThi((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 2));
                tenKhoaThi = (String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 3);
                phongThiSelected.setMaTrinhDo((String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 4));
                tenTrinhDo = (String) jTablePhongThi.getModel().getValueAt(rowPhongThi, 5);
                phongThiSelected.setSoLuong((Integer) jTablePhongThi.getModel().getValueAt(rowPhongThi, 6));
                jTextMaPT.setText(phongThiSelected.getMaPhongThi());
                jTextTenPhongThi.setText(phongThiSelected.getTenPhongThi());
                jCbKhoaThi.setSelectedItem(phongThiSelected.getMaKhoaThi() + ". " + tenKhoaThi);
                jCbTrinhDo.setSelectedItem(phongThiSelected.getMaTrinhDo() + ". " + tenTrinhDo);
                jTextSoluong.setText(String.valueOf(phongThiSelected.getSoLuong()));
                jBtnCapPhatMaPT.setEnabled(false);
                jBtnThemPT.setEnabled(false);
                jBtnSuaPT.setEnabled(true);
                jBtnXoaPT.setEnabled(true);
                jBtnHuy.setEnabled(true);
                flagSua = true;
            }
        }
    }//GEN-LAST:event_jTablePhongThiMouseClicked

    private void jBtnChonGVPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonGVPTActionPerformed
    {//GEN-HEADEREND:event_jBtnChonGVPTActionPerformed
        // TODO add your handling code here:
        BangGiaoVien bangGiaoVien = new BangGiaoVien();
        bangGiaoVien.phongThiForm = this;
        bangGiaoVien.tableModelGiaoVien(phanCongBUS.getGiaoViensBy(phongThi.getMaPhongThi(), caThi.getMaCaThi(), DashBoard.phanCongDTOs, DashBoard.giaoVienDTOs));
    }//GEN-LAST:event_jBtnChonGVPTActionPerformed

    private void jBtnThemGVPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemGVPTActionPerformed
    {//GEN-HEADEREND:event_jBtnThemGVPTActionPerformed
        // TODO add your handling code here:
        NhiemVu nv = (NhiemVu) jCbNhiemVu.getSelectedItem();
        if (phanCongBUS.checkFull(phongThi.getMaPhongThi(), caThi.getMaCaThi(), DashBoard.phanCongDTOs)) {
            if (phanCongBUS.checkNhiemVu(phongThi.getMaPhongThi(), caThi.getMaCaThi(), nv.type, DashBoard.phanCongDTOs)) {
                if (phanCongBUS.Add(new PhanCongDTO(phongThi.getMaPhongThi(), caThi.getMaCaThi(), jTextMaGVPT.getText(), null, nv.type), DashBoard.phanCongDTOs)) {
                    Vector row = new Vector();
                    row.add(jTextMaGVPT.getText());
                    row.add(jTextTenGVPT.getText());
                    row.add(nv.type);
                    tbModelPTGV.addRow(row);
                    JOptionPane.showMessageDialog(this, "Thêm giáo viên thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm giáo viên thất bại!");
                }
                clearPhongThiGV();
            } else {
                System.out.println("Không được trùng nhiệm vụ");
                JOptionPane.showMessageDialog(this, "Không thể thêm trùng nhiệm vụ!");
            }
        } else {
            System.out.println("Vượt quá số lượng giáo viên");
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng giáo viên!");
        }
    }//GEN-LAST:event_jBtnThemGVPTActionPerformed

    private void jBtnSuaGVPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaGVPTActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaGVPTActionPerformed
        // TODO add your handling code here:
        NhiemVu nv = (NhiemVu) jCbNhiemVu.getSelectedItem();
        if (phanCongBUS.checkNhiemVu(phongThi.getMaPhongThi(), caThi.getMaCaThi(), nv.type, DashBoard.phanCongDTOs)) {
            if (phanCongBUS.Update(new PhanCongDTO(phongThi.getMaPhongThi(), caThi.getMaCaThi(), jTextMaGVPT.getText(), null, nv.type), DashBoard.phanCongDTOs)) {
                tbModelPTGV.setValueAt(nv.type, rowGiaoVien, 2);
                JOptionPane.showMessageDialog(this, "Sửa giáo viên thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa giáo viên thất bại!");
            }
            clearPhongThiGV();
        } else {
            System.out.println("Không được trùng nhiệm vụ");
            JOptionPane.showMessageDialog(this, "Không được trùng nhiệm vụ!");
        }
    }//GEN-LAST:event_jBtnSuaGVPTActionPerformed

    private void jBtnXoaGVPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaGVPTActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaGVPTActionPerformed
        // TODO add your handling code here:
        if (phanCongBUS.Delete(new PhanCongDTO(phongThi.getMaPhongThi(), caThi.getMaCaThi(), jTextMaGVPT.getText(), null, null), DashBoard.phanCongDTOs, phongThi.getMaKhoaThi(), DashBoard.khoaThiDTOs)) {
            tbModelPTGV.removeRow(rowThiSinh);
            System.out.println("Delete phancong Success");
            JOptionPane.showMessageDialog(this, "Xóa giáo viên thành công!");
        } else {
            //
            System.out.println("Fail");
            JOptionPane.showMessageDialog(this, "Xóa giáo viên thất bại!");
        }
        clearPhongThiGV();
    }//GEN-LAST:event_jBtnXoaGVPTActionPerformed

    private void jBtnHuyGVPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyGVPTActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyGVPTActionPerformed
        // TODO add your handling code here:
        clearPhongThiGV();
    }//GEN-LAST:event_jBtnHuyGVPTActionPerformed

    private void jBtnThemTSPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemTSPTActionPerformed
    {//GEN-HEADEREND:event_jBtnThemTSPTActionPerformed
        // TODO add your handling code here:
        BangThiSinh bangThiSinh = new BangThiSinh();
        bangThiSinh.phongThiForm = this;
        bangThiSinh.tableModel(phieuBaoDuThiBUS.getThiSinhsBy(phongThi.getMaTrinhDo(), phongThi.getMaKhoaThi(), phongThi.getMaPhongThi(), caThi.getMaCaThi(), DashBoard.phieuBaoDuThiDTOs));


    }//GEN-LAST:event_jBtnThemTSPTActionPerformed

    private void jTablePTTSMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablePTTSMouseClicked
    {//GEN-HEADEREND:event_jTablePTTSMouseClicked
        // TODO add your handling code here:
        rowThiSinh = jTablePTTS.getSelectedRow();

        if (rowThiSinh != -1) {
//            maLoaiChiPhi = (String) jTableTrinhDo.getModel().getValueAt(rowChiPhi, 0);
//            tenLoaiChiPhi = (String) jTableTrinhDo.getModel().getValueAt(rowChiPhi, 1);
//            if (!maLoaiChiPhi.equals("null"))
//            {
//                jTextMaTD.setText(maLoaiChiPhi);
//                jTextTenTD.setText(tenLoaiChiPhi);
//            }
            jTextMaTSPT.setText((String) tbModelPTTS.getValueAt(rowThiSinh, 0));
            jTextTenTSPT.setText((String) tbModelPTTS.getValueAt(rowThiSinh, 1));
            jTextSBD.setText((String) tbModelPTTS.getValueAt(rowThiSinh, 2));
            jBtnXoaTSPT.setEnabled(true);
            jBtnHuyTSPT.setEnabled(true);
            jBtnThemTSPT.setEnabled(false);
            JTable tempJTable = (JTable) evt.getSource();
            int row = tempJTable.getSelectedRow();
            if (row != -1) {
                if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                    jPopupMenuStatus.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        }
    }//GEN-LAST:event_jTablePTTSMouseClicked

    private void jBtnHuyTSPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyTSPTActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyTSPTActionPerformed
        // TODO add your handling code here:
        clearPhongThiTS();
    }//GEN-LAST:event_jBtnHuyTSPTActionPerformed

    private void jBtnXoaTSPTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaTSPTActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaTSPTActionPerformed
        // TODO add your handling code here:
        String SBD = (String) tbModelPTTS.getValueAt(rowThiSinh, 2);
        String maThiSinh = (String) tbModelPTTS.getValueAt(rowThiSinh, 0);
//        System.out.println("mathisinh:  " + maThiSinh);
        if (!phieuBaoDuThiBUS.CheckThiChua(SBD)) {
            if (ketQuaBUS.Delete(SBD, DashBoard.ketQuaThiDTOs)) {
                if (phieuBaoDuThiBUS.Delete(SBD, DashBoard.phieuBaoDuThiDTOs)) {
                    if (thiSinhBUS.UpdateStatusAfterModified(maThiSinh, 2, DashBoard.thiSinhDTOs)) {
                        JOptionPane.showMessageDialog(this, "Xóa thí sinh thành công!");
                        tbModelPTTS.removeRow(rowThiSinh);
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thí sinh thất bại!");
                    }
                    clearPhongThiTS();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không thể xóa\nThí sinh đã thi!");
        }
    }//GEN-LAST:event_jBtnXoaTSPTActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnBackActionPerformed
    {//GEN-HEADEREND:event_jBtnBackActionPerformed
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.remove(jPanelQlyPT);
    }//GEN-LAST:event_jBtnBackActionPerformed

    public String initTenPhong() {
        String tenPhong = "";
        for (TrinhDoDTO trinhDo : DashBoard.trinhDoDTOs) {
            if (trinhDo.getMaTrinhDo().equals(jCbTrinhDo.getSelectedItem().toString().substring(0, 8))) {
                soLuongPG = trinhDo.getSoLuongPG() + 1;
                if (soLuongPG < 1000) {
                    int totalzero = 3;
                    String add = String.valueOf(soLuongPG);
                    int cpzero = totalzero - add.length();
                    String init = "P";
                    for (int i = 0; i < cpzero; i++) {
                        init += '0';
                    }
                    tenPhong = jCbTrinhDo.getSelectedItem().toString().substring(10) + init + add;
                } else {
                    tenPhong = jCbTrinhDo.getSelectedItem().toString().substring(10) + "P" + soLuongPG;
                }
                break;
            }
        }
        return tenPhong;
    }

    private void jTextSBDMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextSBDMouseClicked
    {//GEN-HEADEREND:event_jTextSBDMouseClicked
        // TODO add your handling code here:
        String aString = jLabelTenPhongThi.getText().substring(0, 2);
        jTextSBD.setText(aString + "001");
    }//GEN-LAST:event_jTextSBDMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTabbedPane1MouseClicked
    {//GEN-HEADEREND:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jMenuItemChuaThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChuaThiActionPerformed
        // TODO add your handling code here:
        if (jTablePTTS.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty!!");
        } else {
//            System.out.println(jTableTS.getSelectedRowCount());
            //ArrayList<String> a = new ArrayList<>();
            for (int i = 0; i < jTablePTTS.getRowCount(); i++) {
                if (jTablePTTS.getSelectionModel().isSelectedIndex(i)) {
                    //a.add((String) jTablePTTS.getModel().getValueAt(i, 0));
                    if (phieuBaoDuThiBUS.CheckThiChua((String) jTablePTTS.getModel().getValueAt(i, 2)) && ketQuaBUS.Delete((String) jTablePTTS.getModel().getValueAt(i, 2), DashBoard.ketQuaThiDTOs)) {
                        thiSinhBUS.UpdateStatusAfterModified((String) jTablePTTS.getModel().getValueAt(i, 0), 3, DashBoard.thiSinhDTOs);
                    }
                }
            }
            //System.out.println("List dc chon!!" + a);
        }
    }//GEN-LAST:event_jMenuItemChuaThiActionPerformed

    private void jMenuItemDaThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDaThiActionPerformed
        // TODO add your handling code here:
        if (jTablePTTS.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty!!");
        } else {
//            System.out.println(jTableTS.getSelectedRowCount());
            //ArrayList<String> a = new ArrayList<>();
            for (int i = 0; i < jTablePTTS.getRowCount(); i++) {
                if (jTablePTTS.getSelectionModel().isSelectedIndex(i)) {
                    //a.add((String) jTablePTTS.getModel().getValueAt(i, 0));
                    if (ketQuaBUS.Add(new KetQuaThiDTO((String) jTablePTTS.getModel().getValueAt(i, 2), -1, -1, -1, -1), DashBoard.ketQuaThiDTOs, phieuBaoDuThiBUS.getNgayThiBySBD((String) jTablePTTS.getModel().getValueAt(i, 2)))) {
                        thiSinhBUS.UpdateStatusAfterModified((String) jTablePTTS.getModel().getValueAt(i, 0), 4, DashBoard.thiSinhDTOs);
                    }
                }
            }
            //System.out.println("List dc chon!!" + a);
        }
    }//GEN-LAST:event_jMenuItemDaThiActionPerformed

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

    private void jTextTenPhongThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextTenPhongThiMouseClicked
        // TODO add your handling code here:
        if (flagSua == true) {
            if (phongThiSelected.getMaTrinhDo().equals(jCbTrinhDo.getSelectedItem().toString().substring(0, 8))) {
                jTextTenPhongThi.setText(phongThiSelected.getTenPhongThi());
            } else {
                jTextTenPhongThi.setText(initTenPhong());
            }
        } else {
            jTextTenPhongThi.setText(initTenPhong());
        }
    }//GEN-LAST:event_jTextTenPhongThiMouseClicked

    private void jTablePTTSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePTTSMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePTTSMouseEntered

    private void jTextTimKiemPTTSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemPTTSKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiemPTTS.getText();
        filterPTTS(query);
    }//GEN-LAST:event_jTextTimKiemPTTSKeyReleased

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JButton getjBtnChonGVPT() {
        return jBtnChonGVPT;
    }

    public JButton getjBtnHuyGVPT() {
        return jBtnHuyGVPT;
    }

    public JButton getjBtnHuyTSPT() {
        return jBtnHuyTSPT;
    }

    public JButton getjBtnSuaGVPT() {
        return jBtnSuaGVPT;
    }

    public JButton getjBtnThemGVPT() {
        return jBtnThemGVPT;
    }

    public JButton getjBtnThemTSPT() {
        return jBtnThemTSPT;
    }

    public JButton getjBtnXoaGVPT() {
        return jBtnXoaGVPT;
    }

    public JButton getjBtnXoaTSPT() {
        return jBtnXoaTSPT;
    }

    public JTextField getjTextMaGVPT() {
        return jTextMaGVPT;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnCapPhatMaPT;
    private javax.swing.JButton jBtnChonGVPT;
    private javax.swing.JButton jBtnChoose;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnHuyGVPT;
    private javax.swing.JButton jBtnHuyTSPT;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaGVPT;
    private javax.swing.JButton jBtnSuaPT;
    private javax.swing.JButton jBtnThemGVPT;
    private javax.swing.JButton jBtnThemPT;
    private javax.swing.JButton jBtnThemTSPT;
    private javax.swing.JButton jBtnXoaGVPT;
    private javax.swing.JButton jBtnXoaPT;
    private javax.swing.JButton jBtnXoaTSPT;
    private javax.swing.JComboBox<String> jCbCaThi;
    private javax.swing.JComboBox<String> jCbKhoaThi;
    private javax.swing.JComboBox<NhiemVu> jCbNhiemVu;
    private javax.swing.JComboBox<String> jCbTrinhDo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTenPhongThi;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JLabel jLbTimKiemPTTS;
    private javax.swing.JMenuItem jMenuItemChuaThi;
    private javax.swing.JMenuItem jMenuItemDaThi;
    private javax.swing.JPanel jPanelChonGV;
    private javax.swing.JPanel jPanelChonThiSinh1;
    private javax.swing.JPanel jPanelPT;
    private javax.swing.JPanel jPanelPhongThi;
    private javax.swing.JPanel jPanelQlyPT;
    private javax.swing.JPopupMenu jPopupMenuStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePTGV;
    private javax.swing.JTable jTablePTTS;
    private javax.swing.JTable jTablePhongThi;
    private javax.swing.JTextField jTextMaGVPT;
    private javax.swing.JTextField jTextMaPT;
    private javax.swing.JTextField jTextMaTSPT;
    private javax.swing.JTextField jTextSBD;
    private javax.swing.JTextField jTextSoluong;
    private javax.swing.JTextField jTextTenGVPT;
    private javax.swing.JTextField jTextTenPhongThi;
    private javax.swing.JTextField jTextTenTSPT;
    private javax.swing.JTextField jTextTimKiem;
    private javax.swing.JTextField jTextTimKiemPTTS;
    // End of variables declaration//GEN-END:variables

    public JTextField GetjTextTenGVPT() {
        return jTextTenGVPT;
    }

    public void setjTextMaGVPT(JTextField jTextMaGVPT) {
        this.jTextMaGVPT = jTextMaGVPT;
    }

    public class NhiemVu {

        String type;
        String nhiemVu;

        public NhiemVu(String type, String nhiemVu) {
            this.type = type;
            this.nhiemVu = nhiemVu;
        }

        @Override
        public String toString() {
            return nhiemVu;
        }
    };
}
