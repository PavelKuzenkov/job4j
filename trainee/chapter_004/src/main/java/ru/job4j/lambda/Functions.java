package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class DynamicContainer.
 * @author Kuzenkov Pavel.
 * @since 25.09.2018.
 */

public class Functions {

    /**
     * Calculate values according to input function.
     * @param start beginning of the range.
     * @param end end of the range.
     * @return list of values.
     * */

    private List<Double> function(int start, int end, Function<Integer, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }

    /**
     * Linear function.
     * @param start beginning of the range.
     * @param end end of the range.
     * @return list of values.
     * */

    public List<Double> linearFunction(int start, int end) {
        return this.function(start, end, Double::new);
    }

    /**
     * Square function.
     * @param start beginning of the range.
     * @param end end of the range.
     * @return list of values.
     * */

    public List<Double> squareFunction(int start, int end) {
        return this.function(start, end, (value) -> Math.pow(new Double(value), 2));
    }

    /**
     * Logarithm function.
     * @param start beginning of the range.
     * @param end end of the range.
     * @return list of values.
     * */

    public List<Double> logarithmFunction(int start, int end) {
        return this.function(start, end, (value) -> Math.log(new Double(value)));
    }
}