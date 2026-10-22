package cj.mobile.wm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ra extends ByteArrayOutputStream {
    public final la dexa;

    public ra(la laVar, int i) {
        this.dexa = laVar;
        ((ByteArrayOutputStream) this).buf = laVar.dexa(Math.max(i, 256));
    }

    private void dexa(int i) {
        int i2 = ((ByteArrayOutputStream) this).count + i;
        if (i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrDexa = this.dexa.dexa(i2 * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrDexa, 0, ((ByteArrayOutputStream) this).count);
        this.dexa.dexa(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrDexa;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dexa.dexa(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.dexa.dexa(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        dexa(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        dexa(i2);
        super.write(bArr, i, i2);
    }
}
