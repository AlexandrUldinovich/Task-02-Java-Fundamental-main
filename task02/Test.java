package com.company.epam.task02;

public class Test {
    public double calculate (String str) {
        TaskLogic logic = new TaskLogic();
        TaskValidator validator = new TaskValidator();

        validator.generalConformityCheck(str);
        double result = logic.calcExpression(str);

        return result;
    }
}


