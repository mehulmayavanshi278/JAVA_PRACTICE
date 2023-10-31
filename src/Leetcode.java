import java.util.Scanner;
import java.util.*;

public class Leetcode {




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
        for(int i=0;i<(Integer.toString(x).length()/2);i++){
//            System.out.print(Integer.toString(x).charAt(i));
//            System.out.print(( x / ((int) (Math.pow(10, (Integer.toString(x).length()- (i+1)))))) % 10 );
//            System.out.print("  ");
//            System.out.println((x / ((int) (Math.pow(10,i)))) % 10);


            if ( ( x / ((int) (Math.pow(10, (Integer.toString(x).length()- (i+1)))))) % 10 !=  (x / ((int) (Math.pow(10,i)))) % 10){
                isPalindrm=false;
            }
//            example
//            how to check first letters x/1000%10 x/100%10 x/10%10
//            how to check last letters  x/1%10 x/10%10 x/100%10 x/1000%10
//

        }
        return isPalindrm;
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
        System.out.println("Enter the number to test palindrome");
        int num = sc.nextInt();
        Leetcode L1 = new Leetcode();
       boolean result = L1.isPalindrome(num);
        System.out.println(result);



    }
}