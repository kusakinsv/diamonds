package ru.one.project;

import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    private static int height, width = 0;
    private static final Character paintSymbol = '#';

    public static void main(String[] args) {
        while (true) {
            getSize();
            MainApplication.printDiamond(height, width);
            height = width = 0;
        }
    }

    private static void getSize() {
        Scanner scanner = new Scanner(System.in);
        while (height < 1 || height > 80) {
            try {
                System.out.println("Enter the height of the diamond from 1 to 80 or 'q' to quit");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.exit(0);
                }
                height = Integer.parseInt(input);
            } catch (Exception ignore){}
        }
        while (width < 1 || width > 80) {
            try {
                System.out.println("Enter the width of the diamond from 1 to 80 or 'q' to quit");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.exit(0);
                }
                width = Integer.parseInt(input);
            } catch (Exception ignore){}
        }
    }

    //Построить в 1 цикл с минимальным кол-вом переменных
    private static void printDiamond(int height, int width) {
        for (int h = 0; h < height; h++) {
            char[] characters = new char[width];
            Arrays.fill(characters, ' ');
            int coeffValue;
            if (h <= height / 2) {
                coeffValue = width * (height == 1 ? (100) : h * 100 / (height - 1)) / 100;
                characters[Math.max((width / 2 - coeffValue), 0)] = paintSymbol;
                characters[(width / 2 + coeffValue) >= width ? width - 1 : width / 2 + coeffValue] = paintSymbol;
            } else {
                coeffValue = width * ((h == height - 1) ? 0 : (height - h) * 100 / (height + 1)) / 100;
                characters[width / 2 - coeffValue] = paintSymbol;
                characters[width / 2 + coeffValue] = paintSymbol;
            }
            System.out.println(characters);
        }
    }
}
