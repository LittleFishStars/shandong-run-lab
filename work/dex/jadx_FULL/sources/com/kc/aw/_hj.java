package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hj {
    public static String _a(_h _hVar) {
        return _hVar != null ? _hVar._u : "";
    }

    public static String _a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return str;
        }
        if (!str.contains("?")) {
            str = str + "?";
        }
        if (str.endsWith("&")) {
            str = str.substring(0, str.length() - 1);
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(com.kc.aw.lib.utils._a._b(entry.getValue()));
        }
        return sb.toString();
    }
}
