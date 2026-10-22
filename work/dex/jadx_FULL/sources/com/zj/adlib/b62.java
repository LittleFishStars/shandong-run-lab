package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.b;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b62 extends SegmentDownloader<c62> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xr0 f40683a;

    public class a extends RunnableFutureTask<b, IOException> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Representation f40684a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DataSource f15450a;

        public a(b62 b62Var, DataSource dataSource, int i, Representation representation) {
            this.f15450a = dataSource;
            this.K = i;
            this.f40684a = representation;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public b doWork() throws IOException {
            return f62.d(this.f15450a, this.K, this.f40684a);
        }
    }

    public b62(g gVar, CacheDataSource.b bVar) {
        this(gVar, bVar, new z07());
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00b7 A[SYNTHETIC] */
    public final void h(DataSource dataSource, vz vzVar, long j, long j2, boolean z, ArrayList<SegmentDownloader.c> arrayList) throws InterruptedException, IOException {
        for (int i = 0; i < vzVar.f20347a.size(); i++) {
            Representation representation = vzVar.f20347a.get(i);
            try {
                try {
                    DashSegmentIndex dashSegmentIndexJ = j(dataSource, vzVar.b, representation, z);
                    if (dashSegmentIndexJ != null) {
                        long jG = dashSegmentIndexJ.g(j2);
                        if (jG == -1) {
                            throw new DownloadException("Unbounded segment index");
                        }
                        String str = ((vr0) gj9.k(this.f40683a.j(representation.f3984a))).f20281a;
                        ka7 ka7VarM = representation.m();
                        if (ka7VarM != null) {
                            arrayList.add(i(representation, str, j, ka7VarM));
                        }
                        ka7 ka7VarL = representation.l();
                        if (ka7VarL != null) {
                            arrayList.add(i(representation, str, j, ka7VarL));
                        }
                        long jF = dashSegmentIndexJ.f();
                        long j3 = (jF + jG) - 1;
                        for (long j4 = jF; j4 <= j3; j4++) {
                            arrayList.add(i(representation, str, j + dashSegmentIndexJ.getTimeUs(j4), dashSegmentIndexJ.d(j4)));
                        }
                    } else {
                        try {
                            throw new DownloadException("Missing segment index");
                        } catch (IOException e) {
                            e = e;
                            if (z) {
                                throw e;
                            }
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (z) {
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
    }

    public final SegmentDownloader.c i(Representation representation, String str, long j, ka7 ka7Var) {
        return new SegmentDownloader.c(j, f62.b(representation, str, ka7Var, 0));
    }

    @Nullable
    public final DashSegmentIndex j(DataSource dataSource, int i, Representation representation, boolean z) throws InterruptedException, IOException {
        DashSegmentIndex dashSegmentIndexK = representation.k();
        if (dashSegmentIndexK != null) {
            return dashSegmentIndexK;
        }
        b bVar = (b) execute(new a(this, dataSource, i, representation), z);
        if (bVar == null) {
            return null;
        }
        return new g62(bVar, representation.b);
    }

    public b62(g gVar, CacheDataSource.b bVar, Executor executor) {
        this(gVar, new com.google.android.exoplayer2.source.dash.manifest.a(), bVar, executor);
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.c> getSegments(DataSource dataSource, c62 c62Var, boolean z) throws InterruptedException, IOException {
        ArrayList<SegmentDownloader.c> arrayList = new ArrayList<>();
        for (int i = 0; i < c62Var.d(); i++) {
            eo6 eo6VarC = c62Var.c(i);
            long jZ0 = gj9.Z0(eo6VarC.f41481a);
            long jF = c62Var.f(i);
            int i2 = 0;
            for (List<vz> list = eo6VarC.f16370a; i2 < list.size(); list = list) {
                h(dataSource, list.get(i2), jZ0, jF, z, arrayList);
                i2++;
            }
        }
        return arrayList;
    }

    public b62(g gVar, ParsingLoadable.Parser<c62> parser, CacheDataSource.b bVar, Executor executor) {
        super(gVar, parser, bVar, executor);
        this.f40683a = new xr0();
    }
}
