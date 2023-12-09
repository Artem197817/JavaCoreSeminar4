package view;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner((System.in));

    public String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }


    public Integer inputInt(String message) {
        int result;
        try {
            result = Integer.parseInt(input(message));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат. Введите число еще раз");
            result = inputInt(message);
        }
        return result;
    }
}
