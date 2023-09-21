public class HeapSort {

    public static void heapify(int arr[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int t = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = t;
            heapify(arr, maxIdx, n);
        }
    }

    public static void heapsort(int arr[]) {
        int n = arr.length;

       
        for (int i = n / 2 ; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapsort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
