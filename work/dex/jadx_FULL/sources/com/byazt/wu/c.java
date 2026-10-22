package com.byazt.wu;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.eia.i;
import com.byazt.ete.nu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1128, 20})
public class c {
    public static boolean c(i iVar) {
        if (iVar == null) {
            return false;
        }
        return c(iVar.yp());
    }

    public static boolean c(nu nuVar) {
        if (nuVar == null) {
            return false;
        }
        String strTt = nuVar.tt();
        if (TextUtils.isEmpty(strTt)) {
            return false;
        }
        return strTt.startsWith("snssdk2329") || strTt.startsWith("snssdk1128");
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return nb.ve("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return nb.ve("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
