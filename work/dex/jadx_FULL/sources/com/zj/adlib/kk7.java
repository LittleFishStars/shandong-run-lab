package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.common.math.e;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kk7 {
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final byte[] f17720c = new byte[0];
    public static final int d = 65507;
    public static final int e = 12;
    public static final int f = 0;
    public static final int g = 65535;
    public static final int h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f42840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f17722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f17724a;
    public final byte b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f17725b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f17726b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final byte[] f17727b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final byte f17728c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f17729c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f42841a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f17730a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f17731a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f17732a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f17734b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f17733a = kk7.f17720c;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public byte[] f17735b = kk7.f17720c;

        public kk7 i() {
            return new kk7(this);
        }

        public b j(byte[] bArr) {
            sb0.g(bArr);
            this.f17733a = bArr;
            return this;
        }

        public b k(boolean z) {
            this.f17734b = z;
            return this;
        }

        public b l(boolean z) {
            this.f17732a = z;
            return this;
        }

        public b m(byte[] bArr) {
            sb0.g(bArr);
            this.f17735b = bArr;
            return this;
        }

        public b n(byte b) {
            this.f42841a = b;
            return this;
        }

        public b o(int i) {
            sb0.a(i >= 0 && i <= 65535);
            this.f17730a = i & 65535;
            return this;
        }

        public b p(int i) {
            this.b = i;
            return this;
        }

        public b q(long j) {
            this.f17731a = j;
            return this;
        }
    }

    public static int b(int i) {
        return e.r(i + 1, 65536);
    }

    public static int c(int i) {
        return e.r(i - 1, 65536);
    }

    @Nullable
    public static kk7 d(om6 om6Var) {
        byte[] bArr;
        if (om6Var.a() < 12) {
            return null;
        }
        int iG = om6Var.G();
        byte b2 = (byte) (iG >> 6);
        boolean z = ((iG >> 5) & 1) == 1;
        byte b3 = (byte) (iG & 15);
        if (b2 != 2) {
            return null;
        }
        int iG2 = om6Var.G();
        boolean z2 = ((iG2 >> 7) & 1) == 1;
        byte b4 = (byte) (iG2 & 127);
        int iM = om6Var.M();
        long jI = om6Var.I();
        int iO = om6Var.o();
        if (b3 > 0) {
            bArr = new byte[b3 * 4];
            for (int i = 0; i < b3; i++) {
                om6Var.k(bArr, i * 4, 4);
            }
        } else {
            bArr = f17720c;
        }
        byte[] bArr2 = new byte[om6Var.a()];
        om6Var.k(bArr2, 0, om6Var.a());
        return new b().l(z).k(z2).n(b4).o(iM).q(jI).p(iO).j(bArr).m(bArr2).i();
    }

    @Nullable
    public static kk7 e(byte[] bArr, int i) {
        return d(new om6(bArr, i));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || kk7.class != obj.getClass()) {
            return false;
        }
        kk7 kk7Var = (kk7) obj;
        return this.f17728c == kk7Var.f17728c && this.f17721a == kk7Var.f17721a && this.f17729c == kk7Var.f17729c && this.f17722a == kk7Var.f17722a && this.f17725b == kk7Var.f17725b;
    }

    public int f(byte[] bArr, int i, int i2) {
        int length = (this.b * 4) + 12 + this.f17727b.length;
        if (i2 < length || bArr.length - i < length) {
            return -1;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2);
        byte b2 = (byte) (((this.f17723a ? 1 : 0) << 5) | 128 | ((this.f17726b ? 1 : 0) << 4) | (this.b & com.google.common.base.a.q));
        byteBufferWrap.put(b2).put((byte) (((this.f17729c ? 1 : 0) << 7) | (this.f17728c & 127))).putShort((short) this.f17721a).putInt((int) this.f17722a).putInt(this.f17725b).put(this.f17724a).put(this.f17727b);
        return length;
    }

    public int hashCode() {
        int i = (((((527 + this.f17728c) * 31) + this.f17721a) * 31) + (this.f17729c ? 1 : 0)) * 31;
        long j = this.f17722a;
        return ((i + ((int) (j ^ (j >>> 32)))) * 31) + this.f17725b;
    }

    public String toString() {
        return gj9.H("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f17728c), Integer.valueOf(this.f17721a), Long.valueOf(this.f17722a), Integer.valueOf(this.f17725b), Boolean.valueOf(this.f17729c));
    }

    public kk7(b bVar) {
        this.f42840a = (byte) 2;
        this.f17723a = bVar.f17732a;
        this.f17726b = false;
        this.f17729c = bVar.f17734b;
        this.f17728c = bVar.f42841a;
        this.f17721a = bVar.f17730a;
        this.f17722a = bVar.f17731a;
        this.f17725b = bVar.b;
        byte[] bArr = bVar.f17733a;
        this.f17724a = bArr;
        this.b = (byte) (bArr.length / 4);
        this.f17727b = bVar.f17735b;
    }
}
