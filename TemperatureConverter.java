import java.util.Scanner;

public class TemperatureConverter{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature=sc.nextDouble();
        System.out.print("Enter temperature unit (C for Celsius, F for Fahrenheit): ");
        String unit=sc.next().toUpperCase();

        double result;

        if (unit.equals("C")) {
            result=ToFahrenheit(temperature);
            System.out.printf("%.2f C => %.2f F",temperature,result);
        } else if(unit.equals("F")) {
            result=ToCelsius(temperature);
            System.out.printf("%.2f F => %.2f C",temperature,result);
        } else {
            System.out.println("Invalid unit entered.Enter C or F.");
            return;
        }

        sc.close();
    }

    public static double ToFahrenheit(double c){
        return(c*9/5)+32;
    }

    public static double ToCelsius(double f){
        return (f-32)*5/9;
    }
}
