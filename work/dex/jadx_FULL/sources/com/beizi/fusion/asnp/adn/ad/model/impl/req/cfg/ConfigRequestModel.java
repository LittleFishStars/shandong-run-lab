package com.beizi.fusion.asnp.adn.ad.model.impl.req.cfg;

import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ConfigRequestModel extends ASNPJsonRequestModel {

    @kg(key = "appId")
    private String appID;

    @kg(key = "brand")
    private String brand;

    @kg(key = "carrier")
    private String carrier;

    @kg(key = "coaid")
    private String coaid;

    @kg(key = "connectType")
    private int connectType;

    @kg(key = ze1.s)
    private String country;

    @kg(key = "country_CN")
    private int country_CN;

    @kg(key = "density")
    private float density;

    @kg(key = "deviceName")
    private String deviceName;

    @kg(key = "deviceType")
    private int deviceType;

    @kg(key = "fileMark")
    private String fileMark;

    @kg(key = "harddiskSize")
    private String hardDiskSize;

    @kg(key = MediaFormat.KEY_LANGUAGE)
    private String language;

    @kg(key = ze1.p)
    private String manufacturer;

    @kg(key = ze1.k)
    private String model;

    @kg(key = DeviceIdType.OAID)
    private String oaid;

    @kg(key = "orientation")
    private int orientation;

    @kg(key = "os")
    private int os;

    @kg(key = "osVersion")
    private String osVersion;

    @kg(key = "physicalMemory")
    private String physicalMemory;

    @kg(key = "planIds")
    private List<String> planIds;

    @kg(key = "ppi")
    private float ppi;

    @kg(key = "requestUrlMD5")
    private String requestUrlMD5;

    @kg(key = "resolutionHeight")
    private int resolutionHeight;

    @kg(key = "resolutionWidth")
    private int resolutionWidth;

    @kg(key = "said")
    private String said;

    @kg(key = "screenHeight")
    private int screenHeight;

    @kg(key = "screenWidth")
    private int screenWidth;

    @kg(key = "sdkVersion")
    private String sdkVersion;

    @kg(key = "spaceStrategyMD5")
    private String spaceStrategyMD5 = "";

    @kg(key = "statisticsMD5")
    private String statisticsMD5;

    @kg(key = "timeStamp")
    private long timeStamp;

    @kg(key = "timeZone")
    private String timeZone;

    @kg(key = "updateMark")
    private String updateMark;

    @kg(key = "updateMD5")
    private String updateMd5;

    @kg(key = TRiverConstants.KEY_ENVIRONMENT_USERAGENT)
    private String userAgent;

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setBetaPlanIds(List<String> list) {
        this.planIds = list;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCOAID(String str) {
        this.coaid = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setConnectType(int i) {
        this.connectType = i;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountry_CN(int i) {
        this.country_CN = i;
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void setFileMark(String str) {
        this.fileMark = str;
    }

    public void setHardDiskSize(String str) {
        this.hardDiskSize = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOAID(String str) {
        this.oaid = str;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setOs(int i) {
        this.os = i;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPhysicalMemory(String str) {
        this.physicalMemory = str;
    }

    public void setPpi(float f) {
        this.ppi = f;
    }

    public void setRequestUrlMD5(String str) {
        this.requestUrlMD5 = str;
    }

    public void setResolutionHeight(int i) {
        this.resolutionHeight = i;
    }

    public void setResolutionWidth(int i) {
        this.resolutionWidth = i;
    }

    public void setSAID(String str) {
        this.said = str;
    }

    public void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setStatisticsMD5(String str) {
        this.statisticsMD5 = str;
    }

    public void setStrategyMD5(String str) {
        this.spaceStrategyMD5 = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public void setUpdateMark(String str) {
        this.updateMark = str;
    }

    public void setUpdateMd5(String str) {
        this.updateMd5 = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
