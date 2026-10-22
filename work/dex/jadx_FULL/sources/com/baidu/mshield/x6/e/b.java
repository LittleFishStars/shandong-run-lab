package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x6.EngineImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26760a;
    public com.baidu.mshield.x6.b.b b;

    public b(Context context) {
        this.f26760a = context;
        this.b = new com.baidu.mshield.x6.b.b(this.f26760a);
    }

    public void a() {
        try {
            String strR = this.b.r();
            String propertyByType = EngineImpl.getInstance(this.f26760a).getPropertyByType("arid");
            TextUtils.isEmpty("");
            if (TextUtils.isEmpty(propertyByType)) {
                propertyByType = "";
            }
            if (TextUtils.isEmpty(strR)) {
                String strA = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.isEmpty(strA)) {
                    this.b.c(strA);
                }
            } else {
                String strA2 = com.baidu.mshield.b.f.e.a("" + propertyByType);
                if (!TextUtils.equals(strR, strA2)) {
                    this.b.c(strA2);
                    h.a(this.f26760a).a(3, true);
                }
            }
            this.b.c(true);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}
