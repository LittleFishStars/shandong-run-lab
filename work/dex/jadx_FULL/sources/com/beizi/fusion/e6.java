package com.beizi.fusion;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e6 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27214a;
    private final KeyguardManager b;

    public e6(Context context) {
        this.f27214a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f27214a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.b, null);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27214a == null || jcVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            jcVar.a(new sj("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.b, null);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                xj.a("OAID obtain success: " + string);
                jcVar.a(string);
                return;
            }
            throw new sj("OAID obtain failed");
        } catch (Exception e) {
            xj.a(e);
        }
    }
}
