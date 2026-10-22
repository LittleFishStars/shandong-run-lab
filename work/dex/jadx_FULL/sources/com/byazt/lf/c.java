package com.byazt.lf;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alipay.sdk.m.t.e;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 526, 20})
public class c {
    /* JADX WARN: Code duplicated, block: B:10:0x0023 A[PHI: r1
      0x0023: PHI (r1v1 java.lang.String) = (r1v0 java.lang.String), (r1v3 java.lang.String) binds: [B:6:0x0010, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean c(Map<String, String> map) {
        String str;
        if (map == null) {
            return false;
        }
        String str2 = e.f;
        if (TextUtils.isEmpty(map.get(e.f))) {
            str2 = "Content-Type";
            if (TextUtils.isEmpty(map.get("Content-Type"))) {
                str = "";
            } else {
                str = map.get(str2);
            }
        } else {
            str = map.get(str2);
        }
        return str.contains(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    }
}
