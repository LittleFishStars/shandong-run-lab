package com.alipay.sdk.m.l0;

import android.content.Context;
import com.alipay.sdk.m.i0.d;
import com.alipay.sdk.m.k0.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f25459a;
    public static com.alipay.sdk.m.i0.a b;

    public static a a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f25459a == null) {
            b = d.a(context, str);
            f25459a = new b();
        }
        return f25459a;
    }

    @Override // com.alipay.sdk.m.l0.a
    public c a(com.alipay.sdk.m.k0.d dVar) {
        return com.alipay.sdk.m.k0.b.a(b.a(com.alipay.sdk.m.k0.b.a(dVar)));
    }

    @Override // com.alipay.sdk.m.l0.a
    public boolean logCollect(String str) {
        return b.logCollect(str);
    }
}
