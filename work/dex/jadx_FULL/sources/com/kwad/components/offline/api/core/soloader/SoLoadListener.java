package com.kwad.components.offline.api.core.soloader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface SoLoadListener {
    void onFailed(int i, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
