package com.zj.adlib;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.FileCache;
import com.facebook.cache.disk.b;
import com.facebook.imagepipeline.core.DiskStorageFactory;
import com.facebook.imagepipeline.core.FileCacheFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class do2 implements FileCacheFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DiskStorageFactory f41237a;

    public do2(DiskStorageFactory diskStorageFactory) {
        this.f41237a = diskStorageFactory;
    }

    public static b b(ao2 ao2Var, DiskStorage diskStorage) {
        return new b(diskStorage, ao2Var.g(), new b.C0634b(ao2Var.i(), ao2Var.h(), ao2Var.e()), ao2Var.d(), ao2Var.c(), ao2Var.f());
    }

    @Override // com.facebook.imagepipeline.core.FileCacheFactory
    public FileCache a(ao2 ao2Var) {
        return b(ao2Var, this.f41237a.a(ao2Var));
    }
}
