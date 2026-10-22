package com.google.zxing.client.result;

import com.zj.adlib.dv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    public static String[] i(String str, String str2) {
        return ResultParser.c(str, str2, dv9.e, true);
    }

    public static String j(String str, String str2, boolean z) {
        return ResultParser.d(str, str2, dv9.e, z);
    }
}
