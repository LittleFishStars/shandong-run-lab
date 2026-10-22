package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.zj.adlib.at6;
import com.zj.adlib.g89;
import com.zj.adlib.jg2;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface HlsExtractorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HlsExtractorFactory f30911a = new jg2();

    HlsMediaChunkExtractor a(Uri uri, d dVar, @Nullable List<d> list, g89 g89Var, Map<String, List<String>> map, ExtractorInput extractorInput, at6 at6Var) throws IOException;
}
