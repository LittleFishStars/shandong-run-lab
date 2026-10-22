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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Escaper f32021a = new a();

    public class a extends CharEscaper {
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String b(String str) {
            return (String) i.E(str);
        }

        @Override // com.google.common.escape.CharEscaper
        @CheckForNull
        public char[] escape(char c) {
            return null;
        }
    }

    public class b extends UnicodeEscaper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharEscaper f32022a;

        public b(CharEscaper charEscaper) {
            this.f32022a = charEscaper;
        }

        @Override // com.google.common.escape.UnicodeEscaper
        @CheckForNull
        public char[] escape(int i) {
            if (i < 65536) {
                return this.f32022a.escape((char) i);
            }
            char[] cArr = new char[2];
            Character.toChars(i, cArr, 0);
            char[] cArrEscape = this.f32022a.escape(cArr[0]);
            char[] cArrEscape2 = this.f32022a.escape(cArr[1]);
            if (cArrEscape == null && cArrEscape2 == null) {
                return null;
            }
            int length = cArrEscape != null ? cArrEscape.length : 1;
            char[] cArr2 = new char[(cArrEscape2 != null ? cArrEscape2.length : 1) + length];
            if (cArrEscape != null) {
                for (int i2 = 0; i2 < cArrEscape.length; i2++) {
                    cArr2[i2] = cArrEscape[i2];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (cArrEscape2 != null) {
                for (int i3 = 0; i3 < cArrEscape2.length; i3++) {
                    cArr2[length + i3] = cArrEscape2[i3];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    /* JADX INFO: renamed from: com.google.common.escape.c$c, reason: collision with other inner class name */
    @Beta
    public static final class C0740c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f32023a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public String f6238a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<Character, String> f6239a;
        public char b;

        /* JADX INFO: renamed from: com.google.common.escape.c$c$a */
        public class a extends ArrayBasedCharEscaper {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @CheckForNull
            public final char[] f6240a;

            public a(Map map, char c, char c2) {
                super((Map<Character, String>) map, c, c2);
                this.f6240a = C0740c.this.f6238a != null ? C0740c.this.f6238a.toCharArray() : null;
            }

            @Override // com.google.common.escape.ArrayBasedCharEscaper
            @CheckForNull
            public char[] escapeUnsafe(char c) {
                return this.f6240a;
            }
        }

        public /* synthetic */ C0740c(a aVar) {
            this();
        }

        @CanIgnoreReturnValue
        public C0740c b(char c, String str) {
            i.E(str);
            this.f6239a.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper c() {
            return new a(this.f6239a, this.f32023a, this.b);
        }

        @CanIgnoreReturnValue
        public C0740c d(char c, char c2) {
            this.f32023a = c;
            this.b = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public C0740c e(String str) {
            this.f6238a = str;
            return this;
        }

        public C0740c() {
            this.f6239a = new HashMap();
            this.f32023a = (char) 0;
            this.b = (char) 65535;
            this.f6238a = null;
        }
    }

    public static UnicodeEscaper a(Escaper escaper) {
        i.E(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return g((CharEscaper) escaper);
        }
        String name = escaper.getClass().getName();
        throw new IllegalArgumentException(name.length() != 0 ? "Cannot create a UnicodeEscaper from: ".concat(name) : new String("Cannot create a UnicodeEscaper from: "));
    }

    public static C0740c b() {
        return new C0740c(null);
    }

    @CheckForNull
    public static String c(CharEscaper charEscaper, char c) {
        return f(charEscaper.escape(c));
    }

    @CheckForNull
    public static String d(UnicodeEscaper unicodeEscaper, int i) {
        return f(unicodeEscaper.escape(i));
    }

    public static Escaper e() {
        return f32021a;
    }

    @CheckForNull
    public static String f(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public static UnicodeEscaper g(CharEscaper charEscaper) {
        return new b(charEscaper);
    }
}
