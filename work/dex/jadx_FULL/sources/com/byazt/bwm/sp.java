package com.byazt.bwm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 91})
public abstract class sp implements Comparable<sp>, Runnable {
    public int c;
    public String tt;

    public sp(String str, int i) {
        this.c = 0;
        this.c = i == 0 ? 5 : i;
        this.tt = str;
    }

    public void c(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(sp spVar) {
        if (c() < spVar.c()) {
            return 1;
        }
        return c() >= spVar.c() ? -1 : 0;
    }

    public sp(String str) {
        this.c = 5;
        this.tt = str;
    }
}
