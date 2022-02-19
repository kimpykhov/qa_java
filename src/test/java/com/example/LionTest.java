package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        int amount = 3;
        lion.getKittens();
        Assert.assertEquals(amount, feline.getKittens(3));
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.doesHaveMane();
        Assert.assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeBaba() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.doesHaveMane();
        Assert.assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeElse() throws Exception {
        Exception exception = null; // делаем переменную для потенциального исключения
        try {
            Lion lion = new Lion("Не самец ", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getFoods() throws Exception{
        Lion lion = new Lion("Самец", feline);
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lion.getFood()).thenReturn(expectedListFood);
        List<String> actualListFood =  lion.getFood();
        Assert.assertEquals(expectedListFood, actualListFood);
    }
}