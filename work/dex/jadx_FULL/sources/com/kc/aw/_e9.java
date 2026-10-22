package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e9 implements ServiceConnection {
    public Context _a;
    public _4._a _b = new _4._a();
    public _b _c = new _b(this);
    public _a _d = new _a(this);
    public CountDownLatch _e = new CountDownLatch(2);

    @Keep
    public final class _a extends _eo {
        public final _e9 _a;

        public _a(_e9 _e9Var) {
            this._a = _e9Var;
        }

        @Override // com.kc.aw._eo
        public final void _a(int i, Bundle bundle) {
            if (i == 0 && bundle != null && this._a._b != null) {
                this._a._b._b = bundle.getBoolean("oa_id_limit_state");
            }
            this._a._e.countDown();
        }

        @Override // com.kc.aw._eo
        public final void _c() {
        }
    }

    @Keep
    public final class _b extends _eo {
        public final _e9 _a;

        public _b(_e9 _e9Var) {
            this._a = _e9Var;
        }

        @Override // com.kc.aw._eo
        public final void _a(int i, Bundle bundle) {
            if (i == 0 && bundle != null && this._a._b != null) {
                String string = bundle.getString("oa_id_flag");
                this._a._b._a = string;
                try {
                    _a2 _a2Var_a = _a2._a();
                    Context context = this._a._a;
                    _a2Var_a.getClass();
                    try {
                        _jw._a(context, "ptg_ids_sp_honor_oaid", string);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable unused) {
                }
            }
            this._a._e.countDown();
        }

        @Override // com.kc.aw._eo
        public final void _c() {
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final IBinder _a;
        public final _e9 _b;

        public _c(_e9 _e9Var, IBinder iBinder) {
            this._b = _e9Var;
            this._a = iBinder;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x001d, code lost:
        
            r0 = null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            _ep _epVar;
            try {
                Binder.getCallingPid();
                IBinder iBinder = this._a;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    _epVar = iInterfaceQueryLocalInterface instanceof _ep ? (_ep) iInterfaceQueryLocalInterface : new _ep(this._a);
                } else {
                    _epVar = null;
                }
            } catch (Exception unused) {
                _epVar = null;
            }
            try {
                _epVar._a(this._b._c);
                _epVar._a(this._b._d);
            } catch (Exception unused2) {
                this._b._e.countDown();
                this._b._e.countDown();
                _e9 _e9Var = this._b;
                _e9Var.getClass();
                try {
                    _e9Var._a.unbindService(_e9Var);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public static boolean _a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new Thread(new _c(this, iBinder)).start();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this._e.countDown();
        this._e.countDown();
    }
}
