package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32019a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Character, String> f6237a = new HashMap();

    public static class a extends CharEscaper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char[][] f32020a;
        public final int b;

        public a(char[][] cArr) {
            this.f32020a = cArr;
            this.b = cArr.length;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String b(String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                char[][] cArr = this.f32020a;
                if (cCharAt < cArr.length && cArr[cCharAt] != null) {
                    return escapeSlow(str, i);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        public char[] escape(char c) {
            if (c < this.b) {
                return this.f32020a[c];
            }
            return null;
        }
    }

    @CanIgnoreReturnValue
    public b a(char c, String str) {
        this.f6237a.put(Character.valueOf(c), (String) i.E(str));
        if (c > this.f32019a) {
            this.f32019a = c;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public b b(char[] cArr, String str) {
        i.E(str);
        for (char c : cArr) {
            a(c, str);
        }
        return this;
    }

    public char[][] c() {
        char[][] cArr = new char[this.f32019a + 1][];
        for (Map.Entry<Character, String> entry : this.f6237a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public Escaper d() {
        return new a(c());
    }
}
