package com.kc.aw.lib.helper.imp;

import android.app.Activity;
import android.content.Intent;
import android.widget.ProgressBar;
import com.kc.aw._oc;
import com.kc.aw._r;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.widget.titlebar.PtgTitleBarWeb;
import com.kc.aw.widget.web.AdvancedWebView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a {
    public AdvancedWebView _a;
    public ProgressBar _b;
    public PtgTitleBarWeb _c;
    public List<String> _d;
    public int _e;
    public _r _f;
    public final RunnableC0956_a _g = new RunnableC0956_a(this);

    /* JADX INFO: renamed from: com.kc.aw.lib.helper.imp._a$_a, reason: collision with other inner class name */
    @Keep
    public final class RunnableC0956_a implements Runnable {
        public final _a _a;

        public RunnableC0956_a(_a _aVar) {
            this._a = _aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdvancedWebView advancedWebView = this._a._a;
            if (advancedWebView == null || advancedWebView.getSettings() == null) {
                return;
            }
            this._a._a.getSettings().setJavaScriptEnabled(true);
        }
    }

    public static boolean _a(_a _aVar) {
        int i = _aVar._e;
        if (i <= 0) {
            return false;
        }
        _aVar._e = Math.max(500, Math.min(i, 5000));
        return true;
    }

    public static boolean _a(_a _aVar, String str) {
        List<String> list = _aVar._d;
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = _aVar._d.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void _a(Activity activity, PtgTitleBarWeb ptgTitleBarWeb, AdvancedWebView advancedWebView, ProgressBar progressBar, String str) {
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null) {
            this._f = (_r) intent.getSerializableExtra("playerInfo");
        }
        this._d = PtgAdSdk.getConfig()._r;
        this._e = PtgAdSdk.getConfig()._D;
        this._a = advancedWebView;
        this._b = progressBar;
        this._c = ptgTitleBarWeb;
        advancedWebView.loadUrl(str);
        AdvancedWebView advancedWebView2 = this._a;
        if (advancedWebView2 != null) {
            advancedWebView2.setWebViewClient(new WebManager$1(this, activity));
        }
        AdvancedWebView advancedWebView3 = this._a;
        if (advancedWebView3 == null) {
            return;
        }
        advancedWebView3.setWebChromeClient(new _oc(this, activity));
    }
}
