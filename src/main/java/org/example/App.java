package org.example;

import org.example.System.controller.SystemController;
import org.example.motivation.controller.MotivationController;


import java.util.Scanner;

public class App {


    void run() {
        System.out.println("== motivation 실행 ==");

        MotivationController motivationController = new MotivationController(Container.getScanner());
        SystemController systemController = new SystemController();

        while (true) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.end();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;
            }

            if (cmd.equals("add")) {
                motivationController.reg();

            } else if (cmd.equals("list")) {
                motivationController.list();

            } else if (cmd.contains("delete")) { // contains 대신 startwith으로 해도 무방함.
                motivationController.delete(cmd);

            } else if (cmd.contains("modify")) {
                motivationController.modify(cmd);

            } else {
                System.out.println("등록되지 않은 명령어 입니다.");
            }
        }

    }
}


