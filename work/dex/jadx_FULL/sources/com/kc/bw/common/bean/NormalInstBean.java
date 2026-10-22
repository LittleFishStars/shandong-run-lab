package com.kc.bw.common.bean;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class NormalInstBean {
    public Set<String> normalInstIdSet;
    public long roll64;

    public Set<String> getNormalInstIdSet() {
        return this.normalInstIdSet;
    }

    public long getRoll64() {
        return this.roll64;
    }

    public void setNormalInstIdSet(Set<String> set) {
        this.normalInstIdSet = set;
    }

    public void setRoll64(long j) {
        this.roll64 = j;
    }
}
