package com.byazt.un;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 54})
public class ve extends uj {
    public ve(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, icVar, str, z, z2, z3);
    }

    @Override // com.byazt.un.uj
    public void c(int i, int i2) {
        super.c(i, i2);
        a aVar = this.n;
        if (aVar == null || i <= 0 || i2 <= 0) {
            return;
        }
        aVar.ve(i, i2);
        this.n.c(i, i2);
        tt(-1, -1);
    }

    @Override // com.byazt.un.uj
    public com.byazt.jr.tt gu() {
        a aVar = this.n;
        if (aVar != null) {
            return aVar.nu();
        }
        return null;
    }
}
