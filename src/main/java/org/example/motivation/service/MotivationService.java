package org.example.motivation.service;

import org.example.Container;
import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {
    // getter
    public List<Motivation> getMotivations() {
        return motivations;
    }

    private List<Motivation> motivations; // List 배열 Motivation 타입 motivations 변수 선언
    int lastId; // id가 몇번쨰까지 이루어지는 알기 위한 int 변수 선언

    public MotivationService() { // 생성자
        motivations = new ArrayList<>();// motivation 객체들을 저장하기 위한 저장소
        lastId = 0; // MotivationService class가 생성될 때 순서를 바로 0으로 선언
    }

    public int add(String body, String source) { // body, source를 매개변수로 받는 add 함수
        int id = lastId + 1; // add로 함수가 실행될 떄 마다 id가 1씩 증가
        Motivation motivation = new Motivation(id, body, source); // id, body, source를 인자로 넣어 새로운 객체 motivation 생성.
        motivations.add(motivation); // motivations List 배열에 방금 만든 motivation을 저장

        lastId = id; // 다음에도 번호를 증가시킬 것이기 때문에 lastdId 변수를 지금의 id로 갱신

        return id; // id를 return시킴
    }

    public void showList() { // showList 함수
        if (motivations.size() == 0) { // List 배열 motivations에 아무것도 없을 경우
            System.out.println("등록된 moti 없어"); // 문자열 출력
            return; // 아무런 리턴값 없이 showList 함수 종료
        }

        System.out.println("=".repeat(40)); // 문자열 출력
        System.out.printf("   id    /     source      /      body        \n"); // 문자열 출력

        for (int i = motivations.size() - 1; i >= 0; i--) { // motivatons List 배열의 마지막 index 부터 0까지 반복
            Motivation motivation = motivations.get(i); // motivations List 배열에 있는 i번째 index Motivation 객체를 motivation 변수와 연결

            if (motivation.getSource().length() > 7) { // motivation 객체 안에 있는 getSource 함수를 이용해 Source 를 가져오고 이 Source 의 길이가 7보다 클 경우
                System.out.printf("   %d    /     %s     /      %s        \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody()); // motivation에 getId, getSource, getBody 를 이용해 Id, Source, Body 값을 가져와 출력
                // 이때, Source의 문자열은 index 0부터 4까지만 출력
                continue; // 이후 바로 다음 for 반복문을 실행함.
            }
            System.out.printf("   %d    /     %s        /      %s        \n", motivation.getId(), motivation.getSource(), motivation.getBody()); // motivation 에 getId, getSource, getBody 를 이용해 Id, Source, Body 값을 가져와 출력
        }

        System.out.println("=".repeat(40)); // 문자열 출력
    }

    public int getIndexById(int id) { // int 타입 id 변수를 매개변수로 받는 getIndexById 함수
        int foundIndex = -1; // int 타입 foundIndex 를 -1값으로 선언
        for (int i = 0; i < motivations.size(); i++) { // List 배열 motivations 의 크기만큼 반복
            Motivation motivation = motivations.get(i); // List 배열 motivations 의 i 번째 Motivation 객체를 motivation 변수와 연결
            if (motivation.getId() == id) { // motivation 객체의 getId를 통해 얻은 Id 값과 매개변수로 받은 id 값이 같을 경우
                foundIndex = i; // foundIndex 의 값은 i로 선언
                break; // for 반복문 탈출
            }
        }

        return foundIndex; //foundIndex 값을 return 시킴
    }

    public void doDelete(int id) { // int 타입 id 매개변수를 받는 doDelete 함수
        int foundIndex = getIndexById(id); // getIndexById 함수에 id 인자를 넣고 return 받은 값을 int 타입 foundIndex 값에 저장
        motivations.remove(foundIndex); // List 배열 motivations 에 있는 foundIndex 번째의 객체를 삭제시킴.
    }

    public Motivation findById(int id) { // int 타입 id 매개변수를 받는 findById 함수
        for (Motivation motivation : motivations) { // List 배열 motivations 안에 있는 motivation 객체들을 하나씩 꺼내어 모두 꺼낼때까지 반복
            if (motivation.getId() == id) { // motivation 객체 안에 있는 함수 getId를 통해 얻은 Id 값과 매개변수로 받은 id 값이 같으 경우
                return motivation; // motivation 객체를 return 시킴
            }
        }
        return null; // null 값을 return 시킴
    }

    public void doEdit(Motivation foundMotivation) { // Motivation 타입 foundMotivation 값을 매개변수로 받는 doEdit 함수
        System.out.println("body(기존) : " + foundMotivation.getBody()); // foundMotivation 객체 안에 있는 getBody 함수를 이용해 Body 값을 얻고 문자열 출력
        System.out.println("source(기존) : " + foundMotivation.getSource()); // foundMotivation 객체 안에 있는 getSource 함수를 이용해 Source 값을 얻고 문자열 출력

        String newBody; // String 타입 newBody 변수 선언
        String newSource; // String 타입 newSource 변수 선언
        while (true) { // 항상 반복
            System.out.print("new body : "); // 문자열 출력
            newBody = Container.getScanner().nextLine().trim(); // Container class 안에 있는 getScanner 함수를 이용해 Scanner 를 사용하여 받은 문자열을 newBody 변수에 저장
            // 이때, trim 함수를 통해 양옆의 공백을 없앰.

            if (newBody.length() != 0) { // newBody 변수 안에 있는 문자열 길이가 0이 아닐 경우
                break; // while 반복문 탈출
            }
            System.out.println("수정사항(body) 입력해"); // 문자열 출력
        }

        while (true) { //항상 반복
            System.out.print("new source : "); // 문자열 출력
            newSource = Container.getScanner().nextLine();// Container class 안에 있는 getScanner 함수를 이용해 Scanner 를 사용하여 받은 문자열을 newSource 변수에 저장
            // 이때, trim 함수를 통해 양옆의 공백을 없앰.

            if (newSource.length() != 0) { // newSource 변수 안에 있는 문자열 길이가 0이 아닐 경우
                break; // while 반복문 탈출
            }
            System.out.println("수정사항(source) 입력해"); // 문자열 출력
        }

        foundMotivation.setBody(newBody); // foundMotivation 객체 안에 있는 setBody 함수를 통해 Body 변수의 값을 newBody 의 값으로 설정
        foundMotivation.setSource(newSource); // foundMotivation 객체 안에 있는 setSource 함수를 통해 Source 변수의 값을 newSource 의 값으로 설정
    }
}
