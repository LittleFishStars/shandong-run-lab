package com.byazt.sz;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.nd9;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 158})
public class sl implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29048a;
    public AtomicInteger c;
    public my i;
    public AtomicInteger n;
    public t sp;
    public AtomicInteger tt;
    public AtomicInteger uj;
    public AtomicInteger ve;
    public qy x;

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, nd9.i)) && str2.startsWith("http")) {
            this.tt.incrementAndGet();
        }
    }

    public int tt() {
        int i = (int) (this.f29048a * this.tt.get());
        this.c.set(i);
        return i;
    }

    public boolean ve() {
        return this.c.get() > 0;
    }

    @Override // com.byazt.sz.sp
    public void tt(com.byazt.xj.ve veVar, String str) {
        int iIncrementAndGet = this.n.incrementAndGet();
        if (iIncrementAndGet > this.tt.get() - this.c.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.tt.get() - this.c.get() && this.i != null) {
                    rl rlVar = new rl();
                    rlVar.c(-3);
                    rlVar.c("image download fail");
                    rlVar.c(veVar.tt(veVar));
                }
            }
        }
    }

    public void c(my myVar) {
        this.i = myVar;
    }

    public void c(qy qyVar) {
        this.x = qyVar;
    }

    @Override // com.byazt.sz.sp
    public void c() {
        this.uj.incrementAndGet();
        if (this.uj.get() == 1) {
            synchronized (this) {
                this.uj.get();
            }
        }
    }

    @Override // com.byazt.sz.sp
    public void c(com.byazt.xj.ve veVar, String str) {
        if (this.ve.incrementAndGet() == this.c.get()) {
            synchronized (this) {
                if (this.ve.get() == this.c.get()) {
                    if (this.sp != null) {
                        this.tt.get();
                    }
                    if (this.i != null) {
                        rl rlVar = new rl();
                        rlVar.c(0);
                        rlVar.c(veVar.tt(veVar));
                    }
                }
            }
        }
    }
}
