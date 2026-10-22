package com.zj.adlib;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class nz5 implements MemoryTrimmableRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static nz5 f43633a;

    public static synchronized nz5 c() {
        if (f43633a == null) {
            f43633a = new nz5();
        }
        return f43633a;
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void a(MemoryTrimmable memoryTrimmable) {
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void b(MemoryTrimmable memoryTrimmable) {
    }
}
