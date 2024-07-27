package BinarySearch;
import java.io.*;
import java.util.*;

public class BitonicArraySearch {

    public static boolean check(int arr[], int i){
        if(arr[i] > arr[i - 1]) return true;
        else return false;
    }

    public static void solve(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        String[] arrInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        int lo = 1;
        int hi = n - 1;
        int peak = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(arr, mid)) {
                peak = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        while (q-- > 0) {
            int k = Integer.parseInt(br.readLine());

            List<Integer> finalPositions = new ArrayList<>();
            lo = 0;
            hi = peak - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == k) {
                    finalPositions.add(mid + 1);
                    break;
                } else if (arr[mid] > k) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            lo = peak;
            hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == k) {
                    finalPositions.add(mid + 1);
                    break;
                } else if (arr[mid] > k) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (finalPositions.isEmpty()) {
                System.out.println(-1);
            } else {
                for (int pos : finalPositions) {
                    System.out.print(pos + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }
}
