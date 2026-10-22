package com.byazt.sr;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 977, 15})
public class uj {
    public static boolean c() {
        com.byazt.mf.ve veVarVe = com.byazt.mf.c.c().ve();
        return veVarVe != null && veVarVe.sp() == 1;
    }

    public static Context getContext() {
        if (com.byazt.mf.c.c().ve() == null) {
            return null;
        }
        return com.byazt.mf.c.c().ve().getContext();
    }

    public static int tt() {
        return com.byazt.mf.c.c().ve().da();
    }
}
