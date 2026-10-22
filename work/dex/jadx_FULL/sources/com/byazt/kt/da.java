package com.byazt.kt;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 72})
public class da {
    public static int c(RecyclerView.gt gtVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        if (iVar.my() == 0 || gtVar.uj() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (gtVar.uj() - Math.max(iVar.uj(view), iVar.uj(view2))) - 1) : Math.max(0, Math.min(iVar.uj(view), iVar.uj(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(xVar.tt(view2) - xVar.c(view)) / (Math.abs(iVar.uj(view) - iVar.uj(view2)) + 1))) + (xVar.ve() - xVar.c(view)));
        }
        return iMax;
    }

    public static int tt(RecyclerView.gt gtVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.my() == 0 || gtVar.uj() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return gtVar.uj();
        }
        return (int) (((xVar.tt(view2) - xVar.c(view)) / (Math.abs(iVar.uj(view) - iVar.uj(view2)) + 1)) * gtVar.uj());
    }

    public static int c(RecyclerView.gt gtVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.my() == 0 || gtVar.uj() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.uj(view) - iVar.uj(view2)) + 1;
        }
        return Math.min(xVar.a(), xVar.tt(view2) - xVar.c(view));
    }
}
