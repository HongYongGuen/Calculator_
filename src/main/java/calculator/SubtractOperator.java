package calculator;

public class SubtractOperator<T extends Number, N extends Number> extends AbstractOperation<T,N>{
    @Override
    public double operate(T n1, N n2) {
        /* 구현 */
        return n1.doubleValue()-n2.doubleValue();
    }
}
