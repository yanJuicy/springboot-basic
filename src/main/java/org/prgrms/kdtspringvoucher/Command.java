package org.prgrms.kdtspringvoucher;

public enum Command {
    EXIT,
    CREATE,
    LIST ;

    public static Command getCommand(String s) {
        switch (s) {
            case "exit":
                return EXIT;
            case "create":
                return CREATE;
            case "list":
                return LIST;
            default:
                return null;
        }
    }
}
