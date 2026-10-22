package com.byazt.ouc;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.atv.n;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 162, 54})
public class ve extends n {
    public ve(Context context, ic icVar, com.byazt.atv.tt ttVar, ViewGroup viewGroup) {
        super(context, icVar, ttVar, viewGroup);
    }

    private JSONObject rh() {
        try {
            return new JSONObject(c.c(this.f28298a, this.sp).c(this.f28298a));
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    @Override // com.byazt.atv.n
    public JSONObject c() {
        return rh();
    }

    @Override // com.byazt.atv.n, com.byazt.xl.uj
    public int ve() {
        return 8;
    }
}
