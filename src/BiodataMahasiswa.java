import com.formdev.flatlaf.FlatLightLaf; // FlatLaf Light Theme
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataMahasiswa {

    public static void main(String[] args) {
        // Set tema FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());  // Ganti dengan FlatDarkLaf untuk tema gelap
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Membuat frame utama
        JFrame frame = new JFrame("Biodata Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);  // Ukuran frame lebih besar untuk menampung kop dan logo
        frame.setLocationRelativeTo(null); // Posisikan di tengah layar

        // Membuat panel utama dengan GridBagLayout untuk responsivitas
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Memberi padding sekitar panel

        // Menambahkan gambar logo universitas
        try {
            ImageIcon icon = new ImageIcon("path/to/your/logo.jpg"); // Ganti dengan path gambar logo
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Ukuran gambar responsif
            icon = new ImageIcon(img);
            JLabel gambarLabel = new JLabel(icon);
            gambarLabel.setHorizontalAlignment(SwingConstants.CENTER);  // Posisikan gambar di tengah

            // Menambahkan gambar logo ke panel menggunakan GridBagConstraints
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(10, 10, 10, 10);  // Memberi jarak
            panel.add(gambarLabel, gbc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Menambahkan kop universitas
        JLabel kopLabel = new JLabel("Universitas Diponegoro - Teknik Komputer", JLabel.CENTER);
        kopLabel.setFont(new Font("Arial", Font.BOLD, 16));
        kopLabel.setForeground(new Color(0, 0, 128)); // Warna teks biru gelap

        // Menambahkan kop universitas ke panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(kopLabel, gbc);

        // Menambahkan form biodata mahasiswa (Nama, NIM, Alamat, Jurusan)
        JLabel labelNama = new JLabel("Nama:");
        JTextField fieldNama = new JTextField(20);

        JLabel labelNIM = new JLabel("NIM:");
        JTextField fieldNIM = new JTextField(20);

        JLabel labelAlamat = new JLabel("Alamat:");
        JTextField fieldAlamat = new JTextField(20);

        JLabel labelJurusan = new JLabel("Jurusan:");
        JTextField fieldJurusan = new JTextField(20);

        // Menambahkan elemen-elemen form ke panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(labelNama, gbc);

        gbc.gridx = 1;
        panel.add(fieldNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelNIM, gbc);

        gbc.gridx = 1;
        panel.add(fieldNIM, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(labelAlamat, gbc);

        gbc.gridx = 1;
        panel.add(fieldAlamat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(labelJurusan, gbc);

        gbc.gridx = 1;
        panel.add(fieldJurusan, gbc);

        // Tombol Submit
        JButton tombolSubmit = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(tombolSubmit, gbc);

        // Panel untuk menampilkan hasil biodata (KTM)
        JPanel panelHasil = new JPanel(new GridLayout(5, 1, 5, 5));  // Menata hasil dalam 4 baris
        panelHasil.setBackground(Color.WHITE);
        panelHasil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Border seperti kartu
        panelHasil.setPreferredSize(new Dimension(350, 200));  // Sesuaikan ukuran panel hasil

        // Menambahkan kop universitas di panel hasil
        JLabel kopHasilLabel = new JLabel("Universitas Diponegoro - Teknik Komputer", JLabel.CENTER);
        kopHasilLabel.setFont(new Font("Arial", Font.BOLD, 14));
        kopHasilLabel.setForeground(new Color(0, 0, 128));  // Warna teks biru gelap
        panelHasil.add(kopHasilLabel); // Menambahkan kop ke panel hasil

        JLabel labelNamaHasil = new JLabel("Nama: ");
        JLabel labelNIMHasil = new JLabel("NIM: ");
        JLabel labelAlamatHasil = new JLabel("Alamat: ");
        JLabel labelJurusanHasil = new JLabel("Jurusan: ");

        panelHasil.add(labelNamaHasil);
        panelHasil.add(labelNIMHasil);
        panelHasil.add(labelAlamatHasil);
        panelHasil.add(labelJurusanHasil);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(panelHasil, gbc);

        // Menambahkan panel ke frame
        frame.add(panel);

        // Aksi ketika tombol Submit ditekan
        tombolSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil input dari text fields
                String nama = fieldNama.getText();
                String nim = fieldNIM.getText();
                String alamat = fieldAlamat.getText();
                String jurusan = fieldJurusan.getText();

                // Mengupdate label hasil dengan biodata yang
                labelNamaHasil.setText("Nama: " + nama);
                labelNIMHasil.setText("NIM: " + nim);
                labelAlamatHasil.setText("Alamat: " + alamat);
                labelJurusanHasil.setText("Jurusan: " + jurusan);
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}