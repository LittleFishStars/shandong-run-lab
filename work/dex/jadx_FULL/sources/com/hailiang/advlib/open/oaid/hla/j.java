package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class j implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32599a;
    private Class<?> b;
    private Object c;

    public j(Context context) {
        this.f32599a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f32599a);
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32599a == null || aVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            aVar.a(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            aVar.a(strB);
        } catch (Exception e) {
            aVar.a(e);
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        return this.c != null;
    }
}
