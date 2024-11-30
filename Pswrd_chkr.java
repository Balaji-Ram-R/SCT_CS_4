import java.util.Scanner;
public class Pswrd_chkr {
    public static String PswrdAnalyzer(String pswrd){
        String ans="";
        int n = pswrd.length();
        String spl_char = "!@#$%^&*()-+";
        boolean upp = false, low = false, dig = false, spl = false;
        for (char a : pswrd.toCharArray()) {
            if (Character.isUpperCase(a)) {
                upp = true;
            }else if (Character.isLowerCase(a)) {
                low = true;
            }else if(Character.isDigit(a)){
                dig = true;
            }else if (spl_char.contains(Character.toString(a))) {
                spl = true;
            }
        }

        if (n>=8 && low ==true && upp==true && spl==true && dig==true) {
            ans = "Strong";
        }else if (n>=6 && low ==true && upp==true && spl==true) {
            ans = "Average";
        }else{
            ans = "Weak";
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Password: ");
        String inp = sc.nextLine();
        sc.close();
        System.out.println("Your Password is "+PswrdAnalyzer(inp));
    }
}
