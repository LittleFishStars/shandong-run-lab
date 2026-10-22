package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.ue7;
import com.zj.adlib.wa9;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class MappingTrackSelector extends TrackSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public MappedTrackInfo f31040a;

    public static final class MappedTrackInfo {
        public static final int b = 0;
        public static final int c = 1;
        public static final int d = 2;
        public static final int e = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31041a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ga9 f4677a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f4678a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ga9[] f4679a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f4680a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[][][] f4681a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int[] f4682b;

        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RendererSupport {
        }

        @VisibleForTesting
        public MappedTrackInfo(String[] strArr, int[] iArr, ga9[] ga9VarArr, int[] iArr2, int[][][] iArr3, ga9 ga9Var) {
            this.f4680a = strArr;
            this.f4678a = iArr;
            this.f4679a = ga9VarArr;
            this.f4681a = iArr3;
            this.f4682b = iArr2;
            this.f4677a = ga9Var;
            this.f31041a = iArr.length;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.f4679a[i].b(i2).K;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i(i, i2, i5);
                if (i6 == 4 || (z && i6 == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int b(int i, int i2, int[] iArr) {
            int i3 = 0;
            int iMin = 16;
            String str = null;
            boolean z = false;
            int i4 = 0;
            while (i3 < iArr.length) {
                String str2 = this.f4679a[i].b(i2).c(iArr[i3]).k;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !gj9.c(str, str2);
                }
                iMin = Math.min(iMin, RendererCapabilities.getAdaptiveSupport(this.f4681a[i][i2][i3]));
                i3++;
                i4 = i5;
            }
            return z ? Math.min(iMin, this.f4682b[i]) : iMin;
        }

        public int c(int i, int i2, int i3) {
            return this.f4681a[i][i2][i3];
        }

        public int d() {
            return this.f31041a;
        }

        public String e(int i) {
            return this.f4680a[i];
        }

        public int f(int i) {
            int iMax = 0;
            for (int[] iArr : this.f4681a[i]) {
                for (int i2 : iArr) {
                    int formatSupport = RendererCapabilities.getFormatSupport(i2);
                    int i3 = 1;
                    if (formatSupport != 0 && formatSupport != 1 && formatSupport != 2) {
                        if (formatSupport != 3) {
                            if (formatSupport == 4) {
                                return 3;
                            }
                            throw new IllegalStateException();
                        }
                        i3 = 2;
                    }
                    iMax = Math.max(iMax, i3);
                }
            }
            return iMax;
        }

        public int g(int i) {
            return this.f4678a[i];
        }

        public ga9 h(int i) {
            return this.f4679a[i];
        }

        public int i(int i, int i2, int i3) {
            return RendererCapabilities.getFormatSupport(c(i, i2, i3));
        }

        public int j(int i) {
            int iMax = 0;
            for (int i2 = 0; i2 < this.f31041a; i2++) {
                if (this.f4678a[i2] == i) {
                    iMax = Math.max(iMax, f(i2));
                }
            }
            return iMax;
        }

        public ga9 k() {
            return this.f4677a;
        }
    }

    public static int i(RendererCapabilities[] rendererCapabilitiesArr, da9 da9Var, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < rendererCapabilitiesArr.length; i2++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < da9Var.K; i3++) {
                iMax = Math.max(iMax, RendererCapabilities.getFormatSupport(rendererCapabilities.e(da9Var.c(i3))));
            }
            boolean z3 = iArr[i2] == 0;
            if (iMax > i || (iMax == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = iMax;
            }
        }
        return length;
    }

    public static int[] k(RendererCapabilities rendererCapabilities, da9 da9Var) throws ExoPlaybackException {
        int[] iArr = new int[da9Var.K];
        for (int i = 0; i < da9Var.K; i++) {
            iArr[i] = rendererCapabilities.e(da9Var.c(i));
        }
        return iArr;
    }

    public static int[] l(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rendererCapabilitiesArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void d(@Nullable Object obj) {
        this.f31040a = (MappedTrackInfo) obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final wa9 f(RendererCapabilities[] rendererCapabilitiesArr, ga9 ga9Var, MediaSource.a aVar, Timeline timeline) throws ExoPlaybackException {
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        da9[][] da9VarArr = new da9[length][];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = ga9Var.K;
            da9VarArr[i] = new da9[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrL = l(rendererCapabilitiesArr);
        for (int i3 = 0; i3 < ga9Var.K; i3++) {
            da9 da9VarB = ga9Var.b(i3);
            int i4 = i(rendererCapabilitiesArr, da9VarB, iArr, da9VarB.L == 5);
            int[] iArrK = i4 == rendererCapabilitiesArr.length ? new int[da9VarB.K] : k(rendererCapabilitiesArr[i4], da9VarB);
            int i5 = iArr[i4];
            da9VarArr[i4][i5] = da9VarB;
            iArr2[i4][i5] = iArrK;
            iArr[i4] = i5 + 1;
        }
        ga9[] ga9VarArr = new ga9[rendererCapabilitiesArr.length];
        String[] strArr = new String[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
            int i7 = iArr[i6];
            ga9VarArr[i6] = new ga9((da9[]) gj9.e1(da9VarArr[i6], i7));
            iArr2[i6] = (int[][]) gj9.e1(iArr2[i6], i7);
            strArr[i6] = rendererCapabilitiesArr[i6].getName();
            iArr3[i6] = rendererCapabilitiesArr[i6].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr3, ga9VarArr, iArrL, iArr2, new ga9((da9[]) gj9.e1(da9VarArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length])));
        Pair<ue7[], ExoTrackSelection[]> pairSelectTracks = selectTracks(mappedTrackInfo, iArr2, iArrL, aVar, timeline);
        return new wa9((ue7[]) pairSelectTracks.first, (ExoTrackSelection[]) pairSelectTracks.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[]) pairSelectTracks.second), mappedTrackInfo);
    }

    @Nullable
    public final MappedTrackInfo j() {
        return this.f31040a;
    }

    public abstract Pair<ue7[], ExoTrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.a aVar, Timeline timeline) throws ExoPlaybackException;
}
