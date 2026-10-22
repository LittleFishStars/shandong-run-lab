package com.kwad.components.offline.api.core.adInnerEc;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostUploadListener {
    void onFailed(int i, String str);

    void onProgress(float f);

    void onSuccess(String str);
}
