package lambda.sec05.exam01;

// 메소드 참조
// : 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 함
// 1. 정적 메소드 참조: 클래스 :: 메소드
// 2. 인스턴스 메소드 참조: 참조변수 :: 메소드
public class MethodReferenceExample {
  public static void main(String[] args) {
    Person person = new Person();

    // 정적 메소드
    person.action((x, y) -> Computer.staticMethod(x, y)); // 람다식
    person.action(Computer::staticMethod); // 메소드 참조

    // 인스턴스 메소드
    Computer com = new Computer();
    person.action((x, y) -> com.instanceMethod(x, y)); // 람다식
    person.action(com::instanceMethod); // 메소드 참조
  }
}
