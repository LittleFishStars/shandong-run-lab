package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 133})
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f28794a;
    public final byte[] c;
    public boolean n;
    public z sp;
    public int tt;
    public boolean uj;
    public int ve;

    public z() {
        this.c = new byte[8192];
        this.n = true;
        this.uj = false;
    }

    public final z c() {
        this.uj = true;
        return new z(this.c, this.tt, this.ve, true, false);
    }

    public final z tt() {
        z zVar = this.f28794a;
        z zVar2 = zVar != this ? zVar : null;
        z zVar3 = this.sp;
        if (zVar3 != null) {
            zVar3.f28794a = zVar;
        }
        z zVar4 = this.f28794a;
        if (zVar4 != null) {
            zVar4.sp = zVar3;
        }
        this.f28794a = null;
        this.sp = null;
        return zVar2;
    }

    public final void ve() {
        z zVar = this.sp;
        if (zVar == this) {
            throw new IllegalStateException();
        }
        if (zVar.n) {
            int i = this.ve - this.tt;
            if (i > (8192 - zVar.ve) + (zVar.uj ? 0 : zVar.tt)) {
                return;
            }
            c(zVar, i);
            tt();
            m.c(this);
        }
    }

    public final z c(z zVar) {
        zVar.sp = this;
        zVar.f28794a = this.f28794a;
        this.f28794a.sp = zVar;
        this.f28794a = zVar;
        return zVar;
    }

    public z(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.tt = i;
        this.ve = i2;
        this.uj = z;
        this.n = z2;
    }

    public final z c(int i) {
        z zVarC;
        if (i > 0 && i <= this.ve - this.tt) {
            if (i >= 1024) {
                zVarC = c();
            } else {
                zVarC = m.c();
                System.arraycopy(this.c, this.tt, zVarC.c, 0, i);
            }
            zVarC.ve = zVarC.tt + i;
            this.tt += i;
            this.sp.c(zVarC);
            return zVarC;
        }
        throw new IllegalArgumentException();
    }

    public final void c(z zVar, int i) {
        if (zVar.n) {
            int i2 = zVar.ve;
            if (i2 + i > 8192) {
                if (!zVar.uj) {
                    int i3 = zVar.tt;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = zVar.c;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        zVar.ve -= zVar.tt;
                        zVar.tt = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.c, this.tt, zVar.c, zVar.ve, i);
            zVar.ve += i;
            this.tt += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
