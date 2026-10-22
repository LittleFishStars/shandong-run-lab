package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.primitives.Ints;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.h89;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import com.zj.adlib.w38;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    public final int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrmSessionEventListener.a f30922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f4146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f4147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f4148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SequenceableLoader f4149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsDataSourceFactory f4150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsExtractorFactory f4151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsPlaylistTracker f4152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f4153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TransferListener f4155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f4156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ga9 f4157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4160a;
    public final boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IdentityHashMap<SampleStream, Integer> f4159a = new IdentityHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h89 f4158a = new h89();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HlsSampleStreamWrapper[] f4161a = new HlsSampleStreamWrapper[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public HlsSampleStreamWrapper[] f4163b = new HlsSampleStreamWrapper[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[][] f4162a = new int[0][];

    public c(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i, boolean z2, at6 at6Var) {
        this.f4151a = hlsExtractorFactory;
        this.f4152a = hlsPlaylistTracker;
        this.f4150a = hlsDataSourceFactory;
        this.f4155a = transferListener;
        this.f4145a = drmSessionManager;
        this.f30922a = aVar;
        this.f4154a = loadErrorHandlingPolicy;
        this.f4148a = aVar2;
        this.f4153a = allocator;
        this.f4146a = compositeSequenceableLoaderFactory;
        this.f4160a = z;
        this.K = i;
        this.b = z2;
        this.f4156a = at6Var;
        this.f4149a = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
    }

    public static d l(d dVar, @Nullable d dVar2, boolean z) {
        String strT;
        Metadata metadata;
        int i;
        String str;
        int i2;
        int i3;
        String str2;
        if (dVar2 != null) {
            strT = dVar2.i;
            metadata = dVar2.f2567a;
            i2 = dVar2.U;
            i = dVar2.K;
            i3 = dVar2.L;
            str = dVar2.h;
            str2 = dVar2.g;
        } else {
            strT = gj9.T(dVar.i, 1);
            metadata = dVar.f2567a;
            if (z) {
                i2 = dVar.U;
                i = dVar.K;
                i3 = dVar.L;
                str = dVar.h;
                str2 = dVar.g;
            } else {
                i = 0;
                str = null;
                i2 = -1;
                i3 = 0;
                str2 = null;
            }
        }
        return new d.b().S(dVar.f).U(str2).K(dVar.j).e0(bp5.g(strT)).I(strT).X(metadata).G(z ? dVar.M : -1).Z(z ? dVar.N : -1).H(i2).g0(i).c0(i3).V(str).E();
    }

    public static Map<String, DrmInitData> m(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitDataMerge = list.get(i);
            String str = drmInitDataMerge.schemeType;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData.schemeType, str)) {
                    drmInitDataMerge = drmInitDataMerge.merge(drmInitData);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            map.put(str, drmInitDataMerge);
        }
        return map;
    }

    public static d n(d dVar) {
        String strT = gj9.T(dVar.i, 2);
        return new d.b().S(dVar.f).U(dVar.g).K(dVar.j).e0(bp5.g(strT)).I(strT).X(dVar.f2567a).G(dVar.M).Z(dVar.N).j0(dVar.Q).Q(dVar.R).P(dVar.f2564a).g0(dVar.K).c0(dVar.L).E();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4163b) {
            if (hlsSampleStreamWrapper.F()) {
                return hlsSampleStreamWrapper.a(j, w38Var);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public boolean b(Uri uri, LoadErrorHandlingPolicy.c cVar, boolean z) {
        boolean zQ = true;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            zQ &= hlsSampleStreamWrapper.Q(uri, cVar, z);
        }
        this.f4147a.d(this);
        return zQ;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f4147a = callback;
        this.f4152a.b(this);
        j(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.f4157a != null) {
            return this.f4149a.continueLoading(j);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            hlsSampleStreamWrapper.n();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4163b) {
            hlsSampleStreamWrapper.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return (ga9) sb0.g(this.f4157a);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00df  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr2[i];
            iArr[i] = sampleStream == null ? -1 : this.f4159a.get(sampleStream).intValue();
            iArr2[i] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                da9 da9VarD = exoTrackSelection.d();
                int i2 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f4161a;
                    if (i2 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[i2].e().c(da9VarD) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.f4159a.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.f4161a.length];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i4 < this.f4161a.length) {
            for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
                ExoTrackSelection exoTrackSelection2 = null;
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    exoTrackSelection2 = exoTrackSelectionArr[i5];
                }
                exoTrackSelectionArr2[i5] = exoTrackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f4161a[i4];
            int i6 = i3;
            int i7 = length;
            int i8 = i4;
            ExoTrackSelection[] exoTrackSelectionArr3 = exoTrackSelectionArr2;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean Z = hlsSampleStreamWrapper.Z(exoTrackSelectionArr2, zArr, sampleStreamArr4, zArr2, j, z);
            int i9 = 0;
            boolean z2 = false;
            while (true) {
                if (i9 >= exoTrackSelectionArr.length) {
                    break;
                }
                SampleStream sampleStream2 = sampleStreamArr4[i9];
                if (iArr2[i9] == i8) {
                    sb0.g(sampleStream2);
                    sampleStreamArr3[i9] = sampleStream2;
                    this.f4159a.put(sampleStream2, Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i9] == i8) {
                    sb0.i(sampleStream2 == null);
                }
                i9++;
            }
            if (z2) {
                hlsSampleStreamWrapperArr3[i6] = hlsSampleStreamWrapper;
                i3 = i6 + 1;
                if (i6 == 0) {
                    hlsSampleStreamWrapper.c0(true);
                    if (Z) {
                        this.f4158a.b();
                        z = true;
                    } else {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.f4163b;
                        if (hlsSampleStreamWrapperArr4.length == 0 || hlsSampleStreamWrapper != hlsSampleStreamWrapperArr4[0]) {
                            this.f4158a.b();
                            z = true;
                        }
                    }
                } else {
                    hlsSampleStreamWrapper.c0(i8 < this.M);
                }
            } else {
                i3 = i6;
            }
            i4 = i8 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i7;
            exoTrackSelectionArr2 = exoTrackSelectionArr3;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) gj9.e1(hlsSampleStreamWrapperArr2, i3);
        this.f4163b = hlsSampleStreamWrapperArr5;
        this.f4149a = this.f4146a.a(hlsSampleStreamWrapperArr5);
        return j;
    }

    public final void g(long j, List<com.google.android.exoplayer2.source.hls.playlist.c.a> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).b;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (gj9.c(str, list.get(i2).b)) {
                        com.google.android.exoplayer2.source.hls.playlist.c.a aVar = list.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(aVar.f30935a);
                        arrayList2.add(aVar.f4267a);
                        z &= gj9.S(aVar.f4267a.i, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper hlsSampleStreamWrapperK = k(str2, 1, (Uri[]) arrayList.toArray((Uri[]) gj9.l(new Uri[0])), (d[]) arrayList2.toArray(new d[0]), null, Collections.emptyList(), map, j);
                list3.add(Ints.B(arrayList3));
                list2.add(hlsSampleStreamWrapperK);
                if (this.f4160a && z) {
                    hlsSampleStreamWrapperK.T(new da9[]{new da9(str2, (d[]) arrayList2.toArray(new d[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f4149a.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f4149a.getNextLoadPositionUs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        int[] iArr;
        ga9 ga9VarE;
        int iY;
        c cVar = this;
        com.google.android.exoplayer2.source.hls.playlist.c cVar2 = (com.google.android.exoplayer2.source.hls.playlist.c) sb0.g(cVar.f4152a.d());
        boolean z = !cVar2.f4266c.isEmpty();
        int length = cVar.f4161a.length - cVar2.f.size();
        int i = 0;
        if (z) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = cVar.f4161a[0];
            iArr = cVar.f4162a[0];
            ga9VarE = hlsSampleStreamWrapper.e();
            iY = hlsSampleStreamWrapper.y();
        } else {
            iArr = new int[0];
            ga9VarE = ga9.f16735a;
            iY = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (ExoTrackSelection exoTrackSelection : list) {
            da9 da9VarD = exoTrackSelection.d();
            int iC = ga9VarE.c(da9VarD);
            if (iC == -1) {
                ?? r15 = z;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = cVar.f4161a;
                    if (r15 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[r15].e().c(da9VarD) != -1) {
                        int i2 = r15 < length ? 1 : 2;
                        int[] iArr2 = cVar.f4162a[r15];
                        for (int i3 = 0; i3 < exoTrackSelection.length(); i3++) {
                            arrayList.add(new StreamKey(i2, iArr2[exoTrackSelection.getIndexInTrackGroup(i3)]));
                        }
                        break;
                    }
                    cVar = this;
                    r15++;
                }
            } else if (iC == iY) {
                for (int i4 = i; i4 < exoTrackSelection.length(); i4++) {
                    arrayList.add(new StreamKey(i, iArr[exoTrackSelection.getIndexInTrackGroup(i4)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
            cVar = this;
            i = 0;
        }
        if (z2 && !z3) {
            int i5 = iArr[0];
            int i6 = cVar2.f4266c.get(i5).f4269a.O;
            for (int i7 = 1; i7 < iArr.length; i7++) {
                int i8 = cVar2.f4266c.get(iArr[i7]).f4269a.O;
                if (i8 < i6) {
                    i5 = iArr[i7];
                    i6 = i8;
                }
            }
            arrayList.add(new StreamKey(0, i5));
        }
        return arrayList;
    }

    public final void i(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j, List<HlsSampleStreamWrapper> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z;
        boolean z2;
        int size = cVar.f4266c.size();
        int[] iArr = new int[size];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cVar.f4266c.size(); i3++) {
            d dVar = cVar.f4266c.get(i3).f4269a;
            if (dVar.R > 0 || gj9.T(dVar.i, 2) != null) {
                iArr[i3] = 2;
                i++;
            } else if (gj9.T(dVar.i, 1) != null) {
                iArr[i3] = 1;
                i2++;
            } else {
                iArr[i3] = -1;
            }
        }
        if (i > 0) {
            size = i;
            z = true;
            z2 = false;
        } else if (i2 < size) {
            size -= i2;
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        Uri[] uriArr = new Uri[size];
        d[] dVarArr = new d[size];
        int[] iArr2 = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < cVar.f4266c.size(); i5++) {
            if ((!z || iArr[i5] == 2) && (!z2 || iArr[i5] != 1)) {
                com.google.android.exoplayer2.source.hls.playlist.c.b bVar = cVar.f4266c.get(i5);
                uriArr[i4] = bVar.f30936a;
                dVarArr[i4] = bVar.f4269a;
                iArr2[i4] = i5;
                i4++;
            }
        }
        String str = dVarArr[0].i;
        int iS = gj9.S(str, 2);
        int iS2 = gj9.S(str, 1);
        boolean z3 = (iS2 == 1 || (iS2 == 0 && cVar.e.isEmpty())) && iS <= 1 && iS2 + iS > 0;
        HlsSampleStreamWrapper hlsSampleStreamWrapperK = k("main", (z || iS2 <= 0) ? 0 : 1, uriArr, dVarArr, cVar.f4263a, cVar.h, map, j);
        list.add(hlsSampleStreamWrapperK);
        list2.add(iArr2);
        if (this.f4160a && z3) {
            ArrayList arrayList = new ArrayList();
            if (iS > 0) {
                d[] dVarArr2 = new d[size];
                for (int i6 = 0; i6 < size; i6++) {
                    dVarArr2[i6] = n(dVarArr[i6]);
                }
                arrayList.add(new da9("main", dVarArr2));
                if (iS2 > 0 && (cVar.f4263a != null || cVar.e.isEmpty())) {
                    arrayList.add(new da9("main:audio", l(dVarArr[0], cVar.f4263a, false)));
                }
                List<d> list3 = cVar.h;
                if (list3 != null) {
                    for (int i7 = 0; i7 < list3.size(); i7++) {
                        arrayList.add(new da9("main:cc:" + i7, list3.get(i7)));
                    }
                }
            } else {
                d[] dVarArr3 = new d[size];
                for (int i8 = 0; i8 < size; i8++) {
                    dVarArr3[i8] = l(dVarArr[i8], cVar.f4263a, true);
                }
                arrayList.add(new da9("main", dVarArr3));
            }
            da9 da9Var = new da9("main:id3", new d.b().S("ID3").e0("application/id3").E());
            arrayList.add(da9Var);
            hlsSampleStreamWrapperK.T((da9[]) arrayList.toArray(new da9[0]), 0, arrayList.indexOf(da9Var));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f4149a.isLoading();
    }

    public final void j(long j) {
        com.google.android.exoplayer2.source.hls.playlist.c cVar = (com.google.android.exoplayer2.source.hls.playlist.c) sb0.g(this.f4152a.d());
        Map<String, DrmInitData> mapM = this.b ? m(cVar.i) : Collections.emptyMap();
        boolean z = !cVar.f4266c.isEmpty();
        List<com.google.android.exoplayer2.source.hls.playlist.c.a> list = cVar.e;
        List<com.google.android.exoplayer2.source.hls.playlist.c.a> list2 = cVar.f;
        this.L = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            i(cVar, j, arrayList, arrayList2, mapM);
        }
        g(j, list, arrayList, arrayList2, mapM);
        this.M = arrayList.size();
        int i = 0;
        while (i < list2.size()) {
            com.google.android.exoplayer2.source.hls.playlist.c.a aVar = list2.get(i);
            String str = "subtitle:" + i + u15.f19942b + aVar.b;
            ArrayList arrayList3 = arrayList2;
            int i2 = i;
            HlsSampleStreamWrapper hlsSampleStreamWrapperK = k(str, 3, new Uri[]{aVar.f30935a}, new d[]{aVar.f4267a}, null, Collections.emptyList(), mapM, j);
            arrayList3.add(new int[]{i2});
            arrayList.add(hlsSampleStreamWrapperK);
            hlsSampleStreamWrapperK.T(new da9[]{new da9(str, aVar.f4267a)}, 0, new int[0]);
            i = i2 + 1;
            arrayList2 = arrayList3;
        }
        this.f4161a = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.f4162a = (int[][]) arrayList2.toArray(new int[0][]);
        this.L = this.f4161a.length;
        for (int i3 = 0; i3 < this.M; i3++) {
            this.f4161a[i3].c0(true);
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            hlsSampleStreamWrapper.n();
        }
        this.f4163b = this.f4161a;
    }

    public final HlsSampleStreamWrapper k(String str, int i, Uri[] uriArr, d[] dVarArr, @Nullable d dVar, @Nullable List<d> list, Map<String, DrmInitData> map, long j) {
        return new HlsSampleStreamWrapper(str, i, this, new a(this.f4151a, this.f4152a, uriArr, dVarArr, this.f4150a, this.f4155a, this.f4158a, list, this.f4156a), map, this.f4153a, j, dVar, this.f4145a, this.f30922a, this.f4154a, this.f4148a, this.K);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void d(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f4147a.d(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            hlsSampleStreamWrapper.R();
        }
        this.f4147a.d(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(Uri uri) {
        this.f4152a.refreshPlaylist(uri);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i = this.L - 1;
        this.L = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            i2 += hlsSampleStreamWrapper.e().K;
        }
        da9[] da9VarArr = new da9[i2];
        int i3 = 0;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : this.f4161a) {
            int i4 = hlsSampleStreamWrapper2.e().K;
            int i5 = 0;
            while (i5 < i4) {
                da9VarArr[i3] = hlsSampleStreamWrapper2.e().b(i5);
                i5++;
                i3++;
            }
        }
        this.f4157a = new ga9(da9VarArr);
        this.f4147a.h(this);
    }

    public void p() {
        this.f4152a.a(this);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f4161a) {
            hlsSampleStreamWrapper.V();
        }
        this.f4147a = null;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f4149a.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f4163b;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean zY = hlsSampleStreamWrapperArr[0].Y(j, false);
            int i = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.f4163b;
                if (i >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i].Y(j, zY);
                i++;
            }
            if (zY) {
                this.f4158a.b();
            }
        }
        return j;
    }
}
