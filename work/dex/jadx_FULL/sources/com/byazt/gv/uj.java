package com.byazt.gv;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 15})
public class uj implements ThreadFactory {
    public static final AtomicInteger c = new AtomicInteger(1);
    public final tt.c n;
    public final ThreadGroup tt;
    public final String uj;
    public final AtomicInteger ve = new AtomicInteger(1);

    public uj(tt.c cVar, String str) {
        this.n = cVar;
        SecurityManager securityManager = System.getSecurityManager();
        this.tt = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (TextUtils.isEmpty(str)) {
            this.uj = "ttdefault-" + c.getAndIncrement() + "-thread-";
            return;
        }
        this.uj = str + c.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(this.tt, runnable, this.uj + this.ve.getAndIncrement(), 0L);
        if (veVar.isDaemon()) {
            veVar.setDaemon(false);
        }
        tt.c cVar = this.n;
        if (cVar != null && cVar.c() == tt.c.LOW.c()) {
            veVar.setPriority(1);
        } else if (veVar.getPriority() != 5) {
            veVar.setPriority(3);
        } else {
            veVar.setPriority(5);
        }
        return veVar;
    }
}
