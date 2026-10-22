package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdSlot;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dp extends _gg {
    public _am _G;
    public volatile boolean _H;
    public volatile boolean _I;
    public volatile boolean _J;
    public volatile boolean _K;
    public _b _L;
    public _c _M;
    public final _a _N;

    @Keep
    public final class _a implements _j6 {
        public final _dp _a;

        public _a(_dp _dpVar) {
            this._a = _dpVar;
        }
    }

    @Keep
    public final class _b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final ViewTreeObserver _a;
        public final _dp _b;

        public _b(_dp _dpVar, ViewTreeObserver viewTreeObserver) {
            this._b = _dpVar;
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this._b._K) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                this._a.removeOnGlobalLayoutListener(this);
                return;
            }
            _dp _dpVar = this._b;
            if (_dpVar.getWindowVisibility() == 0 && _l5._a(_dpVar)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _dp _dpVar2 = this._b;
                _dpVar2._K = true;
                _fz._a.post(new _dq(_dpVar2));
            }
        }
    }

    @Keep
    public final class _c implements ViewTreeObserver.OnScrollChangedListener {
        public final ViewTreeObserver _a;
        public final _dp _b;

        public _c(_dp _dpVar, ViewTreeObserver viewTreeObserver) {
            this._b = _dpVar;
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (this._b._K) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                this._a.removeOnScrollChangedListener(this);
                return;
            }
            _dp _dpVar = this._b;
            if (_dpVar.getWindowVisibility() == 0 && _l5._a(_dpVar)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnScrollChangedListener(this);
                }
                _dp _dpVar2 = this._b;
                _dpVar2._K = true;
                _fz._a.post(new _dq(_dpVar2));
            }
        }
    }

    public _dp(Context context) {
        super(context);
        this._N = new _a(this);
    }

    @Override // com.kc.aw._gg
    public final void _a(View view, int i, _nk _nkVar) {
        AdSlot adSlot;
        if (com.kc.aw.lib.utils._a._c() || (adSlot = this._d) == null || this._c == null || view == null) {
            return;
        }
        this._g = false;
        this._h = false;
        this._j = false;
        this._l = false;
        this._m = false;
        this._n = false;
        adSlot.setCt(i);
        _h _hVar = this._c;
        _hVar._t = _nkVar;
        boolean z_p = _hVar._p();
        _h _hVar2 = this._c;
        if (z_p) {
            i = 0;
        }
        _m2 _m2Var = _m1._a;
        if (_m2Var != null) {
            _m2Var._a(view, _hVar2, i);
        }
        _b2._a(view.getContext(), this._c, this._d);
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kc.aw._gg
    public final void _b(View view, int i, _nk _nkVar) {
        super._b(view, i, _nkVar);
        _a(view, i, _nkVar);
        _am _amVar = this._G;
        if (_amVar != null) {
            _m1._a(this, _amVar.getAdRootView(), null);
        }
    }

    @Override // com.kc.aw._gg
    public final void _d() {
        setBackgroundColor(-1);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View.inflate(getContext(), R.layout.aw_feed_view, this);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new _do(this));
    }

    public final void _e() {
        PtgVideoView ptgVideoView;
        _ge _geVar;
        _gg._a _aVar;
        Handler handler = this._v;
        if (handler != null && (_aVar = this._w) != null) {
            handler.removeCallbacks(_aVar);
        }
        String str = this._e;
        ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.remove(str);
        }
        _mg._a(this._e);
        try {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive() && (_geVar = this._q) != null) {
                viewTreeObserver.removeOnScrollChangedListener(_geVar);
            }
        } catch (Exception unused) {
        }
        if (this._a != null) {
            this._a = null;
        }
        if (this._b != null) {
            this._b = null;
        }
        _am _amVar = this._G;
        if (_amVar != null && (ptgVideoView = _amVar._j) != null) {
            ptgVideoView._b();
            _amVar._j.setOnErrorListener(null);
            _amVar._j = null;
        }
        this._b = null;
        try {
            ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                _b _bVar = this._L;
                if (_bVar != null) {
                    viewTreeObserver2.removeOnGlobalLayoutListener(_bVar);
                }
                _c _cVar = this._M;
                if (_cVar != null) {
                    viewTreeObserver2.removeOnScrollChangedListener(_cVar);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public final void _f() {
        if (this._H && this._I && this._J && !this._K) {
            if (getWindowVisibility() == 0 && _l5._a(this)) {
                this._K = true;
                _fz._a.post(new _dq(this));
                return;
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return;
            }
            if (this._L == null) {
                this._L = new _b(this, viewTreeObserver);
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this._L);
            viewTreeObserver.addOnGlobalLayoutListener(this._L);
            if (this._M == null) {
                this._M = new _c(this, viewTreeObserver);
            }
            viewTreeObserver.removeOnScrollChangedListener(this._M);
            viewTreeObserver.addOnScrollChangedListener(this._M);
        }
    }

    @Override // com.kc.aw._gg
    public List<View> getAdvertViews() {
        ViewGroup adRootView;
        _am _amVar = this._G;
        if (_amVar == null || (adRootView = _amVar.getAdRootView()) == null) {
            return null;
        }
        return Collections.singletonList(adRootView);
    }

    @Override // com.kc.aw._gg
    public View getShakeLayout() {
        _am _amVar = this._G;
        if (_amVar != null) {
            return _amVar.getShakeLayout();
        }
        return null;
    }

    @Override // com.kc.aw._gg, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._I = true;
        _f();
    }

    @Override // com.kc.aw._gg, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._I = false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        _am _amVar;
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 || i2 == i4 || (_amVar = this._G) == null) {
            return;
        }
        _amVar._a(i);
    }

    @Override // com.kc.aw._gg
    public void setAdvertInfo(_h _hVar) {
        super.setAdvertInfo(_hVar);
    }

    public void setExpressViewColor(String str) {
        _am _amVar = this._G;
        if (_amVar == null || !(_amVar instanceof _ab)) {
            return;
        }
        ((_ab) _amVar).setAdvertColor(str);
    }

    @Override // com.kc.aw._gg
    public void setOnTouchAction(_nl _nlVar) {
        View cView;
        super.setOnTouchAction(_nlVar);
        if (_nlVar == null || (cView = getCView()) == null) {
            return;
        }
        cView.setTag(R.id.aw_native_view_tag, _nlVar);
    }
}
