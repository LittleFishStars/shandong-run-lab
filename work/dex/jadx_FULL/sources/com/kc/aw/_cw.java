package com.kc.aw;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.byazt.tk.AdBaseConstants;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cw {
    public final Pattern _a = Pattern.compile(".*\\.apk(\\?.*)?$", 2);

    @Keep
    public interface _a {
    }

    public _cw(String str, _d6 _d6Var) {
        Logger.d("PTG_QM_TAG cut-0");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Handler handler = new Handler(Looper.getMainLooper());
        _cu _cuVar = new _cu(this, atomicBoolean, _d6Var);
        handler.postDelayed(_cuVar, 3000L);
        com.kc.aw.lib.utils._d._b(new _cv(this, str, atomicBoolean, handler, _cuVar, _d6Var));
    }

    public static long _a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getContentLengthLong();
        } catch (Exception unused) {
            return httpURLConnection.getContentLength();
        }
    }

    public static void _a(_cw _cwVar, _a _aVar, int i, int i2, String str) {
        _cwVar.getClass();
        _ct _ctVar = new _ct(_aVar, i, i2, str);
        _fz _fzVar = _fz._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _ctVar.run();
        } else {
            _fz._a.post(_ctVar);
        }
    }

    public static boolean _a(long j, String str, String str2) {
        boolean z = AdBaseConstants.MIME_APK.equals(str) || OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE.equals(str);
        boolean z2 = str2 != null && str2.toLowerCase().contains("attachment");
        boolean z3 = j > 1048576;
        if (z) {
            return true;
        }
        return z2 && z3;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    public static boolean _a(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
            }
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.contains("text/html") && !lowerCase.contains("application/xhtml+xml") && !lowerCase.contains("text/xml")) {
            if (str2 != null || str2.toLowerCase().contains("attachment")) {
                return false;
            }
        }
        return true;
    }
}
