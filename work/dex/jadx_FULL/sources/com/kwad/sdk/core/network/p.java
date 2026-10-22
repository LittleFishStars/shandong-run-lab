package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public final class p {
    private static String aTX = "";
    private static String aTY = "";

    public static String Mh() {
        try {
            if (!TextUtils.isEmpty(aTX)) {
                return aTX;
            }
            String property = System.getProperty("http.agent");
            aTX = property;
            if (TextUtils.isEmpty(property)) {
                return aTX;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aTX.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = aTX.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
            String string = stringBuffer.toString();
            aTX = string;
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Mi() {
        if (!TextUtils.isEmpty(aTY)) {
            return aTY;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            String strDv = ai.dv(context);
            aTY = strDv;
            if (!TextUtils.isEmpty(strDv)) {
                return aTY;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            aTY = defaultUserAgent;
            String strEncode = URLEncoder.encode(defaultUserAgent, "UTF-8");
            aTY = strEncode;
            ai.ar(context, strEncode);
            return aTY;
        } catch (Exception unused) {
        }
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", Mi());
        httpURLConnection.setRequestProperty("SystemUa", Mh());
    }

    private static String getDefaultUserAgent() {
        return Mh() + "-ksad-android-5.4.10.2";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }
}
