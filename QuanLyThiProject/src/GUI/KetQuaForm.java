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

/**
 *
 * @author Hyung
 */
public class KetQuaForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel modelthisinh, modelThongKe;
    private int flagAcc;
    private String manv;
//    private NhanVienBUS nhanVienBUS;
//    private DoanDuLichBUS doanDuLichBUS;
    private int selectedRow;
//    private Utils ult = new Utils();

    public KetQuaForm()
    {
        initComponents();
        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");
        //loadData();
//        tk.setVisible(false);
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
    private void initComponents()
    {

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
        jTextTimKiemTS = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTS = new javax.swing.JTable();
        jPanelThongkeTS = new javax.swing.JPanel();
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
        jBtnSuaDiem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnSuaDiemActionPerformed(evt);
            }
        });

        jBtnHuyDiem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyDiem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyDiem.setText("Hủy");
        jBtnHuyDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyDiem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSuaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuyDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelTS.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, 550));

        jTextTimKiemTS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTimKiemTSActionPerformed(evt);
            }
        });
        jPanelTS.add(jTextTimKiemTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 160, 30));

        jButtonTimKiem.setText("Tìm kiếm");
        jButtonTimKiem.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonTimKiemActionPerformed(evt);
            }
        });
        jPanelTS.add(jButtonTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

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
        jPanelTS.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 40, 30));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setAutoscrolls(true);

        jTableTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTableTS.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableTSMouseClicked(evt);
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

        modelthisinh = new DefaultTableModel(tableCol, 20)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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

        jTableTS.getColumn (tableCol.elementAt (0)).setPreferredWidth (140);
        jTableTS.getColumn (tableCol.elementAt (1)).setPreferredWidth (140);
        jTableTS.getColumn (tableCol.elementAt (2)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (3)).setPreferredWidth (160);
        jTableTS.getColumn (tableCol.elementAt (4)).setPreferredWidth (110);
        jTableTS.getColumn (tableCol.elementAt (5)).setPreferredWidth (130);
        jTableTS.getColumn (tableCol.elementAt (6)).setPreferredWidth (170);
        jTableTS.getColumn (tableCol.elementAt (7)).setPreferredWidth (110);
        jTableTS.getColumn (tableCol.elementAt (8)).setPreferredWidth (110);
        jTableTS.getColumn (tableCol.elementAt (9)).setPreferredWidth (110);
        jTableTS.getColumn (tableCol.elementAt (10)).setPreferredWidth (110);
        jTableTS.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(jTableTS);

        jPanelTS.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 530, 530));

        jTabbedPane1.addTab("Quản Lý KQ", jPanelTS);

        jPanelThongkeTS.setBackground(new java.awt.Color(233, 242, 249));
        jPanelThongkeTS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelThongkeTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonThongKe.setText("Thống Kê");
        jButtonThongKe.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonThongKeActionPerformed(evt);
            }
        });
        jPanelThongkeTS.add(jButtonThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 120, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

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
        tableColThongKe.add ("Mã Nhân Viên");
        tableColThongKe.add ("Tên Nhân Viên");
        tableColThongKe.add ("Số Lần Đi Tour");
        modelThongKe = new DefaultTableModel(tableColThongKe, 0)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableThongke.setModel(modelThongKe);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(modelThongKe);
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

        jPanelThongkeTS.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 950, 520));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Băt Đầu<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelThongkeTS.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jDateNgayBDTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayBDTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateNgayBDTK.getDateEditor();
        editor2.setEditable(false);
        jPanelThongkeTS.add(jDateNgayBDTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelThongkeTS.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 30));

        jDateNgayKTTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKTTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor3 = (JTextFieldDateEditor) jDateNgayKTTK.getDateEditor();
        editor3.setEditable(false);
        jPanelThongkeTS.add(jDateNgayKTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 180, 30));

        jTabbedPane1.addTab("Thống Kê", jPanelThongkeTS);

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

        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");
        jTableTS.clearSelection();
    }//GEN-LAST:event_jBtnSuaDiemActionPerformed

    private void jBtnHuyDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyDiemActionPerformed

   
        jBtnSuaDiem.setEnabled(false);
        jBtnHuyDiem.setEnabled(false);
        jTextMaThiSinh.setText("");
        jTextTenThiSinh.setText("");
        jTextDiemNghe.setText("");
        jTextDiemNoi.setText("");

        jTableTS.clearSelection();
    }//GEN-LAST:event_jBtnHuyDiemActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonThongKeActionPerformed
    {//GEN-HEADEREND:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:
        modelThongKe.setRowCount(0);
        if (jDateNgayBDTK.getDate() == null || jDateNgayKTTK.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Ngày Bắt Đầu và Ngày Kết Thúc không được bỏ trống!");
            return;
        }
        String ngayBD = (String) ((JTextField) jDateNgayBDTK.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateNgayKTTK.getDateEditor().getUiComponent()).getText();
        //Validation
        StringBuilder message = new StringBuilder();
//        Validation.afterOrEquals(message, "Ngày kết thúc", ngayKT, "Ngày bắt đầu", ngayBD);
//        if (!message.toString().equals(""))
//        {
//            JOptionPane.showMessageDialog(this, message.toString());
//            return;
//        }
//        tbModelThongKeNhanVien(modelThongKe, jDateNgayBDTK.getDate(), jDateNgayKTTK.getDate());
    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jTableThongkeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThongkeMouseClicked
    {//GEN-HEADEREND:event_jTableThongkeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThongkeMouseClicked

    private void jTextTimKiemTSActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTimKiemTSActionPerformed
    {//GEN-HEADEREND:event_jTextTimKiemTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTimKiemTSActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTimKiemActionPerformed
    {//GEN-HEADEREND:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefreshActionPerformed
    {//GEN-HEADEREND:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jTableTSMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTSMouseClicked
    {//GEN-HEADEREND:event_jTableTSMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableTSMouseClicked

//    Vector tableRow = new Vector ();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableCol = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tableColThongKe = new Vector();

    public JPanel getjPanel1()
    {
        return jPanelTS;
    }

    public JTextField getjTextManv()
    {
        return jTextMaThiSinh;
    }

    public DefaultTableModel getModelnv()
    {
        return modelthisinh;
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

    public JTextField getjTextTimKiemNV()
    {
        return jTextTimKiemTS;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV)
    {
        this.jTextTimKiemTS = jTextTimKiemNV;
    }

    public JButton getjButtonTimKiem()
    {
        return jButtonTimKiem;
    }

    public void setjButtonTimKiem(JButton jButtonTimKiem)
    {
        this.jButtonTimKiem = jButtonTimKiem;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnHuyDiem;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaDiem;
    private javax.swing.JButton jButtonThongKe;
    private javax.swing.JButton jButtonTimKiem;
    private com.toedter.calendar.JDateChooser jDateNgayBDTK;
    private com.toedter.calendar.JDateChooser jDateNgayKTTK;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelTS;
    private javax.swing.JPanel jPanelThongkeTS;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableTS;
    private javax.swing.JTable jTableThongke;
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
    private javax.swing.JTextField jTextTimKiemTS;
    private javax.swing.JTextField jTextTrinhDo;
    // End of variables declaration//GEN-END:variables
}
