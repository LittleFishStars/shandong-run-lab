package com.byazt.bu;

import com.byazt.bu.ve;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 68, 15})
public class uj<T extends ve> {
    public int c;
    public BlockingQueue<T> tt = new LinkedBlockingQueue();

    private uj(int i) {
        this.c = i;
    }

    public static uj c(int i) {
        return new uj(i);
    }

    public int tt() {
        return this.tt.size();
    }

    public T c() {
        return this.tt.poll();
    }

    public boolean c(T t) {
        if (t == null) {
            return false;
        }
        t.c();
        if (this.tt.size() >= this.c) {
            return false;
        }
        return this.tt.offer(t);
    }
}
