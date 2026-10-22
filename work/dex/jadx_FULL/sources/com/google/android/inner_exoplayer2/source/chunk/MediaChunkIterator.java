package com.google.android.inner_exoplayer2.source.chunk;

import com.google.android.inner_exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY = new MediaChunkIterator() { // from class: com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator.1
        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            throw new NoSuchElementException();
        }

        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public boolean isEnded() {
            return true;
        }

        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public boolean next() {
            return false;
        }

        @Override // com.google.android.inner_exoplayer2.source.chunk.MediaChunkIterator
        public void reset() {
        }
    };

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}
