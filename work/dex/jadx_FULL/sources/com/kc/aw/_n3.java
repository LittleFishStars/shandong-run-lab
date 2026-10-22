package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.aw.widget.web.AdTemplateWebView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.y6b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n3 extends _aj {
    public FrameLayout _f;
    public AdTemplateWebView _g;
    public LinearLayout _h;
    public PtgShakeView _i;
    public TextView _j;
    public AdSlot _k;
    public _h _l;
    public long _m;
    public Handler _n;
    public _n2 _o;
    public volatile boolean _p;
    public final _a _q;

    @Keep
    public final class _a implements AdTemplateWebView._a {
        public final _n3 _a;

        public _a(_n3 _n3Var) {
            this._a = _n3Var;
        }

        public final void _a() {
            _n2 _n2Var;
            this._a._p = true;
            _n3 _n3Var = this._a;
            Handler handler = _n3Var._n;
            if (handler != null && (_n2Var = _n3Var._o) != null) {
                handler.removeCallbacks(_n2Var);
                _n3Var._o = null;
            }
            _n3 _n3Var2 = this._a;
            if (_n3Var2._l != null) {
                Context context = _n3Var2.getContext();
                _n3 _n3Var3 = this._a;
                _b2._a(context, _n3Var3, _n3Var3._l, _n3Var3._f, _n3Var3._j, _n3Var3._h, _n3Var3._b);
            }
            _t _tVar = this._a._c;
            if (_tVar != null) {
                _tVar._a();
            }
        }

        public final void _a(int i, JSONObject jSONObject) {
            TextView textView;
            View view;
            if (i == 1) {
                view = this._a._f;
                if (view == null) {
                    return;
                }
            } else {
                if (i == 2) {
                    if (this._a._b != null) {
                        int iOptInt = jSONObject.optInt("time", 0);
                        _mz._d _dVar = (_mz._d) this._a._b;
                        _c._a()._a(_hj._a(_dVar._a._m), (_dVar._a._a - ((long) iOptInt)) / 1000);
                        PtgSplashAd.AdInteractionListener adInteractionListener = _dVar._a._i;
                        if (adInteractionListener != null) {
                            adInteractionListener.onAdSkip();
                        }
                        PtgSplashAd.AdInteractionListener adInteractionListener2 = _dVar._a._i;
                        if (adInteractionListener2 != null) {
                            adInteractionListener2.onDismiss(1);
                        }
                        _dVar._a._a();
                        return;
                    }
                    return;
                }
                if (i != 3 || (textView = this._a._j) == null) {
                    return;
                }
                Object tag = textView.getTag(R.id.aw_native_view_tag);
                if (tag instanceof _nl) {
                    _nl _nlVar = (_nl) tag;
                    _nlVar._i = jSONObject.optInt("ux");
                    _nlVar._j = jSONObject.optInt("uy");
                    _nlVar._g = jSONObject.optInt("dx");
                    _nlVar._h = jSONObject.optInt("dy");
                }
                view = this._a._j;
            }
            view.performClick();
        }

        public final void _b() {
            _j _jVar = this._a._b;
            if (_jVar != null) {
                _mz._d _dVar = (_mz._d) _jVar;
                _c._a()._a(_hj._a(_dVar._a._m), _dVar._a._a / 1000);
                PtgSplashAd.AdInteractionListener adInteractionListener = _dVar._a._i;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdTimeOver();
                }
                PtgSplashAd.AdInteractionListener adInteractionListener2 = _dVar._a._i;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onDismiss(2);
                }
                _dVar._a._a();
            }
        }
    }

    public _n3(Context context) {
        super(context);
        this._m = 5000L;
        this._p = false;
        this._q = new _a(this);
    }

    @Override // com.kc.aw._aj
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_splash_webview_layout, (ViewGroup) null);
        this._a = viewInflate;
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgAdvertLayout);
        this._g = (AdTemplateWebView) this._a.findViewById(R.id.adTemplateWebView);
        this._j = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._h = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._i = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _df._a(this._j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this._a, layoutParams);
        setGravity(17);
        this._n = new Handler(Looper.getMainLooper());
    }

    @Override // com.kc.aw._aj
    public final void _c() {
        _n2 _n2Var;
        super._c();
        Handler handler = this._n;
        if (handler != null && (_n2Var = this._o) != null) {
            handler.removeCallbacks(_n2Var);
            this._o = null;
        }
        this._n = null;
        AdTemplateWebView adTemplateWebView = this._g;
        if (adTemplateWebView != null) {
            adTemplateWebView.post(new _1(adTemplateWebView));
            this._g.destroy();
            this._g = null;
        }
        PtgShakeView ptgShakeView = this._i;
        if (ptgShakeView != null) {
            ImageView imageView = ptgShakeView._a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            _lz _lzVar = ptgShakeView._d;
            if (_lzVar != null) {
                _lzVar.cancel();
                ptgShakeView._d = null;
            }
        }
        this._l = null;
        this._k = null;
    }

    @Override // com.kc.aw._aj
    public void setAd(_h _hVar) {
        String str;
        AdSlot adSlot;
        this._l = _hVar;
        if (TextUtil.isEmpty(_hVar._K)) {
            _t _tVar = this._c;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, new Exception("WebSource为空"));
                return;
            }
            return;
        }
        this._m = _ib._a(_hVar, this._k);
        String strReplace = _hVar._K;
        String strReplace2 = "";
        if (TextUtil.isEmpty(strReplace) || (adSlot = this._k) == null) {
            str = strReplace2;
        } else {
            float screenWidth = adSlot.getExpressViewAcceptedWidth() <= 0.0f ? ScreenUtils.getScreenWidth(getContext()) : ScreenUtils.dp2px(this._k.getExpressViewAcceptedWidth());
            float screenHeight = this._k.getExpressViewAcceptedHeight() <= 0.0f ? ScreenUtils.getScreenHeight(getContext()) : ScreenUtils.dp2px(this._k.getExpressViewAcceptedHeight());
            boolean zIsCountdownVisibility = this._k.isCountdownVisibility();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", screenWidth);
                jSONObject.put("height", screenHeight);
                strReplace = strReplace.replace("__E__", jSONObject.toString());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("time", this._m / 1000);
                jSONObject2.put("count_visible", zIsCountdownVisibility ? 1 : 2);
                _i6 _i6Var = _hVar._z;
                jSONObject2.put("source", _i6Var != null ? _i6Var._d : "");
                jSONObject2.put("title", _hVar._k());
                jSONObject2.put("desc", _hVar._e());
                jSONObject2.put("logo", _hVar._i());
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("img", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("w", _hVar._n());
                jSONObject3.put(y6b.g, _hVar._g());
                jSONObject3.put("url", _hVar._f() != null ? _hVar._f()._a : "");
                jSONArray.put(jSONObject3);
                strReplace2 = strReplace.replace("__C__", jSONObject2.toString());
                str = strReplace2;
            } catch (JSONException unused) {
                str = strReplace;
            }
        }
        int iMax = Math.max(Math.min(_hVar._j, 5000), 1000);
        Handler handler = this._n;
        if (handler != null) {
            _n2 _n2Var = this._o;
            if (_n2Var != null) {
                handler.removeCallbacks(_n2Var);
                this._o = null;
            }
            _n2 _n2Var2 = new _n2(this);
            this._o = _n2Var2;
            this._n.postDelayed(_n2Var2, iMax);
        }
        System.currentTimeMillis();
        AdTemplateWebView adTemplateWebView = this._g;
        adTemplateWebView._a = this._q;
        adTemplateWebView.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }

    public void setAdSlot(AdSlot adSlot) {
        this._k = adSlot;
    }
}
