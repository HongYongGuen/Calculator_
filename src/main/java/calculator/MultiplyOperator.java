package calculator;

public class MultiplyOperator<T extends Number, N extends Number> extends AbstractOperation<T,N>{
    @Override
    public double operate(T n1, N n2) {
        return n1.doubleValue()*n2.doubleValue();
    }
}
