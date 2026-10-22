package com.zj.adlib;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ig2 implements HlsDataSourceFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSource.Factory f42352a;

    public ig2(DataSource.Factory factory) {
        this.f42352a = factory;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public DataSource a(int i) {
        return this.f42352a.a();
    }
}
