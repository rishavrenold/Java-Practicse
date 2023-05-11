package _1DArray;

import java.util.Scanner;

public class ArraySpiralTraversal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int arr[][]=new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        int minRow=0;
        int minCol=0;
        int maxRow=arr.length-1;
        int maxCol=arr[0].length-1;
        int totalele=row*col;
        int count=0;

        while(count<totalele)
        {        
        for(int i=minCol;i<=maxCol && count<totalele;i++)
        {
            System.out.print(arr[minRow][i]+" ");
            count++;
        }
        System.out.println();
        
        minRow+=1;
        System.out.println("Min Row ="+ minRow);
        for(int i=minRow;i<=maxRow && count<totalele;i++)
        {
            System.out.print(arr[i][maxCol]+" ");
            count++;
        }
        System.out.println();
        maxCol-=1;
        System.out.println("Max Col ="+ maxCol);
        for(int i=maxCol;i>=minCol && count<totalele;i--)
        {
            System.out.print(arr[maxRow][i]+" ");
            count++;
        }
        System.out.println();
        maxRow-=1;
        System.out.println("Max Row ="+ maxRow);
        for(int i=maxRow;i>=minRow && count<totalele;i--)
        {
            System.out.print(arr[i][minCol]+" ");
            count++;
        }
        System.out.println();
        minCol+=1;
        System.out.println("Min Col ="+ minCol);

        }
        
    }
    
}
