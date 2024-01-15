import com.sun.source.tree.LambdaExpressionTree;

import java.beans.PropertyEditorSupport;
import java.nio.file.LinkOption;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;





 class Listnode{
     int data;
     Listnode next;
     Listnode(int data){
         this.data=data;
         this.next=null;
     }

 }



public class Leetcode {



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

     public  static Listnode reverseListNode(Listnode head){
         Listnode current = head;
         List<Listnode> listnodesArr = new ArrayList<>();
         while (current!=null){
             listnodesArr.add(current);
             current=current.next;
         }

         Collections.reverse(listnodesArr);
         Listnode head1=listnodesArr.get(0);
         Listnode temp = head1;
         for(int i=1;i<listnodesArr.toArray().length;i++){
             head1.next = listnodesArr.get(i);
             head1=head1.next;
         }
         head1.next=null;
         return temp;
     }

     public static void PrintArray(int[] a){
         System.out.print("Array Element is");
       for(int i=0;i<a.length;i++){
           System.out.print( " " + a[i] + " ");
       }
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
           } else if (s1.charAt(i) == ')' && s1.charAt(i-1) == '(') {
               STACK.pop();
           }else if (s1.charAt(i) == '}' && s1.charAt(i-1) == '{') {
               STACK.pop();
           }else if (s1.charAt(i) == ']' && s1.charAt(i-1) == '[') {
               STACK.pop();
           }
        }
        System.out.println(STACK);
        return false;
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

    public boolean IsIsomorphic(String s1 , String s2){



         return true;
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
    public int[] nextGreaterElement(int[] nums1 , int[] nums2){
         int[] result = new int[nums1.length];
         for(int i=0;i<nums1.length;i++){
             result[i] = findNextGreter(nums2 , findIndex(nums2 , nums1[i]) ) ;
         }
         return result;
    }
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
    public int lengthOfLongestSubstring(String s){ //abcabcbb
         int count=0;
         int temp=0;
         int k=0;
         outer :   for(int i=0;i<s.length()-1;i++){
             for(int j=i+1;j<s.length();j++){
                 if(s.charAt(i)==s.charAt(j)){
                     count = Math.max(k,count);
                     System.out.println("k is " + k);

                     System.out.println("i is " + i);
                     System.out.println("j is " + j);
                     k=1;
                     continue outer;
                 }
                 k++;
             }
             count = Math.max(k , count);
             k=0;
         }
         System.out.println(count);

         return count;
    }
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

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int i=0;
        int j=1;
        int k=nums.length-1;

        while(i<k && j<nums.length){
            if(j==k){
                i=i+1;
                j=i+1;

            }
            if(nums[i] + nums[j] + nums[k] == 0){
                result.add(new ArrayList<>());
                result.get(result.size()-1).add(nums[i]);
                result.get(result.size()-1).add(nums[j]);
                result.get(result.size()-1).add(nums[k]);
                i=i+1;
                j=i+1;
                continue;
            }
            if(nums[i] + nums[j] + nums[k] <0){

                j++;
            }
            if(nums[i] + nums[j] + nums[k] >0){
                k--;
            }

        }

        return result;

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
    public List<String> letterCombinations(String digit){
         List<String> list = new ArrayList<>();


        for(int i=digit.length()-1;i>=0;i--){
             List<String> temp  = combineLetter(digit.charAt(i) , list);
             list.addAll(temp);
        }
        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        return list;




    }

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
//              boolean result = L1.IsIsomorphic(s1  , s2);
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
             int[] a = {1,2,3,4,5};
             int n = 2;
             Listnode l1 =  createListnode(a);

             Listnode result = removeNthFromEnd(l1 , n);
             PrintListnode(result);










    }
}