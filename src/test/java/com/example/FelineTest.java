package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    //Feline feline;

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        feline.eatMeat();
        Assert.assertEquals((List.of("Животные", "Птицы", "Рыба")), feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        feline.getFamily();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        feline.getKittens();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int amount = 3;
        feline.getKittens(amount);
        Assert.assertEquals(amount, feline.getKittens(amount));
    }
}