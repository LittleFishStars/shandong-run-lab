package com.alibaba.ariver.kernel.api.security;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Accessor {

    public interface InquiryCallback {
        void onComplete(List<? extends Permission> list, List<? extends Permission> list2);
    }

    Group getGroup();

    void inquiry(List<? extends Permission> list, InquiryCallback inquiryCallback);

    List<Permission> usePermissions();
}
