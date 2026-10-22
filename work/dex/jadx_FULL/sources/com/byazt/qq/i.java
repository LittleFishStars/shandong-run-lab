package com.byazt.qq;

import android.app.Activity;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.ete.yv;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 42})
public class i extends c {
    public String nu;

    public i(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
        yv yvVarKn = this.sp.kn();
        if (yvVarKn != null) {
            this.nu = yvVarKn.c();
        }
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        String str = this.nu;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.nu)) ? false : true;
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.nu);
            boolean z = false;
            try {
                if (Double.parseDouble(this.nu) != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 5;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }
}
