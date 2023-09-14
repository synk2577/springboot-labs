package lambda.sec01;


// 인터페이스 익명 구현 객체를 람다식으로 표현하려면, interface 가 abstract method 를 하나만 가져야 함
// interface 가 abstract method 를 하나만 가짐 == functional interface

@FunctionalInterface // @FunctionalInterface 어노테이션: 인터페이스가 함수형 인터페이스임을 보장
public interface Calculable {
  void calculate(int x, int y);
}
