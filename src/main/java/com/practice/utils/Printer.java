package com.practice.utils;

import com.practice.interfaces.Printable;

public class Printer {

    public static void print(Printable printable) {
        if (null != printable) printable.print();
        else System.err.println("Nothing to print");
    }
}
