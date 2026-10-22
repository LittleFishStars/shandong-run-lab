package com.kc.cw.ad.d.a.b;

import android.app.KeyguardManager;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38787a;
    private final KeyguardManager b;

    public c(Context context) {
        this.f38787a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38787a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            cVar.a(new com.kc.cw.ad.d.a.e("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke == null) {
                throw new com.kc.cw.ad.d.a.e("OAID obtain failed");
            }
            String string = objInvoke.toString();
            com.kc.cw.ad.d.a.f.a("OAID obtain success: " + string);
            cVar.a(string);
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
        }
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f38787a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            com.kc.cw.ad.d.a.f.a(e);
            return false;
        }
    }
}
