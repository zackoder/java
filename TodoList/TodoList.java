enum TaskStatus {
    NEW, IN_PROGRESS, COMPLETED
}

class Task {
    private String description;
    private TaskStatus status;

    public Task(String tast) {
        this.description = tast;
        this.status = TaskStatus.NEW;
    }

    public Task() {}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus taskStatus) {
        this.status = taskStatus;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public String getDescription() {
        return this.description;
    }
}

public class TodoList {
    private Task[] tasks;
    private int capacity;
    private int count;

    public TodoList(int capacity) {
        this.capacity = capacity;
        Task[] taks = new Task[capacity];
        this.tasks = taks;
    }

    public void addTask(String description) {
        if (this.count != this.capacity) {
            this.tasks[count] = new Task(description);
            this.count++;
        }
    }

    public void setStatus(int index, TaskStatus status) {
        if (index > 0 && index < this.capacity)
            this.tasks[index].setStatus(status);
    }

    public void setDescription(int index, String newDescription) {
        if (index > 0 && index < this.capacity)
            this.tasks[index].setDescription(newDescription);
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < this.count; i++) {
            System.out.printf("%-33s |%s\n", this.tasks[i].getDescription(), this.tasks[i].getStatus());
        }
    }

}