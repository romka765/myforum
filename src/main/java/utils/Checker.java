package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    //проверка строки на заполненность
    public boolean isEmpty(String a){
        a.trim();
        if (a.isEmpty()){
            return false;
        }
        else return true;

    }

    public boolean isEMail(String a){
        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher = pattern.matcher(a);
        int counter = 0;
        while (matcher.find()){
            counter++;
        }
        if (counter == 1){
            return true;
        }
        else {
            return false;
        }
    }

}
