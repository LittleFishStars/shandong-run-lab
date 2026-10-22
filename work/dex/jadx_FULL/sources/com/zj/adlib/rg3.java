package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rg3<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParsingLoadable.Parser<? extends T> f44445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final List<StreamKey> f19285a;

    public rg3(ParsingLoadable.Parser<? extends T> parser, @Nullable List<StreamKey> list) {
        this.f44445a = parser;
        this.f19285a = list;
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T parse(Uri uri, InputStream inputStream) throws IOException {
        T t = this.f44445a.parse(uri, inputStream);
        List<StreamKey> list = this.f19285a;
        return (list == null || list.isEmpty()) ? t : (T) t.copy(this.f19285a);
    }
}
