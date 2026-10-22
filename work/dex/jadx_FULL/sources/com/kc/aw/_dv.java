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
public final class _dv implements _ek {
    public final Context _a;

    @Keep
    public final class _a implements ServiceConnection {
        public final _a3 _a;
        public final _dv _b;

        public _a(_dv _dvVar, _a3 _a3Var) {
            this._b = _dvVar;
            this._a = _a3Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _ev c0943_a;
            try {
                int i = _ev._a._a;
                if (iBinder == null) {
                    c0943_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                    c0943_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _ev)) ? new _ev._a.C0943_a(iBinder) : (_ev) iInterfaceQueryLocalInterface;
                }
                if (this._a != null) {
                    this._a._a(c0943_a != null ? c0943_a._b() : "");
                }
                this._b._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a3 _a3Var = this._a;
                if (_a3Var != null) {
                    _a3Var._a("");
                }
                this._b._a.unbindService(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _dv(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        if (this._a == null) {
            if (_a3Var != null) {
                _a3Var._a("");
            }
        } else {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            this._a.bindService(intent, new _a(this, _a3Var), 1);
        }
    }
}
