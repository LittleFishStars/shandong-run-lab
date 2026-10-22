package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class a {
    public static final byte A = 23;
    public static final byte B = 24;
    public static final byte C = 25;
    public static final byte D = 26;
    public static final byte E = 27;
    public static final byte F = 28;
    public static final byte G = 29;
    public static final byte H = 30;
    public static final byte I = 31;
    public static final byte J = 32;
    public static final byte K = 32;
    public static final byte L = 127;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f31593a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char f5940a = 0;
    public static final byte b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final char f5941b = 127;
    public static final byte c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final char f5942c = ' ';
    public static final byte d = 3;
    public static final byte e = 4;
    public static final byte f = 5;
    public static final byte g = 6;
    public static final byte h = 7;
    public static final byte i = 8;
    public static final byte j = 9;
    public static final byte k = 10;
    public static final byte l = 10;
    public static final byte m = 11;
    public static final byte n = 12;
    public static final byte o = 13;
    public static final byte p = 14;
    public static final byte q = 15;
    public static final byte r = 16;
    public static final byte s = 17;
    public static final byte t = 17;
    public static final byte u = 18;
    public static final byte v = 19;
    public static final byte w = 19;
    public static final byte x = 20;
    public static final byte y = 21;
    public static final byte z = 22;

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int iB;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            char cCharAt2 = charSequence2.charAt(i2);
            if (cCharAt != cCharAt2 && ((iB = b(cCharAt)) >= 26 || iB != b(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    public static int b(char c2) {
        return (char) ((c2 | ' ') - 97);
    }

    public static boolean c(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean d(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static char e(char c2) {
        return d(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String f(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return g((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = e(charSequence.charAt(i2));
        }
        return String.valueOf(cArr);
    }

    public static String g(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (d(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (d(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static char h(char c2) {
        return c(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String i(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return j((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = h(charSequence.charAt(i2));
        }
        return String.valueOf(cArr);
    }

    public static String j(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (c(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (c(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static String k(CharSequence charSequence, int i2, String str) {
        String string;
        i.E(charSequence);
        int length = i2 - str.length();
        i.m(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i2, str.length());
        int length2 = charSequence.length();
        CharSequence charSequence2 = charSequence;
        if (length2 <= i2) {
            string = charSequence.toString();
            if (string.length() <= i2) {
                charSequence2 = string;
                return string;
            }
        }
        charSequence2 = string;
        StringBuilder sb = new StringBuilder(i2);
        sb.append(charSequence2, 0, length);
        sb.append(str);
        return sb.toString();
    }
}
