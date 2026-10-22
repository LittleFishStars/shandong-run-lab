package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class a extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f32178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6345a;

    public a(Appendable appendable) {
        this.f32178a = (Appendable) com.google.common.base.i.E(appendable);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6345a = true;
        Appendable appendable = this.f32178a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        g();
        Appendable appendable = this.f32178a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public final void g() throws IOException {
        if (this.f6345a) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        g();
        this.f32178a.append(new String(cArr, i, i2));
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        g();
        this.f32178a.append((char) i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        g();
        this.f32178a.append(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        com.google.common.base.i.E(str);
        g();
        this.f32178a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence) throws IOException {
        g();
        this.f32178a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence, int i, int i2) throws IOException {
        g();
        this.f32178a.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        com.google.common.base.i.E(str);
        g();
        this.f32178a.append(str, i, i2 + i);
    }
}
