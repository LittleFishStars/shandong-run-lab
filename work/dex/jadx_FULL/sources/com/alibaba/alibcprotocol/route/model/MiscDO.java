package com.alibaba.alibcprotocol.route.model;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MiscDO implements Serializable {
    private static final long serialVersionUID = -1810077063975122225L;
    private String componentDegrade;
    private String em;
    private String enableMultiProcess;
    private String extConfigApi;
    private String failMode;
    private String guideAccount;
    private String isNeedAlipay;
    private String isSyncForTaoke;
    private String isTUnionMtopDegrade;
    private String isvCode;
    private String launchExBrand;
    private String launchSwitch;
    private String launchTimes;
    private String loginDegarade;
    private String miniConf;
    private JSONObject miniConfJson;
    private String monitorSampling;
    private String sampling;
    private String urlApi;
    private String al = "1";
    private int st = 1;
    private String backControl = AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;

    public String getAl() {
        return this.al;
    }

    public String getBackControl() {
        return this.backControl;
    }

    public String getComponentDegrade() {
        return this.componentDegrade;
    }

    public String getEm() {
        return this.em;
    }

    public String getEnableMultiProcess() {
        return this.enableMultiProcess;
    }

    public String getExtConfigApi() {
        return this.extConfigApi;
    }

    public String getFailMode() {
        return this.failMode;
    }

    public String getGuideAccount() {
        return this.guideAccount;
    }

    public String getIsNeedAlipay() {
        return this.isNeedAlipay;
    }

    public String getIsSyncForTaoke() {
        return this.isSyncForTaoke;
    }

    public String getIsTUnionMtopDegrade() {
        return this.isTUnionMtopDegrade;
    }

    public String getIsvCode() {
        return this.isvCode;
    }

    public String getLaunchExBrand() {
        return this.launchExBrand;
    }

    public String getLaunchSwitch() {
        return this.launchSwitch;
    }

    public String getLaunchTimes() {
        return this.launchTimes;
    }

    public String getLoginDegarade() {
        return this.loginDegarade;
    }

    public String getMiniConf() {
        return this.miniConf;
    }

    public JSONObject getMiniConfJson() {
        return this.miniConfJson;
    }

    public String getMonitorSampling() {
        return this.monitorSampling;
    }

    public String getSampling() {
        return this.sampling;
    }

    public int getSt() {
        return this.st;
    }

    public String getUrlApi() {
        return this.urlApi;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public void setBackControl(String str) {
        this.backControl = str;
    }

    public void setComponentDegrade(String str) {
        this.componentDegrade = str;
    }

    public void setEm(String str) {
        this.em = str;
    }

    public void setEnableMultiProcess(String str) {
        this.enableMultiProcess = str;
    }

    public void setExtConfigApi(String str) {
        this.extConfigApi = str;
    }

    public void setFailMode(String str) {
        this.failMode = str;
    }

    public void setGuideAccount(String str) {
        this.guideAccount = str;
    }

    public void setIsNeedAlipay(String str) {
        this.isNeedAlipay = str;
    }

    public void setIsSyncForTaoke(String str) {
        this.isSyncForTaoke = str;
    }

    public void setIsTUnionMtopDegrade(String str) {
        this.isTUnionMtopDegrade = str;
    }

    public void setIsvCode(String str) {
        this.isvCode = str;
    }

    public void setLaunchExBrand(String str) {
        this.launchExBrand = str;
    }

    public void setLaunchSwitch(String str) {
        this.launchSwitch = str;
    }

    public void setLaunchTimes(String str) {
        this.launchTimes = str;
    }

    public void setLoginDegarade(String str) {
        this.loginDegarade = str;
    }

    public void setMiniConf(String str) {
        this.miniConf = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.miniConfJson = JSON.parseObject(str);
        } catch (Exception e) {
            AlibcLogger.e("miniConf", e.getMessage());
        }
    }

    public void setMonitorSampling(String str) {
        this.monitorSampling = str;
    }

    public void setSampling(String str) {
        this.sampling = str;
    }

    public void setSt(int i) {
        this.st = i;
    }

    public void setUrlApi(String str) {
        this.urlApi = str;
    }
}
