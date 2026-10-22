package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RecordBean implements Serializable {
    private int clickNum;
    private int dynamicClickNum;
    private int exposureNum;
    private long lastClickTime;
    private long lastDynamicClickTime;
    private long lastDynamicLoadedTime;
    private int loadNum;
    private int loadSucc;
    private String pid;

    public static RecordBean fromJson(JSONObject jSONObject) {
        try {
            RecordBean recordBean = new RecordBean();
            recordBean.setPid(jSONObject.optString("pid", ""));
            recordBean.setLoadNum(jSONObject.optInt("loadNum", 0));
            recordBean.setLoadSucc(jSONObject.optInt("loadSucc", 0));
            recordBean.setExposureNum(jSONObject.optInt("exposureNum", 0));
            recordBean.setClickNum(jSONObject.optInt("clickNum", 0));
            recordBean.setDynamicClickNum(jSONObject.optInt("dynamicClickNum", 0));
            recordBean.setLastDynamicLoadedTime(jSONObject.optLong("lastDynamicLoadedTime", 0L));
            recordBean.setLastDynamicClickTime(jSONObject.optLong("lastDynamicClickTime", 0L));
            recordBean.setLastClickTime(jSONObject.optLong("lastClickTime", 0L));
            return recordBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getClickNum() {
        return this.clickNum;
    }

    public int getDynamicClickNum() {
        return this.dynamicClickNum;
    }

    public int getExposureNum() {
        return this.exposureNum;
    }

    public long getLastClickTime() {
        return this.lastClickTime;
    }

    public long getLastDynamicClickTime() {
        return this.lastDynamicClickTime;
    }

    public long getLastDynamicLoadedTime() {
        return this.lastDynamicLoadedTime;
    }

    public int getLoadNum() {
        return this.loadNum;
    }

    public int getLoadSucc() {
        return this.loadSucc;
    }

    public String getPid() {
        return this.pid;
    }

    public void setClickNum(int i) {
        this.clickNum = i;
    }

    public void setDynamicClickNum(int i) {
        this.dynamicClickNum = i;
    }

    public void setExposureNum(int i) {
        this.exposureNum = i;
    }

    public void setLastClickTime(long j) {
        this.lastClickTime = j;
    }

    public void setLastDynamicClickTime(long j) {
        this.lastDynamicClickTime = j;
    }

    public void setLastDynamicLoadedTime(long j) {
        this.lastDynamicLoadedTime = j;
    }

    public void setLoadNum(int i) {
        this.loadNum = i;
    }

    public void setLoadSucc(int i) {
        this.loadSucc = i;
    }

    public void setPid(String str) {
        this.pid = str;
    }
}
