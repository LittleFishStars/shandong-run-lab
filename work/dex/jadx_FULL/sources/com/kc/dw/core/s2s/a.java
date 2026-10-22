package com.kc.dw.core.s2s;

import android.content.Context;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    public static void a(Context context, String[] strArr, Map<String, Object> map) {
        if (strArr == null) {
            return;
        }
        try {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String strReplace = strArr[i];
                if (map != null) {
                    if (map.containsKey("winPrice") && a(map.get("winPrice"))) {
                        strReplace = strReplace.replace("__MS_WIN_PRICE__", g0.b(map.get("winPrice") + ""));
                    }
                    if (map.containsKey("lossReason")) {
                        String str = map.get("lossReason") + "";
                        if ("1".equals(str) || "101".equals(str) || "10001".equals(str)) {
                            strReplace = strReplace.replace("__MS_LOSS_REASON__", g0.b(str));
                        }
                    }
                    if (map.containsKey("adnId")) {
                        String str2 = map.get("adnId") + "";
                        if ("1".equals(str2) || "2".equals(str2) || "3".equals(str2) || "4".equals(str2)) {
                            strReplace = strReplace.replace("__MS_ADN_ID__", str2);
                        }
                    }
                }
                z.a(context, strReplace, new j());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float)) {
            return true;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        try {
            Double.parseDouble((String) obj);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Context context, String[] strArr, Map<String, Object> map) {
        if (strArr == null) {
            return;
        }
        try {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String strReplace = strArr[i];
                if (map != null) {
                    if (map.containsKey(ISBidding.EXPECT_COST_PRICE)) {
                        Object obj = map.get(ISBidding.EXPECT_COST_PRICE);
                        if (a(obj)) {
                            strReplace = strReplace.replace("__MS_WIN_PRICE__", g0.b(obj + ""));
                        }
                    }
                    if (map.containsKey("highestLossPrice") && a(map.get("highestLossPrice"))) {
                        strReplace = strReplace.replace("__MS_LOSS_PRICE__", g0.b(map.get("highestLossPrice") + ""));
                    }
                }
                z.a(context, strReplace, new j());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
