package com.byazt.hc;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.qq.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1504, 20})
public abstract class c extends com.byazt.qq.tt {
    public String c;

    public c(Activity activity, ic icVar) {
        super(activity, icVar);
    }

    public void c(String str) {
        this.c = str;
    }

    public c(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.tt
    public com.byazt.qq.tt.c c(da daVar) {
        uj ujVar = new uj(this.x, this.sp);
        ujVar.uj(this.sl);
        ujVar.ve(this.t);
        ujVar.tt(this.z);
        ujVar.c(this.c);
        return ujVar.c(daVar);
    }
}
