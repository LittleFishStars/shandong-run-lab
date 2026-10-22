package com.kwad.components.core.t;

import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j {
    private static long alA;
    private boolean alB;
    private long alC;
    private long alz;

    public j() {
        this(false);
    }

    public final void a(View view, @NonNull View.OnClickListener onClickListener) {
        com.kwad.sdk.core.d.c.d("click", "cur:" + SystemClock.elapsedRealtime() + " pre:" + this.alz + " global:" + this.alB + " gt:" + alA);
        if (SystemClock.elapsedRealtime() - (this.alB ? alA : this.alz) > this.alC) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.alz = jElapsedRealtime;
            alA = jElapsedRealtime;
            onClickListener.onClick(view);
        }
    }

    public j(boolean z) {
        this(z, 1000L);
    }

    private j(boolean z, long j) {
        this.alB = z;
        this.alC = 1000L;
    }
}
