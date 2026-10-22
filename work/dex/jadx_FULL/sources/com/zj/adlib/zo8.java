package com.zj.adlib;

import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zo8 extends SegmentDownloader<a> {
    public zo8(g gVar, CacheDataSource.b bVar) {
        this(gVar, bVar, new z07());
    }

    public zo8(g gVar, CacheDataSource.b bVar, Executor executor) {
        this(gVar.b().L(gj9.G(((g.h) sb0.g(gVar.f3327a)).f30751a)).a(), new SsManifestParser(), bVar, executor);
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.c> getSegments(DataSource dataSource, a aVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (a.b bVar : aVar.f4503a) {
            for (int i = 0; i < bVar.f4511a.length; i++) {
                for (int i2 = 0; i2 < bVar.f4517f; i2++) {
                    arrayList.add(new SegmentDownloader.c(bVar.e(i2), new DataSpec(bVar.a(i, i2))));
                }
            }
        }
        return arrayList;
    }

    public zo8(g gVar, ParsingLoadable.Parser<a> parser, CacheDataSource.b bVar, Executor executor) {
        super(gVar, parser, bVar, executor);
    }
}
