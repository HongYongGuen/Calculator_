package calculator;
public class ArithmeticCalculator extends Calculator{
    AbstractOperation abstractOperation;
    ArithmeticCalculator(){

    }
    public int calculate(int firstNumber, int secondNumber,char op) throws BadInputException{
        /* 위 요구사항에 맞게 구현 */
        switch (OperateType.convert(op)){
            case ADD->this.abstractOperation=new AddOperator();
            case SUBTRACT-> this.abstractOperation=new SubtractOperator();
            case MULTIPLY-> this.abstractOperation=new MultiplyOperator();
            case DIVIDE-> {
                if(secondNumber==0) throw new BadInputException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
                this.abstractOperation=new DivideOperator();
            }
            case MOD-> {
                if(secondNumber==0) throw new BadInputException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
                this.abstractOperation=new ModOperator();
            }
            default -> throw new BadInputException("연산자를 잘못 입력하셨습니다.");
        };
        return abstractOperation.operate(firstNumber,secondNumber);
    }

    public void setAddResults(int value){//추가 하나//이거  int형으로 하나 만들자 ar..에
        //r값 추가 setter
        double v = (double)value;
        this.results.add(v);
    }
    public void removeResult() {
        /* 구현 */
        this.results.removeFirst();
    }
    public void inquiryResults(){
        /* 구현 */
        System.out.print("저장된 결과 값 : ");
        for(double i: results) {
            System.out.print((int)i+" ");
        }
        System.out.println();
    }
}
