import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
 class armstrong {
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter any Number");
         String s1 = sc.nextLine();
         String[] x = s1.split("");

         int sum=0;

         for(int i=0;i<x.length;i++){
          sum = sum +  (Integer.parseInt(x[i]) * Integer.parseInt(x[i]) * Integer.parseInt(x[i]));
         }

         if(sum== Integer.parseInt(s1)){
             System.out.println("this number is armstrong");
         }else {
             System.out.println("this number is not armstrong");
         }
     }
}
