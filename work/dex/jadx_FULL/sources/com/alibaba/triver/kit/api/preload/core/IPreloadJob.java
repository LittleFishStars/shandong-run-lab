package com.alibaba.triver.kit.api.preload.core;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPreloadJob<T> {
    String getJobName();

    Class<T> getResultClazz();

    T preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType);
}
