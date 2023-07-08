import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class register extends JFrame implements ActionListener {
    JButton add = new JButton("add");
    JButton back = new JButton("back");
    JTextField password = new JTextField("Create Password");
    GridBagConstraints gbc = new GridBagConstraints();
    File file = new File("password.txt");
    PrintWriter output = new PrintWriter(new FileWriter(file, true));
    user user = new user();
    register() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250,250);
        setLayout(new GridBagLayout());

        gbc.gridx = 2;
        gbc.gridy = 0;
        password.setSize(100,50);
        password.setBackground(Color.white);
        add(password,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add.setFocusable(false);
        add.setSize(50,50);
        add.addActionListener(this);
        add(add,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        back.setFocusable(false);
        back.setSize(50,50);
        back.addActionListener(this);
        add(back,gbc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String text = password.getText();
            user.setPassword(text);

            output.println(user.getPassword());
            output.close();
        }
        if (e.getSource()==back){
            dispose();
            new loginPage();
            }
        }
    }
