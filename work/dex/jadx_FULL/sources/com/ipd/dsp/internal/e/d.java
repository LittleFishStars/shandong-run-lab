package com.ipd.dsp.internal.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {
    public static final String e = "GifHeaderParser";
    public static final int f = 255;
    public static final int g = 44;
    public static final int h = 33;
    public static final int i = 59;
    public static final int j = 249;
    public static final int k = 255;
    public static final int l = 254;
    public static final int m = 1;
    public static final int n = 28;
    public static final int o = 2;
    public static final int p = 1;
    public static final int q = 128;
    public static final int r = 64;
    public static final int s = 7;
    public static final int t = 128;
    public static final int u = 7;
    public static final int v = 2;
    public static final int w = 10;
    public static final int x = 256;
    public ByteBuffer b;
    public c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f38287a = new byte[256];
    public int d = 0;

    public d a(@NonNull ByteBuffer byteBuffer) {
        n();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void b(int i2) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i2) {
            int iE = e();
            if (iE == 33) {
                int iE2 = e();
                if (iE2 == 1) {
                    o();
                } else if (iE2 == 249) {
                    this.c.d = new b();
                    i();
                } else if (iE2 == 254) {
                    o();
                } else if (iE2 != 255) {
                    o();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f38287a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        o();
                    }
                }
            } else if (iE == 44) {
                c cVar = this.c;
                if (cVar.d == null) {
                    cVar.d = new b();
                }
                f();
            } else if (iE != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public boolean c() {
        j();
        if (!b()) {
            b(2);
        }
        return this.c.c > 1;
    }

    @NonNull
    public c d() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        j();
        if (!b()) {
            h();
            c cVar = this.c;
            if (cVar.c < 0) {
                cVar.b = 1;
            }
        }
        return this.c;
    }

    public final int e() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void f() {
        this.c.d.f38285a = m();
        this.c.d.b = m();
        this.c.d.c = m();
        this.c.d.d = m();
        int iE = e();
        boolean z = (iE & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iE & 7) + 1);
        b bVar = this.c.d;
        bVar.e = (iE & 64) != 0;
        if (z) {
            bVar.k = a(iPow);
        } else {
            bVar.k = null;
        }
        this.c.d.j = this.b.position();
        p();
        if (b()) {
            return;
        }
        c cVar = this.c;
        cVar.c++;
        cVar.e.add(cVar.d);
    }

    public final void g() {
        int iE = e();
        this.d = iE;
        if (iE <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                int i4 = this.d;
                if (i2 >= i4) {
                    return;
                }
                i3 = i4 - i2;
                this.b.get(this.f38287a, i2, i3);
                i2 += i3;
            } catch (Exception e2) {
                if (Dsp.isDebugLogEnable()) {
                    k.a("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.d, e2);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    public final void h() {
        b(Integer.MAX_VALUE);
    }

    public final void i() {
        e();
        int iE = e();
        b bVar = this.c.d;
        int i2 = (iE & 28) >> 2;
        bVar.g = i2;
        if (i2 == 0) {
            bVar.g = 1;
        }
        bVar.f = (iE & 1) != 0;
        int iM = m();
        if (iM < 2) {
            iM = 10;
        }
        b bVar2 = this.c.d;
        bVar2.i = iM * 10;
        bVar2.h = e();
        e();
    }

    public final void j() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        k();
        if (!this.c.h || b()) {
            return;
        }
        c cVar = this.c;
        cVar.f38286a = a(cVar.i);
        c cVar2 = this.c;
        cVar2.l = cVar2.f38286a[cVar2.j];
    }

    public final void k() {
        this.c.f = m();
        this.c.g = m();
        int iE = e();
        c cVar = this.c;
        cVar.h = (iE & 128) != 0;
        cVar.i = (int) Math.pow(2.0d, (iE & 7) + 1);
        this.c.j = e();
        this.c.k = e();
    }

    public final void l() {
        do {
            g();
            byte[] bArr = this.f38287a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int m() {
        return this.b.getShort();
    }

    public final void n() {
        this.b = null;
        Arrays.fill(this.f38287a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    public final void o() {
        int iE;
        do {
            iE = e();
            this.b.position(Math.min(this.b.position() + iE, this.b.limit()));
        } while (iE > 0);
    }

    public final void p() {
        e();
        o();
    }

    public d a(@Nullable byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        this.b = null;
        this.c.b = 2;
        return this;
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    @Nullable
    public final int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = bArr[i4] & 255;
                int i6 = i4 + 2;
                int i7 = bArr[i4 + 1] & 255;
                i4 += 3;
                int i8 = i3 + 1;
                iArr[i3] = (i7 << 8) | (i5 << 16) | (-16777216) | (bArr[i6] & 255);
                i3 = i8;
            }
            return iArr;
        } catch (BufferUnderflowException e2) {
            if (Dsp.isDebugLogEnable()) {
                k.a("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.c.b = 1;
            return iArr;
        }
    }

    public final boolean b() {
        return this.c.b != 0;
    }
}
