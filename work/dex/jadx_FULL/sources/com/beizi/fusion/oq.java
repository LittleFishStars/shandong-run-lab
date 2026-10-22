package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class oq implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27628a;
    private Class b;
    private Object c;

    public oq(Context context) {
        this.f27628a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            yj.a(e);
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f27628a);
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        return this.c != null;
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27628a == null || kcVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            kcVar.a(new tj("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new tj("OAID query failed");
            }
            yj.a("OAID query success: " + strB);
            kcVar.a(strB);
        } catch (Exception e) {
            yj.a(e);
            kcVar.a(e);
        }
    }
}
