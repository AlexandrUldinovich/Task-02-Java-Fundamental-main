package com.company.epam.task02;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        TaskLogic logic = new TaskLogic();

        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        if(expression.isEmpty()){
            throw new RuntimeException("Я сидел тут 4 дня,чтобы ты ввел пустую строку?(");
        }

        System.out.println(TaskLogic.RpnToAnswer(TaskLogic.transferToRpn(expression)));

    }
}
