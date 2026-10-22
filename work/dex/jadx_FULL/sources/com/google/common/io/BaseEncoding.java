package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaseEncoding f32147a;
    public static final BaseEncoding b;
    public static final BaseEncoding c;
    public static final BaseEncoding d;
    public static final BaseEncoding e;

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th) {
            super(th);
        }
    }

    public class a extends ByteSink {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CharSink f6321a;

        public a(CharSink charSink) {
            this.f6321a = charSink;
        }

        @Override // com.google.common.io.ByteSink
        public OutputStream c() throws IOException {
            return BaseEncoding.this.p(this.f6321a.b());
        }
    }

    public class b extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CharSource f6322a;

        public b(CharSource charSource) {
            this.f6322a = charSource;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return BaseEncoding.this.k(this.f6322a.m());
        }
    }

    public class e extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Writer f32152a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Appendable f6323a;

        public e(Appendable appendable, Writer writer) {
            this.f6323a = appendable;
            this.f32152a = writer;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f32152a.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.f32152a.flush();
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f6323a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32153a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f6324a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f6325a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final char[] f6326a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f6327a;
        public final int b;
        public final int c;
        public final int d;

        public f(String str, char[] cArr) {
            this.f6324a = (String) com.google.common.base.i.E(str);
            this.f6326a = (char[]) com.google.common.base.i.E(cArr);
            try {
                int iP = com.google.common.math.e.p(cArr.length, RoundingMode.UNNECESSARY);
                this.b = iP;
                int iMin = Math.min(8, Integer.lowestOneBit(iP));
                try {
                    this.c = 8 / iMin;
                    this.d = iP / iMin;
                    this.f32153a = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c = cArr[i];
                        com.google.common.base.i.f(c < 128, "Non-ASCII character: %s", c);
                        com.google.common.base.i.f(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i;
                    }
                    this.f6325a = bArr;
                    boolean[] zArr = new boolean[this.c];
                    for (int i2 = 0; i2 < this.d; i2++) {
                        zArr[com.google.common.math.e.g(i2 * 8, this.b, RoundingMode.CEILING)] = true;
                    }
                    this.f6327a = zArr;
                } catch (ArithmeticException e) {
                    String str2 = new String(cArr);
                    throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e);
                }
            } catch (ArithmeticException e2) {
                int length = cArr.length;
                StringBuilder sb = new StringBuilder(35);
                sb.append("Illegal alphabet length ");
                sb.append(length);
                throw new IllegalArgumentException(sb.toString(), e2);
            }
        }

        public boolean b(char c) {
            return c <= 127 && this.f6325a[c] != -1;
        }

        public int c(char c) throws DecodingException {
            if (c > 127) {
                String strValueOf = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(strValueOf.length() != 0 ? "Unrecognized character: 0x".concat(strValueOf) : new String("Unrecognized character: 0x"));
            }
            byte b = this.f6325a[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                String strValueOf2 = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(strValueOf2.length() != 0 ? "Unrecognized character: 0x".concat(strValueOf2) : new String("Unrecognized character: 0x"));
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Unrecognized character: ");
            sb.append(c);
            throw new DecodingException(sb.toString());
        }

        public char d(int i) {
            return this.f6326a[i];
        }

        public final boolean e() {
            for (char c : this.f6326a) {
                if (com.google.common.base.a.c(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof f) {
                return Arrays.equals(this.f6326a, ((f) obj).f6326a);
            }
            return false;
        }

        public final boolean f() {
            for (char c : this.f6326a) {
                if (com.google.common.base.a.d(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean g(int i) {
            return this.f6327a[i % this.c];
        }

        public f h() {
            if (!f()) {
                return this;
            }
            com.google.common.base.i.h0(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f6326a.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.f6326a;
                if (i >= cArr2.length) {
                    return new f(String.valueOf(this.f6324a).concat(".lowerCase()"), cArr);
                }
                cArr[i] = com.google.common.base.a.e(cArr2[i]);
                i++;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.f6326a);
        }

        public boolean i(char c) {
            byte[] bArr = this.f6325a;
            return c < bArr.length && bArr[c] != -1;
        }

        public f j() {
            if (!e()) {
                return this;
            }
            com.google.common.base.i.h0(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f6326a.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.f6326a;
                if (i >= cArr2.length) {
                    return new f(String.valueOf(this.f6324a).concat(".upperCase()"), cArr);
                }
                cArr[i] = com.google.common.base.a.h(cArr2[i]);
                i++;
            }
        }

        public String toString() {
            return this.f6324a;
        }
    }

    public static final class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char[] f32154a;

        public g(String str, String str2) {
            this(new f(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding D(f fVar, @CheckForNull Character ch) {
            return new g(fVar);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            com.google.common.base.i.E(bArr);
            if (charSequence.length() % 2 == 1) {
                int length = charSequence.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((((j) this).f32156a.c(charSequence.charAt(i)) << 4) | ((j) this).f32156a.c(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            com.google.common.base.i.E(appendable);
            com.google.common.base.i.f0(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.f32154a[i4]);
                appendable.append(this.f32154a[i4 | 256]);
            }
        }

        public g(f fVar) {
            super(fVar, null);
            this.f32154a = new char[512];
            com.google.common.base.i.d(fVar.f6326a.length == 16);
            for (int i = 0; i < 256; i++) {
                this.f32154a[i] = fVar.d(i >>> 4);
                this.f32154a[i | 256] = fVar.d(i & 15);
            }
        }
    }

    public static final class h extends j {
        public h(String str, String str2, @CheckForNull Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.j
        public BaseEncoding D(f fVar, @CheckForNull Character ch) {
            return new h(fVar, ch);
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            com.google.common.base.i.E(bArr);
            CharSequence charSequenceY = y(charSequence);
            if (!((j) this).f32156a.g(charSequenceY.length())) {
                int length = charSequenceY.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceY.length()) {
                int i3 = i + 1;
                int i4 = i3 + 1;
                int iC = (((j) this).f32156a.c(charSequenceY.charAt(i)) << 18) | (((j) this).f32156a.c(charSequenceY.charAt(i3)) << 12);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (iC >>> 16);
                if (i4 < charSequenceY.length()) {
                    int i6 = i4 + 1;
                    int iC2 = iC | (((j) this).f32156a.c(charSequenceY.charAt(i4)) << 6);
                    i2 = i5 + 1;
                    bArr[i5] = (byte) ((iC2 >>> 8) & 255);
                    if (i6 < charSequenceY.length()) {
                        i4 = i6 + 1;
                        i5 = i2 + 1;
                        bArr[i2] = (byte) ((iC2 | ((j) this).f32156a.c(charSequenceY.charAt(i6))) & 255);
                    } else {
                        i = i6;
                    }
                }
                i2 = i5;
                i = i4;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.j, com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            com.google.common.base.i.E(appendable);
            int i3 = i + i2;
            com.google.common.base.i.f0(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(((j) this).f32156a.d(i6 >>> 18));
                appendable.append(((j) this).f32156a.d((i6 >>> 12) & 63));
                appendable.append(((j) this).f32156a.d((i6 >>> 6) & 63));
                appendable.append(((j) this).f32156a.d(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                C(appendable, bArr, i, i3 - i);
            }
        }

        public h(f fVar, @CheckForNull Character ch) {
            super(fVar, ch);
            com.google.common.base.i.d(fVar.f6326a.length == 64);
        }
    }

    public static final class i extends BaseEncoding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32155a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f6328a;
        public final BaseEncoding f;

        public i(BaseEncoding baseEncoding, String str, int i) {
            this.f = (BaseEncoding) com.google.common.base.i.E(baseEncoding);
            this.f6328a = (String) com.google.common.base.i.E(str);
            this.f32155a = i;
            com.google.common.base.i.k(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding A(char c) {
            return this.f.A(c).B(this.f6328a, this.f32155a);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding B(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean f(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (this.f6328a.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.f.f(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (this.f6328a.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.f.i(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream k(Reader reader) {
            return this.f.k(BaseEncoding.r(reader, this.f6328a));
        }

        @Override // com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            this.f.n(BaseEncoding.w(appendable, this.f6328a, this.f32155a), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream p(Writer writer) {
            return this.f.p(BaseEncoding.x(writer, this.f6328a, this.f32155a));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding s() {
            return this.f.s().B(this.f6328a, this.f32155a);
        }

        @Override // com.google.common.io.BaseEncoding
        public int t(int i) {
            return this.f.t(i);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f);
            String str = this.f6328a;
            int i = this.f32155a;
            StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(str).length());
            sb.append(strValueOf);
            sb.append(".withSeparator(\"");
            sb.append(str);
            sb.append("\", ");
            sb.append(i);
            sb.append(")");
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public int u(int i) {
            int iU = this.f.u(i);
            return iU + (this.f6328a.length() * com.google.common.math.e.g(Math.max(0, iU - 1), this.f32155a, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding v() {
            return this.f.v().B(this.f6328a, this.f32155a);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence y(CharSequence charSequence) {
            return this.f.y(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding z() {
            return this.f.z().B(this.f6328a, this.f32155a);
        }
    }

    public static class j extends BaseEncoding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f32156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public final Character f6329a;

        @CheckForNull
        @LazyInit
        public transient BaseEncoding f;

        @CheckForNull
        @LazyInit
        public transient BaseEncoding g;

        public class a extends OutputStream {
            public int K = 0;
            public int L = 0;
            public int M = 0;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Writer f6330a;

            public a(Writer writer) {
                this.f6330a = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i = this.L;
                if (i > 0) {
                    int i2 = this.K;
                    f fVar = j.this.f32156a;
                    this.f6330a.write(fVar.d((i2 << (fVar.b - i)) & fVar.f32153a));
                    this.M++;
                    if (j.this.f6329a != null) {
                        while (true) {
                            int i3 = this.M;
                            j jVar = j.this;
                            if (i3 % jVar.f32156a.c == 0) {
                                break;
                            }
                            this.f6330a.write(jVar.f6329a.charValue());
                            this.M++;
                        }
                    }
                }
                this.f6330a.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f6330a.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                this.K = (i & 255) | (this.K << 8);
                this.L += 8;
                while (true) {
                    int i2 = this.L;
                    f fVar = j.this.f32156a;
                    int i3 = fVar.b;
                    if (i2 < i3) {
                        return;
                    }
                    this.f6330a.write(fVar.d((this.K >> (i2 - i3)) & fVar.f32153a));
                    this.M++;
                    this.L -= j.this.f32156a.b;
                }
            }
        }

        public j(String str, String str2, @CheckForNull Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding A(char c) {
            Character ch;
            return (8 % this.f32156a.b == 0 || ((ch = this.f6329a) != null && ch.charValue() == c)) ? this : D(this.f32156a, Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding B(String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                com.google.common.base.i.u(!this.f32156a.i(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.f6329a;
            if (ch != null) {
                com.google.common.base.i.u(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new i(this, str, i);
        }

        public void C(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            com.google.common.base.i.E(appendable);
            com.google.common.base.i.f0(i, i + i2, bArr.length);
            int i3 = 0;
            com.google.common.base.i.d(i2 <= this.f32156a.d);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & 255))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f32156a.b;
            while (i3 < i2 * 8) {
                f fVar = this.f32156a;
                appendable.append(fVar.d(((int) (j >>> (i5 - i3))) & fVar.f32153a));
                i3 += this.f32156a.b;
            }
            if (this.f6329a != null) {
                while (i3 < this.f32156a.d * 8) {
                    appendable.append(this.f6329a.charValue());
                    i3 += this.f32156a.b;
                }
            }
        }

        public BaseEncoding D(f fVar, @CheckForNull Character ch) {
            return new j(fVar, ch);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f32156a.equals(jVar.f32156a) && com.google.common.base.g.a(this.f6329a, jVar.f6329a);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean f(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            CharSequence charSequenceY = y(charSequence);
            if (!this.f32156a.g(charSequenceY.length())) {
                return false;
            }
            for (int i = 0; i < charSequenceY.length(); i++) {
                if (!this.f32156a.b(charSequenceY.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f32156a.hashCode() ^ com.google.common.base.g.b(this.f6329a);
        }

        @Override // com.google.common.io.BaseEncoding
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            f fVar;
            com.google.common.base.i.E(bArr);
            CharSequence charSequenceY = y(charSequence);
            if (!this.f32156a.g(charSequenceY.length())) {
                int length = charSequenceY.length();
                StringBuilder sb = new StringBuilder(32);
                sb.append("Invalid input length ");
                sb.append(length);
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceY.length()) {
                long jC = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    fVar = this.f32156a;
                    if (i3 >= fVar.c) {
                        break;
                    }
                    jC <<= fVar.b;
                    if (i + i3 < charSequenceY.length()) {
                        jC |= (long) this.f32156a.c(charSequenceY.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = fVar.d;
                int i6 = (i5 * 8) - (i4 * fVar.b);
                int i7 = (i5 - 1) * 8;
                while (i7 >= i6) {
                    bArr[i2] = (byte) ((jC >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.f32156a.c;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream k(Reader reader) {
            com.google.common.base.i.E(reader);
            return new b(reader);
        }

        @Override // com.google.common.io.BaseEncoding
        public void n(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            com.google.common.base.i.E(appendable);
            com.google.common.base.i.f0(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                C(appendable, bArr, i + i3, Math.min(this.f32156a.d, i2 - i3));
                i3 += this.f32156a.d;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream p(Writer writer) {
            com.google.common.base.i.E(writer);
            return new a(writer);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding s() {
            BaseEncoding baseEncodingD = this.g;
            if (baseEncodingD == null) {
                f fVarH = this.f32156a.h();
                baseEncodingD = fVarH == this.f32156a ? this : D(fVarH, this.f6329a);
                this.g = baseEncodingD;
            }
            return baseEncodingD;
        }

        @Override // com.google.common.io.BaseEncoding
        public int t(int i) {
            return (int) (((((long) this.f32156a.b) * ((long) i)) + 7) / 8);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f32156a.toString());
            if (8 % this.f32156a.b != 0) {
                if (this.f6329a == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f6329a);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public int u(int i) {
            f fVar = this.f32156a;
            return fVar.c * com.google.common.math.e.g(i, fVar.d, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding v() {
            return this.f6329a == null ? this : D(this.f32156a, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence y(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            Character ch = this.f6329a;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding z() {
            BaseEncoding baseEncodingD = this.f;
            if (baseEncodingD == null) {
                f fVarJ = this.f32156a.j();
                baseEncodingD = fVarJ == this.f32156a ? this : D(fVarJ, this.f6329a);
                this.f = baseEncodingD;
            }
            return baseEncodingD;
        }

        public j(f fVar, @CheckForNull Character ch) {
            this.f32156a = (f) com.google.common.base.i.E(fVar);
            com.google.common.base.i.u(ch == null || !fVar.i(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f6329a = ch;
        }

        public class b extends InputStream {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Reader f6331a;
            public int K = 0;
            public int L = 0;
            public int M = 0;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f6332a = false;

            public b(Reader reader) {
                this.f6331a = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f6331a.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i;
                while (true) {
                    int i2 = this.f6331a.read();
                    if (i2 == -1) {
                        if (this.f6332a || j.this.f32156a.g(this.M)) {
                            return -1;
                        }
                        int i3 = this.M;
                        StringBuilder sb = new StringBuilder(32);
                        sb.append("Invalid input length ");
                        sb.append(i3);
                        throw new DecodingException(sb.toString());
                    }
                    this.M++;
                    char c = (char) i2;
                    Character ch = j.this.f6329a;
                    if (ch == null || ch.charValue() != c) {
                        if (this.f6332a) {
                            int i4 = this.M;
                            StringBuilder sb2 = new StringBuilder(61);
                            sb2.append("Expected padding character but found '");
                            sb2.append(c);
                            sb2.append("' at index ");
                            sb2.append(i4);
                            throw new DecodingException(sb2.toString());
                        }
                        int i5 = this.K;
                        f fVar = j.this.f32156a;
                        int i6 = i5 << fVar.b;
                        this.K = i6;
                        int iC = fVar.c(c) | i6;
                        this.K = iC;
                        int i7 = this.L + j.this.f32156a.b;
                        this.L = i7;
                        if (i7 >= 8) {
                            int i8 = i7 - 8;
                            this.L = i8;
                            return (iC >> i8) & 255;
                        }
                    } else {
                        if (!this.f6332a && ((i = this.M) == 1 || !j.this.f32156a.g(i - 1))) {
                            int i9 = this.M;
                            StringBuilder sb3 = new StringBuilder(41);
                            sb3.append("Padding cannot start at index ");
                            sb3.append(i9);
                            throw new DecodingException(sb3.toString());
                        }
                        this.f6332a = true;
                    }
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = i2 + i;
                com.google.common.base.i.f0(i, i3, bArr.length);
                int i4 = i;
                while (i4 < i3) {
                    int i5 = read();
                    if (i5 == -1) {
                        int i6 = i4 - i;
                        if (i6 == 0) {
                            return -1;
                        }
                        return i6;
                    }
                    bArr[i4] = (byte) i5;
                    i4++;
                }
                return i4 - i;
            }
        }
    }

    static {
        Character chValueOf = Character.valueOf(com.alipay.sdk.m.p.a.h);
        f32147a = new h("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", chValueOf);
        b = new h("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", chValueOf);
        c = new j("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", chValueOf);
        d = new j("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", chValueOf);
        e = new g("base16()", "0123456789ABCDEF");
    }

    public static BaseEncoding a() {
        return e;
    }

    public static BaseEncoding b() {
        return c;
    }

    public static BaseEncoding c() {
        return d;
    }

    public static BaseEncoding d() {
        return f32147a;
    }

    public static BaseEncoding e() {
        return b;
    }

    public static byte[] q(byte[] bArr, int i2) {
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    @GwtIncompatible
    public static Reader r(Reader reader, String str) {
        com.google.common.base.i.E(reader);
        com.google.common.base.i.E(str);
        return new c(reader, str);
    }

    public static Appendable w(Appendable appendable, String str, int i2) {
        com.google.common.base.i.E(appendable);
        com.google.common.base.i.E(str);
        com.google.common.base.i.d(i2 > 0);
        return new d(i2, appendable, str);
    }

    @GwtIncompatible
    public static Writer x(Writer writer, String str, int i2) {
        return new e(w(writer, str, i2), writer);
    }

    public abstract BaseEncoding A(char c2);

    public abstract BaseEncoding B(String str, int i2);

    public abstract boolean f(CharSequence charSequence);

    public final byte[] g(CharSequence charSequence) {
        try {
            return h(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final byte[] h(CharSequence charSequence) throws DecodingException {
        CharSequence charSequenceY = y(charSequence);
        byte[] bArr = new byte[t(charSequenceY.length())];
        return q(bArr, i(bArr, charSequenceY));
    }

    public abstract int i(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    public final ByteSource j(CharSource charSource) {
        com.google.common.base.i.E(charSource);
        return new b(charSource);
    }

    @GwtIncompatible
    public abstract InputStream k(Reader reader);

    public String l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public final String m(byte[] bArr, int i2, int i3) {
        com.google.common.base.i.f0(i2, i2 + i3, bArr.length);
        StringBuilder sb = new StringBuilder(u(i3));
        try {
            n(sb, bArr, i2, i3);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public abstract void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException;

    @GwtIncompatible
    public final ByteSink o(CharSink charSink) {
        com.google.common.base.i.E(charSink);
        return new a(charSink);
    }

    @GwtIncompatible
    public abstract OutputStream p(Writer writer);

    public abstract BaseEncoding s();

    public abstract int t(int i2);

    public abstract int u(int i2);

    public abstract BaseEncoding v();

    public CharSequence y(CharSequence charSequence) {
        return (CharSequence) com.google.common.base.i.E(charSequence);
    }

    public abstract BaseEncoding z();

    public class c extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Reader f32150a;
        public final /* synthetic */ String f;

        public c(Reader reader, String str) {
            this.f32150a = reader;
            this.f = str;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f32150a.close();
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int i;
            do {
                i = this.f32150a.read();
                if (i == -1) {
                    break;
                }
            } while (this.f.indexOf((char) i) >= 0);
            return i;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public class d implements Appendable {
        public int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Appendable f32151a;
        public final /* synthetic */ String f;

        public d(int i, Appendable appendable, String str) {
            this.L = i;
            this.f32151a = appendable;
            this.f = str;
            this.K = i;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.K == 0) {
                this.f32151a.append(this.f);
                this.K = this.L;
            }
            this.f32151a.append(c);
            this.K--;
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@CheckForNull CharSequence charSequence, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public Appendable append(@CheckForNull CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }
    }
}
