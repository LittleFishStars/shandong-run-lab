package com.byazt.pc;

import android.text.TextUtils;
import com.byazt.yj.rh;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 54})
public class ve extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "generate_key";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        if (TextUtils.isEmpty(veVar.getMemoryCacheKey())) {
            rh rhVarN = veVar.u().n();
            veVar.tt(rhVarN.c(veVar));
            veVar.c(rhVarN.tt(veVar));
        }
        veVar.c(new sp());
    }
}
