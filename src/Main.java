import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

//    -------------------------------------------
//    1 Reverse The Array;
//    int[] arr = new int[8];
//    System.out.println("enter the Array elements : ");
//    for(int i=0;i<8;i++){
//        arr[i] = sc.nextInt();
//    }
//    int x=0 , y=7,  mid=8/2 , temp;
//    while(x<mid || y>mid){
//     temp=arr[x];
//     arr[x]=arr[y];
//     arr[y]=temp;
//     x++;
//     y--;
//    }
//    for(int i=0;i<8;i++){
//        System.out.println(arr[i]);
//    }


//    ------------------------------------
//    2 Find The Maximum and Minimum In The Array

//        int[] arr = new int[5];
//        System.out.println("Enter the Array  element: ");
//        for(int i=0;i<5;i++){
//          arr[i] = sc.nextInt();
//        }
//        int min=arr[0] , max=arr[0];
//        for(int i=1;i<5;i++){
//
//            if(min>arr[i]){
//                min=arr[i];
//                continue;
//            }
//            if(max<arr[i]){
//                max=arr[i];
//                continue;
//            }
//        }
//        System.out.println("min is " + min +  "  max is"+ + max);


//     ----------------------------------------------------
//     3 Find the Kth minimum And Kth maximum element in Array

        int arr[] = new int[6];
        System.out.println("Enter the array element");
        for(int i=0;i<6;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter kth max and kth min choice");
        int max = sc.nextInt();
        int min = sc.nextInt();
        Arrays.sort(arr);
        if(max > 6 || max < 0 || min > 6 || min < 0){
            System.out.println("Enter Valid Choice");
        }else{
         System.out.println("the " + max + "th maximum number is" + arr[6-max]);
         System.out.println("the " + min + "th minimum number is" + arr[min]);
        }


    }
}