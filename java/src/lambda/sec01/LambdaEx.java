package lambda.sec01;

// 람다식: 데이터 처리부에 제공되는 함수 역할을 하는 매개변수를 가진 중괄호 블록
// => 데이터 처리부가 람다식을 받아 매개변수에 데이터를 대입하여 중괄호를 실행시켜 처리
public class LambdaEx {
  public static void main(String[] args) {
    action((x, y) -> {
      int result = x + y;
      System.out.println("result : " + result);
    });

    action((x, y) -> {
      int result = x - y;
      System.out.println("result : " + result);
    });

  }

  // 데이터 처리부: 제공된 람다식을 이용해 내부 데이터 처리
  public static void action(Calculable cal) {
    int x = 10;
    int y = 4;
    cal.calculate(x, y);
  }
}
