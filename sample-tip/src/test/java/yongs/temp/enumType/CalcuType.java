package yongs.temp.enumType;

import java.util.function.Function;

public enum CalcuType {
    TYPE_A(value -> value),
    Type_B(value -> value * 10),
    Type_C(value -> value *3);

    private Function<Long, Long > expression;

    CalcuType(Function<Long, Long> expression) {
        this.expression = expression;
    }

    public long calcu(long value) {
        return expression.apply(value);
    }
}
