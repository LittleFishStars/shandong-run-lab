package com.beizi.fusion;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.zj.adlib.u15;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class og implements Closeable, Flushable {
    private static final Pattern l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] m = new String[128];
    private static final String[] n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f27615a;
    private int[] b = new int[32];
    private int c = 0;
    private g8 d;
    private String e;
    private String f;
    private boolean g;
    private mo h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            m[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public og(Writer writer) {
        a(6);
        this.h = mo.LEGACY_STRICT;
        this.k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f27615a = writer;
        a(g8.d);
    }

    private void j() throws IOException {
        if (this.g) {
            return;
        }
        this.f27615a.write(this.d.b());
        int i = this.c;
        for (int i2 = 1; i2 < i; i2++) {
            this.f27615a.write(this.d.a());
        }
    }

    private int l() {
        int i = this.c;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m() throws IOException {
        if (this.j != null) {
            a();
            b(this.j);
            this.j = null;
        }
    }

    public final void a(g8 g8Var) {
        Objects.requireNonNull(g8Var);
        this.d = g8Var;
        this.f = ",";
        if (g8Var.c()) {
            this.e = ": ";
            if (this.d.b().isEmpty()) {
                this.f = ", ";
            }
        } else {
            this.e = u15.f19942b;
        }
        this.g = this.d.b().isEmpty() && this.d.a().isEmpty();
    }

    public final void b(boolean z) {
        this.k = z;
    }

    public og c() throws IOException {
        m();
        return a(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27615a.close();
        int i = this.c;
        if (i > 1 || (i == 1 && this.b[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public og d() throws IOException {
        m();
        return a(3, '{');
    }

    public og e() {
        return a(1, 2, ']');
    }

    public og f() {
        return a(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f27615a.flush();
    }

    public final boolean g() {
        return this.k;
    }

    public final mo h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public og k() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return this;
            }
            m();
        }
        b();
        this.f27615a.write("null");
        return this;
    }

    private void b(int i) {
        this.b[this.c - 1] = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void b(String str) throws IOException {
        String str2;
        String[] strArr = this.i ? n : m;
        this.f27615a.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.f27615a.write(str, i, i2 - i);
                    }
                    this.f27615a.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f27615a.write(str, i, i2 - i);
                }
                this.f27615a.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f27615a.write(str, i, length - i);
        }
        this.f27615a.write(34);
    }

    public og c(String str) throws IOException {
        if (str == null) {
            return k();
        }
        m();
        b();
        b(str);
        return this;
    }

    public og c(boolean z) throws IOException {
        m();
        b();
        this.f27615a.write(z ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        return this;
    }

    public final void a(mo moVar) {
        Objects.requireNonNull(moVar);
        this.h = moVar;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    private og a(int i, char c) throws IOException {
        b();
        a(i);
        this.f27615a.write(c);
        return this;
    }

    private void b() throws IOException {
        int iL = l();
        if (iL == 1) {
            b(2);
            j();
            return;
        }
        if (iL == 2) {
            this.f27615a.append((CharSequence) this.f);
            j();
        } else {
            if (iL != 4) {
                if (iL != 6) {
                    if (iL == 7) {
                        if (this.h != mo.LENIENT) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                b(7);
                return;
            }
            this.f27615a.append((CharSequence) this.e);
            b(5);
        }
    }

    private og a(int i, int i2, char c) throws IOException {
        int iL = l();
        if (iL != i2 && iL != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.c--;
            if (iL == i2) {
                j();
            }
            this.f27615a.write(c);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.j);
    }

    private void a(int i) {
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = i;
    }

    public og a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.j == null) {
            int iL = l();
            if (iL != 3 && iL != 5) {
                throw new IllegalStateException("Please begin an object before writing a name.");
            }
            this.j = str;
            return this;
        }
        throw new IllegalStateException("Already wrote a name, expecting a value.");
    }

    public og a(Boolean bool) throws IOException {
        if (bool == null) {
            return k();
        }
        m();
        b();
        this.f27615a.write(bool.booleanValue() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        return this;
    }

    public og a(double d) throws IOException {
        m();
        if (this.h != mo.LENIENT && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        b();
        this.f27615a.append((CharSequence) Double.toString(d));
        return this;
    }

    public og a(long j) throws IOException {
        m();
        b();
        this.f27615a.write(Long.toString(j));
        return this;
    }

    public og a(Number number) throws IOException {
        if (number == null) {
            return k();
        }
        m();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!a(cls)) {
            if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
                if (cls != Float.class && cls != Double.class && !l.matcher(string).matches()) {
                    throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
                }
            } else if (this.h != mo.LENIENT) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
            }
        }
        b();
        this.f27615a.append((CharSequence) string);
        return this;
    }

    private static boolean a(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void a() throws IOException {
        int iL = l();
        if (iL == 5) {
            this.f27615a.write(this.f);
        } else if (iL != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        j();
        b(4);
    }
}
