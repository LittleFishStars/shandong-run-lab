package com.kwad.components.core.video;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    private boolean anq = false;
    private boolean anr = false;
    private boolean ans = false;
    private boolean ant = false;
    private boolean anu = false;
    private int anv = -1;

    public final void bh(boolean z) {
        this.ans = z;
    }

    public final void cb(int i) {
        this.anv = i;
    }

    public final void setAd(boolean z) {
        this.anr = z;
    }

    public final void setFillXY(boolean z) {
        this.anu = z;
    }

    public final void setForce(boolean z) {
        this.anq = z;
    }

    public final void setHorizontalVideo(boolean z) {
        this.ant = z;
    }

    public final boolean xA() {
        return this.ans;
    }

    public final boolean xB() {
        return this.ant;
    }

    public final boolean xC() {
        return this.anu;
    }

    public final boolean xw() {
        return this.anv > 0;
    }

    public final int xx() {
        return this.anv;
    }

    public final boolean xy() {
        return this.anq;
    }

    public final boolean xz() {
        return this.anr;
    }
}
