package com.alibaba.ariver.kernel.api.extension.bridge;

import com.alibaba.ariver.kernel.api.security.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgePermission implements Permission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24200a;
    private String b;

    public BridgePermission(String str, String str2) {
        this.f24200a = str;
        this.b = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String authority() {
        return this.f24200a;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String description() {
        return this.b;
    }

    public String toString() {
        return "authority=" + this.f24200a + ",description=" + this.b;
    }
}
