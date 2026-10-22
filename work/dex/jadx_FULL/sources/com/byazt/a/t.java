package com.byazt.a;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 66})
public class t extends c {
    public t(Context context, com.byazt.k.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.byazt.a.n
    public Intent tt() {
        String strVe = this.tt.ve("s");
        String strC = com.byazt.i.ve.c(this.tt.ve("ag"), strVe);
        String strC2 = com.byazt.i.ve.c(this.tt.ve("ah"), strVe);
        String strC3 = com.byazt.i.ve.c(this.tt.ve("ai"), strVe);
        String strC4 = com.byazt.i.ve.c(this.tt.ve("aj"), strVe);
        Intent intent = new Intent();
        intent.putExtra(strC, this.ve);
        intent.putExtra(strC2, "*/*");
        intent.putExtra(strC3, true);
        intent.setAction(strC4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
