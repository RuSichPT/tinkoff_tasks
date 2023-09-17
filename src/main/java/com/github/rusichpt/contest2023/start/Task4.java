package com.github.rusichpt.contest2023.start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Integer> aList = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                aList.add(scanner.nextInt());
            }
            aList.addAll(aList);
            aList.sort(Collections.reverseOrder());
            List<Integer> ans = new ArrayList<>();
            int sum = sumRecur(aList, 0, n, ans);

            if (sum == n) {
                System.out.println(ans.size());
                for (int i = ans.size() - 1; i >= 0; i--) {
                    System.out.print(ans.get(i));
                    System.out.print(" ");
                }
            } else {
                System.out.println(-1);
            }
        }
    }

    private static int sumRecur(List<Integer> aList, int sum, int n, List<Integer> ans) {
        if (aList.size() == 0) {
            return sum;
        }
        for (int i = 0; i < aList.size(); i++) {
            if (sum < n) {
                Integer a = aList.get(i);
                sum += a;
                ans.add(a);
            } else if (sum > n) {
                sum -= ans.get(ans.size() - 1);
                ans.remove(ans.size() - 1);
                List<Integer> subList = aList.subList(i, aList.size());

                sum = sumRecur(subList, sum, n, ans);
            } else {
                return sum;
            }
        }

        return sum;
    }

}