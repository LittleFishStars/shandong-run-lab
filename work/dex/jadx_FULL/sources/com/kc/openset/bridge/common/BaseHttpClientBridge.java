package com.kc.openset.bridge.common;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface BaseHttpClientBridge extends BaseCommonBridge {
    void get(String str, Map<String, String> map, OSETHttpCallback oSETHttpCallback);

    void post(String str, Map<String, String> map, String str2, OSETHttpCallback oSETHttpCallback);
}
