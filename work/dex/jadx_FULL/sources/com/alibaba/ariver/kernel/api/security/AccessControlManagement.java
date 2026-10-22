package com.alibaba.ariver.kernel.api.security;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AccessControlManagement {
    boolean asyncInterceptJsapi(Permission permission, Accessor accessor);

    boolean asyncPermissionCheck(Permission permission, Accessor accessor);

    boolean bizPermissionCheck(Permission permission, Accessor accessor);

    Group manageAccessorGroup(Accessor accessor);

    boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list);

    ApiPermissionCheckResult permissionCheck(Permission permission, Accessor accessor);
}
