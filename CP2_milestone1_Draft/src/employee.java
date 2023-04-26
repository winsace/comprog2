import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class employee {
    String path = "C:\\Users\\Admin\\Downloads\\motorPh.xlsx";
    FileInputStream read = new FileInputStream(path);
    XSSFWorkbook wb = new XSSFWorkbook(read);
    XSSFSheet sheet = wb.getSheet("Attendance Record");
    private float hoursWorkedInAWeek;
    private int employeeNumber;
    private float employeePay;
    private float grossWage;
    private float totalContributions;
    private float taxableIncome;
    private float withholdingTax;
    private float netWage;


    public employee() throws IOException {
    }

    //getters
    public String getEmployeeNumber(){

        return String.valueOf(employeeNumber);
    }
    public String getHoursWorkedInAWeek(){

        return String.valueOf(hoursWorkedInAWeek);
    }
    public String getEmployeePay(){

        return String.valueOf(employeePay);
    }
    public String getGrossWage(){

        return String.valueOf(grossWage);
    }

    public String getNetWage(){

        return String.valueOf(netWage);
    }

    public String getTotalContributions(){

        return String.valueOf(totalContributions);
    }

    public String getTaxableIncome(){

        return String.valueOf(taxableIncome);
    }
    public String getWithholdingTax(){

        return String.valueOf(withholdingTax);
    }
    //setters
    public void setEmployeeNumber(String number){

        employeeNumber = Integer.parseInt(number);
    }
    public void setEmployeePay(float pay){

        employeePay = pay;
    }

    public void setHoursWorkedInAWeek(float week){

        hoursWorkedInAWeek = week;
    }

    //methods
    public float computeGrossWage(){
        grossWage = employeePay * hoursWorkedInAWeek * 4;
        return grossWage;
    }
    public double computeTotalContributions() {
        float pagIBig = 100;
        float philHealth = 300;
        float philHealth1 = (float) ((grossWage * 0.03) / (2));
        float philHealth2 = 1800;
        double sss = 135;
        if ((grossWage >= 3250.00) && (grossWage <= 3750.00)) {
            sss = 157.50;
        } else if ((grossWage >= 3750.01) && (grossWage <= 4250.00)) {
            sss = 180.00;
        } else if ((grossWage >= 4250.01) && (grossWage <= 4750.00)) {
            sss = 202.50;
        } else if ((grossWage >= 4750.01) && (grossWage <= 5250.00)) {
            sss = 225.00;
        } else if ((grossWage >= 5250.01) && (grossWage <= 5750.00)) {
            sss = 247.50;
        } else if ((grossWage >= 5750.01) && (grossWage <= 6250.00)) {
            sss = 270.00;
        } else if ((grossWage >= 6250.01) && (grossWage <= 6750.00)) {
            sss = 292.50;
        } else if ((grossWage >= 6750.01) && (grossWage <= 7250.00)) {
            sss = 315.00;
        } else if ((grossWage >= 7250.01) && (grossWage <= 7750.00)) {
            sss = 337.50;
        } else if ((grossWage >= 7750.01) && (grossWage <= 8250.00)) {
            sss = 360.00;
        } else if ((grossWage >= 8250.01) && (grossWage <= 8750.00)) {
            sss = 382.50;
        } else if ((grossWage >= 8750.01) && (grossWage <= 9250.00)) {
            sss = 405.00;
        } else if ((grossWage >= 9250.01) && (grossWage <= 9750.00)) {
            sss = 427.50;
        } else if ((grossWage >= 9750.01) && (grossWage <= 10250.00)) {
            sss = 450.00;
        } else if ((grossWage >= 10250.01) && (grossWage <= 10750.00)) {
            sss = 472.50;
        } else if ((grossWage >= 10750.01) && (grossWage <= 11250.00)) {
            sss = 495.00;
        } else if ((grossWage >= 11250.01) && (grossWage <= 11750.00)) {
            sss = 517.50;
        } else if ((grossWage >= 11750.01) && (grossWage <= 12250.00)) {
            sss = 540.00;
        } else if ((grossWage >= 12250.01) && (grossWage <= 12750.00)) {
            sss = 562.50;
        } else if ((grossWage >= 12750.01) && (grossWage <= 13250.00)) {
            sss = 585.00;
        } else if ((grossWage >= 13250.01) && (grossWage <= 13750.00)) {
            sss = 607.50;
        } else if ((grossWage >= 13750.01) && (grossWage <= 14250.00)) {
            sss = 630.00;
        } else if ((grossWage >= 14250.01) && (grossWage <= 14750.00)) {
            sss = 652.50;
        } else if ((grossWage >= 14750.01) && (grossWage <= 15250.00)) {
            sss = 675.00;
        } else if ((grossWage >= 15250.01) && (grossWage <= 15750.00)) {
            sss = 697.50;
        } else if ((grossWage >= 15750.01) && (grossWage <= 16250.00)) {
            sss = 720.00;
        } else if ((grossWage >= 16250.01) && (grossWage <= 16750.00)) {
            sss = 742.50;
        } else if ((grossWage >= 16750.01) && (grossWage <= 17250.00)) {
            sss = 765.00;
        } else if ((grossWage >= 17250.01) && (grossWage <= 17750.00)) {
            sss = 787.50;
        } else if ((grossWage >= 17750.01) && (grossWage <= 18250.00)) {
            sss = 810.00;
        } else if ((grossWage >= 18250.01) && (grossWage <= 18750.00)) {
            sss = 832.50;
        } else if ((grossWage >= 18750.01) && (grossWage <= 19250.00)) {
            sss = 855.00;
        } else if ((grossWage >= 19250.01) && (grossWage <= 19750.00)) {
            sss = 877.50;
        } else if ((grossWage >= 19750.01) && (grossWage <= 20250.00)) {
            sss = 900.00;
        } else if ((grossWage >= 20250.01) && (grossWage <= 20750.00)) {
            sss = 922.50;
        } else if ((grossWage >= 20750.01) && (grossWage <= 21250.00)) {
            sss = 945.00;
        } else if ((grossWage >= 21250.01) && (grossWage <= 21750.00)) {
            sss = 967.50;
        } else if ((grossWage >= 21750.01) && (grossWage <= 22250.00)) {
            sss = 990.00;
        } else if ((grossWage >= 22250.01) && (grossWage <= 22750.00)) {
            sss = 1012.50;
        } else if ((grossWage >= 22750.01) && (grossWage <= 23250.00)) {
            sss = 1035.00;
        } else if ((grossWage >= 23250.01) && (grossWage <= 23750.00)) {
            sss = 1057.50;
        } else if ((grossWage >= 23750.01) && (grossWage <= 24250.00)) {
            sss = 1080.00;
        } else if ((grossWage >= 24250.01) && (grossWage <= 24750.00)) {
            sss = 1102.50;
        } else if (grossWage >= 24750.01) {
            sss = 1125.00;
        }

        if (grossWage <= 10000.00) {
            totalContributions = (float) (philHealth + sss + pagIBig);
        } else if ((grossWage >= 10000.01) && (grossWage <= 59999.99)){
            totalContributions = (float) (philHealth1 + sss + pagIBig);
        } else if(grossWage>=60000.00){
            totalContributions = (float) (philHealth2 + sss + pagIBig);
        }
        return totalContributions;
    }

    public float computeTaxableIncome(){
        taxableIncome = grossWage - totalContributions;
        return taxableIncome;
    }

    public float computeWithholdingTax(){
        if (taxableIncome <= 20832.99){
            withholdingTax = 0;
        }else if ((taxableIncome >=20833.00)&&(taxableIncome<=33332.99)){
            withholdingTax = (float) ((taxableIncome-20833)*0.20);
        }else if ((taxableIncome>=33333.00)&&(taxableIncome<=66666.99)){
            withholdingTax = (float) ((taxableIncome-33333) * 0.25 + (2500));
        }else if ((taxableIncome>=66667.00)&&(taxableIncome<=166666.99)){
            withholdingTax = (float) ((taxableIncome-66667.00) * 0.30 + (10833));
        }else if ((taxableIncome>=166667.00)&&(taxableIncome<=666666.99)) {
            withholdingTax = (float) ((taxableIncome - 166667.00) * 0.32 + (40833.33));
        }else if (taxableIncome>=666667.00){
            withholdingTax = (float) ((taxableIncome - 666667.00) * 0.35 + (200833.33));
        }
        return withholdingTax;
    }

    public float computeNetWage(){
        netWage = taxableIncome - withholdingTax;
        return netWage;
    }
}
