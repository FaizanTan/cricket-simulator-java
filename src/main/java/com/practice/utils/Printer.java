package com.practice.utils;

import com.practice.interfaces.Printable;

public class Printer {

    public static void print(Printable printable) {
        System.out.println("------------------------------------------------");
        printable.print();
        System.out.println("------------------------------------------------");
    }
}
