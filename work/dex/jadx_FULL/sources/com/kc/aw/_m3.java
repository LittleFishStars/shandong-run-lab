package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.alipay.sdk.m.p0.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m3 implements _ek {
    public final Context _a;
    public _a3 _b;
    public _a _c = new _a(this);

    @Keep
    public final class _a implements ServiceConnection {
        public final _m3 _a;

        public _a(_m3 _m3Var) {
            this._a = _m3Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0200a.f25485a);
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    th.printStackTrace();
                    string = null;
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a(string);
                }
                _m3 _m3Var = this._a;
                _m3Var._a.unbindService(_m3Var._c);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a("");
                }
                _m3 _m3Var = this._a;
                _m3Var._a.unbindService(_m3Var._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _m3(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        this._b = _a3Var;
        if (this._a == null) {
            if (_a3Var != null) {
                _a3Var._a("");
            }
        } else {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                this._a.bindService(intent, this._c, 1);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
