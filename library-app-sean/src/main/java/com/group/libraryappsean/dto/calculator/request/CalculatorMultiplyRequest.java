package com.group.libraryappsean.dto.calculator.request;

// 해당 DTO는 POST /multiply 요청을 보낼 때 사용
// 즉, @RequestBody 어노테이션을 사용하게 되는데, 이 때는 DTO 클래스에서 생성자를 생성하지 않아도 괜찮다.
public class CalculatorMultiplyRequest {
    private int number1;
    private int number2;

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}
