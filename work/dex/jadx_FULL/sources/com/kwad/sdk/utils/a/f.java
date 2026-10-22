package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class f implements Executor {
    private Runnable bsA;
    private Runnable bsB;

    private Runnable c(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.bsB;
        this.bsA = runnable;
        this.bsB = null;
        if (runnable != null) {
            d.getExecutor().execute(this.bsA);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.bsA == null) {
            this.bsA = c(runnable);
            d.getExecutor().execute(this.bsA);
        } else {
            if (this.bsB == null) {
                this.bsB = c(runnable);
            }
        }
    }
}
