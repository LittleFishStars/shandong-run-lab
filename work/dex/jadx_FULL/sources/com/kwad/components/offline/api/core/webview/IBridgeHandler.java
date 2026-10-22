package com.kwad.components.offline.api.core.webview;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
