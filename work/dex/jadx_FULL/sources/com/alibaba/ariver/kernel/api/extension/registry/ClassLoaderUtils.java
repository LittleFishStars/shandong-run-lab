package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class ClassLoaderUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24203a = "AriverKernel:ClassLoaderUtils";

    public static Class<? extends Extension> loadClass(String str, String str2) {
        try {
            return ((RVClassLoaderFactory) RVProxy.get(RVClassLoaderFactory.class)).getClassLoader(str).loadClass(str2);
        } catch (Throwable th) {
            RVLogger.e(f24203a, "failed to load class", th);
            return null;
        }
    }
}
