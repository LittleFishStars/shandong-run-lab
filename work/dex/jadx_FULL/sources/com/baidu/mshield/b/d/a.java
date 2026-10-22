package com.baidu.mshield.b.d;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f26703a;
    public Context b;

    public a(Context context, Handler handler) {
        try {
            this.b = context;
            this.f26703a = new b(context, handler);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public String a() {
        return this.f26703a.a();
    }

    public String a(String str, byte[] bArr) throws Throwable {
        if (str != null) {
            return !com.baidu.mshield.b.e.a.d(this.b) ? "" : this.f26703a.a(str, bArr);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
