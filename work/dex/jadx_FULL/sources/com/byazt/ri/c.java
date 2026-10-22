package com.byazt.ri;

import android.content.Context;
import com.byazt.lt.tt;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsNextDownloadThreshold, 20})
public class c {
    public static int c = 10;
    public static com.byazt.fk.c n = null;
    public static int tt = 10;
    public static int uj = 10;
    public static int ve = 10;

    public static void c(Context context) {
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            c = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            tt = jSONObject.optInt("reward", 10);
            ve = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt("other", 10);
            uj = iOptInt;
            if (c < 0) {
                c = 10;
            }
            if (tt < 0) {
                tt = 10;
            }
            if (ve < 0) {
                ve = 10;
            }
            if (iOptInt < 0) {
                uj = 10;
            }
            tt.c("MediaConfig", "splash=", Integer.valueOf(c), ",reward=", Integer.valueOf(tt), ",brand=", Integer.valueOf(ve), ",other=", Integer.valueOf(uj));
        } catch (Throwable th) {
            tt.ve("MediaConfig", th.getMessage());
        }
    }

    public static int n() {
        return uj;
    }

    public static int tt() {
        return c;
    }

    public static int uj() {
        return ve;
    }

    public static int ve() {
        return tt;
    }

    public static void c(com.byazt.fk.c cVar) {
        n = cVar;
    }

    public static void c() {
        com.byazt.fk.c cVar = n;
        if (cVar != null) {
            cVar.clearCache();
        }
    }
}
