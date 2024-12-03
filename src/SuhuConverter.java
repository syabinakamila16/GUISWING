import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuhuConverter {
    public static void main(String[] args) {
        // Mengatur FlatLaf tema
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Aplikasi Konversi Suhu");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menggunakan layout yang lebih rapi
        frame.setLayout(new BorderLayout());

        // Panel untuk input dan output
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(5, 2, 10, 10)); // 5 baris, 2 kolom, dengan jarak antar elemen
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        // Label dan input untuk suhu
        JLabel labelInput = new JLabel("Masukkan suhu:");
        labelInput.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        // ComboBox untuk pilihan konversi suhu
        String[] pilihanKonversi = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> comboBox1 = new JComboBox<>(pilihanKonversi);
        comboBox1.setFont(new Font("Arial", Font.PLAIN, 16));
        JComboBox<String> comboBox2 = new JComboBox<>(pilihanKonversi);
        comboBox2.setFont(new Font("Arial", Font.PLAIN, 16));

        // Button untuk konversi
        JButton buttonConvert = new JButton("Konversi");
        buttonConvert.setFont(new Font("Arial", Font.BOLD, 16));
        buttonConvert.setBackground(new Color(72, 133, 237)); // Warna biru
        buttonConvert.setForeground(Color.WHITE);
        buttonConvert.setFocusPainted(false);

        // Label hasil konversi
        JLabel labelHasil = new JLabel("Hasil: ");
        labelHasil.setFont(new Font("Arial", Font.BOLD, 18));
        labelHasil.setForeground(new Color(72, 133, 237)); // Warna biru

        // Menambahkan komponen ke panel
        panelInput.add(labelInput);
        panelInput.add(inputField);
        panelInput.add(new JLabel("Dari"));
        panelInput.add(comboBox1);
        panelInput.add(new JLabel("Ke"));
        panelInput.add(comboBox2);
        panelInput.add(buttonConvert);
        panelInput.add(labelHasil);

        // Menambahkan panel ke frame
        frame.add(panelInput, BorderLayout.CENTER);

        // Menambahkan action listener untuk tombol konversi
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputSuhu = Double.parseDouble(inputField.getText());
                    String dari = (String) comboBox1.getSelectedItem();
                    String ke = (String) comboBox2.getSelectedItem();

                    double hasil = konversiSuhu(inputSuhu, dari, ke);
                    labelHasil.setText("Hasil: " + hasil);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid. Silakan masukkan angka yang benar.");
                }
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }

    private static double konversiSuhu(double suhu, String dari, String ke) {
        if (dari.equals("Celsius")) {
            if (ke.equals("Fahrenheit")) return suhu * 9/5 + 32;
            if (ke.equals("Kelvin")) return suhu + 273.15;
        } else if (dari.equals("Fahrenheit")) {
            if (ke.equals("Celsius")) return (suhu - 32) * 5/9;
            if (ke.equals("Kelvin")) return (suhu - 32) * 5/9 + 273.15;
        } else if (dari.equals("Kelvin")) {
            if (ke.equals("Celsius")) return suhu - 273.15;
            if (ke.equals("Fahrenheit")) return (suhu - 273.15) * 9/5 + 32;
        }
        return suhu;
    }
}
