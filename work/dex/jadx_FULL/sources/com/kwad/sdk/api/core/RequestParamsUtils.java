package com.kwad.sdk.api.core;

import android.text.TextUtils;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-5.4.10.2";
        }
        return sUserAgent;
    }

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append(c49.f40900a);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
