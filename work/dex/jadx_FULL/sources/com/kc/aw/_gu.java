package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdSlot;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gu {
    public final Context _a;
    public final AdSlot _b;
    public final _h _c;
    public final String _d;
    public PtgNativeExpressAd.AdInteractionListener _e;
    public ViewGroup _f;
    public List<View> _g;
    public _k _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public int _m;
    public boolean _n;
    public long _o;
    public boolean _p = true;
    public final AtomicBoolean _q = new AtomicBoolean(false);
    public final AtomicBoolean _r = new AtomicBoolean(false);
    public final AtomicBoolean _s = new AtomicBoolean(false);
    public final Handler _t = new Handler(Looper.getMainLooper());
    public final _a _u = new _a(this);
    public final _b _v = new _b(this);
    public final _c _w = new _c(this);
    public final AtomicBoolean _x = new AtomicBoolean(false);

    @Keep
    public final class _a implements Runnable {
        public final _gu _a;

        public _a(_gu _guVar) {
            this._a = _guVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                _gu _guVar = this._a;
                List<View> list = _guVar._g;
                View view = (list == null || list.isEmpty()) ? null : _guVar._g.get(0);
                if (view != null && view.hasWindowFocus() && this._a._a(true)) {
                    this._a._q.set(true);
                    _o6._a(view, 6);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Keep
    public final class _b implements View.OnTouchListener {
        public final _gu _a;

        public _b(_gu _guVar) {
            this._a = _guVar;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this._a._w.onTouch(view, motionEvent);
            return false;
        }
    }

    @Keep
    public final class _c implements View.OnTouchListener {
        public long _a = 0;
        public long _b = 0;
        public int _c;
        public int _d;
        public int _e;
        public int _f;
        public int _g;
        public int _h;
        public int _i;
        public int _j;
        public final _gu _k;

        @Keep
        public final class _a implements Runnable {
            public final View _a;
            public final _c _b;

            public _a(_c _cVar, View view) {
                this._b = _cVar;
                this._a = view;
            }

            @Override // java.lang.Runnable
            public final void run() {
                View view = this._a;
                if (view != null) {
                    this._b._k._a(view);
                }
            }
        }

        public _c(_gu _guVar) {
            this._k = _guVar;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0083  */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            _gu _guVar = this._k;
            if (_guVar._f == null || _gu._a(_guVar, view)) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && _gu._a(this._k, view, motionEvent)) {
                    this._b = System.currentTimeMillis();
                    this._e = (int) motionEvent.getRawX();
                    this._f = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    this._k._f.getLocationOnScreen(iArr);
                    this._i = this._e - iArr[0];
                    this._j = this._f - iArr[1];
                    int i = R.id.aw_native_view_tag;
                    Object tag = view.getTag(i);
                    if (tag instanceof _nl) {
                        _nl _nlVar = (_nl) tag;
                        if (_nlVar._k > 0) {
                            this._k._r.set(true);
                            _nl _nlVar2 = new _nl(this._g, this._h, this._a);
                            _nlVar2._f = this._b;
                            _nlVar2._d = this._i;
                            _nlVar2._e = this._j;
                            _nlVar2._k = _nlVar._k;
                            view.setTag(i, _nlVar2);
                        } else {
                            this._k._r.set(true);
                            _nl _nlVar3 = new _nl(this._g, this._h, this._a);
                            _nlVar3._f = this._b;
                            _nlVar3._d = this._i;
                            _nlVar3._e = this._j;
                            _nlVar3._k = 0;
                            view.setTag(i, _nlVar3);
                        }
                    } else {
                        this._k._r.set(true);
                        _nl _nlVar4 = new _nl(this._g, this._h, this._a);
                        _nlVar4._f = this._b;
                        _nlVar4._d = this._i;
                        _nlVar4._e = this._j;
                        _nlVar4._k = 0;
                        view.setTag(i, _nlVar4);
                    }
                    this._k._a(view);
                }
                return true;
            }
            if (_gu._a(this._k, view, motionEvent)) {
                this._a = System.currentTimeMillis();
                this._c = (int) motionEvent.getRawX();
                this._d = (int) motionEvent.getRawY();
                int[] iArr2 = new int[2];
                this._k._f.getLocationOnScreen(iArr2);
                this._g = this._c - iArr2[0];
                this._h = this._d - iArr2[1];
                _gu _guVar2 = this._k;
                if ((_guVar2._i && !_guVar2._r.get() && _guVar2._n && _ib._a(_guVar2._d)) && !this._k._a(true)) {
                    this._k.getClass();
                    if (_o6._a(view) != 6) {
                        this._k._r.set(true);
                        _gu _guVar3 = this._k;
                        int i2 = this._g;
                        int i3 = this._h;
                        _guVar3.getClass();
                        _nl _nlVar5 = new _nl(i2, i3, System.currentTimeMillis());
                        _nlVar5._k = 2;
                        this._k.getClass();
                        long jNextInt = com.kc.aw.lib.utils._a._b.nextInt(31) + 50;
                        int i4 = _nlVar5._g;
                        int i5 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                        if (i4 <= 0 && (i4 = _nlVar5._a) == 0) {
                            i4 = -999;
                        }
                        _nlVar5._d = i4;
                        int i6 = _nlVar5._h;
                        if (i6 > 0 || (i6 = _nlVar5._b) != 0) {
                            i5 = i6;
                        }
                        _nlVar5._e = i5;
                        _nlVar5._f = _nlVar5._c + jNextInt;
                        view.setTag(R.id.aw_native_view_tag, _nlVar5);
                        view.postDelayed(new _a(this, view), jNextInt);
                    }
                }
            }
            return true;
        }
    }

    public _gu(Context context, _h _hVar, AdSlot adSlot) {
        this._a = context;
        this._b = adSlot;
        this._c = _hVar;
        this._d = _hVar._a();
        _a();
    }

    public static boolean _a(_gu _guVar, View view) {
        boolean z = false;
        if (view == null) {
            _guVar.getClass();
            return false;
        }
        ViewGroup viewGroup = _guVar._f;
        if (viewGroup == null || view != viewGroup || _guVar._p) {
            return false;
        }
        if (_guVar._i && !_guVar._r.get() && _guVar._n && _ib._a(_guVar._d)) {
            z = true;
        }
        return !z;
    }

    public static boolean _a(_gu _guVar, View view, MotionEvent motionEvent) {
        _guVar.getClass();
        if (!(motionEvent.getX() >= 0.0f && motionEvent.getX() <= ((float) view.getWidth()) && motionEvent.getY() >= 0.0f && motionEvent.getY() <= ((float) view.getHeight()))) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (motionEvent.getX() < iArr[0]) {
                return false;
            }
            if (motionEvent.getX() > view.getWidth() + iArr[0] || motionEvent.getY() < iArr[1]) {
                return false;
            }
            if (motionEvent.getY() > view.getHeight() + iArr[1]) {
                return false;
            }
        }
        return true;
    }

    public final void _a() {
        List<Integer> list;
        _h _hVar = this._c;
        if (_hVar == null) {
            return;
        }
        _k _kVar = _hVar._q;
        this._h = _kVar;
        if (_kVar == null) {
            return;
        }
        boolean z_c = _kVar._c();
        this._i = z_c;
        if (z_c) {
            this._j = this._h._b(z_c);
            this._k = this._h._d(this._i);
            this._l = this._h._c(this._i);
            _k _kVar2 = this._h;
            this._m = _kVar2._j;
            this._n = this._i && (list = _kVar2._g) != null && list.contains(4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000b  */
    public final void _a(View view) {
        boolean z;
        int i_a = _o6._a(view);
        if (i_a != 0) {
            z = i_a != 1;
        }
        if (z) {
            _b(view, _o6._a(view), null, this._e);
        } else {
            _a(view, 0, null, this._e);
        }
    }

    public final void _a(View view, int i, _nk _nkVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        ViewGroup viewGroup;
        if (com.kc.aw.lib.utils._a._c() || this._b == null || this._c == null || view == null) {
            return;
        }
        this._i = false;
        this._l = false;
        this._j = false;
        this._k = false;
        this._n = false;
        this._r.set(true);
        this._q.set(true);
        this._s.set(true);
        if (!this._p && (viewGroup = this._f) != null) {
            viewGroup.setOnTouchListener(null);
        }
        this._b.setCt(i);
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
        _b2._a(view.getContext(), this._c, this._b);
        if (!this._c._x || adInteractionListener == null) {
            return;
        }
        adInteractionListener.onAdClicked();
    }

    public final boolean _a(boolean z) {
        if (z) {
            return this._i && !this._q.get() && this._l && _ib._a(this._d);
        }
        return this._i && !this._q.get() && this._l;
    }

    public final void _b() {
        List<View> list;
        ViewGroup viewGroup = this._f;
        this._p = (viewGroup == null || (list = this._g) == null || !list.contains(viewGroup)) ? false : true;
        ViewGroup viewGroup2 = this._f;
        if (viewGroup2 != null && (this._k || this._n)) {
            viewGroup2.setEnabled(true);
            this._f.setClickable(true);
            this._f.setOnTouchListener(this._v);
        }
        List<View> list2 = this._g;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        for (View view : this._g) {
            view.setTag(R.id.aw_native_view_tag, new _nl(view));
            view.setEnabled(true);
            view.setClickable(true);
            view.setOnTouchListener(this._v);
        }
    }

    public final void _b(View view, int i, _nk _nkVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        ViewGroup viewGroup;
        _a _aVar;
        if (_ib._a(this._d)) {
            Handler handler = this._t;
            if (handler != null && (_aVar = this._u) != null) {
                handler.removeCallbacks(_aVar);
            }
            String str = this._d;
            if (!TextUtils.isEmpty(str)) {
                _ib._a.remove(str);
            }
            _mg._a(this._d);
        }
        _dj._a(this._c);
        _jw._a(this._i, this._l);
        this._i = false;
        this._l = false;
        this._j = false;
        this._k = false;
        this._n = false;
        this._r.set(true);
        this._q.set(true);
        this._s.set(true);
        if (!this._p && (viewGroup = this._f) != null) {
            viewGroup.setOnTouchListener(null);
        }
        _a(view, i, _nkVar, adInteractionListener);
        List<View> list = this._g;
        if (list != null) {
            for (View view2 : list) {
                view2.setTag(R.id.aw_native_view_tag, new _nl(view2));
            }
        }
    }

    public final boolean _b(boolean z) {
        if (z) {
            if (!this._i || this._s.get()) {
                return false;
            }
            return (this._j || this._l) && _ib._a(this._d);
        }
        if (!this._i || this._s.get()) {
            return false;
        }
        return this._j || this._l;
    }
}
