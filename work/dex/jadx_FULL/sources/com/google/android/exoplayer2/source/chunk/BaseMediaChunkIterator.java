package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30857a;
    public final long b;
    public long c;

    public BaseMediaChunkIterator(long j, long j2) {
        this.f30857a = j;
        this.b = j2;
        reset();
    }

    public final void checkInBounds() {
        long j = this.c;
        if (j < this.f30857a || j > this.b) {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        return this.c > this.b;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        this.c++;
        return !isEnded();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public void reset() {
        this.c = this.f30857a - 1;
    }
}
