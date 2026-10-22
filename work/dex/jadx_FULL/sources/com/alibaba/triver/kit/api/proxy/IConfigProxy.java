package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.alibaba.proxy.ConfigProxy")
public interface IConfigProxy extends Proxiable {

    public interface ConfigListener {
        void onConfigUpdate(Map<String, String> map);
    }

    Map<String, String> getConfigsByGroup(String str);

    String getConfigsByGroupAndName(String str, String str2, String str3);

    String getCustomConfigsByGroup(String str);

    void registerListener(String str, ConfigListener configListener);

    void unregisterListener(String str, ConfigListener configListener);
}
