package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32017a = 32;

    public static char[] c(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    public static int codePointAt(CharSequence charSequence, int i, int i2) {
        i.E(charSequence);
        if (i >= i2) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i3 = i + 1;
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            String strValueOf = String.valueOf(charSequence);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 88);
            sb.append("Unexpected low surrogate character '");
            sb.append(cCharAt);
            sb.append("' with value ");
            sb.append((int) cCharAt);
            sb.append(" at index ");
            sb.append(i3 - 1);
            sb.append(" in '");
            sb.append(strValueOf);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 == i2) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i3);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        String strValueOf2 = String.valueOf(charSequence);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 89);
        sb2.append("Expected low surrogate but got char '");
        sb2.append(cCharAt2);
        sb2.append("' with value ");
        sb2.append((int) cCharAt2);
        sb2.append(" at index ");
        sb2.append(i3);
        sb2.append(" in '");
        sb2.append(strValueOf2);
        sb2.append("'");
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.common.escape.Escaper
    public String b(String str) {
        i.E(str);
        int length = str.length();
        int iNextEscapeIndex = nextEscapeIndex(str, 0, length);
        return iNextEscapeIndex == length ? str : escapeSlow(str, iNextEscapeIndex);
    }

    @CheckForNull
    public abstract char[] escape(int i);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrA = d.a();
        int i2 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i3 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            if (cArrEscape != null) {
                int i4 = i - i2;
                int i5 = length2 + i4;
                int length3 = cArrEscape.length + i5;
                if (cArrA.length < length3) {
                    cArrA = c(cArrA, length2, length3 + (length - i) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArrA, length2);
                    length2 = i5;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrA, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i2 = i3;
            }
            i = nextEscapeIndex(str, i3, length);
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = i6 + length2;
            if (cArrA.length < i7) {
                cArrA = c(cArrA, length2, i7);
            }
            str.getChars(i2, length, cArrA, length2);
            length2 = i7;
        }
        return new String(cArrA, 0, length2);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int iCodePointAt = codePointAt(charSequence, i, i2);
            if (iCodePointAt < 0 || escape(iCodePointAt) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
        }
        return i;
    }
}
