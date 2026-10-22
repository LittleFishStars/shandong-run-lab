package cj.mobile.wm.common.bean;

import cj.mobile.wm.dexc;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
        return dexc.dexa("BeCmbdlDpogjh|tfotjujwfXpse>") + this.sensitiveWord + dexc.dexa("-!dsfbujwfJetVsm>(") + this.creativeIdsUrl + "'}";
    }
}
