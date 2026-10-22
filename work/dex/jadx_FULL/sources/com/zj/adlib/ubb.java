package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.ij;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ubb extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45111a = 13;
    public static int b = 6;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f20028a;

    public ubb(Context context, ij ijVar) {
        super(ijVar);
        this.f20028a = context;
    }

    public static byte[] c(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = new byte[0];
        try {
            try {
                s4b.l(byteArrayOutputStream, "1.2." + f45111a + Consts.DOT + b);
                s4b.l(byteArrayOutputStream, "Android");
                s4b.l(byteArrayOutputStream, fj.L());
                s4b.l(byteArrayOutputStream, fj.G());
                s4b.l(byteArrayOutputStream, fj.N(context));
                s4b.l(byteArrayOutputStream, Build.MANUFACTURER);
                s4b.l(byteArrayOutputStream, Build.MODEL);
                s4b.l(byteArrayOutputStream, Build.DEVICE);
                s4b.l(byteArrayOutputStream, fj.h0(context));
                s4b.l(byteArrayOutputStream, j4b.g(context));
                s4b.l(byteArrayOutputStream, j4b.h(context));
                s4b.l(byteArrayOutputStream, j4b.j(context));
                byteArrayOutputStream.write(new byte[]{0});
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                a7b.m(th2, "sm", "gh");
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                throw th3;
            }
        }
        return byteArray;
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) {
        byte[] bArrC = c(this.f20028a);
        byte[] bArr2 = new byte[bArrC.length + bArr.length];
        System.arraycopy(bArrC, 0, bArr2, 0, bArrC.length);
        System.arraycopy(bArr, 0, bArr2, bArrC.length, bArr.length);
        return bArr2;
    }
}
