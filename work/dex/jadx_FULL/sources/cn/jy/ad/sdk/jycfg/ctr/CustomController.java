package cn.jy.ad.sdk.jycfg.ctr;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CustomController implements JyController {
    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public String getAndroidId() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public String getImei() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public List<String> getInstalledPackages() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public String getIp() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public JyLocation getLocation() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public String getMacAddress() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public String getOaid() {
        return null;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanReadInstalledPackages() {
        return false;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseAndroidId() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseIp() {
        return false;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseLocation() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseNetworkState() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseOaid() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUsePermissionRecordAudio() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUsePhoneState() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseSensorManager() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseStoragePermission() {
        return true;
    }

    @Override // cn.jy.ad.sdk.jycfg.ctr.JyController
    public boolean isCanUseWifiState() {
        return true;
    }
}
