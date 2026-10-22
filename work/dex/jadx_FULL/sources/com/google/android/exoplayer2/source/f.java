package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeSequenceableLoaderFactory f30902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f4005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SequenceableLoader f4006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ga9 f4007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaPeriod[] f4011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<MediaPeriod> f4008a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<da9, da9> f4009a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IdentityHashMap<SampleStream, Integer> f4010a = new IdentityHashMap<>();
    public MediaPeriod[] b = new MediaPeriod[0];

    public static final class a implements ExoTrackSelection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExoTrackSelection f30903a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final da9 f4012a;

        public a(ExoTrackSelection exoTrackSelection, da9 da9Var) {
            this.f30903a = exoTrackSelection;
            this.f4012a = da9Var;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public com.google.android.exoplayer2.d a() {
            return this.f30903a.a();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int b(com.google.android.exoplayer2.d dVar) {
            return this.f30903a.b(dVar);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public boolean blacklist(int i, long j) {
            return this.f30903a.blacklist(i, j);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.f30903a.c(j, j2, j3, list, mediaChunkIteratorArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public da9 d() {
            return this.f4012a;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void disable() {
            this.f30903a.disable();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public com.google.android.exoplayer2.d e(int i) {
            return this.f30903a.e(i);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void enable() {
            this.f30903a.enable();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30903a.equals(aVar.f30903a) && this.f4012a.equals(aVar.f4012a);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
            return this.f30903a.evaluateQueueSize(j, list);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public boolean f(long j, Chunk chunk, List<? extends MediaChunk> list) {
            return this.f30903a.f(j, chunk, list);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getIndexInTrackGroup(int i) {
            return this.f30903a.getIndexInTrackGroup(i);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectedIndex() {
            return this.f30903a.getSelectedIndex();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectedIndexInTrackGroup() {
            return this.f30903a.getSelectedIndexInTrackGroup();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        @Nullable
        public Object getSelectionData() {
            return this.f30903a.getSelectionData();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectionReason() {
            return this.f30903a.getSelectionReason();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getType() {
            return this.f30903a.getType();
        }

        public int hashCode() {
            return ((527 + this.f4012a.hashCode()) * 31) + this.f30903a.hashCode();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int indexOf(int i) {
            return this.f30903a.indexOf(i);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public boolean isBlacklisted(int i, long j) {
            return this.f30903a.isBlacklisted(i, j);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int length() {
            return this.f30903a.length();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void onDiscontinuity() {
            this.f30903a.onDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void onPlayWhenReadyChanged(boolean z) {
            this.f30903a.onPlayWhenReadyChanged(z);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void onPlaybackSpeed(float f) {
            this.f30903a.onPlaybackSpeed(f);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void onRebuffer() {
            this.f30903a.onRebuffer();
        }
    }

    public static final class b implements MediaPeriod, MediaPeriod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30904a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaPeriod.Callback f4013a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaPeriod f4014a;

        public b(MediaPeriod mediaPeriod, long j) {
            this.f4014a = mediaPeriod;
            this.f30904a = j;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long a(long j, w38 w38Var) {
            return this.f4014a.a(j - this.f30904a, w38Var) + this.f30904a;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void c(MediaPeriod.Callback callback, long j) {
            this.f4013a = callback;
            this.f4014a.c(this, j - this.f30904a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return this.f4014a.continueLoading(j - this.f30904a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
            this.f4014a.discardBuffer(j - this.f30904a, z);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public ga9 e() {
            return this.f4014a.e();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
            int i = 0;
            while (true) {
                SampleStream sampleStreamA = null;
                if (i >= sampleStreamArr.length) {
                    break;
                }
                c cVar = (c) sampleStreamArr[i];
                if (cVar != null) {
                    sampleStreamA = cVar.a();
                }
                sampleStreamArr2[i] = sampleStreamA;
                i++;
            }
            long jF = this.f4014a.f(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j - this.f30904a);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                SampleStream sampleStream = sampleStreamArr2[i2];
                if (sampleStream == null) {
                    sampleStreamArr[i2] = null;
                } else {
                    SampleStream sampleStream2 = sampleStreamArr[i2];
                    if (sampleStream2 == null || ((c) sampleStream2).a() != sampleStream) {
                        sampleStreamArr[i2] = new c(sampleStream, this.f30904a);
                    }
                }
            }
            return jF + this.f30904a;
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) sb0.g(this.f4013a)).d(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.f4014a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f30904a + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.f4014a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f30904a + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.f4014a.getStreamKeys(list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void h(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) sb0.g(this.f4013a)).h(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return this.f4014a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws IOException {
            this.f4014a.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            long discontinuity = this.f4014a.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f30904a + discontinuity;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
            this.f4014a.reevaluateBuffer(j - this.f30904a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            return this.f4014a.seekToUs(j - this.f30904a) + this.f30904a;
        }
    }

    public static final class c implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30905a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SampleStream f4015a;

        public c(SampleStream sampleStream, long j) {
            this.f4015a = sampleStream;
            this.f30905a = j;
        }

        public SampleStream a() {
            return this.f4015a;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            int iB = this.f4015a.b(yk3Var, decoderInputBuffer, i);
            if (iB == -4) {
                decoderInputBuffer.f30576a = Math.max(0L, decoderInputBuffer.f30576a + this.f30905a);
            }
            return iB;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.f4015a.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.f4015a.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return this.f4015a.skipData(j - this.f30905a);
        }
    }

    public f(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f30902a = compositeSequenceableLoaderFactory;
        this.f4011a = mediaPeriodArr;
        this.f4006a = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.f4011a[i] = new b(mediaPeriodArr[i], j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        MediaPeriod[] mediaPeriodArr = this.b;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.f4011a[0]).a(j, w38Var);
    }

    public MediaPeriod b(int i) {
        MediaPeriod mediaPeriod = this.f4011a[i];
        return mediaPeriod instanceof b ? ((b) mediaPeriod).f4014a : mediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f4005a = callback;
        Collections.addAll(this.f4008a, this.f4011a);
        for (MediaPeriod mediaPeriod : this.f4011a) {
            mediaPeriod.c(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.f4008a.isEmpty()) {
            return this.f4006a.continueLoading(j);
        }
        int size = this.f4008a.size();
        for (int i = 0; i < size; i++) {
            this.f4008a.get(i).continueLoading(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (MediaPeriod mediaPeriod : this.b) {
            mediaPeriod.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return (ga9) sb0.g(this.f4007a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        Integer num;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        int i = 0;
        while (true) {
            num = null;
            if (i >= exoTrackSelectionArr.length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr[i];
            num = sampleStream != null ? this.f4010a.get(sampleStream) : null;
            iArr[i] = num == null ? -1 : num.intValue();
            iArr2[i] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                da9 da9Var = (da9) sb0.g(this.f4009a.get(exoTrackSelection.d()));
                int i2 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.f4011a;
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i2].e().c(da9Var) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
            i++;
        }
        this.f4010a.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        Object[] objArr = new ExoTrackSelection[exoTrackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.f4011a.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.f4011a.length) {
            for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
                sampleStreamArr3[i4] = iArr[i4] == i3 ? sampleStreamArr[i4] : num;
                if (iArr2[i4] == i3) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) sb0.g(exoTrackSelectionArr[i4]);
                    objArr[i4] = new a(exoTrackSelection2, (da9) sb0.g(this.f4009a.get(exoTrackSelection2.d())));
                } else {
                    objArr[i4] = num;
                }
            }
            int i5 = i3;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jF = this.f4011a[i3].f(objArr, zArr, sampleStreamArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jF;
            } else if (jF != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    SampleStream sampleStream2 = (SampleStream) sb0.g(sampleStreamArr3[i6]);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    this.f4010a.put(sampleStream2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    sb0.i(sampleStreamArr3[i6] == 0);
                }
            }
            if (z) {
                arrayList2.add(this.f4011a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        MediaPeriod[] mediaPeriodArr2 = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[0]);
        this.b = mediaPeriodArr2;
        this.f4006a = this.f30902a.a(mediaPeriodArr2);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) sb0.g(this.f4005a)).d(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f4006a.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f4006a.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void h(MediaPeriod mediaPeriod) {
        this.f4008a.remove(mediaPeriod);
        if (!this.f4008a.isEmpty()) {
            return;
        }
        int i = 0;
        for (MediaPeriod mediaPeriod2 : this.f4011a) {
            i += mediaPeriod2.e().K;
        }
        da9[] da9VarArr = new da9[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f4011a;
            if (i2 >= mediaPeriodArr.length) {
                this.f4007a = new ga9(da9VarArr);
                ((MediaPeriod.Callback) sb0.g(this.f4005a)).h(this);
                return;
            }
            ga9 ga9VarE = mediaPeriodArr[i2].e();
            int i4 = ga9VarE.K;
            int i5 = 0;
            while (i5 < i4) {
                da9 da9VarB = ga9VarE.b(i5);
                da9 da9VarB2 = da9VarB.b(i2 + u15.f19942b + da9VarB.f);
                this.f4009a.put(da9VarB2, da9VarB);
                da9VarArr[i3] = da9VarB2;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f4006a.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod mediaPeriod : this.f4011a) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.b) {
            long discontinuity = mediaPeriod.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                if (j != -9223372036854775807L && mediaPeriod.seekToUs(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (MediaPeriod mediaPeriod2 : this.b) {
                    if (mediaPeriod2 == mediaPeriod) {
                        break;
                    }
                    if (mediaPeriod2.seekToUs(discontinuity) != discontinuity) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = discontinuity;
            } else if (discontinuity != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f4006a.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        long jSeekToUs = this.b[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.b;
            if (i >= mediaPeriodArr.length) {
                return jSeekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }
}
