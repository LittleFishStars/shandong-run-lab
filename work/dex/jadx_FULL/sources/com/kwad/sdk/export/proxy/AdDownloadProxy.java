package com.kwad.sdk.export.proxy;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DownloadParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    @Nullable
    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
