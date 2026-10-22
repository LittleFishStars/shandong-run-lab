package com.kc.aw;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gl implements _er {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final AtomicBoolean _b = new AtomicBoolean(false);
    public _h _c;
    public ViewGroup _d;
    public Boolean _e;
    public boolean _f;
    public PtgNativeExpressAd.AdInteractionListener _g;
    public _a _h;
    public _b _i;
    public _c _j;
    public _d _k;
    public _gd _l;

    @Keep
    public final class _a implements View.OnAttachStateChangeListener {
        public final _gl _a;

        public _a(_gl _glVar) {
            this._a = _glVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (this._a._b.get()) {
                return;
            }
            _gl _glVar = this._a;
            if (_glVar._b(_glVar._d)) {
                this._a._b.set(true);
                _gl _glVar2 = this._a;
                _glVar2.getClass();
                _fz._a.post(new _gk(_glVar2));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    @Keep
    public final class _b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final ViewTreeObserver _a;
        public final _gl _b;

        public _b(_gl _glVar, ViewTreeObserver viewTreeObserver) {
            this._b = _glVar;
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this._b._b.get()) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gl _glVar = this._b;
                _glVar._e = _jx._a(_glVar._d);
                return;
            }
            _gl _glVar2 = this._b;
            if (_glVar2._b(_glVar2._d)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gl _glVar3 = this._b;
                _glVar3._e = _jx._a(_glVar3._d);
                if (this._b._b.get()) {
                    return;
                }
                _gl _glVar4 = this._b;
                if (_glVar4._b(_glVar4._d)) {
                    this._b._b.set(true);
                    _gl _glVar5 = this._b;
                    _glVar5.getClass();
                    _fz._a.post(new _gk(_glVar5));
                }
            }
        }
    }

    @Keep
    public final class _c implements ViewTreeObserver.OnScrollChangedListener {
        public long _a = 0;
        public final _gl _b;

        public _c(_gl _glVar) {
            this._b = _glVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052 A[PHI: r1
          0x0052: PHI (r1v6 com.kc.aw._gl) = (r1v5 com.kc.aw._gl), (r1v12 com.kc.aw._gl) binds: [B:21:0x0050, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            Boolean bool;
            _gl _glVar;
            int windowVisibility;
            if (System.currentTimeMillis() - this._a < 200) {
                return;
            }
            this._a = System.currentTimeMillis();
            _gl _glVar2 = this._b;
            if (_glVar2._d != null && _glVar2._l != null && (bool = _glVar2._e) != null) {
                if (bool.booleanValue()) {
                    boolean globalVisibleRect = this._b._d.getGlobalVisibleRect(new Rect());
                    _glVar = this._b;
                    if (_glVar._f != globalVisibleRect) {
                        _glVar._f = globalVisibleRect;
                        if (globalVisibleRect) {
                            windowVisibility = _glVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dl) this._b._l)._a(windowVisibility);
                    }
                } else {
                    boolean zHasWindowFocus = this._b._d.hasWindowFocus();
                    _glVar = this._b;
                    if (_glVar._f != zHasWindowFocus) {
                        _glVar._f = zHasWindowFocus;
                        if (zHasWindowFocus) {
                            windowVisibility = _glVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dl) this._b._l)._a(windowVisibility);
                    }
                }
            }
            if (this._b._b.get()) {
                return;
            }
            _gl _glVar3 = this._b;
            if (_glVar3._b(_glVar3._d)) {
                this._b._b.set(true);
                _gl _glVar4 = this._b;
                _glVar4.getClass();
                _fz._a.post(new _gk(_glVar4));
            }
        }
    }

    @Keep
    public final class _d implements ViewTreeObserver.OnWindowFocusChangeListener {
        public final _gl _a;

        public _d(_gl _glVar) {
            this._a = _glVar;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            if (this._a._a.get()) {
                _gl _glVar = this._a;
                _glVar._f = z;
                ViewGroup viewGroup = _glVar._d;
                if (viewGroup == null || _glVar._l == null) {
                    return;
                }
                ((_dl) this._a._l)._a(z ? viewGroup.getWindowVisibility() : 8);
            }
        }
    }

    @Override // com.kc.aw._er
    public final void _a() {
        try {
            ViewGroup viewGroup = this._d;
            if (viewGroup != null) {
                _a _aVar = this._h;
                if (_aVar != null) {
                    try {
                        viewGroup.removeOnAttachStateChangeListener(_aVar);
                    } catch (Exception unused) {
                    }
                }
                try {
                    ViewTreeObserver viewTreeObserver = this._d.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        _b _bVar = this._i;
                        if (_bVar != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(_bVar);
                        }
                        _c _cVar = this._j;
                        if (_cVar != null) {
                            viewTreeObserver.removeOnScrollChangedListener(_cVar);
                        }
                        _d _dVar = this._k;
                        if (_dVar != null) {
                            viewTreeObserver.removeOnWindowFocusChangeListener(_dVar);
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
    }

    @Override // com.kc.aw._er
    public final void _a(ViewGroup viewGroup) {
        this._d = viewGroup;
    }

    @Override // com.kc.aw._er
    public final void _a(_dl _dlVar) {
        this._l = _dlVar;
    }

    @Override // com.kc.aw._er
    public final void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._g = adInteractionListener;
    }

    @Override // com.kc.aw._er
    public final void _b() {
        ViewTreeObserver viewTreeObserver;
        _h _hVar = this._c;
        if ((_hVar == null || _hVar._r()) ? false : true) {
            return;
        }
        if (!this._a.get()) {
            this._a.set(true);
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._g;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderSuccess(this._d);
            }
        }
        if (!this._b.get() && _b(this._d)) {
            this._b.set(true);
            _fz._a.post(new _gk(this));
        }
        if (this._b.get()) {
            return;
        }
        if (this._h == null) {
            this._h = new _a(this);
        }
        this._d.removeOnAttachStateChangeListener(this._h);
        this._d.addOnAttachStateChangeListener(this._h);
        if (_b(this._d) || (viewTreeObserver = this._d.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        if (this._i == null) {
            this._i = new _b(this, viewTreeObserver);
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this._i);
        viewTreeObserver.addOnGlobalLayoutListener(this._i);
        if (this._j == null) {
            this._j = new _c(this);
        }
        viewTreeObserver.removeOnScrollChangedListener(this._j);
        viewTreeObserver.addOnScrollChangedListener(this._j);
        if (this._k == null) {
            this._k = new _d(this);
        }
        viewTreeObserver.removeOnWindowFocusChangeListener(this._k);
        viewTreeObserver.addOnWindowFocusChangeListener(this._k);
    }

    public final boolean _b(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getWindowVisibility() == 0 && _l5._a(viewGroup);
    }

    @Override // com.kc.aw._er
    public final View _c() {
        return null;
    }

    @Override // com.kc.aw._er
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        return null;
    }

    @Override // com.kc.aw._er
    public final void pauseVideo() {
    }

    @Override // com.kc.aw._er
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
    }

    @Override // com.kc.aw._er
    public final void startVideo() {
    }
}
