package controller;

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Student;

public class CSVread {

    public static List<Student> readStudentDataFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student student = new Student(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public static List<Student> readStudentDataFromCSV2(String filePath) {
        List<Student> studentData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 4) {
                    String maSV = data[0].trim();
                    String tenSV = data[1].trim();
                    String ngaySinh = data[2].trim();
                    String lop = data[3].trim();

                    double diem = 0.0;

                    if (data.length >= 5) {
                        try {
                            diem = Double.parseDouble(data[4].trim());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    Student student = new Student(maSV, tenSV, ngaySinh, lop);
                    student.setDiem(diem);

                    studentData.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentData;
    }

    public static void luuDuLieuVaoCSV(String duongDan, DefaultTableModel model) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(duongDan), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            for (int hang = 0; hang < model.getRowCount(); hang++) {
                Vector<Object> duLieuHang = model.getDataVector().elementAt(hang);
                if (duLieuHang.size() >= 5) {
                    Object diemObject = model.getValueAt(hang, 4);
                    String diem = (diemObject != null) ? diemObject.toString() : "";

                    if (!diem.isEmpty()) {
                        String[] mangHang = new String[duLieuHang.size()];
                        for (int cot = 0; cot < duLieuHang.size(); cot++) {
                            mangHang[cot] = duLieuHang.elementAt(cot).toString();
                        }
                        writer.writeNext(mangHang);
                    }
                }
            }

            writer.close();
            JOptionPane.showMessageDialog(null, "Dữ liệu đã được lưu vào file CSV.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

}
