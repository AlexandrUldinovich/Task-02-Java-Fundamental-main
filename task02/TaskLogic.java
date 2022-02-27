package com.company.epam.task02;

import java.util.Stack;

class TaskLogic {

    public double calcExpression (String expression) {
        String rpn = expressionToRpn (expression);
        double result = rpnToAnswer(rpn);

        return result;
    }

    private static int getPriority (char token) {

        if (token == '*' || token == '/') {
            return 3;
        } else if (token == '-' || token == '+') {
            return 2;
        } else if (token == '(') {
            return 1;
        } else if (token == ')') {
            return -1;
        } else {
            return 0;
        }
    }

    public String expressionToRpn (String expression) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == 0) {
                current += expression.charAt(i);
            }
            if (priority == 1) {
                stack.push(expression.charAt(i));
            }

            if (priority > 1) {
                current+=(' ');

                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current+=(stack.pop());
                    }
                    else{
                        break;
                    }
                }
                stack.push(expression.charAt(i));
            }

            if (priority == -1) {
                current+=(' ');
                while (getPriority(stack.peek()) != 1) {
                    current+=(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            current+=(stack.pop());
        }
        return current;
    }

    public Double rpnToAnswer (String rpn) {

        String oper = new String();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }

            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    oper += rpn.charAt(i++);
                    if (i == rpn.length())
                        break;
                }


                stack.push(Double.parseDouble(oper));
                oper = new String();

            }

            if (getPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop(), b = stack.pop();

                if (rpn.charAt(i) == '+') {
                    stack.push(b+a);
                }
                if (rpn.charAt(i) == '-') {
                    stack.push(b-a);
                }
                if (rpn.charAt(i) == '*') {
                    stack.push(b*a);
                }
                if (rpn.charAt(i) == '/') {
                    stack.push(b/a);
                }
            }
        }
        return stack.pop();
    }
}