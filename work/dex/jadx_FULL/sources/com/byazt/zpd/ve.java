package com.byazt.zpd;

import com.byazt.bwm.sp;
import com.byazt.nr.zm;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1919, 54})
public class ve extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public zm c() {
        zm zmVar = new zm(gt.getContext(), 1, x.m().uj());
        boolean zC = zmVar.c(0);
        c(zC ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            zmVar.tt(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.byazt.pf.c.c().tt() > c(i)) {
            com.byazt.bzd.x.c(new sp("reg_sensor") { // from class: com.byazt.zpd.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.c();
                }
            });
        }
    }
}
