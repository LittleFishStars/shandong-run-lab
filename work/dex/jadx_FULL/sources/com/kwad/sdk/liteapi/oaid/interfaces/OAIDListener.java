package com.kwad.sdk.liteapi.oaid.interfaces;

import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OAIDListener {
    @WorkerThread
    void OnOAIDValid(String str);
}
