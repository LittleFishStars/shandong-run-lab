package com.kc.openset.pine.manager.tobid;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ToBidBean {
    private BaseAdCache baseAdCache;
    private String network;
    private final Set<Object> objects = new HashSet();
    private String placementId;

    static {
        OSETSDKProtected.interface11(4642);
    }

    public native BaseAdCache getBaseAdCache();

    public native String getNetwork();

    public native Set<Object> getObjects();

    public native String getPlacementId();

    public native void setBaseAdCache(BaseAdCache baseAdCache);

    public native void setNetwork(String str);

    public native void setPlacementId(String str);
}
