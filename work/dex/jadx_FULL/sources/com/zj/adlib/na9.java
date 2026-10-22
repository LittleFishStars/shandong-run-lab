package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class na9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackSelection[] f18382a;
    public int b;

    public na9(TrackSelection... trackSelectionArr) {
        this.f18382a = trackSelectionArr;
        this.f43484a = trackSelectionArr.length;
    }

    @Nullable
    public TrackSelection a(int i) {
        return this.f18382a[i];
    }

    public TrackSelection[] b() {
        return (TrackSelection[]) this.f18382a.clone();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || na9.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f18382a, ((na9) obj).f18382a);
    }

    public int hashCode() {
        if (this.b == 0) {
            this.b = 527 + Arrays.hashCode(this.f18382a);
        }
        return this.b;
    }
}
