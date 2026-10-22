package com.google.android.inner_exoplayer2.extractor;

import com.google.android.inner_exoplayer2.upstream.DataReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface ExtractorInput extends DataReader {
    void advancePeekPosition(int i);

    boolean advancePeekPosition(int i, boolean z);

    long getLength();

    long getPeekPosition();

    long getPosition();

    int peek(byte[] bArr, int i, int i2);

    void peekFully(byte[] bArr, int i, int i2);

    boolean peekFully(byte[] bArr, int i, int i2, boolean z);

    @Override // com.google.android.inner_exoplayer2.upstream.DataReader
    int read(byte[] bArr, int i, int i2);

    void readFully(byte[] bArr, int i, int i2);

    boolean readFully(byte[] bArr, int i, int i2, boolean z);

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j, E e);

    int skip(int i);

    void skipFully(int i);

    boolean skipFully(int i, boolean z);
}
