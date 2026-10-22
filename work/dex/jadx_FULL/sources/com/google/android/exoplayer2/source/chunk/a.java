package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements ChunkExtractor.TrackOutputProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30863a = "BaseMediaChunkOutput";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SampleQueue[] f3865a;

    public a(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f3864a = iArr;
        this.f3865a = sampleQueueArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f3865a.length];
        int i = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f3865a;
            if (i >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i] = sampleQueueArr[i].H();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider
    public TrackOutput b(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f3864a;
            if (i3 >= iArr.length) {
                Log.d(f30863a, "Unmatched track of type: " + i2);
                return new com.google.android.exoplayer2.extractor.d();
            }
            if (i2 == iArr[i3]) {
                return this.f3865a[i3];
            }
            i3++;
        }
    }

    public void c(long j) {
        for (SampleQueue sampleQueue : this.f3865a) {
            sampleQueue.a0(j);
        }
    }
}
