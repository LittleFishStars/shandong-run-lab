package com.kc.bw.common.bean;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdBlackConfig {
    public String creativeIdsUrl;
    public List<String> sensitiveWord;

    public String getCreativeIdsUrl() {
        return this.creativeIdsUrl;
    }

    public List<String> getSensitiveWord() {
        return this.sensitiveWord;
    }

    public void setCreativeIdsUrl(String str) {
        this.creativeIdsUrl = str;
    }

    public void setSensitiveWord(List<String> list) {
        this.sensitiveWord = list;
    }

    public String toString() {
        return dexg.dexa("BeCmbdlDpogjh|tfotjujwfXpse>") + this.sensitiveWord + dexg.dexa("-!dsfbujwfJetVsm>(") + this.creativeIdsUrl + "'}";
    }
}
