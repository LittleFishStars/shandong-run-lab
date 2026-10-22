package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class tgb implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f44920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class<?> f19815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f19816a;

    @SuppressLint({"PrivateApi"})
    public tgb(Context context) {
        this.f44920a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f19815a = cls;
            this.f19816a = cls.newInstance();
        } catch (Exception e) {
            ija.a(e);
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        return this.f19816a != null;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f44920a == null || ddksaVar == null) {
            return;
        }
        if (this.f19815a == null || this.f19816a == null) {
            ddksaVar.b(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strC = c();
            if (strC == null || strC.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            ija.a("OAID query success: " + strC);
            ddksaVar.a(strC);
        } catch (Exception e) {
            ija.a(e);
            ddksaVar.b(e);
        }
    }

    public final String c() {
        return (String) this.f19815a.getMethod("getOAID", Context.class).invoke(this.f19816a, this.f44920a);
    }
}
