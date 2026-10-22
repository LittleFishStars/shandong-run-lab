package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.encrypt.LiteKsSig1Util;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f {
    public static void a(String str, Map<String, String> map, String str2) {
        map.put(LiteKsSig1Util.PARAM_SIGNATURE, eG(generateInputString(str, str2)));
    }

    private static String eG(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String strDoSign = com.kwad.sdk.core.f.c.doSign(context, str);
                return strDoSign == null ? "" : strDoSign;
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String generateInputString(String str, String str2) {
        Uri uri = Uri.parse(str);
        return uri.getPath() + "&" + getSortedQuery(uri.getQuery()) + "&" + str2;
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] strArrSplit = str.split("&");
        Arrays.sort(strArrSplit);
        return TextUtils.join("&", strArrSplit);
    }
}
