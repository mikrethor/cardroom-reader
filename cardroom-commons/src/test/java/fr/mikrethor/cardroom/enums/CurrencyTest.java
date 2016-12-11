package fr.mikrethor.cardroom.enums;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Thor on 2016-12-11.
 */
class CurrencyTest {
    @Test
    public void testToString() {
        System.out.println(Currency.EURO.toString());
        System.out.println(Currency.USD.toString());
        System.out.println(Currency.POUND.toString());
        Assert.assertEquals("",Currency.EURO.toString());
    }
}