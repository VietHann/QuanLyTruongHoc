package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CSVdt {

    public static void saveDataToCSV(String filePath, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadDataHocSinhFromCSV(String filePath, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();

            if (headerLine != null && headerLine.contains("Ngày sinh") && headerLine.contains("Lớp học")) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }
            } else {
                System.out.println("File không chứa dữ liệu học sinh.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadDataHocSinhFromClass(String filePath, JTable jTable, String selectedClass) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();

            if (headerLine != null && headerLine.contains("Ngày sinh") && headerLine.contains("Lớp học")) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    // Check if the last part of "Lớp học" matches the selected class
                    if (data.length > 3 && data[3].trim().endsWith(selectedClass)) {
                        model.addRow(data);
                    }
                }
            } else {
                System.out.println("File không chứa dữ liệu học sinh.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveDataGiaoVienToCSV(String filePath, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadDataGiaoVienFromCSV(String filePath, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadCSVdiemso(String filePath, JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
