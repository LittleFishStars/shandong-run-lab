package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32184a = 2048;

    public static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32185a = new a();

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            com.google.common.base.i.E(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            com.google.common.base.i.f0(i, i2 + i, cArr.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            com.google.common.base.i.E(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence, int i, int i2) {
            com.google.common.base.i.f0(i, i2, charSequence == null ? 4 : charSequence.length());
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            com.google.common.base.i.f0(i, i2 + i, str.length());
        }
    }

    @Beta
    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new com.google.common.io.a(appendable);
    }

    @CanIgnoreReturnValue
    public static long b(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            return appendable instanceof StringBuilder ? c((Reader) readable, (StringBuilder) appendable) : d((Reader) readable, a(appendable));
        }
        com.google.common.base.i.E(readable);
        com.google.common.base.i.E(appendable);
        CharBuffer charBufferE = e();
        long jRemaining = 0;
        while (readable.read(charBufferE) != -1) {
            j.b(charBufferE);
            appendable.append(charBufferE);
            jRemaining += (long) charBufferE.remaining();
            j.a(charBufferE);
        }
        return jRemaining;
    }

    @CanIgnoreReturnValue
    public static long c(Reader reader, StringBuilder sb) throws IOException {
        com.google.common.base.i.E(reader);
        com.google.common.base.i.E(sb);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int i = reader.read(cArr);
            if (i == -1) {
                return j;
            }
            sb.append(cArr, 0, i);
            j += (long) i;
        }
    }

    @CanIgnoreReturnValue
    public static long d(Reader reader, Writer writer) throws IOException {
        com.google.common.base.i.E(reader);
        com.google.common.base.i.E(writer);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int i = reader.read(cArr);
            if (i == -1) {
                return j;
            }
            writer.write(cArr, 0, i);
            j += (long) i;
        }
    }

    public static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @Beta
    public static long f(Readable readable) throws IOException {
        CharBuffer charBufferE = e();
        long j = 0;
        while (true) {
            long j2 = readable.read(charBufferE);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            j.a(charBufferE);
        }
    }

    @Beta
    public static Writer g() {
        return a.f32185a;
    }

    @Beta
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T h(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String strB;
        com.google.common.base.i.E(readable);
        com.google.common.base.i.E(lineProcessor);
        k kVar = new k(readable);
        do {
            strB = kVar.b();
            if (strB == null) {
                break;
            }
        } while (lineProcessor.a(strB));
        return lineProcessor.getResult();
    }

    @Beta
    public static List<String> i(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        k kVar = new k(readable);
        while (true) {
            String strB = kVar.b();
            if (strB == null) {
                return arrayList;
            }
            arrayList.add(strB);
        }
    }

    @Beta
    public static void j(Reader reader, long j) throws IOException {
        com.google.common.base.i.E(reader);
        while (j > 0) {
            long jSkip = reader.skip(j);
            if (jSkip == 0) {
                throw new EOFException();
            }
            j -= jSkip;
        }
    }

    public static String k(Readable readable) throws IOException {
        return l(readable).toString();
    }

    public static StringBuilder l(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            c((Reader) readable, sb);
        } else {
            b(readable, sb);
        }
        return sb;
    }
}
