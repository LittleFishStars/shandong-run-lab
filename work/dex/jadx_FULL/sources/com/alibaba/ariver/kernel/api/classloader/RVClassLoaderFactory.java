package com.alibaba.ariver.kernel.api.classloader;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.kernel.api.classloader.DefaultClassLoaderFactory")
public interface RVClassLoaderFactory extends Proxiable {
    ClassLoader getClassLoader(String str);
}
