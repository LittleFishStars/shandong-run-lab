package com.kc.aw;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.core.b;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bd implements Runnable {
    public final Intent _a;
    public final _be _b;

    public _bd(_be _beVar, Intent intent) {
        this._b = _beVar;
        this._a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _l6 _l6Var_a;
        _be _beVar = this._b;
        Intent intent = this._a;
        _beVar.getClass();
        try {
            Uri data = intent.getData();
            if (data != null && (_l6Var_a = _be._a(_beVar._a, data)) != null) {
                CopyOnWriteArraySet<String> copyOnWriteArraySet = _g8._h;
                if (copyOnWriteArraySet.contains(_l6Var_a._a)) {
                    return;
                }
                copyOnWriteArraySet.add(_l6Var_a._a);
                _nr _nrVar = new _nr(_m4._a);
                _nrVar._c = "ain";
                _nq _nqVar_c = _nrVar._c();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(b.aC, _l6Var_a._a);
                    jSONObject.put("type", _l6Var_a._c);
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put("av", _l6Var_a._b);
                    _nqVar_c._a.put("ain", jSONObject);
                } catch (Exception unused) {
                }
                _nqVar_c._i(PtgAdSdk.config._a);
                String str_a = _l0._a(PtgAdSdk.config._G, _nrVar);
                if (TextUtil.isNotEmpty(str_a)) {
                    _h1._a(str_a);
                }
            }
        } catch (Exception unused2) {
        }
    }
}
