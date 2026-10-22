package com.zj.adlib;

import android.app.KeyguardManager;
import android.content.Context;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hwa implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyguardManager f42222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f17086a;

    public hwa(Context context) {
        this.f17086a = context;
        this.f42222a = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f17086a == null || (keyguardManager = this.f42222a) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f42222a, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            ija.a(e);
            return false;
        }
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f17086a == null || ddksaVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f42222a;
        if (keyguardManager == null) {
            ddksaVar.b(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f42222a, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String string = objInvoke.toString();
            ija.a("OAID obtain success: " + string);
            ddksaVar.a(string);
        } catch (Exception e) {
            ija.a(e);
        }
    }
}
