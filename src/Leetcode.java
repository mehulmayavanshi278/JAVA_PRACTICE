import com.sun.source.tree.LambdaExpressionTree;
import com.sun.source.tree.WildcardTree;

import java.awt.desktop.ScreenSleepEvent;
import java.beans.PropertyEditorSupport;
import java.nio.file.LinkOption;
import java.sql.Array;
import java.sql.SQLRecoverableException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.LinkedTransferQueue;


class Listnode{
     int data;
     Listnode next;
     Listnode(int data){
         this.data=data;
         this.next=null;
     }

 }

class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp , -1);
        return helper(arr , k,0);
    }
    private int helper(int[] a , int k , int start){
        int len=Math.min(a.length , start);
        if(len>=a.length){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int ans=0,curMax=0;
        int end=Math.min(start+k , a.length);
        for(int i=start;i<end;i++){
            curMax=Math.max(curMax , a[i]);
            ans=Math.max(ans , (i-start+1)*curMax + helper(a,k,i+1));
        }
        return dp[start]=ans;
    }
}

public class Leetcode {

     List<List<Integer>> dpDoubleIntList = new ArrayList<>();







     public static Listnode createListnode(int[] a){
         Listnode head = new Listnode(a[0]);
         Listnode node = head;
         for(int i=1;i<a.length;i++){
             Listnode temp = new Listnode(a[i]);
             node.next=temp;
             node=node.next;
         }

         return head;

     }

     public static void PrintNeighbour2DMetrics(int[][] a){
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + "--->");
                for(int m=i-1;m<=i+1;m++){
                    for(int n=j-1;n<=j+1;n++){
                        if(m>-1 && m<a.length && n>-1 && n<a[i].length){
                            if(m==i && n==j){
                                continue;
                            }
                            System.out.print(a[m][n] + " ");
                        }
                    }
                }
                System.out.println("");
             }
         }
     }

     public  static Listnode reverseListNode(Listnode head){   // 1 2 3 4 5
        Listnode prev = null;
        Listnode curr = head;
        while (curr!=null){
            Listnode nextNode = curr.next;
            curr.next=prev;
            prev=curr;
            curr = nextNode;
        }
        return prev;
     }

     public static void PrintArray(int[] a){
         System.out.print("Array Element is");
       for(int i=0;i<a.length;i++){
           System.out.print( " " + a[i] + " ");
       }
       System.out.println("");
     }public static void PrintStringArray(String[] a){
         System.out.print("Array Element is");
       for(int i=0;i<a.length;i++){
           System.out.print( " " + a[i] + " ");
       }
     }

     public static void PrintDoubleArray(int[][] a){
          for(int i=0;i<a.length;i++){
              for(int j=0;j<a[i].length;j++){
                  System.out.print(a[i][j] + " ");
              }
              System.out.println("");
          }
     }
     public static void PrintDoubleArrayString(String[][] a){
          for(int i=0;i<a.length;i++){

              for(int j=0;j<a[i].length;j++){
                  System.out.print(a[i][j] + " ");
              }
              System.out.println("");
          }
     }

     public static void PrintListnode(Listnode node){
         while (node!=null){
             System.out.println(node.data);
             node=node.next;
         }
     }



    public static void PrintDoublyList(List<List<Integer>> result){
         for(List<Integer> innerList : result){
             for(Integer val : innerList){
                System.out.println(val + " ");
             }
             System.out.println("");
         }
    }
    public static void PrintDoublyListString(List<List<String>> result){
         for(List<String> innerList : result){
             for(String val : innerList){
                System.out.print(val + " ");
             }
             System.out.println("");
         }
    }


    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }


        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }




    public int romanToInt(String s1) {

        HashMap<Character, Integer> MAP = new HashMap<>();

        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
        int result = MAP.get(s1.charAt(s1.length() - 1));
        for (int i = s1.length() - 2; i >= 0; i--) {
            if (MAP.get(s1.charAt(i)) >= MAP.get(s1.charAt(i + 1))) {
                result += MAP.get(s1.charAt(i));
            } else {
                result -= MAP.get(s1.charAt(i));
            }
        }
        return result;
    }



    public boolean checkIsValid(String s1){
        Stack<Character> STACK = new Stack<>();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == '('){
                STACK.push(s1.charAt(i));
            } else if (s1.charAt(i) == '[') {
                STACK.push(s1.charAt(i));
            } else if (s1.charAt(i) == '{') {
                STACK.push(s1.charAt(i));
            }else{
                if(STACK.size()!=0){
                    if (s1.charAt(i) == ')' && STACK.peek() == '(') {
                        STACK.pop();
                    }else if (s1.charAt(i) == '}' && STACK.peek() == '{') {
                        STACK.pop();
                    }else if (s1.charAt(i) == ']' && STACK.peek() == '[') {
                        STACK.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

        }
        // System.out.println(STACK);
        return STACK.size()==0;
    }

//    4 palindrome

    public boolean isPalindrome(int x) {
        boolean isPalindrm = true;
        if(x<0){
           return false;
        }

        for(int i=0;i<(Integer.toString(x).length()/2);i++){
//            System.out.print(Integer.toString(x).charAt(i));
//            System.out.print(( x / ((int) (Math.pow(10, (Integer.toString(x).length()- (i+1)))))) % 10 );
//            System.out.print("  ");
//            System.out.println((x / ((int) (Math.pow(10,i)))) % 10);


            if ( ( x / ((int) (Math.pow(10, (Integer.toString(x).length()- (i+1)))))) % 10 !=  (x / ((int) (Math.pow(10,i)))) % 10){
                isPalindrm=false;
                break;
            }
//            example
//            how to check first letters x/1000%10 x/100%10 x/10%10
//            how to check last letters  x/1%10 x/10%10 x/100%10 x/1000%10
//

        }
        return isPalindrm;
    }

//    public static String longestCommonprefex(String[] s){        // using sorting technique
//        String result="";
//        Arrays.sort(s);
//        int i=0;
//        while(s[0].charAt(i) == s[s.length-1].charAt(i)){
//            result = result+s[s.length-1].charAt(i);
//            i++;
//        }
//        return result;
//    }

    public static String longestCommonprefex(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        System.out.println(minLength);
        // Find the minimum length of the strings in the array
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
            System.out.println(minLength);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);

            // Compare the current character with the same position in other strings
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    return result.toString(); // Found a mismatch, return the common prefix found so far
                }
            }

            // If all characters match, append the character to the result
            result.append(currentChar);
        }

        return result.toString();
    }

//     public  HashMap<Integer , Integer>  getBestProfitableStock(int maxPrice , int[] a , int[] b){
//        HashMap<Integer , Integer> MAP = new HashMap<>();
//        int[] c = new int[a.length];
//          for(int i=0;i<a.length;i++){
//              MAP.put(b[i] - a[i] , a[i]);
//              c[i]=b[i] - a[i];
//          }
//          Arrays.sort(c);
//          System.out.println(MAP);
//
//          for(int i=0;i<c.length;i++){
//              System.out.println(c[i]);
//          }
//          HashMap<Integer , Integer> result = new HashMap<>();
//          int remainingPrice = maxPrice;
//          for(int i=c.length-1;i>=0;i--){
//              int noOfStock=0;
//              if(remainingPrice>0){
//                  noOfStock = remainingPrice/MAP.get(c[i]);
//                  System.out.println("before remainin Price is" + remainingPrice);
//                  remainingPrice = remainingPrice - ((remainingPrice/MAP.get(c[i])) * MAP.get(c[i]));
//                  System.out.println("after remainin Price is" + remainingPrice);
//                  System.out.println("remaining price for" + MAP.get(c[i]) + " is " + remainingPrice);
//                  result.put(MAP.get(c[i]) , noOfStock);
//              }
//          }
//        return result;
//
//    }

     public HashMap<Integer , Integer> getBestProfitableStock(int maxPrice , int[] a , int[] b){
        HashMap<Integer , Integer> MAP = new HashMap<>();
        HashMap<Integer , Integer> result = new HashMap<>();
        int[] c = new int[a.length];
        for(int i=0;i<a.length;i++){
            MAP.put(b[i] - a[i] , a[i]);
            c[i] = b[i] - a[i];
        }
        Arrays.sort(c);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
        int noOfStock = 0;
        int RemainingPrice = maxPrice;
        for(int i=c.length-1;i>=0;i--){
           if(RemainingPrice>0){
               noOfStock = RemainingPrice/MAP.get(c[i]);
               RemainingPrice = RemainingPrice - (RemainingPrice/MAP.get(c[i]) * MAP.get(c[i]));
               result.put(MAP.get(c[i]) , noOfStock);
           }
        }
        return result;
     }

     public boolean CheckValidParanthesis(String s1){  // ({[]}{}]])
        if(s1.length()==0){
            return false;
        }
        Boolean isValid = true;
        Stack<Character> STACK = new Stack<>();
        int CurrIndexOfS1=0;
        while(CurrIndexOfS1<s1.length()){
            Character currentChar = s1.charAt(CurrIndexOfS1);
            if(currentChar == '(' || currentChar == '[' || currentChar == '{'){
                System.out.println("yes");
                STACK.push(currentChar);
                CurrIndexOfS1++;
                System.out.println(CurrIndexOfS1);
//                System.out.println("current character is" + currentChar);
            } else if (currentChar==')' || currentChar==']' || currentChar=='}') {
                System.out.println(CurrIndexOfS1);
                System.out.println("current character is" + currentChar);
                System.out.println("top element is" + STACK.peek());
               if (currentChar==')' && STACK.peek() == '('){
                  STACK.pop();
                  CurrIndexOfS1++;
               } else if (currentChar==']' && STACK.peek() == '['){
                    STACK.pop();
                    CurrIndexOfS1++;
               }else if (currentChar=='}' && STACK.peek() == '{'){
                  STACK.pop();
                  CurrIndexOfS1++;
               }else{
                  System.out.println("not valid");
                  return false;
               }
            }else{
                System.out.println("current character is" + currentChar);
                break;
            }
        }

        if(STACK.isEmpty()){
            return isValid;
        }else{
            return !isValid;
        }

     }

     public int[] mergeTwoSortedArray(int[] a , int[] b){
         int[] result = new int[a.length + b.length];
         int i=0 ,j=0;
         int k=0;
         while(i<a.length && j<b.length){
             if(a[i]==b[j]){
                 result[k]=a[i];
                 result[++k] = a[i];
                 i++;
                 j++;
                 k++;
             } else if (a[i]<b[j]) {
                 result[k] = a[i];
                 i++;
                 k++;
             }else {
                 result[k] = b[j];
                 j++;
                 k++;
             }
         }
         while(i<a.length){
             result[k]=a[i];
             i++;
             k++;
         }
         while(j<b.length){
             result[k]=b[j];
             j++;
             k++;
         }

         return result;
     }
     int removeDuplicateFromSortedArray(int[] a){   // int[] a = {0,0,1,1,1,2,2,3,3,4}
           int result=0;
           int[] temp = new int[a.length];
           System.out.println(temp.length);
           int j=0;
           int k=0;
           int i=0;
           for( i=0;i<a.length-1;i++){
               if(a[i]==a[i+1]){
                   continue;
               }else{
                   temp[k]=a[i];
                   k++;
               }
           }
           temp[k]=a[i];
//         PrintArray(temp);
         result=k+1;
         int []temp2 = new int[result];
         for(int p=0;p<result;p++){
             temp2[p]=temp[p];
         }
           return result;
     }
    public  int[] removeElement(int[] a ,int val){
         int size=0;

         for(int i=0;i<a.length;i++){
             Boolean isElement=false;
             if(a[i]==val){
             isElement=true;
             }
             if(!isElement){
                 a[size]=a[i];
                 size++;
             }

         }
         for(int i=0;i<a.length;i++){
             if(i<size){
                 continue;
             }
             a[i]=0;
         }
         return a;
     }

      int indexofFirstOccurence(String s1 , String s2){
         int result=-1;
         result = s1.indexOf(s2);
         return result;
     }
     int searchInsert(int[] a ,int val){
         int result=a.length;

         for(int i=0;i<a.length;i++){
             if(val>a[i]){
                 continue;
             }
             if(val==a[i] || val<a[i]){
                 return i;
             }
         }
         return result;
     }



//     int findLenghtOfLastWord(String s1){
//         String[] temp = s1.trim().split(" ");
//         int result = temp[temp.length-1].length();
//         return result;
//     }

     int addBinary(int a , int b){
         String result="";
         int k=0;
         int num1=0;
         int num2=0;
         while(a>0){
//             System.out.println(a%10);
             if(a%10==1){
                 num1=num1 + (int) (Math.pow(2,k));
             }
             k++;
             a/=10;
         }
         k=0;
         while (b>0){
//             System.out.println(b%10);
             if(b%10==1){
                 num2=num2 + (int)Math.pow(2,k);
             }
             k++;
             b/=10;
         }

//         System.out.println(num1);
//         System.out.println(num2);
         int temp = num1+num2;
//         System.out.println(temp);

         while(temp>0){
             result=result + temp%2;
             temp=temp/2;
         }

         System.out.println(result);
         StringBuilder stringBuilder = new StringBuilder(result);
         stringBuilder.reverse();
         int mainResult = Integer.parseInt(stringBuilder.toString());


         return mainResult;
     }
       int SQRT(int a){
         int result = (int) Math.sqrt(a);
         return result;
       }

    int climbStairs(int a) {

      if(a==2){
          return 2;
      }
      if(a==1){
          return 1;
      }
      return   climbStairs(a-1) + climbStairs(a-2);

    }

     int medianOfTwoSortedArray(int[] a , int[] b){

         int median = -1;
         int lenA = a.length;
         int lenB = b.length;
         int i=0;
         int j=0;
         int k=0;

         if(lenA+lenB %2==1){
             k=(lenB+lenA)/2;
             while (i+j != k && i<a.length && j<b.length){
                if(a[i] < b[j]){
                    i++;
                    median=a[i];
                }else{
                    j++;
                    median=b[j];
                }
             }
             while (i+j != k && i<a.length ){
                 i++;
                 median=a[i];
             }
             while (i+j != k && i<b.length ){
                 j++;
                 median=a[j];
             }

         }else if(lenA+lenB % 2 ==0){
             k=(lenB+lenA)/2;

         }
         return median;

    }
    int containerWithMostWater(int [] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);
            System.out.println(maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;


    }

    public int[] plusOne(int[] a){
      int[] temp = a;
      int j=temp.length-1;
      int k=a[a.length-1];
      if(k<9){
          temp[temp.length-1] = temp[temp.length-1] + 1;
      }else{
          while(j>-1 && temp[j]==9){
              temp[j]=0;
              j--;
          }
          if(j>-1){
              temp[j] = temp[j] + 1;
          }else{
            int[] newArray  = new int[temp.length+1];
            System.arraycopy(temp , 0 , newArray , 1 , temp.length-1);
            newArray[0]=1;
            PrintArray(newArray);
            temp=newArray;
          }
      }
      return  temp;
    }
    public  Listnode mergeSortedListnode(Listnode node1 , Listnode node2){
         Listnode dummy = new Listnode(-1);
         Listnode current = dummy;
         while (node1!=null && node2!=null){
             if(node1.data<node2.data){
                 current.next=node1;
                 node1=node1.next;
             }else{
                 current.next=node2;
                 node2=node2.next;
             }
             current=current.next;
         }

         while (node1!=null){
             current.next=node1;
             current=current.next;
             node1= node1.next;
         }
         while (node2!=null){
             current.next=node2;
             current=current.next;
             node2=node2.next;
         }
         return dummy.next;
    }
    public Listnode removeDuplicatesFromsortedList(Listnode node){


          Listnode dummy = new Listnode(-1);
          Listnode temp = dummy;
          while (node.next!=null){
              if(node.data!=node.next.data){
                  temp.next=node;
                  temp=temp.next;
              }else{

              }
              node=node.next;
          }
          temp.next=node;
          temp=temp.next;
          temp.next=null;
          return dummy.next;
    }


    public List<List<Integer>> MakePasclesTriangle(int rows){
      List<List<Integer>> result = new ArrayList<>();
      for(int i=0;i<rows;i++){
           result.add(new ArrayList<>());
          for(int j=0;j<i+1;j++){

              if(j==0 || j==i){
                  result.get(i).add(1);
                  continue;
              }
              result.get(i).add(result.get(i-1).get(j-1) + result.get(i-1).get(j));


          }
      }
      return result;
    }

    int findSingleNumber(int[] a){
         if(a.length==1){
             return a[0];
         }
         Arrays.sort(a);
         boolean isDouble=false;
         int number=0;
         for(int i=1;i<a.length;i++){
             if(a[i]==a[i-1]){
                 isDouble=false;
                 continue;
             }
             if(i==a.length-1){
                 number=a[i];
                 break;
             }
             if(isDouble){
                 number=a[i-1];
                 break;
             }
             if(a[i]!=a[i-1]){
                 isDouble=true;
                 number=a[i];
             }
         }
         return number;

    }

    public boolean CheckHappyNumber(int n  , int origional  , List<Integer> list){
        int sum=0;
        while(n>0){
            sum+= n%10==0 ? 0 : (n%10)*(n%10);
            n/=10;
        }

        if(sum==1){
            return true;
        }else if(sum==origional || list.contains(sum) ){
            return false;
        }
        list.add(sum);
        return CheckHappyNumber(sum , origional , list);
    }


   public static boolean checkPalindromeLinkedList(Listnode head){
       if(head==null || head.next==null){
           return true;
       }
       List<Integer> list = new ArrayList<>();
       while(head!=null){
           list.add(head.data);
           head=head.next;
       }
       for(int i=0;i<list.size()/2;i++){
           if(list.get(i)==list.get(list.size()-1)){
               list.remove(list.size()-1);
               System.out.println("size is"  + list.size());
               continue;
           }else{
               return false;
           }
       }
       return true;
   }

    public int[][] getTransposeMetric(int[][] metric) {
      int[][] result = new int[metric.length][metric[0].length];
      for(int i=0;i<metric.length;i++){
          for(int j=0;j<metric[0].length;j++){
              result[j][i] = metric[i][j];
          }
      }
      return result;
    }

    public boolean isAnagram(String s1 , String s2){

         return false;
    }

    public boolean canConstruct(String ransomNote, String magazine) {

      String s1 = ransomNote;
      String s2 = magazine;

      for(int i=0;i<ransomNote.length();i++){
          if( s2.indexOf(ransomNote.charAt(i)) != -1){
             s1 = s1.replaceFirst(String.valueOf(ransomNote.charAt(i)), "");
             System.out.println(s1);
             s2 = s2.replaceFirst(String.valueOf(ransomNote.charAt(i)), "");
              System.out.println(s2);
          }else{
              return false;
          }
      }

      return s1.length()==0;

    }

    public int numSpecial(int[][] a){
         int sum=0;
//         int m=0,n=0;
         int temp=0;
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
//                 System.out.println(a[i][j]);

                 if(a[i][j]==1){

//                     System.out.println(a[i][j]);

                   for(int m=0;m<a[0].length;m++){
                       if(a[i][m]==1){
                           temp++;
                       }else{

                       }
                   }
                   for(int m=0;m<a.length;m++){
                       if(a[m][j]==1){
                           temp++;
                       }else{

                       }
                   }
//                   System.out.println(temp);
                   if(temp>2){

                   }else{
                       sum+=1;
                   }
                 }

                 temp=0;

             }

         }
         return sum;
    }


    public int firstUniqChar(String s){
         int index = 0;
          Map<Character , Integer> hashmap = new HashMap<>();
          hashmap.put(s.charAt(0) , 1);
         for(int i=1;i<s.length();i++){
            if(hashmap.get(s.charAt(i))==null){
                hashmap.put(s.charAt(i) , 1);
            }else{
                hashmap.put(s.charAt(i) , hashmap.get(s.charAt(i))+1);
            }

         }
         for(int i=0;i<s.length();i++){
             if(hashmap.get(s.charAt(i)) ==1){
                 return i;
             }
         }
        System.out.println(hashmap);

         return index;


    }

    public  int[][] onesMinusZeros(int[][] a){
         int result[][] = new int[a.length][a[0].length];
         int[] rows=new int[a.length];
         int[] cols=new int[a[0].length];


         for(int i=0;i<a.length;i++){
             int sum=0;
             for(int m=0;m<a[i].length;m++){
                 if(a[i][m]==1){
                     sum++;
                 }
             }
             System.out.println(sum);
             rows[i] = (sum - (a[i].length - sum));
         }

        for(int i=0;i<a[0].length;i++){
            int sum=0;
            for(int m=0;m<a.length;m++){
                if(a[m][i]==1){
                    sum++;
                }
            }
            cols[i] = (sum - (a.length - sum));
        }
        PrintArray(rows);
        PrintArray(cols);

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                result[i][j] = rows[i] + cols[j];
            }
        }





         return result;
    }

    public  String destCity(String[][] a){

      Map<String , String> hashmap = new HashMap<>();
      for(int i=0;i<a.length;i++){
          for(int j=0;j<a[i].length-1;j++){
              hashmap.put(a[i][j] , a[i][j+1]);
          }
      }
      String temp  =a[0][0];
      while (hashmap.get(temp)!=null){
          temp = hashmap.get(temp);
      }

      return temp;


    }

    public  char findTheDifference(String s1  ,  String s2){
         if(s1.length()==0){
             return s2.charAt(0);
         }
         if(s2.length()==0){
             return s1.charAt(0);
         }
         int i=0;
         char[] chararr1 = s1.toCharArray();
         char[] chararr2 = s2.toCharArray();
         Arrays.sort(chararr1);
         Arrays.sort(chararr2);
         while (i  < chararr1.length && i<chararr2.length && chararr1[i]==chararr2[i]){
             i++;
         }
         System.out.println(i);
         return  chararr1.length > chararr2.length ? chararr1[i]  :chararr2[i];
    }

//    public boolean isAnagram(String s , String t){
//         String s1 = s;
//         String s2 = t;
//
//    }

    public int maxProductDifference(int[] a){
         Arrays.sort(a);
         int maxDiff = (a[a.length-1]*a[a.length-2]) - (a[0] * a[1]);
         return maxDiff;
    }

    public int[][] imageSmoother(int[][] a){

            int[][] result = new int[a.length][a[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[i].length;j++){
                    int sum=0;
                    int count=0;
                    for(int m=i-1;m<=i+1;m++){
                        for(int n=j-1;n<=j+1;n++){
                            if(m>=0 && m<a.length && n>=0&&n<a[i].length){
                                sum+=a[m][n];
                                count++;
                            }
                        }
                    }
                    result[i][j] = sum/count;
                }
            }
            return result;


    }
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result =  new ArrayList<>();
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Get the index to mark as visited
            int index = Math.abs(nums[i]) - 1;

            // If the number at the index is positive, mark it as visited by making it negative
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Iterate through the array again to find the indices with positive numbers
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                // The index (i+1) represents the missing number
//                result.add(i + 1);
//            }
            System.out.println(nums[i]);
        }

        return result;
    }

    public int buyChoco(int[] a , int money){
         int result=0;
         Arrays.sort(a);
         result = money - (a[0]+a[1]);
        return  result >= 0 ?  result :  money;

    }

    public boolean repeatedSubstringPattern(String s1){
          boolean result =  false;
          boolean temp=true;
          int n = s1.length();

          for(int i=n/2;i>=0;i--){
              System.out.println("i is" + i);
              temp=true;
              if(n%(i+1)==0){
                  String s2 = s1.substring(0,i+1);
                  System.out.println(s2);
                  for(int j=1;j<n/(i+1);j++){
                      System.out.println("j is" + j);
                      int start=(i+1)*j;
                      int end=(i+1)*(j+1);
                      System.out.println(start  + ""  +  end);
                      System.out.println("s3 is "  + s1.substring(start , end));
                      if(s2.equals(s1.substring(start , end))){
                          System.out.println(s1.substring(start , end));
                          result=true;
                      }else{
                          temp=false;
                          break;
                      }
                  }
                  if(temp && result){
                      return true;
                  }
              }
          }

          return false;

    }

    public int maxWidthOfVerticalArea(int[][] a){
         int result=0;
        Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));  // to sort 2d aray based on 0th sub index
        for(int i=0;i<a.length-1;i++){
            if( a[i+1][0]-a[i][0] > result ){
//                System.out.println("yes");
                result = a[i+1][0]-a[i][0];
            }
        }
        System.out.println(result);
        return result;
    }
    public int findComplement(int num){
        int result = 0;
        int i = 0;

        while (num != 0) {
            int bit = num % 2;
            int complementBit = (bit == 1) ? 0 : 1;
            result += (complementBit * Math.pow(2, i));
            num /= 2;
            i++;
        }

        return result;
    }

    public  int maxScore(String s){
         int sum=0;
         int zeros=0;
         int ones=0;
         if(s.charAt(0)=='0'){
             zeros++;
         }
         for(int i=1;i<s.length();i++){
             if(s.charAt(i)=='1'){
                 ones++;
             }
         }
         System.out.println(ones);
         sum=ones+zeros;

         for(int i=1;i<s.length()-1;i++){
             if(s.charAt(i)=='0'){
                 ++zeros;
             }else{
                 --ones;
             }

             System.out.println( "i is  " + i  + " zeros is" + zeros);
             System.out.println( "i is  " + i  + " ones is" + ones);

             if(zeros+ones > sum){
                 sum=zeros+ones;
             }

         }


         return sum;

    }


    public boolean isPathCrossing(String s){
         boolean result=false;
         Map<String  , Boolean> hashmap = new HashMap<String , Boolean>();
         int x=0 , y=0;

         for(int i=0;i<s.length();i++){

             String temp = ""+x+"_"+y;
             System.out.println(temp);
             if(hashmap.get(temp)==null){
                 hashmap.put(temp , true);
             }

           if(s.charAt(i)=='N'){
               x++;
           }if(s.charAt(i)=='E'){
               y++;
           }if(s.charAt(i)=='W'){
               y--;
           }if(s.charAt(i)=='S'){
               x--;
           }
             temp = ""+x+"_"+y;

             if(hashmap.get(temp)!=null){
                 return true;
             }



         }
//         System.out.println(x + " " + y);
         return result;

    }

    public int islandPerimeter(int[][] a){
         int result=0;
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
                 if(a[i][j]==1){
                    int temp=4;
                    if(j!=0){
                       if(a[i][j-1]==1){
                           temp--;
                       }
                    }
                    if(i!=0){
                        if(a[i-1][j]==1){
                            temp--;
                        }
                    }
                    if(i!=a.length-1){
                        if(a[i+1][j]==1){
                            temp--;
                        }
                    }
                    if(j!=a[i].length-1){
                        if(a[i][j+1]==1){
                            temp--;
                        }
                    }

                    result+=temp;
                 }
             }
         }
         return result;
    }

    public int hammingDistance(int x ,  int y){

         int n=0;
         while (x!=0 || y!=0){
            if(x%2 != y%2){
              n++;
            }
            x/=2;
            y/=2;
         }
         return n;
    }

    public int[] constructRectangle(int area) {
        int n = (int) Math.sqrt(area);
        if(n*n==area){
            return  new int[]{n , n};
        }
        if(isPrime(area)){
            return new int[]{area , 1};
        }
        int num1=1;
        int num2=1;
        for(int i=n;i>0;i--){
            if(area%i==0){
                num1=area/i;
                num2=i;
                break;
            }
        }

        return new int[]{num1 , num2};

    }

    public String licenseKeyFormatting(String s , int k){
        s = s.replaceAll("-", "").toUpperCase();
        int lenS = s.length();
        if (lenS == 0) {
            return "";
        }
        int firstGroupSize = lenS % k;
        StringBuilder result = new StringBuilder();

        if (firstGroupSize > 0) {
            result.append(s, 0, firstGroupSize).append("-");
        }

        for (int i = firstGroupSize; i < lenS; i += k) {
            result.append(s, i, i + k).append("-");
        }





        return result.substring(0, result.length() - 1);
    }

    public int findMaxConsecutiveOnes(int[] a){
         int ones=0;
         int temp=0;
         int i=0;
         int j=0;
         while (i<a.length){
             temp=0;
             while (i<a.length && a[i]==1){
                 temp++;
                 i++;
             }
             if(temp>ones){
                ones=temp;
             }
             i++;
         }
         return ones;
    }

    public int findPoisonedDuration(int[] a , int dur){
         int time=dur;
         int i=1;

         while (i<a.length){
          if(a[i]<a[i-1]+dur){
              time+=a[i]-a[i-1];
          }else{
              time+=dur;
          }
          i++;
         }
         return time;
    }

    public static int findNextGreter(int[] a , int index){
        int elm = a[index];
        for(int i=index+1;i<a.length;i++){
            if(a[i]>elm){
                return a[i];
            }
        }
        return -1;
    }
    public static int findIndex(int[] array , int target){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> findAllFacor(int num){
      List<Integer> list = new ArrayList<>();
      for(int i=1;i<=(int)Math.sqrt(num);i++){
          if(num%i==0){
              System.out.println(i + " " + num/i);
              list.add(i);
              list.add(num/i);
          }
      }
      return list;
    }
//    public int[] nextGreaterElement(int[] nums1 , int[] nums2){
//         int[] result = new int[nums1.length];
//         for(int i=0;i<nums1.length;i++){
//             result[i] = findNextGreter(nums2 , findIndex(nums2 , nums1[i]) ) ;
//         }
//         return result;
//    }
    public int minOperations(String s){
         int count=0;
         int i=1;
         char[] charArr = s.toCharArray();
         while (i<s.length()){
             while (i<s.length() && charArr[i-1]==charArr[i]){
                 System.out.println("i is" + i);
                 charArr[i] = charArr[i-1]=='1' ? '0' : '1';
                 i++;
                 count++;
             }
             i++;
         }
         System.out.println(count);
         return count;
    }

    public static String findrow(char c){
         String[] arr = {"qwertyuiop" , "asdfghjkl" , "zxcvbnm"};
//
//         System.out.println(c);
         for(int i=0;i<arr.length;i++){

             if(arr[i].indexOf(Character.toLowerCase(c))!=-1){
                 return arr[i];
             }
         }
         return "";
    }
    public String[] findWords(String[] words){
         int x=0;
        main: for(int i=0;i<words.length;i++){
             words[i] = words[i].toLowerCase();
             String row = findrow(words[i].charAt(0));
             System.out.println(row);
             for(int j=0;j<words[i].length();j++){
              if(row.indexOf(words[i].charAt(j)) ==-1){
                  continue main;
              }
             }
             words[x]=words[i];
             x++;
         }

        System.arraycopy(words , 0 , words , 0 , x);
        return Arrays.copyOf(words, x);
    }

    public String convertToBase7(int num){
         StringBuilder s = new StringBuilder();
         while (num!=0){
              if(num%7<0){
                  s.append(Integer.toString(Math.abs(num%7)) + "-");
              }else{
                  s.append(Integer.toString(num%7));
              }



             num/=7;
         }
         System.out.println(s);
         return s.reverse().toString();
    }


    public String[] findRelativeRanks(int[] score) {
      String[] result = new String[score.length];
      int[] temp = Arrays.copyOf(score , score.length);
      Arrays.sort(temp);
//      PrintArray(temp);
//      PrintArray(score);
        for(int i=0;i<score.length;i++){
            int index = findIndex(temp , score[i]);
            System.out.println("index is" + index);
            if(index==temp.length-1){
                result[i]="Gold Medal";
            } else if (index==temp.length-2) {
                result[i]="Silver Medal";
            } else if (index==temp.length-3) {
               result[i]="Bronze Medal";
            }else {
                result[i]=Integer.toString(temp.length-index);
            }
        }
      return result;
    }





    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }


    public static void PrintIntList(List<Integer> list){
        for(int elm : list){
            System.out.print(elm + " ");
        }
        System.out.println("");
    }
    public static void PrintStringList(List<String> list){
        for(String elm : list){
            System.out.println(elm);
        }
    }
    public static int getLowestSum(List<Integer> list){
      int sum=0;
        list.sort((a, b) -> a.compareTo(b));
        PrintIntList(list);
        for(int i=0;i<list.size()-1;i++){
            sum+=list.get(i);
        }
      return sum;
    }

    public int minCost(String s , int[] time){
         int count=0;
//         if(s.charAt(0)==s.charAt(1)){
//             count = time[0] > time[1] ? time[1] : time[0];
//         }
         int i=0;
         while (i<s.length()-1){
              if(s.charAt(i)==s.charAt(i+1)){
                  List<Integer> list = new ArrayList<>();
                  while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                      list.add(time[i]);
                      i++;
                  }
                  list.add(time[i]);

                  count+=getLowestSum(list);

              }
              i++;
         }
         return count;
    }


    public static Listnode sumOfTwoListNode(Listnode l1 , Listnode l2){

         List<Integer> list3 = new ArrayList<>();

        System.out.println("over");
         int carry=0;

        while (l1!=null && l2!=null){
            int sum=l1.data+l2.data+carry;
            list3.add(sum>9 ? sum%10 : sum);
            carry = sum > 9 ? carry = sum/10 : 0;
            l1=l1.next;
            l2=l2.next;
        }

        while (l1!=null){
            int sum=l1.data+carry;
            list3.add(sum>9 ? sum%10 : sum);
            carry = sum > 9 ? carry = sum/10 : 0;
            l1=l1.next;
        }
        while (l2!=null){
            int sum=l2.data+carry;
            list3.add(sum>9 ? sum%10 : sum);
            carry = sum > 9 ? carry = sum/10 : 0;
            l2=l2.next;
        }


        if(carry > 0 ){
            list3.add(carry);
        }



        PrintIntList(list3);
        System.out.println("over");
        return l1;
    }


    public int getLengthOfOptimalCompression(String s , int k){
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 9999;
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0, del = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1))
                        cnt++;
                    else
                        del++;

                    if (j - del >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                    }
                }
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }



    public static Listnode addTwoNumbers(Listnode l1 , Listnode l2){
         List<Integer> listarr1 = new ArrayList<>();
         List<Integer> listarr2 = new ArrayList<>();

         Listnode l3 = new Listnode(-1);
         while (l1.next!=null){
             listarr1.add(l1.data);
         }
         while (l2.next!=null){
             listarr2.add(l2.data);
         }
         int lenA = listarr1.size();
         int lenB = listarr2.size();

         int minLen = listarr1.size() < listarr2.size() ? listarr1.size() : listarr2.size();
         System.out.print(minLen);
         int carry=0;
         while (minLen!=0){

         }

         return l3;

    }

    public boolean checkPerfectNumber(int num){
         if(num==1){
             return false;
         }
         List<Integer> list = new ArrayList<>();
         list = findAllFacor(num);
         int sum=0;
         for(int i=0;i<list.size();i++){
             sum+=list.get(i);
         }
         System.out.println(sum);
         return sum-num == num;
    }

    public int maxLengthBetweenEqualCharacters(String s) {
      if(s.length()==2 && s.charAt(0)==s.charAt(1)){
          return 0;
      }
      int count=-1;
      Map<Character , Integer> hashmap = new HashMap<>();
      for(int i=0;i<s.length();i++){
       if(hashmap.get(s.charAt(i))==null){
           hashmap.put(s.charAt(i) , i);
       }else {
           count = Math.max(count ,  i-hashmap.get(s.charAt(i)) -1);
       }
      }
      System.out.println(hashmap);
      return count;
      
    }
    public int findContentChildren(int[] g , int[] s){
         if(s.length==0 || s.length==0){
             return 0;
         }
         Arrays.sort(g);
         Arrays.sort(s);
         int count=0;
         int index=0;
         for(int i=0;i< (Math.min(s.length , g.length));i++){
             System.out.println(i);
           if(s[i]>=g[i]){
               count++;
               index=i;
           }else{
               break;
           }
         }
         count=g[index];
         return count;
    }




//     List<List<Integer>> list = new ArrayList<>();
//     List<Integer> l1 = new ArrayList<>();

    public static void combinationSumHelper(int[] a , int index , int target , List<Integer> l1 , List<List<Integer>> list){

         if(target==0){
             list.add(new ArrayList<>(l1));
             return;
         }
         if(target<0){
             return;
         }
         for(int i=index;i<a.length;i++){
             if(target<a[i]){
                 break;
             }
             l1.add(a[i]);
             combinationSumHelper(a , i , target-a[i] , l1 , list);
             l1.remove(l1.size()-1);
         }

    }

    List<List<Integer>> combinationSum(int[] a , int target){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        combinationSumHelper(a, 0 , target , l1 , list);
        return list;
    }


    public  static   void  combinationSum2Helper(int[] a , int index ,  int target , List<Integer> l1 , List<List<Integer>> list){

        if(index==a.length && target!=0){
            return;
        }
        if(target==0){
            if(!list.contains(l1)){
                list.add(new ArrayList<>(l1));
            }
            return;

        }
        if(target<0){
            return;
        }


        for(int i=index;i<a.length;i++){
            if(i>index && a[i]==a[i-1]){
                continue;
            }
            if(a[i]>target){
                break;
            }
            l1.add(a[i]);

            combinationSum2Helper(a , i+1 , target-a[i] , l1 , list);
            l1.remove(l1.size()-1);
        }




    }

    List<List<Integer>> combinationSum2(int[] a , int target){

        Arrays.sort(a);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        combinationSum2Helper(a , 0  , target ,   l1 , list);
        return list;

    }

//    List<List<Integer>> combinationSum(int[] a , int target){
//
//        int sum=0;
//        for(int i=0;i<a.length;i++){
//            sum=0;
//            List<Integer> l2 = new ArrayList<>();
//            l2.clear();
//
//            combinationSumHelper(a , target , sum , i , l2);
//        }
//
//        return list;
//    }


    public int lengthOfLongestSubstring(String s){ //abcabcbb


         int max = 1;

         String str = s.charAt(0)+"";
         for(int i=1;i<s.length();i++){
           if(str.contains(s.charAt(i)+"")){
               System.out.println("i is " + i);
               int index = str.indexOf(s.charAt(i));
               System.out.println("index is " + index);
               max=Math.max(max , str.length());
               System.out.println("max is " + max);
               System.out.println("elm is " + str);
               int len = str.length();
               str = str.substring(index+1 , len);

           }
           str+=s.charAt(i);

         }
         return max;


    }
//    public int lengthOfLongestSubstring(String s){ //abcabcbb
//         int start=0;
//         int end=0;
//         int max=0;
//         Set<Character> hashset= new HashSet<>();
//
//        while (end<s.length()){
//            System.out.println("yes" + hashset);
//           char chr = s.charAt(end);
//           if(hashset.add(chr)){
//
//               max = Math.max(max , end-start+1);
//               end++;
//           }else{
//             while (s.charAt(start)!=chr){
//                 hashset.remove(s.charAt(start));
//                 start++;
//             }
//               hashset.remove(s.charAt(start));
//               start++;
//
////             System.out.println(hashset);
//           }
//
//        }
//
//        System.out.println(hashset);
//
//
//         return max;
//    }
    public  boolean detectCapitalUse(String s){
         Character c = s.charAt(0)<=122 && s.charAt(0)>=97 ? 'a' : 'A';
         System.out.println(c);
         if(c=='A'){
             if(s.length()!=1 && s.charAt(1)<=90 && s.charAt(1)>=65){
                 for(int i=1;i<s.length();i++){
                     if(s.charAt(i)<=122 && s.charAt(i)>=97){
                         continue;
                     }

                     return false;
                 }

             }else{
                 for(int i=1;i<s.length();i++){
                     if(s.charAt(i)<=90 && s.charAt(i)>=65){
                         continue;
                     }

                     return false;
                 }
             }


         }else{
             for(int i=1;i<s.length();i++){
                 if(s.charAt(i)<=122 && s.charAt(i)>=97){
                     continue;
                 }

                 return false;
             }
         }
         return true;
    }

    public List<List<Integer>> findMatrix(int[] nums) {   //  [8,8,8,8,2,4,4,2,4]  [[8,4,2],[8,4,2],[8,4],[8]]    [[8],[8],[8],[8,2,4],[4,2],[4]]
      List<List<Integer>> list = new ArrayList<>();

      int j=0;
      int k=0;
      list.add(new ArrayList<>());
      for(int i=0;i<nums.length;i++){
          if(list.get(j).contains(nums[i])){
           j++;
           if(list.size()==j && list.get(j).contains(nums[i])){

           }
           list.add(new ArrayList<>());
           list.get(j).add(nums[i]);
          }else{
              list.get(j).add(nums[i]);
          }
      }
//      PrintDoublyList(list);

      return list;
    }

//    P   A   H   N
//    A P L S I I G
//    Y   I   R
    public String convert(String s , int numRows){
         if(numRows==1){
             return s;
         }
         List<List<Character>> list = new ArrayList<>();
         for(int i=0;i<numRows;i++){
             list.add(new ArrayList<>());
         }
         int j=-1;
         boolean down=true;
         boolean up=false;
         for(int i=0;i<s.length();i++){
             if(j==numRows-1){
                 down=false;
                 up=true;
             }
             if(j==0){
                 down=true;
                 up=false;
             }
             if(down==true){
                 j++;
                list.get(j).add(s.charAt(i));
             }
             if(up==true){
                 j--;
                 list.get(j).add(s.charAt(i));
             }
         }
        String s1 = "";
         for(int i=0;i<list.size();i++){
             for(int k=0;k<list.get(i).size();k++){
                 s1+=list.get(i).get(k);
             }
         }


         return s1;

    }

    public int numberOfBeams(String[] s){
         int count=0;
         boolean isFound=false;
         int a=0;
         int b=0;
         List<Integer> list = new ArrayList<>();
         for(String word : s){
//            System.out.println(word);
             if(word.contains("1")){
                 System.out.println(word);
                 long temp = word.chars().filter(ch -> ch == '1').count();
                 System.out.println(temp);
                 list.add((int)temp);
             }
         }
         for(int i=0;i<list.size()-1;i++){
             count+=list.get(i) * list.get(i+1);
         }
         System.out.println(count);
         return count;
    }

    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(a);
        PrintArray(a);
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue; // Skip duplicate elements
            }

            int j = i + 1;
            int k = a.length - 1;

            while (j < k) {
                int sum = a[i] + a[j] + a[k];

                if (sum == 0) {
                    result.add(Arrays.asList(a[i], a[j], a[k]));

                    // Skip duplicate elements for 'j'
                    while (j < k && a[j] == a[j + 1]) {
                        j++;
                    }
                    // Skip duplicate elements for 'k'
                    while (j < k && a[k] == a[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    int[] rotate189(int[] a , int k){

        int[] b = new int[a.length];
        Arrays.fill(b , 0);

        int j=a.length-k;
        if(j<0){
            j=k%a.length;
            j=a.length-j;
        }
        for(int i=0;i<a.length;i++){
            if(j==a.length){
                j=0;
            }
            b[i] = a[j];
            j++;
        }
        System.arraycopy(b , 0 , a , 0 , b.length);
        return a;
    }
    public int minOperations(int[] nums){
         int count=0;
         Map<Integer , Integer> hashmap  = new HashMap<>();
         for(int i=0;i<nums.length;i++){
            if(hashmap.get(nums[i])==null){
              hashmap.put(nums[i] , 1);
              continue;
             }
            hashmap.put(nums[i] , hashmap.get(nums[i]) + 1);
         }
//
         System.out.println(hashmap);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer , Integer> entry : hashmap.entrySet()){
          list.add(entry.getValue());
        }

        for(int i=0;i<list.size();i++){
            if(list.get(i)==1){
                return -1;
            }
//            if(list.get(i)%2!=0 && list.get(i)%3 !=0){
//              if(isPrime(list.get(i))){
            if(list.get(i)%2==0){
//              count+=list.get(i)/2;
                int num = list.get(i);
                while (num % 3 !=0 &&  num%2==0){
                    num-=2;
                }
                count+=num/3;
                if(list.get(i)-num!=0){
                    count+=(list.get(i)-num )/2;
                }
                System.out.println("count is " + count);
            }else{
                int num=list.get(i);
                while (num >=0 && num%3!=0 && (list.get(i)-num) %2 ==0){
                    num-=2;
                }
                if(num<0){
                    return -1;
                }
                count+=num/3;
                count+=(list.get(i)-num)/2;
                System.out.println("num is " + num);
            }


                  continue;



//            if(list.get(i)%3==0){
//                count+=list.get(i)/3;
//                continue;
//            }

//            count+= Math.min(list.get(i)/2 , list.get(i)/3);

        }
         return count;
    }
    public static List<String> combineLetter(Character digit , List<String> previous){
//        System.out.println(Integer.parseInt(digit.toString()));
        List<String> tempList = new ArrayList<>();
        tempList.add("abc");
        tempList.add("def");
        tempList.add("ghi");
        tempList.add("jkl");
        tempList.add("mno");
        tempList.add("pqrs");
        tempList.add("tuv");
        tempList.add("wxyz");
           List<String> list = new ArrayList<>();

           System.out.println(list.size());
           return list;
    }
//    public List<String> letterCombinations(String digit){
//         List<String> list = new ArrayList<>();
//
//
//        for(int i=digit.length()-1;i>=0;i--){
//             List<String> temp  = combineLetter(digit.charAt(i) , list);
//             list.addAll(temp);
//        }
//        System.out.println(list.size());
//
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//
//        return list;
//
//
//
//
//    }

    boolean halvesAreAlike(String s){
         int first=0;
         int last=0;
         String s1="AEIOUaeiou";

         for (int i=0;i<s.length();i++){
             if(s1.indexOf(s.charAt(i)) != -1){
                 if(i<s.length()/2){
                     first++;
                 }else if(i>=s.length()/2){
                     last++;
                 }
             }


         }
        System.out.println(first);
        System.out.println(last);

         return first==last;
    }

    public int minSteps(String s , String t){
         int result=0;
         Map<Character , Integer> hashmap1 = new HashMap<>();
         Map<Character , Integer> hashmap2 = new HashMap<>();
         for(int i=0;i<s.length();i++){
             char currentChar = s.charAt(i);
             char currentChar2 = t.charAt(i);
             if (hashmap1.containsKey(currentChar)) {
                 // If yes, increment the count
                 hashmap1.put(currentChar, hashmap1.get(currentChar) + 1);
             } else {
                 // If no, add the character to the HashMap with a count of 1
                 hashmap1.put(currentChar, 1);
             }
             if (hashmap2.containsKey(currentChar2)) {
                 // If yes, increment the count
                 hashmap2.put(currentChar2, hashmap2.get(currentChar2) + 1);
             } else {
                 // If no, add the character to the HashMap with a count of 1
                 hashmap2.put(currentChar2, 1);
             }
         }


         for(Map.Entry<Character , Integer> entry : hashmap1.entrySet()){
             char key = entry.getKey();
             if(hashmap2.get(key)==null){
                 result+=hashmap1.get(key);
                 System.out.println(key);

                 continue;
             }
             if(hashmap2.get(key)>=hashmap1.get(key)){
//                 System.out.println("hy");
//                 System.out.println(key);
                 continue;
             }else{
                 System.out.println("hyms");
                 result+=(hashmap1.get(key) - hashmap2.get(key));
             }


         }

//         System.out.println("hashmap 1 is " + hashmap1);
//         System.out.println("hashmap 2 is " + hashmap2);
//         System.out.println("result is "  + result);
         return result;
    }

    public List<List<Integer>> findWinners(int[][] matches){
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer , Integer> hashmap  = new TreeMap<>();
        for(int i=0;i<matches.length;i++){
            hashmap.put(matches[i][0] , 0);
            hashmap.put(matches[i][1] , 0);
        }
        for(int i=0;i<matches.length;i++){
         hashmap.put(matches[i][1] , hashmap.get(matches[i][1]) + 1);
        }


        list.add(new ArrayList<>());
        list.add(new ArrayList<>());


        for(Map.Entry<Integer , Integer> entry : hashmap.entrySet()){
         
          if(entry.getValue()==0){
              list.get(0).add(entry.getKey());
          } else if (entry.getValue()==1) {
              list.get(1).add(entry.getKey());
          }
        }

        System.out.println(hashmap);
        return list;
    }
    public static Listnode removeNthFromEnd(Listnode l1 , int n){
        Listnode dummy = new Listnode(0);
        dummy.next = l1;

        Listnode fast = dummy;
        Listnode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the n-th node from the end
        slow.next = slow.next.next;

        return dummy.next;

    }

    public static boolean isPalindromeLinkedList(Listnode l1){
        boolean isPal = true;


        return isPal;
    }



    public  static  Listnode reverseKGroup(Listnode l1 , int k){  //  1 2 3  4 5 6  7 8 9
                                                          //  3 2 1  6 5 4  9 8 7
        int x=1;
        int p=0;
        Listnode dummy = new Listnode(-1);
        Listnode ans = dummy;
        Listnode start=l1;
        Listnode origionalHead=null;
        Listnode newend=null;
        Listnode prv = null;
       while (l1!=null){
           while (l1!=null && x!=k){
               l1=l1.next;
               x++;
           }
           if(x==k && l1!=null){

             Listnode nxt = l1==null ? null : l1.next;
              newend = start;
              if(l1!=null){
                  l1.next=null;
              }

             dummy.next=reverseListNode(start);
             start=nxt;
             l1=start;
             dummy=newend;
             x=1;
           }else {
               dummy.next=start;
           }

       }
//       PrintListnode(ans);
       return ans.next;

    }

    public static Listnode detectCyclePoint(Listnode l1){
        Listnode slow = l1;
        Listnode fast = l1;
        int ind=-1;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                 slow = l1;
                 ind=0;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                    ind++;
                }
            }
        }

        return new Listnode(ind);


    }


    public int myAtoi(String s){
         int result=0;
         int i=0;
         boolean ismines=false;
         while (!Character.isDigit(s.charAt(i))){
             if(s.charAt(i)=='-'){
                 ismines=true;
             }
             i++;
         }
         String s1="";
         while(Character.isDigit(s.charAt(i))){
             s1+=s.charAt(i);
             i++;
         }
         System.out.println("s1 is : " +  s1);
         result=Integer.parseInt(s1);
         return ismines ? -result :  result;
    }
    boolean uniqueOccurrences(int[] a){
         boolean isUnique=false;
         Map<Integer , Integer> hashmap = new HashMap<>();
         for(int i=0;i<a.length;i++){
             if(hashmap.get(a[i])==null){
                 hashmap.put(a[i] , 1);
             }else{
                 hashmap.put(a[i] , hashmap.get(a[i])+1);
             }

         }
         Set<Integer> hashset = new HashSet<>();
         for(Map.Entry<Integer , Integer> entry : hashmap.entrySet()){
             int val = entry.getValue();
             if(hashset.add(val)==false){
                 return false;
             }
         }
         System.out.println(hashmap);
         return true;
    }
//    public int climbStairs(int n){
//         if(n==2){
//             return 2;
//         }
//         if(n==1){
//             return 1;
//         }
//         if(n==0){
//             return 0;
//         }
//
//         return climbStairs(n-1) + climbStairs(n-2);
//
//    }

    public int findLUSlength(String s1 , String s2){
         if(s1==s2){
             return 0;
         }
         int indexOfs1=s1.length();
         int indexOfs2=s2.length();



         return -1;

    }

    public int minFallingPathSum(int[][] a){
         int sum=0;

         return sum;
    }

    public boolean canJump(int[] a){
        boolean result = false;
        int target = a.length - 1;
        int curInd = a.length - 2;

        while (curInd >= 0) {
            if (target <= curInd + a[curInd]) {
                target = curInd;
                curInd--;
                continue;
            }
            curInd--;
        }

        // Check if the first index is reachable from the last index
        result = a[0] >= target;

        return result;
    }
    private int countMinHelper(int[] a , int start){
        if (start >= a.length - 1) {
            return 0;
        }

//        if (dp[start] != -1) {
//            return dp[start];
//        }

        int len = a.length - 1;
        if (a[start] == 0) {
            return Integer.MAX_VALUE;
        }

        int jmp = Math.min(len - start, a[start]);
        int ans = Integer.MAX_VALUE;

        for (int i = start + 1; i <= start + jmp; i++) {
            int jumps = countMinHelper(a, i);
            if (jumps != Integer.MAX_VALUE) {
                ans = Math.min(ans, jumps + 1);
            }
        }


        return ans;
    }
    public int countMinJump(int[] a){

         int start=0;
         return countMinHelper(a , start);
    }
    public int evalRPN(String[] s){
         int result=0;
        ArrayList<String> stack = new ArrayList<>();
         String s1="+-*/";
         for(int i=0;i<s.length;i++){
             if(s1.contains(s[i])){
               System.out.println(s[i]);
               int num1=Integer.parseInt(stack.get(stack.size()-1));
               int num2=Integer.parseInt(stack.get(stack.size()-2));
               System.out.println("num2 is " + num2);
               System.out.println("num1 is " + num1);
               int temp=0;

                switch (s[i]){
                    case "+" :
                        System.out.println("y");
                        temp = num1+num2;
                        break;

                    case "-" :
                        temp=num2-num1;
                        break;
                    case "*" :
                        temp=num2*num1;
                        break;
                    case "/" :
                        temp=num2/num1;
                        break;

                }
                System.out.println("temp is now" + temp);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add(Integer.toString(temp));
                continue;
             }
             stack.add(s[i]);

         }
         System.out.println(stack);
         return result;
    }

    List<Integer> sequentialDigits(int low , int high){
        List<Integer> result = new ArrayList<>();

        String s="123456789";
        int l=String.valueOf(low).length();
        int h=String.valueOf(high).length();

        for(int i=l;i<=h;i++){
           for(int j=0;j<10-i;j++){
                int num = Integer.parseInt(s.substring(j , j+i));
                System.out.println(num);
                if(num<high){
                    result.add(num);
                }
           }
        }




        return result;
    }


    private int hindexHelper(int[] a , int start , int end){
         int result=0;
         int mid=(start+end)/2;
         System.out.println("mid is " + mid);
        int target = a[mid];
        System.out.println("target " + target);
        if(mid==start){




        }



         if(target<=a.length-mid){
             System.out.println("yes");
             result = hindexHelper(a  , mid , end);
         }else{
             System.out.println("no");
             result = hindexHelper(a , start , mid);
         }

         return result;

    }
    public int hIndex(int[] a){   //[1 1 3] [0 0 4 4]
         Arrays.sort(a);
       return hindexHelper(a ,  0 , a.length-1);
    }

    public int[] productExceptSelf(int[] a){
         int[] b = new int[a.length];
         int[] leftP = new int[a.length];
         int[] rightP = new int[a.length];
         int product=1;
         for(int i=0;i<a.length;i++){
             if(i==0){
              leftP[i]=1;
              continue;
             }
             product=product*a[i-1];
             leftP[i]=product;
         }
         product=1;
         for(int i=a.length-1;i>=0;i--){
             if(i==a.length-1){
              rightP[i]=1;
              continue;
             }
             product=product*a[i+1];
             rightP[i]=product;
         }
//         PrintArray(rightP);
          for(int i=0;i<a.length;i++){
              b[i]=leftP[i]*rightP[i];
          }
         return b;
    }

    List<List<String>> groupAnagrams(String[] s){
         List<List<String>> result = new ArrayList<>();
         Map<String , List<String>> hashmap = new HashMap<>();
         for(int i=0;i<s.length;i++){
             char[] charArr = s[i].toCharArray();
             Arrays.sort(charArr);
             String sortedStr = new String(charArr);
             if(hashmap.get(sortedStr)==null){
                List<String> temp = new ArrayList<>();
                temp.add(s[i]);
                 hashmap.put(sortedStr , temp);
             }else{
                 hashmap.get(sortedStr).add(s[i]);
             }
         }
         for(Map.Entry<String , List<String>>  entry : hashmap.entrySet()){
             System.out.println(entry.getValue());
             result.add(entry.getValue());
         }

         return result;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

//        int[] gas = {5,1,2,3,4};
//        int[] cost = {4,4,1,5,1};

        int result = -1;
        int totalGas = 0;  // Track total gas
        int currentGas = 0;  // Track gas at the current station
        int startStation = 0;  // Potential starting station

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            System.out.println("current gas is" + currentGas);

            // If gas at the current station is negative, update the potential starting station
            if (currentGas < 0) {
                System.out.println("index is " + i);
//                System.out.println(totalGas + "  totalgas");
//                System.out.println(currentGas + "  currentGas");
                currentGas = 0;
                startStation = i + 1;
            }
        }
        System.out.println("total gas is " + totalGas);

        // If totalGas is non-negative, a valid circuit exists, return the potential starting station
        return totalGas >= 0 ? startStation : -1;
    }

    String intToRoman(int num){
         String s = "";
         Character[] charArr =  {'I'  , 'V' , 'X' , 'L' , 'C' , 'D' , 'M'};
         List<Integer> val = new ArrayList<>(Arrays.asList(1,5,10,50,100,500,1000));
         Map<Character , Integer> hashmap = new HashMap<>();
         for(int i=0;i<charArr.length;i++){
             hashmap.put(charArr[i] , val.get(i));
         }

         int count = num;
         int x=0;
         while (x<20){
             System.out.println("count is " + count);
             System.out.println("s is " + s);

             System.out.println("running " + x + " times");
             x++;
            if(count >=0 && count<=5){
              if(count==5){
                  s+='V';
              } else if (count==4) {
                  s+="IV";
                  break;
              }else  if(count==3){
                  s+="III";
                  break;
              }else  if(count==2){
                  s+="II";
                  break;
              }else  if(count==1){
                  s+="I";
                  break;
              }else {
                  break;
              }
            }else{
                int i=1;
                while (i<charArr.length && count>=val.get(i)){
                   i++;
                }
                System.out.println("founded at " + i);
                if(i==7){
                    s+=charArr[6];
                    count=count-val.get(6);
                    continue;
                }
                if(hashmap.get(charArr[i])==count){
                    s+=charArr[i];
                    break;
                }else{
                    int num1 = count -  (val.get(i)-val.get(i-2));
                    int num2= count - (val.get(i)-val.get(i-1));
                    System.out.println("num 1 is " + num1 + " and num 2 is " + num2);
                    if(num1<num2){
                         System.out.println(" is is " + i + " i-2 is " + charArr[i-2] + "");
                        s+= charArr[i-2].toString() +   charArr[i].toString() ;
                        count=count-(val.get(i) - val.get(i-2));

                    }else{
                        System.out.println("entered");
                        s+=charArr[i-1];
                        count=count-val.get(i-1);
                    }

                }
            }
         }
         return s;
    }


    String frequencySort(String s){
         String result = "";
         TreeMap<Character , Integer> hashmap = new TreeMap<>();
         for(int i=0;i<s.length();i++){
             if(hashmap.get(s.charAt(i))==null){
                 hashmap.put(s.charAt(i) , 1);
             }else{
                 hashmap.put(s.charAt(i) , hashmap.get(s.charAt(i)) + 1);
             }
         }

         TreeMap<Integer , List<Character>> temphashmap = new TreeMap<>(Collections.reverseOrder());

         for(Map.Entry<Character , Integer> entry : hashmap.entrySet()){
             System.out.println(entry.getKey() +":" + entry.getValue() );
             List<Character> list = new ArrayList<>();
             list.add(entry.getKey());
             if(temphashmap.get(entry.getValue())==null){

                 temphashmap.put(entry.getValue() , list);
             }else{
                  list = temphashmap.get(entry.getValue());
                  list.add(entry.getKey());
                    temphashmap.put(entry.getValue() , list);
             }
         }

         for(Map.Entry<Integer , List<Character>> entry : temphashmap.entrySet()){
             System.out.println(entry.getKey() +":" + entry.getValue() );
             if(entry.getKey()>1){
               for(int i=0;i<entry.getValue().size();i++){
                   for(int j=0;j<entry.getKey();j++){
                       result+=entry.getValue().get(i);
                   }
               }
             }else{
                 for(int i=0;i<entry.getValue().size();i++){
                     result+=entry.getValue().get(i);
                 }
             }
         }








         return result;
    }


    String reverseWords(String s){
         String result="";

         List<String> list = new ArrayList<>();
         String[] s1 = s.split(" ");
        PrintStringArray(s1);
         for(int i=0;i<s1.length;i++){
             String temp=s1[i].trim();
//             System.out.println("trim is" + temp+"k");
             if(temp.length()==0){
//                 i++;
             }else{
                 list.add(temp);

             }


         }
//         for(String str  : s1){
//             System.out.println(str + "/");
//         }
        Collections.reverse(list);
//         System.out.println(list);
         for(int i=0;i<list.size();i++){
             result+=list.get(i) + (i==list.size()-1 ? "" : " ");

         }

//         PrintStringArray(s1);
         return result;
    }


    private int numSquareHelper(int num){
         int result = 0;
         int index=2;
        if(num==0){
            return 0;
        }
        if(num<4 && num>0){
            return num;
        }



         while (Math.pow(index , 2)  <= num){
             index++;
         }

         System.out.println("index is" + (index-1));
         System.out.println("num is" + num);

         for(int i=index-1;i>=2;i--){
             int val = numSquareHelper(num - (int)Math.pow(i , 2));
             if(val==(num - (int)Math.pow(i , 2))){
                 if(val==0){
                     result+=1;
                 }else{
                     result+=val;
                 }

//                 return result;
             }else{
                 result = Math.max(result  , val+1);
             }

         }

         return result;
    }

    int[] twoSumII(int[] a ,int  target){
         int[] result = new int[2];

         int i=0;
         int j=a.length-1;
         while (i<j){
             int sum=a[i]+a[j];
             if(sum>target){
                 j--;
             } else if (sum<target) {
                 i++;
             }else {
                 result[0]=i+1;
                 result[1]=j+1;
                 break;
             }
         }

         return result;
    }

     int numSquares(int num){
         return numSquareHelper(num);
     }


     List<Integer> largestDivisibleSubsetHelper(int[] a , int index){

        if(index==a.length-1){
            return new ArrayList<>(Collections.singletonList(a[index]));
        }
        if(dpDoubleIntList.get(index).size()!=0){
            return dpDoubleIntList.get(index);
        }
        List<Integer> list  =  new ArrayList<>();
        List<Integer> templist  =  new ArrayList<>();

//        list.add(a[index]);
        for(int i=index+1;i<a.length;i++){
            List<Integer> l1 = largestDivisibleSubsetHelper(a , i);

        }
        if(templist.get(0)%a[index]==0){
            list.add(a[index]);
         }
        list.addAll(templist);

         dpDoubleIntList.get(index).addAll(list);
        return list;
     }
     List<Integer> largestDivisibleSubset(int[] a){
         for(int i=0;i<a.length;i++){
             dpDoubleIntList.add(new ArrayList<>());
         }
         Arrays.sort(a);
         PrintArray(a);
         return largestDivisibleSubsetHelper(a , 0);
     }

//     int minSubArrayLenHelper(int[] a , int index , int sum , int target){  //2,3,1,2,4,3
//
//     }
     int minSubArrayLen(int[] a ,int target){
         int i=0;
         int j=0;
         int sum=0;

         int min = Integer.MAX_VALUE;
          for(i=0;i<a.length;i++){

              if(a[i]>=target){
                   min=1;
                   break;
              }



              while (j<a.length && sum<target){
                  sum+=a[j];
                  j++;

              }
              if(sum>=target){
                  System.out.println("found at " + i + " and " + (j-1));
                  min = Math.min(min , j-i);

              }
              sum-=a[i];





          }
         return min;
     }

     boolean isValidSudoku(String[][] a){
//         PrintDoubleArray(a);
         PrintDoubleArrayString(a);

         boolean isvalid = true;

         HashSet<String> hashSet = new HashSet<>();

         outer : for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
                 if(a[i][j]!="."){
                     isvalid = isvalid && hashSet.add("row_"+i+"_"+a[i][j]);
                     System.out.println("row" + i  + " is "+ isvalid);
                     isvalid = isvalid && hashSet.add("col_"+j+"_"+a[i][j]);
                     System.out.println("col" + j + " is "+ isvalid);
                     isvalid = isvalid && hashSet.add("main_"+i/3+"_"+j/3+"_"+a[i][j]);
                     System.out.println("index" + i /3+  " " +  j/3 + " is "+ isvalid + " elm is" + a[i][j]);

//                     if(isvalid==false){
//                         break outer;
//                     }

                 }
             }
         }

         System.out.println(hashSet);

         return isvalid;
     }

     int[][] rotate48(int[][] a){
//         PrintDoubleArray(a);
//         int[][] result = new int[a.length][a[0].length];

//
//         for(int i=0;i<a.length;i++){
//             for(int j=0;j<a[i].length;j++){
//                 result[i][j] = a[j][a.length-1-i];
//             }
//         }
         int rows = a.length;
         int cols = a[0].length;

         for (int i = 0; i < rows; i++) {
             for (int j = i + 1; j < cols; j++) {
                 // Swap elements across the main diagonal
                 int temp = a[i][j];
                 a[i][j] = a[j][i];
                 a[j][i] = temp;
             }
         }
//         int[] temp = new int[a[0].length];
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length/2;j++){
                int temp = a[i][j];
                a[i][j] = a[i][a[i].length-1-j];
                 a[i][a[i].length-1-j] = temp;
             }
         }


         return a;
     }

    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> res = new ArrayList<>();
        int count=0;
        boolean down=false , left=false , up = false;
        boolean right=true;
        int i=a.length;
        int j=a[0].length;
        int m=0;
        int n=0;
        int top=0 , rightt=a[0].length-1 , downn=a.length-1 , leftf = a.length;
        outer :  while (count<a.length*a[0].length*2){


            while(right){
                System.out.println("index" + m +"" +n);
                count++;
               System.out.println(a[m][n]);
               n++;
               if(n==j){
                   System.out.println("enter");

                   n-=1;
                   j-=1;
                   m++;
                   right=false;
                   down=true;
                   continue outer;
               }
            }while(down){
                System.out.println("index" + m +"" +n);

                count++;
                System.out.println(a[m][n]);
               m++;
               if(m==i){
                   System.out.println("enter");
                   m-=1;
                   i-=1;
                   n--;
                   j--;
                   left=true;
                   down=false;
                   continue outer;
               }
            }while(left){
                System.out.println("index" + m +"" +n);

                count++;
                System.out.println(a[m][n]);
               n--;
               if(n==a[0].length-j-2){
                   System.out.println("enter");
                   n++;
                   i-=1;
                   m--;
                   up=true;
                   left=false;
                   continue outer;
               }
            }while(up){
                count++;
                System.out.println("index" + m +"" +n);

                System.out.println(a[m][n]);
               m--;
               if(m==a.length-i-2){
                   System.out.println("enter");
                 m++;
                 n++;
                 j-=1;
                 up=false;
                 right=true;
                   continue outer;
               }
            }

            count++;


        }
        return res;
    }

    int[][] setZeroes(int[][] a){
         int[][] result  = new int[a.length][a[0].length];
         HashSet<Integer> rows = new HashSet<>();
         HashSet<Integer> cols = new HashSet<>();
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
               if(a[i][j]==0){
                   rows.add(i);
                   cols.add(j);
               }
             }
         }
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
               if(rows.contains(i)){
                   a[i][j]=0;
               }if(cols.contains(j)){
                   a[i][j]=0;
               }
             }
         }

         System.out.println(rows);
         System.out.println(cols);
         return a;
    }

    public boolean isIsomorphic(String s, String t) {

        int map1[] = new int[200];
        int map2[] = new int[200];

        if (s.length() != t.length())
            return false;


        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;



        }
        return true;
    }

    int longestConsecutive(int[] a){
//        int st = 0;
//        int res = 0;
//        Arrays.sort(nums);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] - nums[i - 1] == 0) {
//                res = Math.max(res,1);
//                st++;
//            }
//            else if (nums[i] - nums[i - 1] != 1) {
//                st = i;
//            }else {
//                res = Math.max(res, i - st+1);
//            }
//        }
//        if(nums.length==0) return 0;
//        if(nums.length==1) return 1;
//        return res;

        Arrays.sort(a);
        int res=0;
        int st=0;
        for(int i=1;i<a.length;i++){   // 1 2 3 4 100 200
            if(a[i]-a[i-1] ==1){
               res =  Math.max(res , i-st+1);
            } else if (a[i]-a[i-1]==0) {
                st++;
            }else {
                st=i;
                res = Math.max(res , 1);
                System.out.println("max" + res);
            }
        }
        return res;
    }

    String minWindow(String s , String t){
         String result="";
         int start=0;
         int end=0;
         if(s==t){
             return s;
         }
         if(s.length()<t.length()){
             return "";
         }


         return result;
    }

    int[][] gameOfLife(int[][] a){
         int[][] res = new int[a.length][a[0].length];



        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
//                System.out.print(a[i][j] + "--->");
                int count=0;
                for(int m=i-1;m<=i+1;m++){
                    for(int n=j-1;n<=j+1;n++){

                        if(m>-1 && m<a.length && n>-1 && n<a[i].length){
                            if(m==i && n==j){
                                continue;
                            }
//                            System.out.print(a[m][n] + " ");
                            if(a[m][n]==1){
                                count++;
                            }
                        }
                    }
                }
                if(a[i][j]==0){
                    if(count==3){
                      res[i][j]=1;
                    }
                }else {
                    if(count==2 || count==3){
                        res[i][j]=1;
                    } else if (count>3) {
                        res[i][j]=0;
                    }else{
                        res[i][j]=0;
                    }
                }
//                System.out.println("");
            }
        }
         return res;
    }

    int missingNumber(int[] a){
         int num=0;
         int max=-1;
         for(int i=0;i<a.length;i++){
           max = Math.max(max , a[i]);
         }
         for(int i=0;i<max+1;i++){
             num = num^i;
         }
         System.out.println("max is" + max);
         System.out.println("num is" + num);
         for(int i=0;i<a.length;i++){
             num = num^a[i];
         }
         return num!=0 ? num : max+1;
    }

    public int removeDuplicates26(int[] a) {
        int index=1;
        int elm=a[0];



        for(int i=1;i<a.length;i++){
            if(elm==a[i]){
                continue;
            }else{
                elm=a[i];
                a[index]=a[i];
                index++;
            }
        }

        PrintArray(a);
        System.arraycopy(a , 0 , a , 0 , index+1 > a.length ? a.length  : index+1);



        return index;

    }
    public int removeDuplicates(int[] a) {

      int index=0;
      int count=0;
      int elm = a[index];

      for(int i=0;i<a.length;i++){
          if(count>=2){
              if(a[i]==a[i-1]){
                  continue;
              }

          }
          if(a[i]==elm){
              count++;
              a[index]=elm;
              index++;
          }else{
            count=0;
            a[index]=a[i];
            count++;
            index++;
            elm = a[i];
          }
      }

      PrintArray(a);
      System.arraycopy(a , 0 ,  a, 0 , index+1>a.length ? a.length : index+1);

      return index;
    }



    boolean isValid(String s){
         boolean res = true;
          Stack<Character> stack = new Stack<>();
          String s1 = "({[";
          String s2 = ")}]";
          for(int i=0;i<s.length();i++){
             if(s1.contains(s.charAt(i)+"")){
                stack.push(s.charAt(i));
             }else{
               Character elm = stack.peek();
               if(elm=='('){
                    if(s.charAt(i)==')'){
                        stack.pop();
                    }else{
//                        res = false;
//                        break;
                    }
               } else if (elm=='{') {
                   if(s.charAt(i)=='}'){
                       stack.pop();
                   }else{
//                       res = false;
//                       break;
                   }

               } else if (elm=='[') {
                   if(s.charAt(i)==']'){
                       stack.pop();
                   }else{
//                       res = false;
//                       break;
                   }
               }else{
                 res = false;
//                 break;
               }
             }
          }
          return stack.size()==0;
//         return false;
    }


    int findJudge(int[][] a){
         int num=0;

         Map<Integer , Integer> hashmap = new HashMap<>();
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a[i].length;j++){
                 hashmap.put(a[i][j] , 0);
             }
         }
         for(int i=0;i<a.length;i++){
            hashmap.remove(a[i][0]);
         }
         System.out.println(hashmap);

         if(hashmap.size()==0){
             return -1;
         }
         for(Map.Entry<Integer , Integer> entry : hashmap.entrySet()){
              num = entry.getKey();
         }

//         PrintIntList(list);



//        PrintIntList(list);

         return num;
    }


    List<String> summaryRanges(int[] a){
         List<String> res = new ArrayList<>();
         int i=0;
         while(i<a.length){
             int j=0;
             String s1 = Integer.toString(a[i]);
             while (i<a.length-1){
                 if(j==0 && i==a.length-1){
                     break;
                 }else if(a[i]+1 ==a[i+1]){
                     i++;
                     j++;
                 }else{
                     break;
                 }
             }
             if(j>0){
                 s1+="->" + Integer.toString(a[i]);
             }
             res.add(s1);
             i++;

         }
        return res;
    }

    int[][] merge56(int[][] a){


         int i=0;
         int j=0;
         int k=0;
         int s=0;
         while (i<a.length){
             while (i<a.length && a[i][0]<=a[j][1]){
                 if(a[i][1]>=a[j][1]){
                     j=i;
                 }
                 i++;
             }
             a[k][0]=a[s][0];
             a[k][1]=a[j][1];
             k++;
             j=i;
             s=i;
         }

        int[][] res = new int[k][2];
         for(int m=0;m<k;m++){
             for(int n=0;n<2;n++){
                 res[m][n]=a[m][n];
             }
         }
         return res;

    }


//    int[][] helperinsert(int[][] a , int index){
//
//    }
//    int[][] insert57(int[][] a , int[] newInt){    //{{1,2},{3,5},{6,7},{8,10},{12,16}}
//
//         int[][] tmp = new int[a.length+1][2];
//         int k=0;
//         int min=newInt[0];
//         int max=newInt[1];
//         boolean isinserted=false;
//         int index=0;
//         for(int i=0;i<a.length;i++) {
//
//             if (min <= a[i][0]) {
//                 tmp[k][0] = min;
//                 tmp[k][1] = max;
//                 k++;
//                 min = Integer.MAX_VALUE;
//                 isinserted = true;
//                 index=i-1;
//             }
//             tmp[k][0] = a[i][0];
//             tmp[k][1] = a[i][1];
//             k++;
//         }
//        if(!isinserted){
//            tmp[k][0]=min;
//            tmp[k][1]=max;
//            index=k;
//        }
//
//         return helperinsert(tmp , index);
//
//    }

       int findMinArrowShots(int[][] a){    //  {1 6} {2 8} {7 12} {10 16}
           int count=0;
         Arrays.sort(a, Comparator.comparingInt(arr->arr[0]));
         PrintDoubleArray(a);
         int prevend=a[0][1];
         int prevstart=a[0][0];
         int i=0;
         while (i<a.length){
             while (i<a.length && a[i][0]<=prevend){
                prevend = Math.min(prevend , a[i][1]);
                i++;
             }
             count++;
             if(i<a.length){
                 prevend=a[i][1];
//                 i++;
             }


         }


         return count;
       }

       String longestPalindrome(String s){
         if(s.length()==1){
             return s;
         }
         int count=1;
         int max=Integer.MIN_VALUE;
          String ans = "";
          String res = "";
          int left=0 ,  right=0 ,  mid=s.length()/2;
          for(int i=mid;i>=0&&left>=0;i--){
              count=1;
              left=i-1;
              right=i+1;
              res=s.charAt(i)+"";
              while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                  count++;
                  res+=s.charAt(right);
                  right++;
              }
              System.out.println(count);
              while (left>=0 && s.charAt(left)==s.charAt(i)){
                  count++;
                  res=s.charAt(left) + res;
                  left--;
              }
              while (left>=0 && right<s.length()){
                  if(s.charAt(left)==s.charAt(right)){
                      count+=2;
                      res = s.charAt(left) + res + s.charAt(right);
                      left--;
                      right++;
                  }else{
                      break;
                  }
              }
              if(count>=max){
                  max = Math.max(max, count);
                  ans = res;
              }
          }
          for(int i=mid+1;i<s.length()-1&&right<s.length();i++){
              count=1;
              left=i-1;
              right=i+1;
              res=s.charAt(i)+"";
              while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                  count++;
                  res+=s.charAt(right);
                  right++;
              }
              while (left>=0 && s.charAt(left)==s.charAt(i)){
                  count++;
                  res=s.charAt(left) + res;
                  left--;
              }
              while (left>=0 && right<s.length()){
                  if(s.charAt(left)==s.charAt(right)){
                      count+=2;
                      res = s.charAt(left) +res + s.charAt(right);
                      left--;
                      right++;
                  }else{
                      break;
                  }
              }
              if(count>=max){
                  max = Math.max(max, count);
                  ans = res;
              }
          }
          System.out.println(max);
          return ans;
       }

       List<String> helpeLletterCombinations(String s , int index , Map<Character , String > hashmap){
           List<String> list = new ArrayList<>();
           if(index==s.length()){
               list.add("x");
               return list;
           }
           List<String> tmp =  helpeLletterCombinations(s , index+1 , hashmap);
           if(index==s.length()-1){
             for(int i=0;i<hashmap.get(s.charAt(index)).length();i++){
                 list.add(hashmap.get(s.charAt(index)).charAt(i)+"");
             }
           }else{
               for(int i=0;i<hashmap.get(s.charAt(index)).length();i++){
                   for(int j=0;j<tmp.size();j++){
                       list.add(hashmap.get(s.charAt(index)).charAt(i) + tmp.get(j));
                   }
               }
           }
           return list;
       }
       List<String> letterCombinations(String s){
           if(s.length()==0){
               return new ArrayList<>();
           }
         Map<Character  , String> hashmap = new HashMap<>();
         hashmap.put('2' , "abc");
         hashmap.put('3' , "def");
         hashmap.put('4' , "ghi");
         hashmap.put('5' , "jkl");
         hashmap.put('6' , "mno");
         hashmap.put('7' , "pqrs");
         hashmap.put('8' , "tuv");
         hashmap.put('9' , "wxyz");

         return helpeLletterCombinations(s,0 , hashmap);
       }


       List<List<String>> dpgen = new ArrayList<>();

     public static void helpergenerateParenthesis(List<String> res,String curr,int open, int close,int n){
          if(curr.length()==2*n)
          {
              res.add(curr);
              return;
          }
          if(open<n)
          {
              helpergenerateParenthesis(res,curr+"(",open+1,close,n);
          }
          if(close<open)
          {
              helpergenerateParenthesis(res,curr+")",open,close+1,n);
          }
      }
       List<String> generateParenthesis(int n){
           ArrayList<String> res= new ArrayList<>();
           helpergenerateParenthesis(res,"",0,0,n);
           return res;
       }


        public static int search33Helper(int[] a , int start , int end , int elm){
            int index=-1;


            if(start<=end) {
                int mid=(start+end)/2;
                if(a[mid]==elm){
                    return mid;
                }
                if(a[mid]>=a[start]){
                    if(elm>=a[start] && elm<a[mid]){
                        index =  search33Helper(a , start , mid-1 , elm);
                    }else{
                        index =  search33Helper(a , mid+1 , end , elm);
                    }
                }else{
                    if(elm<a[mid] || elm>=a[start]){
                        index =  search33Helper(a , start , mid-1 , elm);
                    }else{
                        index = search33Helper(a , mid+1 , end , elm);
                    }
                }}
            return index;
       }
       int search33(int[] a , int elm){
         int res= search33Helper(a , 0 , a.length , elm);
         return res;
       }
       int[] searchRange(int[] a, int target){
         if(a.length==0){
           return new int[]{-1,-1};
         }
          int[] res = new int[2];
          int left=0 , right=a.length-1;
          int tempIndex=-1;

          while (left<=right){
             int mid = (left+right)/2;
             if(a[mid]==target){
               tempIndex=mid;
               break;
             }
             if(target<=a[mid]){
                 right=mid-1;
             }else{
                 left=mid+1;
             }
          }
         System.out.println(tempIndex);
         System.out.println(left);
         System.out.println(right);

         int index=tempIndex;
         int min=-1;
         int l=left;
         int r=tempIndex;
         while (l<=r){
//             if(a[l]==a[r]){
//                 min = l;
//             }
             int mid=(l+r)/2;
             if(a[mid]==target && a[mid-1]!=target){
                 min=l;
                 break;
             }


             if(target<=a[mid]){
                 r=mid-1;
             }else{
                 l=mid+1;
             }

         }
         l=tempIndex;
         r=right;
         int max=-1;
           while (l<=r){
//             if(a[l]==a[r]){
//                 min = l;
//             }
               int mid=(l+r)/2;
               if(a[mid]==target && a[mid+1]!=target){
                   max=mid;
                   break;
               }


               if(target<a[mid]){
                   r=mid-1;
               }else{
                   l=mid+1;
               }

           }
         System.out.println("min" + min);
         System.out.println("max" + max);

         res[0]=min;
         res[1]=max;
          return res;
       }

       int findMin(int[] a){
         int min = Integer.MAX_VALUE;
         int left=0;
         int right=a.length-1;

         while (left<=right){
             int mid = (left+right)/2;
             if(a[mid]>=a[left]){
                 min = Math.min(min , a[left]);
                 left=mid+1;
             }else{
                 min = Math.min(min , a[mid]);
                 right=mid-1;
             }
         }
         return min;
       }




       public static int[] reverseArray(int[] a  , int start , int end){
         System.out.println("yes");
         for(int i=start;i<start+(end-start+1)/2;i++){
             int temp = a[i];
             a[i] = a[end - (i-start)];
             a[end -(i-start)] = temp;
         }
         return a;
       }

       int[] nextPermutation(int[] a){
         int index=-1;
         for(int i=a.length-2;i>=0;i--){
             if(a[i]<a[i+1]){
                 index=i;
                 break;
             }
         }
         if(index==-1){
             reverseArray(a,0,a.length-1);
             return a;
         }else{
             System.out.println("indx is" + index);
             for(int i=a.length-1;i>=0;i--){
                 if(a[i]>a[index]){
                     int temp = a[index];
                     a[index]=a[i];
                     a[i]=temp;
                     break;
                 }
             }
             PrintArray(a);
             reverseArray(a , index+1 , a.length-1);

         }

           return a;

       }

       int[] sortColors(int[] a){

         int zeros=0,ones=0;
         for(int i=0;i<a.length;i++){
             if(a[i]==0){
                 zeros++;
             } else if (a[i]==1) {
                 ones++;
             }
         }

         int i=0;
         int j=1;
         while (j<=zeros){
             a[i]=0;
             i++;
             j++;
         }
         j=1;
         while (j<=ones){
            a[i]=1;
            i++;
            j++;
         }
         while (i<a.length){
             a[i]=2;
             i++;
         }

         return a;
       }


       int maxProfit(int[] arr){
           int maxPro = 0;
           int minPrice = Integer.MAX_VALUE;
           for (int i = 0; i < arr.length; i++) {
               minPrice = Math.min(minPrice, arr[i]);
               maxPro = Math.max(maxPro, arr[i] - minPrice);
           }
           return maxPro;
       }


       int[] repeatedAndMissing(int[] nums){
         int[] a = new int[nums.length+1];
         Arrays.fill(a,0);
         for(int i=0;i<nums.length;i++){
            a[nums[i]] = a[nums[i]]+1;
         }
         PrintArray(a);
         int[] res = new int[2];
         for(int i=1;i<a.length;i++){
             if(a[i]==0){
                 res[1]=i;
             } else if (a[i]>1) {
                  res[0]=i;
             }
         }
//           PrintArray(nums);
           return res;
       }

       int findFactorial (int n){
         if(n==1){
             return 1;
         }
         return n*findFactorial(n-1);
       }
//    public static long getInversions(long arr[], int n) {
//
//    }
//       int countInverstion(int[] a){  // 8,7,1,9,10,4,5
//         int count=0;
//         for(int i=0;i<a.length-1;i++){
//          for(int j=i+1;j<a.length;j++){
//              if(a[j]<a[i]){
//                  count+=1;
//              }
//          }
//         }
//
//         return count;
//       }


    public static int mergeSortHelpercountInvertionMeerge(int[] a , int low , int mid , int high){
         int count=0;
         int[] res = new int[a.length];
         int i=low;
         int j=mid+1;
         int k=low;
         while (i<=mid && j<=high){
             if(a[i]<a[j]){
                 res[k]=a[i];
                 i++;
                 k++;
             }else{
                 count+=(mid-low)+1;
                 System.out.println("yes");
                 res[k]=a[j];
                 j++;
                 k++;
             }
         }

         while (i<=mid){
             res[k]=a[i];
             k++;
             i++;
         }
        while (j<=high){
            res[k]=a[j];
            k++;
            j++;
        }

        for(int m=0;m<a.length;m++){
            a[m]=res[m];
        }

        return count;

    }



      public static int mergeSortHelpercountInvertion(int[] a , int low , int high){
         int count=0;
         if(low<high){
             int mid = (low+high)/2;
             count+= mergeSortHelpercountInvertion(a , low , mid );
             count+= mergeSortHelpercountInvertion(a , mid+1 , high);
             count+= mergeSortHelpercountInvertionMeerge(a , low , mid , high);
         }
        return   count;
     }
       int countInverstion(int[] a){  // 8,7,1,9,10,4,5

//         int count=0;

        int count =  mergeSortHelpercountInvertion(a , 0 , a.length-1);
        System.out.println(count);


         return count;
       }

       boolean searchMatrix(int[][] a , int target){
         boolean res = false;
         int index=-1;
         for(int i=0;i<a.length;i++){
             if(a[i][0]<=target && target<=a[i][a[i].length-1]){
                 index=i;
                 break;
             }
         }
         if(index==-1){
             return false;
         }

         for(int i=0;i<a[index].length;i++){
             if(a[index][i]==target){
                 res=true;
             }
         }
         System.out.println(index);
         return res;
       }

       double myPow(double x , int n){
         if(n==1){
             return x;
         }
         return x*myPow(x , n-1);
       }

       int majorityElement(int[] a){
         int count=0;
         int elm=a[0];
         for(int i=0;i<a.length;i++){
              if(a[i]==elm){
                 count++;
             }else{
                 count--;
             }
             if(count==0){
                 count=1;
                 elm=a[i];
             }
         }
         count++;
         for(int i=0;i<a.length;i++){
             if(a[i]==elm){
                 count++;
             }
         }
         if(count>a.length/2){
             return elm;
         }
         return count;
       }


       int[][] dp62;

    int uniquePathsHelper(int m , int n){

        if(dp62[m][n]!=-1){
            return dp62[m][n];
        }
        int count=0;
        // if(m==1 && n!=1 || n==1 && m!=1){
        //     return 0;
        // }
        if(m==1 && n==1){
            return 1;
        }
        if(m!=1){
            count+=uniquePathsHelper(m-1 , n);
        }
        if(n!=1){
            count+=uniquePathsHelper(m , n-1);
        }



        dp62[m][n]=count;
        return count;
    }



    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    int[]  mergeArrHelper(int[] a , int low , int mid , int high){
        int[] res = new int[a.length];

        int i=low;
        int j=mid+1;
        int k=low;
        while (i<=mid && j<=high){
            if(a[i]<a[j]){
                res[k]=a[i];
                i++;
            }else{

                res[k]=a[j];
                j++;
            }
            k++;
        }

        while (i<=mid){
            res[k]=a[i];
            i++;
            k++;
        }
        while (j<=high){
            res[k]=a[j];
            j++;
            k++;
        }

        for (int m = low; m <= high; m++) {
            a[m] = res[m];
        }

        return a;
    }


    int mergeArr(int[] a, int low , int high){
        int cnt=0;
        if(low<high){

            int mid=(low+high)/2;

            mergeArr(a , low , mid);
            mergeArr(a , mid+1 , high);
            cnt += countPairs(a, low, mid, high);
            mergeArrHelper(a , low , mid ,high);
        }
        return cnt;
    }
    int reversePairs(int[] a){
        int count=0;
        count = mergeArr(a , 0 , a.length-1);
        PrintArray(a);
        return count;
    }

       int uniquePaths(int m , int n){     //(3,7) (2,7) , (1,7) (1,6) , (1,5) , (1,4) , (1,3) , (1,2), (1,1)
           dp62 = new int[m+1][n+1];
           for(int i=0;i<dp62.length;i++){
               for(int j=0;j<dp62[i].length;j++){
                   dp62[i][j]=-1;
               }
           }
           return uniquePathsHelper(m,n);
       }

    public List<List<Integer>> fourSum(int[] a, int target) {


        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(a);
        int k , l;

        for(int i=0;i<a.length-3;i++){
            if(i>0 && a[i]==a[i-1]){
                continue;
            }
            for(int j=i+1;j<a.length-2;j++){
                if(j>i+1 && a[j]==a[j-1]){
//                    j++;
                    continue;
                }
                k=j+1;
                l=a.length-1;
                while (k<l){
                    int sum = a[i]+a[j]+a[k]+a[l];
                    if(sum==target){
                        List<Integer> l1 = new ArrayList<>();
                        l1.add(a[i]);
                        l1.add(a[j]);
                        l1.add(a[k]);
                        l1.add(a[l]);


                        while (k<l && a[k]==a[k+1]){
                            k++;
                        }
                        while (k<l && a[l]==a[l-1]){
                            l--;
                        }
                        k++;
                        l--;
                    } else if (sum<target) {
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        if(list.size()==0){
            list.add(new ArrayList<>());
        }

        return list;


    }

    int maxLen(int[] a){
        int max=Integer.MIN_VALUE;
        Arrays.sort(a);
        int sum=0;
        int st=0;
        int i=0;
        while (i<a.length){
            sum+=a[i];
            if(sum==0){
                max = Math.max(max , i-st+1);
                sum-=a[st];
                st++;
            } else if (sum>0) {
                while (sum>0 && st<a.length){
                    sum-=a[st];
                    st++;
                }
                if(sum==0){
                    max = Math.max(max , i-st+1);
                }
            }


        }
        return max;
    }

    int SubArrayWithXOR(int[] a , int b){
        int count=0;
        int exor=0;
        for(int i=0;i<a.length;i++){
            exor=0;
//            if((exor^a[i])==b){
//                count++;
//            }
            for(int j=i;j<a.length;j++){
               exor^=a[j];
               if(exor==b){
                   count++;
               }
            }
        }
        return count;
    }



    int getCommon(int[] a , int[] b){
        int result=-1;
       Map<Integer , Integer> hashmap = new HashMap<>();
       for(int i=0;i<a.length;i++){
           hashmap.put(a[i] , 1);
       }
       for(int i=0;i<b.length;i++){
           if(hashmap.get(b[i])!=null && hashmap.get(b[i])==1){
               result=b[i];
           }
       }

        return result;
    }



    int maxSubArray(int[] a){
        int sum=a[0];
        int max=a[0];


        for(int i=1;i<a.length;i++){
            sum+=a[i];
            if(a[i]>sum){
                sum=a[i];
            }
            max = Math.max(sum , max);
        }


        return max;
    }



    int[][] generateMatrix(int n){
        int[][] rs = new int[n][n];
        int i=0,j=n-1,k=n-1,l=0;
        int x=1;
        int p=0,q=0;
        while (true){

            while (q<=j){
                rs[p][q]=x;
                System.out.println(rs[p][q]);
                x++;
                q++;
            }
            if(k-i==0){
                break;
            }
//            x--;
            i++;
            p=i;
            q--;

            while (p<=k){
               rs[p][q]=x;
                System.out.println(rs[p][q]);
               x++;
               p++;
            }
            if(j-l==0){
                break;
            }
            j--;
            p--;
            q--;
            while (q>=l){
                rs[p][q]=x;
                System.out.println(rs[p][q]);
                x++;
                q--;
            }
            if(k-i==0){
                break;
            }
            k--;
            p--;
            q++;
            while (p>=i){
                rs[p][q]=x;
                System.out.println(rs[p][q]);
                x++;
                p--;
            }
            if(j-l==0){
                break;
            }
            l++;
            q++;
            p++;

//            System.out.println((j-l)+"0" +   (k-i));


        }
        return rs;
    }


//    int[] intersection(int[] a , int[] b){
//        int k=0;
//        int i=0 , j=0;
//        int[] res = new int[Math.min(a.length , b.length)];
//        Set<Integer> hashset = new HashSet<>();
//        for(int p=0;p<a.length;p++){
//            hashset.add(a[p]);
//        }
//        for(int p=0;p<b.length;p++){
//            if(hashset.contains(b[p])){
//                res[k]=b[p];
//                k++;
//                System.out.println(b[p]);
//                hashset.remove(b[p]);
//            }
//
//        }
//        System.arraycopy(a , 0 , a , 0 , k);
//        return Arrays.copyOf(res , k);
//    }


    int[] intersection(int[] a , int[] b){
        int k =0;
        int i=0,j=0;
        int[] res = new int[Math.min(a.length , b.length)];

        return res;
    }


    public  static  Listnode middleNode(Listnode start){
        Listnode slow=start;
        Listnode fast=start;

        while (fast.next!=null && fast!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static Listnode rotateLinkedList(Listnode head  , int k){
        Listnode start = reverseListNode(head);
        Listnode prev = null;
        Listnode curr = start;

        while (k!=0){
         Listnode nextNode =  curr.next;
         curr.next=prev;
         prev=curr;
         curr=nextNode;
         k--;
        }
        start = reverseListNode(curr);
        curr=prev;
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next=start;


        return prev;

    }


    public static List<Integer> subsetSumsHlpr(int[] a ,int i ,  List<Integer> l1){
        if(i==a.length-1){
            l1.add(a[i]);
            return l1;
        }
        int sum=a[i];
        int sum2=a[i];
        l1.add(sum);
        for(int j=i+1;j<a.length;j++){
            sum2 = sum2+a[j];
            l1.add(sum2);
            if(!l1.contains(sum+a[j])){
                l1.add(sum+a[j]);
            }

        }

        return subsetSumsHlpr(a , i+1 , l1);
    }


//    List<Integer> subsetSums(int[] a){
//        List<Integer> list = new ArrayList<>();
//        return list;
//    }


//    List<List<Integer>> subsetsWithDupHlpr(int[] a , int i , List<List<Integer>> list , List<Integer> l1){
//
//    }
//    List<List<Integer>> subsetsWithDup(int[] a){
//
//    }

    public  static   void subsetsHelper(int[] a , int ind , List<List<Integer>> list ,   List<Integer> l1){

     if(ind==a.length){
         if(!list.contains(l1)){
             list.add(new ArrayList<>(l1));
         }

         return ;
     }


     if(ind<a.length){
         l1.add(a[ind]);

         subsetsHelper(a , ind+1 , list , l1);
         l1.remove(l1.size()-1);
     }
        subsetsHelper(a , ind+1 , list , l1);





    }


    List<List<Integer>> subsets(int[] a){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
         subsetsHelper(a , 0 , list ,l1);
        return list;
    }


//    private static void backtrackgetParmutation(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
//        if (tempList.size() == nums.length) {
//            result.add(new ArrayList<>(tempList));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (tempList.contains(nums[i])) continue; // Skip already used elements
//                tempList.add(nums[i]);
//                backtrack(nums, tempList, result);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }


//    List<String> getParmutation(int n , int k){
//
//    }


    int singleNonDuplicateHelper(int[] a , int low , int high){    // 1,1,2,3,3,4,4,8,8
                                                                   //  3,3,7,7,10,11,11
        System.out.println(low + " " + high);

        if(high-low!=2){

            int mid = (low+high)/2;
            if(a[mid]!=a[mid-1] && a[mid]!=a[mid+1]){
                return a[mid];
            }
            if(mid%2==0){
                if(a[mid]==a[mid-1]){
                    high=mid;
                }else {
                    low=mid;
                }
            }else {
               if(a[mid]==a[mid-1]){
                    low =  mid+1;
                }else {
                    high=mid-1;
                }
            }

            return singleNonDuplicateHelper(a , low , high);
        }
        if(a[low]==a[low+1]){
            return a[high];
        }else {
            return a[low];
        }



    }

    int findKthLargest(int[] a , int k){
        PriorityQueue<Integer>pq= new PriorityQueue<>((s,t)->t-s);   // it returns the element in
        for(int i=0;i<a.length;i++){
            pq.add(a[i]);
        }
        int f=k-1;

        while (f!=0){
           pq.remove();
           f--;
        }
        return pq.peek();
    }

      int singleNonDuplicate(int[] a){
        return singleNonDuplicateHelper(a , 0 , a.length-1);
      }

      int[] nextGreaterElement(int[] a , int[] num){  
        Map<Integer , Integer> hashmap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] rs = new int[num.length];
        for(int i=a.length-1;i>=0;i--){

            while (!stack.isEmpty() && stack.peek()<a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                hashmap.put(a[i] , -1);
                stack.push(a[i]);
                continue;
            }

                hashmap.put(a[i] , stack.peek());
                 stack.push(a[i]);
        }
        for(int i=0;i<num.length;i++){
            rs[i] = hashmap.get(num[i]);
        }

        return rs;
      }

      int[] nextSmallerElement(int[] a , int[] num){    // 34, 35, 27, 42, 5, 28, 39, 20, 28
        int[] rs = new int[num.length];

        Stack<Integer> stak = new Stack<>();
        int k=0;
        for(int i=0;i<a.length;i++){
            while (!stak.isEmpty() && stak.peek()>=a[i]){
                stak.pop();
            }
            if(stak.isEmpty()){
                stak.push(a[i]);
                rs[k] = -1;
                k++;
                 continue;
            }
            rs[k]=stak.peek();
            k++;
            stak.push(a[i]);

        }
//        for(int i=0;i<num.length;i++){
//            rs[i] = hashmap.get(num[i]);
//        }
        return rs;
      }

      int repeatedStringMatch(String s1 , String s2){   // ced

        if(s1.contains(s2)){
            return 1;
        }



        int rs = 1;
        String s = s1;

          for(int i=0;i<s2.length();i++){
              if(!s.contains(s2)){
                  rs++;
                  s = s+s1;
              }else {
                  break;
              }
          }
        return s.contains(s2) ? rs : -1;
      }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        1


//        2 roman to integer
//        to find roman to integer we will first store the value of last element and after then we will compare with
//        right element one by one if current element is bigger and equal to right then we will add to the result else we will subtract from result


//        System.out.println("Enter the Roman Number");
//        String s1 = sc.nextLine();
//        Leetcode L1 = new Leetcode();
//        int result = L1.romanToInt(s1);
//        System.out.println("The Number is" + result);



//        3 valid Parentheses
//
//        System.out.println("Enter the Roman Number");
//        String s1 = sc.nextLine();
//        Leetcode L1 = new Leetcode();
////        String s1 = "{[]}";
//        String s1 = "}";
//        boolean output = L1.checkIsValid(s1);
//        System.out.println(output);

//        4  palindrome
//        System.out.println("Enter the number to test palindrome");
//        int num = sc.nextInt();
//        Leetcode L1 = new Leetcode();
//       boolean result = L1.isPalindrome(num);
//        System.out.println(result);

//        5 longest common prefix
//
//        String[] s1 = {  "interstellar" , "interract" ,  "in"};
//        String result = longestCommonprefex(s1);
//        System.out.println(result + " is common in all elements");

//        6  stock problame
//          int[] buyPrice = {10 , 8 , 11 , 4};
//          int[] futurePrice = {7 , 8 , 13 , 5};
//          int maxPrice = 350;
//          HashMap<Integer , Integer> HMAP = new HashMap<>();
//          Leetcode L1 = new Leetcode();
//          HMAP =L1.getBestProfitableStock(maxPrice , buyPrice , futurePrice);
//          System.out.println(HMAP);

//        7   check valid paranthesis
//           String s1 = "({}[]()()({})]";
//           Leetcode L1 = new Leetcode();
//           Boolean isValid = L1.CheckValidParanthesis(s1);
//           System.out.println(isValid);


//        8  merge two sorted array
//             int[] a = {1 , 5 , 7 ,9};
//             int[] b = {1 , 3 , 5 ,14};
//             Leetcode L1 = new Leetcode();
//             int[] result = L1.mergeTwoSortedArray(a ,b);
//             PrintArray(result);

//        9  remove duplicates from sorted array
//             int[] a = {1 , 5 , 5 ,5 , 7 ,9 , 9 , 10 , 15 , 17 , 20 , 20};
//             Leetcode L1 = new Leetcode();
//             int[] result = L1.removeDuplicateFromSortedArray(a);
//             PrintArray(result);

//        10  remove the element
//             int[] a = {1 , 5 , 5 ,5 , 7 ,9 , 10 , 15 , 17 , 20 };
//             Leetcode L1 = new Leetcode();
//             int[] result = L1.removeElement(a , 5);
//             PrintArray(result);

//          11. Find the Index of the First Occurrence in a String
//            String haystack = "sadbutsad";
//            String needle = "sad";
//            Leetcode L1= new Leetcode();
//            int result = L1.indexofFirstOccurence(haystack , needle);
//            System.out.println(result);

//          12 searchInsert in sorted array
//            int[] a = {1 , 4 , 7 ,9 , 10 , 15 , 17 , 20 };
//            Leetcode L1 = new Leetcode();
//            int result = L1.searchInsert(a , 16);
//            System.out.println(result);

//           13  find lenght of last word in a string
//               String s1 = "  my name is mehul i am a software devloper";
//               Leetcode L1 = new Leetcode();
//               int result = L1.findLenghtOfLastWord(s1);
//               System.out.println(result);




//           15  add binary
//                 int a = 1010;
//                 int b = 110;
//                 Leetcode L1 = new Leetcode();
//                 int result = L1.addBinary(a,b);
//                 System.out.println(result);

//           16  findSquareRoot
//                    int a = 1010;
//                    int b = 110;
//                    Leetcode L1 = new Leetcode();
//                    int result = L1.SQRT(18);
//                    System.out.println(result);

//            4    median of two sorted array

//                     int[] a = { 1 , 6 , 9};
//                     int[] b = { 2 , 5};
//                     Leetcode L1 = new Leetcode();
//                     int result = L1.medianOfTwoSortedArray(a,b);
//                     System.out.println(result);

//          11     container with most water
//                   int [] a = {1,8,6,2,5,4,8,3,7};
////                   int [] a = {1 , 2 , 4 , 3};
//                   Leetcode L1 = new Leetcode();
//                   int result = L1.containerWithMostWater(a);
//                   System.out.println(result);

//           26     remove duplicates from sorted array
//                    int[] a = {0,0,1,1,1,2,2,3,3,4};
////                    int[] a = {1 , 1 ,2};
//                    Leetcode L1 = new Leetcode();
//                    int result = L1.removeDuplicateFromSortedArray(a);
//                    System.out.println("the result is : " + result);

//           66   plus one

//                  int[] a  = {9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0};
//                  int[] a  = {9};
//                  Leetcode L1 = new Leetcode();
//                  int[] result  = L1.plusOne(a);
//                  PrintArray(result);



//        21   merge two sorted lists
//            int[] a = { 1 , 5 , 9};
//            int[] b = { 1 , 2 , 10};
//            Leetcode L1 = new Leetcode();
//
//            Listnode l1 = createListnode(a);
//            Listnode l2 = createListnode(b);
//
//
//            Listnode result = L1.mergeSortedListnode(l1 , l2);
//            PrintListnode(result);

//         22 remove duplicates from sorted lists
//             int[] a = { 1 , 1 , 2 , 2 , 2, 3 , 3 , 4 , 4 , 4 };
//           int[] a = { 1 , 1 , 2 };
//             Leetcode L1 = new Leetcode();
//             Listnode l1 = createListnode(a);
//             Listnode result = L1.removeDuplicatesFromsortedList(l1);
//             PrintListnode(result);


//        110 pascles triangle
//             int NoOfRows = 5;
//             Leetcode L1 = new Leetcode();
//             List<List<Integer>> result = L1.MakePasclesTriangle(NoOfRows);
//             PrintDoublyList(result);


//          2000 find single number
//               int[] a = { 2 , 2 , 4 , 4 , 3  , 1 , 1};
//               Leetcode L1 = new Leetcode();
//               int result = L1.findSingleNumber(a);
//               System.out.println(result);

//         202  happy number;
//             int num=2;
////             int num=19;
//             Leetcode L1 = new Leetcode();
//             boolean result = L1.CheckHappyNumber(num , num , new ArrayList<>());
//             System.out.println(result);


//             205   isomorphic string

//              String s1 = "paper";
//              String s2 = "title";
//              Leetcode L1 = new Leetcode();
//              boolean result = L1.isIsomorphic(s1  , s2);
//              System.out.println(result);

//            206  Reverse Linked List
//                   int[] a = {1 , 2 , 3 , 4 , 5};
//                   Listnode l1 =  createListnode(a);
//                   Listnode l2 = reverseListNode(l1);
//                   PrintListnode(l2);

//            234  palindrome linkedlist
//                   int[] a = {1 , 1 ,  2 , 1};
//                   Listnode l1 = createListnode(a);
//                   boolean result =  checkPalindromeLinkedList(l1);
//                   System.out.println(result);


//              868  Transpose Matrix
//                    int[][] metric = { { 1 , 2 , 3} , {4,5,6} , {7 , 8 , 9}};
//                    Leetcode L1  = new Leetcode();
//                    int[][] result = L1.getTransposeMetric(metric);
//                    PrintDoubleArray(result);


//               242. Valid Anagram
//                     String s = "anagram", t = "nagaram";
//                     Leetcode L1 = new Leetcode();
//                     boolean result = L1.isAnagram(s1 , s2);


//              383. Ransom Note
//                 String s1 = "aa";
//                 String s2 = "aab";
//        Leetcode L1 = new Leetcode();
//                 boolean result = L1.canConstruct(s1 , s1);
//                 System.out.println(result);


//          1582. Special Positions in a Binary Matrix

//               int[][] a = { { 1 ,0 , 0} , {0 , 0 , 1} , {1 , 0 , 0}};
//               int[][] a = {{1,0,0},{0,1,0},{0,0,1}};
//               int[][] a = {{0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,0,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0}};

//        Leetcode L1 = new Leetcode();
//               int result = L1.numSpecial(a);
//               System.out.println(result);


//            374. Guess Number Higher or Lower



//           387. First Unique Character in a String
//             String s = "leetcode";
//             String s = "loveleetcode";
//             Leetcode L1 = new Leetcode();
//             int result = L1.firstUniqChar(s);
//             System.out.println(result);

//        2482. Difference Between Ones and Zeros in Row and Column

//        int[][] arr = {{0,1,1},{1,0,1},{0,0,1}};
//        Leetcode L1 = new Leetcode();
//        int result[][]  =L1.onesMinusZeros(arr);
//        PrintDoubleArray(result);


//        1436. Destination City

//        String[][] a = {{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}};
//
//        Leetcode L1= new Leetcode();
//          String result = L1.destCity(a);
//          System.out.println(result);


//        389. Find the Difference
//          String s = "abcd", t = "abcde";
//          Leetcode L1 = new Leetcode();
//          char result = L1.findTheDifference(s ,t);
//          System.out.println(result);

//        242. Valid Anagram
//           String s = "anagram", t = "nagaram";
//           Leetcode L1 = new Leetcode();
//           boolean result = L1.isAnagram(s , t);
//           System.out.println(result);

//        1913. Maximum Product Difference Between Two Pairs

//          int[] a = {5,6,2,7,4};
//          Leetcode L1 = new Leetcode();
//          int result = L1.maxProductDifference(a);
//          System.out.println(result);

//        661. Image Smoother

//            int[][] img =  {{1,1,1},{1,0,1},{1,1,1}};
//              int[][] img = {{ 1,2,3} , { 4 , 5 , 6} , { 7 , 8 , 9}};
//              int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
//            Leetcode L1 = new Leetcode();
//            int[][] result =  L1.imageSmoother(img);
//            PrintDoubleArray(result);



//        448  Find All Numbers Disappeared in an Array
//            int[] a = {4,3,2,7,8,2,3,1};
//            Leetcode L1 = new Leetcode();
//            List<Integer> result = L1.findDisappearedNumbers(a);
//            for(int i=0;i<result.size();i++){
//                System.out.println(result.get(i));
//            }

//        2706. Buy Two Chocolates
//             int[] a = {1 , 2 , 3};
//             int money =3;
//             Leetcode L1 = new Leetcode();
//             int result = L1.buyChoco(a,money);
//             System.out.println(result);


//        459. Repeated Substring Pattern
//              String s1 = "abab";
//              String s1 = "aba";
//              String s1 = "abcabcabcabc";
//              String s1 = "abaababaab";
//              String s1 = "ababba";
//              String s1 = "bb";
//              String s1 = "abcdab";
//              String s1 = "babbabbabbabbab";
//              String s1 = "zzz";
//                Leetcode L1 = new Leetcode();
//                boolean result = L1.repeatedSubstringPattern(s1);
//                System.out.println(result);

//        1637. Widest Vertical Area Between Two Points Containing No Points
//                int[][] a  = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
////                int[][] a  = {{8,7},{9,9},{7,4},{9,7}};
//                 Leetcode L1 = new Leetcode();
//                 int result = L1.maxWidthOfVerticalArea(a);
//                 System.out.println(result);



//        476. Number Complement
//          int num = 5;
//          int num = 1;
//          Leetcode L1 = new Leetcode();
//          int result=L1.findComplement(num);
//          System.out.println(result);



//        1422. Maximum Score After Splitting a String
//          String s1 = "011101";
//          String s1 = "00111";
//          Leetcode L1 = new Leetcode();
//          int result=L1.maxScore(s1);
//          System.out.println(result);


//        463. Island Perimeter
//           int[][] a = {{0,1,0,0},{1,1,1,0} , {0,1,0,0},{1,1,0,0}};
//           Leetcode L1 = new Leetcode();
//           int result = L1.islandPerimeter(a);
//           System.out.println(result);

//        461. Hamming Distance
//              int x = 1, y=4;
//              Leetcode L1 = new Leetcode();
//              int result = L1.hammingDistance(x,y);
//              System.out.println(result);



//        492. Construct the Rectangle
//               int area = 4;
//               int area = 37;
//               int area = 122122;
//               Leetcode L1 = new Leetcode();
//               int[] result = L1.constructRectangle(area);
//               PrintArray(result);


//        1496. Path Crossing
//              String s = "NES";
//              String s = "NESWW";
//              String s = "S";
//              String s = "NEEEEEEEEEENNNNNNNNNNWWWWWWWWWW";
//              Leetcode L1 = new Leetcode();
//              boolean result = L1.isPathCrossing(s);
//              System.out.println(result);

//         482. License Key Formatting
//           String  s = "5F3Z-2e-9-w";
//           int k = 4;
//           String  s = "2-5g-3-j";
//           int k = 2;
//           Leetcode L1 = new Leetcode();
//           String result = L1.licenseKeyFormatting(s,k);
//           System.out.println(result);

//        485. Max Consecutive Ones
//              int[] nums= {1,1,0,1,1,1};
//              int[] nums= {1,0 ,1 ,1 ,0 ,1};
//              Leetcode L1 = new Leetcode();
//              int result = L1.findMaxConsecutiveOnes(nums);
//              System.out.println("maximum ones is" + result);

//        495. Teemo Attacking
//               int[] a = {1,4};
//               int duration=2;
////               int[] a = {1,3,5,7,9,11,13,15};
////               int duration=3;
//               Leetcode L1 = new Leetcode();
//               int result = L1.findPoisonedDuration(a,duration);
//               System.out.println(result);


//        496. Next Greater Element I
//              int[] nums1 = {4,1,2};
//              int[] nums2 = {1,3,4,2};
//              Leetcode L1 = new Leetcode();
//              int[] result = L1.nextGreaterElement(nums1 , nums2);
//              PrintArray(result);

//        1758. Minimum Changes To Make Alternating Binary String
////              String s = "0100";
//              String s = "10010100";
////              String s = "10";
////              String s = "1111";
//                Leetcode L1 = new Leetcode();
//                int result1 = L1.minOperations(s);
//                System.out.println(result1);

//        500. Keyboard Row
//           String[] words  = {"Hello","Alaska","Dad","Peace"};
//           Leetcode L1 = new Leetcode();
//           String[] result = L1.findWords(words);
//           for(int i=0;i<result.length;i++){
//               System.out.println(result[i]);
//           }

//        504. Base 7
//          int num =  100;
//          int num =  -7;
//          Leetcode L1 = new Leetcode();
//          String result = L1.convertToBase7(num);
//          System.out.println(result);

//        506. Relative Ranks
//          int[] score = {5,4,3,2,1};
//          int[] score = {10,3,8,9,4};
//          Leetcode L1 = new Leetcode();
//          String[] result = L1.findRelativeRanks(score);
//        PrintStringArray(result);

//        91. Decode Ways
//            String s = "12";
//            String s = "226";
//            String s = "2565";
//            String s = "06";
//            String s = "10";
//            String s = "2101";
//            String s = "1201234";
//              Leetcode L1  = new Leetcode();
//              int result = L1.numDecodings(s);
//              System.out.println("result is " + result);

//         1578   Minimum Time to Make Rope Colorful
//            String color = "abaac";
//            int[] time  ={1,2,3,4,5};
//            String color = "aabaa";
//            int[] time  ={1,2,3,4,1};
//            Leetcode L1 = new Leetcode();
//            int result = L1.minCost(color , time);
//            System.out.println(result);

//        2. Add Two Numbers
//              int[] a = {9,9,9,9,9,9,9};
//              int[] b = {9,9,9,9};
//              int[] a = {2,4,3};
//              int[] b = {5,6,4};
//              int[] a = {2,4,9};
//              int[] b = {5,6 , 4 , 9};
//              Listnode l1 = createListnode(a);
//              Listnode l2 = createListnode(b);
//              Listnode l3 = sumOfTwoListNode(l1, l2);
//              PrintListnode(l3);

//            1531 String Compression II
//               String s = "aaabcccd";
//               int k=2;
//               String s = "aabbaa";
//               int k=2;
//               String s = "aaaaaaaaaaa";
//               int k=0;
//               String s = "abc";
//               int k=2;

//               Leetcode L1 = new Leetcode();
//               int result = L1.getLengthOfOptimalCompression(s,k);
//               System.out.print(result);



//        2   add to numbers
//            int[] a ={9,9,9,9,9,9,9};
//            int[] b ={9,9,9 ,9};
//            Listnode l1 = createListnode(a);
//            Listnode l2 = createListnode(b);
//            Listnode l3 = addTwoNumbers(l1 , l2);
//            PrintListnode(l3);


//        1335. Minimum Difficulty of a Job Schedule
//                int num=28;
//                int num=7;
//                  int num=6;
//                  int num=1;
//                Leetcode L1 = new Leetcode();
//                boolean result = L1.checkPerfectNumber(num);
//                System.out.print(result);

//        temp  find all posible factors


//       1624 Largest Substring Between Two Equal Characters
//             String s = "abca";
//             Leetcode L1 = new Leetcode();
//             int result = L1.maxLengthBetweenEqualCharacters(s);
//             System.out.println(result);

//        455. Assign Cookies
//               int[] g = {1,2,3};
//               int[] s = {1,1};
//               int[] g = {1,2};
//               int[] s = {1,2,3};
//               int[] g = {1,2 , 3};
//               int[] s = {3};
//               Leetcode L1 = new Leetcode();
//               int result = L1.findContentChildren(g,s);
//               System.out.println(result);

//        3. Longest Substring Without Repeating Characters
//             String s = "pwwkew";
//             String s = "abcabcbb";
//             String s = "   ";
//               String s = "au";
//               String s = "aab";
//               String s = "cdd";
//               String s = "abba";
//             Leetcode L1 = new Leetcode();
//             int result = L1.lengthOfLongestSubstring(s);
//             System.out.println(result);

//         520. Detect Capital
//              String s = "FlaG";
//              String s = "Leetcode";
//              Leetcode L1 = new Leetcode();
//              boolean result = L1.detectCapitalUse(s);
//              System.out.println(result);

//         2610. Convert an Array Into a 2D Array With Conditions
//                int[] nums = {1,3,4,1,2,3,1};
//                Leetcode L1 = new Leetcode();
//                List<List<Integer>> list = L1.findMatrix(nums);
//                PrintDoublyList(list);

//         6. Zigzag Conversion
//              String s = "PAYPALISHIRING";
//              String s = "AB";
////              int numRows=3;
//              int numRows=1;
////              int numRows=3;
//              Leetcode L1 = new Leetcode();
//              String result = L1.convert(s , numRows);
//              System.out.println(result);


//        2125. Number of Laser Beams in a Bank
//                String[] s = {"011001","000000","010100","001000"};
//                Leetcode L1 = new Leetcode();
//                int result = L1.numberOfBeams(s);
//                System.out.println(result);


//        15. 3Sum
//             int[] nums = {-1,0,1,2,-1,-4};
//             Leetcode L1 = new Leetcode();
//             List<List<Integer>>  result = L1.threeSum(nums);
//             PrintDoublyList(result);


//        [2,3,3,2,2,4,2,3,4]
//          int[] nums = {2,3,3,2,2,4,2,3,4};
//          int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
//          int[] nums = {19,19,19,19,19,19,19,19,19,19,19,19,19};
//          int[] nums = {3,14,3,14,3,14,14,3,3,14,14,14,3,14,14,3,14,14,14,3};
//          int[] nums = {240,174,240,174,174,174,297,174,297,174,297,240,297,240,240,174,240,174,174,174,297,297,174,174,297,297,174,297,297,297,297,297,297,297,297,297,240,174,174,174,297,297,174,174,174,297,240,174,174,297,174,297,174,174,174,174,174,240,174,174,174,174,174,174,174,174,297,174,297,174,297,240,174,297,240,297,174,174,297,297,297,297,174,174,174,174,174,174,240,240,297,297,174,174,174};
//          Leetcode L1 = new Leetcode();
//          int result = L1.minOperations(nums);
//          System.out.println(result);

//        17. Letter Combinations of a Phone Number
//               String s = "23";
//               Leetcode L1 = new Leetcode();
//               List<String> list = L1.letterCombinations(s);


//        1704. Determine if String Halves Are Alike
//            String s = "book";
//            String s = "textbook";
//            Leetcode L1 = new Leetcode();
//            boolean result = L1.halvesAreAlike(s);
//            System.out.println(result);

//        1347. Minimum Number of Steps to Make Two Strings Anagram
//             String s = "leetcode";
//             String t = "practice";
////             String s = "anagram";
////             String t = "mangaar";
//             Leetcode L1 = new Leetcode();
//             int result = L1.minSteps(s,t);
//             System.out.println(result);


//        2225. Find Players With Zero or One Losses
//             int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
//             Leetcode L1 = new Leetcode();
//             List<List<Integer>> list = L1.findWinners(matches);
//             PrintDoublyList(list);

//        19  Remove Nth Node From End of List
//             int[] a = {1,2,3,4,5};
//             int n = 2;
//             Listnode l1 =  createListnode(a);
//
//             Listnode result = removeNthFromEnd(l1 , n);
//             PrintListnode(result);

//        8  String to Integer (atoi)
//              String s="4193 with words";
//              Leetcode L1 = new Leetcode();
//              int result = L1.myAtoi(s);
//              System.out.println(result);

//        1207. Unique Number of Occurrences
//             int[] a = {1,2,2,1,1,3};
//             Leetcode L1 = new Leetcode();
//             boolean result = L1.uniqueOccurrences(a);
//             System.out.println(result);

//        70. Climbing Stairs
//              int n=45;
//              Leetcode L1 = new Leetcode();
//              int result = L1.climbStairs(n);
//              System.out.println(result);

//        15. 3Sum
//             int[] a = {-1,0,1,2,-1,-4};
//             Leetcode L1 = new Leetcode();
//             List<List<Integer>> list  = L1.threeSum(a);
//             PrintDoublyList(list);

//        521. Longest Uncommon Subsequence I
//           String s1="abc";
//           String s2="cdc";
//           Leetcode L1 = new Leetcode();
//           int result = L1.findLUSlength(s1,s2);
//           System.out.println(result);

//        931 Minimum Falling Path Sum
//              int[][] a = {{2,1,3},{6,5,4} , {7,8,9}};
//              Leetcode L1 = new Leetcode();
//              int result = L1.minFallingPathSum(a);
//              System.out.println(result);

//        55. Jump Game
//              int[] a = {2,3,1,1,4};
////              int[] a = {2,0};
////              int[] a = {3,2,1,0,4};
//              Leetcode L1 = new Leetcode();
//              boolean result = L1.canJump(a);
//              System.out.println(result);

//        45. Jump Game II
//              int[] a = {2,3,1,1,4};
//              int[] a = {2,0,2,4,6,0,0,3};
////              int[] a = {1,2,3};
//              Leetcode L1 = new Leetcode();
//              int result = L1.countMinJump(a);
//              System.out.println(result);

//        150. Evaluate Reverse Polish Notation
//               String[] a = {"2","1","+","3","*"};
//               String[] a = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//               Leetcode L1 = new Leetcode();
//               int result = L1.evalRPN(a);
//               System.out.println(result);

//        1291. Sequential Digits
//                int low=1000;
//                int high=13000;
//                Leetcode L1 = new Leetcode();
//                List<Integer> result = L1.sequentialDigits(low , high);
//                PrintIntList(result);

//        1043. Partition Array for Maximum Sum
//                int[] a={1,4,1,5,7,3,6,1,9,9,3};
////                int[] a={1,15,7,9,2,5,10};
//                Solution L1 = new Solution();
//                int result = L1.maxSumAfterPartitioning(a,4);
//                System.out.println(result);


//        274. H-Index
//                int[] a ={3,0,6,1,5};
//                int[] a ={1,3,1};
//                int[] a ={0 , 0 , 4 , 4};
////                int[] a ={0};
//                Leetcode L1 = new Leetcode();
//                int result = L1.hIndex(a);
//                System.out.println("result is " + result);

//        238   Product of Array Except Self
//                int[] a = {1,2,3,4};
//                Leetcode L1 = new Leetcode();
//                int[] result = L1.productExceptSelf(a);
//                PrintArray(result);

//        49. Group Anagrams
//               String[] s = {"eat","tea","tan","ate","nat","bat"};
////               String[] s = {"a"};
////               String[] s = {""};
////               String[] s = {"bluffed","excellently","neurology","nonrefillable","edmund","boyhoods","survivors","sexually","outnumbering","bolero","werewolf","debasing","dragnet","addams","monochromes","flippancy","hoots","digestion","profanity","cellist","enrols","crumble","elderberry","jayson","recopying","threats","exploded","cinnamon","hospitalized","ducat","memorialize","powerlessly","suaver","deservings","genuinely","calliope","oxidize","gamekeeper","slimming","daises","resisted","shanty","receivable","careering","transmigration","dooms","revisiting","financed","severs","hominy","pantomiming","bestride","seam","alibi","churchman","ovule","jaxartes","retirement","translated","pancaking","achiever","navigates","hazes","tubman","versatility","fergus","adjust","narcosis","hightail","mormon","hattie","chinning","teenager","tho","misbehaves","trustfulness","electioneers","emending","disenchanting","barometer","styluses","uruguay","houseboat","rungs","endwise","reinterpretation","gashes","koshers","nostalgic","hateful","bray","sutures","saudis","sentimentalizes","ayers","avoided","spiky","circumnavigated","tonic","dialects","disbursing","manitoba","potbellies","cauldron","whitened","fitter","attorney","doorbell","scrolled","noncontagious","overnight","rubbishes","stove","amortizing","periling","doublet","celina","whitfield","tonsures","overturns","missions","casuals","juxtaposing","sings","hesperus","panhandle","armando","bernays","trimmers","transom","grafts","columns","abelson","archway","infantries","orly","pock","selectors","lecterns","humps","kinked","bridles","essentials","instead","eliminating","mabel","zing","impersonation","cudgels","chang","artifacts","creon","clucking","skedaddled","spryer","footballs","honeys","wafer","knelt","flagstone","americanize","bohr","plottered","simone","conventional","definable","blackbirds","woodsier","carriage","residents","mezzanines","tenement","plymouth","wresting","islanders","malleable","attentively","irrelevancy","paulette","hillbillies","leech","cloaks","individualist","uncannier","patel","effusions","dungs","plugs","discompose","dacrons","teletypes","dismay","germany","travailing","loathes","devouter","chandelier","rinsed","denial","mil","outmanoeuvre","tugged","icings","reefer","dominicans","franz","destruct","bog","pinhole","jackknife","polytheists","chatted","tomfoolery","breeziness","beaked","tasman","possession","partying","shift","anodynes","pontificate","typefaces","mullions","reconnaissance","stanching","bedstead","belligerent","breakwaters","messerschmidt","instincts","sickle","quondam","limos","fosters","mentalities","minestrone","harrowed","folsom","travesty","compendiums","maladies","narrates","interlocks","humbleness","uplifted","slipknot","motorcyclists","restarted","iconoclast","forts","trumpery","cute","harpsichord","klutzier","ashtray","garlicking","sprayer","duodenal","parboiled","ultras","arkansan","metaphor","patterning","lorries","donetsk","coerced","constricted","murkiness","curtailing","bookish","tenacious","araucanian","unmask","forlorner","ills","bert","closures","cahoots","rotundity","sullying","pare","pretences","beggar","childproofs","educable","duct","posits","bushed","southward","echelon","approximates","spoonerism","waitresses","unman","isolation","suleiman","delight","skimping","rambles","redistrict","alderwomen","o","rejoiced","blot","backpedals","clearings","brontosauruses","laughingly","huckleberries","steinbeck","friskier","commander","skivvies","reality","intermingles","cumbersome","bribery","disagreeable","jersey","lamont","profiteered","shooters","transience","scraper","resignedly","grabbing","christies","piaget","executors","reproachfully","spasming","overproduction","incises","priesthoods","straightforwards","poesied","welled","bickered","drolleries","manures","daffy","segregate","waddles","cheerfully","overprinted","molester","lief","summarizes","vaccination","seminole","unlisted","rumping","ed","weir","manufacture","secretariat","fulminated","molybdenum","bakersfield","unpinning","heroism","violence","mistimed","alcoa","perter","manuscripts","separate","retractions","safes","atoll","grottos","boogieing","olga","frisking","grows","redeployment","helmholtz","durant","rankest","thespian","cheese","pilaf","thinness","contrast","parqueted","milkmaids","blackhead","breathlessly","bothering","decoration","arrogant","setups","contraptions","swirly","transgression","misses","handyman","snows","clinic","vatican","forecaster","haughtiness","bovine","strobe","ingram","maratha","descartes","billeting","treetop","aloud","globed","monument","argumentative","squeegee","especial","retrofits","artistes","propose","piraeus","horsetails","tailpipes","throughout","tarted","synods","unconcerned","weighting","duding","roe","undervalued","reachable","thicker","egging","dentistry","byte","distinguished","envisioning","filibusters","housewarming","matzot","dill","remarries","anatomical","kremlinologists","truancy","bostonians","limited","poorer","corniest","contradictory","three","temporaries","convivial","shirting","schisms","balconies","reinterpret","suturing","kumquats","oncology","unbidden","correlates","kowtows","flashest","neighborhood","rumbas","swathed","webb","birches","engages","promoters","outside","cheeriest","suffusion","propounding","bagels","amish","contrarily","xylophonists","familiarize","makes","testimony","crusaded","wildcatted","slackest","bovines","artier","plops","robbie","slosh","dinkier","airworthiest","carbohydrates","teammates","locoweed","stratagems","sarcoma","gougers","yuletide","rosemarie","upholster","sizzle","reminiscing","bluffers","shellac","heckled","hypothalami","showery","supposes","humbug","burnished","lopsided","imprisons","opine","leeches","generic","stimulated","soggily","aftershave","marvell","pekoe","microorganism","burlap","topples","misfire","scuttlebutt","tantrums","exits","eclecticism","alden","ilk","deltas","slack","effortlessly","operationally","offspring","staggers","alkalis","logger","spines","oscilloscope","tiniest","fluxed","collectively","leagues","procter","protruding","flukiest","underemployed","wetter","ignite","puddings","magnetosphere","solids","oceangoing","barrooms","refurnished","operational","mastering","white","organist","blackest","licentiates","marsupial","machinists","borderlands","dingies","kegging","dualism","cohen","existing","wheeler","uncleanly","umlauts","expiate","misspends","ebert","camber","adventured","weave","bounded","religiously","potluck","scions","millionths","goblet","witchery","dodge","sarasota","pier","membranous","stomaching","tallyhos","cohort","leveraged","makeshift","hexagon","thumped","zedong","versions","ultraconservatives","obeyed","pace","wicks","luncheoning","minerals","medications","moralizes","unites","rant","portents","apparelling","hums","farrowed","verve","boggiest","weal","josephus","perfects","beef","stairwell","comment","arrant","stature","kc","quoits","galls","adoption","reformulate","physicals","schroeder","scoundrels","delivered","crushed","rue","thrives","cerf","hijacker","inkier","vulvae","deterring","burgles","catechism","unhorse","reclined","dapple","angioplasties","sluggards","emceed","snobbery","accessory","cardiologist","browning","crosses","boasted","summonsing","gamble","overdue","scourge","dirges","cascades","precious","peacefuller","oysters","hoods","pirates","sauerkraut","whiskers","defames","repute","foolish","lactate","tharp","electrocutions","fating","freezers","invocation","dissenter","should","hells","homesickness","archdukes","preconceiving","scroungers","embellishment","massacre","upon","aerated","protuberant","sternly","meticulously","virulent","loch","enchant","raindrop","atrophies","magyar","interring","coachmen","exorcism","faintness","pointlessness","kawabata","installment","maliciously","vindicating","monkeying","uncanny","tangibles","blessed","forensic","arty","toppled","dilapidation","klutzes","moots","cottage","seismograph","diarists","aperitif","facing","filial","soundings","salsa","clear","cayenne","stilling","thighs","contrasting","cloistered","custodial","woodland","frillier","unrolls","landsat","chartres","toughly","saluted","verbose","transfiguring","zapped","iconoclasts","parkman","charlestons","spadework","okaying","numismatics","chestnuts","ghostwriters","nobelists","insouciant","vivisection","moods","edifices","relocated","wisdom","ignobly","namesakes","tapestry","schismatics","agra","blundering","sailboards","fruited","anticlimax","viewed","locus","barricading","rehearsed","irater","sibyl","steps","airsickness","blasphemous","swelling","salinger","veal","normalizes","gullet","inhabitant","slut","zinced","homing","headphone","chatters","winged","wingspread","kneecaps","tam","withdraws","repatriating","peter","isobars","dix","rekindled","snider","depends","mute","knowledgeably","mends","tides","stoutness","hempen","victoria","slaloming","buttons","grammars","astounding","memorandum","kenmore","solid","bandoliers","flowered","equivocation","assuredly","festers","helios","lebanese","impugned","shiftlessness","statement","announcer","vagueness","punctures","colonnade","exist","displeasing","diocletian","untold","unprintable","hereford","sidereal","joke","automatically","rendezvousing","surfed","surreptitious","depopulating","arching","massive","excise","beatles","rigorous","turnovers","impromptus","jezebels","glinted","leveraging","capsizing","voices","hitchhiking","ramon","wyeth","larva","unblushing","inanest","vacillate","contrives","kw","carboniferous","disinterred","predicated","song","andean","youths","previous","yours","supplicates","gompers","apprenticed","half","lactic","authenticating","charlatan","mendacious","flanks","hieronymus","dressy","owns","vestry","strobes","clapping","informers","sermoning","rifer","headstone","bobbing","forgiven","hypocritical","legation","adjusted","glibness","peeled","actuators","composition","payloads","abdication","delete","unnecessary","misprint","wooziest","cannibalistic","voiced","marooned","einstein","erratically","obsessions","impracticality","hoffa","rheumatics","handsets","tricked","afield","abdul","sounding","tray","massacring","iowan","grits","billy","purchases","profitably","resilience","eyed","vocabularies","golden","barking","riviera","helmsmen","cavorting","shrinks","hangmen","heliports","salve","assorting","neuroses","contribute","triathlon","adherents","gismo","sering","pulsate","hoarders","vacating","pulverization","destabilize","wore","eureka","gobs","raiding","valhalla","aureole","illustration","null","ageing","umbrellaing","characterize","ethel","bagging","lucas","nakedly","rinded","wainscottings","through","falter","clearness","smart","overspecializes","older","entourage","dawn"};
//               Leetcode L1 = new Leetcode();
//               List< List <String>> list = L1.groupAnagrams(s);
//               PrintDoublyListString(list);



//        134. Gas Station
////              int[] gas = {1,2,3,4,5};
////              int[] cost = {3,4,5,1,2};
//              int[] gas = {5,1,2,3,4};
//              int[] cost = {4,4,1,5,1};
////              int[] gas = {1,2,3,4,5,5,70};
////              int[] cost = {2,3,4,3,9,6,2};
//              Leetcode L1 = new Leetcode();
//              int result  =  L1.canCompleteCircuit(gas , cost);
//              System.out.println(result);


//        12. Integer to Roman
//              int num = 1994;
//              int num = 3;
//              int num = 58;
//              int num = 40;
//              Leetcode L1 = new Leetcode();
//              String s = L1.intToRoman(num);
//              System.out.println(s);

//        451. Sort Characters By Frequency
//              String s = "tree";
//              String s = "cccaaa";
//              String s = "Aabb";
//              Leetcode L1 = new Leetcode();
//              String result = L1.frequencySort(s);
//              System.out.println(result);

//        151. Reverse Words in a String
//             String s = "  hello world  ";
//             Leetcode L1 = new Leetcode();
//             String result = L1.reverseWords(s);
//             System.out.println(result);

//        279. Perfect Squares
//              int num = 13;
////              int num = 12;
////              int num = 4;
//
//              Leetcode L1 = new Leetcode();
//              int result = L1.numSquares(num);
//              System.out.println(result);


//        167. Two Sum II - Input Array Is Sorted
//               int[] a = {2,7,11,15};
//               Leetcode L1 = new Leetcode();
//               int[] result = L1.twoSumII(a , 9);
//               PrintArray(result);

////        15. 3Sum
////           int[] a = {-1,0,1,2,-1,-4};
////           int[] a = {0,1,1};
////           int[] a = {0,0,0};
//           int[] a = {0,0,0 , 0};
//           int[] a = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
//           Leetcode L1 = new Leetcode();
//           List<List<Integer>> list = L1.threeSum(a);
//           PrintDoublyList(list);

//        189. Rotate Array
//               int[] a = {1,2,3,4,5,6,7};
//               int k=3;
//               int[] a = {1,2};
//               int k=3;
//               int[] a = {1,2,3,4,5,6};
//               int k=11;
////               int[] a = {-1,-100,3,99};
////               int k=2;
//               Leetcode L1 = new Leetcode();
//               int[] result = L1.rotate189(a ,k);
//               PrintArray(result);

//        368. Largest Divisible Subset
////            int[] a = {1,2,3};
//            int[] a = {3,4,16,8};
////            int[] a = {1,2,4,8};
//            Leetcode L1 = new Leetcode();
//            List<Integer> list =  L1.largestDivisibleSubset(a);
//            PrintIntList(list);


//        209. Minimum Size Subarray Sum
//              int[] a = {2,3,1,2,4,3};
////              int[] a = {1,1,1,1,1,1,1,1};
//              int target=7;
////              int target=11;
//              Leetcode L1 = new Leetcode();
//              int result = L1.minSubArrayLen(a , target);
//              System.out.println(result);

//         36  valid sudoku
//               String[][] a = {
// {"5","3",".",".","7",".",".",".","."}
//,{"6",".",".","1","9","5",".",".","."}
//,{".","9","8",".",".",".",".","6","."}
//,{"8",".",".",".","6",".",".",".","3"}
//,{"4",".",".","8",".","3",".",".","1"}
//,{"7",".",".",".","2",".",".",".","6"}
//,{".","6",".",".",".",".","2","8","."}
//,{".",".",".","4","1","9",".",".","5"}
//,{".",".",".",".","8",".",".","7","9"}
//               };
//               String[][] a = {
//                       {"8","3",".",".","7",".",".",".","."},
//                       {"6",".",".","1","9","5",".",".","."},
//                       {".","9","8",".",".",".",".","6","."},
//                       {"8",".",".",".","6",".",".",".","3"},
//                       {"4",".",".","8",".","3",".",".","1"},
//                       {"7",".",".",".","2",".",".",".","6"},
//                       {".","6",".",".",".",".","2","8","."},
//                       {".",".",".","4","1","9",".",".","5"},
//                       {".",".",".",".","8",".",".","7","9"}
//               }
//                       ;
//               Leetcode L1 = new Leetcode();
//               boolean result = L1.isValidSudoku(a);
//               System.out.println(result);

//        48. Rotate Image
//           int[][] a = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//           Leetcode L1= new Leetcode();
//           int[][] result = L1.rotate48(a);
//           PrintDoubleArray(result);

//        54. Spiral Matrix
//            int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
//            Leetcode L1 = new Leetcode();
//            List<Integer> result = L1.spiralOrder(a);
//            PrintIntList(result);

//        73. Set Matrix Zeroes
//              int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
//              Leetcode L1 = new Leetcode();
//              int[][] result = L1.setZeroes(a);
//              PrintDoubleArray(result);

//        205. Isomorphic Strings


//        128. Longest Consecutive Sequence
//              int[] a = {100,4,200,1,3,2};
////              int[] a = {0,3,7,2,5,8,4,6,0,1};
//              Leetcode L1 = new Leetcode();
//              int result = L1.longestConsecutive(a);
//              System.out.println(result);

//        3. Longest Substring Without Repeating Characters
//           String s= "abcabcbb";
//           Leetcode L1 = new Leetcode();
//           int result = L1.lengthOfLongestSubstring(s);
//           System.out.println(result);

//        76. Minimum Window Substring
//             String s = "ADOBECODEBANC";
//             String t="ABC";
//             Leetcode L1 = new Leetcode();
//             String result = L1.minWindow(s , t);
//             System.out.println(result);

//          traverse neighbour of the element in 2d metrics
//               int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//               Leetcode L1=  new Leetcode();
//               PrintNeighbour2DMetrics(a);

//        289. Game of Life
//             int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//             int[][] a = {{1,1},{1,0}};
//              Leetcode L1  =new Leetcode();
//              int[][] res = L1.gameOfLife(a);
//              PrintDoubleArray(res);
//        PrintNeighbour2DMetrics(a);

//        268. Missing Number
//            int[] a = {3,0,1};
//            Leetcode L1 = new Leetcode();
//            int num = L1.missingNumber(a);
//            System.out.println(num);



//        26. Remove Duplicates from Sorted Array
//              int[] a = {0,0,1,1,1,2,2,3,3,4};
//              int[] a = {1,1,2};
//              Leetcode L1 = new Leetcode();
//              int res = L1.removeDuplicates26(a);
//              System.out.println(res);


//        80. Remove Duplicates from Sorted Array II
//             int[] a ={1,1,1,2,2,3};
//             int[] a ={1,1};
////             int[] a ={0,0,1,1,1,1,2,3,3};
//             Leetcode L1 = new Leetcode();
//             int res = L1.removeDuplicates(a);
//             System.out.println(res);

//        997. Find the Town Judge
//              int[][] a = {{1,3},{2,3},{3,1}};
//              int[][] a = {{1,3},{2,3}};
//              int[][] a = {{1,2}};
//              Leetcode L1 = new Leetcode();
//              int res = L1.findJudge(a);
//              System.out.println(res);


//        228. Summary Ranges
//               int[]   a= {0,2,3,4,6,8,9};
//               int[]   a= {0,1,2,4,5,7};
//               int[]   a= {0,1,2,4,5,7};
//               Leetcode L1 = new Leetcode();
//               List<String> res = L1.summaryRanges(a);
//               for(int i=0;i<res.size();i++){
//                   System.out.println(res.get(i));
//               }




//        56. Merge Intervals
//            Leetcode L1 = new Leetcode();
////            int[][] a= {{1,3},{2,6},{8,10},{15,18}};
////            int[][] a= {{1,4},{4,5}};
//            int[][] a= {{1,4},{4,5}};
////            int[][] a= {{1,5},{2,7}};
//            int[][] res=L1.merge56(a);
//            PrintDoubleArray(res);


//        57. Insert Interval

//              int[][] a = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//              int[] newInterval = {4,8};
////              int[][] a = {{1,3},{6,9}};
////              int[] newInterval = {2,5};
////              int[][] a = {{}};
////                int[][] a = {{1,5}};
////                int[] newInterval = {2,7};
//        Leetcode L1 = new Leetcode();
//
//              int[][] res  = L1.insert57(a, newInterval);
//              PrintDoubleArray(res);


//        452. Minimum Number of Arrows to Burst Balloons
////              int[][] a = {{10,16},{2,8},{1,6},{7,12}};
//              int[][] a = {{1,2},{2,3},{3,4},{4,5}};
////              int[][] a = {{1,2},{3,4},{5,6},{7,8}};
//              Leetcode L1  = new Leetcode();
//              int res = L1.findMinArrowShots(a);
//              System.out.println(res);

//        5. Longest Palindromic Substring
//             String s = "babad";
//             String s = "cbbd";
//             String s = "babadabcaacbab";
//             Leetcode L1 = new Leetcode();
//             String result = L1.longestPalindrome(s);
//             System.out.println(result);

//        17. Letter Combinations of a Phone Number

//              String s = "23";
//              Leetcode L1  = new Leetcode()
//;              List<String> res = L1.letterCombinations(s);
//                System.out.println(res);


//        22. Generate Parentheses
//              int num=3;
//              Leetcode L1 = new Leetcode();
//              List<String> res =  L1.generateParenthesis(num);
//              PrintStringList(res);


//        33. Search in Rotated Sorted Array
//              int[] a = {4,5,6,7,0,1,2};
//              Leetcode L1 = new Leetcode();
//              int res = L1.search33(a , 5);
//              System.out.println(res);


//        34. Find First and Last Position of Element in Sorted Array
//            int[] a = {5,7,7,8,8,10};
//            int[] a = {5,7,7,8,8,10};
////            int[] a = {1,2,3,4, 4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5   ,5,5,8,8,8,8,8,8,8,8,8,8,8,8,9,10,11,12};
//            Leetcode L1 = new Leetcode();
//            int[] res = L1.searchRange(a,8);
//            PrintArray(res);

//        153. Find Minimum in Rotated Sorted Array
//              int[] a = {3,4,5,1,2};
//              Leetcode L1 = new Leetcode();
//              int res = L1.findMin(a);
//              System.out.println(res);

//        31. Next Permutation
//              int[] a = {1,2,3};
//              int[] a = {2, 1,5,4,3,0,0};
//              Leetcode L1 = new Leetcode();
//              int[] res = L1.nextPermutation(a);
//              PrintArray(res);

//        75. Sort Colors
//              int[] a = {2,0,2,1,1,0};
//              Leetcode L1 = new Leetcode();
//              int[] res = L1.sortColors(a);
//              PrintArray(res);

//        121. Best Time to Buy and Sell Stock
//            int[] a = {7,1,5,3,6,4};
//              int[] a = {7,6,4,3,1};
//            Leetcode L1 = new Leetcode();
//            int res = L1.maxProfit(a);
//            System.out.println(res);

//      interviewbit   Repeat and Missing Number Array
//             int[] a = {3 ,1, 2, 5, 3};
//             Leetcode L1 = new Leetcode();
//             int[] res = L1.repeatedAndMissing(a);
//             PrintArray(res);

//       coading ninjas Count Inversions
////            int[] a = {5,3,2,1,4};
//            int[] a = {2 ,5 ,1, 3, 4};
//            Leetcode L1 = new Leetcode();
//            int res=  L1.countInverstion(a);
//            System.out.println(res);


//        74. Search a 2D Matrix
//              int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//              int target  = 3;
//              Leetcode L1 = new Leetcode();
//              boolean res=L1.searchMatrix(a ,target );
//              System.out.println(res);


//        50. Pow(x, n)
//              double x = 2.00000;
//              int n = 10;
//              Leetcode L1 = new Leetcode();
//              double res = L1.myPow(x,n);
//              System.out.println(res);

//        169. Majority Element
//               int[] a = {6,5,5};
//               Leetcode L1 = new Leetcode();
//               int res = L1.majorityElement(a);
//               System.out.println(res);



//         62. Unique Paths
//              int m = 3, n = 7;
//              Leetcode L1 = new Leetcode();
//              int res = L1.uniquePaths(m,n);
//              System.out.println(res);



//        493. Reverse Pairs
//              int[] nums = {2,4,3,5,1};
//              Leetcode L1 = new Leetcode();
//              int res=  L1.reversePairs(nums);
//              System.out.println(res);


//         18 sum
//             int[] a = {1,0,-1,0,-2,2};
//             int[] a = {1,0,-1,0,-2,2};
//             int target=0;
//             int[] a = {1000000000,1000000000,1000000000,1000000000};
//             int target=-294967296;
//             Leetcode L1 = new Leetcode();
//             List<List<Integer>> list = L1.fourSum(a,target);
//             PrintDoublyList(list);


//        Largest subarray with 0 sum  gfg
//            int[] a = {15,-2,2,-8,1,7,10,23};
//            Leetcode L1 = new Leetcode();
//            int res = L1.maxLen(a);
//            System.out.println(res);




//        Subarray with given XOR
//             int[] a = {4,2,2,6,4};
//             int b=6;
//             Leetcode L1 = new Leetcode();
//             int res = L1.SubArrayWithXOR(a,b);
//             System.out.println(res);


//        3. Longest Substring Without Repeating Characters
//            String s = "bbbbb";
////            String s = "abcabcbb";
//            Leetcode L1 = new Leetcode();
//            int result = L1.lengthOfLongestSubstring(s);
//            System.out.println(result);

//        39. Combination Sum
//              int[] a = {2,3,5};
//              int target = 8;
//              Leetcode L1=new Leetcode();
//              List<List<Integer>> res = L1.combinationSum(a,target);
//              PrintDoublyList(res);

//        40  combinationSum2
//              int[] a = {10,1,2,7,6,1,5};
//              int target = 8;
//              Leetcode L1 = new Leetcode();
//              List<List<Integer>> res = L1.combinationSum2(a , target);
//              PrintDoublyList(res);

//         2540. Minimum Common Value
//               int[] a = {1,2,3};
//               int[] b = {2,4};
//                  int[] a = {1,2};
//               int[] b = {2,4};
//               Leetcode L1 = new Leetcode();
//               int result = L1.getCommon(a,b);
//               System.out.println(result);

//           52 maxSubArray
//               int[] a = {-2,1,-3,4,-1,2,1,-5,4};
//                 int[] a = {5,4,-1,7,8};
//               Leetcode L1 = new Leetcode();
//               int result = L1.maxSubArray(a);
//               System.out.println(result);


//           59. Spiral Matrix II
//                int n=5;
//                Leetcode L1 = new Leetcode();
//                int[][] rs = L1.generateMatrix(n);
//                PrintDoubleArray(rs);

//        349. Intersection of Two Arrays
//            int[] a = {1,2,2,1};
//            int[] b = {2,2};
//            int[] a = {4,9,5};
//            int[] b = {9,4,9,8,4};
//            Leetcode L1 = new Leetcode();
//            int[] res = L1.intersection(a , b);
//            PrintArray(res);



//        876  middleNode
//              int[] a = {1,2,3,4,5,6};
//              Listnode l1 = createListnode(a);
//              Listnode rs = middleNode(l1);
//              PrintListnode(rs);

//        61. Rotate List
//              int[] a = {1,2,3,4,5};
//              int k=2;
//              Listnode l1 = createListnode(a);
//              Listnode res = rotateLinkedList(l1 , k);
//              PrintListnode(res);

//        19. Remove Nth Node From End of List
//              int[] a = {1,2,3,4,5};
//              int n=2;
//              Listnode l1 = createListnode(a);
//              Listnode res = removeNthFromEnd(l1,n);
//              PrintListnode(res);


//                237. Delete Node in a Linked List
//                 int[] a = {4,5,1,9};
//                 int n=5;
//                 Listnode l1 = createListnode(a);
//                 Listnode res =  deleteNode(l1 , 1);


//        234. Palindrome Linked List
//              int[] a = {1,1,2,1};
//              Listnode l1 = createListnode(a);
//              boolean isPalindrome = isPalindromeLinkedList(l1);
//              System.out.println(isPalindrome);

//        25. Reverse Nodes in k-Group
//             int[] a = {1,2,3,4,5};
//             int k=3;
//                int[] a = {1,2,3,4,5,6,7,8,9};
//                int k=3;
//             Listnode l1 = createListnode(a);
//             Listnode rs = reverseKGroup(l1 , k);
//             PrintListnode(rs);

//          142 Linked List Cycle II

//            int[] a = {1,2,3,4,5,6,7,8,9};
//            Listnode l1 = createListnode(a);
//            Listnode res = detectCyclePoint(l1);
//            System.out.println(res.data);


//          gfg subst sum
//             int[] a ={5, 2, 1};
//             Leetcode L1= new Leetcode();
//             List<Integer> list = L1.subsetSums(a);
//             PrintIntList(list);




//        78  subset

//           int[] a = {1,2,3};
//           Leetcode L1 = new Leetcode();
//           List<List<Integer>> list = L1.subsets(a);
//           PrintDoublyList(list);

//        90. Subsets II
//            int[] a = {1,2,2};
//            Leetcode L1 = new Leetcode();
//            List<List<Integer>> rs = L1.subsetsWithDup(a);
//            PrintDoublyList(rs);



//             fin all prmutation

//        540. Single Element in a Sorted Array
//               int[] a = {1,1,2,3,3,4,4,8,8};
//               int[] a  = {3,3,7,7,10,11,11};
//               Leetcode L1 = new Leetcode();
//               int res = L1.singleNonDuplicate(a);
//               System.out.println(res);



//         gfg  K-th element of two Arrays


//        215. Kth Largest Element in an Array
//            int[] a = {3,2,1,5,6,4};
//            int k=2;
//            Leetcode L1 = new Leetcode();
//            int rs = L1.findKthLargest(a , k);
//            System.out.println(rs);


//        496. Next Greater Element I
//               int[] a  = {1,3,4,2};
//               int[] num = {4,1,2};
////                int[] a  = {1,2 , 3 , 4};
////                int[] num = {2,4};
//               Leetcode L1 = new Leetcode();
//               int[] rs = L1.nextGreaterElement(a , num);
//               PrintArray(rs);

//        496. Next smallr Element
//                int[] a  = {1,3,4,2};
//                int[] num = {4,1,2};
//                        int[] a  = {34, 35, 27, 42, 5, 28, 39, 20, 28};
//                        int[] num = {34, 35, 27, 42, 5, 28, 39, 20, 28};
//                Leetcode L1 = new Leetcode();
//                int[] rs = L1.nextSmallerElement(a , num);
//                PrintArray(rs);


//        686. Repeated String Match
//              String s1 = "abcd";
//              String s2 = "cdabcdab";
              String s1="aaaaaaaaaaaaaaaaaaaaaab";
              String s2 = "ba";
              Leetcode L1 = new Leetcode();
              int rs = L1.repeatedStringMatch(s1 , s2);
              System.out.println(rs);















































    }
}




