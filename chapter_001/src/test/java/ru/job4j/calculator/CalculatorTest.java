package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 11.05.2018
 */

public class CalculatorTest {

    /**
     * Test add.
     */@Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1d, 1d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */@Test
    public void whenSubtractThreeMinusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.subtract(3d, 1d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */@Test
    public void whenDivFourDivideTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4d, 2d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */@Test
    public void whenMultipleTwoMultiplyTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2d, 2d);
        double result = calc.getResult();
        double expected = 4d;
        assertThat(result, is(expected));
    }
}
