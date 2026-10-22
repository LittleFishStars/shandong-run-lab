package com.alibaba.ariver.kernel.api.security;

import com.alipay.sdk.m.m.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum DefaultGroup implements Group {
    INTERNAL("internal", "first party"),
    PARTNER(b.z0, "second party"),
    EXTERNAL("external", "third party");

    private String description;
    private String groupName;
    private Map<String, Permission> permissions;

    DefaultGroup(String str, String str2) {
        this.groupName = str;
        this.description = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public void assignPermissions(Map<String, ? extends Permission> map) {
        if (this.permissions == null) {
            this.permissions = new HashMap();
        }
        this.permissions.putAll(map);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public String description() {
        return this.description;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public String groupName() {
        return this.groupName;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public Map<String, ? extends Permission> permissions() {
        return this.permissions;
    }
}
