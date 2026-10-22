package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVFileAbilityProvider extends Proxiable {
    String decodeLocalIdToPath(String str);

    String getUserId();

    boolean removeLocalId(String str);

    boolean savePathAndLocalId(String str, String str2);
}
