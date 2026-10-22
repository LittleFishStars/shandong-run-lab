package com.zj.adlib;

import com.facebook.common.file.FileTreeVisitor;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class fg3 {
    public static boolean a(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zB = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                zB &= b(file2);
            }
        }
        return zB;
    }

    public static boolean b(File file) {
        if (file.isDirectory()) {
            a(file);
        }
        return file.delete();
    }

    public static void c(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.c(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    c(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.b(file2);
                }
            }
        }
        fileTreeVisitor.a(file);
    }
}
