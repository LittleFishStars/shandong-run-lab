package com.ipd.dsp.internal.w0;

import com.ipd.dsp.internal.v0.k;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements com.ipd.dsp.internal.v0.a {
    public static final String d = ".ipdCacheFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f38592a;
    public File b;
    public RandomAccessFile c;

    public b(File file) throws k {
        File file2;
        try {
            this.f38592a = com.ipd.dsp.internal.v0.c.b();
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                throw new IOException();
            }
            c.b(parentFile);
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + d);
            }
            this.b = file2;
            this.c = new RandomAccessFile(this.b, zExists ? "r" : "rw");
        } catch (IOException e) {
            throw new k("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized int a(byte[] bArr, long j, int i) throws k {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new k(String.format("Error reading %d bytes with offset %d form file[%d bytes] to buffed[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized long available() throws k {
        try {
        } catch (IOException e) {
            throw new k("Error reading length of file " + this.b, e);
        }
        return (int) this.c.length();
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized boolean b() {
        return !a(this.b);
    }

    public File c() {
        return this.b;
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized void close() throws k {
        try {
            this.c.close();
            this.f38592a.a(this.b);
        } catch (IOException e) {
            throw new k("Error closing file " + this.b, e);
        }
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized void a(byte[] bArr, int i) throws k {
        try {
            if (!b()) {
                this.c.seek(available());
                this.c.write(bArr, 0, i);
            } else {
                throw new k("Error append cache: cache file " + this.b + " is completed!");
            }
        } catch (IOException e) {
            throw new k(String.format("Error writing %d bytes to %s from buffed with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.ipd.dsp.internal.v0.a
    public synchronized void a() throws k {
        if (b()) {
            return;
        }
        close();
        File file = new File(this.b.getParentFile(), this.b.getName().substring(0, this.b.getName().length() - 13));
        if (this.b.renameTo(file)) {
            this.b = file;
            try {
                this.c = new RandomAccessFile(this.b, "r");
                this.f38592a.a(this.b);
                return;
            } catch (IOException e) {
                throw new k("Error opening " + this.b + " as disc cache", e);
            }
        }
        throw new k("Error renaming file " + this.b + " to " + file + " for completion!");
    }

    public boolean a(File file) {
        return file.getName().endsWith(d);
    }
}
