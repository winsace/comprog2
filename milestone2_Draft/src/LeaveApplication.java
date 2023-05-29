import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class LeaveApplication extends JFrame implements ActionListener {
    private static final String LEAVE_FILE = "leave_applications.csv";
    private static final String LEAVE_COUNT_FILE = "leave_counts.csv";
    private static final int MAX_SICK_LEAVES = 5;
    private static final int MAX_VACATION_LEAVES = 10;
    private static final int MAX_EMERGENCY_LEAVES = 5;

    private final JTextField startDateField;
    private final JTextField endDateField;
    private final JComboBox<String> leaveTypeComboBox;
    private final JLabel sickLeaveLabel;
    private final JLabel vacationLeaveLabel;
    private final JLabel emergencyLeaveLabel;

    JButton applyButton = new JButton("Apply");

    LeaveApplication(){
        setTitle("Leave Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(7, 2));

        JLabel startDateLabel = new JLabel("Start Date (YYYY-MM-DD):");
        startDateField = new JTextField();

        JLabel endDateLabel = new JLabel("End Date (YYYY-MM-DD):");
        endDateField = new JTextField();

        JLabel leaveTypeLabel = new JLabel("Leave Type:");
        leaveTypeComboBox = new JComboBox<>(new String[]{"Sick Leave", "Vacation Leave", "Emergency Leave"});

        sickLeaveLabel = new JLabel();

        vacationLeaveLabel = new JLabel();

        emergencyLeaveLabel = new JLabel();

        applyButton.addActionListener(this);

        updateLeaveCountLabels();

        add(startDateLabel);
        add(startDateField);
        add(endDateLabel);
        add(endDateField);
        add(leaveTypeLabel);
        add(leaveTypeComboBox);
        add(new JLabel()); // Placeholder for an empty cell
        add(applyButton);
        add(new JLabel("Remaining Sick Leaves:"));
        add(sickLeaveLabel);
        add(new JLabel("Remaining Vacation Leaves:"));
        add(vacationLeaveLabel);
        add(new JLabel("Remaining Emergency Leaves:"));
        add(emergencyLeaveLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String leaveType = leaveTypeComboBox.getSelectedItem().toString();

        if (validateLeaveDates(startDate, endDate)) {
            if (applyLeave(startDate, endDate, leaveType)) {
                JOptionPane.showMessageDialog(LeaveApplication.this, "Leave application submitted successfully.");
                updateLeaveCountLabels();
            } else {
                JOptionPane.showMessageDialog(LeaveApplication.this, "Failed to submit leave application. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(LeaveApplication.this, "Invalid leave dates. Please enter valid dates.");
        }
    }
    private boolean validateLeaveDates(String startDate, String endDate) {
        try {
            // Validate the date format (YYYY-MM-DD)
            java.sql.Date.valueOf(startDate);
            java.sql.Date.valueOf(endDate);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean applyLeave(String startDate, String endDate, String leaveType) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LEAVE_FILE, true))) {
            writer.write(startDate + "," + endDate + "," + leaveType);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void updateLeaveCountLabels() {
        int remainingSickLeaves = MAX_SICK_LEAVES - countLeaves("Sick Leave");
        int remainingVacationLeaves = MAX_VACATION_LEAVES - countLeaves("Vacation Leave");
        int remainingEmergencyLeaves = MAX_EMERGENCY_LEAVES - countLeaves("Emergency Leave");

        sickLeaveLabel.setText(String.valueOf(remainingSickLeaves));
        vacationLeaveLabel.setText(String.valueOf(remainingVacationLeaves));
        emergencyLeaveLabel.setText(String.valueOf(remainingEmergencyLeaves));
    }

    private int countLeaves(String leaveType) {
        List <String[]>leaveRecords = readCSVFile(LEAVE_FILE);
        int count = 0;

        for (String[] record : leaveRecords) {
            String type = record[2];
            if (type.equals(leaveType)) {
                count++;
            }
        }

        return count;
    }

    private List<String[]> readCSVFile(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

}
