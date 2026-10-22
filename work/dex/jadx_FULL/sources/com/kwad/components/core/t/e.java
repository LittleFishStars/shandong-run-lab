package com.kwad.components.core.t;

import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    public static String a(long j, boolean z) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j > 1) {
            double d = j;
            int iLog = (int) (Math.log(d) / Math.log(1024.0d));
            return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j > 1024 ? d / Math.pow(1024.0d, iLog) : d / 1024.0d), strArr[iLog]);
        }
        return j + "B";
    }
}
