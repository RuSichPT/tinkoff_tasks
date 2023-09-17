package com.github.rusichpt.contest2023.test;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int result = A;
        int D = scanner.nextInt();

        if (D > B) {
            result += (D - B) * C;
        }

        System.out.println(result);
    }

}