package com.kc.dw.core.loader.serverbidding;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class S2sbCacheEntity {
    private List<S2SBDataBean> s2sbList;

    @Keep
    public static class S2SBDataBean {
        private String appId;
        private String pid;
        private String platform;
        private long updateTime;

        public String getAppId() {
            return this.appId;
        }

        public String getPid() {
            return this.pid;
        }

        public String getPlatform() {
            return this.platform;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public boolean isValid() {
            return System.currentTimeMillis() - this.updateTime < 604800000;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setPid(String str) {
            this.pid = str;
        }

        public void setPlatform(String str) {
            this.platform = str;
        }

        public void setUpdateTime(long j) {
            this.updateTime = j;
        }
    }

    public List<S2SBDataBean> getS2sbList() {
        return this.s2sbList;
    }

    public void setS2sbList(List<S2SBDataBean> list) {
        this.s2sbList = list;
    }
}
