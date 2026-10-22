package com.byazt.wee;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.omf.gt;
import com.byazt.qqc.ve;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1009, 13})
public class tt extends com.byazt.qqc.c {
    public double tt;
    public String ve;
    public final String uj = "xgc_prop_volume";
    public volatile int n = -2;
    public c c = new c(gt.getContext());

    public int a() {
        return (int) ve.c().a();
    }

    public void c(double d) {
        this.tt = d;
    }

    public int n() {
        return this.n;
    }

    public int sp() {
        int iA = a();
        int iTt = this.c.tt() - this.c.c();
        if (iTt != 0) {
            return Math.round((iA * 100.0f) / iTt);
        }
        return -1;
    }

    public void tt(double d) {
        int iTt = this.c.tt();
        int iC = this.c.c();
        int i = (int) d;
        if (d < iTt) {
            iTt = d <= ((double) iC) ? iC : i;
        }
        this.n = iTt;
        this.c.c(iTt);
    }

    @Override // com.byazt.qqc.c
    public JSONObject uj() {
        return gt.tt().mm();
    }

    @Override // com.byazt.qqc.c
    public boolean ve() {
        int iSp = sp();
        return iSp >= 94 || iSp <= 6;
    }

    public void c(String str) {
        this.ve = str;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019 A[PHI: r7
      0x0019: PHI (r7v2 double) = (r7v0 double), (r7v1 double) binds: [B:8:0x0017, B:11:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.qqc.c
    public boolean c(int i) {
        double dC;
        JSONObject jSONObjectUj = uj();
        if (jSONObjectUj == null) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                dC = c(jSONObjectUj);
            }
            return false;
        }
        dC = jSONObjectUj.optDouble("value", AudioStats.AUDIO_AMPLITUDE_NONE);
        double d = -1.0d;
        if (dC <= -1.0d) {
            dC = d;
        } else {
            d = 1.0d;
            if (dC >= 1.0d) {
                dC = d;
            }
        }
        if (dC != AudioStats.AUDIO_AMPLITUDE_NONE && dC != -2.0d) {
            tt(((double) a()) + (((double) (this.c.tt() - this.c.c())) * dC));
            return true;
        }
        return false;
    }

    @Override // com.byazt.qqc.c
    public void tt(int i) {
        float fA = ve.c().a();
        if (fA != -2.0f) {
            int iTt = this.c.tt();
            int iC = this.c.c();
            int i2 = (int) fA;
            if (fA < iTt) {
                iTt = fA <= ((float) iC) ? iC : i2;
            }
            this.n = iTt;
            this.c.c(iTt);
        }
    }

    private double c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -2.0d;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("applist");
        return com.byazt.qqc.c.c(((((double) (jSONArrayOptJSONArray != null && !TextUtils.isEmpty(this.ve) && jSONArrayOptJSONArray.toString().contains(this.ve) ? 1 : -1)) * jSONObject.optDouble("content_factor", AudioStats.AUDIO_AMPLITUDE_NONE)) + (((double) (this.tt >= 10.0d ? 1 : -1)) * jSONObject.optDouble("duration_factor", AudioStats.AUDIO_AMPLITUDE_NONE)) + (((double) (com.byazt.qqc.tt.tt() ? 1 : -1)) * jSONObject.optDouble("night_factor", AudioStats.AUDIO_AMPLITUDE_NONE)) + (jSONObject.optDouble("week_factor", AudioStats.AUDIO_AMPLITUDE_NONE) * ((double) (com.byazt.qqc.tt.c() ? 1 : -1))) + (((double) (this.c.uj() ? 1 : -1)) * jSONObject.optDouble("headset_factor", AudioStats.AUDIO_AMPLITUDE_NONE))) * jSONObject.optDouble("factor", AudioStats.AUDIO_AMPLITUDE_NONE), jSONObject);
    }

    @Override // com.byazt.qqc.c
    public boolean tt() {
        return ve.c().uj();
    }
}
