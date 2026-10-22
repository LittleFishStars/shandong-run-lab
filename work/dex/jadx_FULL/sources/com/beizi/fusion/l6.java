package com.beizi.fusion;

import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class l6 {
    public static long a(int i) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i);
            return calendar.getTimeInMillis();
        } catch (Exception e) {
            om.a(e);
            return 0L;
        }
    }

    public static boolean a(long j, int i) {
        return System.currentTimeMillis() - j < ((long) i) * 86400000;
    }
}
