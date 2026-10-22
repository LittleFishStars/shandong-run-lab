package com.kc.aw;

import android.os.Handler;
import android.text.TextUtils;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l8 implements _eb {
    public final Handler _a;
    public final Runnable _b;
    public final _b3 _c;

    @Keep
    public final class _a implements Runnable {
        public final int _a;
        public final String _b;
        public final _l8 _c;

        public _a(_l8 _l8Var, int i, String str) {
            this._c = _l8Var;
            this._a = i;
            this._b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this._a == 0 || TextUtils.isEmpty(this._b)) {
                _b3 _b3Var = this._c._c;
                if (_b3Var != null) {
                    AdErrorImpl adErrorImpl = new AdErrorImpl();
                    PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.ERR_SERVER;
                    adErrorImpl._a = serverErr.getCode();
                    adErrorImpl._b = serverErr.getMsg();
                    _b3Var.onError(adErrorImpl);
                    return;
                }
                return;
            }
            try {
                boolean zOptBoolean = new JSONObject(this._b).optBoolean("isValid", false);
                _b3 _b3Var2 = this._c._c;
                if (_b3Var2 != null) {
                    _b3Var2._a(Boolean.valueOf(zOptBoolean));
                }
            } catch (Exception e) {
                _b3 _b3Var3 = this._c._c;
                if (_b3Var3 != null) {
                    AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                    PtgRewardConstant.ServerErr serverErr2 = PtgRewardConstant.ServerErr.ERR_PAR;
                    adErrorImpl2._a = serverErr2.getCode();
                    adErrorImpl2._b = serverErr2.getMsg() + " : " + e.getMessage();
                    _b3Var3.onError(adErrorImpl2);
                }
            }
        }
    }

    public _l8(Handler handler, _l7 _l7Var, _lg._b _bVar) {
        this._a = handler;
        this._b = _l7Var;
        this._c = _bVar;
    }

    @Override // com.kc.aw._eb
    public final void _a(_ee _eeVar) {
    }

    @Override // com.kc.aw._eb
    public final void _a(_ee _eeVar, int i, String str) {
        _l9._a.set(false);
        this._a.removeCallbacks(this._b);
        if (_l9._b.get()) {
            return;
        }
        com.kc.aw.lib.utils._d._c(new _a(this, i, str));
    }
}
