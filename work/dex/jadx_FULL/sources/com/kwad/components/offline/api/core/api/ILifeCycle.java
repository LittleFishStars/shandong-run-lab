package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i);
}
