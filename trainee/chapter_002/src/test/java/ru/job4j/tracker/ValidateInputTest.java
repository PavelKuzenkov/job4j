package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 02.06.2018
 */
public class ValidateInputTest {

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        "Необходимо ввести корректное значение.".concat(System.lineSeparator())
                )
        );
    }
}