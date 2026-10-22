package com.byazt.ml;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vb.n;
import com.byazt.vb.uj;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TTAdConstant.STYLE_SIZE_RADIO_2_3, 54})
public class ve {
    private static boolean c(String str) {
        uj ujVarUj;
        n nVarVe = ve(str);
        if (nVarVe == null || (ujVarUj = nVarVe.uj()) == null) {
            return false;
        }
        return ujVarUj.c();
    }

    private static String tt(String str) {
        uj ujVarUj;
        n nVarVe = ve(str);
        if (nVarVe == null || (ujVarUj = nVarVe.uj()) == null) {
            return null;
        }
        return ujVarUj.tt();
    }

    public static void uj(String str, n nVar) {
        if (nVar == null) {
            return;
        }
        c(null, str, nVar.n(), 100);
    }

    private static n ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.epi.c.uj(str);
    }

    public static void ve(String str, n nVar) {
        if (nVar == null) {
            return;
        }
        c(null, str, nVar.n(), 6);
    }

    public static void c(String str, n nVar) {
        if (nVar == null) {
            return;
        }
        c(null, str, nVar.n(), 4);
    }

    public static void tt(String str, n nVar) {
        if (nVar == null) {
            return;
        }
        c(null, str, nVar.n(), 5);
    }

    public static void ve(String str, String str2, n nVar) {
        if (nVar == null) {
            return;
        }
        c(str, str2, nVar.n(), 6);
    }

    public static void c(String str, String str2, n nVar) {
        if (nVar == null) {
            return;
        }
        c(str, str2, nVar.n(), 4);
    }

    public static void tt(String str, String str2, n nVar) {
        if (nVar == null) {
            return;
        }
        c(str, str2, nVar.n(), 5);
    }

    public static void c(String str, String str2, String str3) {
        c(str, str2, str3, 4);
    }

    private static void c(String str, String str2, String str3, int i) {
        try {
            if (c(str3) || i == 100) {
                String strTt = tt(str3);
                if (strTt == null) {
                    strTt = "";
                }
                String str4 = strTt + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i == 4) {
                    m.c(str4, str2);
                    return;
                }
                if (i == 5) {
                    m.tt(str4, str2);
                } else if (i == 6 || i == 100) {
                    m.uj(str4, str2);
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
    }
}
