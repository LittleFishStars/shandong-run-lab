package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.v39;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class ByteSource {

    public class a extends CharSource {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Charset f6334a;

        public a(Charset charset) {
            this.f6334a = (Charset) com.google.common.base.i.E(charset);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource a(Charset charset) {
            return charset.equals(this.f6334a) ? ByteSource.this : super.a(charset);
        }

        @Override // com.google.common.io.CharSource
        public Reader m() throws IOException {
            return new InputStreamReader(ByteSource.this.m(), this.f6334a);
        }

        @Override // com.google.common.io.CharSource
        public String n() throws IOException {
            return new String(ByteSource.this.o(), this.f6334a);
        }

        public String toString() {
            String string = ByteSource.this.toString();
            String strValueOf = String.valueOf(this.f6334a);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 15 + strValueOf.length());
            sb.append(string);
            sb.append(".asCharSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32161a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f6335a;
        public final int b;

        public b(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.google.common.io.ByteSource
        public long g(OutputStream outputStream) throws IOException {
            outputStream.write(this.f6335a, this.f32161a, this.b);
            return this.b;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode j(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.f6335a, this.f32161a, this.b);
        }

        @Override // com.google.common.io.ByteSource
        public boolean k() {
            return this.b == 0;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream l() throws IOException {
            return m();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() {
            return new ByteArrayInputStream(this.f6335a, this.f32161a, this.b);
        }

        @Override // com.google.common.io.ByteSource
        @ParametricNullness
        public <T> T n(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.a(this.f6335a, this.f32161a, this.b);
            return byteProcessor.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public byte[] o() {
            byte[] bArr = this.f6335a;
            int i = this.f32161a;
            return Arrays.copyOfRange(bArr, i, this.b + i);
        }

        @Override // com.google.common.io.ByteSource
        public long p() {
            return this.b;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> q() {
            return Optional.of(Long.valueOf(this.b));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource r(long j, long j2) {
            com.google.common.base.i.p(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.i.p(j2 >= 0, "length (%s) may not be negative", j2);
            long jMin = Math.min(j, this.b);
            return new b(this.f6335a, this.f32161a + ((int) jMin), (int) Math.min(j2, ((long) this.b) - jMin));
        }

        public String toString() {
            String strK = com.google.common.base.a.k(BaseEncoding.a().m(this.f6335a, this.f32161a, this.b), 30, v39.CHARACTER_ELLIPSIZE);
            StringBuilder sb = new StringBuilder(String.valueOf(strK).length() + 17);
            sb.append("ByteSource.wrap(");
            sb.append(strK);
            sb.append(")");
            return sb.toString();
        }

        public b(byte[] bArr, int i, int i2) {
            this.f6335a = bArr;
            this.f32161a = i;
            this.b = i2;
        }
    }

    public static final class c extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends ByteSource> f32162a;

        public c(Iterable<? extends ByteSource> iterable) {
            this.f32162a = (Iterable) com.google.common.base.i.E(iterable);
        }

        @Override // com.google.common.io.ByteSource
        public boolean k() throws IOException {
            Iterator<? extends ByteSource> it = this.f32162a.iterator();
            while (it.hasNext()) {
                if (!it.next().k()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return new n(this.f32162a.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long p() throws IOException {
            Iterator<? extends ByteSource> it = this.f32162a.iterator();
            long jP = 0;
            while (it.hasNext()) {
                jP += it.next().p();
                if (jP < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return jP;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> q() {
            Iterable<? extends ByteSource> iterable = this.f32162a;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            Iterator<? extends ByteSource> it = iterable.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                Optional<Long> optionalQ = it.next().q();
                if (!optionalQ.isPresent()) {
                    return Optional.absent();
                }
                jLongValue += optionalQ.get().longValue();
                if (jLongValue < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(jLongValue));
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f32162a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
            sb.append("ByteSource.concat(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32163a = new d();

        public d() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource a(Charset charset) {
            com.google.common.base.i.E(charset);
            return CharSource.h();
        }

        @Override // com.google.common.io.ByteSource.b, com.google.common.io.ByteSource
        public byte[] o() {
            return ((b) this).f6335a;
        }

        @Override // com.google.common.io.ByteSource.b
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class e extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f32164a;
        public final long b;

        public e(long j, long j2) {
            com.google.common.base.i.p(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.i.p(j2 >= 0, "length (%s) may not be negative", j2);
            this.f32164a = j;
            this.b = j2;
        }

        @Override // com.google.common.io.ByteSource
        public boolean k() throws IOException {
            return this.b == 0 || super.k();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream l() throws IOException {
            return t(ByteSource.this.l());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return t(ByteSource.this.m());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> q() {
            Optional<Long> optionalQ = ByteSource.this.q();
            if (!optionalQ.isPresent()) {
                return Optional.absent();
            }
            long jLongValue = optionalQ.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.b, jLongValue - Math.min(this.f32164a, jLongValue))));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource r(long j, long j2) {
            com.google.common.base.i.p(j >= 0, "offset (%s) may not be negative", j);
            com.google.common.base.i.p(j2 >= 0, "length (%s) may not be negative", j2);
            long j3 = this.b - j;
            return j3 <= 0 ? ByteSource.i() : ByteSource.this.r(this.f32164a + j, Math.min(j2, j3));
        }

        public final InputStream t(InputStream inputStream) throws Throwable {
            long j = this.f32164a;
            if (j > 0) {
                try {
                    if (com.google.common.io.b.t(inputStream, j) < this.f32164a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th) {
                    Closer closerG = Closer.g();
                    closerG.h(inputStream);
                    try {
                        throw closerG.j(th);
                    } catch (Throwable th2) {
                        closerG.close();
                        throw th2;
                    }
                }
            }
            return com.google.common.io.b.f(inputStream, this.b);
        }

        public String toString() {
            String string = ByteSource.this.toString();
            long j = this.f32164a;
            long j2 = this.b;
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 50);
            sb.append(string);
            sb.append(".slice(");
            sb.append(j);
            sb.append(", ");
            sb.append(j2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static ByteSource b(Iterable<? extends ByteSource> iterable) {
        return new c(iterable);
    }

    public static ByteSource c(Iterator<? extends ByteSource> it) {
        return b(ImmutableList.copyOf(it));
    }

    public static ByteSource d(ByteSource... byteSourceArr) {
        return b(ImmutableList.copyOf(byteSourceArr));
    }

    public static ByteSource i() {
        return d.f32163a;
    }

    public static ByteSource s(byte[] bArr) {
        return new b(bArr);
    }

    public CharSource a(Charset charset) {
        return new a(charset);
    }

    public boolean e(ByteSource byteSource) throws Throwable {
        int iN;
        com.google.common.base.i.E(byteSource);
        byte[] bArrD = com.google.common.io.b.d();
        byte[] bArrD2 = com.google.common.io.b.d();
        Closer closerG = Closer.g();
        try {
            InputStream inputStream = (InputStream) closerG.h(m());
            InputStream inputStream2 = (InputStream) closerG.h(byteSource.m());
            do {
                iN = com.google.common.io.b.n(inputStream, bArrD, 0, bArrD.length);
                if (iN == com.google.common.io.b.n(inputStream2, bArrD2, 0, bArrD2.length) && Arrays.equals(bArrD, bArrD2)) {
                }
                closerG.close();
                return false;
            } while (iN == bArrD.length);
            closerG.close();
            return true;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @CanIgnoreReturnValue
    public long f(ByteSink byteSink) throws Throwable {
        com.google.common.base.i.E(byteSink);
        Closer closerG = Closer.g();
        try {
            long jB = com.google.common.io.b.b((InputStream) closerG.h(m()), (OutputStream) closerG.h(byteSink.c()));
            closerG.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    @CanIgnoreReturnValue
    public long g(OutputStream outputStream) throws Throwable {
        com.google.common.base.i.E(outputStream);
        Closer closerG = Closer.g();
        try {
            long jB = com.google.common.io.b.b((InputStream) closerG.h(m()), outputStream);
            closerG.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public final long h(InputStream inputStream) throws IOException {
        long j = 0;
        while (true) {
            long jT = com.google.common.io.b.t(inputStream, 2147483647L);
            if (jT <= 0) {
                return j;
            }
            j += jT;
        }
    }

    public HashCode j(HashFunction hashFunction) throws Throwable {
        Hasher hasherNewHasher = hashFunction.newHasher();
        g(Funnels.a(hasherNewHasher));
        return hasherNewHasher.p();
    }

    public boolean k() throws Throwable {
        Optional<Long> optionalQ = q();
        if (optionalQ.isPresent()) {
            return optionalQ.get().longValue() == 0;
        }
        Closer closerG = Closer.g();
        try {
            boolean z = ((InputStream) closerG.h(m())).read() == -1;
            closerG.close();
            return z;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public InputStream l() throws IOException {
        InputStream inputStreamM = m();
        return inputStreamM instanceof BufferedInputStream ? (BufferedInputStream) inputStreamM : new BufferedInputStream(inputStreamM);
    }

    public abstract InputStream m() throws IOException;

    @CanIgnoreReturnValue
    @Beta
    public <T> T n(ByteProcessor<T> byteProcessor) throws Throwable {
        com.google.common.base.i.E(byteProcessor);
        Closer closerG = Closer.g();
        try {
            T t = (T) com.google.common.io.b.o((InputStream) closerG.h(m()), byteProcessor);
            closerG.close();
            return t;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public byte[] o() throws Throwable {
        Closer closerG = Closer.g();
        try {
            InputStream inputStream = (InputStream) closerG.h(m());
            Optional<Long> optionalQ = q();
            byte[] bArrV = optionalQ.isPresent() ? com.google.common.io.b.v(inputStream, optionalQ.get().longValue()) : com.google.common.io.b.u(inputStream);
            closerG.close();
            return bArrV;
        } catch (Throwable th) {
            try {
                throw closerG.j(th);
            } catch (Throwable th2) {
                closerG.close();
                throw th2;
            }
        }
    }

    public long p() throws Throwable {
        Optional<Long> optionalQ = q();
        if (optionalQ.isPresent()) {
            return optionalQ.get().longValue();
        }
        Closer closerG = Closer.g();
        try {
            long jH = h((InputStream) closerG.h(m()));
            closerG.close();
            return jH;
        } catch (IOException unused) {
            closerG.close();
            Closer closerG2 = Closer.g();
            try {
                long jE = com.google.common.io.b.e((InputStream) closerG2.h(m()));
                closerG2.close();
                return jE;
            } catch (Throwable th) {
                try {
                    throw closerG2.j(th);
                } catch (Throwable th2) {
                    closerG2.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            closerG.close();
            throw th3;
        }
    }

    @Beta
    public Optional<Long> q() {
        return Optional.absent();
    }

    public ByteSource r(long j, long j2) {
        return new e(j, j2);
    }
}
