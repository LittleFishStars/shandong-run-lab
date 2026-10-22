package com.byazt.vv;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 685, 54})
public class ve {
    public static long c(String str, String str2) {
        File fileVe = ve(str, str2);
        if (fileVe.exists()) {
            return fileVe.length();
        }
        File fileTt = tt(str, str2);
        if (fileTt.exists()) {
            return fileTt.length();
        }
        return 0L;
    }

    public static File tt(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File ve(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean c(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            com.byazt.lt.tt.c("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}
