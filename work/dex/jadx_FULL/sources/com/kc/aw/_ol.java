package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ol implements _ek {
    public Context _a;
    public Class<?> _b;
    public Object _c;

    public _ol(Context context) {
        this._a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this._b = cls;
            this._c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        String str;
        try {
            try {
                str = (String) this._b.getMethod("getOAID", Context.class).invoke(this._c, this._a);
            } catch (Throwable th) {
                th.printStackTrace();
                str = "";
            }
            if (_a3Var != null) {
                _a3Var._a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
