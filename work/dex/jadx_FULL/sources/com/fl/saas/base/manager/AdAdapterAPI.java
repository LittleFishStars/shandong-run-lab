package com.fl.saas.base.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.common.saas.bean.AdSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdAdapterAPI {
    void destroy();

    @NonNull
    AdSource getAdSource();

    boolean isCache();

    void load();

    void reportRequestShow();

    AdAdapterAPI setAdAdapter(@NonNull AdViewManager adViewManager);

    AdAdapterAPI setAdSource(@NonNull AdSource adSource);

    void setCache();

    AdAdapterAPI setContext(@NonNull Context context);

    void showAd();
}
