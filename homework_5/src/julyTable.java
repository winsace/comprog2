import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class julyTable extends JFrame implements ListSelectionListener {

    private final String[] columnNames = {"Employee Number", "Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pagibig No."};
    private final Object[][] data = {
            {"10001", "Crisostomo", "Jose", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646"},
            {"10002", "Mata", "Christian", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464"},
            {"10003", "San Jose", "Brad", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964"},
            {"10004", "Salcedo","Anthony", "26-9647608-3","126445315651","210-805-911-000","218002473454" },
            {"10005", "Romualdez","Alice", "55-4476527-2","545652640232","888-572-294-000","211385556888" },
            {"10006","Atienza","Rosie","41-0644692-3","708988234853","604-997-793-000","260107732354"},
            {"10007","Farala","Martha","45-5656375-0","233693897247","210-835-851-000","631130283546"},
            {"10008","Martinez","Leila","27-2090996-4","515741057496","275-792-513-000","101205445886"},
            {"10009","San Jose","Allison","5-3251383-0","745148459521","121-203-336-000","114901859343"},
            {"10010","Rosario","Cydney","49-1629900-2","579253435499","122-244-511-000","265104358643"},
            {"10011","Lopez","Josie ","44-8563448-3","431709011012","218-489-737-000","113071293354"},
            {"10012","De Leon","Selena ","27-2090208-8","587272469938","482-259-498-000","719007608464"},
            {"10013","Romualdez","Fredrick","26-8768374-1","308366860059","598-065-761-000","223057707853"},
            {"10014","Bautista","Mark","49-1647342-5","399665157135","273-970-941-000","260054585575"},
            {"10015","Lazaro","Darlene","45-5617168-2","606386917510","354-650-951-000","104907708845"},
            {"10016","Delos Santos","Kolby ","52-0109570-6","357451271274","187-500-345-000","113017988667"},
            {"10017","Santos","Vella","52-9883524-3","548670482885","101-558-994-000","360028104576"},
            {"10018","Del Rosario","Tomas","45-5866331-6","953901539995","560-735-732-000","913108649964"},
            {"10019","Tolentino","Jacklyn ","47-1692793-0","753800654114","841-177-857-000","210546661243"},
            {"10020","Gutierrez","Percival","40-9504657-8","797639382265","502-995-671-000","210897095686"},
            {"10021","Manalaysay","Garfield ","45-3298166-4","810909286264","336-676-445-000","211274476563"},
            {"10022","Villegas","Lizeth","40-2400719-4","934389652994","210-395-397-000","122238077997"},
            {"10023","Ramos","Carol","60-1152206-4","351830469744","395-032-717-000","212141893454"},
            {"10024","Maceda","Emelia","54-1331005-0","465087894112","215-973-013-000","515012579765"},
            {"10025","Aguilar","Delia","52-1859253-1","136451303068","599-312-588-000","110018813465"},
    };
    private final JTable table = new JTable(new DefaultTableModel(data, columnNames));
    private final JButton view;
    private JTextField basicSalary, riceSubsidy, phoneAllowance, clothingAllow, grossSemiMonthRate, hourlyRate, hoursWorked;
    private final JDialog sndFrame = new JDialog();
    private final String path = "C:\\Users\\Admin\\Downloads\\motorPhh.xlsx";
    private final FileInputStream read = new FileInputStream(path);
    private final XSSFWorkbook wb = new XSSFWorkbook(read);
    private final XSSFSheet sheet = wb.getSheet("Employee Details");
    private final XSSFSheet sheetAttendance = wb.getSheet("Attendance Record");
    public julyTable() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(800, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Employee Records - July");

        sndFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        sndFrame.setLayout(new GridBagLayout());
        sndFrame.setSize(300, 300);
        sndFrame.setResizable(false);
        sndFrame.setLocationRelativeTo(null);
        sndFrame.setVisible(false);

        JPanel panel = new JPanel();
        panel.setSize(700, 400);
        panel.setBackground(Color.gray);
        panel.setLayout(new GridBagLayout());
        panel.setVisible(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.gridx = 1;
        table.setSize(700, 300);
        table.getSelectionModel().addListSelectionListener(this);
        panel.add(table, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        view = new JButton("View Details");
        view.setEnabled(false);
        view.setFocusable(false);
        view.addActionListener(e -> {
            int selectRow = table.getSelectedRow();
            if (selectRow >= 0) {
                if (selectRow == 0) {
                    // Add new content to the JFrame
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(101).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(1).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(1).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(1).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(1).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(1).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(1).getCell(16)));
                } else if (selectRow == 1) {
                    // Add new content to the JFrame
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(102).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(2).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(2).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(2).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(2).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(2).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(2).getCell(16)));
                }else if (selectRow ==2){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(103).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(3).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(3).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(3).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(3).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(3).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(3).getCell(16)));
                }else if (selectRow ==3){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(104).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(4).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(4).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(4).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(4).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(4).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(4).getCell(16)));
                }else if (selectRow ==4){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(105).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(5).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(5).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(5).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(5).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(5).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(5).getCell(16)));
                }else if (selectRow ==5){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(106).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(6).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(6).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(6).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(6).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(6).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(6).getCell(16)));
                }else if (selectRow ==6){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(107).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(7).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(7).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(7).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(7).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(7).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(7).getCell(16)));
                }else if (selectRow ==7){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(108).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(8).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(8).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(8).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(8).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(8).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(8).getCell(16)));
                }else if (selectRow ==8){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(109).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(9).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(9).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(9).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(9).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(9).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(9).getCell(16)));
                }else if (selectRow ==9){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(110).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(10).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(10).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(10).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(10).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(10).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(10).getCell(16)));
                }else if (selectRow ==10){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(111).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(11).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(11).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(11).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(11).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(11).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(11).getCell(16)));
                }else if (selectRow ==11){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(112).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(12).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(12).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(12).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(12).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(12).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(12).getCell(16)));
                }else if (selectRow ==12){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(113).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(13).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(13).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(13).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(13).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(13).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(13).getCell(16)));
                }else if (selectRow ==13){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(114).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(14).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(14).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(14).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(14).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(14).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(14).getCell(16)));
                }else if (selectRow ==14){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(115).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(15).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(15).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(15).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(15).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(15).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(15).getCell(16)));
                }else if (selectRow ==15){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(116).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(16).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(16).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(16).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(16).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(16).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(16).getCell(16)));
                }else if (selectRow ==16){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(117).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(17).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(17).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(17).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(17).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(17).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(17).getCell(16)));
                }else if (selectRow ==17){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(118).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(18).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(18).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(18).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(18).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(18).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(18).getCell(16)));
                }else if (selectRow ==18){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(119).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(19).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(19).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(19).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(19).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(19).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(19).getCell(16)));
                }else if (selectRow ==19){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(120).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(20).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(20).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(20).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(20).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(20).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(20).getCell(16)));
                }else if (selectRow ==20){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(121).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(21).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(21).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(21).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(21).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(21).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(21).getCell(16)));
                }else if (selectRow ==21){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(122).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(22).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(22).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(22).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(22).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(22).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(22).getCell(16)));
                }else if (selectRow ==22){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(123).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(23).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(23).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(23).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(23).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(23).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(23).getCell(16)));
                }else if (selectRow ==23){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(124).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(24).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(24).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(24).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(24).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(24).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(24).getCell(16)));
                }else if (selectRow ==24){
                    sndFrame.setVisible(true);
                    sndFrame.setVisible(true);
                    hoursWorked.setText(String.valueOf(sheetAttendance.getRow(125).getCell(6)));
                    hourlyRate.setText(String.valueOf(sheet.getRow(25).getCell(18)));
                    grossSemiMonthRate.setText(String.valueOf(sheet.getRow(25).getCell(17)));
                    basicSalary.setText(String.valueOf(sheet.getRow(25).getCell(13)));
                    riceSubsidy.setText(String.valueOf(sheet.getRow(25).getCell(14)));
                    phoneAllowance.setText(String.valueOf(sheet.getRow(25).getCell(15)));
                    clothingAllow.setText(String.valueOf(sheet.getRow(25).getCell(16)));
                }
            }
        });
        add(view, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        JButton update = new JButton("Update Details");
        update.setEnabled(true);
        update.setFocusable(false);
        update.addActionListener(e -> {
            int selectRow = table.getSelectedRow();
            int selectColumn = table.getSelectedColumn();
            if (selectRow >= 0 && selectColumn == 0) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 1) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 2) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 3) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 4) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 5) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else if (selectRow >= 0 && selectColumn == 6) {
                String updatedValue = JOptionPane.showInputDialog(null, "Enter updated value:");
                table.setValueAt(updatedValue, selectRow, selectColumn);
                table.getColumnModel().getColumn(selectColumn).setCellEditor(null); // Make the cell non-editable
            }else {
                JOptionPane.showMessageDialog(julyTable.this, "Please select a tab to update.");
            }
        });
        panel.add(update, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        JButton delete = new JButton("Delete Employee");
        delete.setEnabled(true);
        delete.setFocusable(false);
        delete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(julyTable.this,
                        "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Remove the selected row from the table
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);

                    // Show a deletion confirmation message
                    JOptionPane.showMessageDialog(julyTable.this, "Employee deleted successfully.");

                    // Clear the input fields
                    clearInputFields();
                }
            } else {
                JOptionPane.showMessageDialog(julyTable.this, "Please select an employee to delete.");
            }
        });

        panel.add(delete,gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        JButton back = new JButton("Back");
        back.setFocusable(false);
        back.addActionListener(e -> {
            dispose();
            sndFrame.dispose();
            new login();
        });
        add(back,gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        JLabel january = new JLabel("|July|");
        sndFrame.add(january,gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel hoursWorkedLb = new JLabel("Hours Worked: ");
        sndFrame.add(hoursWorkedLb,gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        hoursWorked = new JTextField("      ");
        hoursWorked.setEditable(false);
        sndFrame.add(hoursWorked, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel hourRateLb = new JLabel("Hourly Rate: ₱");
        sndFrame.add(hourRateLb,gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        hourlyRate = new JTextField("      ");
        hourlyRate.setEditable(false);
        sndFrame.add(hourlyRate, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel grossSemRateLb = new JLabel("Gross Semi-Monthly Rate: ₱");
        sndFrame.add(grossSemRateLb,gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        grossSemiMonthRate = new JTextField("      ");
        grossSemiMonthRate.setEditable(false);
        sndFrame.add(grossSemiMonthRate, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel basicSalaryLb = new JLabel("Basic Salary: ₱");
        sndFrame.add(basicSalaryLb, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        basicSalary = new JTextField("      ");
        basicSalary.setEditable(false);
        sndFrame.add(basicSalary, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        JLabel riceSubdLb = new JLabel("Rice Subsidy: ₱");
        sndFrame.add(riceSubdLb,gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        riceSubsidy = new JTextField("      ");
        riceSubsidy.setEditable(false);
        sndFrame.add(riceSubsidy, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        JLabel phoneAllowLb = new JLabel("Phone Allowance: ₱");
        sndFrame.add(phoneAllowLb,gbc);

        gbc.gridy = 6;
        gbc.gridx = 1;
        phoneAllowance = new JTextField("      ");
        phoneAllowance.setEditable(false);
        sndFrame.add(phoneAllowance, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        JLabel clotheAllowLb = new JLabel("Clothing Allowance: ₱");
        sndFrame.add(clotheAllowLb,gbc);

        gbc.gridy = 7;
        gbc.gridx = 1;
        clothingAllow = new JTextField("      ");
        clothingAllow.setEditable(false);
        sndFrame.add(clothingAllow, gbc);

        add(panel);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectRow = table.getSelectedRow();
        view.setEnabled(selectRow >= 0);
    }

    private void clearInputFields() {
        hoursWorked.setText("");
        hourlyRate.setText("");
        grossSemiMonthRate.setText("");
        basicSalary.setText("");
        riceSubsidy.setText("");
        phoneAllowance.setText("");
        clothingAllow.setText("");
    }
}
