package org.example.motivation.entity;

public class Motivation {
    private int id; // 이 class 에서만 사용할 수 있는 int 타입 id 변수 선언
    private String body; // 이 class 에서만 사용할 수 있는 String 타입 body 변수 선언
    private String source; // 이 class 에서만 사용할 수 있는 String 타입 source 변수 선언

    public Motivation(int id, String body, String source) { // 생성자(Motivation class가 생성될 때)가 매개변수로 id, body, source로 받으며 실행
        this.id = id; // 매개변수 id 를 Motivation class 안에 있는 id 변수에 넣음
        this.body = body; // 매개 변수 body를 Motivation class 안에 있는 body 변수에 넣음
        this.source = source; // 매개변수 source를 Motivation class 안에 있는 source 변수에 넣음
    }

    // getter 와 setter (private로 변수를 선언했기 때문에 Motivation class 밖에 있는 함수들은 사용할 수 없기 때문에 getter와 setter를 활용하여 변수값을 수정하거나 꺼내옴.)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}