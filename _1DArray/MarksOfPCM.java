package _1DArray;

import java.util.Arrays;
import java.util.Comparator;

public class MarksOfPCM {

   static class Student implements Comparable<Student>{
        int phy;
        int chem;
        int math;
        
        Student()
        {
            
        }
        Student(int phy,int chem,int math)
        {
            this.phy=phy;
            this.chem=chem;
            this.math=math;
        }
        @Override
        public int compareTo(Student o) {
                   if (this.phy - o.phy == 0) {
                if (this.chem - o.chem == 0) {
                    return this.math - o.math;
                } else {
                    return o.chem - this.chem;
                }
            } else {
                return this.phy - o.phy;
            }
        }
    }       

    //   static class StudentComparator implements Comparator<Student> {
    //     @Override
    //     public int compare(Student o1, Student o2) {
    //         if (o1.phy - o2.phy == 0) {
    //             if (o1.chem - o2.chem == 0) {
    //                 return o1.math - o2.math;
    //             } else {
    //                 return o2.chem - o1.chem;
    //             }
    //         } else {
    //             return o1.phy - o2.phy;
    //         }
    //     }
    // }  
    public static void customSort(int phy[], int chem[], int math[], int N) {
        Student[] stu = new Student[N];
        for (int i = 0; i < N; i++) {
            stu[i] = new Student(phy[i], chem[i], math[i]);
        }

        Arrays.sort(stu);
        for(int i=0;i<N;i++)
        {
            phy[i]=stu[i].phy;
            chem[i]=stu[i].chem;
            math[i]=stu[i].math;
        }
    }
    public static void main(String[] args) {
       int N = 10;
       int  phy[] = {4 ,1, 10, 4, 4, 4, 1, 10, 1, 10};
       int  chem[] = {5 ,2 ,9 ,6 ,3 ,10 ,2 ,9 ,14 ,10};
       int  math[] = {12 ,3, 6, 5, 2, 10, 16, 32, 10, 4};
       customSort(phy,chem,math,N);
       for(int i=0;i<N;i++)
       {
            System.out.println("Physics"+phy[i]+" "+"Chemisty"+chem[i]+" "+"Math"+math[i]+" ");
       }
    }
}


