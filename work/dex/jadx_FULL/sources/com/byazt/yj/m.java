package com.byazt.yj;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface m<T> {
    String getCacheKey();

    int getFileSize();

    Map<String, String> getHeaders();

    int getHeight();

    x getHttpTime();

    T getOriginResult();

    T getResult();

    String getUrl();

    int getWidth();

    boolean isGif();

    boolean isLocal();

    void setResult(T t);
}
