package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.y.l;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.primitives.Ints;
import com.zj.adlib.at6;
import com.zj.adlib.c62;
import com.zj.adlib.da9;
import com.zj.adlib.eo6;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.j13;
import com.zj.adlib.p53;
import com.zj.adlib.rk2;
import com.zj.adlib.s53;
import com.zj.adlib.u15;
import com.zj.adlib.vz;
import com.zj.adlib.w38;
import com.zj.adlib.xr0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f30873a = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern b = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public final int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f3895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f3896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f3897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f3898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f3899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SequenceableLoader f3900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashChunkSource.Factory f3901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PlayerEmsgHandler f3902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f3903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f3904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoaderErrorThrower f3905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TransferListener f3906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f3907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c62 f3908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ga9 f3909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xr0 f3910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<s53> f3912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackGroupInfo[] f3914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ChunkSampleStream<DashChunkSource>[] f3913a = u(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p53[] f3915a = new p53[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.b> f3911a = new IdentityHashMap<>();

    public static final class TrackGroupInfo {
        public static final int g = 0;
        public static final int h = 1;
        public static final int i = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30874a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3916a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        public TrackGroupInfo(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
            this.f30874a = i2;
            this.f3916a = iArr;
            this.b = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.c = i7;
        }

        public static TrackGroupInfo a(int[] iArr, int i2) {
            return new TrackGroupInfo(3, 1, iArr, i2, -1, -1, -1);
        }

        public static TrackGroupInfo b(int[] iArr, int i2) {
            return new TrackGroupInfo(5, 1, iArr, i2, -1, -1, -1);
        }

        public static TrackGroupInfo c(int i2) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i2);
        }

        public static TrackGroupInfo d(int i2, int[] iArr, int i3, int i4, int i5) {
            return new TrackGroupInfo(i2, 0, iArr, i3, i4, i5, -1);
        }
    }

    public DashMediaPeriod(int i, c62 c62Var, xr0 xr0Var, int i2, DashChunkSource.Factory factory, @Nullable TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, at6 at6Var) {
        this.K = i;
        this.f3908a = c62Var;
        this.f3910a = xr0Var;
        this.L = i2;
        this.f3901a = factory;
        this.f3906a = transferListener;
        this.f3896a = drmSessionManager;
        this.f3895a = aVar;
        this.f3904a = loadErrorHandlingPolicy;
        this.f3899a = aVar2;
        this.f3894a = j;
        this.f3905a = loaderErrorThrower;
        this.f3903a = allocator;
        this.f3897a = compositeSequenceableLoaderFactory;
        this.f3907a = at6Var;
        this.f3902a = new PlayerEmsgHandler(c62Var, playerEmsgCallback, allocator);
        this.f3900a = compositeSequenceableLoaderFactory.a(this.f3913a);
        eo6 eo6VarC = c62Var.c(i2);
        List<s53> list = eo6VarC.b;
        this.f3912a = list;
        Pair<ga9, TrackGroupInfo[]> pairK = k(drmSessionManager, eo6VarC.f16370a, list);
        this.f3909a = (ga9) pairK.first;
        this.f3914a = (TrackGroupInfo[]) pairK.second;
    }

    public static void g(List<s53> list, da9[] da9VarArr, TrackGroupInfo[] trackGroupInfoArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            s53 s53Var = list.get(i2);
            da9VarArr[i] = new da9(s53Var.a() + u15.f19942b + i2, new d.b().S(s53Var.a()).e0("application/x-emsg").E());
            trackGroupInfoArr[i] = TrackGroupInfo.c(i2);
            i2++;
            i++;
        }
    }

    public static int i(DrmSessionManager drmSessionManager, List<vz> list, int[][] iArr, int i, boolean[] zArr, d[][] dVarArr, da9[] da9VarArr, TrackGroupInfo[] trackGroupInfoArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int[] iArr2 = iArr[i4];
            ArrayList arrayList = new ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(list.get(i6).f20347a);
            }
            int size = arrayList.size();
            d[] dVarArr2 = new d[size];
            for (int i7 = 0; i7 < size; i7++) {
                d dVar = ((Representation) arrayList.get(i7)).f3983a;
                dVarArr2[i7] = dVar.d(drmSessionManager.a(dVar));
            }
            vz vzVar = list.get(iArr2[0]);
            int i8 = vzVar.f45491a;
            String string = i8 != -1 ? Integer.toString(i8) : "unset:" + i4;
            int i9 = i5 + 1;
            if (zArr[i4]) {
                i2 = i9 + 1;
            } else {
                i2 = i9;
                i9 = -1;
            }
            if (dVarArr[i4].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            da9VarArr[i5] = new da9(string, dVarArr2);
            trackGroupInfoArr[i5] = TrackGroupInfo.d(vzVar.b, iArr2, i5, i9, i2);
            if (i9 != -1) {
                String str = string + ":emsg";
                da9VarArr[i9] = new da9(str, new d.b().S(str).e0("application/x-emsg").E());
                trackGroupInfoArr[i9] = TrackGroupInfo.b(iArr2, i5);
            }
            if (i2 != -1) {
                da9VarArr[i2] = new da9(string + ":cc", dVarArr[i4]);
                trackGroupInfoArr[i2] = TrackGroupInfo.a(iArr2, i5);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    public static Pair<ga9, TrackGroupInfo[]> k(DrmSessionManager drmSessionManager, List<vz> list, List<s53> list2) {
        int[][] iArrP = p(list);
        int length = iArrP.length;
        boolean[] zArr = new boolean[length];
        d[][] dVarArr = new d[length][];
        int iT = t(length, list, iArrP, zArr, dVarArr) + length + list2.size();
        da9[] da9VarArr = new da9[iT];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[iT];
        g(list2, da9VarArr, trackGroupInfoArr, i(drmSessionManager, list, iArrP, length, zArr, dVarArr, da9VarArr, trackGroupInfoArr));
        return Pair.create(new ga9(da9VarArr), trackGroupInfoArr);
    }

    @Nullable
    public static rk2 l(List<rk2> list) {
        return m(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    public static rk2 m(List<rk2> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if (str.equals(rk2Var.f44473a)) {
                return rk2Var;
            }
        }
        return null;
    }

    @Nullable
    public static rk2 n(List<rk2> list) {
        return m(list, "http://dashif.org/guidelines/trickmode");
    }

    public static d[] o(List<vz> list, int[] iArr) {
        for (int i : iArr) {
            vz vzVar = list.get(i);
            List<rk2> list2 = list.get(i).f20348b;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                rk2 rk2Var = list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(rk2Var.f44473a)) {
                    return w(rk2Var, f30873a, new d.b().e0("application/cea-608").S(vzVar.f45491a + ":cea608").E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(rk2Var.f44473a)) {
                    return w(rk2Var, b, new d.b().e0("application/cea-708").S(vzVar.f45491a + ":cea708").E());
                }
            }
        }
        return new d[0];
    }

    public static int[][] p(List<vz> list) {
        int iMin;
        rk2 rk2VarL;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(list.get(i).f45491a, i);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i));
            arrayList.add(arrayList2);
            sparseArray.put(i, arrayList2);
        }
        for (int i2 = 0; i2 < size; i2++) {
            vz vzVar = list.get(i2);
            rk2 rk2VarN = n(vzVar.f20349c);
            if (rk2VarN == null) {
                rk2VarN = n(vzVar.d);
            }
            if (rk2VarN == null || (iMin = sparseIntArray.get(Integer.parseInt(rk2VarN.b), -1)) == -1) {
                iMin = i2;
            }
            if (iMin == i2 && (rk2VarL = l(vzVar.d)) != null) {
                for (String str : gj9.u1(rk2VarL.b, ",")) {
                    int i3 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i3 != -1) {
                        iMin = Math.min(iMin, i3);
                    }
                }
            }
            if (iMin != i2) {
                List list2 = (List) sparseArray.get(i2);
                List list3 = (List) sparseArray.get(iMin);
                list3.addAll(list2);
                sparseArray.put(i2, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i4 = 0; i4 < size2; i4++) {
            int[] iArrB = Ints.B((Collection) arrayList.get(i4));
            iArr[i4] = iArrB;
            Arrays.sort(iArrB);
        }
        return iArr;
    }

    public static boolean s(List<vz> list, int[] iArr) {
        for (int i : iArr) {
            List<Representation> list2 = list.get(i).f20347a;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).f3986a.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int t(int i, List<vz> list, int[][] iArr, boolean[] zArr, d[][] dVarArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (s(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            d[] dVarArrO = o(list, iArr[i3]);
            dVarArr[i3] = dVarArrO;
            if (dVarArrO.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static ChunkSampleStream<DashChunkSource>[] u(int i) {
        return new ChunkSampleStream[i];
    }

    public static d[] w(rk2 rk2Var, Pattern pattern, d dVar) {
        String str = rk2Var.b;
        if (str == null) {
            return new d[]{dVar};
        }
        String[] strArrU1 = gj9.u1(str, l.b);
        d[] dVarArr = new d[strArrU1.length];
        for (int i = 0; i < strArrU1.length; i++) {
            Matcher matcher = pattern.matcher(strArrU1[i]);
            if (!matcher.matches()) {
                return new d[]{dVar};
            }
            int i2 = Integer.parseInt(matcher.group(1));
            dVarArr[i] = dVar.b().S(dVar.f + u15.f19942b + i2).F(i2).V(matcher.group(2)).E();
        }
        return dVarArr;
    }

    public final void A(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream == null) {
                    zArr[i] = true;
                    TrackGroupInfo trackGroupInfo = this.f3914a[iArr[i]];
                    int i2 = trackGroupInfo.b;
                    if (i2 == 0) {
                        sampleStreamArr[i] = j(trackGroupInfo, exoTrackSelection, j);
                    } else if (i2 == 2) {
                        sampleStreamArr[i] = new p53(this.f3912a.get(trackGroupInfo.c), exoTrackSelection.d().c(0), this.f3908a.f15743a);
                    }
                } else if (sampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) ((ChunkSampleStream) sampleStream).o()).b(exoTrackSelection);
                }
            }
        }
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] == null && exoTrackSelectionArr[i3] != null) {
                TrackGroupInfo trackGroupInfo2 = this.f3914a[iArr[i3]];
                if (trackGroupInfo2.b == 1) {
                    int iQ = q(i3, iArr);
                    if (iQ == -1) {
                        sampleStreamArr[i3] = new j13();
                    } else {
                        sampleStreamArr[i3] = ((ChunkSampleStream) sampleStreamArr[iQ]).E(j, trackGroupInfo2.f30874a);
                    }
                }
            }
        }
    }

    public void B(c62 c62Var, int i) {
        this.f3908a = c62Var;
        this.L = i;
        this.f3902a.q(c62Var);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.f3913a;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> chunkSampleStream : chunkSampleStreamArr) {
                ((DashChunkSource) chunkSampleStream.o()).c(c62Var, i);
            }
            this.f3898a.d(this);
        }
        this.f3912a = c62Var.c(i).b;
        for (p53 p53Var : this.f3915a) {
            for (s53 s53Var : this.f3912a) {
                if (s53Var.a().equals(p53Var.a())) {
                    p53Var.d(s53Var, c62Var.f15743a && i == c62Var.d() - 1);
                    break;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f3913a) {
            if (chunkSampleStream.K == 2) {
                return chunkSampleStream.a(j, w38Var);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback
    public synchronized void b(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.b bVarRemove = this.f3911a.remove(chunkSampleStream);
        if (bVarRemove != null) {
            bVarRemove.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f3898a = callback;
        callback.h(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.f3900a.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f3913a) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return this.f3909a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] iArrR = r(exoTrackSelectionArr);
        y(exoTrackSelectionArr, zArr, sampleStreamArr);
        z(exoTrackSelectionArr, sampleStreamArr, iArrR);
        A(exoTrackSelectionArr, sampleStreamArr, zArr2, j, iArrR);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof ChunkSampleStream) {
                arrayList.add((ChunkSampleStream) sampleStream);
            } else if (sampleStream instanceof p53) {
                arrayList2.add((p53) sampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArrU = u(arrayList.size());
        this.f3913a = chunkSampleStreamArrU;
        arrayList.toArray(chunkSampleStreamArrU);
        p53[] p53VarArr = new p53[arrayList2.size()];
        this.f3915a = p53VarArr;
        arrayList2.toArray(p53VarArr);
        this.f3900a = this.f3897a.a(this.f3913a);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f3900a.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f3900a.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        List<vz> list2 = this.f3908a.c(this.L).f16370a;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection exoTrackSelection : list) {
            TrackGroupInfo trackGroupInfo = this.f3914a[this.f3909a.c(exoTrackSelection.d())];
            if (trackGroupInfo.b == 0) {
                int[] iArr = trackGroupInfo.f3916a;
                int length = exoTrackSelection.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < exoTrackSelection.length(); i++) {
                    iArr2[i] = exoTrackSelection.getIndexInTrackGroup(i);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).f20347a.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i4];
                    while (true) {
                        int i6 = i3 + size;
                        if (i5 >= i6) {
                            i2++;
                            size = list2.get(iArr[i2]).f20347a.size();
                            i3 = i6;
                        }
                    }
                    arrayList.add(new StreamKey(this.L, iArr[i2], i5 - i3));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f3900a.isLoading();
    }

    public final ChunkSampleStream<DashChunkSource> j(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j) {
        int i;
        da9 da9VarB;
        da9 da9VarB2;
        int i2;
        int i3 = trackGroupInfo.e;
        boolean z = i3 != -1;
        PlayerEmsgHandler.b bVarK = null;
        if (z) {
            da9VarB = this.f3909a.b(i3);
            i = 1;
        } else {
            i = 0;
            da9VarB = null;
        }
        int i4 = trackGroupInfo.f;
        boolean z2 = i4 != -1;
        if (z2) {
            da9VarB2 = this.f3909a.b(i4);
            i += da9VarB2.K;
        } else {
            da9VarB2 = null;
        }
        d[] dVarArr = new d[i];
        int[] iArr = new int[i];
        if (z) {
            dVarArr[0] = da9VarB.c(0);
            iArr[0] = 5;
            i2 = 1;
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            for (int i5 = 0; i5 < da9VarB2.K; i5++) {
                d dVarC = da9VarB2.c(i5);
                dVarArr[i2] = dVarC;
                iArr[i2] = 3;
                arrayList.add(dVarC);
                i2++;
            }
        }
        if (this.f3908a.f15743a && z) {
            bVarK = this.f3902a.k();
        }
        PlayerEmsgHandler.b bVar = bVarK;
        ChunkSampleStream<DashChunkSource> chunkSampleStream = new ChunkSampleStream<>(trackGroupInfo.f30874a, iArr, dVarArr, this.f3901a.a(this.f3905a, this.f3908a, this.f3910a, this.L, trackGroupInfo.f3916a, exoTrackSelection, trackGroupInfo.f30874a, this.f3894a, z, arrayList, bVar, this.f3906a, this.f3907a), this, this.f3903a, j, this.f3896a, this.f3895a, this.f3904a, this.f3899a);
        synchronized (this) {
            this.f3911a.put(chunkSampleStream, bVar);
        }
        return chunkSampleStream;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.f3905a.maybeThrowError();
    }

    public final int q(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.f3914a[i2].d;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.f3914a[i5].b == 0) {
                return i4;
            }
        }
        return -1;
    }

    public final int[] r(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i];
            if (exoTrackSelection != null) {
                iArr[i] = this.f3909a.c(exoTrackSelection.d());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f3900a.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f3913a) {
            chunkSampleStream.D(j);
        }
        for (p53 p53Var : this.f3915a) {
            p53Var.c(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void d(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.f3898a.d(this);
    }

    public void x() {
        this.f3902a.o();
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f3913a) {
            chunkSampleStream.B(this);
        }
        this.f3898a = null;
    }

    public final void y(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            if (exoTrackSelectionArr[i] == null || !zArr[i]) {
                SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream instanceof ChunkSampleStream) {
                    ((ChunkSampleStream) sampleStream).B(this);
                } else if (sampleStream instanceof ChunkSampleStream.a) {
                    ((ChunkSampleStream.a) sampleStream).c();
                }
                sampleStreamArr[i] = null;
            }
        }
    }

    public final void z(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z;
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if ((sampleStream instanceof j13) || (sampleStream instanceof ChunkSampleStream.a)) {
                int iQ = q(i, iArr);
                if (iQ == -1) {
                    z = sampleStreamArr[i] instanceof j13;
                } else {
                    SampleStream sampleStream2 = sampleStreamArr[i];
                    z = (sampleStream2 instanceof ChunkSampleStream.a) && ((ChunkSampleStream.a) sampleStream2).f3861a == sampleStreamArr[iQ];
                }
                if (!z) {
                    SampleStream sampleStream3 = sampleStreamArr[i];
                    if (sampleStream3 instanceof ChunkSampleStream.a) {
                        ((ChunkSampleStream.a) sampleStream3).c();
                    }
                    sampleStreamArr[i] = null;
                }
            }
        }
    }
}
