package com.byazt.oaq;

import android.content.Context;
import androidx.annotation.NonNull;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 995, 20})
public class c extends ve<CycleSkipView> {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public CycleSkipView c() {
        return new CycleSkipView(this.tt);
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
    }

    public void tt(int i, int i2) {
        T t = this.n;
        if (t != 0) {
            ((CycleSkipView) t).c(i, i2);
        }
    }
}
