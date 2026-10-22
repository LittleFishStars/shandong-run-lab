package com.byazt.wy;

import android.content.Context;
import com.byazt.cd.x;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1540, 20})
public class c extends ve<UGProgressBar> {
    public int c;
    public int kz;
    public float mq;
    public float vi;
    public String vp;
    public int yo;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UGProgressBar c() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.tt);
        uGProgressBar.c(this);
        return uGProgressBar;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((UGProgressBar) this.n).setBackgroundColor(this.yo);
        ((UGProgressBar) this.n).setText(this.vp);
        ((UGProgressBar) this.n).setProgressBgColor(this.yo);
        ((UGProgressBar) this.n).setProgressColor(this.c);
        ((UGProgressBar) this.n).setTextColor(this.kz);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.yo = com.byazt.cd.c.c(str2);
                break;
            case "textColor":
                this.kz = com.byazt.cd.c.c(str2);
                break;
            case "textSize":
                this.vi = x.c(this.tt, str2);
                break;
            case "progress":
                this.mq = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case "text":
                this.vp = str2;
                break;
            case "progressColor":
                this.c = com.byazt.cd.c.c(str2);
                break;
        }
    }
}
