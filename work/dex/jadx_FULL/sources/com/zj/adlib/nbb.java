package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.fj;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class nbb {
    public static k9b a(WeakReference<k9b> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new k9b());
        }
        return weakReference.get();
    }

    public static String b() {
        return s4b.b(System.currentTimeMillis());
    }

    public static String c(Context context, r4b r4bVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String strK = fj.K(context);
            sb.append("\"sim\":\"");
            sb.append(strK);
            sb.append("\",\"sdkversion\":\"");
            sb.append(r4bVar.f());
            sb.append("\",\"product\":\"");
            sb.append(r4bVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(r4bVar.g());
            sb.append("\",\"nt\":\"");
            sb.append(fj.F(context));
            sb.append("\",\"np\":\"");
            sb.append(fj.A(context));
            sb.append("\",\"mnc\":\"");
            sb.append(fj.E(context));
            sb.append("\",\"ant\":\"");
            sb.append(fj.H(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String d(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String e(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void f(Context context, k9b k9bVar, String str, int i, int i2, String str2) {
        k9bVar.f17616a = y6b.i(context, str);
        k9bVar.f42769a = i;
        k9bVar.f17612a = i2;
        k9bVar.f17617b = str2;
    }

    public static byte[] g(e9b e9bVar, String str) {
        e9b.e eVarB;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVarB = e9bVar.b(str);
            if (eVarB == null) {
                if (eVarB != null) {
                    try {
                        eVarB.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            try {
                InputStream inputStreamA = eVarB.a();
                if (inputStreamA == null) {
                    if (inputStreamA != null) {
                        try {
                            inputStreamA.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    try {
                        eVarB.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return bArr;
                }
                bArr = new byte[inputStreamA.available()];
                inputStreamA.read(bArr);
                try {
                    inputStreamA.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    eVarB.close();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    a7b.m(th, "sui", "rdS");
                    return bArr;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (eVarB != null) {
                        try {
                            eVarB.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            eVarB = null;
        }
    }
}
