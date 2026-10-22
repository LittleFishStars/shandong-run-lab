package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheKeyFactory f31135a = new CacheKeyFactory() { // from class: com.zj.adlib.x91
        @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
        public final String b(DataSpec dataSpec) {
            return CacheKeyFactory.c(dataSpec);
        }
    };

    static /* synthetic */ String c(DataSpec dataSpec) {
        String str = dataSpec.f5028a;
        return str != null ? str : dataSpec.f5026a.toString();
    }

    String b(DataSpec dataSpec);
}
