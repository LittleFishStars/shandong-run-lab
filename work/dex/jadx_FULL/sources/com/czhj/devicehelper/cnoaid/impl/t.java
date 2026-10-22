package com.czhj.devicehelper.cnoaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class t implements com.czhj.devicehelper.cnoaid.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29367a;
    private Class<?> b;
    private Object c;

    @SuppressLint({"PrivateApi"})
    public t(Context context) {
        this.f29367a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
        }
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f29367a);
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f29367a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            cVar.a(new com.czhj.devicehelper.cnoaid.f("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.czhj.devicehelper.cnoaid.f("OAID query failed");
            }
            com.czhj.devicehelper.cnoaid.g.a("OAID query success: " + strB);
            cVar.a(strB);
        } catch (Exception e) {
            com.czhj.devicehelper.cnoaid.g.a(e);
            cVar.a(e);
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        return this.c != null;
    }
}
