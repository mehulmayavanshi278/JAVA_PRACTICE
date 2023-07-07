import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.Scanner;
import java.util.Arrays;
import java.math.*;
import  java.util.*;

public class Strings {

    String findAllSubsequence(String str){
        ArrayList<String> subSeq = new ArrayList<String>();
        if(str.length()==1){
            return str;
        }

      String returnedString =  findAllSubsequence(str.substring(1));

        System.out.println(returnedString);
        return null;
    }

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

//      1    reverse a  string
//      System.out.println("Enter the String");
//      String s1 = sc.nextLine();
//      char[] charArray = s1.toCharArray();
//      int mid = (int)Math.ceil(s1.length()/2);
//      for(int i=0;i<mid;i++){
//         char temp = charArray[i];
//         charArray[i] = charArray[charArray.length-1-i];
//         charArray[charArray.length - 1 - i] = temp;
//      }
//      s1 = new String(charArray);
//      System.out.println(s1);




//      2  check weather string is palindrome or not
//        System.out.println("Enter the String");
//        String s1 = sc.nextLine();
//        boolean isPalindrome = true;
//        int mid = (int)Math.ceil(s1.length()/2);
//        for(int i=0;i<mid;i++){
//           if(s1.charAt(i) == s1.charAt(s1.length()-1 - i)){
//            isPalindrome = true;
//           }else{
//              isPalindrome = false;
//              break;
//           }
//        }
//        if(isPalindrome){
//           System.out.println("The String is palindrome");
//        }else{
//           System.out.println("The String is not palindrome");
//        }




//      3  find duplicate character in a string
//     System.out.println("Enter the String to Test");
//      String s1 = sc.nextLine();
//      HashMap<Character , Integer> count = new HashMap<>();
//      for(int i=0;i<s1.length();i++){
//         if(!count.containsKey(s1.charAt(i))){
//            count.put(s1.charAt(i) , 1);
//         }else{
//            count.put(s1.charAt(i) , count.get(s1.charAt(i)) + 1);
//         }
//      }
//      for(Map.Entry<Character , Integer> elm : count.entrySet()){
//         if(elm.getValue()>1){
//            System.out.println(elm.getKey() + " , " + elm.getValue());
//         }
//      }


//      5   write a code to check whether one string is rotation in another
//         System.out.println("Enter the String 1");
//         String s1 = sc.nextLine();
//         System.out.println("Enter the string 2");
//         String s2 = sc.nextLine();
//         s1 = s1+s1;
//         if(s1.contains(s2)){
//            System.out.println("string is rotation with s2");
//         }else{
//            System.out.println("String is not rotation");
//         }

//        7 count and say

          HashMap<Character , Integer> MAP = new HashMap<Character , Integer>();
          System.out.println("Enter the String");
          String s1 = sc.nextLine();
          boolean end = false;
          int j=0;
          while(!end){
              System.out.println("i am in");

              int length=1;
              while(s1.charAt(j)==s1.charAt(j+1)){
                  System.out.println("i am in");
                 length++;
                 j++;
                 if(s1.charAt(j+1) == s1.charAt(s1.length()-1)){
                     end=true;
                     break;
                 }
              }
              MAP.put(s1.charAt(j) , length);
              j++;
          }

       for (Map.Entry<Character, Integer> entry : MAP.entrySet()) {
           System.out.println(entry.getKey() + ": " + entry.getValue());
       }



//        10  print All SubSequence of String
//          System.out.println("Enter the String");
//          String s1 = sc.nextLine();
//
//       Strings c1 = new Strings();
//       c1.findAllSubsequence(s1);



//
//


//       15   find next grater number with same set of digit
//          System.out.println("Enter the brackets");
//          String s1 = sc.nextLine();
//          Stack STACK = new Stack();
//          int mid = (int)Math.ceil(s1.length()/2);
//          for(int i=0;i<s1.length();i++){
//              STACK.add(s1.charAt(i));
//          }
//          System.out.println(STACK);


   }
}
