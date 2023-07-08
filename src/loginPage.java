import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class loginPage extends JFrame implements ActionListener {
    JButton login = new JButton("login");
    JButton register = new JButton("Register");
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField password = new JTextField("Enter Password");
    //File file = new File("password.txt");
    //PrintWriter output = new PrintWriter(new FileWriter(file, true));
    Scanner input = new Scanner("C:\\Users\\Admin\\IdeaProjects\\login_v1\\password.txt");

    loginPage() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250, 250);
        setLayout(new GridBagLayout());

        gbc.gridx = 2;
        gbc.gridy = 0;
        password.setSize(100, 50);
        password.setBackground(Color.white);
        add(password, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        login.setFocusable(false);
        login.setSize(50, 50);
        login.addActionListener(this);
        add(login, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        register.setFocusable(false);
        register.setSize(50, 50);
        register.addActionListener(this);
        add(register, gbc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            dispose();
            try {
                new register();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if (e.getSource() == login) {
                String text = password.getText();
                if (input.next().equals(text)) {
                    try {
                        new imIn();
                    } catch (NoSuchElementException ex) {
                        password.setText("Try Again");
                    }
                }

            }
        }
    }
}
