package ru.digitalleague;

import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestRemoveStorageTest {
    @Before // загрузка предметов перед тестом
    public void testAddPreWork() {
        Storage.addObject("Cola", 0);
        Storage.addObject("Fork", 1);
        Storage.addObject("", 0);// пустой предмет в количестве 0 штук
    }
    @Test// обычный позитивный тест на удаление предмета, который был добавлен в хранилище
    //Ожидаемый результат: предмет будет удалён
    public void testRemove() {
        Storage.removeObject("Fork");
        assertFalse(Storage.isInStock("Fork"));
    }
    @Test// Негативный тест на удаление предмета, который был добавлен в количестве 0 штук.
            //Ожидаемый результат: предмет не должен быть удалён, хотя дать пользователю возможность удалять несуществующие предметы никак не повлияет на работу склада
            //Наверное плохой тон в 1 тест класть тесты, которые можно было бы разделить? Наверное, тогда разделю.
    public void testRemove1() {
        Storage.removeObject("Cola");
        assertFalse(Storage.isInStock("Cola"));
    }
        @Test// Тест на удаление не существующего предмета
                // Ожидаемый результат: выведется сообщение об отсутствии такого предмета на складе
         public void testRemove2() {
            Storage.removeObject("Soda");
            assertFalse(Storage.isInStock("Soda"));
        }

    @Test// Негативный тест на удаление "Пустого" объекта в количестве 0 штук
            // Ожидаемый результат: судя по предыдущим тестам должно произойти удаление, но лучше добавить какое-нибудь исключение
           // добавления пустых предметов или предметов в количестве 0 штук, чтобы пользователь по ошибке не забивал склад пустыми объектами
    public void testRemove3 (){
        Storage.removeObject("");
        assertFalse(Storage.isInStock(""));
    }
//    @Test
//    public void testRemove3 (){
//        Storage.removeObject()
//    }

}
