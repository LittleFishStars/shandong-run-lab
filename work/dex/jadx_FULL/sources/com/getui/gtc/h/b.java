package com.getui.gtc.h;

import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {
    public static void a(com.getui.gtc.entity.a.C0657a c0657a, String str) throws Exception {
        if (a(c0657a)) {
            throw new RuntimeException("The download request is unusual, too many times in a short time");
        }
        Response responseExecute = d.f30374a.newCall(new Request.Builder().url(c0657a.h).method("GET").logFlags(1).build()).execute();
        if (responseExecute.body() == null) {
            throw new RuntimeException("can not save file, body is null");
        }
        responseExecute.body().file(new File(str));
    }

    private static boolean a(com.getui.gtc.entity.a.C0657a c0657a) {
        int iC = com.getui.gtc.e.c.a.f30351a.b.c(c0657a.f30355a);
        long jB = com.getui.gtc.e.c.a.f30351a.b.b(c0657a.f30355a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        if (iC >= 10) {
            iC = -1;
            jB = jCurrentTimeMillis;
        } else {
            long j = jCurrentTimeMillis - jB;
            if (iC < 0) {
                if (j > 3600000) {
                    jB = jCurrentTimeMillis;
                    iC = 0;
                }
            } else if (j > 3600000) {
                jB = jCurrentTimeMillis;
                iC = 0;
                z = false;
            } else {
                iC++;
                z = false;
            }
        }
        com.getui.gtc.e.c.a.f30351a.b.a(c0657a.f30355a, jB, iC);
        return z;
    }
}
