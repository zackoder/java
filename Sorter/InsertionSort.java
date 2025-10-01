import java.util.Arrays;

public class InsertionSort extends Sorter {
    @Override
    public void sort() {
        int[] arr = getArray();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
        setArray(arr);
    }
}