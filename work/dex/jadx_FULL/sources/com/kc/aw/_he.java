package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _he implements _ek {
    public Context _a;
    public String _b;

    @Keep
    public final class _a implements ServiceConnection {
        public final _a3 _a;
        public final _he _b;

        public _a(_he _heVar, _a3 _a3Var) {
            this._b = _heVar;
            this._a = _a3Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _hf _aVar;
            try {
                int i = _hf._b._a;
                if (iBinder == null) {
                    _aVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    _aVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof _hf)) ? new _hf._a(iBinder) : (_hf) iInterfaceQueryLocalInterface;
                }
                if (_aVar == null) {
                    _a3 _a3Var = this._a;
                    if (_a3Var != null) {
                        _a3Var._a("");
                    }
                    this._b._a.unbindService(this);
                    return;
                }
                try {
                    String str_a = _he._a(this._b, _aVar);
                    _a3 _a3Var2 = this._a;
                    if (_a3Var2 != null) {
                        _a3Var2._a(str_a);
                    }
                } catch (Exception e) {
                    _a3 _a3Var3 = this._a;
                    if (_a3Var3 != null) {
                        _a3Var3._a("");
                    }
                    e.printStackTrace();
                }
                this._b._a.unbindService(this);
            } catch (Exception e2) {
                e2.printStackTrace();
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

    public _he(Context context) {
        this._a = context;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005f  */
    public static String _a(_he _heVar, _hf _hfVar) {
        Signature[] signatureArr;
        String string;
        String packageName = _heVar._a.getPackageName();
        String string2 = null;
        if (_heVar._b == null) {
            try {
                signatureArr = _heVar._a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
                th.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    } else {
                        string = null;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            _heVar._b = string;
        }
        _hf._a _aVar = (_hf._a) _hfVar;
        String str = _heVar._b;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(packageName);
            parcelObtain.writeString(str);
            parcelObtain.writeString("OUID");
            _aVar._a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string2 = parcelObtain2.readString();
        } catch (Throwable th3) {
            try {
                th3.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return string2;
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
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                this._a.bindService(intent, new _a(this, _a3Var), 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
