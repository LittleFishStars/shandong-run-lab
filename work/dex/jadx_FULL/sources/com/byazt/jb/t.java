package com.byazt.jb;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 66})
public final class t {
    public final CountDownLatch c = new CountDownLatch(1);
    public long tt = -1;
    public long ve = -1;

    public void c() {
        if (this.tt != -1) {
            throw new IllegalStateException();
        }
        this.tt = System.nanoTime();
    }

    public void tt() {
        if (this.ve != -1 || this.tt == -1) {
            throw new IllegalStateException();
        }
        this.ve = System.nanoTime();
        this.c.countDown();
    }

    public void ve() {
        if (this.ve == -1) {
            long j = this.tt;
            if (j != -1) {
                this.ve = j - 1;
                this.c.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
