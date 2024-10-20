import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of grades: ");
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println("Number of grades must be a positive integer.");
            return;
        }
        double sum = 0;
        for (int i = 1; i <= num; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = sc.nextDouble();
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                i--; 
                continue;
            }
            sum += grade;
        }
        double avg = sum / num;
        System.out.printf("The average grade is: %.2f%n", avg);
        sc.close();
    }
}