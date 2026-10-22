package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.o;
import com.google.common.primitives.Ints;
import com.zj.adlib.at6;
import com.zj.adlib.da9;
import com.zj.adlib.gj9;
import com.zj.adlib.h89;
import com.zj.adlib.rh9;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30917a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f4101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsExtractorFactory f4103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsPlaylistTracker f4104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExoTrackSelection f4105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f4106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f4107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final da9 f4108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h89 f4109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IOException f4110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final List<com.google.android.exoplayer2.d> f4111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri[] f4114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d[] f4115a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final DataSource f4116b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4117b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4118c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FullSegmentEncryptionKeyCache f4102a = new FullSegmentEncryptionKeyCache(4);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f4113a = gj9.f16790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4100a = -9223372036854775807L;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.a$a, reason: collision with other inner class name */
    public static final class C0690a extends DataChunk {
        public byte[] b;

        public C0690a(DataSource dataSource, DataSpec dataSpec, com.google.android.exoplayer2.d dVar, int i, @Nullable Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, dVar, i, obj, bArr);
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] bArr, int i) {
            this.b = Arrays.copyOf(bArr, i);
        }

        @Nullable
        public byte[] g() {
            return this.b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f30918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Chunk f4119a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4120a;

        public b() {
            a();
        }

        public void a() {
            this.f4119a = null;
            this.f4120a = false;
            this.f30918a = null;
        }
    }

    @VisibleForTesting
    public static final class c extends BaseMediaChunkIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<HlsMediaPlaylist.e> f4121a;
        public final long d;

        public c(String str, long j, List<HlsMediaPlaylist.e> list) {
            super(0L, list.size() - 1);
            this.f30919a = str;
            this.d = j;
            this.f4121a = list;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec a() {
            checkInBounds();
            HlsMediaPlaylist.e eVar = this.f4121a.get((int) getCurrentIndex());
            return new DataSpec(rh9.f(this.f30919a, eVar.f), eVar.c, eVar.d);
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.e eVar = this.f4121a.get((int) getCurrentIndex());
            return this.d + eVar.b + eVar.f30926a;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.d + this.f4121a.get((int) getCurrentIndex()).b;
        }
    }

    public static final class d extends BaseTrackSelection {
        public int f;

        public d(da9 da9Var, int[] iArr) {
            super(da9Var, iArr);
            this.f = b(da9Var.c(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.f, jElapsedRealtime)) {
                for (int i = this.c - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, jElapsedRealtime)) {
                        this.f = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectedIndex() {
            return this.f;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectionReason() {
            return 0;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30920a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f4122a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HlsMediaPlaylist.e f4123a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f4124a;

        public e(HlsMediaPlaylist.e eVar, long j, int i) {
            this.f4123a = eVar;
            this.f4122a = j;
            this.f30920a = i;
            this.f4124a = (eVar instanceof HlsMediaPlaylist.b) && ((HlsMediaPlaylist.b) eVar).c;
        }
    }

    public a(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, com.google.android.exoplayer2.d[] dVarArr, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, h89 h89Var, @Nullable List<com.google.android.exoplayer2.d> list, at6 at6Var) {
        this.f4103a = hlsExtractorFactory;
        this.f4104a = hlsPlaylistTracker;
        this.f4114a = uriArr;
        this.f4115a = dVarArr;
        this.f4109a = h89Var;
        this.f4111a = list;
        this.f4107a = at6Var;
        DataSource dataSourceA = hlsDataSourceFactory.a(1);
        this.f4106a = dataSourceA;
        if (transferListener != null) {
            dataSourceA.b(transferListener);
        }
        this.f4116b = hlsDataSourceFactory.a(3);
        this.f4108a = new da9(dVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((dVarArr[i].L & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.f4105a = new d(this.f4108a, Ints.B(arrayList));
    }

    @Nullable
    public static Uri d(HlsMediaPlaylist hlsMediaPlaylist, @Nullable HlsMediaPlaylist.e eVar) {
        String str;
        if (eVar == null || (str = eVar.g) == null) {
            return null;
        }
        return rh9.f(((HlsPlaylist) hlsMediaPlaylist).f30928a, str);
    }

    @Nullable
    public static e g(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.f4171c);
        if (i2 == hlsMediaPlaylist.f4169b.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < hlsMediaPlaylist.f4172c.size()) {
                return new e(hlsMediaPlaylist.f4172c.get(i), j, i);
            }
            return null;
        }
        HlsMediaPlaylist.d dVar = hlsMediaPlaylist.f4169b.get(i2);
        if (i == -1) {
            return new e(dVar, j, -1);
        }
        if (i < dVar.f30925a.size()) {
            return new e(dVar.f30925a.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < hlsMediaPlaylist.f4169b.size()) {
            return new e(hlsMediaPlaylist.f4169b.get(i3), j + 1, -1);
        }
        if (hlsMediaPlaylist.f4172c.isEmpty()) {
            return null;
        }
        return new e(hlsMediaPlaylist.f4172c.get(0), j + 1, 0);
    }

    @VisibleForTesting
    public static List<HlsMediaPlaylist.e> i(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.f4171c);
        if (i2 < 0 || hlsMediaPlaylist.f4169b.size() < i2) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i2 < hlsMediaPlaylist.f4169b.size()) {
            if (i != -1) {
                HlsMediaPlaylist.d dVar = hlsMediaPlaylist.f4169b.get(i2);
                if (i == 0) {
                    arrayList.add(dVar);
                } else if (i < dVar.f30925a.size()) {
                    List<HlsMediaPlaylist.b> list = dVar.f30925a;
                    arrayList.addAll(list.subList(i, list.size()));
                }
                i2++;
            }
            List<HlsMediaPlaylist.d> list2 = hlsMediaPlaylist.f4169b;
            arrayList.addAll(list2.subList(i2, list2.size()));
            i = 0;
        }
        if (hlsMediaPlaylist.f4176e != -9223372036854775807L) {
            int i3 = i != -1 ? i : 0;
            if (i3 < hlsMediaPlaylist.f4172c.size()) {
                List<HlsMediaPlaylist.b> list3 = hlsMediaPlaylist.f4172c;
                arrayList.addAll(list3.subList(i3, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public MediaChunkIterator[] a(@Nullable com.google.android.exoplayer2.source.hls.b bVar, long j) {
        int i;
        int iD = bVar == null ? -1 : this.f4108a.d(((Chunk) bVar).f3837a);
        int length = this.f4105a.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            int indexInTrackGroup = this.f4105a.getIndexInTrackGroup(i2);
            Uri uri = this.f4114a[indexInTrackGroup];
            if (this.f4104a.isSnapshotValid(uri)) {
                HlsMediaPlaylist hlsMediaPlaylistC = this.f4104a.c(uri, z);
                sb0.g(hlsMediaPlaylistC);
                long initialStartTimeUs = hlsMediaPlaylistC.f4168b - this.f4104a.getInitialStartTimeUs();
                i = i2;
                Pair<Long, Integer> pairF = f(bVar, indexInTrackGroup != iD ? true : z, hlsMediaPlaylistC, initialStartTimeUs, j);
                mediaChunkIteratorArr[i] = new c(((HlsPlaylist) hlsMediaPlaylistC).f30928a, initialStartTimeUs, i(hlsMediaPlaylistC, ((Long) pairF.first).longValue(), ((Integer) pairF.second).intValue()));
            } else {
                mediaChunkIteratorArr[i2] = MediaChunkIterator.f30862a;
                i = i2;
            }
            i2 = i + 1;
            z = false;
        }
        return mediaChunkIteratorArr;
    }

    public long b(long j, w38 w38Var) {
        int selectedIndex = this.f4105a.getSelectedIndex();
        Uri[] uriArr = this.f4114a;
        HlsMediaPlaylist hlsMediaPlaylistC = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.f4104a.c(uriArr[this.f4105a.getSelectedIndexInTrackGroup()], true);
        if (hlsMediaPlaylistC == null || hlsMediaPlaylistC.f4169b.isEmpty() || !((HlsPlaylist) hlsMediaPlaylistC).f4188a) {
            return j;
        }
        long initialStartTimeUs = hlsMediaPlaylistC.f4168b - this.f4104a.getInitialStartTimeUs();
        long j2 = j - initialStartTimeUs;
        int iH = gj9.h(hlsMediaPlaylistC.f4169b, Long.valueOf(j2), true, true);
        long j3 = hlsMediaPlaylistC.f4169b.get(iH).b;
        return w38Var.a(j2, j3, iH != hlsMediaPlaylistC.f4169b.size() - 1 ? hlsMediaPlaylistC.f4169b.get(iH + 1).b : j3) + initialStartTimeUs;
    }

    public int c(com.google.android.exoplayer2.source.hls.b bVar) {
        if (bVar.e == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) sb0.g(this.f4104a.c(this.f4114a[this.f4108a.d(((Chunk) bVar).f3837a)], false));
        int i = (int) (((MediaChunk) bVar).d - hlsMediaPlaylist.f4171c);
        if (i < 0) {
            return 1;
        }
        List<HlsMediaPlaylist.b> list = i < hlsMediaPlaylist.f4169b.size() ? hlsMediaPlaylist.f4169b.get(i).f30925a : hlsMediaPlaylist.f4172c;
        if (bVar.e >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.b bVar2 = list.get(bVar.e);
        if (bVar2.c) {
            return 0;
        }
        return gj9.c(Uri.parse(rh9.e(((HlsPlaylist) hlsMediaPlaylist).f30928a, bVar2.f)), ((Chunk) bVar).f3838a.f5026a) ? 1 : 2;
    }

    public void e(long j, long j2, List<com.google.android.exoplayer2.source.hls.b> list, boolean z, b bVar) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long initialStartTimeUs;
        Uri uri;
        int i;
        com.google.android.exoplayer2.source.hls.b bVar2 = list.isEmpty() ? null : (com.google.android.exoplayer2.source.hls.b) o.w(list);
        int iD = bVar2 == null ? -1 : this.f4108a.d(((Chunk) bVar2).f3837a);
        long jMax = j2 - j;
        long jS = s(j);
        if (bVar2 != null && !this.f4117b) {
            long jB = bVar2.b();
            jMax = Math.max(0L, jMax - jB);
            if (jS != -9223372036854775807L) {
                jS = Math.max(0L, jS - jB);
            }
        }
        this.f4105a.c(j, jMax, jS, list, a(bVar2, j2));
        int selectedIndexInTrackGroup = this.f4105a.getSelectedIndexInTrackGroup();
        boolean z2 = iD != selectedIndexInTrackGroup;
        Uri uri2 = this.f4114a[selectedIndexInTrackGroup];
        if (!this.f4104a.isSnapshotValid(uri2)) {
            bVar.f30918a = uri2;
            this.f4118c &= uri2.equals(this.f4101a);
            this.f4101a = uri2;
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylistC = this.f4104a.c(uri2, true);
        sb0.g(hlsMediaPlaylistC);
        this.f4117b = ((HlsPlaylist) hlsMediaPlaylistC).f4188a;
        w(hlsMediaPlaylistC);
        long initialStartTimeUs2 = hlsMediaPlaylistC.f4168b - this.f4104a.getInitialStartTimeUs();
        Pair<Long, Integer> pairF = f(bVar2, z2, hlsMediaPlaylistC, initialStartTimeUs2, j2);
        long jLongValue = ((Long) pairF.first).longValue();
        int iIntValue = ((Integer) pairF.second).intValue();
        if (jLongValue >= hlsMediaPlaylistC.f4171c || bVar2 == null || !z2) {
            hlsMediaPlaylist = hlsMediaPlaylistC;
            initialStartTimeUs = initialStartTimeUs2;
            uri = uri2;
            i = selectedIndexInTrackGroup;
        } else {
            Uri uri3 = this.f4114a[iD];
            HlsMediaPlaylist hlsMediaPlaylistC2 = this.f4104a.c(uri3, true);
            sb0.g(hlsMediaPlaylistC2);
            initialStartTimeUs = hlsMediaPlaylistC2.f4168b - this.f4104a.getInitialStartTimeUs();
            Pair<Long, Integer> pairF2 = f(bVar2, false, hlsMediaPlaylistC2, initialStartTimeUs, j2);
            jLongValue = ((Long) pairF2.first).longValue();
            iIntValue = ((Integer) pairF2.second).intValue();
            i = iD;
            uri = uri3;
            hlsMediaPlaylist = hlsMediaPlaylistC2;
        }
        if (jLongValue < hlsMediaPlaylist.f4171c) {
            this.f4110a = new BehindLiveWindowException();
            return;
        }
        e eVarG = g(hlsMediaPlaylist, jLongValue, iIntValue);
        if (eVarG == null) {
            if (!hlsMediaPlaylist.f4177e) {
                bVar.f30918a = uri;
                this.f4118c &= uri.equals(this.f4101a);
                this.f4101a = uri;
                return;
            } else {
                if (z || hlsMediaPlaylist.f4169b.isEmpty()) {
                    bVar.f4120a = true;
                    return;
                }
                eVarG = new e((HlsMediaPlaylist.e) o.w(hlsMediaPlaylist.f4169b), (hlsMediaPlaylist.f4171c + ((long) hlsMediaPlaylist.f4169b.size())) - 1, -1);
            }
        }
        this.f4118c = false;
        this.f4101a = null;
        Uri uriD = d(hlsMediaPlaylist, eVarG.f4123a.f4183a);
        Chunk chunkL = l(uriD, i);
        bVar.f4119a = chunkL;
        if (chunkL != null) {
            return;
        }
        Uri uriD2 = d(hlsMediaPlaylist, eVarG.f4123a);
        Chunk chunkL2 = l(uriD2, i);
        bVar.f4119a = chunkL2;
        if (chunkL2 != null) {
            return;
        }
        boolean zU = com.google.android.exoplayer2.source.hls.b.u(bVar2, uri, hlsMediaPlaylist, eVarG, initialStartTimeUs);
        if (zU && eVarG.f4124a) {
            return;
        }
        bVar.f4119a = com.google.android.exoplayer2.source.hls.b.h(this.f4103a, this.f4106a, this.f4115a[i], initialStartTimeUs, hlsMediaPlaylist, eVarG, uri, this.f4111a, this.f4105a.getSelectionReason(), this.f4105a.getSelectionData(), this.f4112a, this.f4109a, bVar2, this.f4102a.b(uriD2), this.f4102a.b(uriD), zU, this.f4107a);
    }

    public final Pair<Long, Integer> f(@Nullable com.google.android.exoplayer2.source.hls.b bVar, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        int i = -1;
        if (bVar != null && !z) {
            if (!bVar.f()) {
                return new Pair<>(Long.valueOf(((MediaChunk) bVar).d), Integer.valueOf(bVar.e));
            }
            Long lValueOf = Long.valueOf(bVar.e == -1 ? bVar.e() : ((MediaChunk) bVar).d);
            int i2 = bVar.e;
            return new Pair<>(lValueOf, Integer.valueOf(i2 != -1 ? i2 + 1 : -1));
        }
        long j3 = hlsMediaPlaylist.f4178f + j;
        if (bVar != null && !this.f4117b) {
            j2 = ((Chunk) bVar).f3841b;
        }
        if (!hlsMediaPlaylist.f4177e && j2 >= j3) {
            return new Pair<>(Long.valueOf(hlsMediaPlaylist.f4171c + ((long) hlsMediaPlaylist.f4169b.size())), -1);
        }
        long j4 = j2 - j;
        int iH = gj9.h(hlsMediaPlaylist.f4169b, Long.valueOf(j4), true, !this.f4104a.isLive() || bVar == null);
        long j5 = ((long) iH) + hlsMediaPlaylist.f4171c;
        if (iH >= 0) {
            HlsMediaPlaylist.d dVar = hlsMediaPlaylist.f4169b.get(iH);
            List<HlsMediaPlaylist.b> list = j4 < dVar.b + ((HlsMediaPlaylist.e) dVar).f30926a ? dVar.f30925a : hlsMediaPlaylist.f4172c;
            for (int i3 = 0; i3 < list.size(); i3++) {
                HlsMediaPlaylist.b bVar2 = list.get(i3);
                if (j4 < ((HlsMediaPlaylist.e) bVar2).b + ((HlsMediaPlaylist.e) bVar2).f30926a) {
                    if (!bVar2.b) {
                        break;
                    }
                    j5 += list == hlsMediaPlaylist.f4172c ? 1L : 0L;
                    i = i3;
                    break;
                }
            }
        }
        return new Pair<>(Long.valueOf(j5), Integer.valueOf(i));
    }

    public int h(long j, List<? extends MediaChunk> list) {
        return (this.f4110a != null || this.f4105a.length() < 2) ? list.size() : this.f4105a.evaluateQueueSize(j, list);
    }

    public da9 j() {
        return this.f4108a;
    }

    public ExoTrackSelection k() {
        return this.f4105a;
    }

    @Nullable
    public final Chunk l(@Nullable Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] bArrD = this.f4102a.d(uri);
        if (bArrD != null) {
            this.f4102a.c(uri, bArrD);
            return null;
        }
        return new C0690a(this.f4116b, new DataSpec.b().j(uri).c(1).a(), this.f4115a[i], this.f4105a.getSelectionReason(), this.f4105a.getSelectionData(), this.f4113a);
    }

    public boolean m(Chunk chunk, long j) {
        ExoTrackSelection exoTrackSelection = this.f4105a;
        return exoTrackSelection.blacklist(exoTrackSelection.indexOf(this.f4108a.d(chunk.f3837a)), j);
    }

    public void n() throws IOException {
        IOException iOException = this.f4110a;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f4101a;
        if (uri == null || !this.f4118c) {
            return;
        }
        this.f4104a.maybeThrowPlaylistRefreshError(uri);
    }

    public boolean o(Uri uri) {
        return gj9.u(this.f4114a, uri);
    }

    public void p(Chunk chunk) {
        if (chunk instanceof C0690a) {
            C0690a c0690a = (C0690a) chunk;
            this.f4113a = c0690a.e();
            this.f4102a.c(((Chunk) c0690a).f3838a.f5026a, (byte[]) sb0.g(c0690a.g()));
        }
    }

    public boolean q(Uri uri, long j) {
        int iIndexOf;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.f4114a;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (iIndexOf = this.f4105a.indexOf(i)) == -1) {
            return true;
        }
        this.f4118c |= uri.equals(this.f4101a);
        return j == -9223372036854775807L || (this.f4105a.blacklist(iIndexOf, j) && this.f4104a.excludeMediaPlaylist(uri, j));
    }

    public void r() {
        this.f4110a = null;
    }

    public final long s(long j) {
        long j2 = this.f4100a;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    public void t(boolean z) {
        this.f4112a = z;
    }

    public void u(ExoTrackSelection exoTrackSelection) {
        this.f4105a = exoTrackSelection;
    }

    public boolean v(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f4110a != null) {
            return false;
        }
        return this.f4105a.f(j, chunk, list);
    }

    public final void w(HlsMediaPlaylist hlsMediaPlaylist) {
        this.f4100a = hlsMediaPlaylist.f4177e ? -9223372036854775807L : hlsMediaPlaylist.d() - this.f4104a.getInitialStartTimeUs();
    }
}
