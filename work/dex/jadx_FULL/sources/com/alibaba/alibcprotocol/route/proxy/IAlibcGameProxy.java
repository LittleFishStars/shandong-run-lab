package com.alibaba.alibcprotocol.route.proxy;

import com.alibaba.alibcprotocol.callback.AlibcGameCallback;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcSDKInitResult;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = "com.randy.alibcgame.AlibcGame")
public interface IAlibcGameProxy extends IProxy {
    AlibcSDKInitResult init();

    void init(AlibcGameCallback alibcGameCallback);

    void route(String str, Map<String, Object> map, com.alibaba.alibcprotocol.sdk.a aVar);
}
