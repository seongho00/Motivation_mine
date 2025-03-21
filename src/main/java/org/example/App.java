package org.example;

import org.example.System.controller.SystemController;
import org.example.motivation.controller.MotivationController;


import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;

    }

    void run() {
        System.out.println("== motivation 실행 ==");

        MotivationController command = new MotivationController(sc);
        SystemController systemController = new SystemController();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();


            if (cmd.equals("exit")) {
                systemController.end();
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어가 입력되지 않았습니다.");
                continue;
            }

            if (cmd.equals("add")) {
                command.reg();

            } else if (cmd.equals("list")) {
                command.list();

            } else if (cmd.contains("remove")) {
                command.remove(cmd);


            } else {
                System.out.println("등록되지 않은 명령어 입니다.");
            }
        }

    }
}


