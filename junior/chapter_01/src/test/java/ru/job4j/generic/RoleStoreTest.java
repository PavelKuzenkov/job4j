package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoleStoreTest {

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        RoleStore<Role> simple = new RoleStore<Role>();
        Role role = new Role("Test");
        simple.add(role);
        Role result = simple.findById("Test");
        assertThat(result, is(role));
    }

    @Test
    public void whenReplaceRoleThenReplaced() {
        RoleStore<Role> simple = new RoleStore<Role>();
        Role role1 = new Role("Test1");
        Role role2 = new Role("Test2");
        simple.add(role1);
        int result1 = simple.findPositionById("Test1");
        assertThat(result1, is(0));
        simple.replace("Test1", role2);
        int result2 = simple.findPositionById("Test1");
        assertThat(result2, is(-1));
        Role result3 = simple.findById("Test2");
        assertThat(result3, is(role2));
    }

    @Test
    public void whenDeleteRoleThenDeleted() {
        RoleStore<Role> simple = new RoleStore<Role>();
        Role role1 = new Role("Test1");
        Role role2 = new Role("Test2");
        simple.add(role1);
        simple.add(role2);
        simple.delete("Test1");
        int result1 = simple.findPositionById("Test1");
        assertThat(result1, is(-1));
        int result2 = simple.findPositionById("Test2");
        assertThat(result2, is(0));
    }
}