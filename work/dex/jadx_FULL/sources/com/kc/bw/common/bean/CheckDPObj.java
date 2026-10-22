package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CheckDPObj {
    public int checkDuration;
    public Map<Integer, String> schemeMap;

    public int getCheckDuration() {
        return this.checkDuration;
    }

    public Map<Integer, String> getSchemeMap() {
        return this.schemeMap;
    }

    public void setCheckDuration(int i) {
        this.checkDuration = i;
    }

    public void setSchemeMap(Map<Integer, String> map) {
        this.schemeMap = map;
    }
}
