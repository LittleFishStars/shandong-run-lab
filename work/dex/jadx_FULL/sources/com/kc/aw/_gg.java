package com.kc.aw;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _gg extends FrameLayout {
    public float _A;
    public _nl _B;
    public final _c _C;
    public final _d _D;
    public final _e _E;
    public final _f _F;
    public PtgNativeExpressAd.AdInteractionListener _a;
    public PtgVideoAdListener _b;
    public _h _c;
    public AdSlot _d;
    public String _e;
    public _k _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public int _k;
    public boolean _l;
    public boolean _m;
    public boolean _n;
    public final AtomicBoolean _o;
    public long _p;
    public _ge _q;
    public boolean _r;
    public final AtomicBoolean _s;
    public final AtomicBoolean _t;
    public final AtomicBoolean _u;
    public final Handler _v;
    public final _a _w;
    public final AtomicBoolean _x;
    public final AtomicBoolean _y;
    public float _z;

    @Keep
    public final class _a implements Runnable {
        public final _gg _a;

        public _a(_dp _dpVar) {
            this._a = _dpVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            if (this._a._a(true)) {
                this._a._u.set(true);
                List<View> advertViews = this._a.getAdvertViews();
                if (advertViews == null || advertViews.isEmpty() || (view = advertViews.get(0)) == null || !view.hasWindowFocus()) {
                    return;
                }
                _o6._a(view, 6);
            }
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final _gg _a;

        public _b(_gg _ggVar) {
            this._a = _ggVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _gg _ggVar = this._a;
            _ggVar._b(_ggVar.getCView(), 2, null);
        }
    }

    @Keep
    public final class _c implements MediaPlayer.OnCompletionListener {
        public final _gg _a;

        public _c(_dp _dpVar) {
            this._a = _dpVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoComplete();
            }
        }
    }

    @Keep
    public final class _d implements NiceVideoPlayer._b {
        public final _gg _a;

        public _d(_dp _dpVar) {
            this._a = _dpVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener == null) {
                return false;
            }
            ptgVideoAdListener.onVideoError(i, String.valueOf(i2));
            return false;
        }

        @Override // com.kc.aw.component.videoplayer.NiceVideoPlayer._b
        public final void onTimeout() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERR, "Video Play Timeout!");
            }
        }
    }

    @Keep
    public final class _e implements _k9._b {
        public final _gg _a;

        public _e(_dp _dpVar) {
            this._a = _dpVar;
        }

        @Override // com.kc.aw._k9._b
        public final void _a(long j, long j2) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoProgressUpdate(j, j2);
            }
        }
    }

    @Keep
    public final class _f implements _kc {
        public final _gg _a;

        public _f(_dp _dpVar) {
            this._a = _dpVar;
        }

        @Override // com.kc.aw._kc
        public final void onVideoPause() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoPause();
            }
        }

        @Override // com.kc.aw._kc
        public final void onVideoResume() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoResume();
            }
        }

        @Override // com.kc.aw._kc
        public final void onVideoStart() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoStart();
            }
        }
    }

    public _gg(Context context) {
        super(context);
        this._o = new AtomicBoolean(false);
        this._s = new AtomicBoolean(true);
        this._t = new AtomicBoolean();
        this._u = new AtomicBoolean(false);
        this._v = new Handler(Looper.getMainLooper());
        _dp _dpVar = (_dp) this;
        this._w = new _a(_dpVar);
        this._x = new AtomicBoolean();
        this._y = new AtomicBoolean(false);
        this._C = new _c(_dpVar);
        this._D = new _d(_dpVar);
        this._E = new _e(_dpVar);
        this._F = new _f(_dpVar);
        _d();
    }

    private View getRealRootView() {
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    public final void _a() {
        _h _hVar;
        boolean z;
        View shakeLayout;
        View realRootView;
        List<Integer> list;
        this._p = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
        if ((!concurrentHashMap.isEmpty()) || (_hVar = this._c) == null) {
            return;
        }
        _k _kVar = _hVar._q;
        this._f = _kVar;
        if (_kVar == null) {
            return;
        }
        String str = this._e;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        boolean z_c = this._f._c();
        this._g = z_c;
        _k _kVar2 = this._f;
        int i = _kVar2._a;
        this._i = i == 1 || i == 2;
        this._h = _kVar2._b(z_c);
        this._j = this._f._c(this._g);
        _k _kVar3 = this._f;
        this._k = _kVar3._j;
        this._l = this._g && (list = _kVar3._g) != null && list.contains(3);
        _k _kVar4 = this._f;
        if (this._g) {
            List<Integer> list2 = _kVar4._g;
            if (list2 != null && list2.contains(4)) {
                z = true;
            }
            this._m = z;
            this._n = this._f._d(this._g);
            if (_a(true)) {
                _a(this._f, false);
            } else if (1 == this._k) {
                _a(this._f, true);
            } else {
                long j_a = this._f._a();
                this._v.removeCallbacks(this._w);
                this._v.postDelayed(this._w, j_a);
            }
            if ((this._t.get() && this._n && _ib._a(this._e)) && (realRootView = getRealRootView()) != null) {
                realRootView.setOnClickListener(new _gf((_dp) this));
            }
            shakeLayout = getShakeLayout();
            if (shakeLayout != null) {
                shakeLayout.setVisibility(this._i ? 0 : 8);
            }
        }
        _kVar4.getClass();
        z = false;
        this._m = z;
        this._n = this._f._d(this._g);
        if (_a(true)) {
            _a(this._f, false);
        } else if (1 == this._k) {
            _a(this._f, true);
        } else {
            long j_a2 = this._f._a();
            this._v.removeCallbacks(this._w);
            this._v.postDelayed(this._w, j_a2);
        }
        if (this._t.get() && this._n && _ib._a(this._e)) {
            realRootView.setOnClickListener(new _gf((_dp) this));
        }
        shakeLayout = getShakeLayout();
        if (shakeLayout != null) {
            shakeLayout.setVisibility(this._i ? 0 : 8);
        }
    }

    public final void _a(int i) {
        try {
            View shakeLayout = getShakeLayout();
            if (shakeLayout != null) {
                shakeLayout.setVisibility(this._i ? 0 : 8);
            }
            if (this._s.get()) {
                this._s.set(false);
                return;
            }
            if (i != 0) {
                String str = this._e;
                ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
                if (!TextUtils.isEmpty(str)) {
                    concurrentHashMap.remove(str);
                }
                _mg._a(this._e);
                return;
            }
            if (_a(false) || _b(false)) {
                ConcurrentHashMap<String, Long> concurrentHashMap2 = _ib._a;
                if (!(!concurrentHashMap2.isEmpty())) {
                    String str2 = this._e;
                    if (!TextUtils.isEmpty(str2)) {
                        concurrentHashMap2.put(str2, Long.valueOf(System.currentTimeMillis()));
                    }
                }
            }
            if (!_a(true)) {
                _a(this._f, false);
            } else if (1 == this._k) {
                _a(this._f, true);
            }
        } catch (Exception unused) {
        }
    }

    public void _a(View view, int i, _nk _nkVar) {
    }

    public final void _a(_k _kVar, boolean z) {
        _mf _mfVar_a;
        Context context;
        _gh _ghVar;
        if (_b(true)) {
            try {
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    if (this._q == null) {
                        this._q = new _ge(this);
                    }
                    viewTreeObserver.removeOnScrollChangedListener(this._q);
                    viewTreeObserver.addOnScrollChangedListener(this._q);
                }
            } catch (Exception unused) {
            }
            _mfVar_a = _mf._a(this._e, z, _kVar);
            context = getContext();
            _ghVar = new _gh(this, _mfVar_a);
        } else {
            if (!this._i) {
                _mg._a(this._e);
                return;
            }
            try {
                ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    if (this._q == null) {
                        this._q = new _ge(this);
                    }
                    viewTreeObserver2.removeOnScrollChangedListener(this._q);
                    viewTreeObserver2.addOnScrollChangedListener(this._q);
                }
            } catch (Exception unused2) {
            }
            _mfVar_a = _mf._a(this._e, _kVar);
            context = getContext();
            _ghVar = new _gh(this, _mfVar_a);
        }
        _mg._a(context, _ghVar, _mfVar_a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    public final boolean _a(int i, int i2) {
        boolean z;
        try {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof _am) {
                    _am _amVar = (_am) childAt;
                    _amVar.getClass();
                    try {
                        View view = _amVar._d;
                        if (view != null) {
                            int[] iArr = new int[2];
                            view.getLocationOnScreen(iArr);
                            int i3 = iArr[0];
                            int i4 = iArr[1];
                            int width = _amVar._d.getWidth();
                            int height = _amVar._d.getHeight();
                            if (i < i3 || i > width + i3 || i2 < i4 || i2 > height + i4) {
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public final boolean _a(boolean z) {
        if (z) {
            return this._g && !this._u.get() && this._j && _ib._a(this._e);
        }
        return this._g && !this._u.get() && this._j;
    }

    public void _b(View view, int i, _nk _nkVar) {
        _ge _geVar;
        _a _aVar;
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
        _dj._a(this._c);
        _jw._a(this._g, this._j);
        this._g = false;
        this._h = false;
        this._j = false;
        this._l = false;
        this._m = false;
        this._n = false;
        try {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive() || (_geVar = this._q) == null) {
                return;
            }
            viewTreeObserver.removeOnScrollChangedListener(_geVar);
        } catch (Exception unused) {
        }
    }

    public final boolean _b() {
        List<View> advertViews;
        boolean zHasWindowFocus = hasWindowFocus();
        if (zHasWindowFocus || (advertViews = getAdvertViews()) == null || advertViews.isEmpty()) {
            return zHasWindowFocus;
        }
        for (View view : advertViews) {
            if (view != null && view.hasWindowFocus()) {
                return true;
            }
        }
        return zHasWindowFocus;
    }

    public final boolean _b(boolean z) {
        if (z) {
            return (this._h || this._j) && this._o.get() && !this._x.get() && _ib._a(this._e);
        }
        return (this._h || this._j) && this._o.get() && !this._x.get();
    }

    public final boolean _c() {
        boolean z = this._g && this._o.get() && !this._y.get() && (this._l || this._m) && _ib._a(this._e);
        AdSlot adSlot = this._d;
        if (adSlot != null && adSlot.getStype() == 8 && this._d.isSelfRender() && this._d.getUsedFor() == 1) {
            return z && this._n;
        }
        return z;
    }

    public void _d() {
        setBackgroundColor(-1);
    }

    public abstract List<View> getAdvertViews();

    public View getCView() {
        List<View> advertViews = getAdvertViews();
        return (advertViews == null || advertViews.isEmpty()) ? this : advertViews.get(0);
    }

    public abstract View getShakeLayout();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._o.set(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        _a _aVar;
        super.onDetachedFromWindow();
        this._o.set(false);
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
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        long jNextInt;
        if (_c()) {
            int action = motionEvent.getAction();
            int i = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            if (action == 0) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this._B = new _nl(rawX - iArr[0], rawY - iArr[1], System.currentTimeMillis());
                this._z = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                this._A = rawY2;
                if (this._m) {
                    if (_a((int) this._z, (int) rawY2)) {
                        return false;
                    }
                    this._y.set(true);
                    _nl _nlVar = this._B;
                    if (_nlVar != null) {
                        jNextInt = com.kc.aw.lib.utils._a._b.nextInt(31) + 50;
                        int i2 = _nlVar._g;
                        if (i2 <= 0 && (i2 = _nlVar._a) == 0) {
                            i2 = -999;
                        }
                        _nlVar._d = i2;
                        int i3 = _nlVar._h;
                        if (i3 > 0 || (i3 = _nlVar._b) != 0) {
                            i = i3;
                        }
                        _nlVar._e = i;
                        _nlVar._f = _nlVar._c + jNextInt;
                    } else {
                        jNextInt = 0;
                    }
                    setOnTouchAction(this._B);
                    _fz._a.postDelayed(new _b(this), jNextInt);
                    return true;
                }
            } else if (action == 3 && this._l) {
                int iAbs = (int) Math.abs(motionEvent.getRawX() - this._z);
                int iAbs2 = (int) Math.abs(motionEvent.getRawY() - this._A);
                if (iAbs > 35 || iAbs2 > 35) {
                    if (_a(iAbs, iAbs2)) {
                        return false;
                    }
                    this._y.set(true);
                    _nl _nlVar2 = this._B;
                    if (_nlVar2 != null) {
                        long jNextInt2 = com.kc.aw.lib.utils._a._b.nextInt(31) + 50;
                        int i4 = _nlVar2._g;
                        if (i4 <= 0 && (i4 = _nlVar2._a) == 0) {
                            i4 = -999;
                        }
                        _nlVar2._d = i4;
                        int i5 = _nlVar2._h;
                        if (i5 > 0 || (i5 = _nlVar2._b) != 0) {
                            i = i5;
                        }
                        _nlVar2._e = i;
                        _nlVar2._f = _nlVar2._c + jNextInt2;
                    }
                    setOnTouchAction(this._B);
                    _b(getCView(), 3, null);
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this._r = i == 0;
        _a(i);
    }

    public void setAdvertInfo(_h _hVar) {
        this._c = _hVar;
        if (_hVar != null) {
            this._e = String.valueOf(_hVar.hashCode()) + hashCode();
        }
    }

    public void setAdvertSlot(AdSlot adSlot) {
        this._d = adSlot;
    }

    public void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    public void setOnTouchAction(_nl _nlVar) {
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._b = ptgVideoAdListener;
    }
}
