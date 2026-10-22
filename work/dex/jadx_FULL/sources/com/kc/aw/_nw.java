package com.kc.aw;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nw {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static final AtomicInteger _b = new AtomicInteger(0);
    public static volatile String _c = "";

    @Keep
    public interface _a {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.kc.aw._nw._c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        if (android.text.TextUtils.isEmpty(com.kc.aw._nw._c) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(com.kc.aw._nw._c) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String _a(Context context) {
        if (context != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    if (defaultUserAgent != null) {
                        return defaultUserAgent;
                    }
                } catch (Exception unused) {
                }
            }
            return "";
        }
    }

    public static void _a(_a _aVar, String str) {
        if (_aVar != null) {
            if (str == null) {
                str = "";
            }
            try {
                _c9 _c9Var = ((_nu) _aVar)._a;
                if (_c9Var != null) {
                    _c9Var._z = TextUtils.isEmpty(str) ? "" : str;
                }
            } catch (Exception unused) {
            }
        }
    }
}
