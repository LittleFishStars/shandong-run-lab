package com.baidu.mshield.x0.i;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26750a;
    public String b = "";

    public b(Context context) {
        this.f26750a = context;
    }

    public static synchronized b a(Context context) {
        return new b(context);
    }

    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        String strC = d.c();
        sb.append(a("p/1/r", str));
        sb.append("&msg_id=" + strC);
        return sb.toString();
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String strL = d.l(this.f26750a);
        if (!TextUtils.isEmpty(strL)) {
            this.b = strL;
        }
        return this.b;
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] bArrA = null;
        try {
            bArrA = com.baidu.mshield.b.a.c.a(str.getBytes("utf-8"));
            return com.baidu.mshield.b.f.d.b(bArrA, bArr);
        } catch (Throwable th) {
            d.a(th);
            return bArrA;
        }
    }

    public String a(String str) {
        return a("s/5/aio", str);
    }

    public final String a(String str, String str2, String str3) {
        String strA;
        try {
            String strC = d.c(this.f26750a);
            String strD = d.d(this.f26750a);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                strA = d.a(strC, strD, jCurrentTimeMillis);
            } catch (Throwable th) {
                d.a(th);
                strA = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a());
            stringBuffer.append(str);
            stringBuffer.append("/250");
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + strC);
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + jCurrentTimeMillis);
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + strA);
            stringBuffer.append("?skey=" + str2);
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("&page=" + str3);
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            d.a(th2);
            return "";
        }
    }

    public final String a(String str, String str2) {
        return a(str, str2, "");
    }
}
