package com.kwad.components.core.t;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class u {
    @NonNull
    public static Map<String, String> a(@NonNull Uri uri) {
        HashMap map = new HashMap();
        Set<String> setB = b(uri);
        if (!com.kwad.sdk.crash.utils.c.b(setB)) {
            for (String str : setB) {
                if (!TextUtils.isEmpty(str)) {
                    String strA = a(uri, str);
                    if (!TextUtils.isEmpty(strA)) {
                        map.put(str, strA);
                    }
                }
            }
        }
        return map;
    }

    private static Set<String> b(Uri uri) {
        try {
            return uri.getQueryParameterNames();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("SafetyUriUtil", "getQueryParameterNamesFromUri", th);
            th.printStackTrace();
            return null;
        }
    }

    private static String a(Uri uri, String str) {
        return a(uri, str, null);
    }

    public static String a(Uri uri, String str, String str2) {
        try {
            String queryParameter = uri.getQueryParameter(str);
            return TextUtils.isEmpty(queryParameter) ? str2 : queryParameter;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("SafetyUriUtil", "getQueryParameterFromUri", th);
            th.printStackTrace();
            return str2;
        }
    }
}
