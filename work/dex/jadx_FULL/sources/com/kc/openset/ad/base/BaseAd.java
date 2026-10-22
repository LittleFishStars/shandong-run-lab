package com.kc.openset.ad.base;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.kc.openset.ad.base.Base;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseAd<T extends Base> implements Base {
    protected static Map<String, BaseAdCache> rewardCacheMap;
    protected WeakReference<Context> initContext;
    protected String posId;
    protected String userId;

    static {
        OSETSDKProtected.interface11(3738);
        rewardCacheMap = new HashMap();
    }

    public abstract BaseAdCache createAdCache();

    public native BaseAdCache getBaseAdCache();

    public native String getS2SInfo();

    public abstract BaseAdCache getSingleCacheObj();

    public native T setContext(Activity activity);

    public native T setPosId(String str);

    public native T setUserId(String str);

    public native void startLoad();
}
