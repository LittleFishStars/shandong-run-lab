package com.beizi.fusion;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class mq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27544a;
    private Class b;
    private Object c;
    private Method d;

    public mq(Context context) {
        this.f27544a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            om.a(e);
        }
        try {
            this.d = this.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            om.a(e2);
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
            om.a(e);
            return null;
        }
    }

    public String a() {
        return a(this.f27544a, this.d);
    }
}
