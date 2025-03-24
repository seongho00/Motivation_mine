package org.example;

import java.util.Scanner;

// 프로젝트 전역에 써야할 자원을 모아두는 class
public class Container {
    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }

}
