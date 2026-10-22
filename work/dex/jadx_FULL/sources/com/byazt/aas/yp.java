package com.byazt.aas;

import android.text.TextUtils;
import com.alipay.sdk.m.t.e;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 215})
public class yp {
    public static String c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = e.f;
        if (TextUtils.isEmpty(map.get(e.f))) {
            str = "Content-Type";
        }
        return map.get(str);
    }
}
