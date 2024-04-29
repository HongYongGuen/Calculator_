package calculator;

import java.util.*;

public class App {

    public static void main(String[] args) {
        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        //객체 2개 만들기
        ArithmeticCalculator<Integer,Integer> calculator =new ArithmeticCalculator<>();
        CircleCalculator circleCalculator = new CircleCalculator();
        Scanner sc = new Scanner(System.in);
        while(true){
            /* 사칙연산을 진행할지 원의 너비를 구할지 선택 구현 */
            System.out.print("사칙연산을 하려면 1, 원의 널이블 구하려면 2를 입력해주세요: ");
            int sw = sc.nextInt();
            while(sw!= 1 && sw!=2){
                System.out.println("1 또는 2를 입력해주세요");
                System.out.print("사칙연산을 하려면 1, 원의 널이블 구하려면 2를 입력해주세요: ");
                sw = sc.nextInt();
            }
            if(sw==2){//원의 널이
                System.out.print("반지름을 입력하세요: ");
                /* 원의 넓이를 구하는 경우 반지름을 입력받아 원의 넓이를 구한 후 출력*/
                double radius = sc.nextDouble();
                /* 원의 넓이 저장 */
                double result = circleCalculator.calculateCircleArea(radius);
                System.out.println("원의 널이: " + result);
                circleCalculator.setAddResults(result);
                sc.nextLine();//엔터키 입력 지우기
                /* 저장된 원의 넓이 값들 바로 전체 조회 */
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                /* 위 요구사항에 맞게 구현 */
                String inquiry = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
                if(inquiry.toLowerCase().equals("inquiry")) circleCalculator.inquiryResults();
                //대소문자 상관없이 입력 확인 및 출력
            }
            else{//사칙연산
                Integer num_1_Int=null,num_2_Int = null;
                Double num_1_Db = null,num_2_Db = null;
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                String str = sc.next();
                try{//정수인지 입력받아보기
                    num_1_Int = Integer.parseInt(str);
                }
                catch(NumberFormatException e1){
                    try{//실수인지 입력 받아보기
                        num_1_Db = Double.parseDouble(str);
                    }
                    catch (NumberFormatException e2){//둘다 아니다 다시
                        System.out.println("정수나 실수 중에 입력해주세요");
                        continue;
                    }
                }
                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                str = sc.next();
                try{//정수인지 입력받아보기
                    num_2_Int = Integer.parseInt(str);
                }
                catch(NumberFormatException e1){
                    try{//실수인지 입력 받아보기
                        num_2_Db = Double.parseDouble(str);
                    }
                    catch (NumberFormatException e2){//둘다 아니다 다시
                        System.out.println("정수나 실수 중에 입력해주세요");
                        continue;
                    }
                }
                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                char op = sc.next().charAt(0);
                // 사실 4가지의 경우가 있는데  정정, 정실, 실실, 실정.. 그냥 2개로 만들자 앞에 수정
                // 근데 솔찍히 말하면.. 오버로딩이 훨씬 좋은 상황인데.. 왜 왜왜 제네릭이야..
                //일단 여기 오면 정정 아님 실실 아 리저트는 그냥 하나로 통일.. 너무 변수 많고 복잡해진다.
                //아 8가지 경우 만들려면 null로 할까.. sw로 할까..
                double result;
                try{
                    if(num_1_Int != null) {
                        if (num_2_Int != null) {//둘다 정수
                            ArithmeticCalculator<Integer, Integer> arithmeticCalculator = new ArithmeticCalculator<>();
                            result=arithmeticCalculator.calculate(num_1_Int,num_2_Int,op);
                        } else {//num2 실수
                            ArithmeticCalculator<Integer, Double> arithmeticCalculator = new ArithmeticCalculator<>();
                            result=arithmeticCalculator.calculate(num_1_Int,num_2_Db,op);
                        }
                    }else{
                        if (num_2_Int != null) {//num1만 실수
                            ArithmeticCalculator<Double, Integer> arithmeticCalculator = new ArithmeticCalculator<>();
                            result=arithmeticCalculator.calculate(num_1_Db,num_2_Int,op);
                        } else {//둘다 실수
                            ArithmeticCalculator<Double, Double> arithmeticCalculator = new ArithmeticCalculator<>();
                            result=arithmeticCalculator.calculate(num_1_Db,num_2_Db,op);

                        }
                    }
                } catch (BadInputException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.println("결과: " + result);
                ArithmeticCalculator.Results.add(result);
                sc.nextLine();//enter키 받아주기
                /* 연산의 결과를 배열에 저장합니다. */

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                /* 위 요구사항에 맞게 구현 */
                String remove = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
                if(remove.toLowerCase().equals("remove")) calculator.removeResult();//대소문자 상관없이  입력 확인 첫번째 요소 삭제
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
                if(inquiry.toLowerCase().equals("inquiry")) {
                    System.out.println("입력받은 수 보다 큰 수를 조회합니다.");
                    double inquiryNum = Double.parseDouble(sc.nextLine());
                    List<Double> imsi=calculator.getResultsGreaterThan(inquiryNum);
                    System.out.print(inquiryNum+"보다 큰 값 : ");
                    for(double i : imsi){
                        System.out.printf("%.2f ",i);
                    }
                    System.out.println();

                    //calculator.inquiryResults();
                }
                //대소문자 상관없이 입력 확인 및 출력


            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            String exit = sc.nextLine();//enter키만 쳐도 넘어가게 nextLine()으로 입력
            if(exit.toLowerCase().equals("exit")) break;//대소문자 상관없이 exit 입력 확인
        }

    }
}
