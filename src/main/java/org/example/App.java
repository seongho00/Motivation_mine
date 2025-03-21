package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;

    }

    void run() {
        System.out.println("== motivation 실행 ==");

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.isEmpty()) {
                System.out.println("명령어가 입력되지 않았습니다.");
            }

            if (cmd.equals("add")) {
                command.reg();
            } else if (cmd.equals("list")) {
                command.list();
            } else if (cmd.contains("remove")) {
                try {
                    List<String> a = new ArrayList<>(Arrays.asList(cmd.split(" ")));
                    command.remove(Integer.parseInt(a.get(1)));
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 명령어 입니다.");
                }
            } else if (cmd.equals("exit")) {
                command.end();
                break;
            } else {
                System.out.println("잘못된 명령어 입니다.");
            }
        }

    }
}


class command {
    static int index;

    static List<mot_list> mot = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    static {
        index = 0;
    }

    static void reg() {

        mot_list alist = new mot_list();

        System.out.print("motivation : ");
        alist.motivation = sc.nextLine();

        System.out.print("source : ");
        alist.source = sc.nextLine();

        index++;
        alist.index = index;

        mot.add(alist);

        System.out.println(index + "번 motivation이 등록되었습니다.");

    }

    static void list() {
        if (mot.isEmpty()) {
            System.out.println();

        } else {
            System.out.println("=".repeat(50));
            System.out.println("번호 / source / motivation");

            for (int i = mot.size() - 1; i >= 0; i--) {
                System.out.printf("%d / %s / %s\n", mot.get(i).index, mot.get(i).source, mot.get(i).motivation);
            }

            System.out.println("=".repeat(50));
        }

    }

    static void end() {
        System.out.println("== motivation 종료 ==");
    }

    static void remove(int number) {
        try {
            mot.remove(number - 1);
            System.out.println(number + "번 motivation이 삭제되었습니다.");

        } catch (IndexOutOfBoundsException e) {
            System.out.println(number + "번 motivation은 존재하지 않습니다.");
            
        }

    }
}

class mot_list extends command {
    int index;
    String motivation;
    String source;
}
