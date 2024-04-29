package calculator;

import java.util.*;

public class App {

    public static void main(String[] args) {
        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        Calculator calculator = new Calculator();//Calculatro 객체 생성
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
            try {
                result = calculator.calculate(firstNumber, secondNumber, operation);
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("결과: " + result);
            sc.nextLine();//enter키 받아주기
            /* 연산의 결과를 배열에 저장합니다. */
            calculator.results.add(result);//값 리스트에 추가
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            /* 위 요구사항에 맞게 구현 */
            String remove = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
            if(remove.toLowerCase().equals("remove")) calculator.results.removeFirst();//대소문자 상관없이  입력 확인 첫번째 요소 삭제
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            /* 위 요구사항에 맞게 구현 */
            String inquiry = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
            if(inquiry.toLowerCase().equals("inquiry")){
                System.out.print("저장된 결과 값 : ");
                for(int i: calculator.results) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
                //대소문자 상관없이 입력 확인 및 출력
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            String exit = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
            if(exit.toLowerCase().equals("exit")) break;//대소문자 상관없이 exit 입력 확인
        }

    }
}
