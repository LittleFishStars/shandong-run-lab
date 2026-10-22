package com.google.android.inner_exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.offline.FilterableManifest;
import com.google.android.inner_exoplayer2.upstream.ParsingLoadable;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {
    private final ParsingLoadable.Parser<? extends T> parser;

    @Nullable
    private final List<StreamKey> streamKeys;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser, @Nullable List<StreamKey> list) {
        this.parser = parser;
        this.streamKeys = list;
    }

    @Override // com.google.android.inner_exoplayer2.upstream.ParsingLoadable.Parser
    public T parse(Uri uri, InputStream inputStream) {
        T t = this.parser.parse(uri, inputStream);
        List<StreamKey> list = this.streamKeys;
        return (list == null || list.isEmpty()) ? t : (T) t.copy(this.streamKeys);
    }
}
