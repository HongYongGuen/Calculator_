package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    //1 둘다 있는거 하나만 있는걸로 분리
    //2. list는 동일한거 하나로 쓸까? 굳이.. 두개..하면 상속할 이유가 없음 double형으로 하나로 통일
    List<Double> results;
    //자식 접근할수 있게 default로 변경
    //static final 고정되어서 변하지 않는 수 원의 넓이 에서는 PI가 활용될 수 있다.
    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    /* 생성자 수정 */
    Calculator (){
         this.results= new ArrayList<>();
    }
    public List<Double> getResults(){//1개
        //참조변수라서 얕은복사 말고 깊은복사로 새로 가져옴;
        return new ArrayList<>(this.results);
    }
    public void setAddResults(double value){//추가 하나//이거  int형으로 하나 만들자 ar..에
        //r값 추가 setter
        this.results.add(value);
    }
    public void setDelResults(int idx){
        //값 제거 setter
        this.results.remove(idx);
    }
    public void inquiryResults() {

    }//걍 틀만 만들고 두개 따로
}
