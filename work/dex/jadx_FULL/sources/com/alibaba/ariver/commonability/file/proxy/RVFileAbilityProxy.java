package com.alibaba.ariver.commonability.file.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVFileAbilityProxy extends Proxiable {
    String getUserId();

    boolean hasFolderPermission(String str);

    String queryLocalIdByPath(String str);

    String queryPathByLocalId(String str);

    boolean saveIdWithPath(String str, String str2);
}
