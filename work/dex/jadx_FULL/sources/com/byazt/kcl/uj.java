package com.byazt.kcl;

import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28722a = false;
    public boolean c;
    public n n;
    public final TTBaseVideoActivity tt;
    public tt uj;
    public ic ve;

    public uj(TTBaseVideoActivity tTBaseVideoActivity) {
        this.tt = tTBaseVideoActivity;
    }

    public boolean a() {
        return this.c;
    }

    public void c(tt ttVar, ic icVar, String str, n nVar) {
        if (this.f28722a) {
            return;
        }
        this.f28722a = true;
        this.uj = ttVar;
        this.ve = icVar;
        this.n = nVar;
    }

    public boolean n() {
        if (rl.ve(this.ve)) {
            return this.uj.or();
        }
        return false;
    }

    public void tt() {
        if (rl.tt(this.ve)) {
            if (this.uj.cu() || uj()) {
                boolean z = !this.c;
                this.c = z;
                this.uj.c(z);
            }
        }
    }

    public boolean uj() {
        tt ttVar = this.uj;
        if (ttVar != null) {
            return ttVar.d();
        }
        return false;
    }

    public void ve() {
        this.uj.md();
        this.n.c(this.tt.to().tx());
    }

    public void tt(boolean z) {
        this.uj.a(z);
    }

    public void c() {
        if (rl.tt(this.ve) && !this.uj.cu()) {
            uj();
        }
    }

    public void c(boolean z) {
        tt ttVar = this.uj;
        if (ttVar != null && ttVar.h()) {
            this.c = z;
            this.n.uj(z);
            this.uj.c(this.c);
        }
    }

    public void c(boolean z, boolean z2) {
        this.uj.zm();
        c(z);
        tt(z2);
    }

    public void c(int i, int i2) {
        this.uj.tt(i, i2);
    }

    public void c(ic icVar) {
        this.ve = icVar;
    }
}
