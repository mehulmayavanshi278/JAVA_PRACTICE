import java.util.Scanner;

public class Metrics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);



//        1 spiral traversal on metrics
            System.out.println("Enter the rows of metrics");
            int x = sc.nextInt();
            System.out.println("Enter the column of metrics");
            int y = sc.nextInt();
            int[][] a = new int[x][y];
            System.out.println("Enter The Array Element:");
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    a[i][j] = sc.nextInt();
                }
            }

            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
            int i=0,j=0;
            boolean up=false , right = true , down = false  ,left = false;
            int u= -1 , r = y , d = x , l = -1;

            for(int m=0;m<x*y;m++){
                if(right){
                    System.out.print(a[i][j] + " ");
                    j++;
                    if(j==r){
                        j--;
                        i++;
                        right=false;
                        down=true;
                        left=false;
                        up=false;
                        u++;
                        continue;
                    }
                }else if(down){
                    System.out.print(a[i][j] + " ");
                    i++;
                    if(i==d){
                        i--;
                        j--;
                        r--;
                        left=true;
                        down=false;
                        right=false;
                        up=false;
                        continue;
                    }
                }else if(left){
                    System.out.print(a[i][j] + " ");
                    j--;
                    if(j==l){
                        j++;
                        i--;
                        d--;
                        up=true;
                        right=false;
                        down=false;
                        left=false;
                        continue;
                    }
                }else if(up){
                    System.out.print(a[i][j] + " ");
                    i--;
                    if(i==u){
                        i++;
                        j++;
                        l++;
                        left=false;
                        up=false;
                        down=false;
                        right=true;
                        continue;
                    }
                }
            }





    }
}
