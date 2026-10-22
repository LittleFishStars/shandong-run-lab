package com.alibaba.baichuan.trade.common.mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface NetworkRequestListener {
    void onError(int i, NetworkResponse networkResponse);

    void onSuccess(int i, NetworkResponse networkResponse);
}
