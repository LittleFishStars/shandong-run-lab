package com.google.android.inner_exoplayer2.source.hls.playlist;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.drm.DrmInitData;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Deprecated
public final class HlsMasterPlaylist extends HlsMultivariantPlaylist {
    @Deprecated
    public HlsMasterPlaylist(String str, List<String> list, List<HlsMultivariantPlaylist.Variant> list2, List<HlsMultivariantPlaylist.Rendition> list3, List<HlsMultivariantPlaylist.Rendition> list4, List<HlsMultivariantPlaylist.Rendition> list5, List<HlsMultivariantPlaylist.Rendition> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, list2, list3, list4, list5, list6, format, list7, z, map, list8);
    }
}
