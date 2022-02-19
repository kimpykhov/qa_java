package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Predator predator;
    Animal animal;

    @Test
    public void getSound() {
       Cat cat = new Cat(feline);
       Assert.assertEquals("Мяу", cat.getSound());
    }

//    @Test
//    public void getFood() throws Exception{
//        Cat cat = new Cat(feline);
//        animal.getFood("Хищник");
//        //cat.getFood();
//        //Assert.assertEquals((List.of("Животные", "Птицы", "Рыба")), cat.getFood());
//        Assert.assertEquals((List.of("Животные", "Птицы", "Рыба")), animal.getFood("Хищник"));
//    }
}