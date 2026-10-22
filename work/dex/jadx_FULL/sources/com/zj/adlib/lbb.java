package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.fj;
import com.amap.api.maps.AMapException;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class lbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17918a;
    public String b;
    public String c;
    public String d;

    public lbb(Context context, String str, String str2, String str3) throws ff {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new ff(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.f43033a = context.getApplicationContext();
        this.b = str;
        this.c = str2;
        this.f17918a = str3;
    }

    public static byte[] c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public final void a(String str) throws ff {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new ff(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.d = str;
    }

    public final byte[] b() {
        int iCurrentTimeMillis = 0;
        byte[] byteArray = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    s4b.l(byteArrayOutputStream2, this.b);
                    s4b.l(byteArrayOutputStream2, this.c);
                    s4b.l(byteArrayOutputStream2, this.f17918a);
                    s4b.l(byteArrayOutputStream2, String.valueOf(fj.Y(this.f43033a)));
                    try {
                        iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    } catch (Throwable unused) {
                    }
                    byteArrayOutputStream2.write(c(iCurrentTimeMillis));
                    byteArrayOutputStream2.write(d(this.d));
                    byteArrayOutputStream2.write(s4b.p(this.d));
                    byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        a7b.m(th, "se", "tds");
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return byteArray;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return byteArray;
    }

    public final byte[] d(String str) {
        byte[] bArrP;
        if (!TextUtils.isEmpty(str) && (bArrP = s4b.p(this.d)) != null) {
            return s4b.o(bArrP.length);
        }
        return new byte[]{0, 0};
    }
}
