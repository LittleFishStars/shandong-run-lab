package com.byazt.ukr;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 46})
public class n {
    public static boolean c(String str, double d) {
        JSONObject jSONObjectHq = gt.tt().hq();
        if (jSONObjectHq != null && !TextUtils.isEmpty(str)) {
            try {
                double dOptDouble = jSONObjectHq.optDouble(str, d);
                if (dOptDouble >= 1.0d || dOptDouble < AudioStats.AUDIO_AMPLITUDE_NONE || com.byazt.ddx.ve.c.contains(str)) {
                    return true;
                }
                return com.byazt.ktv.tt.c((float) dOptDouble, false);
            } catch (Throwable th) {
                m.ve("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
