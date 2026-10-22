package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.kernel.common.log.DefaultAppLogConfigProxyImpl")
public interface AppLogConfigProxy extends Proxiable {
    String getCurrentEnv();

    Set<String> getErrorIgnoreAPIList();

    Set<String> getIgnoreAPIList();

    Set<String> getIgnoreErrorResourceHostList();

    Set<String> getIgnoreEventList();

    Set<String> getIgnoreInputAPIList();

    Set<String> getIgnoreOutputAPIList();
}
