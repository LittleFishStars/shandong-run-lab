package com.kc.openset.sdk.apiad.tools;

import com.kc.openset.sdk.apiad.InteractType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface APIAdClickCallback {
    void onClick(InteractType interactType, boolean z);

    void onDeeplinkViewTime(long j);
}
