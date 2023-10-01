package machine.packages.enums;

public enum Mode {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    public final String mode;

    Mode(String mode) {
        this.mode = mode;
    }
}
