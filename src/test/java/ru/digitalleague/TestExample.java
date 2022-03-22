package ru.digitalleague;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@Ignore
public class TestExample {

    @Before
    public void setUp(){
        Storage.addObject("apple", 3);
        Storage.addObject("pear", 7);
        Storage.addObject("salt", 0);
    }
    @Test
    public void simpleTest() {
        Storage.removeObject("pear");
        assertFalse(Storage.isInStock("pear"));
    }

}