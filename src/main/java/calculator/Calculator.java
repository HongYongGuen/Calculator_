package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();
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

    public List<Integer> getResults(){
        //참조변수라서 얕은복사 말고 깊은복사로 새로 가져옴;
        return new ArrayList<>(this.results);
    }

    public void setAddResults(int value){
        //r값 추가 setter
        this.results.add(value);
    }
    public void setDelResults(int idx){
        //값 제거 setter
        this.results.remove(idx);
    }
    public void removeResult() {
        /* 구현 */
        this.results.removeFirst();
    }
    public void inquiryResults() {
        /* 구현 */
        System.out.print("저장된 결과 값 : ");
        for(int i: results) {//getter로 가져오기
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
