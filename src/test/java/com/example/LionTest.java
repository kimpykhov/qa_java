package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testGetKittens() throws Exception{
        int amount = 3;
        Mockito.when(feline.getKittens()).thenReturn(amount);
        Assert.assertEquals(amount, lion.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Assert.assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
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
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lion.getFood()).thenReturn(expectedListFood);
        List<String> actualListFood =  lion.getFood();
        Assert.assertEquals(expectedListFood, actualListFood);
    }
}