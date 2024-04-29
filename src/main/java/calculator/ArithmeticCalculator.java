package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number,N extends Number> extends Calculator{
    AbstractOperation<T,N> abstractOperation;
    static List<Double> Results = new ArrayList<>();//연산자로 계속 돌릴꺼니깐.. 그냥 스태틱으로 안날라가게 하고..
    //static 은 제네릭 안되니깐.. 그냥 더블로 고정!해서 새로 만듬
    ArithmeticCalculator(){

    }
    public double calculate(T firstNumber, N secondNumber,char op) throws BadInputException{
        /* 위 요구사항에 맞게 구현 */
        switch (OperateType.convert(op)){
            case ADD->this.abstractOperation=new AddOperator<>();
            case SUBTRACT-> this.abstractOperation=new SubtractOperator<>();
            case MULTIPLY-> this.abstractOperation=new MultiplyOperator<>();
            case DIVIDE-> {
                if(secondNumber.doubleValue()==0) throw new BadInputException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
                this.abstractOperation=new DivideOperator<>();
            }
            case MOD-> {
                if(secondNumber.intValue()!=secondNumber.doubleValue()) throw new BadInputException("나머지 연산에서  분모(두번째 수)는 실수가 입력될 수 없습니다. ");
                if(secondNumber.doubleValue()==0) throw new BadInputException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
                this.abstractOperation=new ModOperator<>();
            }
            case null->throw new BadInputException("연산자를 잘못 입력하셨습니다.");
        };
        double result = abstractOperation.operate(firstNumber,secondNumber);

        return result;
    }

    public void setAddResults(double value){//추가 하나//이거  int형으로 하나 만들자 ar..에
        //r값 추가 setter
        Results.add(value);
    }
    public void removeResult() {
        /* 구현 */
        Results.removeFirst();
    }
    public void inquiryResults(){
        /* 구현 */
        System.out.print("저장된 결과 값 : ");
        for(double i: Results) {
            System.out.print((int)i+" ");
        }
        System.out.println();
    }

    public List<Double> getResultsGreaterThan(double value) {
        return ArithmeticCalculator.Results.stream()
                .filter(result -> result > value) // 입력값보다 큰 결과만 필터링
                .toList(); // 필터링된 결과를 리스트로 반환
    }
}
