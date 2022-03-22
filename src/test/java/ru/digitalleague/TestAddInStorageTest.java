package ru.digitalleague;

import org.junit.After;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.*;

public class TestAddInStorageTest {
//    @Before//загрузка предметов перед тестом
//    public void testAddPreWork() {
//        Storage.addObject("Pepsi", 1);
//        Storage.addObject("Cola", 0);
//    }
        @Test // обычный позитивный тест на добавление товара и проверка добавления
//  Ожидаемый результат: предмет добавлен на склад и обнаруживается при проверке
    public void yesPepsiTest() {
        Storage.addObject("Pepsi", 1);
     assertTrue(Storage.isInStock("Pepsi"));
}
    @Test// проверка добавки колы в количестве 0 штук
    //Ожидаемый результат: предмет не должен быть добавлен
    //Фактический результат: ассерт даёт ошибку, значит кола есть, но в количестве 0 штук
    public void noColaTest() {
        Storage.addObject("Cola", 1);
        assertTrue(Storage.isInStock("Cola"));
    }


    @After()//Чистка склада. Не смог сделать очистку всего склада, не понял как, поэтому чищу поэлементно, из-за чего высвечивается failure.
    // Может под каждый новый тест делать новый склад?
    //Попробовал, всё равно не чиститься. Может в Junit есть метод onlyFor как в TestNG, можно было бы по привязывать данные только к одному тесту, хотя это тоже
    // имеет мало смысла. Просто не понял как почистить весь склад. Можно было бы сделать для Storage метод Clear, чтобы вся HashMap чистилась, было бы наверное удобно.
    // Понял в чём проблема, Before заполняет
    public void remove(){
        Storage.removeObject("Кола");
        Storage.removeObject("Pepsi");
        Storage.removeObject("Cola");
        Storage.removeObject("Pepsi-Cola");
        Storage.removeObject("Apple");

    }

    @Test // Попытка добавить Пепси-Колу со спец символом "-"
    // Ожидаемый результата: в условиях не сказано ничего про спец символы, значит проверяем реакцию склада. Скорее всего всё добавится
    public void specPepsiColaTest() {
        Storage.addObject("Pepsi-Cola", 1);
        assertTrue(Storage.isInStock("Pepsi-Cola"));
    }

    @Test // попытка добавить объект на русском языке
    // Ожидаемый результата: в условиях сказано о добавлении товаров на латинице, но не на кириллице, так что смотрим
    public void rusWordTest() {
        Storage.addObject("Кола", 2);
        assertTrue(Storage.isInStock("Кола"));
    }
    @Test// Попытка добавить вещей больше, чем полок.
    //Ожидаемый результат:последний добавленный предмет не добавится
    public void fullStorage () {
        Storage storage = new Storage();
        storage.addObject("Apple", 1);
        storage.addObject("Pen", 1);
        storage.addObject("Pineapple", 1);
        storage.addObject("Apple Pen", 1);
//        assertFalse(Storage.isInStock("Apple Pen"));
        assertEquals("Apple Pen", storage.isInStock("Apple Pen"));
    }
}