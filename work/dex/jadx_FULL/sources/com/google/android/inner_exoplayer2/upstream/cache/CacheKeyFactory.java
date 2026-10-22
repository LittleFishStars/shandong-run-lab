package com.google.android.inner_exoplayer2.upstream.cache;

import com.google.android.inner_exoplayer2.upstream.DataSpec;
import com.google.android.inner_exoplayer2.upstream.cache.CacheKeyFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory() { // from class: com.zj.adlib.w91
        @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheKeyFactory
        public final String buildCacheKey(DataSpec dataSpec) {
            return CacheKeyFactory.lambda$static$0(dataSpec);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }

    String buildCacheKey(DataSpec dataSpec);
}
