package com.byazt.te;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.sm.UGTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 14, 20})
public class c extends com.byazt.sm.tt {
    public String kz;
    public String vi;
    public String vp;

    public c(Context context) {
        super(context);
    }

    public void c(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.vp)) {
            String str = this.vp;
            ((com.byazt.sm.tt) this).c = str;
            sl(str);
            return;
        }
        if (TextUtils.isEmpty(this.vi) || TextUtils.equals(this.vi, "null")) {
            this.vi = "";
        }
        if (TextUtils.isEmpty(this.kz) || TextUtils.equals(this.kz, "null")) {
            this.kz = "";
        }
        String str2 = this.kz + i + this.vi;
        ((com.byazt.sm.tt) this).c = str2;
        sl(str2);
    }

    public void sl(String str) {
        ((UGTextView) this.n).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.n).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                uj((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void tt() {
        super.tt();
        if (TextUtils.isEmpty(this.vi) || TextUtils.equals(this.vi, "null")) {
            this.vi = "";
        }
        if (TextUtils.isEmpty(this.kz) || TextUtils.equals(this.kz, "null")) {
            this.kz = "";
        }
        String str = this.kz + this.vi;
        ((com.byazt.sm.tt) this).c = str;
        sl(str);
        ((UGTextView) this.n).setGravity(17);
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "before":
                this.kz = str2;
                break;
            case "finish":
                this.vp = str2;
                break;
            case "after":
                this.vi = str2;
                break;
        }
    }
}
