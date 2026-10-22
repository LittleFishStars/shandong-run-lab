package com.kc.aw;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _bs implements _ek {
    public final Context _a;

    @Keep
    public final class _a implements ServiceConnection {
        public final _a3 _a;
        public final _bs _b;

        public _a(_bs _bsVar, _a3 _a3Var) {
            this._b = _bsVar;
            this._a = _a3Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _el c0942_a;
            try {
                int i = _el._a._a;
                if (iBinder == null) {
                    c0942_a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    c0942_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _el)) ? new _el._a.C0942_a(iBinder) : (_el) iInterfaceQueryLocalInterface;
                }
                if (this._a != null) {
                    this._a._a(c0942_a != null ? c0942_a._a(this._b._a.getPackageName()) : "");
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

    public _bs(Context context) {
        this._a = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        try {
            if (this._a == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
                this._a.bindService(intent, new _a(this, _a3Var), 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
