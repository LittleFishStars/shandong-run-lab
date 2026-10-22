package com.alibaba.analytics.core;

import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.core.d.e;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static void a(Map<String, String> map) {
        boolean z;
        j.d();
        if (map != null) {
            String str = map.get(LogField.EVENTID.toString());
            if (!map.containsKey("_priority")) {
                if (UserTrackConstant.EXPORT_EVENT.equalsIgnoreCase(str)) {
                    map.put("_priority", "4");
                }
                if ("2202".equalsIgnoreCase(str)) {
                    map.put("_priority", "6");
                }
            }
            String strRemove = map.containsKey("_priority") ? map.remove("_priority") : "3";
            String strF = e.a().f(str);
            if (!TextUtils.isEmpty(strF)) {
                strRemove = strF;
            }
            if (map.containsKey("_sls")) {
                map.remove("_sls");
                z = true;
            } else {
                z = false;
            }
            com.alibaba.analytics.core.model.a aVar = new com.alibaba.analytics.core.model.a(strRemove, null, str, map);
            if (z) {
                com.alibaba.analytics.core.f.d.a().b(aVar);
            } else {
                com.alibaba.analytics.core.f.d.a().a(aVar);
            }
        }
    }
}
