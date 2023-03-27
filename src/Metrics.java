import java.util.Scanner;

public class Metrics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);



//        1 spiral traversal on metrics
            System.out.println("Enter the rows of metrics");
            int x = sc.nextInt();
            System.out.println("Enter the column of metrics");
            int y = sc.nextInt();
            int[][] arr1 = new int[x][y];
            System.out.println("Enter The Array Element:");
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    arr1[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    System.out.print(arr1[i][j] + " ");
                }
                System.out.println("");
            }

            boolean up=false , down=false , left=false;
            boolean right=true;
            int u=0,d=x,l=0,r=y,i=0,j=0;
            int k=-1;




              for(int m=0;m<x*y;m++) {


                  if (right) {
                      System.out.println(" I am moving to the right");
                      k++;
                      System.out.print(arr1[i][j]);

                      j++;
                      System.out.println(" " + i + " " + j + "     " + " k is " + k);
                      if (j == r) {
                          right = false;
                          left = false;
                          up = false;
                          down = true;
                          u++;
                          i++;
                          j--;
                         continue;

                      }
                  }


                 else if (down) {
                      System.out.println(" I am moving to the down");
                      k++;
                      System.out.print(arr1[i][j]);
                      i++;
                      System.out.println(" " + i + " " + j + "     " + " k is " + k);
                      if (i == d) {
                          right = false;
                          left = true;
                          up = false;
                          down = false;
                          r--;
                          j--;
                          i--;
                          continue;

                      }

                  }


                 else if (left) {
                      System.out.println(" I am moving to the left");
                      k++;
                      System.out.print(arr1[i][j]);
                      j--;
                      System.out.println(" " + i + " " + j + "     " + " k is " + k);
                      if (j == l) {
                          right = false;
                          left = false;
                          up = true;
                          down = false;
                          d--;
//                            i--;
                          j++;
                          continue;

                      }

                  }

                 else if (up) {
                      System.out.println(" I am moving to the up");
                      k++;
                      System.out.print(arr1[i][j]);
                      i--;
                      System.out.println(" " + i + " " + j + "     " + " k is " + k);
                      if (i == u) {
                          right = true;
                          left = false;
                          up = false;
                          down = false;
                          l++;
                          continue;

                      }


                  }

              }





    }
}
