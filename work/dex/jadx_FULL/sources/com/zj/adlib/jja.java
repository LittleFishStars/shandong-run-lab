package com.zj.adlib;

import android.content.Context;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.dddssad;
import cn.hzjizhun.admin.sdkdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class jja implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class f17408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f17409a;

    public jja(Context context) {
        this.f42603a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f17408a = cls;
            this.f17409a = cls.newInstance();
        } catch (Throwable th) {
            dddssad.a(th);
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        return this.f17409a != null;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f42603a == null || ddakdVar == null) {
            return;
        }
        if (this.f17408a == null || this.f17409a == null) {
            ddakdVar.b(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strC = c();
            if (strC == null || strC.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            dddssad.a("OAID query success: " + strC);
            ddakdVar.a(strC);
        } catch (Throwable th) {
            dddssad.a(th);
            ddakdVar.b(th);
        }
    }

    public final String c() {
        return (String) this.f17408a.getMethod("getOAID", Context.class).invoke(this.f17409a, this.f42603a);
    }
}
