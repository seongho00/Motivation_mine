package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc; // 지역변수이기 때문에 private로 선언

    // 공유 자원을 모아두는 공간을 초기화
    public static void init() { //
        sc = new Scanner(System.in);
    }

    // 공유 자원을 모아두는 공간 자원 해제
    public static void close() { // main함수가 끝날 때 Scanner도 close하기 위해서 만든 함수.
        sc.close();
    }

    public static Scanner getScanner() { // sc는 private로 보호받고 있기 떄문에 getter를 이용하여 sc 자원을 이용하게끔 설정.
        return sc;
    }
}
