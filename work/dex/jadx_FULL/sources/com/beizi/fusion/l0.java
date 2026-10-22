package com.beizi.fusion;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class l0 {
    public static void a(Context context) {
        xp.b().a(context);
        nf.b().a(context);
    }

    public static void a(Context context, List list, List list2, List list3) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                nf.b().a(context, (String) it.next(), ph.TEMPORARY);
            }
        }
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                nf.b().a(context, (String) it2.next(), ph.PERMANENT);
            }
        }
        if (list3 != null) {
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                xp.b().a(context, (String) it3.next(), ph.TEMPORARY);
            }
        }
    }
}
