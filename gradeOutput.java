import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gradeOutput extends JFrame implements ActionListener {
    JButton close,exit;
    JLabel lbQ1,lbQ2,lbQ3,lbStudentName,lbStudentNumber,lbAverage, PorF;
    GridBagConstraints gc = new GridBagConstraints();
    gradeOutput(student stud){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(320,300);
        setTitle("Milestone Calculator");
        setResizable(false);
        setLayout(new GridBagLayout());

        stud.computeAverage();

        gc.gridy=0;
        gc.gridx=1;
        JLabel SNameLabel = new JLabel("Student Name:");
        add(SNameLabel,gc);

        gc.gridy=0;
        gc.gridx=2;
        lbStudentName = new JLabel(stud.getStudentName());
        add(lbStudentName,gc);

        gc.gridy=1;
        gc.gridx=1;
        JLabel SNumLabel = new JLabel("Student Number:");
        add(SNumLabel,gc);

        gc.gridy=1;
        gc.gridx=2;
        lbStudentNumber = new JLabel(stud.getStudentNumber());
        add(lbStudentNumber,gc);

        gc.gridy=2;
        gc.gridx=1;
        JLabel Q1Label = new JLabel("Milestone 1:");
        add(Q1Label,gc);

        gc.gridy=2;
        gc.gridx=2;
        if (Float.parseFloat(stud.getQuiz1())<18.8){
            gc.insets.set(4,0,4,0);
            lbQ1 = new JLabel(stud.getQuiz1() + " | "+stud.percentQ1()+"%");
            lbQ1.setForeground(Color.red);
            add(lbQ1,gc);
        } else if (Float.parseFloat(stud.getQuiz1())>=18.8) {
            gc.insets.set(4,0,4,0);
            lbQ1 = new JLabel(stud.getQuiz1()+" | "+stud.percentQ1()+"%");
            lbQ1.setForeground(Color.green);
            add(lbQ1,gc);
        }

        gc.gridy=3;
        gc.gridx=1;
        JLabel Q2Label = new JLabel("Milestone 2:");
        add(Q2Label,gc);

        gc.gridy=3;
        gc.gridx=2;
        if (Float.parseFloat(stud.getQuiz2())<30){
            lbQ2 = new JLabel(stud.getQuiz2()+" | "+stud.percentQ2()+"%");
            lbQ2.setForeground(Color.red);
            add(lbQ2,gc);
        } else if (Float.parseFloat(stud.getQuiz2())>=30){
            lbQ2 = new JLabel(stud.getQuiz2()+" | "+stud.percentQ2()+"%");
            lbQ2.setForeground(Color.green);
            add(lbQ2,gc);
        }

        gc.gridy=4;
        gc.gridx=1;
        JLabel Q3Label = new JLabel("Terminal Assessment:");
        add(Q3Label,gc);

        gc.gridy=4;
        gc.gridx=2;
        if (Float.parseFloat(stud.getQuiz3())<26.3){
            lbQ3 = new JLabel(stud.getQuiz3()+" | "+stud.percentQ3()+"%");
            lbQ3.setForeground(Color.red);
            add(lbQ3,gc);
        }else if (Float.parseFloat(stud.getQuiz3())>=26.3){
            lbQ3 = new JLabel(stud.getQuiz3()+" | "+stud.percentQ3()+"%");
            lbQ3.setForeground(Color.green);
            add(lbQ3,gc);
        }

        gc.gridy=5;
        gc.gridx=1;
        JLabel AVGLabel = new JLabel("Average Grade: ");
        add(AVGLabel,gc);

        gc.gridy=5;
        gc.gridx=2;
        if (Float.parseFloat(stud.getAveGrade())<75.0){
            lbAverage = new JLabel(stud.getAveGrade()+"%");
            lbAverage.setForeground(Color.red);
            add(lbAverage,gc);
        } else if(Float.parseFloat(stud.getAveGrade())>=75.0){
            lbAverage = new JLabel(stud.getAveGrade()+"%");
            lbAverage.setForeground(Color.green);
            add(lbAverage,gc);
        }

        gc.gridy=6;
        gc.gridx=2;
        PorF = new JLabel();
        if(Float.parseFloat(stud.getAveGrade())<75.0){
            PorF.setText("Failed");
            PorF.setForeground(Color.red);
            add(PorF,gc);
        }else if(Float.parseFloat(stud.getAveGrade())>=75.0){
            PorF.setText("Passed");
            PorF.setForeground(Color.green);
            add(PorF,gc);
        }

        gc.gridy=7;
        gc.gridx=2;
        close = new JButton("Close");
        close.setSize(50,50);
        close.setFocusable(false);
        add(close,gc);
        close.addActionListener(this);

        gc.gridy=7;
        gc.gridx=1;
        exit = new JButton("Exit");
        exit.setFocusable(false);
        exit.setSize(50,50);
        add(exit,gc);
        exit.addActionListener(this);

        getContentPane();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            dispose();
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
    }
}
