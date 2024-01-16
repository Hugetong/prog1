public class TaskListElement {
    public Task task;
    public TaskListElement newE;

    public TaskListElement(Task task) {
        this.task = task;
        this.newE = null;
    }

    public Object getTask() {
        return task;
    }

    public TaskListElement getNext() {
        return newE;
    }
}