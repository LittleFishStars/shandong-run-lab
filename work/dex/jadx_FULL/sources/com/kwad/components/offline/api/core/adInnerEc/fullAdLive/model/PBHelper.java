package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface PBHelper {
    PbClientStat getPbClientStat();

    PbPayloadType getPbPayloadType();

    <T> T parseFrom(byte[] bArr, Class<T> cls);
}
