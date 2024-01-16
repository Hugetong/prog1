import java.util.Random;

public class Task {
    public enum Priority {
        URGENT, NORMAL, LOW;
    }

    private final String text;
    private Priority priority;
    private int dueDate;

    private Task(String text, Priority priority, int dueDate) {
        this.text = text;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getText() {
        return text;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getDueDate() {
        return dueDate;
    }

    public String toString() {
        return text + " (" + priority + ") " + "in " + dueDate + " Tagen";
    }

    public void reduceDueDate() {
        if (dueDate > 0) {
            dueDate--;

            if (dueDate == 0) {
                System.out.println("due date.");
            }
            if (dueDate < 5) {
                priority = Priority.URGENT;
            }
        }
    }
    public static Task generateRandomTask() {
        Random random = new Random();
        String text = "Aufgabe " + (random.nextInt(100) + 1);
        Priority priority = Priority.values()[random.nextInt(Priority.values().length)];
        int dueDate = random.nextInt(6) + 5;
        return new Task(text, priority, dueDate);
    }
}
