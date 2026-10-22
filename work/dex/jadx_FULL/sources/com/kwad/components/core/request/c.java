package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class c extends k {
    @WorkerThread
    public abstract void a(int i, String str, boolean z);

    @WorkerThread
    public abstract void a(@NonNull AdResultData adResultData, boolean z);
}
