package com.kc.bw.common.bean;

import com.kc.bw.common.utils.Utils;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FullInstBean {
    public int cacheDuration;
    public int checkType;
    public long checkedTime;
    public Set<Integer> instIdSet;
    public int recheckDuration;
    public Set<String> totalInstPkgSet;
    public Set<Integer> unInstIdSet;

    public int getCacheDuration() {
        return this.cacheDuration;
    }

    public int getCheckType() {
        return this.checkType;
    }

    public long getCheckedTime() {
        return this.checkedTime;
    }

    public Set<Integer> getInstIdSet() {
        return this.instIdSet;
    }

    public int getRecheckDuration() {
        return this.recheckDuration;
    }

    public Set<String> getTotalInstPkgSet() {
        return this.totalInstPkgSet;
    }

    public Set<Integer> getUnInstIdSet() {
        return this.unInstIdSet;
    }

    public boolean isNeedCleanCache() {
        return ((System.currentTimeMillis() - this.checkedTime) > (((((long) this.cacheDuration) * 60) * 60) * 1000) ? 1 : ((System.currentTimeMillis() - this.checkedTime) == (((((long) this.cacheDuration) * 60) * 60) * 1000) ? 0 : -1)) > 0;
    }

    public boolean isNeedRecheck() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.checkedTime;
        if (jCurrentTimeMillis - j > (((long) this.recheckDuration) * 60) * 1000) {
            return true;
        }
        return Utils.isNextDay(j, dexg.dexa("gvmmJotu"));
    }

    public void setCacheDuration(int i) {
        this.cacheDuration = i;
    }

    public void setCheckType(int i) {
        this.checkType = i;
    }

    public void setCheckedTime(long j) {
        this.checkedTime = System.currentTimeMillis();
    }

    public void setInstIdSet(Set<Integer> set) {
        this.instIdSet = set;
    }

    public void setRecheckDuration(int i) {
        this.recheckDuration = i;
    }

    public void setTotalInstPkgSet(Set<String> set) {
        this.totalInstPkgSet = set;
    }

    public void setUnInstIdSet(Set<Integer> set) {
        this.unInstIdSet = set;
    }

    public String toString() {
        return dexg.dexa("GvmmJotuCfbo|efcvh>gbmtf~");
    }
}
