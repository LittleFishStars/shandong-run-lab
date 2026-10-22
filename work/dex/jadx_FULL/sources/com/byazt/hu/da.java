package com.byazt.hu;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 72})
public class da {
    public static Map<String, c> c = Collections.synchronizedMap(new HashMap());

    public interface c {
        void c();

        void c(String str);
    }

    public static void c(String[] strArr, c cVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        c(strValueOf, cVar);
        TTDelegateActivity.c(strValueOf, strArr);
    }

    public static boolean tt(String str) {
        return com.byazt.gq.t.n().c(com.byazt.gq.t.getContext(), str);
    }

    private static c ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.remove(str);
    }

    public static void c(String str) {
        c cVarVe;
        if (TextUtils.isEmpty(str) || (cVarVe = ve(str)) == null) {
            return;
        }
        cVarVe.c();
    }

    public static void c(String str, String str2) {
        c cVarVe;
        if (TextUtils.isEmpty(str) || (cVarVe = ve(str)) == null) {
            return;
        }
        cVarVe.c(str2);
    }

    private static void c(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c.put(str, cVar);
    }
}
