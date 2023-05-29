import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginSystem extends JFrame implements ActionListener {
    private static final String ACCOUNTS_FILE = "accounts.csv";
    private JTextField usernameField;
    private JPasswordField passwordField;
    JButton loginButton = new JButton("Login");
    JButton signupButton = new JButton("Sign-Up");
    public LoginSystem(){
        setLocationRelativeTo(null);
        setTitle("Login");
        setResizable(false);
        setSize(250,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton.addActionListener(this);
        
        signupButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Placeholder for an empty cell
        add(loginButton);
        add(signupButton);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== loginButton){
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateLogin(username, password)) {
                dispose();
                new LeaveApplication();
            } else {
                JOptionPane.showMessageDialog(LoginSystem.this, "Invalid username or password. Please try again.");
                // Handle incorrect login credentials
            }
        } else if (e.getSource()==signupButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(LoginSystem.this, "Username and password cannot be empty. Please try again.");
            } else {
                if (createAccount(username, password)) {
                    JOptionPane.showMessageDialog(LoginSystem.this, "Account created successfully! You can now log in.");
                } else {
                    JOptionPane.showMessageDialog(LoginSystem.this, "Failed to create account. Please try again.");
                }
            }
        }
    }
        
    private boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] account = line.split(",");
                String storedUsername = account[0];
                String storedPassword = account[1];
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean createAccount(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNTS_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
