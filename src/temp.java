import java.util.Scanner;

public class temp {

    public static void printArray(Boolean[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public  static void FillFalse(Boolean[] a){
        for(int i=0;i<a.length;i++){
            a[i]=false;
        }
    }
    public static int CheckHowManyDoorOpen(Boolean[] a){
        for(int i=1;i<=100;i++){
           for(int j=100;j>=1;j--){
               if(j%i==0 && i<=j){
                   if(a[j-1]==true){
                       a[j-1]=false;
                   }else{
                       a[j-1]=true;
                   }
               }
           }
        }
        int result2=0;
        for(int i=0;i< a.length;i++){
            if(a[i]==true){
                result2++;
            }
        }
        return result2;
    }
    public static void main(String args[]){

      Scanner sc = new Scanner(System.in);

//       1
          Boolean[] doors = new Boolean[100];
          FillFalse(doors);
          printArray(doors);
          int result = CheckHowManyDoorOpen(doors);
          System.out.println(result);

    }
}
