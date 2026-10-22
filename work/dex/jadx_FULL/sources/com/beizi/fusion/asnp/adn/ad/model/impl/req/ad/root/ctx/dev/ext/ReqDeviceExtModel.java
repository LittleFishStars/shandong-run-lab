package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.ext;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReqDeviceExtModel extends ASNPJsonRequestModel {

    @kg(key = "coaid")
    private String coaid;

    @kg(key = "coreVersion")
    private String coreVersion;

    @kg(key = "deviceName")
    private String deviceName;

    @kg(key = "fileMark")
    private String fileMark;

    @kg(key = "harddiskSize")
    private String hardDiskSize;

    @kg(key = "hoaid")
    private String honorOAID;

    @kg(key = "isDeveloper")
    private int isDeveloper;

    @kg(key = "isPrompt")
    private int isPrompt;

    @kg(key = DeviceIdType.OAID)
    private String oaid;

    @kg(key = "openSDKVersion")
    private String openSDKVersion;

    @kg(key = "physicalMemory")
    private String physicalMemory;

    @kg(key = "romv")
    private String romVersion;

    @kg(key = "said")
    private String said;

    @kg(key = "storeVersion")
    private String storeVersion;

    @kg(key = "updateMark")
    private String updateMark;

    @kg(key = "wxInstall")
    private int wxInstall;

    @kg(key = "wxVersion")
    private String wxVersion;

    public void setCoaid(String str) {
        this.coaid = str;
    }

    public void setCoreVersion(String str) {
        this.coreVersion = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setFileMark(String str) {
        this.fileMark = str;
    }

    public void setHardDiskSize(String str) {
        this.hardDiskSize = str;
    }

    public void setHonorOAID(String str) {
        this.honorOAID = str;
    }

    public void setIsDeveloper(int i) {
        this.isDeveloper = i;
    }

    public void setIsPrompt(int i) {
        this.isPrompt = i;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOpenSDKVersion(String str) {
        this.openSDKVersion = str;
    }

    public void setPhysicalMemory(String str) {
        this.physicalMemory = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setSaid(String str) {
        this.said = str;
    }

    public void setStoreVersion(String str) {
        this.storeVersion = str;
    }

    public void setUpdateMark(String str) {
        this.updateMark = str;
    }

    public void setWxInstall(boolean z) {
        this.wxInstall = z ? 1 : 0;
    }

    public void setWxSupportApiVersion(String str) {
        this.wxVersion = str;
    }
}
