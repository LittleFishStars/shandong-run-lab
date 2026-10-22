package com.alibaba.triver.kit.api.network;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface CommonListener<T, D> {
    void onFailure(String str, String str2, D d);

    void onSuccess(T t);
}
