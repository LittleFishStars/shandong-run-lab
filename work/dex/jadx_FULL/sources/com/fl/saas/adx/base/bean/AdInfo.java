package com.fl.saas.adx.base.bean;

import com.fl.saas.adx.util.DeviceUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdInfo {
    private int abFlag;
    private ConcurrentHashMap<String, Object> customMap;
    private String groupId;
    private int mAdv_id = 0;
    private String mTagid = "";

    public static AdInfo create(int i, String str, String str2, int i2) {
        AdInfo adInfoCreateEmpty = createEmpty();
        adInfoCreateEmpty.setAdv_id(i);
        adInfoCreateEmpty.setTagid(str);
        adInfoCreateEmpty.setGroupId(str2);
        adInfoCreateEmpty.setAbFlag(i2);
        ConcurrentHashMap<String, Object> concurrentHashMap = DeviceUtil.customMap;
        if (concurrentHashMap != null) {
            adInfoCreateEmpty.setCustomMap(concurrentHashMap);
        }
        return adInfoCreateEmpty;
    }

    public static AdInfo createEmpty() {
        return new AdInfo();
    }

    public int getAbFlag() {
        return this.abFlag;
    }

    public int getAdv_id() {
        return this.mAdv_id;
    }

    public Map<String, Object> getCustomMap() {
        return this.customMap;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getTagid() {
        return this.mTagid;
    }

    public void setAbFlag(int i) {
        this.abFlag = i;
    }

    public void setAdv_id(int i) {
        this.mAdv_id = i;
    }

    public void setCustomMap(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.customMap = concurrentHashMap;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setTagid(String str) {
        this.mTagid = str;
    }
}
