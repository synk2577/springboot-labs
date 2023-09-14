package lambda.sec02;

// 매개변수가 없는 람다식
public class LambdaEx {
  public static void main(String[] args) {
    Person person = new Person();

    // 실행문 2개 이상; 중괄호 필요
    person.action(() -> {
      System.out.println("출근을 합니다.");
      System.out.println("프로그래밍을 합니다.");
    });

    // 실행문 1개; 중괄호 필요 없음
    person.action(() -> System.out.println("퇴근합니다."));
  }
}
