import java.util.Scanner;

public class temp {
    public static void main(String args[]){

      Scanner sc = new Scanner(System.in);

//    1
       int j=0;
       System.out.println("Enter the Input Line");
       int n = sc.nextInt();
       int[] arr = {100 , 90 , 80 , 70 , 60 };
        for(int i=0;i<n;i++){
            while(j<n && arr[i] < arr[j]){
                j++;
                System.out.println(j);
            }
        }
    }
}
