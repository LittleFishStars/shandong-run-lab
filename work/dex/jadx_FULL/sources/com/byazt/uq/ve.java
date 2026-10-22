package com.byazt.uq;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 54})
public class ve {
    public static String[] c(File file) {
        String[] strArrC = com.byazt.xai.tt.c(file);
        return TextUtils.isEmpty(strArrC[0]) ? com.byazt.xai.c.c(file) : strArrC;
    }
}
