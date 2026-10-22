package com.alibaba.ariver.kernel.api.classloader;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultClassLoaderFactory implements RVClassLoaderFactory {
    @Override // com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory
    public ClassLoader getClassLoader(String str) {
        return DefaultClassLoaderFactory.class.getClassLoader();
    }
}
