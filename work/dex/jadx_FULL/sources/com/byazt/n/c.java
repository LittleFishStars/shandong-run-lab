package com.byazt.n;

import android.app.Notification;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 46, 20})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28803a = 0;
    public Notification c;
    public boolean i;
    public String n;
    public long sp;
    public int tt;
    public long uj;
    public long ve;
    public int x;

    public c(int i, String str) {
        this.tt = i;
        this.n = str;
    }

    public long a() {
        if (this.sp == 0) {
            this.sp = System.currentTimeMillis();
        }
        return this.sp;
    }

    public abstract void c(BaseException baseException, boolean z);

    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.tt = downloadInfo.getId();
        this.n = downloadInfo.getTitle();
    }

    public int n() {
        return this.f28803a;
    }

    public synchronized void sp() {
        this.x++;
    }

    public long tt() {
        return this.ve;
    }

    public String uj() {
        return this.n;
    }

    public long ve() {
        return this.uj;
    }

    public boolean x() {
        return this.i;
    }

    public void tt(long j) {
        this.uj = j;
    }

    public int c() {
        return this.tt;
    }

    public void c(long j) {
        this.ve = j;
    }

    public void c(int i, BaseException baseException, boolean z) {
        c(i, baseException, z, false);
    }

    public void c(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f28803a != i) {
            this.f28803a = i;
            c(baseException, z);
        }
    }

    public void c(long j, long j2) {
        this.ve = j;
        this.uj = j2;
        this.f28803a = 4;
        c((BaseException) null, false);
    }

    public void c(Notification notification) {
        if (this.tt == 0 || notification == null) {
            return;
        }
        tt.c().c(this.tt, this.f28803a, notification);
    }
}
