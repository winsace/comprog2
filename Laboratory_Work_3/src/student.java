public class student {
    private String studentNumber;
    private String studentName;
    private float quiz1;
    private float quiz2;
    private float quiz3;
    private float averageGrade;

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getQuiz1() {
        return String.valueOf(quiz1);
    }

    public String getQuiz2() {
        return String.valueOf(quiz2);
    }

    public String getQuiz3() {
        return String.valueOf(quiz3);
    }

    public String getAveGrade() {
        return String.valueOf(averageGrade);
    }

    //setter methods
    public void setStudentNumber(String studNumber) {
        studentNumber = studNumber;
    }

    public void setStudentName(String studName) {
        studentName = studName;
    }

    public void setQuiz1(float q1) {
        quiz1 = q1;
    }

    public void setQuiz2(float q2) {
        quiz2 = q2;
    }

    public void setQuiz3(float q3) {
        quiz3 = q3;
    }

    //methods

    public float percentQ1(){
        quiz1 = (quiz1/25)*100;
        return quiz1;
    }
    public float percentQ2(){
        quiz2 = (quiz2/40)*100;
        return quiz2;
    }
    public float percentQ3(){
        quiz3 = (quiz3/35)*100;
        return quiz3;
    }
    public float computeAverage() {
        quiz1 = Math.max(quiz1, 0);
        quiz1 = Math.min(quiz1, 25);
        quiz2 = Math.max(quiz2, 0);
        quiz2 = Math.min(quiz2, 40);
        quiz3 = Math.max(quiz3, 0);
        quiz3 = Math.min(quiz3, 35);
        averageGrade = ((((quiz1/25) * 100) + ((quiz2/40) * 100) + ((quiz3/35) * 100)) /3);
        return averageGrade;
    }
}
