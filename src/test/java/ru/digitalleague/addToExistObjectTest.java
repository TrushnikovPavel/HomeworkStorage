package ru.digitalleague;

import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class addToExistObjectTest {
    @Before//загрузка предметов перед тестом
    public void testAddPreWork() {
        Storage.addObject("Pepsi", 1);
    }
    @Test// Проверка добавления к имеющимся предметам 1 предмета. Метод был приватный, я его поменял на публичный, иначе не работает.
    //Ожидаемый результат: будет 2 пепси.
    public void addToExistObjectTest1 () {
        Storage.addToExistObject("Pepsi", 1);
        assertSame(2, Storage.getProductAmount("Pepsi"));
    }
    @Test// Проверка добавления к имеющимся предметам больше размера полки
    //Ожидаемый результат: добавление не произойдёт
    public void addToExistObjectTest2 () {
        Storage.addToExistObject("Pepsi", 9);
        assertSame(3, Storage.getProductAmount("Pepsi"));
    }
    @Test// Проверка добавления к имеющимся предметам до предела полки.
    //Ожидаемый результат: пепси будет 10, ведь она вмещает только 10 предметов
    public void addToExistObjectTest3 () {
        Storage.addToExistObject("Pepsi", 6);
        assertSame(10, Storage.getProductAmount("Pepsi"));
    }
    @Test// Проверка добавления к имеющимся предметам отрицательного значения
    //Ожидаемый результат: неизвестно, но интересно посмотреть (Он вывел сообщение, что можно добавить только 0 предметов, но потом написал что -9 добавлено.
    // При этом тест прошёл, 10-9=1. Прикольно.)
    public void addToExistObjectTest4 () {
        Storage.addToExistObject("Pepsi", -9);
        assertSame(1, Storage.getProductAmount("Pepsi"));
    }
}
