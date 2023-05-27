import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class login extends JFrame implements ActionListener {
    JButton enter;
    JComboBox combo;
    GridBagConstraints gbc = new GridBagConstraints();
    login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(200,250);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Employee Records");

        gbc.gridy = 0;
        gbc.gridx = 0;
        String[] date = {"January", "February", "May", "June","July", "August","September","December"};
        combo = new JComboBox<>(date);
        add(combo,gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        enter = new JButton();
        enter.setFocusable(false);
        enter.setText("Enter");
        enter.addActionListener(this);
        add(enter,gbc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choose = (String) combo.getSelectedItem();

        switch (choose){
            case "January" -> {
                try {
                    new januaryTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "February" -> {
                try {
                    new februaryTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "May" -> {
                try {
                    new mayTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "June" -> {
                try {
                    new juneTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }case "July" -> {
                try {
                    new julyTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }case "August" -> {
                try {
                    new augustTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }case "September" -> {
                try {
                    new septemberTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }case "December" -> {
                try {
                    new decemberTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
