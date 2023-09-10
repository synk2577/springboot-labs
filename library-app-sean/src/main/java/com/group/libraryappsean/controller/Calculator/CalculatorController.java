package com.group.libraryappsean.controller.Calculator;


import com.group.libraryappsean.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryappsean.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    // case1 단점. 받아야하는 query 가 많아진다면 번거로움. 객체를 인자로 받아서 처리하면 간편
//    @GetMapping("/add") // GET /add
//    public int addTowNumbers(@RequestParam int number1, @RequestParam int number2) {
//        return number1 + number2;
//    }

    // case2. dto 를 이용해 query를 객체로 감싸기
    // 장점: query 의 개수가 늘어났을 때 관리 편함.
    @GetMapping("/add") // GET /add
    public int addTowNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") // POST /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        // post 요청의 경우 body 데이터를 parsing 하는 과정(json to obj)이 필요 => @RequestBody
        return request.getNumber1() * request.getNumber2();
    }


}
