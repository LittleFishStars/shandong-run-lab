package com.google.android.inner_exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.drm.DrmSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class FormatHolder {

    @Nullable
    public DrmSession drmSession;

    @Nullable
    public Format format;

    public void clear() {
        this.drmSession = null;
        this.format = null;
    }
}
