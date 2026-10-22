package com.zj.adlib;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class zna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f46305a;

    public zna() throws IOException {
        this("", 0L);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.f46305a.write(bArr);
        return bArr.length;
    }

    public final void b() {
        RandomAccessFile randomAccessFile = this.f46305a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f46305a = null;
        }
    }

    public zna(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                a7b.m(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f46305a = randomAccessFile;
        randomAccessFile.seek(j);
    }
}
