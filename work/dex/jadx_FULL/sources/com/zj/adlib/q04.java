package com.zj.adlib;

import android.net.Uri;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q04 extends SegmentDownloader<HlsPlaylist> {
    public q04(g gVar, CacheDataSource.b bVar) {
        this(gVar, bVar, new z07());
    }

    public final void h(List<Uri> list, List<DataSpec> list2) {
        for (int i = 0; i < list.size(); i++) {
            list2.add(SegmentDownloader.getCompressibleDataSpec(list.get(i)));
        }
    }

    public final void i(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.d dVar, HashSet<Uri> hashSet, ArrayList<SegmentDownloader.c> arrayList) {
        String str = ((HlsPlaylist) hlsMediaPlaylist).f30928a;
        long j = hlsMediaPlaylist.f4168b + dVar.b;
        String str2 = dVar.g;
        if (str2 != null) {
            Uri uriF = rh9.f(str, str2);
            if (hashSet.add(uriF)) {
                arrayList.add(new SegmentDownloader.c(j, SegmentDownloader.getCompressibleDataSpec(uriF)));
            }
        }
        arrayList.add(new SegmentDownloader.c(j, new DataSpec(rh9.f(str, dVar.f), dVar.c, dVar.d)));
    }

    public q04(g gVar, CacheDataSource.b bVar, Executor executor) {
        this(gVar, new HlsPlaylistParser(), bVar, executor);
    }

    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.c> getSegments(DataSource dataSource, HlsPlaylist hlsPlaylist, boolean z) throws InterruptedException, IOException {
        ArrayList<DataSpec> arrayList = new ArrayList();
        if (hlsPlaylist instanceof c) {
            h(((c) hlsPlaylist).f4265b, arrayList);
        } else {
            arrayList.add(SegmentDownloader.getCompressibleDataSpec(Uri.parse(hlsPlaylist.f30928a)));
        }
        ArrayList<SegmentDownloader.c> arrayList2 = new ArrayList<>();
        HashSet<Uri> hashSet = new HashSet<>();
        for (DataSpec dataSpec : arrayList) {
            arrayList2.add(new SegmentDownloader.c(0L, dataSpec));
            try {
                HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) getManifest(dataSource, dataSpec, z);
                List<HlsMediaPlaylist.d> list = hlsMediaPlaylist.f4169b;
                HlsMediaPlaylist.d dVar = null;
                for (int i = 0; i < list.size(); i++) {
                    HlsMediaPlaylist.d dVar2 = list.get(i);
                    HlsMediaPlaylist.d dVar3 = ((HlsMediaPlaylist.e) dVar2).f4183a;
                    if (dVar3 != null && dVar3 != dVar) {
                        i(hlsMediaPlaylist, dVar3, hashSet, arrayList2);
                        dVar = dVar3;
                    }
                    i(hlsMediaPlaylist, dVar2, hashSet, arrayList2);
                }
            } catch (IOException e) {
                if (!z) {
                    throw e;
                }
            }
        }
        return arrayList2;
    }

    public q04(g gVar, ParsingLoadable.Parser<HlsPlaylist> parser, CacheDataSource.b bVar, Executor executor) {
        super(gVar, parser, bVar, executor);
    }
}
