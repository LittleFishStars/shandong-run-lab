package com.alibaba.alibcprotocol.route.proxy;

import android.content.Context;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcSDKInitResult;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = AlibcProtocolConstant.APPLINK_CLASS_NAME)
public interface IAlibcApplinkProxy extends IProxy {
    AlibcSDKInitResult init();

    void openUrl(Context context, String str, Map<String, Object> map, AppLinkOpenCallback appLinkOpenCallback);

    void turnOffDebug();

    void turnOnDebug();
}
