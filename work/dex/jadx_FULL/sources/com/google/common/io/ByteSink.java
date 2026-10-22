package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class ByteSink {

    public final class b extends CharSink {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Charset f6333a;

        @Override // com.google.common.io.CharSink
        public Writer b() throws IOException {
            return new OutputStreamWriter(ByteSink.this.c(), this.f6333a);
        }

        public String toString() {
            String string = ByteSink.this.toString();
            String strValueOf = String.valueOf(this.f6333a);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 13 + strValueOf.length());
            sb.append(string);
            sb.append(".asCharSink(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public b(Charset charset) {
            this.f6333a = (Charset) com.google.common.base.i.E(charset);
        }
    }

    public CharSink a(Charset charset) {
        return new b(charset);
    }

    public OutputStream b() throws IOException {
        OutputStream outputStreamC = c();
        return outputStreamC instanceof BufferedOutputStream ? (BufferedOutputStream) outputStreamC : new BufferedOutputStream(outputStreamC);
    }

    public abstract OutputStream c() throws IOException;

    public void d(byte[] bArr) throws Throwable {
        com.google.common.base.i.E(bArr);
        Closer closerG = Closer.g();
        try {
            OutputStream outputStream = (OutputStream) closerG.h(c());
            outputStream.write(bArr);
            outputStream.flush();
            closerG.close();
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
    public long e(InputStream inputStream) throws Throwable {
        com.google.common.base.i.E(inputStream);
        Closer closerG = Closer.g();
        try {
            OutputStream outputStream = (OutputStream) closerG.h(c());
            long jB = com.google.common.io.b.b(inputStream, outputStream);
            outputStream.flush();
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
}
