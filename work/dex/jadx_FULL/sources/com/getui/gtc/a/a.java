package com.getui.gtc.a;

import android.text.TextUtils;
import com.getui.gtc.base.util.ScheduleQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f30241a = new AtomicBoolean(false);

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.contains("|") ? str.replace("|", "$") : str;
    }

    public static void a() {
        if (f30241a.getAndSet(true)) {
            return;
        }
        b[] bVarArr = {new d(), new e(), new f(), new g()};
        for (int i = 0; i < 4; i++) {
            ScheduleQueue.getInstance().addSchedule(bVarArr[i], 10000L);
        }
    }

    public static void a(int i) {
        if (i == 256) {
            c.a();
        }
    }
}
