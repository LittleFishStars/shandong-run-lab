package com.byazt.ym;

import com.byazt.vb.n;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15})
public class uj {
    public static String c = "com.bytedance.openadsdk";
    public static String tt = "content://" + c + ".TTMultiProvider";

    public static String c(n nVar) {
        if (nVar.getContext() != null) {
            c = nVar.getContext().getPackageName();
            tt = "content://" + c + ".TTMultiProvider";
        }
        return tt;
    }
}
