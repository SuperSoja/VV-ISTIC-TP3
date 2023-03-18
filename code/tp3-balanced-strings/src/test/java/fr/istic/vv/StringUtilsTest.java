package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void testIsBalanced_F1() {
        assertFalse(isBalanced(null));
    }

    @Test
    public void testIsBalanced_F2() {
        assertFalse(isBalanced("("));
    }

    @Test
    public void testIsBalanced_F3() {
        assertFalse(isBalanced("({}[]"));
    }

    @Test
    public void testIsBalanced_F4() {
        assertFalse(isBalanced("{(}[)]"));
    }

    @Test
    public void testIsBalanced_F5() {
        assertFalse(isBalanced("["));
    }

    @Test
    public void testIsBalanced_F6() {
        assertFalse(isBalanced("{"));
    }

    @Test
    public void testIsBalanced_F7() {assertFalse(isBalanced(")")); }

    @Test
    public void testIsBalanced_F8() {
        assertFalse(isBalanced("]"));
    }

    @Test
    public void testIsBalanced_F9() {
        assertFalse(isBalanced("}"));
    }

    @Test
    public void testIsBalanced_F10() {
        assertFalse(isBalanced("(]"));
    }

    @Test
    public void testIsBalanced_F11() {
        assertFalse(isBalanced("{)"));
    }

    @Test
    public void testIsBalanced_F12() {
        assertFalse(isBalanced("[}"));
    }


    @Test
    public void testIsBalanced_T1() {
        assertTrue(isBalanced(""));
    }

    @Test
    public void testIsBalanced_T2() {
        assertTrue(isBalanced("()"));
    }

    @Test
    public void testIsBalanced_T3() {
        assertTrue(isBalanced("a()"));
    }

    @Test
    public void testIsBalanced_T4() {
        assertTrue(isBalanced("(a)"));
    }

    @Test
    public void testIsBalanced_T5() {
        assertTrue(isBalanced("()a"));
    }

    @Test
    public void testIsBalanced_T6() {
        assertTrue(isBalanced("()a[{}]"));
    }
    
}