package com.kc.cw.ad.internal.c;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n {
    public static void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            com.kc.cw.ad.d.b.f.a("ReportEventUtil", "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new com.kc.cw.ad.internal.i(str).b();
            }
        }
    }
}
