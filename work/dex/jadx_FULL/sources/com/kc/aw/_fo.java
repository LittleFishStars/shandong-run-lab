package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.v0.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fo implements _ek {
    public final Context _a;
    public _a3 _b;
    public _a _c = new _a(this);

    @Keep
    public final class _a implements ServiceConnection {
        public final _fo _a;

        public _a(_fo _foVar) {
            this._a = _foVar;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            IInterface iInterfaceQueryLocalInterface;
            try {
                int i = _em._a._a;
                if (iBinder != null && (iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0208a.f25517a)) != null && (iInterfaceQueryLocalInterface instanceof _em)) {
                }
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0208a.f25517a);
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        string = null;
                    } catch (Throwable th2) {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th2;
                    }
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a(string);
                }
                _fo _foVar = this._a;
                _foVar._a.unbindService(_foVar._c);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a("");
                }
                _fo _foVar = this._a;
                _foVar._a.unbindService(_foVar._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _fo(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        try {
            this._b = _a3Var;
            if (this._a == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                this._a.bindService(intent, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
