package com.byazt.lf;

import android.content.Context;
import com.byazt.hw.sp;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 526, 15})
public class uj {
    public static void c(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(c(i2), str);
            }
            ve.tt("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (sp.c().c(i2).uj() != null) {
                sp.c().c(i2).uj().c(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    public static String c(Context context, int i, int i2) {
        String strC;
        if (i != 1) {
            strC = "";
        } else {
            try {
                if (sp.c().c(i2).uj() != null) {
                    strC = sp.c().c(i2).uj().c(context, c(i2), "");
                } else {
                    strC = "";
                }
            } catch (Exception unused) {
            }
        }
        return strC instanceof String ? String.valueOf(strC) : "";
    }

    private static String c(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
