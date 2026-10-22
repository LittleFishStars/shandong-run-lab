package com.byazt.hu;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 91})
public class sp {
    public static long c(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return c(file, file.lastModified(), 0);
    }

    private static long c(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, c(file2, j, i2));
                }
            }
        }
        return j;
    }
}
