package com.fl.saas.base.base;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.common.saas.bean.AdSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdapterAPI {
    void clearCache();

    void destroy();

    @NonNull
    AdSource getAdSource();

    boolean isCache();

    void load();

    void reportRequestShow();

    AdapterAPI setAdAdapter(@NonNull AdViewManager adViewManager);

    AdapterAPI setAdSource(@NonNull AdSource adSource);

    void setCache();

    AdapterAPI setContext(@NonNull Context context);

    void showAd();
}
