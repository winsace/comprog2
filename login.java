import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    GridBagConstraints gbc = new GridBagConstraints();
    JButton enter = new JButton("ENTER");
    JLabel label = new JLabel("Welcome to Milestone Calculator");
    login(){
        super("Grade Output");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setSize(240,150);
        setTitle("Milestone Calculator");
        setResizable(false);

        gbc.gridy=0;
        gbc.gridx=2;
        label.setForeground(Color.BLACK);
        add(label,gbc);

        gbc.gridy=2;
        gbc.gridx=2;
        enter.setSize(50,50);
        enter.setFocusable(false);
        enter.addActionListener(this);
        add(enter,gbc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new gradeCalculator();
        dispose();
    }
}
