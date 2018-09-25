package ru.job4j.lambda;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.Arrays;

public class FunctionsTest {

    @Test
    public void linearFunction() {
        Functions functions = new Functions();
        assertThat(functions.linearFunction(1, 3), is(Arrays.asList(1.0, 2.0, 3.0)));
    }

    @Test
    public void squareFunction() {
        Functions functions = new Functions();
        assertThat(functions.squareFunction(1, 3), is(Arrays.asList(1.0, 4.0, 9.0)));
    }

    @Test
    public void logarithmFunction() {
        Functions functions = new Functions();
        assertThat(functions.logarithmFunction(1, 3), is(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098)));
    }
}
