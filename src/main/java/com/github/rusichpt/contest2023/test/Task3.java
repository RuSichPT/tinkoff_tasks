package com.github.rusichpt.contest2023.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();

            List<Integer> floors = new ArrayList<>(15);
            for (int i = 0; i < n; i++) {
                floors.add(scanner.nextInt());
            }
            int num = scanner.nextInt() - 1;

            //
            int result = Integer.MAX_VALUE;
            for (int floor = 0; floor < n; floor++) {
                //1
                boolean ok = false;
                int dist = 0;
                for (int i = floor; i < n - 1; i++) {
                    if (i == num && t >= dist) {
                        ok = true;
                    }
                    dist += floors.get(i + 1) - floors.get(i);
                }
                for (int i = n - 1; i > 0; i--) {
                    if (floor == 0)
                        break;
                    if (i == num && t >= dist) {
                        ok = true;
                    }
                    dist += floors.get(i) - floors.get(i - 1);
                }

                if (ok) result = Math.min(result, dist);

                //2
                ok = false;
                dist = 0;
                for (int i = floor; i > 0; i--) {
                    if (i == num && t >= dist) {
                        ok = true;
                    }
                    dist += floors.get(i) - floors.get(i - 1);
                }
                for (int i = 0; i < n - 1; i++) {
                    if (floor == n - 1)
                        break;
                    if (i == num && t >= dist) {
                        ok = true;
                    }
                    dist += floors.get(i + 1) - floors.get(i);
                }

                if (ok) result = Math.min(result, dist);
            }

            System.out.println(result);

        }
    }
}
