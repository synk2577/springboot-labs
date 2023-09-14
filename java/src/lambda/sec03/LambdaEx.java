package lambda.sec03;

// 매개변수 있는 람다식
public class LambdaEx {
  public static void main(String[] args) {
    Person person = new Person();

    // 매개변수 두 개일 경우; () 필요
    person.action1((name, job) -> {
      System.out.print(name + "이 ");
      System.out.println(job + "을 합니다.");
    });
    person.action1((name, job) -> System.out.println(name + "이" + job + "을 하지 않습니다."));

    // 매개변수 한 개일 경우; () 필요 없음
    person.action2((txt -> System.out.println("\"" + txt + "\" 라고 말합니다.")));
  }
}
