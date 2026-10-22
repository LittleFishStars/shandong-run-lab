package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dw implements _ek {
    public final Context _a;
    public _a _b;
    public volatile boolean _c = false;

    @Keep
    public final class _a implements ServiceConnection {
        public final _a3 _a;
        public final _dw _b;

        /* JADX INFO: renamed from: com.kc.aw._dw$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class RunnableC0937_a implements Runnable {
            public final _ej _a;
            public final _a _b;

            /* JADX INFO: renamed from: com.kc.aw._dw$_a$_a$_a, reason: collision with other inner class name */
            @Keep
            public final class RunnableC0938_a implements Runnable {
                public final String _a;
                public final RunnableC0937_a _b;

                public RunnableC0938_a(RunnableC0937_a runnableC0937_a, String str) {
                    this._b = runnableC0937_a;
                    this._a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a _aVar = this._b._b;
                    _dw _dwVar = _aVar._b;
                    _a3 _a3Var = _aVar._a;
                    String str = this._a;
                    _dwVar.getClass();
                    if (_a3Var != null) {
                        _a3Var._a(str);
                    }
                    this._b._b._b._a();
                }
            }

            /* JADX INFO: renamed from: com.kc.aw._dw$_a$_a$_b */
            @Keep
            public final class _b implements Runnable {
                public final RunnableC0937_a _a;

                public _b(RunnableC0937_a runnableC0937_a) {
                    this._a = runnableC0937_a;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a _aVar = this._a._b;
                    _dw _dwVar = _aVar._b;
                    _a3 _a3Var = _aVar._a;
                    _dwVar.getClass();
                    if (_a3Var != null) {
                        _a3Var._a("");
                    }
                    this._a._b._b._a();
                }
            }

            public RunnableC0937_a(_a _aVar, _ej _ejVar) {
                this._b = _aVar;
                this._a = _ejVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kc.aw.lib.utils._d._c(new RunnableC0938_a(this, this._a._a()));
                } catch (Throwable unused) {
                    com.kc.aw.lib.utils._d._c(new _b(this));
                }
            }
        }

        public _a(_dw _dwVar, _a3 _a3Var) {
            this._b = _dwVar;
            this._a = _a3Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _ej c0941_a;
            this._b._c = false;
            try {
                int i = _ej._a._a;
                if (iBinder == null) {
                    c0941_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    c0941_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _ej)) ? new _ej._a.C0941_a(iBinder) : (_ej) iInterfaceQueryLocalInterface;
                }
                com.kc.aw.lib.utils._d._b(new RunnableC0937_a(this, c0941_a));
            } catch (Throwable unused) {
                _dw _dwVar = this._b;
                _a3 _a3Var = this._a;
                _dwVar.getClass();
                if (_a3Var != null) {
                    _a3Var._a("");
                }
                this._b._a();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this._b._c = false;
            _dw _dwVar = this._b;
            _a3 _a3Var = this._a;
            _dwVar.getClass();
            if (_a3Var != null) {
                _a3Var._a("");
            }
            this._b._a();
        }
    }

    public _dw(Context context) {
        this._a = context.getApplicationContext();
    }

    public final void _a() {
        _a _aVar = this._b;
        if (_aVar != null) {
            try {
                this._a.unbindService(_aVar);
            } catch (Exception unused) {
            }
            this._b = null;
        }
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        try {
            if (this._a == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                    return;
                }
                return;
            }
            if (this._c) {
                if (_a3Var != null) {
                    _a3Var._a("");
                    return;
                }
                return;
            }
            this._b = new _a(this, _a3Var);
            this._c = true;
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (this._a.bindService(intent, this._b, 1)) {
                return;
            }
            this._c = false;
            if (_a3Var != null) {
                _a3Var._a("");
            }
            _a();
        } catch (Throwable th) {
            th.printStackTrace();
            this._c = false;
            if (_a3Var != null) {
                _a3Var._a("");
            }
            _a();
        }
    }
}
