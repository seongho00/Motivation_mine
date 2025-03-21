package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== motivation 실행 ==");
        command.reg();

        command.reg();

        command.list();

        command.end();


    }
}

class command {
    static int index;

    static List<mot_list> mot = new ArrayList<>();

    static {
        index = 0;
    }

    static void reg() {
        Scanner sc = new Scanner(System.in);

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
        System.out.println("==============");
        System.out.println("번호 / source / motivation");

        for (mot_list list : mot) {
            System.out.printf("%s / %s / %s\n", list.index, list.source, list.motivation);
        }

        System.out.println("==============");
    }

    static void end() {
        System.out.println("== motivation 종료 ==");
    }

}

class mot_list extends command {
    int index;
    String motivation;
    String source;

}