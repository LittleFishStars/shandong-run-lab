package com.byazt.vd;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 15})
public class uj extends c {
    public uj(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        com.byazt.xj.ve veVar;
        com.byazt.xj.ve veVarTt;
        com.byazt.xj.ve veVarA;
        com.byazt.rb.c cVarDa;
        Map<String, Object> map = this.f29129a;
        if (map == null || map.size() <= 0 || (obj = this.f29129a.get("name")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = (veVar = this.ve).tt(veVar)) == null || (veVarA = veVarTt.a(strValueOf)) == null || (cVarDa = veVarA.da(strValueOf)) == null) {
            return;
        }
        cVarDa.tt();
        cVarDa.c(new com.byazt.rb.tt() { // from class: com.byazt.vd.uj.1
            @Override // com.byazt.rb.tt
            public void c() {
            }

            @Override // com.byazt.rb.tt
            public void tt() {
                uj.this.ve();
            }
        });
    }

    @Override // com.byazt.vd.c
    public void tt() {
    }
}
