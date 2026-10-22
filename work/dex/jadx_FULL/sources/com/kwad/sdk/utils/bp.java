package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bp {
    public static void WA() {
        ai.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean WB() {
        return ai.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void WC() {
        ai.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean WD() {
        return ai.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static boolean Wy() {
        return ai.m("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void Wz() {
        ai.l("ksadsdk_pref", "config_data_transfer", true);
    }

    @Nullable
    @WorkerThread
    public static String aE(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String strJ = com.kwad.sdk.crash.utils.h.J(file);
            return TextUtils.isEmpty(strJ) ? "" : strJ;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(final Context context, final String str, final String str2) {
        i.execute(new bi() { // from class: com.kwad.sdk.utils.bp.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                bp.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        if (context != null) {
            com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
            Wz();
        }
    }
}
