package calculator;

public class ModOperator<T extends Number, N extends Number> extends AbstractOperation<T,N> {

    public double operate(T n1, N n2) {
        return n1.doubleValue() % n2.intValue();
    }
}
