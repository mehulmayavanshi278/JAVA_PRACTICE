import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class pq {


    int leastInterval(char[] c1 , int k){
        int count=0;

        int start=0;
        int end=0;


        Set<Integer> hashset = new HashSet<>();

        for(int i=0;i< c1.length;i++){
            int x=k;
            Set<Character> charset = new HashSet<>();
            for(int j=i;j<c1.length && x!=0;j++){
                 if(charset.add(c1[j])){
                     if(hashset.add(j)){
                          count++;
                          x--;
                     }
                }

            }
            if(x!=-1){
                count+=x+1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        pq p1  =  new pq();
//        621. Task Scheduler

        char[] c1 = {'A','A','A','B','B','B'};
        int k=3;
        int res = p1.leastInterval(c1,k);
        System.out.println(res);







    }


}
