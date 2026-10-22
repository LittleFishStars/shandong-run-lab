package com.alibaba.ariver.kernel.api.security;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Group {
    void assignPermissions(Map<String, ? extends Permission> map);

    String description();

    String groupName();

    Map<String, ? extends Permission> permissions();
}
