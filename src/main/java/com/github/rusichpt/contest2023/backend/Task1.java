package com.github.rusichpt.contest2023.backend;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int s = scanner.nextInt();
            int n = scanner.nextInt();

            int k = 0;
            int dif = (s - k);
            while (n - dif >= 0) {
                n -= dif;
                k++;
                k = k % s;
                dif = (s - k);
            }

            System.out.println(n);
        }
    }
}