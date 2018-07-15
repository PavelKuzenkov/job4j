package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PhoneDictionaryTest решение задачи части 003 урок 1 1.
 *
 * @author Кузенков Павел.
 * @since 13.06.2018
 */
public class PhoneDictionaryTest {

    /**
     * Test find method.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Br");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}
