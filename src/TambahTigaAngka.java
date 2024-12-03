import com.formdev.flatlaf.FlatDarkLaf;  // Import FlatLaf Dark Theme
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahTigaAngka {

    public static void main(String[] args) {
        try {
            // Set tema FlatLaf
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Bisa juga menggunakan FlatLightLaf()
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Membuat frame utama
        JFrame frame = new JFrame("Aplikasi Pertambahan Tiga Angka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Ukuran jendela
        frame.setLocationRelativeTo(null); // Posisikan di tengah layar

        // Membuat panel dan layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); // 5 baris dan 2 kolom

        // Membuat label dan field untuk angka
        JLabel label1 = new JLabel("Masukkan Angka 1:");
        JTextField angka1 = new JTextField();

        JLabel label2 = new JLabel("Masukkan Angka 2:");
        JTextField angka2 = new JTextField();

        JLabel label3 = new JLabel("Masukkan Angka 3:");
        JTextField angka3 = new JTextField();

        // Label untuk menampilkan hasil
        JLabel labelHasil = new JLabel("Hasil: ");

        // Tombol untuk melakukan perhitungan
        JButton tombolHitung = new JButton("Hitung");

        // Menambahkan elemen-elemen ke panel
        panel.add(label1);
        panel.add(angka1);
        panel.add(label2);
        panel.add(angka2);
        panel.add(label3);
        panel.add(angka3);
        panel.add(tombolHitung);
        panel.add(labelHasil);

        // Menambahkan panel ke frame
        frame.add(panel);

        // Menambahkan aksi ketika tombol hitung ditekan
        tombolHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mendapatkan input dari text fields
                    int num1 = Integer.parseInt(angka1.getText());
                    int num2 = Integer.parseInt(angka2.getText());
                    int num3 = Integer.parseInt(angka3.getText());

                    // Menghitung hasil
                    int hasil = num1 + num2 + num3;

                    // Menampilkan hasil ke label
                    labelHasil.setText("Hasil: " + hasil);
                } catch (NumberFormatException ex) {
                    // Jika input tidak valid, tampilkan pesan error
                    JOptionPane.showMessageDialog(frame, "Mohon masukkan angka yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}
