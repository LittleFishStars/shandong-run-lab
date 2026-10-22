package com.kc.aw;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i4 {
    public final ConcurrentHashMap _a = new ConcurrentHashMap();

    @Keep
    public static final class _a implements Runnable {
        public final String _a;
        public _b _b;

        /* JADX INFO: renamed from: com.kc.aw._i4$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0945_a implements _d3._d {
            public final _a _a;

            public C0945_a(_a _aVar) {
                this._a = _aVar;
            }

            @Override // com.kc.aw._d3._g
            public final void _a(Bitmap bitmap) {
                _b _bVar = this._a._b;
                if (_bVar != null) {
                    _bVar._b();
                    this._a._b = null;
                }
            }

            @Override // com.kc.aw._d3._d
            public final void _a(Exception exc) {
                _b _bVar = this._a._b;
                if (_bVar != null) {
                    _bVar._a();
                    this._a._b = null;
                }
            }
        }

        public _a(String str, _b _bVar) {
            this._a = str;
            this._b = _bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handler;
            _d3._c _cVar;
            try {
                _d3 _d3Var = new _d3(PtgAdSdk.getContext(), new C0945_a(this));
                _d3Var._d = true;
                String str = this._a;
                _d3Var._i = 3000;
                _d3Var._h = true;
                _d3Var.executeOnExecutor(_d3Var._f, str);
                int i = _d3Var._i;
                if (i <= 0 || (handler = _d3Var._a) == null || (_cVar = _d3Var._l) == null) {
                    return;
                }
                handler.postDelayed(_cVar, i);
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
                _b _bVar = this._b;
                if (_bVar != null) {
                    _bVar._a();
                    this._b = null;
                }
            }
        }
    }

    @Keep
    public interface _b {
        void _a();

        void _b();
    }

    @Keep
    public static final class _c {
        public static final _i4 _a = new _i4();
    }

    @Keep
    public static final class _d implements Runnable {
        public final String _a;
        public _b _b;

        @Keep
        public final class _a implements _d3._d {
            public final _d _a;

            public _a(_d _dVar) {
                this._a = _dVar;
            }

            @Override // com.kc.aw._d3._g
            public final void _a(Bitmap bitmap) {
                _b _bVar = this._a._b;
                if (_bVar != null) {
                    _bVar._b();
                    this._a._b = null;
                }
            }

            @Override // com.kc.aw._d3._d
            public final void _a(Exception exc) {
                _b _bVar = this._a._b;
                if (_bVar != null) {
                    _bVar._a();
                    this._a._b = null;
                }
            }
        }

        public _d(String str, _b _bVar) {
            this._a = str;
            this._b = _bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handler;
            _d3._c _cVar;
            try {
                _d3 _d3Var = new _d3(PtgAdSdk.getContext(), new _a(this));
                _d3Var._d = true;
                String str = this._a;
                _d3Var._g = true;
                _d3Var._i = 3000;
                _d3Var._h = true;
                _d3Var.executeOnExecutor(_d3Var._f, str);
                int i = _d3Var._i;
                if (i <= 0 || (handler = _d3Var._a) == null || (_cVar = _d3Var._l) == null) {
                    return;
                }
                handler.postDelayed(_cVar, i);
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
                _b _bVar = this._b;
                if (_bVar != null) {
                    _bVar._a();
                    this._b = null;
                }
            }
        }
    }

    public final void _a(String str, boolean z, _b _bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this._a) {
            String str_c = com.kc.aw.lib.utils._a._c(str);
            if (!this._a.containsKey(str_c)) {
                this._a.put(str_c, Boolean.TRUE);
                if (PtgAdSdk.getConfig()._b()) {
                    try {
                        _ez._a(str, new _i3(_bVar));
                    } catch (Exception unused) {
                        if (_bVar != null) {
                            _bVar._a();
                        }
                    }
                } else {
                    com.kc.aw.lib.utils._d._b(z ? new _d(str, _bVar) : new _a(str, _bVar));
                }
            } else if (_bVar != null) {
                _bVar._b();
            }
        }
    }
}
