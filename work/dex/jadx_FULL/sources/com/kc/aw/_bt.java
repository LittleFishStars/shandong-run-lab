package com.kc.aw;

import android.app.KeyguardManager;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bt implements _ek {
    public final Context _a;
    public final KeyguardManager _b;

    public _bt(Context context) {
        this._a = context;
        this._b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        if (this._a == null) {
            if (_a3Var != null) {
                _a3Var._a("");
                return;
            }
            return;
        }
        KeyguardManager keyguardManager = this._b;
        if (keyguardManager == null) {
            _a3Var._a("");
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this._b, new Object[0]);
            if (objInvoke == null) {
                _a3Var._a("");
            } else {
                _a3Var._a(objInvoke.toString());
            }
        } catch (Exception unused) {
        }
    }
}
