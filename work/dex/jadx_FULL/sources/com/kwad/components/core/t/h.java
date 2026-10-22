package com.kwad.components.core.t;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h {
    private long FG;
    private a alu;
    private long als = 100;
    private long alt = 0;
    private boolean Sw = false;

    @Nullable
    private Handler alv = new Handler(Looper.getMainLooper());
    private Runnable alw = new Runnable() { // from class: com.kwad.components.core.t.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.alv == null) {
                return;
            }
            if (h.this.Sw) {
                h.this.alv.postDelayed(this, h.this.als / 2);
                return;
            }
            h.this.wK();
            if (h.this.alv != null) {
                h.this.alv.postDelayed(this, h.this.als);
            }
        }
    };

    public interface a {
        void onProgress(long j, long j2);
    }

    public h(long j) {
        this.FG = j;
    }

    public final void pause() {
        this.Sw = true;
    }

    public final void resume() {
        this.Sw = false;
    }

    public final void start() {
        Handler handler = this.alv;
        if (handler == null) {
            return;
        }
        handler.post(this.alw);
    }

    public final void stop() {
        Handler handler = this.alv;
        if (handler != null) {
            handler.removeCallbacks(this.alw);
            this.alv = null;
        }
    }

    public final void wK() {
        a aVar = this.alu;
        if (aVar != null) {
            long j = this.FG;
            long j2 = j - this.alt;
            aVar.onProgress(j2, j);
            if (j2 <= 0) {
                stop();
            }
        }
        this.alt += this.als;
    }

    public final void a(a aVar) {
        this.alu = aVar;
    }
}
