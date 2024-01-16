public class PriorityTaskList {
    private TaskListElement taskList;

    public void addTask(Task task) {
        TaskListElement newTask = new TaskListElement(task);

        if (taskList == null || task.getDueDate() < taskList.task.getDueDate()) {
            newTask.newE = taskList;
            taskList = newTask;
        }
        else {
            TaskListElement current = taskList;

            while (current.newE != null && current.newE.task.getDueDate() < task.getDueDate()) {
                current = current.newE;
            }
            newTask.newE = current.newE;
            current.newE = newTask;
        }
    }
    public Task getNextTask() {
        if (taskList == null) {
            return null;
        }
        else {
            Task nextTask = taskList.task;
            taskList = taskList.newE;
            return nextTask;
        }
    }
    public Task getNextTask(Task.Priority priority) {
        TaskListElement current = taskList;
        TaskListElement previous = null;

        while (current != null) {
            if (current.task.getPriority() == priority) {
                if (previous == null) {
                    taskList = current.newE;
                }
                else {
                    previous.newE = current.newE;
                }
                return current.task;
            }
            previous = current;
            current = current.newE;
        }
        return null;
    }
    public void nextDay() {
        if (taskList == null) {
            return;
        }

        TaskListElement current = taskList;
        TaskListElement previous = null;

        while (current != null) {
            Task.Priority oldPriority = current.task.getPriority();
            current.task.reduceDueDate();
            if (oldPriority != current.task.getPriority()) {
                if (previous == null) {
                    taskList = current.newE;
                }
                else {
                    previous.newE = current.newE;
                }
                addTask(current.task);
                current = previous == null ? taskList : previous.newE;
                }
                else {
                previous = current;
                current = current.newE;
            }
        }
    }

    public TaskListElement getHead() {
        return taskList;
    }

}