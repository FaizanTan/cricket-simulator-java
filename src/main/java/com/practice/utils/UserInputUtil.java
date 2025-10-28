package com.practice.utils;

import java.util.Scanner;

public class UserInputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static <T> T getUserInput(String prompt, Class<T> clazz) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.err.println("❌ Input cannot be empty. Please try again.");
                continue;
            }

            try {
                if (clazz == String.class) {
                    return clazz.cast(input);
                } else if (clazz == Integer.class) {
                    return clazz.cast(Integer.parseInt(input));
                } else if (clazz == Long.class) {
                    return clazz.cast(Long.parseLong(input));
                } else if (clazz == Double.class) {
                    return clazz.cast(Double.parseDouble(input));
                } else if (clazz == Boolean.class) {
                    switch (input.toLowerCase()) {
                        case "true", "yes", "y", "1" -> { return clazz.cast(Boolean.TRUE); }
                        case "false", "no", "n", "0" -> { return clazz.cast(Boolean.FALSE); }
                        default -> throw new IllegalArgumentException("Expected true/false, yes/no, y/n, 1/0");
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported type: " + clazz.getName());
                }
            } catch (Exception e) {
                System.err.println("❌ Cannot convert input to " + clazz.getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
