package com.kwad.components.core.offline.b.a;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class c implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : com.kwad.components.core.video.k.k(ServiceProvider.getContext(), str);
    }
}
