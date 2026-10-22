package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaChunkIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaChunkIterator f30862a = new a();

    public class a implements MediaChunkIterator {
        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec a() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public boolean isEnded() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public boolean next() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public void reset() {
        }
    }

    DataSpec a();

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    boolean isEnded();

    boolean next();

    void reset();
}
