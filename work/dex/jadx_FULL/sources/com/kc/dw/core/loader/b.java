package com.kc.dw.core.loader;

import android.content.Context;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.loader.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface b<Loader extends a> {
    void destroy();

    Loader getAdLoader();

    Context getContext();

    SdkAdInfo getSdkAdInfo();

    void init(Loader loader, SdkAdInfo sdkAdInfo);

    void loadAd();

    void setConCurrentLoadListener(com.kc.dw.core.loader.concurrent.b bVar);

    void setGroupIndex(int i);

    void setLocalParams(Map<String, Object> map);
}
