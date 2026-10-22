package com.kc.aw;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import com.alipay.sdk.m.d.b;
import com.huawei.hms.common.PackageConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e5 implements _ek {
    public final Context _a;
    public _a3 _b;
    public _a _c = new _a(this);

    @Keep
    public final class _a implements ServiceConnection {
        public final _e5 _a;

        /* JADX INFO: renamed from: com.kc.aw._e5$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class RunnableC0939_a implements Runnable {
            public final IBinder _a;
            public final _a _b;

            /* JADX INFO: renamed from: com.kc.aw._e5$_a$_a$_a, reason: collision with other inner class name */
            @Keep
            public final class RunnableC0940_a implements Runnable {
                public final String _a;
                public final RunnableC0939_a _b;

                public RunnableC0940_a(RunnableC0939_a runnableC0939_a, String str) {
                    this._b = runnableC0939_a;
                    this._a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    _a3 _a3Var = this._b._b._a._b;
                    if (_a3Var != null) {
                        _a3Var._a(this._a);
                    }
                    _e5 _e5Var = this._b._b._a;
                    _e5Var._a.unbindService(_e5Var._c);
                }
            }

            public RunnableC0939_a(_a _aVar, IBinder iBinder) {
                this._b = _aVar;
                this._a = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                try {
                    IBinder iBinder = this._a;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken(b.f25422a);
                        iBinder.transact(1, parcelObtain, parcelObtain2, 0);
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
                    com.kc.aw.lib.utils._d._c(new RunnableC0940_a(this, string));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public _a(_e5 _e5Var) {
            this._a = _e5Var;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kc.aw.lib.utils._d._b(new RunnableC0939_a(this, iBinder));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            try {
                _a3 _a3Var = this._a._b;
                if (_a3Var != null) {
                    _a3Var._a("");
                }
                _e5 _e5Var = this._a;
                _e5Var._a.unbindService(_e5Var._c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _e5(Context context) {
        this._a = context;
    }

    public static boolean _a(String str) {
        if (str != null) {
            return "00000000-0000-0000-0000-000000000000".equals(str);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0055 A[Catch: all -> 0x006b, TRY_ENTER, TryCatch #2 {all -> 0x006b, blocks: (B:3:0x0008, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:14:0x002c, B:17:0x0032, B:29:0x0055, B:31:0x0059, B:20:0x0040, B:23:0x0048), top: B:42:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #2 {all -> 0x006b, blocks: (B:3:0x0008, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:14:0x002c, B:17:0x0032, B:29:0x0055, B:31:0x0059, B:20:0x0040, B:23:0x0048), top: B:42:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        String str = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
        this._b = _a3Var;
        try {
            Context context = this._a;
            if (context == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                    return;
                }
                return;
            }
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string) && !_a(string)) {
                    if (_a3Var != null) {
                        _a3Var._a(string);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
            }
            boolean z = false;
            try {
                PackageManager packageManager = this._a.getPackageManager();
                if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                    str = "com.huawei.hwid";
                } else {
                    if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                        try {
                            if (packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) != null) {
                            }
                        } catch (Exception unused2) {
                        }
                        if (z) {
                            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                            intent.setPackage(str);
                            this._a.bindService(intent, this._c, 1);
                        } else if (_a3Var != null) {
                            _a3Var._a("");
                        }
                    }
                    str = "com.huawei.hwid.tv";
                }
                z = true;
            } catch (Exception unused3) {
                str = "com.huawei.hwid";
            }
            if (z) {
                if (_a3Var != null) {
                    _a3Var._a("");
                }
            } else {
                Intent intent2 = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent2.setPackage(str);
                this._a.bindService(intent2, this._c, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
