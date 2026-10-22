package com.byazt.cv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 54})
public class ve extends com.byazt.yh.c {
    public com.byazt.yl.ve c;

    public ve(com.byazt.yl.ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.yh.c
    public String getVideoUrl() {
        com.byazt.yl.ve veVar = this.c;
        return veVar != null ? veVar.getVideoUrl() : "";
    }

    @Override // com.byazt.yh.c
    public void reportVideoAutoStart() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().tt();
    }

    @Override // com.byazt.yh.c
    public void reportVideoBreak(long j) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().ve(j);
    }

    @Override // com.byazt.yh.c
    public void reportVideoContinue(long j) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().tt(j);
    }

    @Override // com.byazt.yh.c
    public void reportVideoError(long j, int i, int i2) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().c(j, i, i2);
    }

    @Override // com.byazt.yh.c
    public void reportVideoFinish() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().c();
    }

    @Override // com.byazt.yh.c
    public void reportVideoPause(long j) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().c(j);
    }

    @Override // com.byazt.yh.c
    public void reportVideoStart() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().tt();
    }

    @Override // com.byazt.yh.c
    public void reportVideoStartError(int i, int i2) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || veVar.getGMNativeCustomVideoReporter() == null) {
            return;
        }
        this.c.getGMNativeCustomVideoReporter().c(i, i2);
    }
}
