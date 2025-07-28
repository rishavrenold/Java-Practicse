package DP;
import java.util.Arrays;

public class MinimumLights {

    public static int minNumberOfLights(int[] arr, int power) {
        int n = arr.length;
        int i = 0; // Current position to illuminate
        int lampsOn = 0; // Number of lamps turned on
        
        while (i < n) {
            int lampPos = -1;
            
            // Search for the farthest lamp that can light up position i
            for (int j = Math.max(0, i - power + 1); j <= Math.min(n - 1, i + power - 1); j++) {
                if (arr[j] == 1) {
                    lampPos = j;
                }
            }
            
            // If no lamp found, it's impossible to light up this section
            if (lampPos == -1) {
                return -1;
            }
            
            // Turn on the lamp at lampPos and move beyond its range
            lampsOn++;
            i = lampPos + power; // Jump to the next section that needs illumination
        }
        
        return lampsOn;
    }

    public static void main(String[] args) {
        int power = 3;
        int arr[] = {0, 0, 1, 1, 1, 0, 0, 1};
        int n = arr.length;

        // // dp[i] will store the minimum number of lights required to cover the first i positions
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, (int) 1e9); // Initialize dp with a large value
        // dp[0] = 0; // No lights needed to cover 0 positions

        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 1) {
        //         int left = Math.max(0, i - power + 1);  // Range that this light can cover
        //         int right = Math.min(n - 1, i + power - 1);

        //         // Update the dp for positions from left to right
        //         for (int j = left; j <= right; j++) {
        //             dp[j + 1] = Math.min(dp[j + 1], dp[left] + 1);
        //         }
        //     }
        // }

        // // The result is the minimum lights needed to cover the last position
        // int result = dp[n];
        // System.out.println(result >= (int) 1e9 ? -1 : result); // If not possible, return -1

        System.out.println(minNumberOfLights(arr, power));
    }
}
