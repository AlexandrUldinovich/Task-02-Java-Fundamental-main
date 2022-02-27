package com.company.epam.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskValidator {

    public void generalConformityCheck (String str) {
        findInvalidSymbols(str);
        findInvalidSymbols(str);
    }

    public boolean findNumsEqualsToZero (String str) {
        Pattern num = Pattern.compile("[\\d]+");
        Matcher m1 = num.matcher(str);

        while (m1.find()){
            if(Integer.parseInt(m1.group()) == 0) {
                return true;
            }
        }
        return false;
    }

    public void findInvalidSymbols (String str) {
        Pattern p1 = Pattern.compile("[^\\d\\s\\-\\*\\+\\/\\(\\)]");
        Matcher m1 = p1.matcher(str);

        if(m1.find()) {
            throw new RuntimeException("Expression contains invalid symbol(s)");
        }
    }
}
