package ru.digitalleague;

import org.junit.AfterClass;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertSame;

public class getFreePlacesTests {
    @Test// Проверка оставшихся полок
    //Ожидаемый результат:будет 2 свободных полки
    public void getFreePlacesTest1() {
        Storage.addObject("Pepsi", 1);
        assertSame(2,Storage.getFreePlaces());
}
    @Test// Проверка оставшихся полок при полном заполнении
    //Ожидаемый результат:будет 0 свободных полки
    public void getFreePlacesTest2() {
        Storage.addObject("Shweps", 1);
        Storage.addObject("Fanta", 1);
        assertSame(0,Storage.getFreePlaces());
    }
    @Test// Проверка оставшихся полок при заполнении больше нормы
    //Ожидаемый результат:будет 0 свободных полки
    public void getFreePlacesTest3() {
        Storage.addObject("Beer", 1);
        assertSame(0,Storage.getFreePlaces());
    }
    @Test// Проверка оставшихся полок при заполнении отрицательными значениями, которые должны привести старые значения в 0
    //Ожидаемый результат:будет 0 свободных полки, но они будут с объектами в количестве 0
    public void getFreePlacesTest4() {
        Storage.addObject("Pepsi", -1);
        Storage.addObject("Shweps", -1);
        Storage.addObject("Fanta", -1);
        assertSame(0,Storage.getFreePlaces());
    }
}
