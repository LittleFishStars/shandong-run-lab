package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageSource {
    public String sourceDesc = "";
    public String sourcePageAppLogToken = "";
    public SourceType sourceType = SourceType.UNKNOWN;

    public enum SourceType {
        START_APP(RVStartParams.START_SCENE_START_APP),
        PUSH_WINDOW("pushWindow"),
        SWITCH_TAB("switchTab"),
        TAB_CLICK(RVEvents.TAB_CLICK),
        TAB_INIT("tabInit"),
        TAB_PUSH("tabPush"),
        EMBED_VIEW("embedView"),
        HREF_CHANGE("hrefChange"),
        UNKNOWN("unknown");

        private String raw;

        SourceType(String str) {
            this.raw = str;
        }

        public String getRaw() {
            return this.raw;
        }
    }
}
