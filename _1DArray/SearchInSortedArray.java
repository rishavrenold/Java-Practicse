package _1DArray;

public class SearchInSortedArray {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end=matrix[0].length-1;
        // System.out.println(start+ " "+ end);
        while(start<matrix.length && end>=0)
        {
            if(matrix[start][end]==target)
            {
                return true;
            }
            if(matrix[start][end]<target)
            {
                start=start+1;
            }
            else
            {
                end=end-1;
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        int matrix[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=3;
        System.out.println(searchMatrix(matrix, target));
    }
}
