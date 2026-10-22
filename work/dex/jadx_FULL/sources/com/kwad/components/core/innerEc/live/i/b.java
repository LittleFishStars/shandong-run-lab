package com.kwad.components.core.innerEc.live.i;

import android.view.View;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements View.OnClickListener {
    private final View.OnClickListener XJ;
    private long wA = 0;

    public b(View.OnClickListener onClickListener) {
        this.XJ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (System.currentTimeMillis() - this.wA >= 500) {
                this.XJ.onClick(view);
                this.wA = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
