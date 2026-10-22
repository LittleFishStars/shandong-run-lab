package com.beizi.fusion;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f6 implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27285a;
    private final KeyguardManager b;

    public f6(Context context) {
        this.f27285a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f27285a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.b, null);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27285a == null || kcVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            kcVar.a(new tj("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.b, null);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                yj.a("OAID obtain success: " + string);
                kcVar.a(string);
                return;
            }
            throw new tj("OAID obtain failed");
        } catch (Exception e) {
            yj.a(e);
        }
    }
}
