package com.github.rusichpt.contest2023.backend;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            List<Integer> aList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                aList.add(scanner.nextInt());
            }

            int k1;
            int k2;
            boolean sub = true;
            int min = alDangerous(aList);
            for (int i = 0; i < c; i++) {
                List<Integer> copy = new ArrayList<>(aList);
                int minValue = Collections.min(copy);
                k1 = aList.indexOf(minValue);
                copy.set(k1, Integer.MAX_VALUE);
                minValue = Collections.min(copy);
                k2 = aList.indexOf(minValue);
                copy.set(k2, Integer.MAX_VALUE);

                List<Integer> copy1 = new ArrayList<>(aList);
                change(copy1, k1, sub, d);
                int newMin1 = alDangerous(copy1);

                List<Integer> copy2 = new ArrayList<>(aList);
                change(copy2, k2, !sub, d);
                int newMin2 = alDangerous(copy2);

                int newMin;
                if (newMin1 < newMin2) {
                    copy = copy1;
                    newMin = newMin1;
                } else {
                    copy = copy2;
                    newMin = newMin2;
                }
                if (newMin <= min) {
                    min = newMin1;
                    aList = copy;
                } else {
                    sub = !sub;
                    aList.set(k1, aList.get(k1));
                }
            }

            for (Integer integer : aList) {
                System.out.print(integer);
                System.out.print(" ");
            }

        }
    }

    private static int alDangerous(List<Integer> aList) {
        int all = 1;
        for (Integer integer : aList) {
            all *= integer;
        }
        return all;
    }

    private static void change(List<Integer> aList, int index, boolean sub, int d) {
        if (index == aList.size())
            return;

        Integer a = aList.get(index);
        if (sub) {
            a -= d;
        } else {
            a += d;
        }
        aList.set(index, a);
    }

}