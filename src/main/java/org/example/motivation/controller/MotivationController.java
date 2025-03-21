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

        System.out.print("Motivation : ");
        mot_list.setMotivation(sc.nextLine());

        System.out.print("Source : ");
        mot_list.setSource(sc.nextLine());

        index++;
        mot_list.setIndex(index);

        mot.add(mot_list);

        System.out.println(index + "번 Motivation이 등록되었습니다.");

    }

    public void list() {
        if (mot.isEmpty()) {
            System.out.println("등록된 List가 없습니다.");
            return;
        }

        System.out.println("=".repeat(50));
        System.out.println("번호 / Source / Motivation");


        for (int i = mot.size() - 1; i >= 0; i--) {
            if (mot.get(i).getSource().length() > 7) {
                System.out.printf("%d / %s / %s\n", mot.get(i).getIndex(), mot.get(i).getSource().substring(0, 5) + "...", mot.get(i).getMotivation());
                continue;
            }
            System.out.printf("%d / %s / %s\n", mot.get(i).getIndex(), mot.get(i).getSource(), mot.get(i).getMotivation());
        }

        System.out.println("=".repeat(50));


    }

    public void delete(String cmd) {
        try {
            List<String> a = new ArrayList<>(Arrays.asList(cmd.split(" ")));
            int number = Integer.parseInt(a.get(1).trim());
            
            for (int i = 0; i < mot.size(); i++) {
                if (mot.get(i).getIndex() == number) {
                    mot.remove(i);
                    System.out.println(number + "번 Motivation을 삭제했습니다.");
                    break;
                }
            }

            System.out.println(number + "번 Motivation은 존재하지 않습니다.");

        } catch (Exception e) {
            System.out.println("delete 명령어가 잘못되었습니다.");
        }


    }

    public void modify(String cmd) {
        try {
            List<String> a = new ArrayList<>(Arrays.asList(cmd.split(" ")));
            int number = Integer.parseInt(a.get(1).trim());

            try {
                System.out.print("Motivation : ");
                mot.get(number - 1).setMotivation(sc.nextLine());

                System.out.print("Source : ");
                mot.get(number - 1).setSource(sc.nextLine());

                System.out.println(number + "번 motivation이 수정되었습니다.");

            } catch (IndexOutOfBoundsException e) {
                System.out.println(number + "번 motivation은 존재하지 않습니다.");
            }

        } catch (Exception e) {
            System.out.println("modify 명령어가 잘못되었습니다.");

        }
    }
}