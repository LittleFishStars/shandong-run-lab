package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ai;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat kc = new SimpleDateFormat("yyyy-MM-dd");
    public long mC = -1;
    public int mD = 0;

    public static void L(Context context) {
        String strVm = ai.Vm();
        b bVar = new b();
        if (TextUtils.isEmpty(strVm)) {
            bVar.mD = 1;
            bVar.mC = System.currentTimeMillis();
            ai.am(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strVm));
            if (b(bVar.mC, System.currentTimeMillis())) {
                bVar.mD++;
            } else {
                bVar.mD = 1;
                bVar.mC = System.currentTimeMillis();
            }
            ai.am(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return kc.format(new Date(j)).equals(kc.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return false;
    }

    public static int dX() {
        String strVm = ai.Vm();
        if (TextUtils.isEmpty(strVm)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strVm));
            if (b(bVar.mC, System.currentTimeMillis())) {
                return bVar.mD;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
