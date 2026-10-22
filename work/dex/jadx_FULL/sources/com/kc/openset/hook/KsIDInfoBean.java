package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsIDInfoBean {
    private String ksAppId;
    private final Set<String> posIdList = new HashSet();
    private boolean isSS = false;

    static {
        OSETSDKProtected.interface11(4444);
    }

    public native String getKsAppId();

    public native List<String> getPosIdList();

    public native boolean isSS();

    public native void putPosId(String str);

    public native void setKsAppId(String str);

    public native void setSS(boolean z);

    public native String toString();
}
