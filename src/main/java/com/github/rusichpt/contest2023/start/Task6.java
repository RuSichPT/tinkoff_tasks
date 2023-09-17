package com.github.rusichpt.contest2023.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<List<Integer>> spirits = new ArrayList<>(n);
            List<Integer> count = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> group = new ArrayList<>();
                group.add(i + 1);
                spirits.add(group);
                count.add(1);
            }

            for (int i = 0; i < m; i++) {
                int type = scanner.nextInt();
                int x, y = 0;
                x = scanner.nextInt();
                if (type == 1 || type == 2) {
                    y = scanner.nextInt();
                }

                if (type == 1 || type == 2) {

                    int idxX = findSpirit(spirits, x);
                    List<Integer> xGroup = spirits.get(idxX);
                    int idxY = findSpirit(spirits, y);
                    List<Integer> yGroup = spirits.get(idxY);

                    if (type == 1) {
                        xGroup.addAll(yGroup);
                        yGroup.clear();
                        changeCount(xGroup, count);
                    } else {
                        if (idxX == idxY) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                    }
                } else {
                    System.out.println(count.get(x - 1));
                }
            }
        }
    }

    private static int findSpirit(List<List<Integer>> spirits, int numSpirit) {
        int indexSpirit = -1;
        for (int i = 0; i < spirits.size(); i++) {
            List<Integer> group = spirits.get(i);
            if (group.contains(numSpirit)) {
                return i;
            }
        }
        return indexSpirit;
    }

    private static void changeCount(List<Integer> group, List<Integer> count) {
        for (int value : group) {
            int tmp = count.get(value - 1);
            count.set(value - 1, ++tmp);
        }
    }
}