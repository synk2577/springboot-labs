package lambda.sec04;

@FunctionalInterface
public interface Calculable {
  // functional interface 의 abstract method 가 return 을 가짐
  double calc(double x, double y);
}