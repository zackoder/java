public class ExerciseRunner {

    public static void main(String[] args) {
        TodoList myList = new TodoList(3); // List can hold up to 3 tasks
        myList.addTask("Go grocery shopping");
        myList.addTask("Pay electricity bill");
        myList.setStatus(0, TaskStatus.COMPLETED); // Mark the first task as completed
        myList.setDescription(1, "Pay all utility bills"); // Update the description of the second task
        myList.displayTasks(); // Display the list of tasks
    }

    // public static void main(String[] args) {
    // TodoList todoList = new TodoList(3);
    // todoList.addTask("Go grocery shopping");
    // todoList.addTask("Pay electricity bill");
    // Task task = new Task("Test description");

    // int passed = 0;
    // int failed = 0;

    // // Helper for assertions
    // java.util.function.BiConsumer<String, Boolean> check = (name, result) -> {
    // if (result) {
    // System.out.println(name + " ✅ Passed");
    // } else {
    // System.out.println(name + " ❌ Failed");
    // }
    // };

    // // ---- Tests ----
    // // Test getDescription
    // check.accept("testGetDescription", task.getDescription().equals("Test
    // description"));

    // // Test setDescription
    // task.setDescription("New description");
    // check.accept("testSetDescription", task.getDescription().equals("New
    // description"));

    // // Test getStatus
    // check.accept("testGetStatus", task.getStatus() == TaskStatus.NEW);

    // // Test setStatus
    // task.setStatus(TaskStatus.COMPLETED);
    // check.accept("testSetStatus", task.getStatus() == TaskStatus.COMPLETED);

    // // Test private fields in Task
    // try {
    // java.lang.reflect.Field descriptionField =
    // Task.class.getDeclaredField("description");
    // java.lang.reflect.Field statusField = Task.class.getDeclaredField("status");
    // boolean isPrivate =
    // java.lang.reflect.Modifier.isPrivate(descriptionField.getModifiers())
    // && java.lang.reflect.Modifier.isPrivate(statusField.getModifiers());
    // check.accept("testTaskAttributesModifiers", isPrivate);
    // } catch (NoSuchFieldException e) {
    // check.accept("testTaskAttributesModifiers", false);
    // }

    // // Test displayTasks
    // todoList.setStatus(0, TaskStatus.COMPLETED);
    // todoList.setDescription(1, "Pay all utility bills");

    // java.io.ByteArrayOutputStream outContent = new
    // java.io.ByteArrayOutputStream();
    // System.setOut(new java.io.PrintStream(outContent));
    // todoList.displayTasks();
    // String expectedOutput = "Tasks:\n" +
    // "Go grocery shopping | COMPLETED\n" +
    // "Pay all utility bills | NEW\n";
    // check.accept("testDisplayTasks",
    // outContent.toString().equals(expectedOutput));
    // System.setOut(System.out); // reset

    // // Test invalid setStatus
    // todoList.setStatus(5, TaskStatus.COMPLETED);
    // check.accept("testInvalidSetStatus",
    // !todoList.toString().contains("COMPLETED"));

    // // Test invalid setDescription
    // todoList.setDescription(5, "Pay all utility bills");
    // check.accept("testInvalidSetDescription", !todoList.toString().contains("Pay
    // all utility bills"));

    // // Test private fields in TodoList
    // try {
    // java.lang.reflect.Field tasksField =
    // TodoList.class.getDeclaredField("tasks");
    // java.lang.reflect.Field capacityField =
    // TodoList.class.getDeclaredField("capacity");
    // java.lang.reflect.Field countField =
    // TodoList.class.getDeclaredField("count");
    // boolean isPrivate =
    // java.lang.reflect.Modifier.isPrivate(tasksField.getModifiers()) &&
    // java.lang.reflect.Modifier.isPrivate(capacityField.getModifiers()) &&
    // java.lang.reflect.Modifier.isPrivate(countField.getModifiers());
    // check.accept("testTodoListAttributesModifiers", isPrivate);
    // } catch (NoSuchFieldException e) {
    // check.accept("testTodoListAttributesModifiers", false);
    // }

    // // Test adding tasks up to capacity
    // todoList.addTask("Read a book");
    // outContent = new java.io.ByteArrayOutputStream();
    // System.setOut(new java.io.PrintStream(outContent));
    // todoList.displayTasks();
    // expectedOutput = "Tasks:\n" +
    // "Go grocery shopping | COMPLETED\n" +
    // "Pay all utility bills | NEW\n" +
    // "Read a book | NEW\n";
    // check.accept("testAddingTasksUpToCapacity",
    // outContent.toString().equals(expectedOutput));
    // System.setOut(System.out);

    // // Test adding tasks beyond capacity
    // todoList.addTask("Write a report");
    // outContent = new java.io.ByteArrayOutputStream();
    // System.setOut(new java.io.PrintStream(outContent));
    // todoList.displayTasks();
    // expectedOutput = "Tasks:\n" +
    // "Go grocery shopping | COMPLETED\n" +
    // "Pay all utility bills | NEW\n" +
    // "Read a book | NEW\n";
    // check.accept("testAddingTasksBeyondCapacity",
    // outContent.toString().equals(expectedOutput));
    // System.setOut(System.out);
    // }
}