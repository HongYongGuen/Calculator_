package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Integer> results = new ArrayList<>();
    public int calculate(int firstNumber, int secondNumber, char operation) throws BadInputException{
        /* 위 요구사항에 맞게 구현 */
        return switch (operation){//switch문 사용.. 오류는 프로그램 끝나니깐 yield 안만들어줌
            case '+'-> firstNumber + secondNumber;
            case '-'-> firstNumber - secondNumber;
            case '*'-> firstNumber * secondNumber;
            case '/'-> {
                if (secondNumber != 0) yield firstNumber / secondNumber;
                else throw new BadInputException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            default -> throw new BadInputException("연산자를 잘못 입력하셨습니다.");
        };
    }
}
