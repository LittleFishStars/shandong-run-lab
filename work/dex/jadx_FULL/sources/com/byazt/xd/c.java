package com.byazt.xd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.cd.x;
import com.hzchengdun.securityguard.SecExceptionCode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 520, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29174a;
    public com.byazt.cd.c.C0376c c;
    public tt i;
    public com.byazt.cd.c.C0376c n;
    public float sp;
    public com.byazt.cd.c.C0376c tt;
    public int uj;
    public int ve;
    public int x;

    public void c(String str) {
        if (com.byazt.cd.c.ve(str)) {
            this.c = com.byazt.cd.c.tt(str);
        }
    }

    public void tt(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.cd.c.ve(strOptString)) {
                return;
            }
            this.tt = com.byazt.cd.c.tt(strOptString);
            this.ve = jSONObject.optInt("duration", SecExceptionCode.SEC_ERROR_LBSRISK);
            this.uj = jSONObject.optInt("playCount", -1);
        } catch (JSONException unused) {
        }
    }

    public void uj() {
        tt ttVar = this.i;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    public void ve() {
        tt ttVar = this.i;
        if (ttVar == null || !ttVar.ve()) {
            return;
        }
        this.i.c();
    }

    public void c(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.cd.c.ve(strOptString)) {
                return;
            }
            this.n = com.byazt.cd.c.tt(strOptString);
            this.f29174a = x.c(context, (float) jSONObject.optDouble("width", 76.0d));
            this.sp = (float) jSONObject.optDouble("opacity", 0.9d);
            this.x = jSONObject.optInt("steps", 24);
        } catch (JSONException unused) {
        }
    }

    public boolean tt() {
        return (this.c == null && this.tt == null && this.n == null) ? false : true;
    }

    public boolean c() {
        return (this.c == null && this.tt == null) ? false : true;
    }

    public void c(View view, Drawable drawable, float f, float[] fArr) {
        int[] iArr;
        float[] fArr2;
        float[] fArr3;
        boolean z = c() && f > 0.0f;
        com.byazt.cd.c.C0376c c0376c = this.n;
        boolean z2 = c0376c != null;
        if (!z && !z2) {
            this.i = null;
            view.setBackground(drawable);
            return;
        }
        if (z) {
            com.byazt.cd.c.C0376c c0376c2 = this.tt;
            if (c0376c2 != null) {
                iArr = c0376c2.tt;
                fArr3 = c0376c2.ve;
            } else {
                com.byazt.cd.c.C0376c c0376c3 = this.c;
                iArr = c0376c3.tt;
                fArr3 = c0376c3.ve;
            }
            fArr2 = fArr3;
        } else {
            iArr = null;
            fArr2 = null;
        }
        tt ttVar = new tt(drawable, iArr, fArr2, f, fArr, this.tt != null, this.ve, this.uj, z2, this.f29174a, this.sp, this.x, z2 ? c0376c.tt : null, z2 ? c0376c.ve : null);
        this.i = ttVar;
        view.setBackground(ttVar);
    }
}
