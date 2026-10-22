package com.kc.cw.ad.d.a.b;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class p implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38805a;
    private Class<?> b;
    private Object c;

    public p(Context context) {
        this.f38805a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
        }
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f38805a);
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38805a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            cVar.a(new com.kc.cw.ad.d.a.e("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.kc.cw.ad.d.a.e("OAID query failed");
            }
            com.kc.cw.ad.d.a.f.a("OAID query success: " + strB);
            cVar.a(strB);
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        return this.c != null;
    }
}
