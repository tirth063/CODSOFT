import java.util.Scanner;



public class StudentGradeCalc {

    static int takeSub(){
        System.out.println("Enter Total Number of Subject");
        Scanner sc = new Scanner(System.in);
        int total_subject = sc.nextInt();
        return total_subject;
    }

    public static void main(String[] args) {
        int total_sub = takeSub();
        int total_marks =0;
        while (total_sub <= 0){
            total_sub = takeSub();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("marks Ranges from 1 to 100");
        int[] marks = new int[total_sub];

        for (int i = 0; i < total_sub; i++) {
            System.out.println("Enter marks for subject  "+(i+1) + "\t");
            marks[i] = sc.nextInt();
            total_marks += marks[i];
        }

        sc.close();
        //find Average Percentage:

        double per = (double) total_marks / total_sub ;
        String grade = "FAIL";
        if (per >= 100)
            grade = "S";
        else if (per >= 80) {
            grade = "A";
        }else if (per >= 70) {
            grade = "B";
        }else if (per >= 60) {
            grade = "C";
        }else if (per >= 50) {
            grade = "D";
        }else if (per >= 40) {
            grade = "E";
        }

        System.out.println("   =========================          ");
        System.out.println("result is : ");
        System.out.println("Your total marks is : " + total_marks + " out of " +(100*total_sub));
        System.out.println("Your total Average Percentage is : " +per);
        System.out.println("Your total Grade is : " +grade);

    }
}
