import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class gradeCalculator extends JFrame implements ActionListener {
    GridBagConstraints gbc = new GridBagConstraints();
    JLabel lbQ1, lbQ2, lbQ3;
    JTextField txtQ1, txtQ2, txtQ3;
    private JTextField txtStudName, txtStudNumber;
    JButton compute = new JButton("Compute");
    student stud = new student();
    gradeCalculator() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        setTitle("Milestone Calculator");
        setResizable(false);
        setLayout(new GridBagLayout());

        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        txtStudName = new JTextField("Enter Student Name");
        txtStudName.setBackground(Color.white);
        add(txtStudName, gbc);

        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        txtStudNumber = new JTextField();
        txtStudNumber = new JTextField("Enter Student Number");
        txtStudNumber.setBackground(Color.white);
        add(txtStudNumber, gbc);

        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        txtQ1 = new JTextField("Milestone 1");
        txtQ1.setBackground(Color.white);
        add(txtQ1, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        lbQ1 = new JLabel("Milestone 1: ");
        add(lbQ1,gbc);

        gbc.gridy = 3;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        txtQ2 = new JTextField("Milestone 2");
        txtQ2.setBackground(Color.white);
        add(txtQ2, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        lbQ2 = new JLabel("Milestone 2: ");
        add(lbQ2,gbc);

        gbc.gridy = 4;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        txtQ3 = new JTextField("Terminal Assessment");
        txtQ3.setBackground(Color.white);
        add(txtQ3, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        lbQ3 = new JLabel("Terminal Assessment: ");
        add(lbQ3,gbc);

        gbc.gridy = 5;
        gbc.gridx = 2;
        gbc.insets.set(4, 0, 4, 0);
        compute.setFocusable(false);
        compute.setSize(50, 50);
        compute.addActionListener(this);
        add(compute, gbc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String studName = txtStudName.getText();
            String studNum = txtStudNumber.getText();
            stud.setQuiz1(Float.parseFloat(txtQ1.getText()));
            stud.setQuiz2(Float.parseFloat(txtQ2.getText()));
            stud.setQuiz3(Float.parseFloat(txtQ3.getText()));
            stud.setStudentName(studName);
            stud.setStudentNumber(studNum);
            gradeOutput output = new gradeOutput(stud);
            output.setVisible(true);
        }catch(NumberFormatException ex){
            txtQ1.setText("Milestone 1");
            txtQ2.setText("Milestone 2");
            txtQ3.setText("Terminal Assessment");
        }
    }
}

