package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.yh3;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection a(ExoTrackSelection.a aVar);
    }

    public static p a(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            TrackSelection trackSelection = trackSelectionArr[i];
            listArr[i] = trackSelection != null ? ImmutableList.of(trackSelection) : ImmutableList.of();
        }
        return b(mappedTrackInfo, listArr);
    }

    public static p b(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z;
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < mappedTrackInfo.d(); i++) {
            ga9 ga9VarH = mappedTrackInfo.h(i);
            List<? extends TrackSelection> list = listArr[i];
            for (int i2 = 0; i2 < ga9VarH.K; i2++) {
                da9 da9VarB = ga9VarH.b(i2);
                boolean z2 = mappedTrackInfo.a(i, i2, false) != 0;
                int i3 = da9VarB.K;
                int[] iArr = new int[i3];
                boolean[] zArr = new boolean[i3];
                for (int i4 = 0; i4 < da9VarB.K; i4++) {
                    iArr[i4] = mappedTrackInfo.i(i, i2, i4);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= list.size()) {
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection = list.get(i5);
                        if (trackSelection.d().equals(da9VarB) && trackSelection.indexOf(i4) != -1) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    zArr[i4] = z;
                }
                aVar.a(new p.a(da9VarB, z2, iArr, zArr));
            }
        }
        ga9 ga9VarK = mappedTrackInfo.k();
        for (int i6 = 0; i6 < ga9VarK.K; i6++) {
            da9 da9VarB2 = ga9VarK.b(i6);
            int[] iArr2 = new int[da9VarB2.K];
            Arrays.fill(iArr2, 0);
            aVar.a(new p.a(da9VarB2, false, iArr2, new boolean[da9VarB2.K]));
        }
        return new p(aVar.e());
    }

    public static LoadErrorHandlingPolicy.a c(ExoTrackSelection exoTrackSelection) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (exoTrackSelection.isBlacklisted(i2, jElapsedRealtime)) {
                i++;
            }
        }
        return new LoadErrorHandlingPolicy.a(1, 0, length, i);
    }

    public static ExoTrackSelection[] d(ExoTrackSelection.a[] aVarArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[aVarArr.length];
        boolean z = false;
        for (int i = 0; i < aVarArr.length; i++) {
            ExoTrackSelection.a aVar = aVarArr[i];
            if (aVar != null) {
                int[] iArr = aVar.f4676a;
                if (iArr.length <= 1 || z) {
                    exoTrackSelectionArr[i] = new yh3(aVar.f4675a, iArr[0], aVar.f4674a);
                } else {
                    exoTrackSelectionArr[i] = adaptiveTrackSelectionFactory.a(aVar);
                    z = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    public static DefaultTrackSelector.d e(DefaultTrackSelector.d dVar, int i, ga9 ga9Var, boolean z, @Nullable DefaultTrackSelector.f fVar) {
        DefaultTrackSelector.d.a aVarD1 = dVar.a().K0(i).D1(i, z);
        if (fVar != null) {
            aVarD1.F1(i, ga9Var, fVar);
        }
        return aVarD1.B();
    }
}
