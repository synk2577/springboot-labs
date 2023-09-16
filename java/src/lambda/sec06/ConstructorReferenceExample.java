package lambda.sec06;

// 생성자 참조
// == 객체 생성

// (a, b) -> { return new 클래스(a, b); }
// 클래스 :: new

// 여러 개의 생성자가 있는 경우, 함수형 인터페이스와 추상 메소드가 동일한 매개변수 타입과 개수를 가지고 있는 생성자를 찾아 실행
public class ConstructorReferenceExample {
  public static void main(String[] args) {
    Person person = new Person();

    Member m1 = person.getMember1(Member::new);
    System.out.println(m1);
    System.out.println();

    Member m2 = person.getMember2(Member::new);
    System.out.println(m2);
  }
}
