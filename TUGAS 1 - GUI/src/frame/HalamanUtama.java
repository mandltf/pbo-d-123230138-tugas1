package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class HalamanUtama extends JFrame implements ActionListener {
    private final JLabel first, last, gender, statusAtas, statusBawah;
    private final JTextField ffirst, flast;
    private final JButton simpan, convert;
    private final JRadioButton pria, wanita;
    private final JTextArea ta;
    private final ButtonGroup grup;
    ArrayList<String> list;
    
    public HalamanUtama(){
        setTitle("Halaman Utama");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        
        list = new ArrayList<>();
        
        first = new JLabel("Nama Depan: ");
        last = new JLabel("Nama Belakang: ");
        gender = new JLabel("Jenis Kelamin: ");
        ffirst = new JTextField();
        flast = new JTextField();
        simpan = new JButton("Simpan");
        convert = new JButton("Convert to .txt File");
        wanita = new JRadioButton("Wanita");
        pria = new JRadioButton("Pria");
        statusAtas = new JLabel(" ");
        statusBawah = new JLabel(" ");
        ta = new JTextArea();
        
        simpan.addActionListener(this);
        convert.addActionListener(this);
        
        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        simpan.setPreferredSize(new Dimension(400,35));
        statusAtas.setPreferredSize(new Dimension(400,35));
        statusBawah.setPreferredSize(new Dimension(400,30));
        
        JPanel nama = new JPanel(new GridLayout(2,2));
        nama.add(first);
        nama.add(last);
        nama.add(ffirst);
        nama.add(flast);
        
        JPanel jk = new JPanel(new FlowLayout());
        jk.add(wanita);
        jk.add(pria);
        
        grup = new ButtonGroup();
        grup.add(wanita);
        grup.add(pria);
        
        JPanel jenis = new JPanel(new GridLayout(2,1));
        jenis.add(gender);
        jenis.add(jk);

        JPanel atas = new JPanel(new BorderLayout());
        add(atas,"North");
        atas.add(nama,"North");
        atas.add(jenis,"Center");
        atas.add(simpan,"South");
        
        JPanel tengah = new JPanel(new BorderLayout());
        tengah.add(statusAtas,"North");
        tengah.add(sp,"Center");
        tengah.add(convert,"South");
        add(tengah,"Center");
        
        JPanel bawah = new JPanel(new BorderLayout());
        bawah.add(statusBawah,"South");
        add(bawah,"South");
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ffirst.getText().isEmpty() || flast.getText().isEmpty() || grup.getSelection()==null){
            statusAtas.setText("Data harus lengkap!");
            
        }else{
            ta.setText("");
            statusAtas.setText("");
            String depan = ffirst.getText();
            ffirst.setText("");
           
            String blkg = flast.getText();
            if(wanita.isSelected()){
                list.add(depan + " " + blkg + " | Gender: Wanita");
            }else{
                list.add(depan + " " + blkg + " | Gender: Pria");
            }
            grup.clearSelection();
            flast.setText("");
            for(String data : list){
                ta.append(data + "\n");
            }
            
        }
        
        if(e.getSource().equals(convert)){
            if(ta.getText().isEmpty()){
                statusAtas.setText("");
                statusBawah.setText("Tidak ada data yang tersedia");
                return;
            }else{
                try{
                    statusAtas.setText("");
                    FileWriter writer = new FileWriter("data_nim.txt");
                    writer.write(ta.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Hasil",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ex) {};
            }
        }
    }
}
