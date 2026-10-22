package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.zj.adlib.da9;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final da9 f31026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f4648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d[] f4649a;
    public final int c;
    public final int d;
    public int e;

    public BaseTrackSelection(da9 da9Var, int... iArr) {
        this(da9Var, iArr, 0);
    }

    public static /* synthetic */ int h(d dVar, d dVar2) {
        return dVar2.O - dVar.O;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final d a() {
        return this.f4649a[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int b(d dVar) {
        for (int i = 0; i < this.c; i++) {
            if (this.f4649a[i] == dVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean blacklist(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.c && !zIsBlacklisted) {
            zIsBlacklisted = (i2 == i || isBlacklisted(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.f4648a;
        jArr[i] = Math.max(jArr[i], gj9.b(jElapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final da9 d() {
        return this.f31026a;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final d e(int i) {
        return this.f4649a[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.f31026a == baseTrackSelection.f31026a && Arrays.equals(this.f4647a, baseTrackSelection.f4647a);
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i) {
        return this.f4647a[i];
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.f4647a[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getType() {
        return this.d;
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = (System.identityHashCode(this.f31026a) * 31) + Arrays.hashCode(this.f4647a);
        }
        return this.e;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.c; i2++) {
            if (this.f4647a[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public boolean isBlacklisted(int i, long j) {
        return this.f4648a[i] > j;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.f4647a.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void onPlaybackSpeed(float f) {
    }

    public BaseTrackSelection(da9 da9Var, int[] iArr, int i) {
        int i2 = 0;
        sb0.i(iArr.length > 0);
        this.d = i;
        this.f31026a = (da9) sb0.g(da9Var);
        int length = iArr.length;
        this.c = length;
        this.f4649a = new d[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f4649a[i3] = da9Var.c(iArr[i3]);
        }
        Arrays.sort(this.f4649a, new Comparator() { // from class: com.zj.adlib.tr0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BaseTrackSelection.h((d) obj, (d) obj2);
            }
        });
        this.f4647a = new int[this.c];
        while (true) {
            int i4 = this.c;
            if (i2 >= i4) {
                this.f4648a = new long[i4];
                return;
            } else {
                this.f4647a[i2] = da9Var.d(this.f4649a[i2]);
                i2++;
            }
        }
    }
}
