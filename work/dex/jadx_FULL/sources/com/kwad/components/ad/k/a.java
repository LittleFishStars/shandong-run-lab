package com.kwad.components.ad.k;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a<L extends i> {
    public AdTemplate mAdTemplate;

    public a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public abstract void a(L l);

    @MainThread
    public abstract void b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean ln() {
        return false;
    }

    public abstract void pause();

    @WorkerThread
    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }
}
