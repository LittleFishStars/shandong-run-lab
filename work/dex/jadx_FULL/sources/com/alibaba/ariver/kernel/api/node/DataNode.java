package com.alibaba.ariver.kernel.api.node;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface DataNode extends Node {
    @Nullable
    <T> T getData(Class<T> cls);

    <T> T getData(Class<T> cls, boolean z);

    <T> void setData(Class<T> cls, T t);
}
