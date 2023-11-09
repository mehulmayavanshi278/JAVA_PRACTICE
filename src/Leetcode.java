import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.String;

public class Leetcode {


     public static void PrintArray(int[] a){
         System.out.print("Array Element is");
       for(int i=0;i<a.length;i++){
           System.out.print( " " + a[i] + " ");
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
     int[] removeDuplicateFromSortedArray(int[] a){   // int[] a = {1 , 5 , 5 ,5 , 7 ,9 , 9 , 10 , 15 , 17 , 20 , 20}


         return a;
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

     int[] plusOne(int[] a){
         return a;
     }

     int findLenghtOfLastWord(String s1){
         String[] temp = s1.trim().split(" ");
         int result = temp[temp.length-1].length();
         return result;
     }

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

//           14  plus one
//                int[] a = {9 , 9 };
//                Leetcode L1 = new Leetcode();
//                int[] result = L1.plusOne(a);
//                PrintArray(result);

//           15  add binary
//                 int a = 1010;
//                 int b = 110;
//                 Leetcode L1 = new Leetcode();
//                 int result = L1.addBinary(a,b);
//                 System.out.println(result);

//           16  findSquareRoot
                    int a = 1010;
                    int b = 110;
                    Leetcode L1 = new Leetcode();
                    int result = L1.SQRT(18);
                    System.out.println(result);


    }
}