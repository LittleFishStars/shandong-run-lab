package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f26634a;

    public class a extends p {
        public boolean b;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.b = true;
        }

        @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
        public final void a(int i) throws IOException {
            if (this.b) {
                this.b = false;
            } else {
                this.f26634a.write(i);
            }
        }
    }

    public p(OutputStream outputStream) {
        this.f26634a = outputStream;
    }

    public x0 a() {
        return new x0(this.f26634a);
    }

    public void a(int i) throws IOException {
        this.f26634a.write(i);
    }

    public void a(d dVar) throws IOException {
        if (dVar == null) {
            throw new IOException("null object detected");
        }
        dVar.c().a(this);
    }

    public final void a(r rVar) throws IOException {
        rVar.a(new a(this.f26634a));
    }

    public final void a(byte[] bArr, int i) throws IOException {
        a(i);
        b(bArr.length);
        this.f26634a.write(bArr);
    }

    public p b() {
        return new k1(this.f26634a);
    }

    public final void b(int i) throws IOException {
        if (i <= 127) {
            a((byte) i);
            return;
        }
        int i2 = i;
        int i3 = 1;
        while (true) {
            i2 >>>= 8;
            if (i2 == 0) {
                break;
            } else {
                i3++;
            }
        }
        a((byte) (i3 | 128));
        for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
            a((byte) (i >> i4));
        }
    }

    public final void a(int i, int i2) throws IOException {
        if (i2 < 31) {
            a(i | i2);
            return;
        }
        a(i | 31);
        if (i2 < 128) {
            a(i2);
            return;
        }
        byte[] bArr = new byte[5];
        int i3 = 4;
        bArr[4] = (byte) (i2 & 127);
        do {
            i2 >>= 7;
            i3--;
            bArr[i3] = (byte) ((i2 & 127) | 128);
        } while (i2 > 127);
        this.f26634a.write(bArr, i3, 5 - i3);
    }
}
