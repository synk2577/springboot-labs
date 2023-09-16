package lambda.sec05.exam02;

// 매개변수의 메소드 참조
public class MethodReferenceExample {
  public static void main(String[] args) {
    Person person = new Person();
    person.ordering(String::compareToIgnoreCase);
  }
}
