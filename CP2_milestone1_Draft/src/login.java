import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class login extends JFrame implements ActionListener {
    JTextField empNum, empPay;
    JLabel lbEmpNum, lbEmpPay;
    GridBagConstraints gc = new GridBagConstraints();
    JButton enter = new JButton("ENTER");
    employee emp = new employee();
    login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,180);
        setLayout(new GridBagLayout());

        gc.gridy =0;
        gc.gridx =1;
        lbEmpNum = new JLabel("Enter Employee Number: ");
        add(lbEmpNum,gc);

        gc.gridy =0;
        gc.gridx =2;
        gc.insets = new Insets(1,0,1,0);
        empNum = new JTextField("Employee Number");
        empNum.setBackground(Color.white);
        empNum.setEditable(true);
        add(empNum,gc);

        gc.gridy =1;
        gc.gridx =1;
        lbEmpPay = new JLabel("Enter Employee Pay: ");
        add(lbEmpPay,gc);

        gc.gridy =1;
        gc.gridx =2;
        gc.insets = new Insets(1,0,1,0);
        empPay = new JTextField("Employee Pay");
        empPay.setBackground(Color.white);
        empPay.setEditable(true);
        add(empPay,gc);

        gc.gridy =2;
        gc.gridx =2;
        gc.insets = new Insets(1,0,1,0);
        enter.setFocusable(false);
        enter.setSize(50,50);
        enter.addActionListener(this);
        add(enter,gc);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String employeeNumb = empNum.getText();
            float employeePay = Float.parseFloat(empPay.getText());
            emp.setEmployeeNumber(employeeNumb);
            emp.setEmployeePay(employeePay);
            employeeInfo info = new employeeInfo(emp);
            info.setVisible(true);
        } catch (NumberFormatException | IOException ex){
            ex.fillInStackTrace();
        }
    }
}

