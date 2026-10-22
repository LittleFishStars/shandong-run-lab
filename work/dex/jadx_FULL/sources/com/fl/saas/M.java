package com.fl.saas;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class M {
    public static void a(File file) {
        File[] fileArrListFiles;
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (file2.isDirectory()) {
                a(file2);
            }
        }
    }
}
