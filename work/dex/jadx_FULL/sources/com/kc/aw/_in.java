package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _in {
    public final _h _a;
    public String _b;
    public View _c;
    public View _d;
    public long _e;
    public _k _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public int _m;
    public _b _n;
    public final AtomicBoolean _o = new AtomicBoolean(false);
    public final AtomicBoolean _p = new AtomicBoolean(false);
    public final AtomicBoolean _q = new AtomicBoolean(false);
    public final Handler _r = new Handler(Looper.getMainLooper());
    public final _a _s = new _a(this);

    @Keep
    public final class _a implements Runnable {
        public final _in _a;

        public _a(_in _inVar) {
            this._a = _inVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this._a._d;
            if (view != null && view.hasWindowFocus() && this._a._a()) {
                this._a._o.set(true);
                _o6._a(this._a._d, 6);
            }
        }
    }

    @Keep
    public interface _b {
        void _a(View view, int i, _nk _nkVar);

        void _a(boolean z);

        void _b(View view, int i, _nk _nkVar);
    }

    public _in(_h _hVar, _b _bVar) {
        this._a = _hVar;
        this._n = _bVar;
        if (_hVar != null) {
            this._b = _hVar._a();
        }
    }

    public final void _a(Activity activity) {
        _h _hVar;
        _mf _mfVar_a;
        _ip _ipVar;
        List<Integer> list;
        if (activity == null || (_hVar = this._a) == null) {
            return;
        }
        this._e = _hVar._I;
        try {
            ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
            boolean z = true;
            if (!(!concurrentHashMap.isEmpty())) {
                _k _kVar = _hVar._q;
                this._f = _kVar;
                if (_kVar != null) {
                    boolean z_c = _kVar._c();
                    this._i = z_c;
                    this._g = this._f._d(z_c);
                    _k _kVar2 = this._f;
                    int i = _kVar2._a;
                    this._h = i == 1 || i == 2;
                    this._j = _kVar2._b(this._i);
                    this._k = this._f._c(this._i);
                    _k _kVar3 = this._f;
                    this._m = _kVar3._j;
                    this._l = this._i && (list = _kVar3._g) != null && list.contains(4);
                }
            }
            View view = this._c;
            if (view != null) {
                view.setEnabled(this._g);
                this._c.setOnClickListener(new _im(this));
            }
            _b _bVar = this._n;
            if (_bVar != null) {
                _bVar._a(this._h);
            }
            _k _kVar4 = this._f;
            if (_kVar4 == null || !this._i) {
                if (this._h) {
                    _mf _mfVar_a2 = _mf._a(this._b, _kVar4);
                    _mg._a(activity, new _ip(this, _mfVar_a2), _mfVar_a2);
                    return;
                }
                return;
            }
            String str = this._b;
            if (!TextUtils.isEmpty(str)) {
                concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            if (!_a()) {
                if (_ib._a(this._b) && this._i && !this._q.get() && (this._j || this._k)) {
                    _mfVar_a = _mf._a(this._b, false, this._f);
                    _ipVar = new _ip(this, _mfVar_a);
                } else if (this._h) {
                    _mfVar_a = _mf._a(this._b, this._f);
                    _ipVar = new _ip(this, _mfVar_a);
                }
                _mg._a(activity, _ipVar, _mfVar_a);
            } else if (1 == this._m) {
                _mfVar_a = _mf._a(this._b, true, this._f);
                _ipVar = new _ip(this, _mfVar_a);
                _mg._a(activity, _ipVar, _mfVar_a);
            } else {
                long j_a = this._f._a();
                this._r.removeCallbacks(this._s);
                this._r.postDelayed(this._s, j_a);
            }
            if (!(_ib._a(this._b) && this._i && !this._p.get() && this._l) || this._d == null) {
                return;
            }
            if (!_ib._a(this._b) || !this._i || this._p.get() || !this._l) {
                z = false;
            }
            if (!z || _a()) {
                return;
            }
            this._d.setOnTouchListener(new _io(this, activity));
        } catch (Exception unused) {
        }
    }

    public final void _a(boolean z) {
        _a _aVar;
        this._o.set(true);
        this._p.set(true);
        this._q.set(true);
        this._i = false;
        this._g = false;
        this._k = false;
        this._j = false;
        this._l = false;
        if (z) {
            this._h = false;
        }
        Handler handler = this._r;
        if (handler != null && (_aVar = this._s) != null) {
            handler.removeCallbacks(_aVar);
        }
        String str = this._b;
        ConcurrentHashMap<String, Long> concurrentHashMap = _ib._a;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.remove(str);
        }
        _mg._a(this._b);
    }

    public final boolean _a() {
        return _ib._a(this._b) && this._i && !this._o.get() && this._k;
    }

    public final void _b() {
        Context context;
        _mf _mfVar_a;
        _ip _ipVar;
        try {
            View view = this._c;
            if (view == null || view.getContext() == null) {
                return;
            }
            boolean z = true;
            if (!_a()) {
                if (!_ib._a(this._b) || !this._i || this._q.get() || (!this._j && !this._k)) {
                    z = false;
                }
                if (z) {
                    context = this._c.getContext();
                    _mfVar_a = _mf._a(this._b, false, this._f);
                    _ipVar = new _ip(this, _mfVar_a);
                } else {
                    if (!this._h) {
                        return;
                    }
                    context = this._c.getContext();
                    _mfVar_a = _mf._a(this._b, this._f);
                    _ipVar = new _ip(this, _mfVar_a);
                }
            } else {
                if (1 != this._m) {
                    return;
                }
                context = this._c.getContext();
                _mfVar_a = _mf._a(this._b, true, this._f);
                _ipVar = new _ip(this, _mfVar_a);
            }
            _mg._a(context, _ipVar, _mfVar_a);
        } catch (Exception unused) {
        }
    }
}
