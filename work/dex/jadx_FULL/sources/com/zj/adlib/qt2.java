package com.zj.adlib;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.c;
import com.facebook.imagepipeline.core.DiskStorageFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class qt2 implements DiskStorageFactory {
    @Override // com.facebook.imagepipeline.core.DiskStorageFactory
    public DiskStorage a(ao2 ao2Var) {
        return new c(ao2Var.j(), ao2Var.b(), ao2Var.a(), ao2Var.c());
    }
}
