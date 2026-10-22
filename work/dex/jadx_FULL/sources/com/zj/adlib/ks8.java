package com.zj.adlib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ks8 {

    public static class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public byte[] toByteArray() {
            int i = ((ByteArrayOutputStream) this).count;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            return i == bArr.length ? bArr : super.toByteArray();
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        return b(inputStream, inputStream.available());
    }

    public static byte[] b(InputStream inputStream, int i) throws IOException {
        a aVar = new a(i);
        s51.a(inputStream, aVar);
        return aVar.toByteArray();
    }

    public static long c(InputStream inputStream, long j) throws IOException {
        ax6.i(inputStream);
        ax6.d(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }
}
