package com.kwad.components.core.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a {
    private static volatile a akF;
    private int aev;
    private int akG;
    private boolean akH;
    private boolean akI;
    private int akJ;
    private boolean akK;

    private a() {
    }

    public static a wm() {
        if (akF == null) {
            synchronized (a.class) {
                if (akF == null) {
                    akF = new a();
                }
            }
        }
        return akF;
    }

    public final void bU(int i) {
        this.akG = i;
    }

    public final void bV(int i) {
        this.akJ = i;
    }

    public final void bW(int i) {
        this.aev = i;
    }

    public final void ba(boolean z) {
        this.akH = true;
    }

    public final void bb(boolean z) {
        this.akI = z;
    }

    public final void bc(boolean z) {
        this.akK = z;
    }

    public final void clear() {
        this.akI = false;
        this.akH = false;
        this.akJ = 0;
        this.akK = false;
        this.akG = -1;
        this.aev = 0;
    }

    public final int wn() {
        return this.akG;
    }

    public final boolean wo() {
        return this.akH;
    }

    public final boolean wp() {
        return this.akI;
    }

    public final boolean wq() {
        int i = this.akJ;
        return i == 1 || i == 3;
    }

    public final int wr() {
        return this.akJ;
    }

    public final boolean ws() {
        return this.akK;
    }

    public final int wt() {
        return this.aev;
    }
}
