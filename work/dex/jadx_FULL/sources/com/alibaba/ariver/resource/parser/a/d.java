package com.alibaba.ariver.resource.parser.a;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24452a = "TarFile";
    public static final int b = 1;
    public static final int c = 4;
    private static final int h = 2048;
    private final String d;
    private File e;
    private RandomAccessFile f;
    private MappedByteBuffer g;
    private c i;
    private long j;
    private long k;

    public d(String str) {
        this(new File(str), 1);
    }

    private void d() {
        if (this.f == null) {
            throw new IllegalStateException("Tar file closed");
        }
    }

    public int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public void b() throws IOException {
        c cVar = this.i;
        if (cVar == null) {
            return;
        }
        if (cVar.i() > this.j) {
            long j = 0;
            while (j < this.i.i() - this.j) {
                long jA = a((this.i.i() - this.j) - j);
                if (jA == 0 && this.i.i() - this.j > 0) {
                    throw new IOException("Possible tar file corruption");
                }
                j += jA;
            }
        }
        this.i = null;
        this.j = 0L;
        c();
    }

    public void c() {
        int i;
        long j = this.k;
        long jA = 0;
        if (j <= 0 || (i = (int) (j % 512)) <= 0) {
            return;
        }
        while (true) {
            long j2 = 512 - i;
            if (jA >= j2) {
                return;
            } else {
                jA += a(j2 - jA);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RandomAccessFile randomAccessFile = this.f;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                IOUtils.freeMappedBuffer(this.g);
                this.f = null;
                randomAccessFile.close();
            }
            File file = this.e;
            if (file != null) {
                file.delete();
                this.e = null;
            }
        }
    }

    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public d(File file, int i) {
        String path = file.getPath();
        this.d = path;
        if (i != 1 && i != 5) {
            throw new IllegalArgumentException("Bad mode: " + i);
        }
        if ((i & 4) != 0) {
            this.e = file;
            file.deleteOnExit();
        } else {
            this.e = null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f = randomAccessFile;
            this.g = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, this.f.length());
        } catch (Throwable th) {
            try {
                RVLogger.e(f24452a, th);
            } finally {
                IOUtils.freeMappedBuffer(this.g);
                IOUtils.closeQuietly(this.f);
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        d();
        c cVar = this.i;
        if (cVar != null) {
            if (this.j == cVar.i()) {
                return -1;
            }
            if (this.i.i() - this.j < i2) {
                i2 = (int) (this.i.i() - this.j);
            }
        }
        try {
            this.g.get(bArr, i, i2);
            i3 = i2;
        } catch (BufferUnderflowException e) {
            RVLogger.e(f24452a, e);
            i3 = -1;
        }
        if (i3 == -1) {
            throw new IOException();
        }
        if (this.i != null) {
            this.j += (long) i2;
        }
        this.k += (long) i2;
        return i2;
    }

    public c a() throws IOException {
        int length;
        int i;
        d();
        b();
        byte[] buf = IOUtils.getBuf(512);
        boolean z = false;
        try {
            this.g.get(buf, 0, 512);
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (buf[i] != 0) {
                    break;
                }
                i++;
            }
        } catch (BufferUnderflowException e) {
            RVLogger.e(f24452a, e);
        }
        length = buf.length;
        i = 0;
        if (!z) {
            this.i = new c(buf);
        }
        IOUtils.returnBuf(buf);
        return this.i;
    }

    public long a(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        byte[] buf = IOUtils.getBuf(2048);
        long j2 = j;
        while (j2 > 0) {
            int iA = a(buf, 0, (int) (j2 < 2048 ? j2 : 2048L));
            if (iA < 0) {
                break;
            }
            j2 -= (long) iA;
        }
        IOUtils.returnBuf(buf);
        return j - j2;
    }
}
