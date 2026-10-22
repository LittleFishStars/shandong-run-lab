package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e7 implements _ek {
    public final Context _a;
    public final Handler _b = new Handler(Looper.getMainLooper());

    @Keep
    public final class _a implements Runnable {
        public final _a3 _a;
        public final _e7 _b;

        public _a(_e7 _e7Var, _a3 _a3Var) {
            this._b = _e7Var;
            this._a = _a3Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _4._a _aVar_a;
            _e7 _e7Var = this._b;
            _a3 _a3Var = this._a;
            _e7Var.getClass();
            try {
                try {
                    _aVar_a = _4._a(_e7Var._a);
                } catch (Throwable unused) {
                    _aVar_a = null;
                }
                _e7Var._b.post(new _e8(_a3Var, (_aVar_a == null || _aVar_a._b) ? "" : _aVar_a._a));
            } catch (Exception unused2) {
                _e7Var._b.post(new _e8(_a3Var, ""));
            }
        }
    }

    public _e7(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        if (this._a == null || _a3Var == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new _a(this, _a3Var));
    }

    public final boolean _a() {
        Context context = this._a;
        if (context == null) {
            return false;
        }
        try {
            new _e9();
            return _e9._a(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
