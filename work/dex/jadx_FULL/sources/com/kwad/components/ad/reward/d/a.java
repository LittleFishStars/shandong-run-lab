package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static void S(@NonNull Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strDt = ai.dt(context);
        int i = 0;
        if (!TextUtils.isEmpty(strDt)) {
            try {
                bVar.parseJson(new JSONObject(strDt));
                if (b(bVar.kd, jCurrentTimeMillis)) {
                    i = bVar.vn;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        bVar.kd = jCurrentTimeMillis;
        bVar.vn = i + 1;
        ai.aj(context, bVar.toJson().toString());
    }

    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    private static void c(@NonNull Context context, int i) {
        int iDs = ai.ds(context);
        if (iDs % i == 0) {
            ai.m(context, 1);
        } else {
            ai.m(context, iDs + 1);
        }
    }

    private static boolean d(@NonNull Context context, int i) {
        return i != 0 && ai.ds(context) % i == 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    private static boolean e(@NonNull Context context, int i) {
        int i2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String strDt = ai.dt(context);
        if (TextUtils.isEmpty(strDt)) {
            i2 = 0;
        } else {
            try {
                bVar.parseJson(new JSONObject(strDt));
                if (b(bVar.kd, jCurrentTimeMillis)) {
                    i2 = bVar.vn;
                } else {
                    i2 = 0;
                }
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return i2 < i;
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.helper.a.aM(adInfo)) {
            return false;
        }
        int iMax = Math.max(com.kwad.sdk.core.response.helper.a.aN(adInfo) + 1, 1);
        boolean zD = d(context, iMax);
        c(context, iMax);
        return zD && e(context, com.kwad.sdk.core.response.helper.a.aO(adInfo));
    }
}
