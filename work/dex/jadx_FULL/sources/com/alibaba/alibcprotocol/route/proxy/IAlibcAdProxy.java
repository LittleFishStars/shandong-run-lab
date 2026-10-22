package com.alibaba.alibcprotocol.route.proxy;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = AlibcProtocolConstant.AD_CLASS_NAME)
public interface IAlibcAdProxy extends IProxy {
    void commitTaokeInfo(String str, Map<String, String> map, CpsCommitCallback cpsCommitCallback);

    void executeConvert(RouteRequest routeRequest, String str, String str2, CpsCommitCallback cpsCommitCallback);

    void executeConvert(boolean z, String str, String str2, String str3, CpsCommitCallback cpsCommitCallback);

    String getClickId(String str, boolean z);

    void init();
}
