package com.byazt.utw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 46})
public class n {
    public final RandomAccessFile c;

    @com.byazt.zqa.c(c = {0, 1, 450, 151})
    public static class c extends Exception {
        public c(Throwable th) {
            super(th);
        }
    }

    public n(File file, String str) throws c {
        try {
            this.c = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new c(e);
        }
    }

    public void c(long j) throws c {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public void c(byte[] bArr, int i, int i2) throws c {
        try {
            this.c.write(bArr, i, i2);
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public void c() {
        com.byazt.nxx.c.c(this.c);
    }
}
