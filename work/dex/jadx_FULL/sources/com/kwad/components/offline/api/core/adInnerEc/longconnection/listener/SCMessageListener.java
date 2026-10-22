package com.kwad.components.offline.api.core.adInnerEc.longconnection.listener;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface SCMessageListener {
    int getPayloadType();

    boolean isSticky();

    void onMessageReceived(byte[] bArr);
}
