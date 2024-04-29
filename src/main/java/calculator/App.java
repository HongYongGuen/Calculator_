package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        int[] results = new int[10];
        int idx=0;
        Scanner sc = new Scanner(System.in);
        while(true){
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
            /* 연산의 결과를 배열에 저장합니다. */
            /* index를 증가 시킵니다. */
            results[idx++]=result;
            sc.nextLine();//enter키 받아주기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            String exit = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
            if(exit.toLowerCase().equals("exit")) break;//대소문자 상관없이 exit 입력 확인
        }

    }
}
