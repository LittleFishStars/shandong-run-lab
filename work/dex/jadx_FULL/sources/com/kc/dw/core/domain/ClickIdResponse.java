package com.kc.dw.core.domain;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ClickIdResponse {
    private ClickIdInfo data;
    private Integer ret;

    @Keep
    public static class ClickIdInfo {
        private String clickid;
        private String dstlink;

        public String getClickid() {
            return this.clickid;
        }

        public String getDstlink() {
            return this.dstlink;
        }

        public void setClickid(String str) {
            this.clickid = str;
        }

        public void setDstlink(String str) {
            this.dstlink = str;
        }
    }

    public ClickIdInfo getData() {
        return this.data;
    }

    public Integer getRet() {
        return this.ret;
    }

    public void setData(ClickIdInfo clickIdInfo) {
        this.data = clickIdInfo;
    }

    public void setRet(Integer num) {
        this.ret = num;
    }
}
