package com.byazt.yl;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.vx.eo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 509, 13})
public class tt {
    public static final String c = eo.uj();
    public static boolean tt = true;

    public static int c() {
        return Integer.parseInt(tt().replace(Consts.DOT, ""));
    }

    public static String tt() {
        return com.byazt.tjo.tt.ve();
    }

    public static String uj() {
        return com.byazt.tjo.tt.uj();
    }

    public static String ve() {
        if (TextUtils.isEmpty(tt())) {
            return "";
        }
        String[] strArrSplit = tt().split("\\.");
        if (strArrSplit.length < 4) {
            return "";
        }
        return strArrSplit[0] + Consts.DOT + strArrSplit[1] + Consts.DOT + strArrSplit[2];
    }
}
