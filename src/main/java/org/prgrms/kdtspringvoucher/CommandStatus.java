package org.prgrms.kdtspringvoucher;

public enum CommandStatus {
    EXIT,
    CREATE,
    LIST,
    WRONG;

    public static CommandStatus getCommand(String s) {
        switch (s) {
            case "exit":
                return EXIT;
            case "create":
                return CREATE;
            case "list":
                return LIST;
            default:
                return WRONG;
        }
    }
}
