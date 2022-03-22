package ru.digitalleague;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//У меня суперглупая проблема, я не смог сделать очистку Storage,
// я понимаю, что надо сделать AfterClass очистку, но как её сделть, я не смог додумать. Я и new Storage генерил, но у меня не работает.
// Возможно, нужно было сделать новый метод, типа Clear для Storage и запускать его после каждого класса. Поэтому в сьюте все тесты валятся, кроме там удалений, потому,
// что работают с данными предыдущих классов, но если их запускать без сьюта, а по отдельности, то всё норм. Или им можно как то параметр задать, чтобы они совсем по
// отдельности запускались.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        addNewObjectTest.class,
        addToExistObjectTest.class,
        getFreePlacesTests.class,
        getProductAmountTest.class,
        TestAddInStorageTest.class,
        TestRemoveStorageTest.class
})
public class SuitTests {

}
