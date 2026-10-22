package com.kwad.components.offline.api.core.api;

import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(TKExceptionUploadParams tKExceptionUploadParams);

    void gatherException(Throwable th);
}
