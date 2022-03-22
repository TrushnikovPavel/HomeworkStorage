package ru.digitalleague;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertSame;

public class addNewObjectTest { //немного не понял метод addNewObject, он позволяет добавлять новые предметы с одинаковыми именами и они будут считаться разными?

        Storage storage = new Storage();
    @Test//Добавление одинаковых предметов через addNewObject.
    //Ожидаемый результат: наверное будет по одному предмету с именем и в количестве 1 штука, и они не будут стакаться.
    // В этом же классе проверю просто через addObject, будут ли они стакаться между собой и с добавленными через addNewObject.
    public void addNewObjectTest1() {
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        assertSame(3, Storage.getProductAmount("Pepsi"));
    }

    @Test // Попытка стакать через обычный addObject.
    //Ожидаемый результат: предметы стакнутся, но по какой логике? Равномерно распределятся и будет 2 Pepsi или зайдут в один из объектов Pepsi и их там будет 4?
    //Или вообще сгенерится ещё один Pepsi и их там будет 3?
    //Зашло в один объект, очень интересно.
    public void addNewObjectTest2() {
        Storage.addObject("Pepsi", 1);
        Storage.addObject("Pepsi", 1);
        Storage.addObject("Pepsi", 1);
        assertSame(4, Storage.getProductAmount("Pepsi"));
    }

    @Test // Может addNewObject создаёт новую полку для одинаковых предметов?
    //Ожидаемый результат: неизвестно
    //не получилось. В следующем попробую наделать много одинаковых Pepsi и посмотреть будет ли склад их ограничивать.
    public void addNewObjectTest3() {
        Storage.addNewObject("Pepsi", 9);
        assertSame(4, Storage.getProductAmount("Pepsi"));
    }

    @Test// Создание много Pepsi.
    //Ожидаемый результат:склад будет заполнен и ограничен.
    //Видимо вызов каждого addNewObject переписывает старый и склад не забивается
    public void addNewObjectTest4() {
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        Storage.addNewObject("Pepsi", 1);
        assertSame(3,Storage.getFreePlaces());
    }
}