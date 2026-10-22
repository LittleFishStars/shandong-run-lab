package com.byazt.of;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1217, 15})
public class uj implements tt {
    public final FileChannel c;
    public final long tt;
    public final long ve;

    public uj(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.c = fileChannel;
        this.tt = j;
        this.ve = j2;
    }

    @Override // com.byazt.of.tt
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public uj c(long j, long j2) {
        long jC = c();
        c(j, j2, jC);
        return (j == 0 && j2 == jC) ? this : new uj(this.c, this.tt + j, j2);
    }

    @Override // com.byazt.of.tt
    public long c() {
        long j = this.ve;
        if (j != -1) {
            return j;
        }
        try {
            return this.c.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public void c(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        c(j, i, c());
        if (i == 0) {
            return;
        }
        if (i <= byteBuffer.remaining()) {
            long j2 = this.tt + j;
            int iLimit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.c) {
                        this.c.position(j2);
                        i2 = this.c.read(byteBuffer);
                    }
                    j2 += (long) i2;
                    i -= i2;
                }
                byteBuffer.limit(iLimit);
                return;
            } catch (Throwable th) {
                byteBuffer.limit(iLimit);
                throw th;
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.byazt.of.tt
    public ByteBuffer c(long j, int i) throws IOException {
        if (i >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            c(j, i, byteBufferAllocate);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
    }

    private static void c(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 <= j3) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
    }
}
