package com.byazt.mc;

import com.byazt.bwm.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 91})
public final class sp extends Thread {
    public volatile Thread c;
    public volatile boolean tt;
    public final Thread ve;

    public sp(Thread thread) {
        this.ve = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.c != null) {
            this.c.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.c != null) {
            return this.c.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.tt) {
            return;
        }
        this.tt = true;
        i.tt.da().execute(new com.byazt.msj.ve(new Runnable() { // from class: com.byazt.mc.sp.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.tt.z()) {
                    sp.this.c();
                } else {
                    sp.this.tt();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            tt ttVarVe = i.tt.ve();
            String name2 = this.ve.getName();
            if (ttVarVe != null) {
                name2 = ttVarVe.c(name2);
            }
            threadCurrentThread.setName(name2);
            this.c = threadCurrentThread;
            threadCurrentThread.setPriority(this.ve.getPriority());
            this.ve.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        Thread threadCurrentThread = Thread.currentThread();
        this.c = threadCurrentThread;
        threadCurrentThread.setPriority(this.ve.getPriority());
        this.ve.run();
    }
}
