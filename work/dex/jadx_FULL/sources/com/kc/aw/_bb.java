package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bb implements Serializable {
    public int _a;
    public int _b;
    public long _c;

    public static _bb _a(JSONObject jSONObject) {
        _bb _bbVar = new _bb();
        long jOptLong = 5;
        if (jSONObject != null) {
            _bbVar._a = jSONObject.optInt("autoPlayMode");
            _bbVar._b = jSONObject.optInt("soundType");
            jSONObject.optInt("renderType");
            jOptLong = jSONObject.optLong("countDownTime", 5L);
        } else {
            _bbVar._a = 1;
            _bbVar._b = 0;
        }
        _bbVar._c = jOptLong;
        return _bbVar;
    }
}
