package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class nq implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27570a;
    private Class b;
    private Object c;

    public nq(Context context) {
        this.f27570a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            xj.a(e);
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f27570a);
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        return this.c != null;
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27570a == null || jcVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            jcVar.a(new sj("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new sj("OAID query failed");
            }
            xj.a("OAID query success: " + strB);
            jcVar.a(strB);
        } catch (Exception e) {
            xj.a(e);
            jcVar.a(e);
        }
    }
}
