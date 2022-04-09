package me.programmers.springboot.basic.springbootbasic.io;

import java.util.Scanner;

public class Console implements ConsoleInput, ConsoleOutput {

    Scanner sc = new Scanner(System.in);

    @Override
    public String inputCommand(String s) {
        System.out.print(s + " ");
        return sc.nextLine().toLowerCase();
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }
}