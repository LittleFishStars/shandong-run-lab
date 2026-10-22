package com.kwad.components.core.h;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements Runnable {
    private InterfaceC1202a Sy;

    @Nullable
    private volatile Handler jk;
    private long Sv = 1000;
    private boolean Sw = true;
    private long Sx = 0;
    private float mSpeed = 1.0f;

    /* JADX INFO: renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC1202a {
        void G(long j);
    }

    public a(Handler handler) {
        this.jk = handler;
    }

    public final void a(InterfaceC1202a interfaceC1202a) {
        this.Sy = interfaceC1202a;
    }

    public final void destroy() {
        stop();
        this.jk = null;
    }

    public final void pause() {
        this.Sw = true;
    }

    public final void resume() {
        this.Sw = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC1202a interfaceC1202a;
        if (this.jk != null) {
            if (!this.Sw && (interfaceC1202a = this.Sy) != null) {
                interfaceC1202a.G(this.Sx);
                this.Sx += this.Sv;
            }
            if (this.jk != null) {
                this.jk.postDelayed(this, (long) (this.Sv / this.mSpeed));
            }
        }
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    public final void start() {
        this.Sw = false;
        if (this.jk != null) {
            this.jk.post(this);
        }
    }

    public final void stop() {
        if (this.jk != null) {
            this.jk.removeCallbacks(this);
        }
    }
}
