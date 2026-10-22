package com.alibaba.ariver.kernel.api.extension.bridge;

import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeGuard implements Guard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Permission f24199a;

    public BridgeGuard(Permission permission) {
        this.f24199a = permission;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return this.f24199a;
    }
}
