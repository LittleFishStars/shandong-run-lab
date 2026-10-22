package com.beizi.fusion;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class bm {
    public static void a(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            kh.a("ReportEventUtil", "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new h5(pp.a(str, "", "", "", "", "", "", "")).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }
}
