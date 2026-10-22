package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IBundleService {
    void loadBundle(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void loadBundleWithString(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void unloadBundle(String str);
}
