package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.entity.Motivation;
import org.example.motivation.service.MotivationService;

import java.util.*;

public class MotivationController {

    private MotivationService motivationService; // MotivationService 객체를 담을 변수를 선언.


    public MotivationController() { // 생성자를 통해 MotivationController가 생성될 때(new) 실행
        motivationService = new MotivationService(); // 변수에 새로운 MotivationService 객체를 잇는 주소를 담음.
    }

    public void add() { // MotivationController의 add함수

        System.out.print("body : "); // 문자열 출력
        String body = Container.getScanner().nextLine(); // Container class 안에 있는 Scanner 함수를 이용하여 입력값 받기
        System.out.print("source : "); // 문자열 출력
        String source = Container.getScanner().nextLine(); // Container class 안에 있는 Scanner 함수를 이용하여 입력값 받기

        int id = motivationService.add(body, source); //motivationService class 안에 있는 add 함수에 인자 body, source를 넣고 int 값을 리턴시켜 id 변수에 담음.

        System.out.printf("%d번 motivation이 등록됨\n", id); // id 값을 넣어 출력

    }

    public void list() { // MotivationController의 list함수
        motivationService.showList(); // motivationService class 안에 있는 showList 함수 실행
    }

    public void delete(String cmd) { // MotivationController의 delete함수 (매개변수 String cmd)
        int id = Integer.parseInt(cmd.split(" ")[1]); // 매개변수로 받은 cmd(명령어)를 공백을 기준으로 나누고 1번 index에 있는 String 값을 int로 변환한 후 id 변수에 값을 담음.

        int foundIndex = motivationService.getIndexById(id); // motivationService class 안에 있는 getIndexById 함수를 인자로 id를 받고 실행시킨 후 return된 int 값을 foundeIndex 변수에 담음.

        if (foundIndex == -1) { // foundIndex의 값이 -1일 때
            System.out.println("해당 moti는 없던데????"); // 문자열 출력
            return; // 아무값 리턴하지 않고 바로 delete 함수를 종료시킴.
        }

        motivationService.doDelete(id); // motivationService class에 있는 doDelete 함수를 id를 인자로 받고 실행시킴.

        System.out.println(id + "번 moti 삭제됨"); // id 값을 넣어 문자열 출력
    }


    public void newDelete(String cmd) { // MotivationController의 newDelete함수 (매개변수 Strind cmd)
        Rq rq = new Rq(cmd); // Rq class 안에 있는 함수를 사용하기 위해 객체 리모콘을 rq변수에 담음. (이 때, Rq 생성자 안에 인자 cmd를 넣음)

        System.out.println("rq.getParams(\"id\") : " + rq.getParams("id")); // Rq class 안에 있는 getParmas 함수를 인자로 "id"를 받고 실행시킴.

        int id = Integer.parseInt(rq.getParams("id")); // Rq class 안에 있는 getParmas 함수를 인자로 "id"를 받고 실행시킨 후 return 받은 int 타입의 값을 id에 넣음.

        Motivation foundMotivation = null; // Motivation 타입 foundMotivation 변수 안에 null 값을 넣음.

        for (Motivation motivation : motivationService.getMotivations()) { // motivationService class 안에 있는 getMotivations함수를 이용하여 motivations 값들을 하나씩 꺼내어 Motivation 타입 motivation 에 넣으며 모두 꺼낼 때까지 반복함.
            if (motivation.getId() == id) { // motivation 객체 안에 있는 getId 함수를 실행시킨 후 return된 int 값이 id 와 같을 경우
                foundMotivation = motivation; // foundMotivation 변수에 motivation과 이어진 주소를 넣음.
                break; // for 반복문 탈출
            }
        }

        if (foundMotivation == null) { // foundMotivation 이 null값일 경우
            System.out.println("해당 moti는 없던데????"); // 문자열 출력
            return; // 아무값 리턴하지 않고 바로 newDelete 함수를 종료시킴.
        }

        motivationService.getMotivations().remove(foundMotivation); // motivationService class 안에 있는 getMotivations함수를 이용하여 motivations를 꺼내와서 foundMotivation 객체를 제거함.
        System.out.println(id + "번 moti 삭제됨"); // id 값을 넣어 문자열 출력
    }

    public void edit(String cmd) { // MotivationController의 edit함수 (매개변수 Strind cmd)
        int id; // int 타입 id 변수 선언.
        try { // 일단 시도해봐.
            id = Integer.parseInt(cmd.split(" ")[1]); // 매개변수로 받은 cmd(명령어)를 공백을 기준으로 나누고 1번 index에 있는 String 값을 int로 변환한 후 id 변수에 값을 담음.
        } catch (ArrayIndexOutOfBoundsException e) { // ArrayIndexOutOfBoundsException 라는 오류가 발생했어? 이거 실행해
            System.out.println("명령어 확인해라"); // 문자열 출력
            return; // 아무값 리턴하지 않고 바로 edit 함수를 종료시킴.
        }

        Motivation foundMotivation = motivationService.findById(id); // motivationService class에 있는 findById 함수를 id를 인자로 받고 실행시키고 return 받은 Motivation 타입의 값을 foundMotivation에 대입.

        if (foundMotivation == null) { // foundMotivation 이 null값일 경우
            System.out.println("해당 moti는 없던데????"); // 문자열 출력
            return; // 아무값 리턴하지 않고 바로 edit 함수를 종료시킴.
        }

        motivationService.doEdit(foundMotivation); // motivationService class에 있는 doEdit 함수를 foundMotivation를 인자로 받고 실행시킴

        System.out.println(id + "번 moti 수정됨"); // 문자열 출력
    }
}