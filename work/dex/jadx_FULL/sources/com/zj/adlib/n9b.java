package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.fj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n9b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r4b f18376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18377a;

    public n9b(Context context, r4b r4bVar, String str) {
        this.f43477a = context.getApplicationContext();
        this.f18376a = r4bVar;
        this.f18377a = str;
    }

    public static String a(Context context, r4b r4bVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(r4bVar.f());
            sb.append("\",\"product\":\"");
            sb.append(r4bVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(fj.F(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public final byte[] b() {
        return s4b.p(a(this.f43477a, this.f18376a, this.f18377a));
    }
}
