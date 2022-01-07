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
import BUS.KhoaThiBUS;
import BUS.ThiSinhBUS;
import BUS.TrinhDoBUS;
import BUS.Utils;
import DTO.KhoaThiDTO;
import DTO.ThiSinhDTO;
import DTO.TrinhDoDTO;
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
public class ThiSinhForm extends javax.swing.JPanel {

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel modelthisinh;
    private int flagAcc;
    private String manv;
//    private NhanVienBUS nhanVienBUS;
//    private DoanDuLichBUS doanDuLichBUS;
    private int selectedRow;
    private ThiSinhBUS thiSinhBUS;
    private KhoaThiBUS khoaThiBUS;
    private TrinhDoBUS trinhDoBUS;
    private Utils utl = new Utils();
//    private Utils ult = new Utils();

    public ThiSinhForm() {
        thiSinhBUS = new ThiSinhBUS();
        khoaThiBUS = new KhoaThiBUS();
        trinhDoBUS = new TrinhDoBUS();

        initComponents();
        jBtnCapPhatMaTS.setEnabled(true);
        jBtnTuyBien.setEnabled(false);
//        jBtnSuaTS1212.setEnabled(false);
        jBtnXoaTS1.setEnabled(false);
        jBtnTaoPhieu.setEnabled(false);
        jBtnCancel1.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
        //loadData();
//        tk.setVisible(false);
    }

    public void initTable() {
        modelthisinh.setRowCount(0);
        DashBoard.thiSinhDTOs = DashBoard.thiSinhDAO.getList();
        tableModel(modelthisinh);
        jTableTS.setRowSorter(null);
        jTableTS.setAutoCreateRowSorter(true);
        jTableTS.setModel(modelthisinh);
        jTableTS.clearSelection();
        clear();
    }

    public void tableModel(TableModel model) {
        Vector row = null;

        for (ThiSinhDTO thisinh : DashBoard.thiSinhDTOs) {
            row = new Vector();
            row.add(thisinh.getMaKhoaThi());
            row.add(thisinh.getMaThiSinh());
            row.add(thisinh.getHoTen());
            if (thisinh.getGioiTinh().equals("1")) {
                row.add("Nam");
            } else {
                row.add("Nữ");
            }
            row.add(thisinh.getNgaySinh());
            row.add(thisinh.getSdt());
            row.add(thisinh.getDiaChi());
            row.add(thisinh.getMail());
            row.add(thisinh.getCmnd());
            row.add(thisinh.getNgayCap());
            row.add(thisinh.getNoiCap());

            // bỏ tên trình độ vào đây
            for (TrinhDoDTO trinhDo : DashBoard.trinhDoDTOs) {
                if (trinhDo.getMaTrinhDo().equals(thisinh.getMaTrinhDo())) {
                    row.add(trinhDo.getTenTrinhDo());
                }
            }

            switch (thisinh.getTinhTrang()) {
                case 1:
                    row.add("Chưa đóng tiền");
                    break;
                case 2:
                    row.add("Đã đóng tiền");
                    break;
                case 3:
                    row.add("Chưa thi");
                    break;
                case 4:
                    row.add("Đã thi");
                    break;
            }

            modelthisinh.addRow(row);

        }
    }

    public void fillTheForm(ThiSinhDTO thiSinh) {
        jCbKhoaThi.setSelectedItem(khoaThiBUS.findKhoaThi(thiSinh.getMaKhoaThi(), DashBoard.khoaThiDTOs));
        jTextMaThiSinh.setText(thiSinh.getMaThiSinh());
        jTextTenThiSinh.setText(thiSinh.getHoTen());
        if (thiSinh.getGioiTinh().equals("1")) {
            jCbGioiTinh.setSelectedIndex(1);
        } else {
            jCbGioiTinh.setSelectedIndex(0);
        }

        jDateNgaySinh.setDate(utl.stringToDate(thiSinh.getNgaySinh()));
        jCbTrinhDo.setSelectedItem(trinhDoBUS.findTrinhDo(thiSinh.getMaTrinhDo(), DashBoard.trinhDoDTOs));
        jTextSDT.setText(thiSinh.getSdt());
        jTextDiaChi.setText(thiSinh.getDiaChi());
        jTextEmail.setText(thiSinh.getMail());
        jTextCMND.setText(thiSinh.getCmnd());
        jDateNgayCap.setDate(utl.stringToDate(thiSinh.getNgayCap()));
        jTextNoiCap.setText(thiSinh.getNoiCap());

    }

    public void loadComboBox() {
        jCbKhoaThi.removeAllItems();
        jCbTrinhDo.removeAllItems();
        for (KhoaThiDTO kt : DashBoard.khoaThiDTOs) {
            jCbKhoaThi.addItem(kt);
            //jComboBoxKT.addItem(kt);
        }

        //Phần trình độ xong thì bỏ //
        for (TrinhDoDTO td : DashBoard.trinhDoDTOs) {
            jCbTrinhDo.addItem(td);
            //jComboBoxKT.addItem(kt);
        }
    }

//    public void loadData()
//    {
//        nhanVienBUS = new NhanVienBUS();
//        doanDuLichBUS = new DoanDuLichBUS();
//        modelnv.setRowCount(0);
//        tbModelNhanVien(modelnv);
//    }
//    public void tbModelNhanVien(DefaultTableModel model)
//    {
//        Vector row;
//        for (NhanVienDTO a : DashBoard.nhanVienDTOs)
//        {
//            row = new Vector();
//            row.add(a.getMaNhanVien());
//            row.add(a.getTenNhanVien());
//            if (a.getGioiTinh().equals("1"))
//            {
//                row.add("Nam");
//            } else
//            {
//                row.add("Nữ");
//            }
//            row.add(a.getNgaySinh());
//            row.add(a.getSDT());
//            row.add(a.getDiaChi());
//            model.addRow(row);
//        }
//    }
//    public boolean add(String maNhanVien, String tenNhanVien, String gioiTinh, String ngaySinh, String sdt, String diaChi)
//    {
//        return nhanVienBUS.add(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi), DashBoard.nhanVienDTOs);
//    }
//
//    public boolean update(String maNhanVien, String tenNhanVien, String gioiTinh, String ngaySinh, String sdt, String diaChi)
//    {
//        return nhanVienBUS.update(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi), DashBoard.nhanVienDTOs);
//    }
//
//    public boolean delete(String maNhanVien)
//    {
//        return nhanVienBUS.delete(maNhanVien, DashBoard.nhanVienDTOs);
//    }
//    public void searchNhanVienByMaNhanVien(DefaultTableModel model, String maNhanVien)
//    {
//        Vector row;
//        for (NhanVienDTO a : nhanVienBUS.searchNhanVienByMaNhanVien(maNhanVien, DashBoard.nhanVienDTOs))
//        {
//            row = new Vector();
//            System.out.println(a);
//            row.add(a.getMaNhanVien());
//            row.add(a.getTenNhanVien());
//            if (a.getGioiTinh().equals("1"))
//            {
//                row.add("Nam");
//            } else
//            {
//                row.add("Nữ");
//            }
//            row.add(a.getNgaySinh());
//            row.add(a.getSDT());
//            row.add(a.getDiaChi());
//            model.addRow(row);
//            break;
//        }
//    }
//    public void tbModelThongKeNhanVien(DefaultTableModel model, Date start, Date end)
//    {
//        //ArrayList<NhanVienDTO> arr = new ArrayList<>();
//        ArrayList<DoanDuLichDTO> arrDoan = doanDuLichBUS.searchDoanByDate(start, end, DashBoard.doanDuLichDTOs);
//        Vector rowVector;
////        if(jDateNgayBDTK.getDate()!=null&&jDateNgayKTTK.getDate()!=null)
//        if (arrDoan.size() > 0)
//        {
//            int count = 0;
//
//            for (NhanVienDTO a : DashBoard.nhanVienDTOs)
//            {
//                rowVector = new Vector();
//                for (NhiemVuNhanVienDTO b : DashBoard.nhiemVuNhanVienDTOs)
//                {
//                    for (DoanDuLichDTO c : arrDoan)
//                    {
//                        if ((a.getMaNhanVien().equals(b.getMaNhanVien())) && (b.getMaDoan().equals(c.getMaDoan())))
//                        {
//                            count++;
//                        }
//                    }
//                }
//                rowVector.add(a.getMaNhanVien());
//                rowVector.add(a.getTenNhanVien());
//                rowVector.add(count);
////                System.out.println(rowVector);
//                model.addRow(rowVector);
//                count = 0;
//            }
//        } else
//        {
//            for (NhanVienDTO a : DashBoard.nhanVienDTOs)
//            {
//                rowVector = new Vector();
//                rowVector.add(a.getMaNhanVien());
//                rowVector.add(a.getTenNhanVien());
//                rowVector.add(0);
//            }
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemChuaDong = new javax.swing.JMenuItem();
        jMenuItemDaDong = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelQLTS = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTS = new javax.swing.JTable();
        jBtnCancel1 = new javax.swing.JButton();
        jBtnXoaTS1 = new javax.swing.JButton();
        jBtnThemTS1 = new javax.swing.JButton();
        jBtnTaoPhieu = new javax.swing.JButton();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();
        jPanelTS = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnTuyBien = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextMaThiSinh = new javax.swing.JTextField();
        jBtnCapPhatMaTS = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTenThiSinh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox<>();
        jTextDiaChi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextCMND = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCbKhoaThi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCbTrinhDo = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jDateNgayCap = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jTextNoiCap = new javax.swing.JTextField();

        jMenuItemChuaDong.setText("Chưa đóng tiền");
        jMenuItemChuaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChuaDongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemChuaDong);

        jMenuItemDaDong.setText("Đã đóng tiền");
        jMenuItemDaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDaDongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemDaDong);

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelQLTS.setBackground(new java.awt.Color(233, 242, 249));
        jPanelQLTS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelQLTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setAutoscrolls(true);

        jTableTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTSMouseClicked(evt);
            }
        });
        tableCol.add ("Mã Khóa Thi");
        tableCol.add ("Mã Thí Sinh");
        tableCol.add ("Họ Tên Thí Sinh");
        tableCol.add ("Giới Tính");
        tableCol.add ("Ngày Sinh");
        tableCol.add ("SĐT");
        tableCol.add ("Địa Chỉ");
        tableCol.add ("Email");
        tableCol.add ("CMND");
        tableCol.add ("Ngày Cấp");
        tableCol.add ("Nơi Cấp");
        tableCol.add ("Trình Độ");
        tableCol.add ("Tình Trạng");
        modelthisinh = new DefaultTableModel(tableCol, 20){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableTS.setModel(modelthisinh);
        jTableTS.setShowGrid(true);
        jTableTS.setFocusable(false);
        jTableTS.setIntercellSpacing(new Dimension(0,0));
        jTableTS.setRowHeight(25);
        jTableTS.getTableHeader().setOpaque(false);
        jTableTS.setFillsViewportHeight(true);
        jTableTS.getTableHeader().setBackground(new Color(232,57,99));
        jTableTS.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableTS.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableTS.setSelectionBackground(new Color(52,152,219));
        jTableTS.setGridColor(new java.awt.Color(83, 86, 88));

        jTableTS.getColumn (tableCol.elementAt (0)).setPreferredWidth (130);
        jTableTS.getColumn (tableCol.elementAt (1)).setPreferredWidth (130);
        jTableTS.getColumn (tableCol.elementAt (2)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (3)).setPreferredWidth (100);
        jTableTS.getColumn (tableCol.elementAt (4)).setPreferredWidth (140);
        jTableTS.getColumn (tableCol.elementAt (5)).setPreferredWidth (150);
        jTableTS.getColumn (tableCol.elementAt (6)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (7)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (8)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (9)).setPreferredWidth (140);
        jTableTS.getColumn (tableCol.elementAt (10)).setPreferredWidth (160);
        jTableTS.getColumn (tableCol.elementAt (11)).setPreferredWidth (110);
        jTableTS.getColumn (tableCol.elementAt (12)).setPreferredWidth (130);
        jTableTS.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane5.setViewportView(jTableTS);

        jPanelQLTS.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 450));

        jBtnCancel1.setBackground(new java.awt.Color(233, 242, 249));
        jBtnCancel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel32.png"))); // NOI18N
        jBtnCancel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnCancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnCancel1MouseClicked(evt);
            }
        });
        jBtnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancel1ActionPerformed(evt);
            }
        });
        jPanelQLTS.add(jBtnCancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 30));

        jBtnXoaTS1.setBackground(new java.awt.Color(233, 242, 249));
        jBtnXoaTS1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaTS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-32.png"))); // NOI18N
        jBtnXoaTS1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnXoaTS1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaTS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaTS1ActionPerformed(evt);
            }
        });
        jPanelQLTS.add(jBtnXoaTS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 30));

        jBtnThemTS1.setBackground(new java.awt.Color(233, 242, 249));
        jBtnThemTS1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemTS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-32.png"))); // NOI18N
        jBtnThemTS1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnThemTS1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemTS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemTS1ActionPerformed(evt);
            }
        });
        jPanelQLTS.add(jBtnThemTS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 30));

        jBtnTaoPhieu.setBackground(new java.awt.Color(233, 242, 249));
        jBtnTaoPhieu.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnTaoPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-create-32.png"))); // NOI18N
        jBtnTaoPhieu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jBtnTaoPhieu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnTaoPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTaoPhieuActionPerformed(evt);
            }
        });
        jPanelQLTS.add(jBtnTaoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelQLTS.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelQLTS.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 140, 30));

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
        jPanelQLTS.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 40, 30));

        jTabbedPane1.addTab("Danh Sách Thí Sinh", jPanelQLTS);

        jPanelTS.setBackground(new java.awt.Color(233, 242, 249));
        jPanelTS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hồ Sơ Thí Sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jBtnTuyBien.setBackground(new java.awt.Color(136, 193, 184));
        jBtnTuyBien.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnTuyBien.setText("Tùy Biến");
        jBtnTuyBien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnTuyBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTuyBienActionPerformed(evt);
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
        jLabel4.setText("<html> <body> Mã Thí Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaThiSinh.setEditable(false);
        jTextMaThiSinh.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaThiSinh.setEditable(false);

        jBtnCapPhatMaTS.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaTS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaTS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaTSActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Họ Tên Thí Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>SĐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSDTActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Sinh<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jDateNgaySinh.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateNgaySinh.getDateEditor();
        editor1.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Giới Tính <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jCbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbGioiTinhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Địa Chỉ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("<html> <body>Email <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("<html> <body>CMND<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("<html> <body> Mã Khóa Thi<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jCbKhoaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbKhoaThiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("<html> <body>Trình Độ <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jCbTrinhDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbTrinhDoActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("<html> <body>Ngày Cấp<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jDateNgayCap.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayCap.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateNgayCap.getDateEditor();
        editor2.setEditable(false);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("<html> <body>Nơi Cấp<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtnTuyBien)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jTextTenThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jCbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jTextMaThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnCapPhatMaTS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnHuy))
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbTrinhDo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateNgayCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jTextCMND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextMaThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnCapPhatMaTS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateNgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbTrinhDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTenThiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnTuyBien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanelTS.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 840, 470));

        jTabbedPane1.addTab("Quản Lý Thí Sinh", jPanelTS);

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

    private void jBtnCapPhatMaTSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaTSActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaTSActionPerformed
        // TODO add your handling code here:
        jTextMaThiSinh.setText(thiSinhBUS.capPhat());

        jBtnCapPhatMaTS.setEnabled(false);
        jBtnTuyBien.setEnabled(true);
        jBtnHuy.setEnabled(true);
        jDateNgayCap.setCalendar(null);
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnCapPhatMaTSActionPerformed

    private void jBtnTuyBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTuyBienActionPerformed

//        KhoaThiDTO khoaThiTemp = (KhoaThiDTO) jCbKhoaThi.getSelectedItem();
//        System.out.println(khoaThiTemp.getMaKhoaThi());
        String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String ngayCap = (String) ((JTextField) jDateNgayCap.getDateEditor().getUiComponent()).getText();
        ThiSinhDTO thiSinh = new ThiSinhDTO();
        thiSinh.setMaThiSinh(jTextMaThiSinh.getText());
        thiSinh.setHoTen(jTextTenThiSinh.getText());
        if (jCbGioiTinh.getSelectedItem().equals("Nam")) {
            thiSinh.setGioiTinh("1");
        } else {
            thiSinh.setGioiTinh("0");
        }
        thiSinh.setNgaySinh(ngaySinh);
        TrinhDoDTO trinhDo = (TrinhDoDTO) jCbTrinhDo.getSelectedItem();
        thiSinh.setMaTrinhDo(trinhDo.getMaTrinhDo());
        thiSinh.setSdt(jTextSDT.getText());
        thiSinh.setDiaChi(jTextDiaChi.getText());
        thiSinh.setMail(jTextEmail.getText());
        thiSinh.setCmnd(jTextCMND.getText());
        thiSinh.setNgayCap(ngayCap);
        thiSinh.setNoiCap(jTextNoiCap.getText());
        KhoaThiDTO khoaThiTemp = (KhoaThiDTO) jCbKhoaThi.getSelectedItem();
        thiSinh.setMaKhoaThi(khoaThiTemp.getMaKhoaThi());

        if (!jBtnThemTS1.isEnabled()) // Ch?c nang cho them
        {
            String valString = validation();
            if (valString.equals("")) {
                if (thiSinhBUS.Add(thiSinh, DashBoard.thiSinhDTOs)) {
                    JOptionPane.showMessageDialog(this, "Thêm thí sinh thành công!");
                    initTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thí sinh thất bại!");
                    clear();
                }
            } else {
                JOptionPane.showMessageDialog(this, valString);
            }
        } else // Ch?c nang cho Sửa
        {
            String valString = validation();
            if (valString.equals("")) {
                if (thiSinhBUS.Update(thiSinh, DashBoard.thiSinhDTOs)) {
                    JOptionPane.showMessageDialog(this, "Sửa thí sinh thành công!");
                    initTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thí sinh thất bại!");
                    clear();
                }
            } else {
                JOptionPane.showMessageDialog(this, valString);
            }
        }

    }//GEN-LAST:event_jBtnTuyBienActionPerformed

    public void clear() {
        jBtnCapPhatMaTS.setEnabled(true);
        jBtnTuyBien.setEnabled(false);
        jBtnHuy.setEnabled(true);
        jBtnXoaTS1.setEnabled(false);
        jBtnTaoPhieu.setEnabled(false);
        jBtnCancel1.setEnabled(false);
        jBtnThemTS1.setEnabled(true);

        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
        jTextEmail.setText("");
        jTextCMND.setText("");
        jTextNoiCap.setText("");
        jDateNgayCap.setCalendar(null);
        jTableTS.clearSelection();

        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.remove(jPanelTS);
    }

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        clear();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jCbGioiTinhActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbGioiTinhActionPerformed
    {//GEN-HEADEREND:event_jCbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbGioiTinhActionPerformed

    private void jCbKhoaThiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbKhoaThiActionPerformed
    {//GEN-HEADEREND:event_jCbKhoaThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbKhoaThiActionPerformed

    private void jTableTSMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTSMouseClicked
    {//GEN-HEADEREND:event_jTableTSMouseClicked
        // TODO add your handling code here:
        selectedRow = jTableTS.getSelectedRow();
        if (evt.getClickCount() >= 2) {
            loadComboBox();
            JTable tempJTable = (JTable) evt.getSource();
            int row = tempJTable.getSelectedRow();

            String maThiSinh = (String) jTableTS.getValueAt(selectedRow, 1);

            fillTheForm(thiSinhBUS.findByMaThiSinh(maThiSinh));

            if (row != -1) {

                System.out.println("Rơ ch?n : " + row);
                jTabbedPane1.add(jPanelTS, 1);
                jTabbedPane1.setTitleAt(1, "Quản Lý Thí Sinh");
                jTabbedPane1.setSelectedIndex(1);
                jTabbedPane1.setEnabledAt(0, false);
                jTabbedPane1.setSelectedIndex(1);
            }
            jBtnTuyBien.setText("Sửa");
            jBtnTuyBien.setEnabled(true);
            jBtnHuy.setEnabled(true);
            jBtnCapPhatMaTS.setEnabled(false);
        } else {
            JTable tempJTable = (JTable) evt.getSource();
            int row = tempJTable.getSelectedRow();
            if (row != -1) {
                jBtnXoaTS1.setEnabled(true);
                jBtnTaoPhieu.setEnabled(true);
                jBtnCancel1.setEnabled(true);
                if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
//                    JOptionPane.showMessageDialog(this, "button1");
                    jPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }

        }

    }//GEN-LAST:event_jTableTSMouseClicked

    private void jCbTrinhDoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbTrinhDoActionPerformed
    {//GEN-HEADEREND:event_jCbTrinhDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbTrinhDoActionPerformed

    private void jTextSDTActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextSDTActionPerformed
    {//GEN-HEADEREND:event_jTextSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSDTActionPerformed

    private void jBtnCancel1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnCancel1MouseClicked
    {//GEN-HEADEREND:event_jBtnCancel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jBtnCancel1MouseClicked

    private void jBtnThemTS1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemTS1ActionPerformed
    {//GEN-HEADEREND:event_jBtnThemTS1ActionPerformed
        // TODO add your handling code here:
        loadComboBox();
        jBtnThemTS1.setEnabled(false);
        jTabbedPane1.add(jPanelTS, 1);
        jTabbedPane1.setTitleAt(1, "Quản Lý Thí Sinh");
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(0, false);
        jTabbedPane1.setSelectedIndex(1);
        jBtnTuyBien.setEnabled(false);
        jBtnTuyBien.setText("Thêm");
        jBtnHuy.setEnabled(true);

    }//GEN-LAST:event_jBtnThemTS1ActionPerformed

    private void jBtnCancel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCancel1ActionPerformed
    {//GEN-HEADEREND:event_jBtnCancel1ActionPerformed
        // TODO add your handling code here:
        jBtnTaoPhieu.setEnabled(false);
        jBtnXoaTS1.setEnabled(false);
        jBtnCancel1.setEnabled(false);
        jTableTS.clearSelection();
    }//GEN-LAST:event_jBtnCancel1ActionPerformed

    private void jBtnTaoPhieuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnTaoPhieuActionPerformed
    {//GEN-HEADEREND:event_jBtnTaoPhieuActionPerformed
        // TODO add your handling code here:
        modelthisinh.getValueAt(selectedRow, 0);

        PhieuBaoDuThi pbdt = new PhieuBaoDuThi();
        ThiSinhDTO thiSinh = thiSinhBUS.findByMaThiSinh((String) modelthisinh.getValueAt(selectedRow, 1));
        pbdt.fillTheForm(thiSinh, khoaThiBUS.findTenKhoaKhoaThi(thiSinh.getMaKhoaThi(), DashBoard.khoaThiDTOs), trinhDoBUS.findTenTrinhDo(thiSinh.getMaTrinhDo(), DashBoard.trinhDoDTOs));
        pbdt.thiSinhForm = this;
    }//GEN-LAST:event_jBtnTaoPhieuActionPerformed

    private void jMenuItemChuaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChuaDongActionPerformed
        // TODO add your handling code here:
        if (jTableTS.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty!!");
        } else {
//            System.out.println(jTableTS.getSelectedRowCount());
            //ArrayList<String> a = new ArrayList<>();
            String noti = "";
            for (int i = 0; i < jTableTS.getRowCount(); i++) {
                if (jTableTS.getSelectionModel().isSelectedIndex(i)) {
                    if (thiSinhBUS.UpdataStatus((String) jTableTS.getModel().getValueAt(i, 1), 2, DashBoard.thiSinhDTOs)) {
                        jTableTS.getModel().setValueAt("Chưa đóng tiền", i, 12);
                        noti += "Cập nhật thành công thí sinh " + (String) jTableTS.getModel().getValueAt(i, 1) + "\n";
                    } else {
                        System.out.println((String) jTableTS.getModel().getValueAt(i, 2) + "Dang da duoc them vao phong thi");
                        noti += "Cập nhật thất bại thí sinh " + (String) jTableTS.getModel().getValueAt(i, 1) + "\n";
                    }
                }
            }
            JOptionPane.showMessageDialog(this, noti);
        }
    }//GEN-LAST:event_jMenuItemChuaDongActionPerformed

    private void jMenuItemDaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDaDongActionPerformed
        // TODO add your handling code here:
        if (jTableTS.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty!!");
        } else {
//            System.out.println(jTableTS.getSelectedRowCount());
            // ArrayList<String> a = new ArrayList<>();
            String noti = "";
            for (int i = 0; i < jTableTS.getRowCount(); i++) {
                if (jTableTS.getSelectionModel().isSelectedIndex(i)) {
                    if (thiSinhBUS.UpdataStatus((String) jTableTS.getModel().getValueAt(i, 1), 2, DashBoard.thiSinhDTOs)) {
                        jTableTS.getModel().setValueAt("Đã đóng tiền", i, 12);
                        noti += "Cập nhật thành công thí sinh " + (String) jTableTS.getModel().getValueAt(i, 1) + "\n";
                    } else {
                        System.out.println((String) jTableTS.getModel().getValueAt(i, 2) + "Dang da duoc them vao phong thi khong duoc thay doi trang thai");
                        noti += "Cập nhật thất bại thí sinh " + (String) jTableTS.getModel().getValueAt(i, 1) + "\n";
                    }
                }
            }
            JOptionPane.showMessageDialog(this, noti);
        }
    }//GEN-LAST:event_jMenuItemDaDongActionPerformed

    private void jBtnXoaTS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaTS1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Dong dc chon: " + selectedRow + "   Gia tri dc chon:  " + (String) modelthisinh.getValueAt(selectedRow, 1));
        String maThiSinh = (String) modelthisinh.getValueAt(selectedRow, 1);
        if (thiSinhBUS.Delete(maThiSinh, DashBoard.thiSinhDTOs, DashBoard.phieuBaoDuThiDTOs)) {
            modelthisinh.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Xóa thí sinh thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thí sinh thất bại!");
        }
        clear();
    }//GEN-LAST:event_jBtnXoaTS1ActionPerformed

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelthisinh);
        jTableTS.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

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

    public String validation() {
        String validate = "";
        String tenTS = jTextTenThiSinh.getText();
        String ngaySinhTS = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String SDT = jTextSDT.getText();
        String diachi = jTextDiaChi.getText();
        String email = jTextEmail.getText();
        String cmnd = jTextCMND.getText();
        String ngayCap = (String) ((JTextField) jDateNgayCap.getDateEditor().getUiComponent()).getText();
        String noicap = jTextNoiCap.getText();
        if (tenTS.equals("") || ngaySinhTS.equals("") || SDT.equals("") || diachi.equals("")
                || email.equals("") || cmnd.equals("") || ngayCap.equals("") || noicap.equals("")) {
            validate += "Các trường thông tin không được bỏ trống!\n";
            return validate;
        } else {
            String tenPattern = "^[^-\\s][a-zA-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
            boolean flag1 = Pattern.matches(tenPattern, tenTS);
            if (!flag1) {
                validate += "Tên thí thi không hợp lệ!\n";
            }

            int hientai = Calendar.getInstance().get(Calendar.YEAR);
            int year = Integer.parseInt(ngaySinhTS.substring(0, 4));
            int namsinh = hientai - year;
            if (namsinh >= 80) {
                validate += "Tuổi thí sinh không hợp lệ!\n";
            }

            String sdtPattern = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
            boolean flag2 = Pattern.matches(sdtPattern, SDT);
            if (!flag2) {
                validate += "Số điện thoại không hợp lệ!\n";
            }

            String diachiPattern = "^[^-\\s][a-zA-Z0-9 ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
            boolean flag3 = Pattern.matches(diachiPattern, diachi);
            if (!flag3) {
                validate += "Địa chỉ không hợp lệ!\n";
            }

            String emailPattern = "^[a-zA-Z][a-zA-Z0-9_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            boolean flag4 = Pattern.matches(emailPattern, jTextEmail.getText());
            if (!flag4) {
                validate += "Email không hợp lệ!\n";
            }

            String cmndPattern = "^(0\\d{11})$";
            boolean flag5 = Pattern.matches(cmndPattern, cmnd);
            if (!flag5) {
                validate += "CMND không hợp lệ!\n";
            }

            int hientai2 = Calendar.getInstance().get(Calendar.YEAR);
            int year2 = Integer.parseInt(ngayCap.substring(0, 4));
            int ngaycmnd = hientai2 - year2;
            if (ngaycmnd >= 20) {
                validate += "Ngày cấp không hợp lệ!\n";
            }

            String noicapPattern = "^[^-\\s][a-zA-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
            boolean flag6 = Pattern.matches(noicapPattern, noicap);
            if (!flag6) {
                validate += "Nơi cấp không hợp lệ!\n";
            }

        }
        return validate;
    }

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
        return modelthisinh;
    }

    public JButton getjBtnCapPhatMaNV() {
        return jBtnCapPhatMaTS;
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

//    public JButton getjBtnRefresh()
//    {
//        return jBtnRefresh;
//    }
//
//    public void setjBtnRefresh(JButton jBtnRefresh)
//    {
//        this.jBtnRefresh = jBtnRefresh;
//    }
    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JButton getjBtnCancel1() {
        return jBtnCancel1;
    }

    public JButton getjBtnTaoPhieu() {
        return jBtnTaoPhieu;
    }

    public JButton getjBtnThemTS1() {
        return jBtnThemTS1;
    }

    public JButton getjBtnXoaTS1() {
        return jBtnXoaTS1;
    }

    public class TinhTrang {

        public String tinhTrang;
        public int num;

        public TinhTrang(String tinhTrang, int num) {
            this.tinhTrang = tinhTrang;
            this.num = num;
        }

        @Override
        public String toString() {
            return tinhTrang;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancel1;
    private javax.swing.JButton jBtnCapPhatMaTS;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnTaoPhieu;
    private javax.swing.JButton jBtnThemTS1;
    private javax.swing.JButton jBtnTuyBien;
    private javax.swing.JButton jBtnXoaTS1;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private javax.swing.JComboBox<KhoaThiDTO> jCbKhoaThi;
    private javax.swing.JComboBox<TrinhDoDTO> jCbTrinhDo;
    private com.toedter.calendar.JDateChooser jDateNgayCap;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JMenuItem jMenuItemChuaDong;
    private javax.swing.JMenuItem jMenuItemDaDong;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelQLTS;
    private javax.swing.JPanel jPanelTS;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableTS;
    private javax.swing.JTextField jTextCMND;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextMaThiSinh;
    private javax.swing.JTextField jTextNoiCap;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenThiSinh;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
