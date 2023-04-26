import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class employeeInfo extends JFrame {
    JTextField empDob, empName, empNumb, empPay, empGW, empTC, empTI, empWithholding, empNetWage,empHoursWorkedD,empHoursWorkedW;
    JLabel divider, divider1, divider2;
    GridBagConstraints gbc = new GridBagConstraints();
    String path = "C:\\Users\\Admin\\Downloads\\motorPh.xlsx";
    FileInputStream read = new FileInputStream(path);
    XSSFWorkbook wb = new XSSFWorkbook(read);
    XSSFSheet sheet = wb.getSheet("Employee Details");
    XSSFSheet sheetAttendance = wb.getSheet("Attendance Record");
    char pesoSign = '₱';


    employeeInfo(employee emp) throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 450);
        setLayout(new GridBagLayout());

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(4, 0, 4, 0);
        JLabel empNumbLabel = new JLabel("Employee Number: ");
        add(empNumbLabel,gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.insets = new Insets(4, 0, 4, 0);
        empNumb = new JTextField(emp.getEmployeeNumber());
        empNumb.setEditable(false);
        add(empNumb, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(4, 0, 4, 0);
        JLabel empPayLabel = new JLabel("Employee Hourly Pay: ");
        add(empPayLabel,gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.insets = new Insets(4, 0, 4, 0);
        empPay = new JTextField(pesoSign+ emp.getEmployeePay());
        empPay.setEditable(false);
        add(empPay, gbc);

        //1
        if (emp.getEmployeeNumber().equals("10001")) {
            Cell hoursInDay = sheetAttendance.getRow(1).getCell(6);
            double hoursInADay = Double.parseDouble(String.valueOf(hoursInDay));
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empDobLabel = new JLabel("Date of Birth: ");
            add(empDobLabel,gbc);

            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empDob = new JTextField();
            empDob.setEditable(false);
            empDob.setText(String.valueOf((sheet.getRow(1).getCell(3))));
            add(empDob, gbc);

            gbc.gridy = 3;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNameLabel = new JLabel("Name: ");
            add(empNameLabel,gbc);

            gbc.gridy = 3;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empName = new JTextField();
            empName.setEditable(false);
            empName.setText((sheet.getRow(1).getCell(2)) + " " + sheet.getRow(1).getCell(1));
            add(empName, gbc);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedDLabel = new JLabel("Hours Worked In A Day: ");
            add(empHoursWorkedDLabel,gbc);

            gbc.gridy = 4;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedD = new JTextField();
            empHoursWorkedD.setEditable(false);
            empHoursWorkedD.setText(String.valueOf(hoursInADay));
            add(empHoursWorkedD,gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedWLabel = new JLabel("Hours Worked In A Week: ");
            add(empHoursWorkedWLabel,gbc);

            emp.setHoursWorkedInAWeek((float) hoursInADay * 5);
            gbc.gridy = 5;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedW = new JTextField();
            empHoursWorkedW.setEditable(false);
            empHoursWorkedW.setText(emp.getHoursWorkedInAWeek());
            add(empHoursWorkedW,gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            divider = new JLabel("*************************************");
            add(divider, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empGWLabel = new JLabel("GrossWage: ");
            add(empGWLabel,gbc);

            gbc.gridy = 7;
            gbc.gridx = 1;
            emp.computeGrossWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empGW = new JTextField();
            empGW.setEditable(false);
            empGW.setText(pesoSign+emp.getGrossWage());
            add(empGW,gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTCLabel = new JLabel("Total Contributions: ");
            add(empTCLabel,gbc);

            gbc.gridy = 8;
            gbc.gridx = 1;
            emp.computeTotalContributions();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTC = new JTextField(pesoSign+emp.getTotalContributions());
            empTC.setEditable(false);
            add(empTC,gbc);

            gbc.gridy = 9;
            gbc.gridx = 1;
            divider1 = new JLabel("*************************************");
            add(divider1, gbc);

            gbc.gridy = 10;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTILabel = new JLabel("Taxable Income: ");
            add(empTILabel,gbc);

            gbc.gridy = 10;
            gbc.gridx = 1;
            emp.computeTaxableIncome();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTI = new JTextField(pesoSign+emp.getTaxableIncome());
            empTI.setEditable(false);
            add(empTI,gbc);

            gbc.gridy = 11;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empWithholdingLabel = new JLabel("Withholding Tax: ");
            add(empWithholdingLabel,gbc);

            gbc.gridy = 11;
            gbc.gridx = 1;
            emp.computeWithholdingTax();
            gbc.insets = new Insets(4, 0, 4, 0);
            empWithholding = new JTextField(pesoSign+emp.getWithholdingTax());
            empWithholding.setEditable(false);
            add(empWithholding,gbc);

            gbc.gridy = 12;
            gbc.gridx = 1;
            divider2 = new JLabel("*************************************");
            add(divider2, gbc);

            gbc.gridy = 13;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNetWageLabel = new JLabel("Net Wage: ");
            add(empNetWageLabel,gbc);

            gbc.gridy = 13;
            gbc.gridx = 1;
            emp.computeNetWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empNetWage = new JTextField(pesoSign+emp.getNetWage());
            empNetWage.setEditable(false);
            add(empNetWage,gbc);


        } else if (emp.getEmployeeNumber().equals("10002")) {
            Cell hoursInDay = sheetAttendance.getRow(2).getCell(6);
            double hoursInADay = Double.parseDouble(String.valueOf(hoursInDay));
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empDobLabel = new JLabel("Date of Birth: ");
            add(empDobLabel,gbc);

            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empDob = new JTextField();
            empDob.setEditable(false);
            empDob.setText(String.valueOf((sheet.getRow(2).getCell(3))));
            add(empDob, gbc);

            gbc.gridy = 3;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNameLabel = new JLabel("Name: ");
            add(empNameLabel,gbc);

            gbc.gridy = 3;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empName = new JTextField();
            empName.setEditable(false);
            empName.setText((sheet.getRow(2).getCell(2)) + " " + sheet.getRow(2).getCell(1));
            add(empName, gbc);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedDLabel = new JLabel("Hours Worked In A Day: ");
            add(empHoursWorkedDLabel,gbc);

            gbc.gridy = 4;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedD = new JTextField();
            empHoursWorkedD.setEditable(false);
            empHoursWorkedD.setText(String.valueOf(hoursInADay));
            add(empHoursWorkedD,gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedWLabel = new JLabel("Hours Worked In A Week: ");
            add(empHoursWorkedWLabel,gbc);

            emp.setHoursWorkedInAWeek((float) hoursInADay * 5);
            gbc.gridy = 5;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedW = new JTextField();
            empHoursWorkedW.setEditable(false);
            empHoursWorkedW.setText(emp.getHoursWorkedInAWeek());
            add(empHoursWorkedW,gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            divider = new JLabel("*************************************");
            add(divider, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empGWLabel = new JLabel("GrossWage: ");
            add(empGWLabel,gbc);

            gbc.gridy = 7;
            gbc.gridx = 1;
            emp.computeGrossWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empGW = new JTextField();
            empGW.setEditable(false);
            empGW.setText(pesoSign+emp.getGrossWage());
            add(empGW,gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTCLabel = new JLabel("Total Contributions: ");
            add(empTCLabel,gbc);

            gbc.gridy = 8;
            gbc.gridx = 1;
            emp.computeTotalContributions();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTC = new JTextField(pesoSign+emp.getTotalContributions());
            empTC.setEditable(false);
            add(empTC,gbc);

            gbc.gridy = 9;
            gbc.gridx = 1;
            divider1 = new JLabel("*************************************");
            add(divider1, gbc);

            gbc.gridy = 10;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTILabel = new JLabel("Taxable Income: ");
            add(empTILabel,gbc);

            gbc.gridy = 10;
            gbc.gridx = 1;
            emp.computeTaxableIncome();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTI = new JTextField(pesoSign+emp.getTaxableIncome());
            empTI.setEditable(false);
            add(empTI,gbc);

            gbc.gridy = 11;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empWithholdingLabel = new JLabel("Withholding Tax: ");
            add(empWithholdingLabel,gbc);

            gbc.gridy = 11;
            gbc.gridx = 1;
            emp.computeWithholdingTax();
            gbc.insets = new Insets(4, 0, 4, 0);
            empWithholding = new JTextField(pesoSign+emp.getWithholdingTax());
            empWithholding.setEditable(false);
            add(empWithholding,gbc);

            gbc.gridy = 12;
            gbc.gridx = 1;
            divider2 = new JLabel("*************************************");
            add(divider2, gbc);

            gbc.gridy = 13;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNetWageLabel = new JLabel("Net Wage: ");
            add(empNetWageLabel,gbc);

            gbc.gridy = 13;
            gbc.gridx = 1;
            emp.computeNetWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empNetWage = new JTextField(pesoSign+emp.getNetWage());
            empNetWage.setEditable(false);
            add(empNetWage,gbc);
        }else if (emp.getEmployeeNumber().equals("10003")) {
            Cell hoursInDay = sheetAttendance.getRow(3).getCell(6);
            double hoursInADay = Double.parseDouble(String.valueOf(hoursInDay));
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empDobLabel = new JLabel("Date of Birth: ");
            add(empDobLabel,gbc);

            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empDob = new JTextField();
            empDob.setEditable(false);
            empDob.setText(String.valueOf((sheet.getRow(3).getCell(3))));
            add(empDob, gbc);

            gbc.gridy = 3;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNameLabel = new JLabel("Name: ");
            add(empNameLabel,gbc);

            gbc.gridy = 3;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empName = new JTextField();
            empName.setEditable(false);
            empName.setText((sheet.getRow(3).getCell(2)) + " " + sheet.getRow(3).getCell(1));
            add(empName, gbc);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedDLabel = new JLabel("Hours Worked In A Day: ");
            add(empHoursWorkedDLabel,gbc);

            gbc.gridy = 4;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedD = new JTextField();
            empHoursWorkedD.setEditable(false);
            empHoursWorkedD.setText(String.valueOf(hoursInADay));
            add(empHoursWorkedD,gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedWLabel = new JLabel("Hours Worked In A Week: ");
            add(empHoursWorkedWLabel,gbc);

            emp.setHoursWorkedInAWeek((float) hoursInADay * 5);
            gbc.gridy = 5;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedW = new JTextField();
            empHoursWorkedW.setEditable(false);
            empHoursWorkedW.setText(emp.getHoursWorkedInAWeek());
            add(empHoursWorkedW,gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            divider = new JLabel("*************************************");
            add(divider, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empGWLabel = new JLabel("GrossWage: ");
            add(empGWLabel,gbc);

            gbc.gridy = 7;
            gbc.gridx = 1;
            emp.computeGrossWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empGW = new JTextField();
            empGW.setEditable(false);
            empGW.setText(pesoSign+emp.getGrossWage());
            add(empGW,gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTCLabel = new JLabel("Total Contributions: ");
            add(empTCLabel,gbc);

            gbc.gridy = 8;
            gbc.gridx = 1;
            emp.computeTotalContributions();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTC = new JTextField(pesoSign+emp.getTotalContributions());
            empTC.setEditable(false);
            add(empTC,gbc);

            gbc.gridy = 9;
            gbc.gridx = 1;
            divider1 = new JLabel("*************************************");
            add(divider1, gbc);

            gbc.gridy = 10;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTILabel = new JLabel("Taxable Income: ");
            add(empTILabel,gbc);

            gbc.gridy = 10;
            gbc.gridx = 1;
            emp.computeTaxableIncome();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTI = new JTextField(pesoSign+emp.getTaxableIncome());
            empTI.setEditable(false);
            add(empTI,gbc);

            gbc.gridy = 11;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empWithholdingLabel = new JLabel("Withholding Tax: ");
            add(empWithholdingLabel,gbc);

            gbc.gridy = 11;
            gbc.gridx = 1;
            emp.computeWithholdingTax();
            gbc.insets = new Insets(4, 0, 4, 0);
            empWithholding = new JTextField(pesoSign+emp.getWithholdingTax());
            empWithholding.setEditable(false);
            add(empWithholding,gbc);

            gbc.gridy = 12;
            gbc.gridx = 1;
            divider2 = new JLabel("*************************************");
            add(divider2, gbc);

            gbc.gridy = 13;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNetWageLabel = new JLabel("Net Wage: ");
            add(empNetWageLabel,gbc);

            gbc.gridy = 13;
            gbc.gridx = 1;
            emp.computeNetWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empNetWage = new JTextField(pesoSign+emp.getNetWage());
            empNetWage.setEditable(false);
            add(empNetWage,gbc);
        }else if (emp.getEmployeeNumber().equals("10004")) {
            Cell hoursInDay = sheetAttendance.getRow(4).getCell(6);
            double hoursInADay = Double.parseDouble(String.valueOf(hoursInDay));
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empDobLabel = new JLabel("Date of Birth: ");
            add(empDobLabel,gbc);

            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empDob = new JTextField();
            empDob.setEditable(false);
            empDob.setText(String.valueOf((sheet.getRow(4).getCell(3))));
            add(empDob, gbc);

            gbc.gridy = 3;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNameLabel = new JLabel("Name: ");
            add(empNameLabel,gbc);

            gbc.gridy = 3;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empName = new JTextField();
            empName.setEditable(false);
            empName.setText((sheet.getRow(4).getCell(2)) + " " + sheet.getRow(4).getCell(1));
            add(empName, gbc);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedDLabel = new JLabel("Hours Worked In A Day: ");
            add(empHoursWorkedDLabel,gbc);

            gbc.gridy = 4;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedD = new JTextField();
            empHoursWorkedD.setEditable(false);
            empHoursWorkedD.setText(String.valueOf(hoursInADay));
            add(empHoursWorkedD,gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedWLabel = new JLabel("Hours Worked In A Week: ");
            add(empHoursWorkedWLabel,gbc);

            emp.setHoursWorkedInAWeek((float) hoursInADay * 5);
            gbc.gridy = 5;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedW = new JTextField();
            empHoursWorkedW.setEditable(false);
            empHoursWorkedW.setText(emp.getHoursWorkedInAWeek());
            add(empHoursWorkedW,gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            divider = new JLabel("*************************************");
            add(divider, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empGWLabel = new JLabel("GrossWage: ");
            add(empGWLabel,gbc);

            gbc.gridy = 7;
            gbc.gridx = 1;
            emp.computeGrossWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empGW = new JTextField();
            empGW.setEditable(false);
            empGW.setText(pesoSign+emp.getGrossWage());
            add(empGW,gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTCLabel = new JLabel("Total Contributions: ");
            add(empTCLabel,gbc);

            gbc.gridy = 8;
            gbc.gridx = 1;
            emp.computeTotalContributions();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTC = new JTextField(pesoSign+emp.getTotalContributions());
            empTC.setEditable(false);
            add(empTC,gbc);

            gbc.gridy = 9;
            gbc.gridx = 1;
            divider1 = new JLabel("*************************************");
            add(divider1, gbc);

            gbc.gridy = 10;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTILabel = new JLabel("Taxable Income: ");
            add(empTILabel,gbc);

            gbc.gridy = 10;
            gbc.gridx = 1;
            emp.computeTaxableIncome();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTI = new JTextField(pesoSign+emp.getTaxableIncome());
            empTI.setEditable(false);
            add(empTI,gbc);

            gbc.gridy = 11;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empWithholdingLabel = new JLabel("Withholding Tax: ");
            add(empWithholdingLabel,gbc);

            gbc.gridy = 11;
            gbc.gridx = 1;
            emp.computeWithholdingTax();
            gbc.insets = new Insets(4, 0, 4, 0);
            empWithholding = new JTextField(pesoSign+emp.getWithholdingTax());
            empWithholding.setEditable(false);
            add(empWithholding,gbc);

            gbc.gridy = 12;
            gbc.gridx = 1;
            divider2 = new JLabel("*************************************");
            add(divider2, gbc);

            gbc.gridy = 13;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNetWageLabel = new JLabel("Net Wage: ");
            add(empNetWageLabel,gbc);

            gbc.gridy = 13;
            gbc.gridx = 1;
            emp.computeNetWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empNetWage = new JTextField(pesoSign+emp.getNetWage());
            empNetWage.setEditable(false);
            add(empNetWage,gbc);
        }else if (emp.getEmployeeNumber().equals("10005")) {
            Cell hoursInDay = sheetAttendance.getRow(5).getCell(6);
            double hoursInADay = Double.parseDouble(String.valueOf(hoursInDay));
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empDobLabel = new JLabel("Date of Birth: ");
            add(empDobLabel,gbc);

            gbc.gridy = 2;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empDob = new JTextField();
            empDob.setEditable(false);
            empDob.setText(String.valueOf((sheet.getRow(5).getCell(3))));
            add(empDob, gbc);

            gbc.gridy = 3;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNameLabel = new JLabel("Name: ");
            add(empNameLabel,gbc);

            gbc.gridy = 3;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empName = new JTextField();
            empName.setEditable(false);
            empName.setText((sheet.getRow(5).getCell(2)) + " " + sheet.getRow(5).getCell(1));
            add(empName, gbc);

            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedDLabel = new JLabel("Hours Worked In A Day: ");
            add(empHoursWorkedDLabel,gbc);

            gbc.gridy = 4;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedD = new JTextField();
            empHoursWorkedD.setEditable(false);
            empHoursWorkedD.setText(String.valueOf(hoursInADay));
            add(empHoursWorkedD,gbc);

            gbc.gridy = 5;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empHoursWorkedWLabel = new JLabel("Hours Worked In A Week: ");
            add(empHoursWorkedWLabel,gbc);

            emp.setHoursWorkedInAWeek((float) hoursInADay * 5);
            gbc.gridy = 5;
            gbc.gridx = 1;
            gbc.insets = new Insets(4, 0, 4, 0);
            empHoursWorkedW = new JTextField();
            empHoursWorkedW.setEditable(false);
            empHoursWorkedW.setText(emp.getHoursWorkedInAWeek());
            add(empHoursWorkedW,gbc);

            gbc.gridy = 6;
            gbc.gridx = 1;
            divider = new JLabel("*************************************");
            add(divider, gbc);

            gbc.gridy = 7;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empGWLabel = new JLabel("GrossWage: ");
            add(empGWLabel,gbc);

            gbc.gridy = 7;
            gbc.gridx = 1;
            emp.computeGrossWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empGW = new JTextField();
            empGW.setEditable(false);
            empGW.setText(pesoSign+emp.getGrossWage());
            add(empGW,gbc);

            gbc.gridy = 8;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTCLabel = new JLabel("Total Contributions: ");
            add(empTCLabel,gbc);

            gbc.gridy = 8;
            gbc.gridx = 1;
            emp.computeTotalContributions();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTC = new JTextField(pesoSign+emp.getTotalContributions());
            empTC.setEditable(false);
            add(empTC,gbc);

            gbc.gridy = 9;
            gbc.gridx = 1;
            divider1 = new JLabel("*************************************");
            add(divider1, gbc);

            gbc.gridy = 10;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empTILabel = new JLabel("Taxable Income: ");
            add(empTILabel,gbc);

            gbc.gridy = 10;
            gbc.gridx = 1;
            emp.computeTaxableIncome();
            gbc.insets = new Insets(4, 0, 4, 0);
            empTI = new JTextField(pesoSign+emp.getTaxableIncome());
            empTI.setEditable(false);
            add(empTI,gbc);

            gbc.gridy = 11;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empWithholdingLabel = new JLabel("Withholding Tax: ");
            add(empWithholdingLabel,gbc);

            gbc.gridy = 11;
            gbc.gridx = 1;
            emp.computeWithholdingTax();
            gbc.insets = new Insets(4, 0, 4, 0);
            empWithholding = new JTextField(pesoSign+emp.getWithholdingTax());
            empWithholding.setEditable(false);
            add(empWithholding,gbc);

            gbc.gridy = 12;
            gbc.gridx = 1;
            divider2 = new JLabel("*************************************");
            add(divider2, gbc);

            gbc.gridy = 13;
            gbc.gridx = 0;
            gbc.insets = new Insets(4, 0, 4, 0);
            JLabel empNetWageLabel = new JLabel("Net Wage: ");
            add(empNetWageLabel,gbc);

            gbc.gridy = 13;
            gbc.gridx = 1;
            emp.computeNetWage();
            gbc.insets = new Insets(4, 0, 4, 0);
            empNetWage = new JTextField(pesoSign+emp.getNetWage());
            empNetWage.setEditable(false);
            add(empNetWage,gbc);
        }
            getContentPane();
            setVisible(true);
        }
    }



