package com.byazt.z;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.t.DownloadInfo;
import com.byazt.y.JumpUnknownSourceActivity;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 91})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f29227a;
    public final Queue<Integer> c;
    public SoftReference<JumpUnknownSourceActivity> n;
    public Runnable sp;
    public boolean tt;
    public long uj;
    public long ve;

    @com.byazt.zqa.c(c = {0, 1, 133, 180})
    public static class c {
        public static final sp c = new sp();
    }

    private sp() {
        this.c = new ArrayDeque();
        this.tt = false;
        this.f29227a = new Handler(Looper.getMainLooper());
        this.sp = new Runnable() { // from class: com.byazt.z.sp.1
            @Override // java.lang.Runnable
            public void run() {
                sp.this.ve();
            }
        };
        com.byazt.g.c.c().c(new com.byazt.g.c.InterfaceC0409c() { // from class: com.byazt.z.sp.2
            @Override // com.byazt.g.c.InterfaceC0409c
            public void tt() {
                if (sp.this.c.isEmpty()) {
                    return;
                }
                long jC = com.byazt.k.c.ve().c("install_on_resume_install_interval", com.igexin.push.config.c.l);
                long jCurrentTimeMillis = System.currentTimeMillis() - sp.this.uj;
                if (jCurrentTimeMillis < jC) {
                    if (sp.this.f29227a.hasCallbacks(sp.this.sp)) {
                        return;
                    }
                    sp.this.f29227a.postDelayed(sp.this.sp, jC - jCurrentTimeMillis);
                } else {
                    sp.this.uj = System.currentTimeMillis();
                    sp.this.ve();
                }
            }

            @Override // com.byazt.g.c.InterfaceC0409c
            public void ve() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tt(Context context, int i, boolean z) {
        int iTt = ve.tt(context, i, z);
        if (iTt == 1) {
            this.tt = true;
        }
        this.ve = System.currentTimeMillis();
        return iTt;
    }

    private boolean uj() {
        return System.currentTimeMillis() - this.ve < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.byazt.g.c.c().tt()) {
            synchronized (this.c) {
                numPoll = this.c.poll();
            }
            this.f29227a.removeCallbacks(this.sp);
            if (numPoll == null) {
                this.tt = false;
                return;
            }
            final Context contextIc = com.byazt.zz.ve.ic();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f29227a.post(new Runnable() { // from class: com.byazt.z.sp.3
                    @Override // java.lang.Runnable
                    public void run() {
                        sp.this.tt(contextIc, numPoll.intValue(), false);
                    }
                });
            } else {
                tt(contextIc, numPoll.intValue(), false);
            }
            this.f29227a.postDelayed(this.sp, 20000L);
        }
    }

    public void c(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        ve();
    }

    public JumpUnknownSourceActivity tt() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.n;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.n = null;
        return jumpUnknownSourceActivity;
    }

    public static sp c() {
        return c.c;
    }

    public int c(final Context context, final int i, final boolean z) {
        if (z) {
            return tt(context, i, z);
        }
        if (uj()) {
            this.f29227a.postDelayed(new Runnable() { // from class: com.byazt.z.sp.4
                @Override // java.lang.Runnable
                public void run() {
                    sp.this.c(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.byazt.g.c.c().tt()) {
            com.byazt.x.c.ve("leaves", "on Foreground");
            return tt(context, i, z);
        }
        if (tt.c()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.c.isEmpty() && !this.tt && z2) {
            return tt(context, i, z);
        }
        int iC = com.byazt.k.c.ve().c("install_queue_size", 3);
        synchronized (this.c) {
            while (this.c.size() > iC) {
                this.c.poll();
            }
        }
        if (z2) {
            this.f29227a.removeCallbacks(this.sp);
            this.f29227a.postDelayed(this.sp, com.byazt.k.c.c(i).c("install_queue_timeout", 20000L));
        }
        synchronized (this.c) {
            if (!this.c.contains(Integer.valueOf(i))) {
                this.c.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    public void c(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.n = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
