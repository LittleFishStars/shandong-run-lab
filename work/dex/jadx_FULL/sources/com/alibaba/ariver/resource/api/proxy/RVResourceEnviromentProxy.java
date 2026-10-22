package com.alibaba.ariver.resource.api.proxy;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVResourceEnviromentProxy extends Proxiable {
    String getConfigVariable();

    @Nullable
    String getLegacySignPublicKey();

    @Nullable
    String getNewSignPublicKey();
}
