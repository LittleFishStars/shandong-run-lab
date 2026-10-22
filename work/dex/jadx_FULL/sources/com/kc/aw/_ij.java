package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ij {
    public String _a;
    public String _b;
    public boolean _c;

    @Keep
    public static final class _a {
        public String _a;
        public String _b;
        public boolean _c;
    }

    public _ij(_a _aVar) {
        this._a = _aVar._a;
        this._b = _aVar._b;
        this._c = _aVar._c;
        if (TextUtils.isEmpty(this._a)) {
            throw new NullPointerException("播放地址为空");
        }
        _a(this._a);
    }

    public final void _a(String str) {
        this._a = str;
    }
}
