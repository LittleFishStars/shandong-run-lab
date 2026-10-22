package com.alibaba.ariver.kernel.api.security;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum DefaultPermission implements Permission {
    ALL("all", "") { // from class: com.alibaba.ariver.kernel.api.security.DefaultPermission.1
    };

    private String authority;
    private String description;

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String authority() {
        return this.authority;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String description() {
        return this.description;
    }

    DefaultPermission(String str, String str2) {
        this.authority = str;
        this.description = str2;
    }
}
