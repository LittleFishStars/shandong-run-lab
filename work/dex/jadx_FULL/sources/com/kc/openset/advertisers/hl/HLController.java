package com.kc.openset.advertisers.hl;

import android.content.pm.PackageInfo;
import com.hailiang.advlib.core.IQLocation;
import com.hailiang.advlib.core.QMCustomControl;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLController extends QMCustomControl {
    private final List<PackageInfo> mAppList = new ArrayList();

    static {
        OSETSDKProtected.interface11(4264);
    }

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native String getAndroidId();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native List<PackageInfo> getAppList();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native String getDevImei();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native String getDevImsi();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native String getMacAddress();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native String getOaid();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native IQLocation getQLocation();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native boolean isCanUseAndroidId();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native boolean isCanUseAppList();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native boolean isCanUseOaid();

    @Override // com.hailiang.advlib.core.QMCustomControl
    public native boolean isCanUsePhoneState();
}
