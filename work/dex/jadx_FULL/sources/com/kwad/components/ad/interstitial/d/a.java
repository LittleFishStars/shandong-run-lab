package com.kwad.components.ad.interstitial.d;

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
    public long mC = -1;
    public int mD = 0;

    public static void L(Context context) {
        String strVn = ai.Vn();
        a aVar = new a();
        if (TextUtils.isEmpty(strVn)) {
            aVar.mD = 1;
            aVar.mC = System.currentTimeMillis();
            ai.an(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strVn));
            if (b(aVar.mC, System.currentTimeMillis())) {
                aVar.mD++;
            } else {
                aVar.mD = 1;
                aVar.mC = System.currentTimeMillis();
            }
            ai.an(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return kc.format(new Date(j)).equals(kc.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int dX() {
        String strVn = ai.Vn();
        if (TextUtils.isEmpty(strVn)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strVn));
            if (b(aVar.mC, System.currentTimeMillis())) {
                return aVar.mD;
            }
            return 0;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }
}
