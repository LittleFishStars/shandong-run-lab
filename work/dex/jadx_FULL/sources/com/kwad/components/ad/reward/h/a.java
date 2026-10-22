package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static long vL = -1;
    public static int vM;

    public static void J(Context context) {
        b bVar = new b();
        if (m(System.currentTimeMillis())) {
            vM++;
        } else {
            vM = 1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        vL = jCurrentTimeMillis;
        bVar.vN = vM;
        bVar.kd = jCurrentTimeMillis;
        ai.ak(context, bVar.toJson().toString());
    }

    public static int dV() {
        if (!m(System.currentTimeMillis())) {
            vM = 0;
        }
        return vM;
    }

    private static long ir() {
        long j = vL;
        if (j != -1) {
            return j;
        }
        String strVk = ai.Vk();
        if (TextUtils.isEmpty(strVk)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strVk));
            vL = bVar.kd;
            vM = bVar.vN;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return vL;
    }

    private static boolean m(long j) {
        return ir() > 0 && j > 0 && ir() / 2460601000L == j / 2460601000L;
    }
}
