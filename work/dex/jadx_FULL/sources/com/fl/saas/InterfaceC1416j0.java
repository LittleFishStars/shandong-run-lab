package com.fl.saas;

import android.content.Context;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;

/* JADX INFO: renamed from: com.fl.saas.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InterfaceC1416j0 {
    InterfaceC1416j0 a(AdParams adParams);

    InterfaceC1416j0 a(NativeLoadListener nativeLoadListener);

    InterfaceC1416j0 a(String str, String str2);

    void a(Context context);

    void clearCache();

    void destroy();

    C1415j getAdSource();

    void setCache();

    InterfaceC1416j0 setContext(Context context);

    InterfaceC1416j0 setLinkId(String str);
}
