package com.byazt.da;

import android.text.TextUtils;
import com.byazt.hz.sp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 72, 15})
public class uj extends com.byazt.pbu.c {
    public sp c;

    public uj(sp spVar) {
        this.c = spVar;
    }

    public void loadByAdm(String str, final com.byazt.nh.tt ttVar) {
        sp spVar;
        if (TextUtils.isEmpty(str) || (spVar = this.c) == null || ttVar == null) {
            com.byazt.eu.tt.uj("TMe", "adm 参数错误 或者 drawTokenInfo is null");
        } else {
            spVar.c(str, new com.byazt.fy.tt() { // from class: com.byazt.da.uj.1
                @Override // com.byazt.fy.tt
                public void c(List<com.byazt.yl.ve> list) {
                    if (list == null) {
                        ttVar.c(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.byazt.yl.ve veVar : list) {
                        if (veVar != null) {
                            arrayList.add(new c(uj.this.c, veVar, uj.this.c.my()));
                        }
                    }
                    ttVar.c(arrayList);
                }

                @Override // com.byazt.fy.tt
                public void c(com.byazt.pp.c cVar) {
                    if (cVar != null) {
                        ttVar.c(cVar.c, cVar.tt);
                    }
                }
            });
        }
    }

    @Override // com.byazt.pbu.c
    public void loadDrawAdByAdm(String str, com.byazt.nh.tt ttVar) {
        loadByAdm(str, ttVar);
    }
}
