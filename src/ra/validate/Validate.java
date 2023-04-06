package ra.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean checkUserName(String string){
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(string);
        return  m.matches();
    }
    public static boolean checkEmail(String email){
        String regex = "^(.+)@(\\S+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean checkRePassword(String pass,String rePass){
        String regex = pass;
        Pattern pattern = Pattern.compile(pass);
        Matcher m = pattern.matcher(rePass);
        return m.matches();
    }
    public static boolean checkPhoneNumber(String phone){
        String regex = "0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(phone);
        return m.matches();
    }

//    public static void main(String[] args) {
//        System.out.println(checkPhoneNumber("0900008000"));
//    }
}
