package org.prgrms.kdtspringvoucher.io;

import java.util.Scanner;

public class Console implements Input, Output{

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
