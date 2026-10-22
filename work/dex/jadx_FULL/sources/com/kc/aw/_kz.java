package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kz implements Runnable {
    public final long _a;
    public final _l0 _b;

    public _kz(_l0 _l0Var, long j) {
        this._b = _l0Var;
        this._a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2 = PtgAdSdk.getConfig()._f;
        if (this._a < 0) {
            str = "TrackingManager: DoInitTracking fail, initialization is not complete";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                if (!_nt._d.compareAndSet(false, true)) {
                    Logger.d("TrackingManager: DoInitTracking fail, reportUrl had report ");
                    return;
                }
                this._b.getClass();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sdk", _l0._b());
                    jSONObject.put("device", _l0._c());
                    jSONObject.put(NativeCallContext.DOMAIN_APP, _l0._a());
                } catch (JSONException unused) {
                }
                try {
                    jSONObject.put("initTime", this._a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                _h1._a(_l0._a(str2, "__DATA__", jSONObject.toString()));
                return;
            }
            str = "TrackingManager: DoInitTracking fail, reportUrl is null ";
        }
        Logger.d(str);
    }
}
