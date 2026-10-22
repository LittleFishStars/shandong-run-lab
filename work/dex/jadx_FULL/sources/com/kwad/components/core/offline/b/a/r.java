package com.kwad.components.core.offline.b.a;

import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.sdk.utils.bs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class r implements ISystemProperties {
    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final String get(String str, String str2) {
        return bs.get(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final boolean getBoolean(String str, boolean z) {
        return bs.getBoolean(str, z);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final int getInt(String str, int i) {
        return bs.getInt(str, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final long getLong(String str, long j) {
        return bs.getLong(str, j);
    }
}
