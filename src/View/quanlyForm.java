package View;

//import com.opencsv.CSVWriter;
import controller.CSVdt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Student;
import controller.CSVread;
import java.io.BufferedWriter;

public class quanlyForm extends javax.swing.JFrame {

    public quanlyForm() {
        initComponents();
        loadDataToComboBox();
        loadLopHocToComboBox();
        repaint();

        CSVdt.loadDataHocSinhFromCSV("file_hocsinh.csv", jTable1);
        String filePathGiaoVien = "file_giaovien.csv";
        loadGiaoVienData(filePathGiaoVien, jTable2);

    }

    private void loadDataToComboBox() {
        try (BufferedReader br = new BufferedReader(new FileReader("file_hocsinh.csv"))) {
            String headerLine = br.readLine();

            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                jComboBoxLocLop.setModel(new DefaultComboBoxModel<>(headers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGiaoVienData(String filePath, JTable jTable) {
        File fileGiaoVien = new File(filePath);

        if (fileGiaoVien.exists()) {
            CSVdt.loadDataGiaoVienFromCSV(filePath, jTable);
        } else {
            System.out.println("File giáo viên không tồn tại: " + filePath);
        }
    }

    private void timKiemTheoTen(String ten) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + ten, 1);

        sorter.setRowFilter(rowFilter);
    }

    private void timKiemTheoTen1(String tenCanTim) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable2.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + tenCanTim);
        sorter.setRowFilter(rowFilter);
    }

    private void loadLopHocToComboBox() {
        Set<String> lopHocSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("file_hocsinh.csv"))) {
            String headerLine = br.readLine();
            int lopHocIndex = -1;

            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                for (int i = 0; i < headers.length; i++) {
                    if (headers[i].trim().equalsIgnoreCase("Lớp học")) {
                        lopHocIndex = i;
                        break;
                    }
                }
            }

            if (lopHocIndex != -1) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length > lopHocIndex) {
                        lopHocSet.add(data[lopHocIndex].trim());
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(lopHocSet.toArray(new String[0]));
        jComboBoxLocLop.setModel(comboBoxModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFieldMSV = new javax.swing.JTextField();
        jTFieldHoten = new javax.swing.JTextField();
        jTFieldNgaysinh = new javax.swing.JTextField();
        jComboBoxLop = new javax.swing.JComboBox<>();
        jButtonAddHocSinh = new javax.swing.JButton();
        jButtonSuaHocSinh = new javax.swing.JButton();
        jButtonXoaHS = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTFieldTimKiemTen = new javax.swing.JTextField();
        jButtonTimKiemTen = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTFieldTimKiemTen1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButtonTimKiemTen1 = new javax.swing.JButton();
        jButtonXoaGV = new javax.swing.JButton();
        jTFieldChuyenNganh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFieldHoten1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTFieldNgaysinh1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButtonAddGiaoVien = new javax.swing.JButton();
        jButtonSuaGiaoVien = new javax.swing.JButton();
        jButtonSave1 = new javax.swing.JButton();
        jTFieldDiaChi = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jComboBoxLocLop = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSV = new javax.swing.JTable();
        jButtonLoc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableModel2 = new javax.swing.JTable();
        jButtonLoadDuLieuVaoBang = new javax.swing.JButton();
        jButtonLuuDiem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        bangHocSinhDiem = new javax.swing.JTable();
        statLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        comboBoxLop = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTKB = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        errorTextArea = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setBackground(new java.awt.Color(130, 167, 233));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Ngày sinh", "Lớp học"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Họ và tên:");

        jLabel9.setText("Ngày sinh:");

        jLabel10.setText("Lớp học:");

        jLabel11.setText("Mã sinh viên:");

        jComboBoxLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớp 10A", "Lớp 10B", "Lớp 10C", "Lớp 10D", " " }));

        jButtonAddHocSinh.setText("Thêm HS");
        jButtonAddHocSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddHocSinhActionPerformed(evt);
            }
        });

        jButtonSuaHocSinh.setText("Sửa HS");
        jButtonSuaHocSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaHocSinhActionPerformed(evt);
            }
        });

        jButtonXoaHS.setText("Xóa HS");
        jButtonXoaHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaHSActionPerformed(evt);
            }
        });

        jButtonSave.setText("Lưu dữ liệu");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel12.setText("Tìm kiếm học sinh:");

        jButtonTimKiemTen.setText("Tìm kiếm tên");
        jButtonTimKiemTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFieldMSV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFieldHoten)
                                    .addComponent(jTFieldNgaysinh)
                                    .addComponent(jComboBoxLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jButtonAddHocSinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSuaHocSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonXoaHS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFieldTimKiemTen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonTimKiemTen)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTFieldTimKiemTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTimKiemTen)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonXoaHS)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTFieldMSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFieldHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTFieldNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jButtonSave)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddHocSinh)
                            .addComponent(jButtonSuaHocSinh))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý sinh viên", jPanel2);

        jPanel14.setBackground(new java.awt.Color(130, 167, 233));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Ngày sinh", "Chuyên ngành", "Địa chỉ"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel13.setText("Tìm kiếm giáo viên:");

        jButtonTimKiemTen1.setText("Tìm kiếm tên");
        jButtonTimKiemTen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemTen1ActionPerformed(evt);
            }
        });

        jButtonXoaGV.setText("Xóa GV");
        jButtonXoaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaGVActionPerformed(evt);
            }
        });

        jLabel14.setText("Họ và tên:");

        jLabel15.setText("Chuyên ngành");

        jLabel16.setText("Ngày sinh:");

        jLabel17.setText("Địa chỉ:");

        jButtonAddGiaoVien.setText("Thêm GV");
        jButtonAddGiaoVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGiaoVienActionPerformed(evt);
            }
        });

        jButtonSuaGiaoVien.setText("Sửa GV");
        jButtonSuaGiaoVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaGiaoVienActionPerformed(evt);
            }
        });

        jButtonSave1.setText("Lưu dữ liệu");
        jButtonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jButtonAddGiaoVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSuaGiaoVien, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jTFieldDiaChi))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addComponent(jTFieldChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFieldHoten1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFieldNgaysinh1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSave1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonXoaGV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButtonTimKiemTen1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFieldTimKiemTen1)
                                .addGap(40, 40, 40)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTFieldTimKiemTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTimKiemTen1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonXoaGV)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTFieldHoten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTFieldNgaysinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTFieldChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSave1)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAddGiaoVien)
                        .addComponent(jButtonSuaGiaoVien)))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý giáo viên", jPanel1);

        jPanel15.setBackground(new java.awt.Color(130, 167, 233));

        jComboBoxLocLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớp 10A", "Lớp 10B", " ", " " }));

        jLabel18.setText("Chọn lớp học:");

        jTableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Ngày sinh", "Lớp học"
            }
        ));
        jScrollPane3.setViewportView(jTableSV);

        jButtonLoc.setText("LỌC");
        jButtonLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxLocLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButtonLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jComboBoxLocLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLoc))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(263, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách lớp học", jPanel5);

        jPanel16.setBackground(new java.awt.Color(130, 167, 233));

        tableModel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Ngày sinh", "Lớp học", "Điểm TB"
            }
        ));
        jScrollPane5.setViewportView(tableModel2);

        jButtonLoadDuLieuVaoBang.setText("Load dữ liệu học sinh");
        jButtonLoadDuLieuVaoBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadDuLieuVaoBangActionPerformed(evt);
            }
        });

        jButtonLuuDiem.setText("Lưu dữ liệu");
        jButtonLuuDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButtonLoadDuLieuVaoBang)
                        .addGap(584, 584, 584)
                        .addComponent(jButtonLuuDiem))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLuuDiem)
                    .addComponent(jButtonLoadDuLieuVaoBang))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kết quả học tập", jPanel4);

        jPanel3.setBackground(new java.awt.Color(130, 167, 233));

        bangHocSinhDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Ngày sinh", "Lớp học", "Điểm TB", "Xếp loại"
            }
        ));
        jScrollPane6.setViewportView(bangHocSinhDiem);

        jButton4.setText("Thống kê");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton4)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(statLabel)
                .addGap(5, 5, 5)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê", jPanel3);

        jPanel12.setBackground(new java.awt.Color(130, 167, 233));

        jButton1.setText("Thêm TKB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Lớp học:");

        comboBoxLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớp 10A", "Lớp 10B", " " }));

        jTableTKB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lớp", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"
            }
        ));
        jScrollPane4.setViewportView(jTableTKB);

        jButton2.setText("Lưu TKB");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xuất file excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel21.setText("Thứ 2:");

        jLabel23.setText("Thứ 4:");

        jLabel24.setText("Thứ 6:");

        jLabel25.setText("Thứ 3:");

        jLabel26.setText("Thứ 5:");

        jLabel27.setText("Thứ 7:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(36, 36, 36)
                                        .addComponent(comboBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(58, 58, 58)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(280, 280, 280)))))
                .addGap(32, 32, 32))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(comboBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thời khóa biểu", jPanel17);

        jPanel6.setBackground(new java.awt.Color(255, 204, 255));

        errorTextArea.setBackground(new java.awt.Color(204, 204, 255));
        errorTextArea.setColumns(20);
        errorTextArea.setRows(5);
        jScrollPane7.setViewportView(errorTextArea);

        jButton5.setText("Gửi lỗi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel22.setText("Đây là phiên bản đầu, nên còn nhiều sai sót, lỗi. Báo cáo lỗi để nhà phát triển sửa lỗi nhé!");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(113, 113, 113))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton5)))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Báo lỗi", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonLoadDuLieuVaoBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadDuLieuVaoBangActionPerformed
        // TODO add your handling code here:
        try {
            loadStudentDataDiem();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi load dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLoadDuLieuVaoBangActionPerformed

    private void jButtonLuuDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuDiemActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) tableModel2.getModel();
        String filePath = "file_hocsinh_diem.csv";
        CSVread.luuDuLieuVaoCSV(filePath, tableModel);

        JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào file CSV.");
    }//GEN-LAST:event_jButtonLuuDiemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hienThiDuLieu();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        luuLoiVaoTep();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonTimKiemTen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemTen1ActionPerformed
        // TODO add your handling code here:
        String tenCanTim = jTFieldTimKiemTen1.getText().trim();

        if (tenCanTim.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            jTable2.setRowSorter(sorter);
            sorter.setRowFilter(null);
        } else {
            timKiemTheoTen1(tenCanTim);
        }
    }//GEN-LAST:event_jButtonTimKiemTen1ActionPerformed

    private void jButtonXoaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaGVActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.removeRow(selectedRow);

            JOptionPane.showMessageDialog(this, "Xóa giáo viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giáo viên cần xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonXoaGVActionPerformed

    private void jButtonAddGiaoVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGiaoVienActionPerformed
        // TODO add your handling code here:
        String hoTen = jTFieldHoten1.getText();
        String ngaySinh = jTFieldNgaysinh1.getText();
        String chuyenNganh = jTFieldChuyenNganh.getText();
        String diaChi = jTFieldDiaChi.getText();

        if (!hoTen.matches("[\\p{L} ]+")) {
            JOptionPane.showMessageDialog(this, "Họ tên chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hoTen.isEmpty() || ngaySinh.isEmpty() || chuyenNganh.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin giáo viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.addRow(new Object[]{hoTen, ngaySinh, chuyenNganh, diaChi});

        jTFieldHoten1.setText("");
        jTFieldNgaysinh1.setText("");
        jTFieldChuyenNganh.setText("");
        jTFieldDiaChi.setText("");
    }//GEN-LAST:event_jButtonAddGiaoVienActionPerformed

    private void jButtonSuaGiaoVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaGiaoVienActionPerformed
        // TODO add your handling code here:
        String hoTen = jTFieldHoten1.getText();
        String ngaySinh = jTFieldNgaysinh1.getText();
        String chuyenNganh = jTFieldChuyenNganh.getText();
        String diaChi = jTFieldDiaChi.getText();

        if (!hoTen.matches("[\\p{L} ]+")) {
            JOptionPane.showMessageDialog(this, "Họ tên chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (hoTen.isEmpty() || ngaySinh.isEmpty() || chuyenNganh.isEmpty() || diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin giáo viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow != -1) {
            model.setValueAt(hoTen, selectedRow, 1);
            model.setValueAt(ngaySinh, selectedRow, 2);
            model.setValueAt(chuyenNganh, selectedRow, 3);
            model.setValueAt(diaChi, selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Sửa thông tin giáo viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giáo viên cần sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSuaGiaoVienActionPerformed

    private void jButtonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave1ActionPerformed
        // TODO add your handling code here:
        String filePath = "file_giaovien.csv";
        CSVdt.saveDataToCSV(filePath, jTable2);
        JOptionPane.showMessageDialog(this, "Dữ liệu giáo viên đã được lưu vào file CSV.");
    }//GEN-LAST:event_jButtonSave1ActionPerformed

    private void jButtonLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocActionPerformed
        // TODO add your handling code here:
        String selectedClass = (String) jComboBoxLocLop.getSelectedItem();
        CSVdt.loadDataHocSinhFromClass("file_hocsinh.csv", jTableSV, selectedClass);
    }//GEN-LAST:event_jButtonLocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        themDuLieuVaoBang();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        luuDuLieuFileCSV();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonTimKiemTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemTenActionPerformed
        // TODO add your handling code here:
        String tenCanTim = jTFieldTimKiemTen.getText().trim();

        if (tenCanTim.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            jTable1.setRowSorter(sorter);
            sorter.setRowFilter(null);
        } else {
            timKiemTheoTen(tenCanTim);
        }
    }//GEN-LAST:event_jButtonTimKiemTenActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String filePath = "file_hocsinh.csv";
        CSVdt.saveDataToCSV(filePath, jTable1);
        JOptionPane.showMessageDialog(this, "Dữ liệu đã được lưu vào file CSV.");
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonXoaHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaHSActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRow);

            JOptionPane.showMessageDialog(this, "Xóa học sinh thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học sinh cần xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonXoaHSActionPerformed

    private void jButtonSuaHocSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaHocSinhActionPerformed
        // TODO add your handling code here:
        String maSV = jTFieldMSV.getText();
        String hoTen = jTFieldHoten.getText();
        String ngaySinh = jTFieldNgaysinh.getText();
        String lopHoc = jComboBoxLop.getSelectedItem().toString();
        if (!maSV.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên chỉ được chứa số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!hoTen.matches("[\\p{L} ]+")) {
            JOptionPane.showMessageDialog(this, "Họ tên chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (maSV.isEmpty() || hoTen.isEmpty() || ngaySinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sinh viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            model.setValueAt(maSV, selectedRow, 0);
            model.setValueAt(hoTen, selectedRow, 1);
            model.setValueAt(ngaySinh, selectedRow, 2);
            model.setValueAt(lopHoc, selectedRow, 3);

            JOptionPane.showMessageDialog(this, "Sửa thông tin học sinh thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học sinh cần sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSuaHocSinhActionPerformed

    private void jButtonAddHocSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddHocSinhActionPerformed
        // TODO add your handling code here:
        String maSV = jTFieldMSV.getText();
        String hoTen = jTFieldHoten.getText();
        String ngaySinh = jTFieldNgaysinh.getText();
        String lopHoc = jComboBoxLop.getSelectedItem().toString();
        if (!maSV.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên chỉ được chứa số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!hoTen.matches("[\\p{L} ]+")) {
            JOptionPane.showMessageDialog(this, "Họ tên chỉ được chứa chữ cái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (maSV.isEmpty() || hoTen.isEmpty() || ngaySinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sinh viên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{maSV, hoTen, ngaySinh, lopHoc});

        jTFieldMSV.setText("");
        jTFieldHoten.setText("");
        jTFieldNgaysinh.setText("");
        jComboBoxLop.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonAddHocSinhActionPerformed
    private void luuLoiVaoTep() {
        String noiDungLoi = errorTextArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("loi.txt", true))) {
            writer.write(noiDungLoi);
            writer.newLine();
            writer.close();
            JOptionPane.showMessageDialog(this, "Lỗi đã được lưu vào loi.txt");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi lưu lỗi.");
        }
    }

    private void hienThiDuLieu() {
        DefaultTableModel model = (DefaultTableModel) bangHocSinhDiem.getModel();
        model.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader("file_hocsinh_diem.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] duLieuHang = line.split(",");
                model.addRow(duLieuHang);
                String diemStr = duLieuHang[4];
                String loaiHocSinh;
                try {
                    double diem = Double.parseDouble(diemStr);
                    if (diem > 8) {
                        loaiHocSinh = "Giỏi";
                    } else if (diem >= 5) {
                        loaiHocSinh = "Khá";
                    } else {
                        loaiHocSinh = "Trung bình";
                    }
                } catch (NumberFormatException e) {
                    loaiHocSinh = "Không hợp lệ";
                    e.printStackTrace();
                }
                model.setValueAt(loaiHocSinh, model.getRowCount() - 1, model.getColumnCount() - 1);
            }
            int soLuongGioi = (int) model.getDataVector().stream()
                    .filter(row -> "Giỏi".equals(((Vector<?>) row).get(model.getColumnCount() - 1)))
                    .count();
            int soLuongKha = (int) model.getDataVector().stream()
                    .filter(row -> "Khá".equals(((Vector<?>) row).get(model.getColumnCount() - 1)))
                    .count();
            int soLuongTB = model.getRowCount() - soLuongGioi - soLuongKha;
            statLabel.setText("Thống kê: Giỏi - " + soLuongGioi + ", Khá - " + soLuongKha + ", Trung bình - " + soLuongTB);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadStudentDataDiem() {
        List<Student> studentData = CSVread.readStudentDataFromCSV("file_hocsinh.csv");
        DefaultTableModel tableModel = (DefaultTableModel) tableModel2.getModel();
        tableModel.setRowCount(0);

        boolean isFirstRow = true;

        for (Student student : studentData) {
            if (!isFirstRow) {
                tableModel.addRow(new Object[]{student.getMaSV(), student.getTenSV(), student.getNgaySinh(), student.getLop()});
            } else {
                isFirstRow = false;
            }
        }
    }

    private void luuDuLieuFileCSV() {
        DefaultTableModel model = (DefaultTableModel) jTableTKB.getModel();
        String lop = (String) model.getValueAt(0, 0);

        if (lop == null || lop.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        luuDuLieuFileCSV(model);

    }

    private void luuDuLieuFileCSV(DefaultTableModel model) {
        try {
            for (int row = 0; row < model.getRowCount(); row++) {
                Vector<Object> rowData = model.getDataVector().elementAt(row);

                Object value = rowData.elementAt(0);
                if (value != null) {
                    String lop = value.toString();

                    String tenFile = "du_lieu_" + lop.replace(" ", "_") + ".csv";
                    String filePath = tenFile;

                    CSVWriter writer = new CSVWriter(new FileWriter(filePath));

                    String[] header = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
                    writer.writeNext(header);

                    for (int r = 0; r < model.getRowCount(); r++) {
                        Vector<Object> rowDataClass = model.getDataVector().elementAt(r);
                        value = rowDataClass.elementAt(0);
                        if (value != null && lop.equals(value.toString())) {
                            String[] rowArray = new String[rowDataClass.size()];
                            for (int col = 0; col < rowDataClass.size(); col++) {
                                value = rowDataClass.elementAt(col);
                                rowArray[col] = (value != null) ? value.toString() : "";
                            }
                            writer.writeNext(rowArray);
                        }
                    }

                    writer.close();

                    JOptionPane.showMessageDialog(null, "Dữ liệu của lớp " + lop + " đã được lưu vào file CSV.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void themDuLieuVaoBang() {
        String lop = (String) comboBoxLop.getSelectedItem();
        String monHoc1 = jTextField1.getText();
        String monHoc2 = jTextField2.getText();
        String monHoc3 = jTextField3.getText();
        String monHoc4 = jTextField4.getText();
        String monHoc5 = jTextField5.getText();
        String monHoc6 = jTextField6.getText();
        if (lop == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn lớp và thứ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTableTKB.getModel();
        model.addRow(new Object[]{lop, monHoc1, monHoc2, monHoc3, monHoc4, monHoc5, monHoc6});
        comboBoxLop.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }

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
            java.util.logging.Logger.getLogger(quanlyForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlyForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlyForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlyForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangHocSinhDiem;
    private javax.swing.JComboBox<String> comboBoxLop;
    private javax.swing.JTextArea errorTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonAddGiaoVien;
    private javax.swing.JButton jButtonAddHocSinh;
    private javax.swing.JButton jButtonLoadDuLieuVaoBang;
    private javax.swing.JButton jButtonLoc;
    private javax.swing.JButton jButtonLuuDiem;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JButton jButtonSuaGiaoVien;
    private javax.swing.JButton jButtonSuaHocSinh;
    private javax.swing.JButton jButtonTimKiemTen;
    private javax.swing.JButton jButtonTimKiemTen1;
    private javax.swing.JButton jButtonXoaGV;
    private javax.swing.JButton jButtonXoaHS;
    private javax.swing.JComboBox<String> jComboBoxLocLop;
    private javax.swing.JComboBox<String> jComboBoxLop;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTFieldChuyenNganh;
    private javax.swing.JTextField jTFieldDiaChi;
    private javax.swing.JTextField jTFieldHoten;
    private javax.swing.JTextField jTFieldHoten1;
    private javax.swing.JTextField jTFieldMSV;
    private javax.swing.JTextField jTFieldNgaysinh;
    private javax.swing.JTextField jTFieldNgaysinh1;
    private javax.swing.JTextField jTFieldTimKiemTen;
    private javax.swing.JTextField jTFieldTimKiemTen1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableSV;
    private javax.swing.JTable jTableTKB;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel statLabel;
    private javax.swing.JTable tableModel2;
    // End of variables declaration//GEN-END:variables

}
