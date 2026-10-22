package com.byazt.zyp;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.bog.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1493, 54})
public class ve {
    public static boolean c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb = new StringBuilder("abi-support: ");
        sb.append(strArr == null ? "null" : strArr.toString());
        a.c(sb.toString());
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }

    public static boolean tt() {
        return ve() && !c();
    }

    public static boolean ve() {
        a.tt("isOA8A: true");
        return true;
    }
}
