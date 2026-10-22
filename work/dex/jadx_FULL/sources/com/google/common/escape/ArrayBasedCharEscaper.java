package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f32012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[][] f6233a;
    public final char b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f6234b;

    public ArrayBasedCharEscaper(Map<Character, String> map, char c, char c2) {
        this(a.a(map), c, c2);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String b(String str) {
        i.E(str);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < this.f6234b && this.f6233a[cCharAt] != null) || cCharAt > this.b || cCharAt < this.f32012a) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    @CheckForNull
    public final char[] escape(char c) {
        char[] cArr;
        if (c < this.f6234b && (cArr = this.f6233a[c]) != null) {
            return cArr;
        }
        if (c < this.f32012a || c > this.b) {
            return escapeUnsafe(c);
        }
        return null;
    }

    @CheckForNull
    public abstract char[] escapeUnsafe(char c);

    public ArrayBasedCharEscaper(a aVar, char c, char c2) {
        i.E(aVar);
        char[][] cArrC = aVar.c();
        this.f6233a = cArrC;
        this.f6234b = cArrC.length;
        if (c2 < c) {
            c2 = 0;
            c = 65535;
        }
        this.f32012a = c;
        this.b = c2;
    }
}
