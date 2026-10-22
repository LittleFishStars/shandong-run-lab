package com.kc.aw;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _4 {

    @Keep
    public static final class _a {
        public String _a;
        public boolean _b;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:51:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static _a _a(Context context) {
        boolean z;
        try {
            _e9 _e9Var = new _e9();
            _e9Var._a = context;
            if (!_e9._a(context)) {
                return null;
            }
            _a _aVar = _e9Var._b;
            try {
                String string = Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID);
                String str = "";
                if (TextUtils.isEmpty(string)) {
                    _a2._a().getClass();
                    try {
                        string = _jw._c(context, "ptg_ids_sp_honor_oaid");
                    } catch (Throwable th) {
                        th.printStackTrace();
                        string = "";
                    }
                }
                try {
                    if (!TextUtils.isEmpty(string)) {
                        String strReplace = string.replace(c49.f40900a, "");
                        int i = 0;
                        while (true) {
                            if (i >= strReplace.length()) {
                                z = true;
                                break;
                            }
                            if (strReplace.charAt(i) == '0') {
                                i++;
                            }
                        }
                        if (z) {
                            str = string;
                        }
                        if (TextUtils.isEmpty(str)) {
                            _aVar._b = false;
                            _aVar._a = str;
                            return _aVar;
                        }
                        try {
                            try {
                                Intent intent = new Intent("com.hihonor.id.HnOaIdService");
                                intent.setPackage("com.hihonor.id");
                                context.bindService(intent, _e9Var, 1);
                                _e9Var._e.await(2000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e) {
                                Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
                            }
                            try {
                                _e9Var._a.unbindService(_e9Var);
                            } catch (Exception unused) {
                            }
                            return _aVar;
                        } catch (Exception e2) {
                            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
                            _e9Var._a.unbindService(_e9Var);
                            return _aVar;
                        }
                        Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
                        _e9Var._a.unbindService(_e9Var);
                        return _aVar;
                    }
                    _e9Var._a.unbindService(_e9Var);
                } catch (Exception unused2) {
                }
                z = false;
                if (z) {
                    str = string;
                }
                if (TextUtils.isEmpty(str)) {
                    _aVar._b = false;
                    _aVar._a = str;
                    return _aVar;
                }
                Intent intent2 = new Intent("com.hihonor.id.HnOaIdService");
                intent2.setPackage("com.hihonor.id");
                context.bindService(intent2, _e9Var, 1);
                _e9Var._e.await(2000L, TimeUnit.MILLISECONDS);
                _e9Var._a.unbindService(_e9Var);
                return _aVar;
            } catch (Exception unused3) {
                Intent intent3 = new Intent("com.hihonor.id.HnOaIdService");
                intent3.setPackage("com.hihonor.id");
                context.bindService(intent3, _e9Var, 1);
                _e9Var._e.await(2000L, TimeUnit.MILLISECONDS);
                _e9Var._a.unbindService(_e9Var);
                return _aVar;
            }
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e2.getMessage());
            return _aVar;
        } catch (Exception unused4) {
            return null;
        }
    }
}
