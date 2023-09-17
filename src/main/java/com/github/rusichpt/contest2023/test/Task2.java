package com.github.rusichpt.contest2023.test;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();

        long value = 1;
        int n = 0;
        while (x > value) {
            value *= 2;
            n++;
        }
        System.out.println(n);
    }
}
