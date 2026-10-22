package com.byazt.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 868, 20})
public class c {
    public int tt = 0;
    public Map<Integer, Long> c = new ConcurrentHashMap();

    public void c() {
        this.tt = 0;
        try {
            this.c.clear();
        } catch (Exception unused) {
        }
    }

    public Long tt(int i) {
        try {
            if (c(i)) {
                return this.c.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public boolean uj(int i) {
        return i == this.tt;
    }

    public void ve(int i) {
        if (c(i)) {
            return;
        }
        this.tt |= i;
        try {
            this.c.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public boolean c(int i) {
        return (this.tt & i) == i;
    }
}
