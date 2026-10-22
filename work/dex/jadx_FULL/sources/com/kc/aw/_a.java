package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a implements _ek {
    public final Context _a;
    public _a3 _b;
    public ServiceConnectionC0935_a _c = new ServiceConnectionC0935_a(this);

    /* JADX INFO: renamed from: com.kc.aw._a$_a, reason: collision with other inner class name */
    @Keep
    public final class ServiceConnectionC0935_a implements ServiceConnection {
        public final _a _a;

        public ServiceConnectionC0935_a(_a _aVar) {
            this._a = _aVar;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String string;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    iBinder.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    th.printStackTrace();
                    string = null;
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a(string);
                }
                _a _aVar = this._a;
                _aVar._a.unbindService(_aVar._c);
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
                _a _aVar = this._a;
                _aVar._a.unbindService(_aVar._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _a(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        this._b = _a3Var;
        try {
            if (this._a == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                }
            } else {
                Intent intent = new Intent();
                intent.setAction("com.asus.msa.action.ACCESS_DID");
                intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
                this._a.bindService(intent, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
