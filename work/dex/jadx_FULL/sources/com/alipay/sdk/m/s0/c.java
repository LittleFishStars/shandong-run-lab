package com.alipay.sdk.m.s0;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25504a;
    public static final Object b = new Object();

    public static long a(b bVar) {
        if (bVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", bVar.c(), bVar.d(), Long.valueOf(bVar.a()), bVar.e(), bVar.b());
        if (com.alipay.sdk.m.q0.f.b(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static synchronized b b(Context context) {
        b bVar = f25504a;
        if (bVar != null) {
            return bVar;
        }
        if (context == null) {
            return null;
        }
        b bVarA = a(context);
        f25504a = bVarA;
        return bVarA;
    }

    public static b a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (b) {
            String strE = d.a(context).e();
            if (com.alipay.sdk.m.q0.f.b(strE)) {
                return null;
            }
            if (strE.endsWith("\n")) {
                strE = strE.substring(0, strE.length() - 1);
            }
            b bVar = new b();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.alipay.sdk.m.q0.d.a(context);
            String strB = com.alipay.sdk.m.q0.d.b(context);
            bVar.c(strA);
            bVar.a(strA);
            bVar.b(jCurrentTimeMillis);
            bVar.b(strB);
            bVar.d(strE);
            bVar.a(a(bVar));
            return bVar;
        }
    }
}
