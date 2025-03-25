package org.example;


public class Main {
    public static void main(String[] args) {
        Container.init(); // Container class에 있는 init 함수 실행 (객체 생성을 안 했기 때문에 static으로 선언되어 있음.)

        new App().run(); // App 객체를 만들면서 run 함수를 실행함.

        Container.close(); // Container class에 있는 closd 함수 실행
    }
}