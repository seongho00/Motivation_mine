package org.example.motivation.controller;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    // getter 와 setter
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getParams(String paramName) {
        return params.get(paramName);
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    String cmd; // String 타입 cmd 변수 선언
    private Map<String, String> params; // Map 함수를 이용해 String, String 타입의 key, value를 가지는 params 변수 선언

    public Rq(String cmd) { // String cmd를 매개변수로 받는 Rq 생성자 실행
        this.cmd = cmd; // 매개변수 cmd 값을 Rq안에 있는 cmd 변수 안에 넣기.

        String[] cmdBits = cmd.split("\\?", 2); // cmd의 값을 "?"를 기준으로 2개로 자른 값을 String 배열 cmdBits 변수에 넣음.

        String actionMethod = cmdBits[0]; // cmdBits로 자른 문자열의 0번째 index에 있는 값을 actionMethod 변수에 넣음.

        params = new HashMap<>(); // params라는 변수에 새로운 HashMap 배열을 만듬.

        String[] paramBits; // String 배열 paramBits 선언

        try { // 일단 시도해
            paramBits = cmdBits[1].split("="); // cmdBits로 자른 문자열의 1번째 index에 있는 값을 "="를 기준으로 자르고 그 값들을 paramBits 배열에 넣기
        } catch (Exception e) { //오류 떴어? 그럼 이거 실행시켜
            System.out.println("명령어 예외 상황 발생"); // 문자열 출력
            return; // 아무런 값을 가지지 않고 Rq 생성자 탈출
        }

        String key = paramBits[0]; // paramBits 배열 안에 있는 0번째 index 값을 String 타입 key 변수에 넣기
        String value = paramBits[1]; // paramBits 배열 안에 있는 1번째 index 값을 String 타입 value 변수에 넣기

        System.out.println(" key : " + key + " value : " + value); // key, value 값을 이용한 문자열 출력
        params.put(key, value); // params라는 HashMap 타입의 변수에 key와 value 값을 넣음.
    }
}