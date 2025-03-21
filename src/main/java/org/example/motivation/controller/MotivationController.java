package org.example.motivation.controller;

import org.example.motivation.entity.mot_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    int index;

    List<mot_list> mot = new ArrayList<>();

    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }


    public void reg() {

        mot_list mot_list = new mot_list();

        System.out.print("motivation : ");
        mot_list.setMotivation(sc.nextLine());

        System.out.print("source : ");
        mot_list.setSource(sc.nextLine());

        index++;
        mot_list.setIndex(index);

        mot.add(mot_list);

        System.out.println(index + "번 motivation이 등록되었습니다.");

    }

    public void list() {
        if (mot.isEmpty()) {
            System.out.println();
            return;
        }

        System.out.println("=".repeat(50));
        System.out.println("번호 / source / motivation");


        for (int i = mot.size() - 1; i >= 0; i--) {

            System.out.printf("%d / %s / %s\n", mot.get(i).getIndex(), mot.get(i).getSource(), mot.get(i).getMotivation());
        }

        System.out.println("=".repeat(50));


    }


    public void remove(String cmd) {
        try {
            List<String> a = new ArrayList<>(Arrays.asList(cmd.split(" ")));
            int number = Integer.parseInt(a.get(1).trim());

            try {
                mot.remove(number - 1);
                System.out.println(number + "번 motivation이 삭제되었습니다.");

            } catch (IndexOutOfBoundsException e) {
                System.out.println(number + "번 motivation은 존재하지 않습니다.");
            }
        } catch (Exception e) {
            System.out.println("remove 명령어가 잘못되었습니다.");
        }


    }
}
