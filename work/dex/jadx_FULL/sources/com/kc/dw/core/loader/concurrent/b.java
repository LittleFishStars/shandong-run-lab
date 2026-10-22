package com.kc.dw.core.loader.concurrent;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface b {
    void a(Object obj, int i, String str);

    void onLoadedError(int i, String str);

    void onLoadedSuccess(Object obj);

    void onRenderSuccess(Object obj);
}
