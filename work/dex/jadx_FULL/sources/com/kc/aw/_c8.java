package com.kc.aw;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kc.aw.lib.PtgAdSdk;
import com.kuaishou.weapon.p0.an;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c8 extends AsyncTask<Void, Void, String> {
    public String _a;

    public _c8(String str) {
        this._a = str;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00b1  */
    public static HashMap _a(Context context) throws Throwable {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        double d;
        double d2;
        _dz _dzVar;
        HashMap map = new HashMap();
        boolean z_b = _as._b(context);
        int i_a = _as._a(context);
        int i_a2 = _h2._a(context);
        boolean z_b2 = _cb._b(context);
        _cc._c();
        boolean z5 = _cc._e;
        if (_o7._b == null) {
            synchronized (_o7.class) {
                try {
                    if (_o7._b == null) {
                        _o7._b = new _o7();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        _o7 _o7Var = _o7._b;
        if (TextUtils.isEmpty(_a5._d)) {
            try {
                Context context2 = PtgAdSdk.getContext();
                if (context2 != null) {
                    _a5._d = context2.getPackageName();
                }
            } catch (Exception unused) {
            }
        }
        String str = _a5._d;
        if (_o7Var._a == null) {
            try {
                _o7Var._a = new LocalServerSocket(str);
            } catch (IOException unused2) {
                z = true;
            }
        }
        z = false;
        try {
            ClassLoader.getSystemClassLoader().loadClass(an.f40039a).newInstance();
            ClassLoader.getSystemClassLoader().loadClass(an.b).newInstance();
        } catch (ClassNotFoundException unused3) {
            z2 = false;
        } catch (IllegalAccessException | InstantiationException unused4) {
        }
        z2 = true;
        String str2 = Build.TAGS;
        if (!(str2 != null && str2.contains("test-keys"))) {
            try {
                String[] strArr = _ly._a;
                int i = 0;
                while (true) {
                    if (i >= 10) {
                        z3 = false;
                        break;
                    }
                    if (new File(strArr[i]).exists()) {
                        z3 = true;
                        break;
                    }
                    i++;
                }
            } catch (Exception unused5) {
            }
            z4 = z3 || _ly._a();
        }
        boolean z_a = _di._a(context);
        String str_a = _cb._a();
        _c9 _c9Var_b = _cc._b();
        if (_c9Var_b == null || (_dzVar = _c9Var_b._m) == null) {
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
            d2 = 0.0d;
        } else {
            d = _dzVar._a;
            d2 = _dzVar._b;
        }
        map.put("isChrg", String.valueOf(z_b));
        map.put("battPct", String.valueOf(i_a));
        map.put("netTyp", String.valueOf(i_a2));
        map.put("hasSim", String.valueOf(z_b2));
        map.put("devMod", String.valueOf(z5));
        map.put("spnMod", String.valueOf(z));
        map.put("xpdMod", String.valueOf(z2));
        map.put("rttMod", String.valueOf(z4));
        map.put("emlMod", String.valueOf(z_a));
        map.put("lat", String.valueOf(d));
        map.put("lon", String.valueOf(d2));
        map.put("srvPkg", str_a);
        return map;
    }

    @Override // android.os.AsyncTask
    public final String doInBackground(Void[] voidArr) {
        try {
            Context context = PtgAdSdk.getContext();
            if (context == null) {
                return "";
            }
            new _e2(context, new _c7(this, _a(context)))._a();
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(String str) {
        super.onPostExecute(str);
    }
}
