package com.byazt.na;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 34})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f28805a;
    public final byte[] c;
    public boolean n;
    public a sp;
    public int tt;
    public boolean uj;
    public int ve;

    public a() {
        this.c = new byte[8192];
        this.n = true;
        this.uj = false;
    }

    public final a c() {
        this.uj = true;
        return new a(this.c, this.tt, this.ve, true, false);
    }

    public final a tt() {
        a aVar = this.f28805a;
        a aVar2 = aVar != this ? aVar : null;
        a aVar3 = this.sp;
        if (aVar3 != null) {
            aVar3.f28805a = aVar;
        }
        a aVar4 = this.f28805a;
        if (aVar4 != null) {
            aVar4.sp = aVar3;
        }
        this.f28805a = null;
        this.sp = null;
        return aVar2;
    }

    public final a c(a aVar) {
        aVar.sp = this;
        aVar.f28805a = this.f28805a;
        this.f28805a.sp = aVar;
        this.f28805a = aVar;
        return aVar;
    }

    public a(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.tt = i;
        this.ve = i2;
        this.uj = z;
        this.n = z2;
    }
}
