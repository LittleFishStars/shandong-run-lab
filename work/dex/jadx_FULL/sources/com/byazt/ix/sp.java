package com.byazt.ix;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1677, 91})
public class sp implements Comparable<sp> {
    public com.byazt.yl.ve c;
    public long tt;
    public com.byazt.ll.tt uj;
    public boolean ve = false;

    public sp(com.byazt.yl.ve veVar, long j, com.byazt.ll.tt ttVar) {
        this.c = veVar;
        this.tt = j;
        this.uj = ttVar;
    }

    public String a() {
        com.byazt.ll.tt ttVar = this.uj;
        if (ttVar == null) {
            return null;
        }
        return ttVar.gt();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(sp spVar) {
        return this.c.compareTo(spVar.c);
    }

    public boolean n() {
        com.byazt.yl.ve veVar = this.c;
        return (veVar == null || this.uj == null || veVar.isHasShown() || !this.c.isReady(this.uj.gt())) ? false : true;
    }

    public boolean sp() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null) {
            return false;
        }
        return veVar.isUseFromCache();
    }

    public String tt() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null) {
            return null;
        }
        return veVar.getAdNetworkSlotId();
    }

    public com.byazt.ll.tt uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    public long c() {
        return this.tt;
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public void tt(boolean z) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null) {
            return;
        }
        veVar.setUseFromCache(z);
    }
}
