package com.alibaba.triver.kit.api.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class URLUtils {
    private static final String TAG = "URLUtils";

    public static Map<String, String> getUrlParams(String str, boolean z) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (z) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
        }
        try {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length < 2) {
                return map;
            }
            for (String str2 : strArrSplit[1].split("&")) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2.length >= 2) {
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(TAG, "parse URL param error " + e2.getMessage());
        }
        return map;
    }

    public static Map<String, String> getUrlParams(String str) {
        return getUrlParams(str, false);
    }
}
