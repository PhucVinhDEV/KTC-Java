import java.util.List;

public class QuickSort {
    public void sortArray(int[] nums,int left,int right) {

        if (left < right) {
            int pivot = partition(nums, left, right);
            sortArray(nums, left, pivot - 1);
            sortArray(nums, pivot + 1, right);
        }
    }
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Hoán đổi arr[i + 1] và arr[high] (hoặc pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }
    public static void main(String[] args) {

    }
}
