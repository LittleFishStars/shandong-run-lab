package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class CharEscaper extends Escaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32014a = 2;

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

    @Override // com.google.common.escape.Escaper
    public String b(String str) {
        i.E(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (escape(str.charAt(i)) != null) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escape(char c);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrA = d.a();
        int length2 = cArrA.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            char[] cArrEscape = escape(str.charAt(i));
            if (cArrEscape != null) {
                int length3 = cArrEscape.length;
                int i4 = i - i2;
                int i5 = i3 + i4;
                int i6 = i5 + length3;
                if (length2 < i6) {
                    length2 = ((length - i) * 2) + i6;
                    cArrA = c(cArrA, i3, length2);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArrA, i3);
                    i3 = i5;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrEscape, 0, cArrA, i3, length3);
                    i3 += length3;
                }
                i2 = i + 1;
            }
            i++;
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + i3;
            if (length2 < i8) {
                cArrA = c(cArrA, i3, i8);
            }
            str.getChars(i2, length, cArrA, i3);
            i3 = i8;
        }
        return new String(cArrA, 0, i3);
    }
}
