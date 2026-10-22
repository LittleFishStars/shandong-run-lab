package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVMultimediaProxy extends Proxiable {
    String decodeLocalIdToPath(String str);

    String encodePathToLocalId(String str);

    boolean saveIdWithPath(String str, String str2);
}
