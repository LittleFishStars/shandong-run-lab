package com.zj.adlib;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lz5 implements DiskTrimmableRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static lz5 f43188a;

    public static synchronized lz5 c() {
        if (f43188a == null) {
            f43188a = new lz5();
        }
        return f43188a;
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void a(DiskTrimmable diskTrimmable) {
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void b(DiskTrimmable diskTrimmable) {
    }
}
