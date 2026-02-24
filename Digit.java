// ======================
// Digit.java
// Do nothing!
// ======================

public class Digit {
    private int value;

    public Digit(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}