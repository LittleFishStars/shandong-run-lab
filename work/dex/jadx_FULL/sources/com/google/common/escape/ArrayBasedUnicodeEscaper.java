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
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f32013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[][] f6235a;
    public final char b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f6236b;
    public final int c;
    public final int d;

    public ArrayBasedUnicodeEscaper(Map<Character, String> map, int i, int i2, String str) {
        this(a.a(map), i, i2, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String b(String str) {
        i.E(str);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < this.f6236b && this.f6235a[cCharAt] != null) || cCharAt > this.b || cCharAt < this.f32013a) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    @CheckForNull
    public final char[] escape(int i) {
        char[] cArr;
        if (i < this.f6236b && (cArr = this.f6235a[i]) != null) {
            return cArr;
        }
        if (i < this.c || i > this.d) {
            return escapeUnsafe(i);
        }
        return null;
    }

    @CheckForNull
    public abstract char[] escapeUnsafe(int i);

    @Override // com.google.common.escape.UnicodeEscaper
    public final int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if ((cCharAt < this.f6236b && this.f6235a[cCharAt] != null) || cCharAt > this.b || cCharAt < this.f32013a) {
                break;
            }
            i++;
        }
        return i;
    }

    public ArrayBasedUnicodeEscaper(a aVar, int i, int i2, String str) {
        i.E(aVar);
        char[][] cArrC = aVar.c();
        this.f6235a = cArrC;
        this.f6236b = cArrC.length;
        if (i2 < i) {
            i2 = -1;
            i = Integer.MAX_VALUE;
        }
        this.c = i;
        this.d = i2;
        if (i >= 55296) {
            this.f32013a = (char) 65535;
            this.b = (char) 0;
        } else {
            this.f32013a = (char) i;
            this.b = (char) Math.min(i2, 55295);
        }
    }
}
