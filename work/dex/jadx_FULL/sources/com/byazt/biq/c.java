package com.byazt.biq;

import android.text.TextUtils;
import com.byazt.ete.sp;
import com.byazt.nr.m;
import com.byazt.omf.x;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 20})
public class c {
    public static String c(String str) {
        if (!m.ve() || TextUtils.isEmpty(str)) {
            return str;
        }
        sp spVar = new sp(x.m().p());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = spVar.tt().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&");
                    sb.append(spVar.c());
                } else {
                    sb.append("?");
                    sb.append(spVar.c());
                }
            }
        }
        return sb.toString();
    }
}
