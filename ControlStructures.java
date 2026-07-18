import java.util.*;

public class ControlStructures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
        switch (num % 3) {
            case 0 -> System.out.println("Divisible by 3");
            case 1 -> System.out.println("Remainder 1 when divided by 3");
            default -> System.out.println("Remainder 2 when divided by 3");
        }
        System.out.println("Multiplication table:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

        sc.close();
    }
}