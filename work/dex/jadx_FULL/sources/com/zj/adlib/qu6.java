package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class qu6 {
    public static final int b = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteArrayPool f19170a;

    public qu6(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 16384);
    }

    public long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f19170a.get(this.f44299a);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.f44299a);
                if (i == -1) {
                    this.f19170a.a(bArr);
                    return j;
                }
                outputStream.write(bArr, 0, i);
                j += (long) i;
            } catch (Throwable th) {
                this.f19170a.a(bArr);
                throw th;
            }
        }
    }

    public long b(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        long j2 = 0;
        ax6.o(j > 0);
        byte[] bArr = this.f19170a.get(this.f44299a);
        while (j2 < j) {
            try {
                int i = inputStream.read(bArr, 0, (int) Math.min(this.f44299a, j - j2));
                if (i == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i);
                j2 += (long) i;
            } catch (Throwable th) {
                this.f19170a.a(bArr);
                throw th;
            }
        }
        this.f19170a.a(bArr);
        return j2;
    }

    @VisibleForTesting
    public qu6(ByteArrayPool byteArrayPool, int i) {
        ax6.d(i > 0);
        this.f44299a = i;
        this.f19170a = byteArrayPool;
    }
}
