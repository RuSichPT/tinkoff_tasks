package com.github.rusichpt.contest2023.backend;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            int n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            s = scanner.nextLine();
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                String chStr = String.valueOf(ch);
                if (!map.containsKey(chStr)) {
                    map.put(chStr, 1);
                } else {
                    Integer count = map.get(chStr);
                    count++;
                    map.put(chStr, count);
                }
            }
            List<Integer> values = new ArrayList<>(map.values().stream().sorted(Comparator.reverseOrder()).toList());
            for (int i = values.size() - 1; i >= 0; i--) {
                Integer value = values.get(i);
                k -= value;
                if (k < 0) {
                    break;
                } else {
                    values.remove(i);
                }
            }

            System.out.println(values.size());

        }
    }
}