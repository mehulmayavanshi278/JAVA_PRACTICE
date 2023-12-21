import com.sun.source.tree.LambdaExpressionTree;

import java.beans.PropertyEditorSupport;
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
          int num = 1;
          Leetcode L1 = new Leetcode();
          int result=L1.findComplement(num);
          System.out.println(result);






    }
}