package com.kwad.components.ad.splashscreen.local;

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
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat kc = new SimpleDateFormat("yyyy-MM-dd");
    public long kd = 0;
    public int ke = 0;

    public static void V(Context context) {
        String strVl = ai.Vl();
        a aVar = new a();
        if (TextUtils.isEmpty(strVl)) {
            aVar.ke = 1;
            aVar.kd = System.currentTimeMillis();
            ai.al(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strVl));
            if (b(aVar.kd, System.currentTimeMillis())) {
                aVar.ke++;
            } else {
                aVar.ke = 1;
            }
            aVar.kd = System.currentTimeMillis();
            ai.al(context, aVar.toJson().toString());
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
}
