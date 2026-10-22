package com.byazt.oaq;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.sm.UGTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 995, 13})
public class tt extends com.byazt.sm.tt {
    public tt(Context context) {
        super(context);
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void tt() {
        super.tt();
        if (TextUtils.isEmpty(((com.byazt.sm.tt) this).c)) {
            ((UGTextView) this.n).setText("跳过");
        }
    }

    public void uj(boolean z) {
        if (z) {
            tt(0);
            c(true, true);
        } else {
            uj(0);
            n(0);
        }
    }
}
