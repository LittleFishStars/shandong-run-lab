package com.alibaba.triver.kit.api.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IRequestListener<T> {
    void onFailure(String str, String str2);

    void onSuccess(T t);
}
