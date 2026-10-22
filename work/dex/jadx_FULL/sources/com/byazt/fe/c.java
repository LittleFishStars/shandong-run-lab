package com.byazt.fe;

import android.content.Context;
import android.graphics.Color;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1154, 20})
public class c extends ve<UGRatingBar> {
    public int c;
    public float kz;
    public float vi;
    public float vp;
    public int yo;
    public static final int mq = Color.parseColor("#FFC642");
    public static final int cf = Color.parseColor("#e3e3e4");

    public c(Context context) {
        super(context);
        this.c = mq;
        this.yo = cf;
        this.vp = 4.0f;
        this.kz = 20.0f;
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UGRatingBar c() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.tt);
        uGRatingBar.c(this);
        return uGRatingBar;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        if (h()) {
            ((UGRatingBar) this.n).c(this.vp, this.c, this.yo, this.kz, (int) this.vi);
        } else {
            ((UGRatingBar) this.n).c(this.vp, this.c, this.yo, this.kz, 5);
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.c = com.byazt.cd.c.c(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.yo = com.byazt.cd.c.c(str2, cf);
                break;
            case "gap":
                this.vi = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case "size":
                this.kz = com.byazt.cd.ve.c(str2, 20.0f);
                break;
            case "score":
                this.vp = com.byazt.cd.ve.c(str2, 4.0f);
                break;
        }
    }
}
