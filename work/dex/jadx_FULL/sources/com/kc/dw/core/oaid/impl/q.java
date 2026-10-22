package com.kc.dw.core.oaid.impl;

import android.content.Context;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39295a;
    public Class<?> b;
    public Object c;

    public q(Context context) {
        this.f39295a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39295a == null || aVar == null) {
            return;
        }
        Class<?> cls = this.b;
        if (cls == null || this.c == null) {
            ((com.kc.dw.core.utils.n) aVar).a(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String str = (String) cls.getMethod("getOAID", Context.class).invoke(this.c, this.f39295a);
            if (str == null || str.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            ((com.kc.dw.core.utils.n) aVar).a(str);
        } catch (Exception e) {
            ((com.kc.dw.core.utils.n) aVar).a(e);
        }
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        return this.c != null;
    }
}
