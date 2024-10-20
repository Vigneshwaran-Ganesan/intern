import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
        
        StringBuilder characterPool = new StringBuilder();
        
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeLowercase) {
            characterPool.append(lowercase);
        }
        if (includeUppercase) {
            characterPool.append(uppercase);
        }
        if (includeSpecial) {
            characterPool.append(special);
        }
        
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("You must select at least one character type!");
        }
        
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");
        
        try {
            String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
            System.out.println("Your generated password is: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        scanner.close();
    }
}
