package com.kwad.sdk.core.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements c {
    private boolean bbU = false;
    private boolean aba = false;
    private boolean abb = false;

    public abstract void aP();

    public abstract void aQ();

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        if (this.bbU && !this.aba) {
            aQ();
            this.aba = true;
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        this.bbU = true;
        if (this.abb) {
            return;
        }
        aP();
        this.abb = true;
    }
}
