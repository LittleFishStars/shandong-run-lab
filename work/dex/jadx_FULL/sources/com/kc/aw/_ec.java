package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ec implements _eb {
    public final _ho _a;
    public final String _b;
    public final _ed _c;

    public _ec(_ed _edVar, _ho _hoVar, String str) {
        this._c = _edVar;
        this._a = _hoVar;
        this._b = str;
    }

    @Override // com.kc.aw._eb
    public final void _a(_ee _eeVar) {
        if (!TextUtils.isEmpty(_eeVar._e)) {
            _eeVar._a.put("Content-Length", String.valueOf(_eeVar._e.getBytes(Charset.forName("UTF-8")).length));
        }
        _eeVar._a.put("Content-Type", ze1.g);
    }

    @Override // com.kc.aw._eb
    public final void _a(_ee _eeVar, int i, String str) {
        String str_a;
        StringBuilder sb_a = _jf._a("HttpConfigPolicyLoader:");
        sb_a.append(String.format("Load with code:%d, result:%s", Integer.valueOf(i), ""));
        Logger.d(sb_a.toString());
        if (i != 1) {
            this._a._c(String.format("HttpConfigPolicyLoader Load failed on url:%s", this._b));
            return;
        }
        try {
            str_a = com.kc.aw.lib.utils._a._a(_eeVar._f, PtgAdSdk.getConfig()._h);
        } catch (Exception unused) {
            str_a = null;
        }
        if (TextUtils.isEmpty(str_a)) {
            this._c.getClass();
            Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "Policy 文件解析失败", (Object) null).getMessage());
            this._a._c(String.format("HttpConfigPolicyLoader parsing failed on url:%s", this._b));
            return;
        }
        _cj _cjVar = new _cj();
        _cn _cnVar = new _cn();
        if (!_cnVar._c(str_a)) {
            this._c.getClass();
            Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "Policy 数据解析失败", (Object) null).getMessage());
            this._a._c(String.format("HttpConfigPolicyLoader DispatchSdkConfig Unmarshal Json failed on url:%s, body:%s", this._b, str_a));
            return;
        }
        if (!_cjVar._a(str_a, _cnVar)) {
            this._c.getClass();
            Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "Policy 数据解析失败", (Object) null).getMessage());
            this._a._c(String.format("HttpConfigPolicyLoader DispatchPolicy Unmarshal Json failed on url:%s, body:%s", this._b, str_a));
        } else if (!_cnVar._a()) {
            this._c.getClass();
            Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, PtgErrorCode.PACKAGE_NAME_ERROR_STR, (Object) null).getMessage());
            this._a._c(String.format("packageName check err url:%s, body:%s", this._b, str_a));
        } else {
            StringBuilder sb_a2 = _jf._a("HttpConfigPolicyLoader policy fetched version: ");
            sb_a2.append(_cnVar._f);
            Logger.i(sb_a2.toString());
            this._a._a(_cjVar, _cnVar);
            this._a._b(str_a);
            this._a._a(str_a);
        }
    }
}
