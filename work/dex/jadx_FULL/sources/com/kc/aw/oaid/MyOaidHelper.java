package com.kc.aw.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.kc.aw._a;
import com.kc.aw._a3;
import com.kc.aw._bs;
import com.kc.aw._bt;
import com.kc.aw._c5;
import com.kc.aw._dv;
import com.kc.aw._e5;
import com.kc.aw._e7;
import com.kc.aw._ek;
import com.kc.aw._fo;
import com.kc.aw._g4;
import com.kc.aw._ha;
import com.kc.aw._hc;
import com.kc.aw._he;
import com.kc.aw._m3;
import com.kc.aw._o8;
import com.kc.aw._ol;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MyOaidHelper {
    public static _ek createOaidGetter(Context context) {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR") && !(!TextUtils.isEmpty(_hc._a("ro.build.version.emui")))) {
                _e7 _e7Var = new _e7(context);
                if (_e7Var._a()) {
                    return _e7Var;
                }
            }
            if (!_hc._c() && !(!TextUtils.isEmpty(_hc._a("ro.build.version.emui")))) {
                if (_hc._k()) {
                    return new _o8(context);
                }
                if (!_hc._i() && !_hc._h()) {
                    if (!_hc._l() && !(!TextUtils.isEmpty(_hc._a(XmSystemUtils.KEY_VERSION_MIUI))) && !_hc._b()) {
                        if (_hc._j()) {
                            return new _m3(context);
                        }
                        if (_hc._e()) {
                            return new _g4(context);
                        }
                        if (_hc._g()) {
                            return new _ha(context);
                        }
                        if (_hc._a()) {
                            return new _a(context);
                        }
                        if (_hc._d() || _hc._f()) {
                            return new _fo(context);
                        }
                        boolean z = false;
                        try {
                            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
                            z = true;
                        } catch (Exception unused) {
                        }
                        if (z) {
                            return new _bs(context);
                        }
                        if (_hc._a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE")) {
                            return new _bt(context);
                        }
                        if (!TextUtils.isEmpty(_hc._a("ro.build.freeme.label"))) {
                            return new _dv(context);
                        }
                        return new _c5();
                    }
                    return new _ol(context);
                }
                return new _he(context);
            }
            return new _e5(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String getManufacturer() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static void getOAid(Context context, _a3 _a3Var) {
        try {
            Logger.d("OaidHelperTag", "[MyOaidHelper] manufacturer = " + getManufacturer().toUpperCase());
            createOaidGetter(context)._a(_a3Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
