package com.byazt.eg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28451a;
    public long c = System.currentTimeMillis();
    public long n;
    public long sp;
    public long tt;
    public long uj;
    public long ve;

    public long a() {
        return this.uj;
    }

    public void c() {
        this.ve = System.currentTimeMillis();
    }

    public long da() {
        return this.tt;
    }

    public long i() {
        return this.sp;
    }

    public long n() {
        return this.ve;
    }

    public void sl() {
        this.tt = System.currentTimeMillis();
    }

    public long sp() {
        return this.n;
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.c + ", asyncCallExecTs=" + this.tt + ", requestStartExecTs=" + this.ve + ", requestConnectStartTs=" + this.uj + ", requestConnectFinishTs=" + this.n + ", reqCallServerStartTs=" + this.f28451a + ", reqCallServerFinishTs=" + this.sp + '}';
    }

    public void tt() {
        this.uj = System.currentTimeMillis();
    }

    public long uj() {
        return this.c;
    }

    public void ve() {
        this.n = System.currentTimeMillis();
    }

    public long x() {
        return this.f28451a;
    }

    public void c(long j) {
        this.f28451a = j;
    }

    public void tt(long j) {
        this.sp = j;
    }
}
