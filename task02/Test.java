package com.company.epam.task02;
import com.company.epam.task02.*;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String expression = "";
        TaskLogic logic = new TaskLogic();
        logic.RpnToAnswer(TaskLogic.ExpressionToRpn(expression));

    }
}


