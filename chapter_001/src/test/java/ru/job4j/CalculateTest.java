package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Kuzenkov Pavel
* @since 10.05.2018
*/
public class CalculateTest {

	/**
	* Test echo.
	*/ @Test

	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Kuzenkov Pavel";
		String expect = "Echo, echo, echo : Kuzenkov Pavel"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}