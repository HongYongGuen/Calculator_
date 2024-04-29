package calculator;

public class CircleCalculator extends Calculator{
    static final double PI = 3.14159;
    /* static, final 활용 */
    /* 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */
    public double calculateCircleArea(double radius) {
        /* 원의 넓이 계산 구현 */
        return radius*radius*PI;
    }
    public void inquiryResults(){
        /* 구현 */
        System.out.print("저장된 원의 넓이 값 : ");
        for(double i: results) {
            System.out.printf("%.2f ",i);
        }
        System.out.println();
    }
}
