package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class b {
    private static final String[] bup = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    public static String A(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static boolean iJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }
}
