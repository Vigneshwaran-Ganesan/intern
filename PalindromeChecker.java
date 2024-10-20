import java.util.Scanner;

public class PalindromeChecker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word or phrase: ");
        String input = sc.nextLine();
        if (isPalindrome(input)) {
            System.out.println("The entered word or phrase is a palindrome.");
        } else {
            System.out.println("The entered word or phrase is not a palindrome.");
        }
        sc.close();
    }

    public static boolean isPalindrome(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int length = cleanedInput.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}