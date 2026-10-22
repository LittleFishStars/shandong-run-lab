package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gp implements _er {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final AtomicBoolean _b = new AtomicBoolean(false);
    public _h _c;
    public ViewGroup _d;
    public Boolean _e;
    public boolean _f;
    public PtgVideoView _g;
    public PtgVideoAdListener _h;
    public PtgNativeExpressAd.AdInteractionListener _i;
    public _b _j;
    public _c _k;
    public _d _l;
    public _e _m;
    public _gd _n;
    public _kb _o;
    public _f _p;

    @Keep
    public final class _a implements _d3._d {
        public final _gp _a;

        public _a(_gp _gpVar) {
            this._a = _gpVar;
        }

        @Override // com.kc.aw._d3._g
        public final void _a(Bitmap bitmap) {
            _h _hVar = this._a._c;
            if ((_hVar == null || _hVar._r()) ? false : true) {
                return;
            }
            _gp _gpVar = this._a;
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = _gpVar._i;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderSuccess(_gpVar._d);
            }
            if (this._a._b.get()) {
                return;
            }
            _gp _gpVar2 = this._a;
            if (_gpVar2._b(_gpVar2._d)) {
                this._a._b.set(true);
                _gp _gpVar3 = this._a;
                _gpVar3.getClass();
                _fz._a.post(new _go(_gpVar3));
            }
        }

        @Override // com.kc.aw._d3._d
        public final void _a(Exception exc) {
            String message = exc.getMessage();
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._i;
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = message;
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = message;
                adInteractionListener.onRenderFail(adErrorImpl);
            }
        }
    }

    @Keep
    public final class _b implements View.OnAttachStateChangeListener {
        public final _gp _a;

        public _b(_gp _gpVar) {
            this._a = _gpVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (this._a._b.get()) {
                return;
            }
            _gp _gpVar = this._a;
            if (_gpVar._b(_gpVar._d)) {
                this._a._b.set(true);
                _gp _gpVar2 = this._a;
                _gpVar2.getClass();
                _fz._a.post(new _go(_gpVar2));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    @Keep
    public final class _c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final ViewTreeObserver _a;
        public final _gp _b;

        public _c(_gp _gpVar, ViewTreeObserver viewTreeObserver) {
            this._b = _gpVar;
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this._b._b.get()) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gp _gpVar = this._b;
                _gpVar._e = _jx._a(_gpVar._d);
                return;
            }
            _gp _gpVar2 = this._b;
            if (_gpVar2._b(_gpVar2._d)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gp _gpVar3 = this._b;
                _gpVar3._e = _jx._a(_gpVar3._d);
                if (this._b._b.get()) {
                    return;
                }
                _gp _gpVar4 = this._b;
                if (_gpVar4._b(_gpVar4._d)) {
                    this._b._b.set(true);
                    _gp _gpVar5 = this._b;
                    _gpVar5.getClass();
                    _fz._a.post(new _go(_gpVar5));
                }
            }
        }
    }

    @Keep
    public final class _d implements ViewTreeObserver.OnScrollChangedListener {
        public long _a = 0;
        public final _gp _b;

        public _d(_gp _gpVar) {
            this._b = _gpVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052 A[PHI: r1
          0x0052: PHI (r1v6 com.kc.aw._gp) = (r1v5 com.kc.aw._gp), (r1v12 com.kc.aw._gp) binds: [B:21:0x0050, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            Boolean bool;
            _gp _gpVar;
            int windowVisibility;
            if (System.currentTimeMillis() - this._a < 200) {
                return;
            }
            this._a = System.currentTimeMillis();
            _gp _gpVar2 = this._b;
            if (_gpVar2._d != null && _gpVar2._n != null && (bool = _gpVar2._e) != null) {
                if (bool.booleanValue()) {
                    boolean globalVisibleRect = this._b._d.getGlobalVisibleRect(new Rect());
                    _gpVar = this._b;
                    if (_gpVar._f != globalVisibleRect) {
                        _gpVar._f = globalVisibleRect;
                        if (globalVisibleRect) {
                            windowVisibility = _gpVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dl) this._b._n)._a(windowVisibility);
                    }
                } else {
                    boolean zHasWindowFocus = this._b._d.hasWindowFocus();
                    _gpVar = this._b;
                    if (_gpVar._f != zHasWindowFocus) {
                        _gpVar._f = zHasWindowFocus;
                        if (zHasWindowFocus) {
                            windowVisibility = _gpVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dl) this._b._n)._a(windowVisibility);
                    }
                }
            }
            if (this._b._b.get()) {
                return;
            }
            _gp _gpVar3 = this._b;
            if (_gpVar3._b(_gpVar3._d)) {
                this._b._b.set(true);
                _gp _gpVar4 = this._b;
                _gpVar4.getClass();
                _fz._a.post(new _go(_gpVar4));
            }
        }
    }

    @Keep
    public final class _e implements ViewTreeObserver.OnWindowFocusChangeListener {
        public final _gp _a;

        public _e(_gp _gpVar) {
            this._a = _gpVar;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            if (this._a._a.get()) {
                _gp _gpVar = this._a;
                _gpVar._f = z;
                ViewGroup viewGroup = _gpVar._d;
                if (viewGroup == null || _gpVar._n == null) {
                    return;
                }
                ((_dl) this._a._n)._a(z ? viewGroup.getWindowVisibility() : 8);
            }
        }
    }

    @Keep
    public final class _f implements PtgNativeExpressAd.CustomizeVideo {
        public final _gp _a;

        public _f(_gp _gpVar) {
            this._a = _gpVar;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final String getCoverUrl() {
            _h _hVar = this._a._c;
            return _hVar != null ? _hVar._m() : "";
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final String getVideoUrl() {
            _k8 _k8Var_l;
            _h _hVar = this._a._c;
            return (_hVar == null || (_k8Var_l = _hVar._l()) == null) ? "" : _k8Var_l._a;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoComplete() {
            _gp _gpVar = this._a;
            _kb _kbVar = _gpVar._o;
            if (_kbVar != null) {
                _kbVar._a(_gpVar._c, -1L);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoError() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoPause() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoProgress(long j, long j2) {
            _gp _gpVar = this._a;
            _kb _kbVar = _gpVar._o;
            if (_kbVar != null) {
                _kbVar._a(_gpVar._c, j2);
            }
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoResume() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoStart() {
        }
    }

    @Override // com.kc.aw._er
    public final void _a() {
        try {
            PtgVideoView ptgVideoView = this._g;
            if (ptgVideoView != null) {
                ptgVideoView._a();
                this._g._b();
                this._g = null;
            }
            this._h = null;
            this._o = null;
            this._p = null;
            ViewGroup viewGroup = this._d;
            if (viewGroup != null) {
                _b _bVar = this._j;
                if (_bVar != null) {
                    try {
                        viewGroup.removeOnAttachStateChangeListener(_bVar);
                    } catch (Exception unused) {
                    }
                }
                try {
                    ViewTreeObserver viewTreeObserver = this._d.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        _c _cVar = this._k;
                        if (_cVar != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(_cVar);
                        }
                        _d _dVar = this._l;
                        if (_dVar != null) {
                            viewTreeObserver.removeOnScrollChangedListener(_dVar);
                        }
                        _e _eVar = this._m;
                        if (_eVar != null) {
                            viewTreeObserver.removeOnWindowFocusChangeListener(_eVar);
                        }
                    }
                } catch (Exception unused2) {
                }
                this._d = null;
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.kc.aw._er
    public final void _a(Context context, _h _hVar) {
        this._c = _hVar;
        PtgVideoView ptgVideoView = this._g;
        PtgVideoView ptgVideoView2 = null;
        if (ptgVideoView != null) {
            ptgVideoView._a();
            this._g._b();
            this._g = null;
        }
        if (context != null && _hVar._s()) {
            ptgVideoView2 = new PtgVideoView(context);
            ptgVideoView2._a(_hVar, 0.0f, new _gq(this));
            ptgVideoView2.setShowPlayButton(true);
            ptgVideoView2.setVideoStateListener(new _gr(this));
            ptgVideoView2.setOnCompletionListener(new _gm(this));
            ptgVideoView2.setOnErrorListener(new _gn(this));
        }
        this._g = ptgVideoView2;
    }

    @Override // com.kc.aw._er
    public final void _a(ViewGroup viewGroup) {
        this._d = viewGroup;
    }

    @Override // com.kc.aw._er
    public final void _a(_dl _dlVar) {
        this._n = _dlVar;
    }

    @Override // com.kc.aw._er
    public final void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._i = adInteractionListener;
    }

    @Override // com.kc.aw._er
    public final void _b() {
        ViewTreeObserver viewTreeObserver;
        if (this._a.get()) {
            return;
        }
        this._a.set(true);
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._a(new _a(this));
        }
        if (!this._b.get() && _b(this._d)) {
            this._b.set(true);
            _fz._a.post(new _go(this));
        }
        if (this._b.get()) {
            return;
        }
        if (this._j == null) {
            this._j = new _b(this);
        }
        this._d.removeOnAttachStateChangeListener(this._j);
        this._d.addOnAttachStateChangeListener(this._j);
        if (_b(this._d) || (viewTreeObserver = this._d.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        if (this._k == null) {
            this._k = new _c(this, viewTreeObserver);
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this._k);
        viewTreeObserver.addOnGlobalLayoutListener(this._k);
        if (this._l == null) {
            this._l = new _d(this);
        }
        viewTreeObserver.removeOnScrollChangedListener(this._l);
        viewTreeObserver.addOnScrollChangedListener(this._l);
        if (this._m == null) {
            this._m = new _e(this);
        }
        viewTreeObserver.removeOnWindowFocusChangeListener(this._m);
        viewTreeObserver.addOnWindowFocusChangeListener(this._m);
    }

    public final boolean _b(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getWindowVisibility() == 0 && _l5._a(viewGroup);
    }

    @Override // com.kc.aw._er
    public final View _c() {
        return this._g;
    }

    @Override // com.kc.aw._er
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        if (this._o == null) {
            this._o = new _kb();
        }
        if (this._p == null) {
            this._p = new _f(this);
        }
        return this._p;
    }

    @Override // com.kc.aw._er
    public final void pauseVideo() {
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._a();
        }
    }

    @Override // com.kc.aw._er
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._h = ptgVideoAdListener;
    }

    @Override // com.kc.aw._er
    public final void startVideo() {
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._c();
        }
    }
}
