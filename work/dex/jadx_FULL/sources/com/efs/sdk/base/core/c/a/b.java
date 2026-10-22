package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        if (logDto.isSendImediately()) {
            b(logDto);
        } else {
            CacheManager.getInstance().put(logDto);
        }
    }
}
