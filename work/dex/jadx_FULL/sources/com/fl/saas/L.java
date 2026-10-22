package com.fl.saas;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class L implements InterfaceC1427p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final E f30072a;
    public File b;
    private RandomAccessFile c;

    public L(File file, E e) throws C1448z0 {
        File file2;
        try {
            if (e == null) {
                throw new NullPointerException();
            }
            this.f30072a = e;
            O.b(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.b = file2;
            this.c = new RandomAccessFile(this.b, zExists ? "r" : "rw");
        } catch (IOException e2) {
            throw new C1448z0("Error using file " + file + " as disc cache", e2);
        }
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (c()) {
                throw new C1448z0("Error append cache: cache file " + this.b + " is completed!");
            }
            this.c.seek(b());
            this.c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new C1448z0(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized long b() {
        try {
        } catch (IOException e) {
            throw new C1448z0("Error reading length of file " + this.b, e);
        }
        return (int) this.c.length();
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized boolean c() {
        return !a(this.b);
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized void close() {
        try {
            this.c.close();
            this.f30072a.a(this.b);
        } catch (IOException e) {
            throw new C1448z0("Error closing file " + this.b, e);
        }
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized void a() {
        if (c()) {
            return;
        }
        close();
        File file = new File(this.b.getParentFile(), this.b.getName().substring(0, this.b.getName().length() - 9));
        if (!this.b.renameTo(file)) {
            throw new C1448z0("Error renaming file " + this.b + " to " + file + " for completion!");
        }
        this.b = file;
        try {
            this.c = new RandomAccessFile(this.b, "r");
            this.f30072a.a(this.b);
        } catch (IOException e) {
            throw new C1448z0("Error opening " + this.b + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.fl.saas.InterfaceC1427p
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new C1448z0(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(b()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }
}
