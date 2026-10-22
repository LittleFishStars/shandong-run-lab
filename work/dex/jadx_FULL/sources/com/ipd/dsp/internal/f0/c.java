package com.ipd.dsp.internal.f0;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface c {
    void connectEnd(@NonNull f fVar, @IntRange(from = 0) int i, int i2, @NonNull Map<String, List<String>> map);

    void connectStart(@NonNull f fVar, @IntRange(from = 0) int i, @NonNull Map<String, List<String>> map);

    void connectTrialEnd(@NonNull f fVar, int i, @NonNull Map<String, List<String>> map);

    void connectTrialStart(@NonNull f fVar, @NonNull Map<String, List<String>> map);

    void downloadFromBeginning(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2);

    void downloadFromBreakpoint(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar);

    void fetchEnd(@NonNull f fVar, @IntRange(from = 0) int i, @IntRange(from = 0) long j);

    void fetchProgress(@NonNull f fVar, @IntRange(from = 0) int i, @IntRange(from = 0) long j);

    void fetchStart(@NonNull f fVar, @IntRange(from = 0) int i, @IntRange(from = 0) long j);

    void taskEnd(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc);

    void taskStart(@NonNull f fVar);
}
