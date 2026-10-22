package com.alibaba.alibctriver.extensions;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.triver.extension.TriverMonitorPub;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTriverMonitorExtension implements TriverMonitorPub {
    @Override // com.alibaba.triver.extension.TriverMonitorPub
    public void fillCustomBehaviorArgs(Page page, Map<String, String> map) {
        map.put("ttid", AlibcBaseTradeCommon.ttid);
        map.put("sdkVersion", "5.0.2.5");
        map.put(UserTrackConstant.SDK_TYPE, "ultimate");
        map.put("appkey", AlibcBaseTradeCommon.getAppKey());
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
