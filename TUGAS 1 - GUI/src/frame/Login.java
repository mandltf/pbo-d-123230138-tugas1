/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    private JLabel user, pass, status;
    private JTextField fuser,fpass;
    private JButton login;

    public Login(){
        setTitle("Login");
        setSize(300,180);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
//        
        user = new JLabel("  Username :" );
        fuser = new JTextField(10);
        pass = new JLabel("  Password :");
        fpass = new JTextField(10);
        login = new JButton("Login");
        status = new JLabel("");
        login.addActionListener(this);
        
        fuser.setPreferredSize(new Dimension(300,18));
        fpass.setPreferredSize(new Dimension(300,18));
        
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setVerticalAlignment(SwingConstants.CENTER);
        
        JPanel form = new JPanel(new GridLayout(2,2,60,2));
        form.add(user);
        form.add(fuser);
        form.add(pass);
        form.add(fpass);
        
        JPanel atas = new JPanel(new BorderLayout());
        atas.add(form);
        add(atas,"North");
        
        JPanel form2 = new JPanel(new FlowLayout());
        form2.add(new JLabel());
        form2.add(login);
        form2.add(new JLabel());
        
        JPanel bawah = new JPanel(new BorderLayout());
        bawah.add(form2,"North");
        bawah.add(status,"Center");
        add(bawah,"Center");
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(fuser.getText().equals("pbo")&&fpass.getText().equals("if-d")){
                new HalamanUtama();
                this.dispose();
            }else{
                status.setText("Gagal Login");
            }
    }
}
