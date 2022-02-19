package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import org.mockito.Spy;
import org.mockito.Mockito;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    private Feline feline;
    @Spy
    private Feline felineSpy = new Feline();

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(expectedListFood);
        List<String> actualListFood = felineSpy.eatMeat();
        Assert.assertEquals(expectedListFood, actualListFood);
    }

    @Test
    public void getFamily() {
        feline.getFamily();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        feline.getKittens();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        int amount = 3;
        feline.getKittens(amount);
        Assert.assertEquals(amount, feline.getKittens(amount));
    }
}