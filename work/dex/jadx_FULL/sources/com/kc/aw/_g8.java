package com.kc.aw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.igexin.push.core.b;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g8 implements _a4 {
    public static final CopyOnWriteArraySet<String> _h = new CopyOnWriteArraySet<>();
    public boolean _a;
    public boolean _b;
    public IntentFilter _d;
    public _a _e;
    public boolean _f;
    public boolean _c = true;
    public Handler _g = new Handler(Looper.getMainLooper());

    @Keep
    public final class _a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int i;
            if (intent.getAction() == null || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (com.kc.aw.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfQURERUQ=").equals(intent.getAction())) {
                i = 1;
            } else {
                i = com.kc.aw.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ=").equals(intent.getAction()) ? 2 : 0;
            }
            CopyOnWriteArraySet<String> copyOnWriteArraySet = _g8._h;
            if (copyOnWriteArraySet.contains(schemeSpecificPart)) {
                return;
            }
            copyOnWriteArraySet.add(schemeSpecificPart);
            _nr _nrVar = new _nr(_m4._a);
            _nrVar._c = "ain";
            _nq _nqVar_c = _nrVar._c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.aC, schemeSpecificPart);
                jSONObject.put("type", i);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("av", (Object) null);
                _nqVar_c._a.put("ain", jSONObject);
            } catch (Exception unused) {
            }
            _nqVar_c._i(PtgAdSdk.config._a);
            String str_a = _l0._a(PtgAdSdk.config._G, _nrVar);
            if (TextUtil.isNotEmpty(str_a)) {
                _h1._a(str_a);
            }
        }
    }

    @Keep
    public static final class _b {
        public static final _g8 _a = new _g8();
    }

    @Override // com.kc.aw._a4
    public final void _a() {
        this._c = true;
        _c();
    }

    @Override // com.kc.aw._a4
    public final void _b() {
        this._c = false;
        if (this._e == null || !this._b || this._a || !this._f) {
            return;
        }
        PtgAdSdk.getContext().unregisterReceiver(this._e);
        this._b = false;
    }

    public final void _c() {
        if (this._d == null) {
            IntentFilter intentFilter = new IntentFilter();
            this._d = intentFilter;
            intentFilter.addAction(com.kc.aw.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfQURERUQ="));
            this._d.addAction(com.kc.aw.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ="));
            this._d.addDataScheme("package");
        }
        if (this._e == null) {
            this._e = new _a();
        }
        if ((this._a || this._c) && !this._b && this._f) {
            PtgAdSdk.getContext().getApplicationContext().registerReceiver(this._e, this._d);
            this._b = true;
        }
    }
}
