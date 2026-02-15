import java.util.Arrays;
import acm.program.ConsoleProgram;

/*
 * Pràctica 1: Representació de nombres naturals per taules de dígits.
 * Eric Buenavida Crespo
 */

public class BigNatural extends ConsoleProgram {

    public static final int[] ZERO = new int[] {0};

    public static final int[] ONE  = new int[] {1};

    public static int arrayToNumber (int[] natArray) {
        int power = 1;
        int natNumber = 0;
        for (int i = 0; i < natArray.length; i++) {
            for (int j = 0; j < i; j++) {
                power *= 10;
            }
            natNumber += natArray[i] * power;
            power = 1;
        }
        return natNumber;
    }

    public static boolean equals (int[] nat1, int[] nat2) {
        // Mirem si nat1 és la representació del número 0
        boolean allZeroNat1 = false;
        for (int i : nat1) {
            if (i == 0) {
                allZeroNat1 = true;
            } else {
                allZeroNat1 = false;
            }
        }
        // Mirem si nat2 és la representació del número 0
        boolean allZeroNat2 = false;
        for (int i : nat2) {
            if (i == 0) {
                allZeroNat2 = true;
            } else {
                allZeroNat2 = false;
            }
        }

        // En el cas que nat1 i nat2 siguin la representació del 0, però de diferent llargada, hem de retornar true
        if (allZeroNat1 && allZeroNat2) {
            return true;
        }

        // En els casos que nat1 i nat2 no siguin la representació de 0:
        if (nat1.length != nat2.length) {
            return false;
        }
        else {
            for (int i = 0; i < nat1.length; i++) {
                if (nat1[i] != nat2[i]) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int compareTo (int[] nat1, int[] nat2) {
        int natOne = arrayToNumber(nat1);
        int natTwo = arrayToNumber(nat2);

        return natOne - natTwo;
    }

    public static int[] add (int[] nat1, int[] nat2) {
        /* Comparem nat1 i nat2 per veure quin natural és potencialment més llarg.

        Guardem en les variables longerNat i shorterNat el natural potencialment més llarg i el natural potencialment més curt respectivament.

        Hem de guardar el natural potencialment més llarg i el potencialment més curt per sumar els dígits faltants a un nou resultat en el cas que
        longerNat.length > shorterNat.length. */
        int comparator = compareTo(nat1, nat2);
        int[] longerNat;
        int[] shorterNat;
        if (comparator > 0) {
            longerNat = nat1;
            shorterNat = nat2;
        }
        else if (comparator < 0) {
            longerNat = nat2;
            shorterNat = nat1;
        }
        else {
            longerNat = nat1;
            shorterNat = nat2;
        }

        // Fem la suma
        int[] result = new int[shorterNat.length];
        int carry = 0;
        int i;

        for (i = 0; i < result.length; i++) {
            result[i] = nat1[i] + nat2[i] + carry;
            carry = 0;
            if (result[i] > 9) {
                carry = 1;
                result[i] -= 10;
            }
        }

        if (i < longerNat.length && carry == 0) {
            int[] newResult = new int[longerNat.length];

            for (i = 0; i < result.length; i++) {
                newResult[i] = result[i];
            }
            for (i = i; i < longerNat.length; i++) {
                newResult[i] = longerNat[i];
            }

            return newResult;
        }

        if (carry == 1) {
            int[] newResult = new int[result.length + 1];

            for (i = 0; i < result.length; i++) {
                newResult[i] = result[i];
            }
            if (longerNat.length == newResult.length) {
                newResult[i] = longerNat[i] + carry;

                if (newResult[i] > 9) {
                    newResult[i] -= 10;

                    int[] newNewResult = new int[newResult.length + 1];

                    for (i = 0; i < newResult.length; i++) {
                        newNewResult[i] = newResult[i];
                    }
                    newNewResult[i] = carry;

                    return  newNewResult;
                }
            }
            else {
                newResult[i] = carry;
            }

            return newResult;
        }

        return result;
    }

    public static int[] shiftLeft (int[] nat, int positions) {
        // Mirem si nat és la representació del número 0 per retornar ZERO en el cas que ho sigui
        boolean allZero = false;
        for (int i : nat) {
            if (i == 0) {
                allZero = true;
            } else {
                allZero = false;
            }
        }

        if (allZero) {
            return ZERO;
        }

        int[] result = new int[nat.length + positions];

        for (int i = positions; i < result.length; i++) {
            int j = i - positions;
            result[i] = nat[j];
        }
        return result;
    }

    public static int[] multByDigit (int[] nat, int digit) {
        // Mirem si nat és la representació del número 0 per retornar ZERO en el cas que ho sigui
        boolean allZero = false;
        for (int i : nat) {
            if (i == 0) {
                allZero = true;
            } else {
                allZero = false;
            }
        }

        if (allZero || digit == 0) {
            return ZERO;
        }

        int[] result = new int[nat.length];
        int carry = 0;
        int i;

        for (i = 0; i < result.length; i++) {
            result[i] = nat[i] * digit + carry;
            carry = 0;
            if (result[i] > 9) {
                for (carry = 0; carry <= result[i] - 10; carry += 10);
                result[i] -= carry;
                carry /= 10;
            }
        }

        if (carry > 0) {
            int[] newResult = new int[result.length + 1];

            for (i = 0; i < newResult.length - 1; i++) {
                newResult[i] = result[i];
            }
            newResult[i] = carry;

            return newResult;
        }

        return result;
    }

    public static int[] mult (int[] nat1, int[] nat2) {
        // Mirem si nat1 és la representació del número 0 per retornar ZERO en el cas que ho sigui
        boolean allZeroNat1 = false;
        for (int i : nat1) {
            if (i == 0) {
                allZeroNat1 = true;
            } else {
                allZeroNat1 = false;
            }
        }
        // Mirem si nat2 és la representació del número 0 per retornar ZERO en el cas que ho sigui
        boolean allZeroNat2 = false;
        for (int i : nat2) {
            if (i == 0) {
                allZeroNat2 = true;
            } else {
                allZeroNat2 = false;
            }
        }

        if (allZeroNat1 || allZeroNat2) {
            return ZERO;
        }

        /* Comparem nat1 i nat2 per veure quin natural és potencialment més llarg.

        Guardem en les variables longerNat i shorterNat el natural potencialment més llarg i el natural potencialment més curt respectivament.

        Hem de guardar el natural potencialment més llarg i el potencialment més curt per poder ordenar la multiplicació. */
        int comparator = compareTo(nat1, nat2);
        int[] longerNat;
        int[] shorterNat;
        if (comparator > 0) {
            longerNat = nat1;
            shorterNat = nat2;
        }
        else if (comparator < 0) {
            longerNat = nat2;
            shorterNat = nat1;
        }
        else {
            longerNat = nat1;
            shorterNat = nat2;

        }

        // Fem la multiplicació
        int[] product;
        int[] shift;
        int[] result = ZERO;
        int i;

        for (i = 0; i < shorterNat.length; i++) {
            product = multByDigit(longerNat, shorterNat[i]);
            shift = shiftLeft(product, i);
            result = add(result, shift);
        }

        return  result;
    }

    public void run() {
        setFont ("*-*-20");
        testFromString();
        testAsString();
        testEquals();
        testCompareTo();
        testAdd();
        testShiftLeft();
        testMultByDigit();
        testMult();
    }

    // Mètodes auxiliars.

    public static int[] fromString (String number) {
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String digit = number.substring (i, i+1);
            digits[number.length()-i-1] = Integer.parseInt (digit);
        }
        return digits;
    }

    public static String asString (int[] nat) {
        char[] chars = new char[nat.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(nat[nat.length - i - 1] + '0');
        }
        return new String (chars);
    }

    private void testFromString() {
        println ("Inici de les proves de fromString");
        if ( ! Arrays.equals (ZERO, fromString ("0")) ) {
            println ("ERROR al cas \"0\"");
        }
        if ( ! Arrays.equals (ONE, fromString ("1")) ) {
            println ("ERROR al cas \"1\"");
        }
        if ( ! Arrays.equals (new int[] {5, 3, 2}, fromString ("235")) ) {
            println ("ERROR al cas \"235\"");
        }
        println ("Final de les proves de fromString");
    }

    private void testAsString() {
        println ("Inici de les proves de asString");
        if ( ! "0".equals ( asString (ZERO) ) ) {
            println ("ERROR al cas ZERO");
        }
        if ( ! "1".equals ( asString (ONE) ) ) {
            println ("ERROR al cas ONE");
        }
        if ( ! "235".equals ( asString (new int[] {5, 3, 2}) ) ) {
            println ("ERROR al cas int[] {5, 3, 2}");
        }
        println ("Final de les proves de asString");
    }

    // Mètodes de test per al vostre codi.

    private void testEquals() {
        println ("Inici de les proves de equals");
        if (   equals(ZERO, ONE) ) {
            println ("ERROR al cas 0 != 1");
        }
        if ( ! equals(ONE, ONE) ) {
            println ("ERROR al cas 1 = 1");
        }
        if (   equals(fromString ("12345"), fromString ("1234")) ) {
            println ("ERROR al cas 12345 != 1234");
        }
        if ( ! equals(fromString ("12345"), fromString ("12345")) ) {
            println ("ERROR al cas 12345 = 12345");
        }
        if (   equals(fromString ("12345"), fromString ("12395")) ) {
            println ("ERROR al cas 12345 != 12395");
        }
        println ("Final de les proves de equals");
    }

    private void testCompareTo() {
        println ("Inici de les proves de compareTo");
        if (compareTo (ZERO, ONE) >= 0) {
            println ("ERROR al cas 0 < 1");
        }
        if (compareTo (ONE, ONE) != 0) {
            println ("ERROR al cas 1 = 1");
        }
        if (compareTo (fromString("12345"), fromString("1234")) <= 0) {
            println ("ERROR al cas 12345 > 1234");
        }
        if (compareTo (fromString("12345"), fromString("12345")) != 0) {
            println ("ERROR al cas 12345 = 12345");
        }
        if (compareTo (fromString("12345"), fromString("12945")) >= 0) {
            println ("ERROR al cas 12345 < 12945");
        }
        if (compareTo (fromString("12945"), fromString("12345")) <= 0) {
            println ("ERROR al cas 12945 > 12345");
        }
        if (compareTo (fromString("55555"), fromString("57535")) >= 0) {
            println ("ERROR al cas 55555 < 57535");
        }
        println ("Final de les proves de compareTo");
    }

    private static boolean checkAdd (String n1, String n2, String result) {
        return Arrays.equals (add (fromString (n1), fromString (n2)),
                fromString (result));
    }

    private void testAdd() {
        println ("Inici de les proves de add");
        if ( ! checkAdd ("0", "0", "0") ) {
            println ("ERROR a la suma 0 + 0 = 0");
        }
        if ( ! checkAdd ("1", "1", "2") ) {
            println ("ERROR a la suma 1 + 1 = 2");
        }
        if ( ! checkAdd ("5", "0", "5") ) {
            println ("ERROR a la suma 5 + 0 = 5");
        }
        if ( ! checkAdd ("5", "5", "10") ) {
            println ("ERROR a la suma 5 + 5 = 10");
        }
        if ( ! checkAdd ("235", "683", "918") ) {
            println ("ERROR a la suma 235 + 683 = 918");
        }
        if ( ! checkAdd ("235", "783", "1018") ) {
            println ("ERROR a la suma 235 + 783 = 1018");
        }
        if ( ! checkAdd ("99", "999", "1098") ) {
            println ("ERROR a la suma 99 + 999 = 1098");
        }
        if ( ! checkAdd ("999", "99", "1098") ) {
            println ("ERROR a la suma 999 + 99 = 1098");
        }
        println ("Final de les proves de add");
    }

    private static boolean checkShiftLeft (String number, int positions, String result) {
        return Arrays.equals (shiftLeft (fromString (number), positions),
                fromString (result));
    }

    private void testShiftLeft() {
        println ("Inici de les proves de shiftLeft");
        if ( ! checkShiftLeft ("0", 0, "0") ) {
            println ("ERROR a 0 0 posicions a l'esquerra = 0");
        }
        if ( ! checkShiftLeft ("0", 3, "0") ) {
            println ("ERROR a 0 3 posicions a l'esquerra = 0");
        }
        if ( ! checkShiftLeft ("235", 0, "235") ) {
            println ("ERROR a 235 0 posicions a l'esquerra = 235");
        }
        if ( ! checkShiftLeft ("235", 1, "2350") ) {
            println ("ERROR a 235 1 posició a l'esquerra = 2350");
        }
        if ( ! checkShiftLeft ("235", 2, "23500") ) {
            println ("ERROR a 235 2 posicions a l'esquerra = 23500");
        }
        if ( ! checkShiftLeft ("235", 3, "235000") ) {
            println ("ERROR a 235 3 posicions a l'esquerra = 235000");
        }
        println ("Final de les proves de shiftLeft");
    }

    private static boolean checkMultByDigit (String number, int digit, String result) {
        return Arrays.equals (multByDigit (fromString (number), digit),
                fromString (result));
    }

    private void testMultByDigit() {
        println ("Inici de les proves de multByDigit");
        if ( ! checkMultByDigit ("0", 0, "0") ) {
            println ("ERROR a 0 * 0 = 0");
        }
        if ( ! checkMultByDigit ("0", 3, "0") ) {
            println ("ERROR a 0 * 3 = 0");
        }
        if ( ! checkMultByDigit ("24", 0, "0") ) {
            println ("ERROR a 24 * 0 = 0");
        }
        if ( ! checkMultByDigit ("24", 2, "48") ) {
            println ("ERROR a 24 * 2 = 48");
        }
        if ( ! checkMultByDigit ("54", 3, "162") ) {
            println ("ERROR a 54 * 3 = 162");
        }
        if ( ! checkMultByDigit ("345", 2, "690") ) {
            println ("ERROR a 345 * 2 = 690");
        }
        if ( ! checkMultByDigit ("345", 3, "1035") ) {
            println ("ERROR a 345 * 3 = 1035");
        }
        println ("Final de les proves de multByDigit");
    }

    private static boolean checkMultiply (String n1, String n2, String result) {
        return Arrays.equals (mult(fromString (n1), fromString (n2)),
                fromString (result));
    }

    private void testMult() {
        println ("Inici de les proves de mult");
        if (! checkMultiply ("999", "0", "0") ) {
            println ("ERROR a 999 * 0 = 0");
        }
        if (! checkMultiply ("0", "888", "0") ) {
            println ("ERROR a 0 * 888 = 0");
        }
        if (! checkMultiply ("777", "1", "777") ) {
            println ("ERROR a 777 * 1 = 777");
        }
        if (! checkMultiply ("1", "666", "666") ) {
            println ("ERROR a 1 * 666 = 666");
        }
        if (! checkMultiply ("2", "3", "6") ) {
            println ("ERROR a 2 * 3 = 6");
        }
        if (! checkMultiply ("15", "17", "255") ) {
            println ("ERROR a 15 * 17 = 255");
        }
        if (! checkMultiply ("999", "888", "887112") ) {
            println ("ERROR a 999 * 888 = 887112");
        }
        println ("Final de les proves de mult");
    }

}
