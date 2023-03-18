package fr.istic.vv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, 2022));
        assertTrue(Date.isValidDate(31, 1, 2022));
        assertTrue(Date.isValidDate(29, 2, 2020));
        assertTrue(Date.isValidDate(28, 2, 2021));
        assertFalse(Date.isValidDate(29, 2, 2021));
        assertTrue(Date.isValidDate(31, 3, 2022));
        assertFalse(Date.isValidDate(31, 4, 2022));
        assertTrue(Date.isValidDate(30, 4, 2022));
        assertTrue(Date.isValidDate(31, 5, 2022));
        assertFalse(Date.isValidDate(31, 6, 2022));
        assertTrue(Date.isValidDate(30, 6, 2022));
        assertTrue(Date.isValidDate(31, 7, 2022));
        assertTrue(Date.isValidDate(31, 8, 2022));
        assertFalse(Date.isValidDate(31, 9, 2022));
        assertTrue(Date.isValidDate(30, 9, 2022));
        assertTrue(Date.isValidDate(31, 10, 2022));
        assertFalse(Date.isValidDate(31, 11, 2022));
        assertTrue(Date.isValidDate(30, 11, 2022));
        assertTrue(Date.isValidDate(31, 12, 2022));
        assertFalse(Date.isValidDate(32, 12, 2022));
        assertFalse(Date.isValidDate(31, -1, 2022));
        assertFalse(Date.isValidDate(31, 13, 2022));
    }

    @Test
    public void testNextDate() {
        Date date = new Date(28, 2, 2020);
        Date nextDate = date.nextDate();
        assertEquals(29, nextDate.day);
        assertEquals(2, nextDate.month);
        assertEquals(2020, nextDate.year);
        date = new Date(28, 2, 2021);
        nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(3, nextDate.month);
        assertEquals(2021, nextDate.year);
        date = new Date(30, 6, 2022);
        nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(7, nextDate.month);
        assertEquals(2022, nextDate.year);
        date = new Date(31, 12, 2022);
        nextDate = date.nextDate();
        assertEquals(1, nextDate.day);
        assertEquals(1, nextDate.month);
        assertEquals(2023, nextDate.year);
    }

    @Test
    public void testPreviousDate() {
        Date date = new Date(29, 2, 2020);
        Date prevDate = date.previousDate();
        assertEquals(28, prevDate.day);
        assertEquals(2, prevDate.month);
        assertEquals(2020, prevDate.year);
        date = new Date(1, 3, 2021);
        prevDate = date.previousDate();
        assertEquals(28, prevDate.day);
        assertEquals(2, prevDate.month);
        assertEquals(2021, prevDate.year);
        date = new Date(1, 7, 2022);
        prevDate = date.previousDate();
        assertEquals(30, prevDate.day);
        assertEquals(6, prevDate.month);
        assertEquals(2022, prevDate.year);
        date = new Date(1, 1, 2023);
        prevDate = date.previousDate();
        assertEquals(31, prevDate.day);
        assertEquals(12, prevDate.month);
        assertEquals(2022, prevDate.year);
    }

    @Test
    public void testLeapYear() {
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(2021));
        assertFalse(Date.isLeapYear(2022));
        assertFalse(Date.isLeapYear(2023));
        assertTrue(Date.isLeapYear(2024));
        assertTrue(Date.isLeapYear(2028));
        assertFalse(Date.isLeapYear(2100));
        assertTrue(Date.isLeapYear(2400));
    }


    @Test
    public void testCompareToBefore() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(2, 2, 2021);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    public void testCompareToAfter() {
        Date date1 = new Date(2, 2, 2021);
        Date date2 = new Date(1, 1, 2020);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    public void testCompareToEqual() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 1, 2020);
        assertTrue(date1.compareTo(date2) == 0);
    }

    @Test
    public void testCompareToSameMonth() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(15, 1, 2020);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    public void testCompareToSameYear() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 12, 2020);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    public void testCompareToSameDay() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 1, 2021);
        assertTrue(date1.compareTo(date2) < 0);
    }

}




