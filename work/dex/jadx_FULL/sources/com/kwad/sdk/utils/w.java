package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class w {
    public static String bo(Context context) {
        return hE("curversion");
    }

    private static String hE(String str) {
        return bq.i("kssdk_api_pref", str, "");
    }
}
