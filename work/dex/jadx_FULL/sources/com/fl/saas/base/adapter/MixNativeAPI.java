package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.saas.bean.AdSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MixNativeAPI {
    void clearCache();

    void destroy();

    void load(Activity activity);

    MixNativeAPI setAdId(String str, String str2);

    MixNativeAPI setAdParams(AdParams adParams);

    MixNativeAPI setAdSource(AdSource adSource);

    void setCache();

    MixNativeAPI setContext(Context context);

    MixNativeAPI setLoadListener(NativeLoadListener nativeLoadListener);
}
