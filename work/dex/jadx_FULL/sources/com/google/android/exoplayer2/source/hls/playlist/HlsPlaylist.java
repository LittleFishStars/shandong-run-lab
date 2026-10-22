package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<String> f4187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4188a;

    public HlsPlaylist(String str, List<String> list, boolean z) {
        this.f30928a = str;
        this.f4187a = Collections.unmodifiableList(list);
        this.f4188a = z;
    }
}
