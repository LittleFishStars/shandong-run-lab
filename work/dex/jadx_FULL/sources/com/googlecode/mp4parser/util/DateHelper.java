package com.googlecode.mp4parser.util;

import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DateHelper {
    public static Date convert(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    public static long convert(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
