package com.byazt.jw;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.pm.a;
import com.byazt.xj.ve;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1216, 20})
public class c extends com.byazt.vd.c {
    public c(ve veVar, String str, a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        ve veVar;
        ve veVarTt;
        int i;
        Map<String, Object> map = this.f29129a;
        if (map == null || map.size() <= 0 || (obj = this.f29129a.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = (veVar = this.ve).tt(veVar)) == null) {
            return;
        }
        ve veVarUj = veVarTt.uj(strValueOf);
        if (veVarUj instanceof com.byazt.yn.c) {
            com.byazt.yn.c cVar = (com.byazt.yn.c) veVarUj;
            int i2 = 4;
            int i3 = 3;
            try {
                i2 = Integer.parseInt(String.valueOf(this.f29129a.get("col")));
                i3 = Integer.parseInt(String.valueOf(this.f29129a.get("row")));
                i = Integer.parseInt(String.valueOf(this.f29129a.get("duration")));
            } catch (Exception e) {
                m.c(e);
                i = 600;
            }
            cVar.c(i2, i3, i);
        }
    }
}
