package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class CharSink {
    public Writer a() throws IOException {
        Writer writerB = b();
        return writerB instanceof BufferedWriter ? (BufferedWriter) writerB : new BufferedWriter(writerB);
    }

    public abstract Writer b() throws IOException;

    public void c(CharSequence charSequence) throws Throwable {
        com.google.common.base.i.E(charSequence);
        Closer closerG = Closer.g();
        try {
            Writer writer = (Writer) closerG.h(b());
            writer.append(charSequence);
            writer.flush();
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
    public long d(Readable readable) throws Throwable {
        com.google.common.base.i.E(readable);
        Closer closerG = Closer.g();
        try {
            Writer writer = (Writer) closerG.h(b());
            long jB = d.b(readable, writer);
            writer.flush();
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

    public void e(Iterable<? extends CharSequence> iterable) throws Throwable {
        f(iterable, System.getProperty("line.separator"));
    }

    public void f(Iterable<? extends CharSequence> iterable, String str) throws Throwable {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.E(str);
        Closer closerG = Closer.g();
        try {
            Writer writer = (Writer) closerG.h(a());
            Iterator<? extends CharSequence> it = iterable.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((CharSequence) str);
            }
            writer.flush();
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
}
