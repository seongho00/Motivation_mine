package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;


public class App {
    public void run() {
        System.out.println("== motivation 실행 ==");

        SystemController systemController = new SystemController(); // systemController class 안에 있는 함수를 사용하기 위해서 객체를 생성한다.
        MotivationController motivationController = new MotivationController(); // motivationController class 안에 있는 함수를 사용하기 위해서 객체를 생성한다.

        while (true) { // while 반복문으로
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim(); // Container class 안에 있는 Scanner함수를 이용해 입력값을 받아 cmd 변수에 넣는다. (이 때, trim 함수를 이용해 양옆의 공백을 없앤다.)

            if (cmd.equals("exit")) { // 명령어가 exit 일 경우
                systemController.exit(); // systemController 클래스 안에 있는 exit 함수를 실행한다.
                break; // 그 후 while 반복문을 탈출한다.

            } else if (cmd.length() == 0) { // 명령어의 길이가 0일 때(아무것도 입력받지 않았을 때)
                System.out.println("명령어가 입력되지 않았음");
                continue; // 그 후 while 반복문을 처음부터 반복한다.
            }

            if (cmd.equals("add")) { // 명령어에 add를 입력받았을 경우
                motivationController.add(); // motivationController class에 있는 add 함수를 실행시킨다.

            } else if (cmd.equals("list")) { // 명령어에 list를 입력받았을 경우
                motivationController.list(); // motivationController class에 있는 list 함수를 실행시킨다.

            } else if (cmd.startsWith("delete?")) { // 명령어가 delete?로 시작할 경우
                motivationController.newDelete(cmd); // motivationController class에 있는 newDelete 함수를 실행시킨다.

            } else if (cmd.startsWith("delete")) { // 명령어가 delete로 시작할 경우
                motivationController.delete(cmd); // motivationController class에 있는 delete 함수를 실행시킨다.

            } else if (cmd.startsWith("edit")) { // 명령어가 edit로 시작할 경우
                motivationController.edit(cmd); // motivationController class에 있는 edit 함수를 실행시킨다.
            } else { // 위의 명령어 말고 다른 명령어가 입력된 경우
                System.out.println("사용할 수 없는 명령어야");
            }
        }
    }
}