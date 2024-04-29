package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int firstNumber = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int secondNumber = sc.nextInt();
        System.out.print("사칙연산 기호를 입력하세요: ");
        // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        char operation = sc.next().charAt(0);
        int result=0;
        switch (operation){
            case '+'-> result = firstNumber + secondNumber;
            case '-'-> result = firstNumber - secondNumber;
            case '*'-> result = firstNumber * secondNumber;
            case '/'-> {
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
            }
            default -> System.out.println("연산자를 잘못 입력하셨습니다.");
        }
        System.out.println("결과: " + result);
    }
}
