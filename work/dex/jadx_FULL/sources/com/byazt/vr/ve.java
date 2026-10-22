package com.byazt.vr;

import android.content.Context;
import android.os.Handler;
import com.byazt.mg.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1683, 54})
public final class ve {
    public List<c> c;

    private ve(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.c = arrayList;
        arrayList.add(new tt(handler, 0L, 15000L));
    }

    public static ve c(Handler handler, Context context) {
        return new ve(handler, context);
    }

    public void c() {
        da.c("[ScheduleTaskManager] execute, task size=" + this.c.size());
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                it.next().c();
            } catch (Throwable unused) {
            }
        }
    }
}
