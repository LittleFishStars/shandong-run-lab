package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kc.aw.component.widgets.PtgLogoView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.widget.PtgRoundLinearLayout;
import com.kc.aw.widget.web.AdTemplateWebView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mz extends RelativeLayout implements _hd<String> {
    public long _a;
    public long _b;
    public _aj _c;
    public PtgLogoView _d;
    public TextView _e;
    public FrameLayout _f;
    public PtgRoundLinearLayout _g;
    public PtgAdNative.SplashAdListener _h;
    public PtgSplashAd.AdInteractionListener _i;
    public PtgVideoAdListener _j;
    public PtgAppDownloadListener _k;
    public String _l;
    public _h _m;
    public AdSlot _n;
    public boolean _o;
    public boolean _p;
    public volatile boolean _q;
    public volatile boolean _r;
    public volatile boolean _s;
    public _bw _t;
    public final _b _u;
    public final _c _v;
    public final _d _w;

    @Keep
    public final class _a implements View.OnClickListener {
        public final _mz _a;

        public _a(_mz _mzVar) {
            this._a = _mzVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.kc.aw.lib.utils._a._c()) {
                return;
            }
            _mz _mzVar = this._a;
            com.kc.aw._c._a()._a(_hj._a(this._a._m), (_mzVar._a - _mzVar._b) / 1000);
            PtgSplashAd.AdInteractionListener adInteractionListener = this._a._i;
            if (adInteractionListener != null) {
                adInteractionListener.onAdSkip();
            }
            PtgSplashAd.AdInteractionListener adInteractionListener2 = this._a._i;
            if (adInteractionListener2 != null) {
                adInteractionListener2.onDismiss(1);
            }
            this._a._a();
        }
    }

    @Keep
    public final class _b implements _t {
        public final _mz _a;

        public _b(_mz _mzVar) {
            this._a = _mzVar;
        }

        @Override // com.kc.aw._t
        public final void _a() {
            _mz _mzVar = this._a;
            _h _hVar = _mzVar._m;
            if (_hVar != null) {
                _hVar._H = true;
            }
            if (_mzVar._i != null && !_mzVar._r) {
                this._a._i.onRenderSuccess();
            }
            this._a._r = true;
            this._a._c();
        }

        @Override // com.kc.aw._t
        public final void _a(View view, int i, Exception exc) {
            _mz _mzVar = this._a;
            FrameLayout frameLayout = _mzVar._f;
            if (frameLayout != null) {
                frameLayout.setVisibility(_mzVar._o ? 0 : 8);
            }
            PtgSplashAd.AdInteractionListener adInteractionListener = this._a._i;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderError(new AdErrorImpl(i, exc.getMessage(), (Object) null));
            }
        }
    }

    @Keep
    public final class _c implements PtgVideoAdListener {
        public final _mz _a;

        public _c(_mz _mzVar) {
            this._a = _mzVar;
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoComplete() {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoComplete();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoError(int i, String str) {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoError(i, str);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoPause() {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoPause();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoProgressUpdate(long j, long j2) {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoProgressUpdate(j, j2);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoResume() {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoResume();
            }
        }

        @Override // com.kc.aw.lib.interf.PtgVideoAdListener
        public final void onVideoStart() {
            PtgVideoAdListener ptgVideoAdListener = this._a._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoStart();
            }
        }
    }

    @Keep
    public final class _d implements _j {
        public final _mz _a;

        public _d(_mz _mzVar) {
            this._a = _mzVar;
        }
    }

    @Keep
    public final class _e implements Runnable {
        public final _mz _a;

        public _e(_mz _mzVar) {
            this._a = _mzVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _mz _mzVar = this._a;
            _m1._a(_mzVar, _mzVar._m);
            PtgSplashAd.AdInteractionListener adInteractionListener = this._a._i;
            if (adInteractionListener != null) {
                adInteractionListener.onAdShow();
            }
        }
    }

    public _mz(Context context) {
        super(context);
        this._a = 5000L;
        this._b = 5000L;
        this._o = true;
        this._p = false;
        this._u = new _b(this);
        this._v = new _c(this);
        this._w = new _d(this);
        _b();
    }

    public final void _a() {
        _aj _ajVar = this._c;
        if (_ajVar != null) {
            _ajVar._c();
        }
        _bw _bwVar = this._t;
        if (_bwVar != null && this._o) {
            if (_bwVar._c) {
                _bwVar._c = false;
                _bwVar._d.removeMessages(1);
            }
            this._t._d.removeMessages(1);
        }
        _fr _frVar = _fr._b;
        _frVar.getClass();
        if (!TextUtil.isEmpty("splashAdDismiss")) {
            CopyOnWriteArrayList<_hd<String>> copyOnWriteArrayList = _frVar._a.get("splashAdDismiss");
            if (!TextUtil.isEmpty(copyOnWriteArrayList)) {
                copyOnWriteArrayList.remove(this);
            }
        }
        try {
            _mg._a(this._l);
        } catch (Exception unused) {
        }
        if (this._h != null) {
            this._h = null;
        }
        if (this._i != null) {
            this._i = null;
        }
        if (this._j != null) {
            this._j = null;
        }
        if (this._k != null) {
            this._k = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    public final void _a(_h _hVar, ViewGroup viewGroup, Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        _b _bVar;
        Exception exc;
        Context context;
        if (viewGroup == null) {
            return;
        }
        this._m = _hVar;
        if (_hVar == null) {
            _bVar = this._u;
            if (_bVar != null) {
                exc = new Exception("ad is null.");
                _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
            }
            layoutParams = null;
        } else {
            this._l = String.valueOf(_hVar.hashCode());
            if (this._n == null) {
                _bVar = this._u;
                if (_bVar != null) {
                    exc = new Exception("adSlot is null.");
                    _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                }
                layoutParams = null;
            } else {
                layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    _bVar = this._u;
                    if (_bVar != null) {
                        exc = new Exception("layoutParams is null.");
                        _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                    }
                    layoutParams = null;
                } else {
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 == null) {
                        _bVar = this._u;
                        if (_bVar != null) {
                            exc = new Exception("container layoutParams is null.");
                            _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                        }
                    } else {
                        try {
                            int i = layoutParams2.width;
                            if (i == 0) {
                                layoutParams.width = -1;
                            } else {
                                layoutParams.width = i;
                            }
                            int i2 = layoutParams2.height;
                            if (i2 == 0) {
                                layoutParams.height = -1;
                            } else {
                                layoutParams.height = i2;
                            }
                        } catch (Exception e) {
                            _b _bVar2 = this._u;
                            if (_bVar2 != null) {
                                _bVar2._a(this, PtgErrorCode.SDK_RENDER_ERROR, e);
                            }
                            layoutParams = null;
                        }
                    }
                    layoutParams = null;
                }
            }
        }
        if (layoutParams == null) {
            return;
        }
        setLayoutParams(layoutParams);
        if (viewGroup.getContext() instanceof Activity) {
            context = activity;
            context = viewGroup.getContext();
        } else if (activity == null) {
            if (getContext() instanceof Activity) {
                context = getContext();
            } else {
                context = activity;
                context = viewGroup.getContext();
            }
        }
        if (_hVar._s()) {
            _mu _muVar = new _mu(context);
            this._c = _muVar;
            _muVar.setVideoAdListener(this._v);
        } else if (TextUtil.isNotEmpty(_hVar._K)) {
            this._p = true;
            _n3 _n3Var = new _n3(context);
            this._c = _n3Var;
            _n3Var.setAdSlot(this._n);
        } else {
            this._c = new _mt(context);
        }
        if (!this._p) {
            FrameLayout frameLayout = this._f;
            if (frameLayout != null) {
                frameLayout.setVisibility(this._o ? 0 : 8);
            }
            long j_a = _ib._a(_hVar, this._n);
            if (this._o) {
                this._a = j_a;
                this._b = j_a;
                this._t = new _bw(j_a, new _n0(this));
            }
        }
        this._c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this._c.setAdClickListener(this._w);
        this._c.setAdRenderListener(this._u);
        this._c.setAd(_hVar);
        addView(this._c, 0);
    }

    @Override // com.kc.aw._hd
    public final void _a(String str) {
        if (this._i == null || !TextUtil.isNotEmpty(str)) {
            return;
        }
        this._i.onDismiss(Integer.parseInt(str));
    }

    public final void _b() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View viewInflate = View.inflate(getContext(), R.layout.aw_splash_view, this);
        this._d = (PtgLogoView) viewInflate.findViewById(R.id.ptg_ad_logo);
        this._g = (PtgRoundLinearLayout) viewInflate.findViewById(R.id.ptgSkipLayout);
        this._e = (TextView) viewInflate.findViewById(R.id.ptgSplashSec);
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgSplashSkipFl);
        this._g.setOnClickListener(new _a(this));
    }

    public final void _c() {
        _bw _bwVar;
        AdTemplateWebView adTemplateWebView;
        if (this._q && this._r && !this._s) {
            this._s = true;
            PtgLogoView ptgLogoView = this._d;
            if (ptgLogoView != null) {
                ptgLogoView.setVisibility(0);
            }
            if (this._p) {
                _aj _ajVar = this._c;
                if ((_ajVar instanceof _n3) && (adTemplateWebView = ((_n3) _ajVar)._g) != null) {
                    adTemplateWebView.post(new _2(adTemplateWebView));
                }
            } else if (this._c != null && (_bwVar = this._t) != null && this._o && !_bwVar._c && _bwVar._b == _bwVar._a) {
                _bwVar._c = true;
                _bwVar._d.sendEmptyMessage(1);
            }
            _fr _frVar = _fr._b;
            _frVar.getClass();
            if (!TextUtil.isEmpty("splashAdDismiss")) {
                CopyOnWriteArrayList<_hd<String>> copyOnWriteArrayList = _frVar._a.get("splashAdDismiss");
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    _frVar._a.put("splashAdDismiss", copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(this);
            }
            _fz._a.post(new _e(this));
        }
    }

    public PtgSplashAd.AdInteractionListener getAdInteractionListener() {
        return this._i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._q = true;
        _c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._q = false;
        _bw _bwVar = this._t;
        if (_bwVar != null && this._o) {
            if (_bwVar._c) {
                _bwVar._c = false;
                _bwVar._d.removeMessages(1);
            }
            this._t._d.removeMessages(1);
        }
        _fr _frVar = _fr._b;
        _frVar.getClass();
        if (TextUtil.isEmpty("splashAdDismiss")) {
            return;
        }
        CopyOnWriteArrayList<_hd<String>> copyOnWriteArrayList = _frVar._a.get("splashAdDismiss");
        if (TextUtil.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        copyOnWriteArrayList.remove(this);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        _bw._a _aVar;
        AdTemplateWebView adTemplateWebView;
        Runnable _1;
        super.onWindowFocusChanged(z);
        if (this._p) {
            _aj _ajVar = this._c;
            if (_ajVar instanceof _n3) {
                _n3 _n3Var = (_n3) _ajVar;
                if (z) {
                    adTemplateWebView = _n3Var._g;
                    if (adTemplateWebView == null) {
                        return;
                    } else {
                        _1 = new _2(adTemplateWebView);
                    }
                } else {
                    adTemplateWebView = _n3Var._g;
                    if (adTemplateWebView == null) {
                        return;
                    } else {
                        _1 = new _1(adTemplateWebView);
                    }
                }
                adTemplateWebView.post(_1);
                return;
            }
            return;
        }
        _bw _bwVar = this._t;
        if (_bwVar == null || !this._o) {
            return;
        }
        if (!z) {
            if (_bwVar._c) {
                _bwVar._c = false;
                _bwVar._d.removeMessages(1);
                return;
            }
            return;
        }
        long j = _bwVar._b;
        if (j > 0 && !_bwVar._c) {
            _bwVar._c = true;
            _bwVar._d.sendEmptyMessage(1);
        } else {
            if (j != 0 || _bwVar._c || (_aVar = _bwVar._e) == null) {
                return;
            }
            ((_n0) _aVar)._a();
        }
    }

    public void setAdInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._i = adInteractionListener;
    }

    public void setAdListener(PtgAdNative.SplashAdListener splashAdListener) {
        this._h = splashAdListener;
    }

    public void setAdSlot(AdSlot adSlot) {
        this._n = adSlot;
        this._o = adSlot != null ? adSlot.isCountdownVisibility() : true;
    }

    public void setAdvertInfo(_h _hVar) {
        this._m = _hVar;
    }

    public void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._k = ptgAppDownloadListener;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._j = ptgVideoAdListener;
    }
}
