package lambda.sec04;

// 리턴값이 있는 람다식
public class LambdaEx {
  public static void main(String[] args) {
    Person person = new Person();

    // 실행문 두 개 이상
    person.action(((x, y) -> {
      double result = x + y;
      return result;
    }));

    // 리턴문 하나만 있을 때 (with 연산식)
    person.action((x, y) -> {
      return (x + y);
    });

    // 리턴 생략 가능
    person.action((x, y) -> (x + y));

    // // 리턴문 하나만 있을 때 (with 메소드 호출)
    person.action((x, y) -> sum(x, y));
  }

  public static double sum(double x, double y) {
    return (x + y);
  }
}
