package com.hailiang.advlib.core;

import android.content.pm.PackageInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public abstract class QMCustomControl {
    @Deprecated
    public String getAndroidId() {
        return null;
    }

    public List<PackageInfo> getAppList() {
        return null;
    }

    public Map<String, Object> getCustomConfig() {
        return null;
    }

    @Deprecated
    public String getDevImei() {
        return null;
    }

    @Deprecated
    public String getDevImsi() {
        return null;
    }

    @Deprecated
    public String getMacAddress() {
        return null;
    }

    public String getOaid() {
        return null;
    }

    public IQLocation getQLocation() {
        return null;
    }

    @Deprecated
    public boolean isCanUseAndroidId() {
        return false;
    }

    public boolean isCanUseAppList() {
        return false;
    }

    public boolean isCanUseBootId() {
        return false;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    @Deprecated
    public boolean isCanUsePhoneState() {
        return false;
    }
}
