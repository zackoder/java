public class ExerciseRunner {
    public static void main(String[] args) {
        LinkedList list = new CircularLinkedList();

        list.add(1);
        int val = list.at(3);
        System.out.println(val);
    }
}