package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.ajc;
import com.zj.adlib.rgc;
import com.zj.adlib.rmc;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzdj extends rgc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f31401a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5833a = Logger.getLogger(zzdj.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f5834a = s0.C();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f5835a;

    public zzdj() {
    }

    public /* synthetic */ zzdj(ajc ajcVar) {
    }

    public static int A(int i) {
        if ((i & com.alipay.sdk.m.p.a.g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int B(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            j >>>= 14;
            i += 2;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzdj a(byte[] bArr, int i, int i2) {
        return new k(bArr, 0, i2);
    }

    @Deprecated
    public static int v(int i, zzfo zzfoVar, zzgh zzghVar) {
        int iC = ((zzck) zzfoVar).c(zzghVar);
        int iA = A(i << 3);
        return iA + iA + iC;
    }

    public static int w(int i) {
        if (i >= 0) {
            return A(i);
        }
        return 10;
    }

    public static int x(zzfo zzfoVar) {
        int iL = zzfoVar.l();
        return A(iL) + iL;
    }

    public static int y(zzfo zzfoVar, zzgh zzghVar) {
        int iC = ((zzck) zzfoVar).c(zzghVar);
        return A(iC) + iC;
    }

    public static int z(String str) {
        int length;
        try {
            length = u0.e(str);
        } catch (zzhm unused) {
            length = str.getBytes(rmc.b).length;
        }
        return A(length) + length;
    }

    public final void b() {
        if (e() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void c(String str, zzhm zzhmVar) throws IOException {
        f5833a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhmVar);
        byte[] bytes = str.getBytes(rmc.b);
        try {
            int length = bytes.length;
            s(length);
            o(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdh(e);
        }
    }

    public abstract int e();

    public abstract void f(byte b) throws IOException;

    public abstract void g(int i, boolean z) throws IOException;

    public abstract void h(int i, zzdb zzdbVar) throws IOException;

    public abstract void i(int i, int i2) throws IOException;

    public abstract void j(int i) throws IOException;

    public abstract void k(int i, long j) throws IOException;

    public abstract void l(long j) throws IOException;

    public abstract void m(int i, int i2) throws IOException;

    public abstract void n(int i) throws IOException;

    public abstract void o(byte[] bArr, int i, int i2) throws IOException;

    public abstract void p(int i, String str) throws IOException;

    public abstract void q(int i, int i2) throws IOException;

    public abstract void r(int i, int i2) throws IOException;

    public abstract void s(int i) throws IOException;

    public abstract void t(int i, long j) throws IOException;

    public abstract void u(long j) throws IOException;
}
