package ru.digitalleague;

import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertSame;

public class getProductAmountTest {
        @Test// позитивный тест на количество предметов
        //Ожидаемый результат: 1 пепси
        public void getProductAmount1 () {
            Storage storage = new Storage();
        storage.addObject("Pepsi", 1);
        assertSame(1,storage.getProductAmount("Pepsi"));
    }
    @Test// позитивный тест на количество предметов со стаком.
    //Ожидаемый результат: 3 пепси
    public void getProductAmount2 () {
        Storage.addObject("Pepsi", 1);
        Storage.addObject("Pepsi", 1);
        assertSame(3,Storage.getProductAmount("Pepsi"));
    }
    @Test// Негативный тест на количество предметов с отрицательным значением.
    //Ожидаемый результат: -7 пепси

    public void getProductAmount3 () {
        Storage.addObject("Pepsi", -10);
        assertSame(-7,Storage.getProductAmount("Pepsi"));
    }
    @Test// Негативный тест на негативную границу значений.
            //Ожидаемый результат: обратной границы нет
    public void getProductAmount4 () {
        Storage.addObject("Pepsi", -4);
        assertSame(-11,Storage.getProductAmount("Pepsi"));
    }
    }
