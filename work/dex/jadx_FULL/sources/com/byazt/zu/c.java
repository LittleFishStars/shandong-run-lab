package com.byazt.zu;

import android.text.TextUtils;
import com.byazt.hz.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 919, 20})
public class c extends com.byazt.pbu.tt {
    public i c;

    public c(i iVar) {
        this.c = iVar;
    }

    public void loadAdByAdm(String str, final com.byazt.nh.ve veVar) {
        i iVar;
        if (TextUtils.isEmpty(str) || (iVar = this.c) == null || veVar == null) {
            com.byazt.eu.tt.uj("TMe", "adm 参数错误 或者 nativeAdManager is null");
        } else {
            iVar.c(str, new com.byazt.me.uj() { // from class: com.byazt.zu.c.1
                @Override // com.byazt.me.uj
                public void c(List<com.byazt.yl.ve> list) {
                    if (list == null) {
                        veVar.c(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.byazt.yl.ve veVar2 : list) {
                        if (veVar2 != null) {
                            arrayList.add(new tt(c.this.c, veVar2, c.this.c.my()));
                        }
                    }
                    veVar.c(arrayList);
                }

                @Override // com.byazt.me.uj
                public void c(com.byazt.pp.c cVar) {
                    if (cVar != null) {
                        veVar.c(cVar.c, cVar.tt);
                    }
                }
            });
        }
    }

    @Override // com.byazt.pbu.tt
    public void loadNativeAdByAdm(String str, com.byazt.nh.ve veVar) {
        loadAdByAdm(str, veVar);
    }
}
