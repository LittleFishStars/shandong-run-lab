package com.kc.cw.ad.internal.d.a;

import com.kc.cw.ad.internal.d.p;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements com.kc.cw.ad.internal.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f38955a;
    private final a b;
    private RandomAccessFile c;

    public b(File file, a aVar) throws p {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.b = aVar;
            d.a(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.f38955a = file2;
            this.c = new RandomAccessFile(this.f38955a, zExists ? "r" : "rw");
        } catch (Exception e) {
            throw new p("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kc.cw.ad.internal.d.a
    public int a(byte[] bArr, long j, int i) throws p {
        int i2;
        synchronized (this) {
            try {
                this.c.seek(j);
                i2 = this.c.read(bArr, 0, i);
            } catch (Exception e) {
                throw new p(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
            }
        }
        return i2;
    }

    @Override // com.kc.cw.ad.internal.d.a
    public long a() throws p {
        long length;
        synchronized (this) {
            try {
                length = (int) this.c.length();
            } catch (Exception e) {
                throw new p("Error reading length of file " + this.f38955a, e);
            }
        }
        return length;
    }

    @Override // com.kc.cw.ad.internal.d.a
    public void a(byte[] bArr, int i) throws p {
        synchronized (this) {
            try {
                if (d()) {
                    throw new p("Error append cache: cache file " + this.f38955a + " is completed!");
                }
                this.c.seek(a());
                this.c.write(bArr, 0, i);
            } catch (Exception e) {
                throw new p(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
            }
        }
    }

    @Override // com.kc.cw.ad.internal.d.a
    public void b() throws p {
        synchronized (this) {
            try {
                this.c.close();
                this.b.a(this.f38955a);
            } catch (Exception e) {
                throw new p("Error closing file " + this.f38955a, e);
            }
        }
    }

    @Override // com.kc.cw.ad.internal.d.a
    public void c() throws p {
        synchronized (this) {
            if (d()) {
                return;
            }
            b();
            File file = new File(this.f38955a.getParentFile(), this.f38955a.getName().substring(0, this.f38955a.getName().length() - 9));
            if (!this.f38955a.renameTo(file)) {
                throw new p("Error renaming file " + this.f38955a + " to " + file + " for completion!");
            }
            this.f38955a = file;
            try {
                this.c = new RandomAccessFile(this.f38955a, "r");
                this.b.a(this.f38955a);
            } catch (Exception e) {
                throw new p("Error opening " + this.f38955a + " as disc cache", e);
            }
        }
    }

    @Override // com.kc.cw.ad.internal.d.a
    public boolean d() {
        boolean zA;
        synchronized (this) {
            zA = a(this.f38955a);
        }
        return !zA;
    }
}
