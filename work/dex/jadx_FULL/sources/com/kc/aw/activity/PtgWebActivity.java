package com.kc.aw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.kc.aw._fr;
import com.kc.aw._h;
import com.kc.aw._h8;
import com.kc.aw._hd;
import com.kc.aw._k;
import com.kc.aw._ko;
import com.kc.aw._kp;
import com.kc.aw._ob;
import com.kc.aw._r;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.widget.titlebar.PtgTitleBarWeb;
import com.kc.aw.widget.web.AdvancedWebView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgWebActivity extends Activity {
    public static final int _g = 0;
    public PtgTitleBarWeb _a;
    public AdvancedWebView _b;
    public ProgressBar _c;
    public String _d;
    public _kp _e;
    public _ob _f;

    public static void _a(Context context, _h _hVar) {
        _k _kVar;
        _r _rVar = new _r();
        if (_hVar != null) {
            _rVar._a = _hVar._i;
            Map<String, String> map = _hVar._G;
            _rVar._d = map != null ? "1".equals(map.get(com.kc.aw.lib.utils._a._a("bGlua01vZGU="))) : false;
            _rVar._f = _hVar._e;
            _rVar._b = _hVar._o();
            Map<String, String> map2 = _hVar._G;
            _rVar._e = map2 != null ? map2.get(com.kc.aw.lib.utils._a._a("bGlua1NpZ24=")) : "";
            _k _kVar2 = _hVar._q;
            _rVar._g = _kVar2 != null ? _kVar2._w : null;
            _rVar._h = _hVar._u;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("playerInfo", _rVar);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
        if (_hVar == null || (_kVar = _hVar._q) == null) {
            return;
        }
        _kVar._w = null;
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        CopyOnWriteArrayList<_hd<String>> copyOnWriteArrayList = _fr._b._a.get("splashAdDismiss");
        if (TextUtil.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        Iterator<_hd<String>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next()._a(String.valueOf(3));
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        com.kc.aw.lib.helper.imp._a _aVar;
        AdvancedWebView advancedWebView;
        super.onActivityResult(i, i2, intent);
        _kp _kpVar = this._e;
        if (_kpVar == null || (_aVar = _kpVar._a) == null || (advancedWebView = _aVar._a) == null) {
            return;
        }
        advancedWebView._a(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (this._e == null || this._b._b()) {
            _ob _obVar = this._f;
            if (_obVar == null || _obVar._a()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().requestFeature(1);
        } catch (Exception unused) {
        }
        setContentView(R.layout.aw_activity_web);
        try {
            this._b = new AdvancedWebView(this);
            ((FrameLayout) findViewById(R.id.webContainer)).addView(this._b, 0);
            _kp _kpVar = new _kp(getIntent());
            this._e = _kpVar;
            this._d = _kpVar._c;
            this._f = new _ob(_kpVar._b, _kpVar._d);
            this._a = (PtgTitleBarWeb) findViewById(R.id.ptgTitleBar);
            this._c = (ProgressBar) findViewById(R.id.ptgProgressBar);
            this._a._d();
            PtgTitleBarWeb ptgTitleBarWeb = this._a;
            Window window = getWindow();
            _h8 _h8Var_a = _h8._a();
            Window window2 = getWindow();
            _h8Var_a.getClass();
            ptgTitleBarWeb._a(window, _h8._a(window2));
            this._a.setBackgroundColor(ContextCompat.getColor(this, R.color.aw_white));
            this._a.setTitleColor(-16777216);
            this._a.setOnClickListener(new _ko(this));
            if (this._e == null || isFinishing()) {
                return;
            }
            _kp _kpVar2 = this._e;
            PtgTitleBarWeb ptgTitleBarWeb2 = this._a;
            AdvancedWebView advancedWebView = this._b;
            ProgressBar progressBar = this._c;
            String str = this._d;
            _kpVar2.getClass();
            if (advancedWebView == null) {
                return;
            }
            com.kc.aw.lib.helper.imp._a _aVar = new com.kc.aw.lib.helper.imp._a();
            _kpVar2._a = _aVar;
            _aVar._a(this, ptgTitleBarWeb2, advancedWebView, progressBar, str);
        } catch (Exception unused2) {
            Logger.e("PtgWebActivity", "webView create failed");
            if (isFinishing()) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        com.kc.aw.lib.helper.imp._a _aVar;
        super.onDestroy();
        _kp _kpVar = this._e;
        if (_kpVar != null && (_aVar = _kpVar._a) != null) {
            try {
                AdvancedWebView advancedWebView = _aVar._a;
                if (advancedWebView != null) {
                    advancedWebView.clearCache(true);
                    _aVar._a.clearHistory();
                    _aVar._a.stopLoading();
                    if (_aVar._a.getSettings() != null) {
                        _aVar._a.getSettings().setJavaScriptEnabled(false);
                    }
                    _aVar._a.setWebViewClient(null);
                    AdvancedWebView advancedWebView2 = _aVar._a;
                    advancedWebView2.getClass();
                    try {
                        ((ViewGroup) advancedWebView2.getParent()).removeView(advancedWebView2);
                    } catch (Exception unused) {
                    }
                    try {
                        advancedWebView2.removeAllViews();
                    } catch (Exception unused2) {
                    }
                    advancedWebView2.destroy();
                    _aVar._a = null;
                }
                com.kc.aw.lib.utils._d._a(_aVar._g);
                _aVar._b = null;
                _aVar._c = null;
            } catch (Throwable unused3) {
            }
            _kpVar._a = null;
        }
        this._f = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
    }
}
