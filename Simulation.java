public class Simulation {
    public static void main(String[] args) {
        PriorityTaskList tasks = new PriorityTaskList();
        for (int i = 0; i < 20; i++) {
            tasks.addTask(Task.generateRandomTask());
        }

        System.out.println("\nList:");
        printList(tasks);

        System.out.println("Removed tasks:");

        for (int i = 0; i < 5; i++) {
            Task taskWeg;
            if (i % 2 == 0) {
                taskWeg = tasks.getNextTask(Task.Priority.URGENT);
            }
            else {
                taskWeg = tasks.getNextTask(Task.Priority.NORMAL);
            }
            System.out.println(taskWeg);
        }

        System.out.println("\nList:");
        printList(tasks);

        for (int i = 0; i < 5; i++) {
            tasks.nextDay();
        }

        System.out.println("\nList:");
        printList(tasks);
    }

    public static void printList(PriorityTaskList tasks) {
        TaskListElement current = tasks.getHead();
        while (current != null) {
            System.out.println(current.getTask().toString());
            current = current.getNext();
        }
        System.out.println();
    }
}
