package com.alibaba.baichuan.trade.common.network;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RetryPolicy {
    int getCurrentRetryCount();

    HttpResponse retry(String str, HttpRequest httpRequest, Exception exc);
}
