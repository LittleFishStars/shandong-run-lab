package com.byazt.ogz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 66})
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28867a;
    public int c;
    public int i;
    public int n;
    public int sp;
    public int tt;
    public int uj;
    public int ve;
    public int x;

    public static t c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        t tVar = new t();
        try {
            JSONObject jSONObject = new JSONObject(str);
            tVar.c = jSONObject.optInt(MediationConstant.RIT_TYPE_BANNER);
            tVar.tt = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH);
            tVar.ve = jSONObject.optInt("rewarded");
            tVar.uj = jSONObject.optInt(MediationConstant.RIT_TYPE_FEED);
            tVar.n = jSONObject.optInt(MediationConstant.RIT_TYPE_DRAW);
            tVar.f28867a = jSONObject.optInt("full_screen");
            tVar.sp = jSONObject.optInt("slide_move_max_num", 5);
            tVar.x = jSONObject.optInt("motion_max_num", 300);
            tVar.i = jSONObject.optInt("sensor_interval", 3);
        } catch (Throwable unused) {
        }
        return tVar;
    }

    private boolean c(int i, int i2) {
        return (i & i2) == i2;
    }

    private int uj(int i) {
        switch (i) {
            case 1:
                return this.c;
            case 2:
            case 6:
            default:
                return 0;
            case 3:
            case 4:
                return this.tt;
            case 5:
                return this.uj;
            case 7:
                return this.ve;
            case 8:
            case 10:
                return this.f28867a;
            case 9:
                return this.n;
        }
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.RIT_TYPE_BANNER, this.c);
            jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, this.tt);
            jSONObject.put("rewarded", this.ve);
            jSONObject.put(MediationConstant.RIT_TYPE_FEED, this.uj);
            jSONObject.put(MediationConstant.RIT_TYPE_DRAW, this.n);
            jSONObject.put("full_screen", this.f28867a);
            jSONObject.put("slide_move_max_num", this.sp);
            jSONObject.put("motion_max_num", this.x);
            jSONObject.put("sensor_interval", this.i);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return super.toString();
        }
    }

    public boolean tt(int i) {
        return c(uj(i), 1);
    }

    public boolean ve(int i) {
        return c(uj(i), 4);
    }

    public int tt() {
        return this.x;
    }

    public int ve() {
        int i = this.i;
        if (i < 0 || i > 3) {
            return 3;
        }
        return i;
    }

    public boolean c(int i) {
        return c(uj(i), 2);
    }

    public int c() {
        return this.sp;
    }
}
