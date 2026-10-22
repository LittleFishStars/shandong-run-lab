package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ai;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat kc = new SimpleDateFormat("yyyy-MM-dd");
    public long kd = -1;
    public int mA = 0;
    public int mB = 0;

    public static void J(Context context) {
        String strVj = ai.Vj();
        b bVar = new b();
        if (TextUtils.isEmpty(strVj)) {
            bVar.mA = 1;
            bVar.kd = System.currentTimeMillis();
            ai.ai(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strVj));
            if (b(bVar.kd, System.currentTimeMillis())) {
                bVar.mA++;
            } else {
                bVar.mA = 1;
                bVar.mB = 0;
                bVar.kd = System.currentTimeMillis();
            }
            ai.ai(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static void K(Context context) {
        String strVj = ai.Vj();
        b bVar = new b();
        if (TextUtils.isEmpty(strVj)) {
            bVar.mB = 1;
            bVar.kd = System.currentTimeMillis();
            ai.ai(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strVj));
            if (b(bVar.kd, System.currentTimeMillis())) {
                bVar.mB++;
            } else {
                bVar.mB = 1;
                bVar.mA = 0;
                bVar.kd = System.currentTimeMillis();
            }
            ai.ai(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return kc.format(new Date(j)).equals(kc.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static int dV() {
        String strVj = ai.Vj();
        if (TextUtils.isEmpty(strVj)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strVj));
            return bVar.mA;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int dW() {
        String strVj = ai.Vj();
        if (TextUtils.isEmpty(strVj)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strVj));
            return bVar.mB;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }
}
