import java.lang.reflect.Array;
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

//        int arr[] = new int[6];
//        System.out.println("Enter the array element");
//        for(int i=0;i<6;i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("enter kth max and kth min choice");
//        int max = sc.nextInt();
//        int min = sc.nextInt();
//        Arrays.sort(arr);
//        if(max > 6 || max < 0 || min > 6 || min < 0){
//            System.out.println("Enter Valid Choice");
//        }else{
//         System.out.println("the " + max + "th maximum number is" + arr[6-max]);
//         System.out.println("the " + min + "th minimum number is" + arr[min]);
//        }

//     4 given an array of only 0 ,1 and 2 sort an array without using any sorting algo.
//            int start=0,mid=0,end=7;
//            System.out.println("enter the array element only in 0 1 and 2");
//            int[] arr = new int[8];
//            int[] arr2 = new int[8];
//            int[] temp = new int[8];
//            for(int i=0;i<8;i++){
//                arr[i] = sc.nextInt();
//            }
//            for(int i=0;i<8;i++){
//                if(arr[i]==0){
//                    arr2[start]=arr[i];
//                    start++;
//                }else if(arr[i]==2){
//                  arr2[end]=arr[i];
//                  end--;
//                }else if(arr[i]==1){
//                    temp[mid]=arr[i];
//                    mid++;
//                }else{
//                    System.out.println("Please Enter Only 0 1 and 2");
//                    break;
//                }
//            }
//        for(int i=0;i<8;i++){
//            if(temp[i]==1){
//                arr2[start]=temp[i];
//                start++;
//            }else{
//                continue;
//            }
//        }
//        for(int i=0;i<8;i++){
//            System.out.println(arr2[i]);
//        }



//     5 move all the nagetive array elements to one side of array
//        int[] arr = new int[8];
//        int[] arr2 = new int[8];
//        int start = 0 , end=7;
//        System.out.println("Enter the Array element");
//        for(int i=0;i<8;i++){
//            arr[i] = sc.nextInt();
//        }
//        for(int i=0;i<8;i++){
//            if(arr[i]<0){
//              arr2[start] = arr[i];
//              start++;
//            }else{
//               arr2[end] = arr[i];
//               end--;
//            }
//        }
//        for(int i=0;i<8;i++){
//            System.out.println(arr2[i]);
//        }



//    6 union and intersect of two sorted arrays
//         System.out.println("Enter the size of arr1");
//         int x = sc.nextInt();
//         System.out.println("Enter the array element:");
//         int[] arr1 = new int[x];
//         for(int i=0;i<x;i++){
//             arr1[i] = sc.nextInt();
//         }
//         System.out.println("Enter the size of arr2");
//         int y = sc.nextInt();
//        System.out.println("Enter the array element:");
//        int[] arr2 = new int[y];
//        for(int i=0;i<y;i++){
//            arr2[i] = sc.nextInt();
//        }
//         for union   1 2 3  5 6
//                       2 4 5
//    7 write a programme Cycle rotate an array
//            int[] arr = new int[5];
//            System.out.println("Enter the Array element:");
//            for(int i=0;i<5;i++){
//                arr[i]=sc.nextInt();
//            }
//            int temp = arr[arr.length-1];
//            for(int i=arr.length-1;i>0;i--){
//                arr[i] = arr[i-1];
//            }
//            arr[0] = temp;
//            for(int i=0;i<arr.length;i++)
//            {
//                System.out.println(arr[i]);
//            }


//      8  write a programme to find duplicate array element:
//        System.out.println("Enter the size of an array:");
//        int sizeofArr = sc.nextInt();
//        int[] a = new int[sizeofArr];
//        System.out.println("Enter the array element:");
//        for(int i=0;i<sizeofArr;i++){
//            a[i] = sc.nextInt();
//        }
//        for(int i=0;i<a.length;i++){
//            for(int j=1;j<a.length;j++){
//                if(i==j){
//                    break;
//                }
//               else if(a[i] == a[j]){
//                    System.out.println(a[i] + " is repeated");
//                }else{
//
//                }
//            }
//        }


//    14 merge interval
//          System.out.println("Enter Any five Interval");
//            int[] a = new int[5];
//            int[] b = new int[5];
//          for(int i=0;i<5;i++){
//             System.out.println("from:");
//             a[i] = sc.nextInt();
//             System.out.println("to:");
//             b[i] = sc.nextInt();
//          }
//          for(int i=0;i<5;i++){
//
//                  System.out.println("[" + a[i] + " " + b[i] + "]");
//
//          }
//          System.out.println("the result is:");
//          for(int i=0;i<a.length;i++){
//              for(int j=0;j<5;j++){
//              if(i==j){
//                  continue;
//              } else if (b[i] > a[j] && b[j] > b[i]) {
//                   System.out.println( "[" + a[i] + " " + b[i] + "] is merged with [" + a[j] + " " + b[j] +  "] => [" + a[i] + " " + b[j] + "]");
//              }else{
//
//              }
//              }
//          }

//    16  inversion count

//        System.out.println("Enter the array size:");
//        int x = sc.nextInt();
//        System.out.println("Enter the array element:");
//        int[] arr = new int[x];
//        for(int i=0;i<x;i++){
//          arr[i] = sc.nextInt();
//        }
//
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]>arr[j]){
//                  System.out.println("(" + arr[i] + "," + arr[j] + ")" );
//                }else{
//
//                }
//            }
//        }


//   17 best time to buy and sell stock
//        System.out.println("Enter the no of days you want to calculate profit on it");
//        int days = sc.nextInt();
//        int[] arr = new int[days];
//        System.out.println("Enter the stock price as day by day");
//        for(int i=0;i<arr.length;i++){
//            arr[i]=sc.nextInt();
//        }
//        int max=0;
//        int buyDay=0,sellDay=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++){
//                if(i==j || i > j){
//                   continue;
//                }else if(arr[i]<arr[j] && (max < (arr[j] - arr[i]))){
//                    max = arr[j] - arr[i];
//                    buyDay=i;
//                    sellDay=j;
//                }else{
//
//                }
//            }
//        }
//        System.out.println("the best day to buy stock is " + (buyDay+1) + " and to sell is " + (sellDay+1) + " profit is " + max);


//   18 find all page on integer array whose sum is equal to the given number:
//        int count = 0;
//          System.out.println("Enter the array size");
//          int x = sc.nextInt();
//          int[] a = new int[x];
//          System.out.println("Enter the Array Element:");
//          for (int i=0;i<x;i++){
//            a[i] = sc.nextInt();
//          }
//          System.out.println("Enter the expected sum you want to find");
//          int eSum = sc.nextInt();
//          for (int i=0;i<a.length;i++){
//              for(int j=i;j<a.length;j++){
//                  if(i==j){
//                      continue;
//                  }else if(a[i] + a[j] == eSum){
//                       count++;
//                       System.out.println(a[i] + "+" + a[j] + " = " + (a[i] + a[j]));
//                  }
//              }
//          }
//          System.out.println("total results " + count);

//   19  find comment element in given three Array

         System.out.println("Enter the size of an array:");
         int x = sc.nextInt();
         System.out.println("Enter the array element:");
         int[] arr1 = new int[x];
         for(int i=0;i<x;i++){
             arr1[i] = sc.nextInt();
         }

         System.out.println("Enter the size of an array:");
         int y = sc.nextInt();
         System.out.println("Enter the array element:");
         int[] arr2 = new int[y];
         for(int i=0;i<y;i++){
             arr2[i] = sc.nextInt();
         }

         System.out.println("Enter the size of an array:");
         int z = sc.nextInt();
         System.out.println("Enter the array element:");
         int[] arr3 = new int[z];
         for(int i=0;i<z;i++){
             arr3[i] = sc.nextInt();
         }

         Arrays.sort(arr1);
         Arrays.sort(arr2);
         Arrays.sort(arr3);

//         for(int i=0;i<arr1.length;i++){
//              for(int j=0;j<arr2.length;j++){
//                   for(int k=0;k<arr3.length;k++){
//
//                   }
//              }
//         }








//         for(int i=0;i<arr1.length;i++){
//             System.out.println(arr1[i]);
//         } for(int i=0;i<arr2.length;i++){
//             System.out.println(arr2[i]);
//         } for(int i=0;i<arr3.length;i++){
//             System.out.println(arr3[i]);
//         }









//   25 given an array of size n and a number k , find all elements that appear more than n/k times.
//           System.out.println("Enter the size of array");
//           int x = sc.nextInt();
//           System.out.println("Enter the array element:");
//           int[] arr = new int[x];
//           for(int i=0;i<x;i++){
//             arr[i] = sc.nextInt();
//           }
//           System.out.println("Enter the size of k");
//           int k = sc.nextInt();
//           int count=1;
//           for(int i=0;i<arr.length;i++){
//               for(int j=i;j<arr.length;j++){
//                if(i==j){
//                    continue;
//                }else if(arr[i]==arr[j]){
//                    count++;
//                    if(count>(x/k)){
//                        System.out.println(arr[j] + " is repeated  more than " +  count +" times " + (x/k));
//                        count=1;
//                    }
//                }else{
//
//                }
//               }
//
//           }

//   29 trapping rain water probLame
//        System.out.println("Enter the length of an array");
//        int x = sc.nextInt();
//        int[] arr = new int[x];
//        System.out.println("Enter the array element:");
//        for(int i=0;i<x;i++){
//            arr[i] = sc.nextInt();
//        }
//        int sum=0;
//        int start=arr[0];
//        for(int i=1;i<arr.length;i++){
//
//              if(arr[i]<start){
//                  sum=sum+(start-arr[i]);
//              }
//
//        }
//     System.out.println(sum);

//    34 minimum no of oparation required to make an array palindrome







//
//    exam practice code
//         *
//        ***
//       *****
//      *******

//        int n=7/2;
//        int m=7/2;
//        for(int i=0;i<4;i++){
//            for(int j=0;j<7;j++){
//                if(j>=n && j<m+1){
//                    System.out.print("*");
//
//                }else{
//                    System.out.print(" ");
//                }
//
//            }
//            System.out.println("");
//            n--;
//            m++;
//        }
//      *
//      ***
//      *****
//      *******
//        int x=0;
//       for(int i=0;i<4;i++){
//           for(int j=0;j<7;j++){
//              if(x>=j){
//                  System.out.print("*");
//              }else{
//                  System.out.print(" ");
//              }
//           }
//           x+=2;
//           System.out.println("");
//       }




//        multiplication of an metrics array
//        int[][] a1 = new int[3][3];
//        int[][] a2 = new int[3][3];
//        int [][] a3 = new int[3][3];
//        System.out.println("Enter the array 1 element:");
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//            System.out.println("Enter A"+ (i+1) + (j+1) + " ");
//            a1[i][j] = sc.nextInt();
//            }
//        } System.out.println("Enter the array 2 element:");
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//            System.out.println("Enter A"+ (i+1) + (j+1) + " ");
//            a2[i][j] = sc.nextInt();
//            }
//        }
//
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(a1[i][j]+ " ");
//            }
//            System.out.println("");
//        } for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(a2[i][j]+ " ");
//            }
//            System.out.println("");
//            System.out.println("");
//            System.out.println("");
//            System.out.println("");
//        }

//      1 2 3  4 5 6   13 15 11
//      4 5 6  3 2 1   37 42 35
//      7 8 9  1 2 1   61 69 59

//        int sum = 0;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                for(int k=0;k<3;k++){
//                    sum = sum + (a1[i][k] * a2[k][j]);
//                }
//                a3[i][j] = sum;
//                sum=0;
//            }
//        }
//
//
//
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(a3[i][j]+ " ");
//            }
//            System.out.println("");
//        }



//    find if there is any subArray with sum equal 0
//       4 2 -3 1 6
//      -3 1  2 4 6
//        1 3 3 -6 10 20
//        -6 1 3 3 10 20



}

}