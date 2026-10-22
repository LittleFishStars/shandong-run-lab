package com.zj.adlib;

import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ic0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42322a = "AtomicFile";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final File f17179a;
    public final File b;

    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f42323a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f17180a = false;

        public a(File file) throws FileNotFoundException {
            this.f42323a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f17180a) {
                return;
            }
            this.f17180a = true;
            flush();
            try {
                this.f42323a.getFD().sync();
            } catch (IOException e) {
                Log.o(ic0.f42322a, "Failed to sync file descriptor:", e);
            }
            this.f42323a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f42323a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f42323a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f42323a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f42323a.write(bArr, i, i2);
        }
    }

    public ic0(File file) {
        this.f17179a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void a(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.b.delete();
    }

    public boolean b() {
        return this.f17179a.exists() || this.b.exists();
    }

    public InputStream c() throws FileNotFoundException {
        d();
        return new FileInputStream(this.f17179a);
    }

    public final void d() {
        if (this.b.exists()) {
            this.f17179a.delete();
            this.b.renameTo(this.f17179a);
        }
    }

    public void delete() {
        this.f17179a.delete();
        this.b.delete();
    }

    public OutputStream e() throws IOException {
        if (this.f17179a.exists()) {
            if (this.b.exists()) {
                this.f17179a.delete();
            } else if (!this.f17179a.renameTo(this.b)) {
                Log.n(f42322a, "Couldn't rename file " + this.f17179a + " to backup file " + this.b);
            }
        }
        try {
            return new a(this.f17179a);
        } catch (FileNotFoundException e) {
            File parentFile = this.f17179a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f17179a, e);
            }
            try {
                return new a(this.f17179a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.f17179a, e2);
            }
        }
    }
}
