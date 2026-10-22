package com.zj.adlib;

import android.app.KeyguardManager;
import android.content.Context;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.dddssad;
import cn.hzjizhun.admin.sdkdda;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dja implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyguardManager f41212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f16029a;

    public dja(Context context) {
        this.f16029a = context;
        this.f41212a = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f16029a == null || (keyguardManager = this.f41212a) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f41212a, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f16029a == null || ddakdVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f41212a;
        if (keyguardManager == null) {
            ddakdVar.b(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f41212a, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String string = objInvoke.toString();
            dddssad.a("OAID obtain success: " + string);
            ddakdVar.a(string);
        } catch (Throwable th) {
            dddssad.a(th);
        }
    }
}
