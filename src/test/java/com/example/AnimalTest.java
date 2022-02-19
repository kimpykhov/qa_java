package com.example;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.security.PublicKey;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test
    public void unknownSort() throws Exception{
        Exception exception = null;
        try {
            Animal animal = new Animal();
            animal.getFood("Челмедведосвин");
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    private final String animalKind;
    private final List ex;

    public AnimalTest(String animalKind, List ex) {
        this.animalKind = animalKind;
        this.ex = ex;
    }

    @Parameterized.Parameters
    public static Object[] getResponse() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
        };
    }

    @Test
    public void checkFood() throws Exception{
        Animal animal = new Animal();
        List act = animal.getFood(animalKind);
        assertEquals(ex, act);
    }
}