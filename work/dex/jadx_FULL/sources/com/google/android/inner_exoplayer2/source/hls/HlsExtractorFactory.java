package com.google.android.inner_exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.analytics.PlayerId;
import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.util.TimestampAdjuster;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface HlsExtractorFactory {
    public static final HlsExtractorFactory DEFAULT = new DefaultHlsExtractorFactory();

    HlsMediaChunkExtractor createExtractor(Uri uri, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId);
}
