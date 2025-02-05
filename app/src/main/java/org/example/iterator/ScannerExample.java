package org.example.iterator;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        String data = "10 20 30";
        Scanner scanner = new Scanner(data);

        while (scanner.hasNextInt()) {  // 类似于 Iterator 的 hasNext()
            int number = scanner.nextInt();  // 类似于 Iterator 的 next()
            System.out.println("Number: " + number);
        }

        scanner.close();
    }
}
