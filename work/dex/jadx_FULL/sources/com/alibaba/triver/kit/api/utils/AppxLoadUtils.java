package com.alibaba.triver.kit.api.utils;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppxLoadUtils {
    public static ResourcePackage getAppxPackageFromRAM() {
        return GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
    }
}
