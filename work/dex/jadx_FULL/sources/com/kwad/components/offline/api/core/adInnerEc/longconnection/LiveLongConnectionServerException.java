package com.kwad.components.offline.api.core.adInnerEc.longconnection;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public class LiveLongConnectionServerException extends ServerException {
    private static final long serialVersionUID = -4435167903777863038L;
    public final long mMaxDelayMs;
    public final long mMinDelayMs;

    public LiveLongConnectionServerException(int i, int i2, String str, long j, long j2) {
        super(i, i2, str);
        this.mMinDelayMs = j;
        this.mMaxDelayMs = j2;
    }
}
