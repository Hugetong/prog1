public class Expense {
    private final String text;
    private final int value;

    public Expense(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return text + ": " + (double) value / 100 + " EUR";
    }

}

