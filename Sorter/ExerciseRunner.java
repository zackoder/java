import java.util.Arrays;

public class ExerciseRunner {

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        java.util.function.BiConsumer<String, Boolean> check = (name, result) -> {
            if (result) {
                System.out.println(name + " ✅ Passed");
            } else {
                System.out.println(name + " ❌ Failed");
            }
        };

        // ---- Tests ----

        // Test getter and setter
        Sorter sorter = new BubbleSort();
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };
        sorter.setArray(array);
        check.accept("getterAndSetter_shouldReturnCorrectValues",
                Arrays.equals(sorter.getArray(), array));

        // Test BubbleSort
        sorter = new BubbleSort();
        sorter.setArray(array.clone());
        sorter.sort();
        check.accept("bubbleSort_shouldSortArrayCorrectly",
                Arrays.equals(sorter.getArray(), new int[] { 11, 12, 22, 25, 34, 64, 90 }));

        // Test InsertionSort
        sorter = new InsertionSort();
        sorter.setArray(array.clone());
        sorter.sort();
        check.accept("insertionSort_shouldSortArrayCorrectly",
                Arrays.equals(sorter.getArray(), new int[] { 11, 12, 22, 25, 34, 64, 90 }));

        // ---- Performance Test ----
        int[] randomArray = new int[1000];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * 1000);
        }
        int[] sortedArray = randomArray.clone();
        Arrays.sort(sortedArray);

        int[] reverseSortedArray = sortedArray.clone();
        for (int i = 0; i < reverseSortedArray.length / 2; i++) {
            int temp = reverseSortedArray[i];
            reverseSortedArray[i] = reverseSortedArray[reverseSortedArray.length - 1 - i];
            reverseSortedArray[reverseSortedArray.length - 1 - i] = temp;
        }

        // Test BubbleSort on random array
        BubbleSort bubbleSorter = new BubbleSort();
        bubbleSorter.setArray(randomArray.clone());
        long startTime = System.nanoTime();
        bubbleSorter.sort();
        long bubbleSortRandomTime = System.nanoTime() - startTime;

        // Test InsertionSort on random array
        InsertionSort insertionSorter = new InsertionSort();
        insertionSorter.setArray(randomArray.clone());
        startTime = System.nanoTime();
        insertionSorter.sort();
        long insertionSortRandomTime = System.nanoTime() - startTime;

        // Test BubbleSort on sorted array
        bubbleSorter.setArray(sortedArray.clone());
        startTime = System.nanoTime();
        bubbleSorter.sort();
        long bubbleSortSortedTime = System.nanoTime() - startTime;

        // Test InsertionSort on sorted array
        insertionSorter.setArray(sortedArray.clone());
        startTime = System.nanoTime();
        insertionSorter.sort();
        long insertionSortSortedTime = System.nanoTime() - startTime;

        // Test BubbleSort on reverse sorted array
        bubbleSorter.setArray(reverseSortedArray.clone());
        startTime = System.nanoTime();
        bubbleSorter.sort();
        long bubbleSortReverseSortedTime = System.nanoTime() - startTime;

        // Test InsertionSort on reverse sorted array
        insertionSorter.setArray(reverseSortedArray.clone());
        startTime = System.nanoTime();
        insertionSorter.sort();
        long insertionSortReverseSortedTime = System.nanoTime() - startTime;

        // Check arrays are sorted correctly
        check.accept("bubbleSortArrayIsSorted", isSorted(bubbleSorter.getArray()));
        check.accept("insertionSortArrayIsSorted", isSorted(insertionSorter.getArray()));

        // Optional performance checks
        check.accept("insertionSortRandomFasterThanBubble",
                insertionSortRandomTime < bubbleSortRandomTime);
        check.accept("insertionSortSortedFasterThanBubble",
                insertionSortSortedTime < bubbleSortSortedTime);
        check.accept("bubbleSortReverseFasterThanInsertion",
                bubbleSortReverseSortedTime < insertionSortReverseSortedTime);

        // Print timings
        System.out.println("\n--- Timings (ns) ---");
        System.out.println("BubbleSort random: " + bubbleSortRandomTime);
        System.out.println("InsertionSort random: " + insertionSortRandomTime);
        System.out.println("BubbleSort sorted: " + bubbleSortSortedTime);
        System.out.println("InsertionSort sorted: " + insertionSortSortedTime);
        System.out.println("BubbleSort reverse: " + bubbleSortReverseSortedTime);
        System.out.println("InsertionSort reverse: " + insertionSortReverseSortedTime);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
