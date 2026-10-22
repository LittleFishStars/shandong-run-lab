package com.byazt.oi;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1933, 20})
public class c {
    public static volatile c c;
    public long tt;
    public final Queue<Long> uj = new LinkedList();
    public long ve;

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public boolean tt() {
        synchronized (c.class) {
            if (this.tt > 0 && this.ve > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.uj.size() >= this.tt) {
                    while (this.uj.size() > this.tt) {
                        this.uj.poll();
                    }
                    if (Math.abs(jCurrentTimeMillis - this.uj.peek().longValue()) <= this.ve) {
                        return true;
                    }
                    this.uj.poll();
                    this.uj.offer(Long.valueOf(jCurrentTimeMillis));
                } else {
                    this.uj.offer(Long.valueOf(jCurrentTimeMillis));
                }
                return false;
            }
            return false;
        }
    }

    public void c(long j, long j2) {
        synchronized (c.class) {
            if (this.tt != j || this.ve != j2) {
                this.tt = j;
                this.ve = j2;
                this.uj.clear();
            }
        }
    }
}
