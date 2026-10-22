package com.kc.dw.core.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39281a;
    public final KeyguardManager b;

    public c(Context context) {
        this.f39281a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39281a == null || aVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            ((com.kc.dw.core.utils.n) aVar).a(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            ((com.kc.dw.core.utils.n) aVar).a(objInvoke.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f39281a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
