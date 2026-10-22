package com.kwad.sdk.core.videocache.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean aQ(long j) {
        return j <= this.maxSize;
    }
}
