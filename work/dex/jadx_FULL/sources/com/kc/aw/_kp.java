package com.kc.aw;

import android.content.Intent;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kp {
    public com.kc.aw.lib.helper.imp._a _a;
    public String _b;
    public String _c;
    public Map<String, Object> _d;

    public _kp(Intent intent) {
        _r _rVar = (_r) intent.getSerializableExtra("playerInfo");
        if (_rVar != null) {
            this._b = _rVar._a();
            this._c = _rVar._b();
            this._d = _rVar._c();
        }
    }
}
