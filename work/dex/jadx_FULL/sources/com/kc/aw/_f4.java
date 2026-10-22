package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f4 implements Serializable {
    public int _a;
    public int _b;
    public int _c;
    public String _d;
    public int _e;
    public int _f;
    public String _g;

    public static _f4 _a(JSONObject jSONObject) {
        _f4 _f4Var = new _f4();
        if (jSONObject != null) {
            _f4Var._a = jSONObject.optInt("screenType");
            jSONObject.optInt("renderType");
            _f4Var._b = jSONObject.optInt("soundType");
            _f4Var._c = jSONObject.optInt("countDownSkipSeconds");
            _f4Var._d = jSONObject.optString("rewardName");
            _f4Var._e = jSONObject.optInt("rewardQuantity");
            _f4Var._f = jSONObject.optInt("rewardConfirmType");
            _f4Var._g = jSONObject.optString("rewardCallbackUrl");
        }
        return _f4Var;
    }
}
