import java.util.Scanner;

public class Metrics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);



//        1 spiral traversal on metrics
//            System.out.println("Enter the rows of metrics");
//            int x = sc.nextInt();
//            System.out.println("Enter the column of metrics");
//            int y = sc.nextInt();
//            int[][] a = new int[x][y];
//            System.out.println("Enter The Array Element:");
//            for(int i=0;i<x;i++){
//                for(int j=0;j<y;j++){
//                    a[i][j] = sc.nextInt();
//                }
//            }
//
//            for(int i=0;i<x;i++){
//                for(int j=0;j<y;j++){
//                    System.out.print(a[i][j] + " ");
//                }
//                System.out.println("");
//            }
//            int i=0,j=0;
//            boolean up=false , right = true , down = false  ,left = false;
//            int u= -1 , r = y , d = x , l = -1;
//
//            for(int m=0;m<x*y;m++){
//                if(right){
//                    System.out.print(a[i][j] + " ");
//                    j++;
//                    if(j==r){
//                        j--;
//                        i++;
//                        right=false;
//                        down=true;
//                        left=false;
//                        up=false;
//                        u++;
//                        continue;
//                    }
//                }else if(down){
//                    System.out.print(a[i][j] + " ");
//                    i++;
//                    if(i==d){
//                        i--;
//                        j--;
//                        r--;
//                        left=true;
//                        down=false;
//                        right=false;
//                        up=false;
//                        continue;
//                    }
//                }else if(left){
//                    System.out.print(a[i][j] + " ");
//                    j--;
//                    if(j==l){
//                        j++;
//                        i--;
//                        d--;
//                        up=true;
//                        right=false;
//                        down=false;
//                        left=false;
//                        continue;
//                    }
//                }else if(up){
//                    System.out.print(a[i][j] + " ");
//                    i--;
//                    if(i==u){
//                        i++;
//                        j++;
//                        l++;
//                        left=false;
//                        up=false;
//                        down=false;
//                        right=true;
//                        continue;
//                    }
//                }
//            }

//      2 search in element in metrics



//           System.out.println("Enter the size of rows");
//           int x = sc.nextInt();
//           System.out.println("Enter the size of column");
//           int y = sc.nextInt();
//
//           int[][] arr = new int[x][y];
//           System.out.println("Enter the array element in Ascending order:");
//           for (int i = 0; i < x; i++) {
//               for (int j = 0; j < y; j++) {
//                   arr[i][j] = sc.nextInt();
//               }
//           }
//
//           for (int i = 0; i < x; i++) {
//               for (int j = 0; j < y; j++) {
//                   System.out.print(arr[i][j] + " ");
//               }
//               System.out.println("");
//           }
//
//        while(true) {
//           System.out.print("Enter the element you want to search:");
//           int search = sc.nextInt();
//           int r = 0, c = 0;
//           for (int i = 1; i < x; i++) {
//               if (search < arr[i][0]) {
////               System.out.println(i-1);
//                   r = i - 1;
//                   break;
//               } else if (i == x - 1 && search <= arr[i][y - 1]) {
////               System.out.println(i);
//                   r = i;
//
//               } else {
//
//               }
//           }
//           for (int j = 0; j < y; j++) {
//               if (search == arr[r][j]) {
//                   System.out.println("Element is founded at index " + "arr[" + r+"][" + j + "] ");
//                   break;
//               } else if (j == y - 1) {
//                   System.out.println("Element is not present");
//                   break;
//               }
//           }
//
//       }



//        3   find the median of a metric which in rows wise sorted

                     System.out.println("Enter the rows of metrics");
             int x = sc.nextInt();
             System.out.println("Enter the size of column");
             int y= sc.nextInt();
             int[][] a = new int[x][y];
             System.out.println("Enter the row wise sorted element");
             for(int i=0;i<x;i++){
                 for(int j=0;j<y;j++){
                     a[i][j] = sc.nextInt();
                 }
             }







//        8   Rotate metrics by 90 degree
//             System.out.println("Enter the rows of metrics");
//             int x = sc.nextInt();
//             System.out.println("Enter the size of column");
//             int y= sc.nextInt();
//             int[][] a = new int[x][y];
//             System.out.println("Enter the array element");
//             for(int i=0;i<x;i++){
//                 for(int j=0;j<y;j++){
//                     a[i][j] = sc.nextInt();
//                 }
//             }
//        for (int i = 0; i < x; i++) {
//               for (int j = 0; j < y; j++) {
//                   System.out.print(a[i][j] + " ");
//               }
//               System.out.println("");
//           }
//        System.out.println("");
//             for(int i=0;i<y;i++){
//                 for(int j=x-1;j>=0;j--){
//                     System.out.print(a[j][i] + " ");
//                 }
//                 System.out.println("");
//             }



    }
}
