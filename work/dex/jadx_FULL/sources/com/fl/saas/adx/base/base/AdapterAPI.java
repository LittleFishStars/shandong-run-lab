package com.fl.saas.adx.base.base;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.C1415j;
import com.fl.saas.adx.base.bean.MaterialBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdapterAPI {
    void clearCache();

    void destroy();

    @NonNull
    C1415j getAdSource();

    boolean isCache();

    void load();

    void reportRequestShow();

    AdapterAPI setAdSource(@NonNull C1415j c1415j);

    void setCache();

    AdapterAPI setContext(@NonNull Context context);

    void setHot(boolean z);

    void setLinkId(String str);

    void setMaterial(MaterialBean materialBean);

    AdapterAPI setPlaceId(String str);

    void showAd();
}
