package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface HonorPushCallback<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
