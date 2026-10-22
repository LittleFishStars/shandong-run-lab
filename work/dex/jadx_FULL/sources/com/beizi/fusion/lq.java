package com.beizi.fusion;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27526a;
    private Class b;
    private Object c;
    private Method d;

    public lq(Context context) {
        this.f27526a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.d = this.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String a(Context context, Method method) {
        Object obj = this.c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String a() {
        return a(this.f27526a, this.d);
    }
}
