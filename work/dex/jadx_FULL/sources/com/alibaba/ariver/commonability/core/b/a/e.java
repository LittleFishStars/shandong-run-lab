package com.alibaba.ariver.commonability.core.b.a;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class e implements com.alibaba.ariver.commonability.core.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23938a = 20;
    public static final int b = 60;
    public static final int c = 200;

    public abstract void a(com.alibaba.ariver.commonability.core.a.a aVar);

    public abstract void b();

    public void b(Context context, JSONObject jSONObject) {
        a(context, jSONObject);
    }

    public void c() {
        b();
        a();
    }
}
