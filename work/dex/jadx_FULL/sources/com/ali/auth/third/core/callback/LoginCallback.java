package com.ali.auth.third.core.callback;

import com.ali.auth.third.core.model.Session;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LoginCallback extends FailureCallback {
    void onSuccess(Session session);
}
