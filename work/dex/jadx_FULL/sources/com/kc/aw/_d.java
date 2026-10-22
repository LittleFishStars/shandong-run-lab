package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d implements Runnable {
    public final String _a;
    public final String _b;
    public final _c _c;

    public _d(_c _cVar, String str, String str2) {
        this._c = _cVar;
        this._a = str;
        this._b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _i2._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strReplace = str.replace("__ACTION__", "openDeep");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reqId", this._a);
            jSONObject.putOpt("pkgName", this._b);
        } catch (Exception unused) {
        }
        String str_a = _hj._a(strReplace.replace("__DATA__", com.kc.aw.lib.utils._a._b(jSONObject.toString())), _c._a(this._c));
        _nt _ntVar_a = _nt._a();
        _l0 _l0Var = _ntVar_a._b;
        if (_l0Var == null) {
            _l0Var = new _l0();
            _ntVar_a._b = _l0Var;
        }
        _l0Var._a(str_a);
    }
}
