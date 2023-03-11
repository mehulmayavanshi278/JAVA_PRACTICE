import java.util.Scanner;
import java.lang.String;
class example {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s1 = sc.nextLine();
        int stringLength = s1.length()-1;
        boolean x = true;
        int mid = stringLength/2;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s1.charAt(stringLength)){
                if(i==stringLength || i>stringLength){
                    break;
                }else{
                    stringLength=stringLength-1;
                }
            }else{
                x=false;
                break;
            }
        }
        if(x==true){
            System.out.println("The String is Palindrome");
        }else{
            System.out.println("The string is not Palindrome");
        }
    }
}