package com.alibaba.alibclinkpartner.smartlink.config;

import com.alibaba.alibclinkpartner.linkpartner.ALPTBLinkPartnerSDK;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLUri {
    public String action;
    public String backUrl;
    public String bcFlSrc;
    public String degradeH5Url;
    public ALSLdegradeType degradeType = ALSLdegradeType.H5;
    public Map<String, Object> extraParam = new HashMap();
    public ALPTBLinkPartnerSDK.JumpIntentProcessor intentProcessor;
    public String module;
    public String packageName;
    public String target;
    public String url;

    public enum ALSLdegradeType {
        NONE,
        H5,
        Download
    }
}
