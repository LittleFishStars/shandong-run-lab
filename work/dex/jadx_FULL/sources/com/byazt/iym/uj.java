package com.byazt.iym;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 15})
public class uj extends com.byazt.xh.tt {
    public boolean qp;

    public uj(Context context, ViewGroup viewGroup, ic icVar) {
        super(context, viewGroup, icVar, null);
        c(false);
    }

    @Override // com.byazt.zd.c
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.byazt.zd.c, com.byazt.dh.ve
    public void da() {
        this.qp = false;
        super.da();
    }

    public boolean gr() {
        return nu() != null && nu().isPaused();
    }

    @Override // com.byazt.xh.tt, com.byazt.zd.c
    public int gu() {
        return 4;
    }

    public void sp(boolean z) {
        this.qp = z;
    }

    @Override // com.byazt.xh.tt, com.byazt.zd.c, com.byazt.dh.ve
    public void x() {
        if (this.qp) {
            return;
        }
        super.x();
    }

    public boolean zm() {
        return this.qp;
    }
}
