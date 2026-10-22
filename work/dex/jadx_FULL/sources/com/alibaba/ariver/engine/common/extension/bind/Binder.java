package com.alibaba.ariver.engine.common.extension.bind;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Binder<A extends Annotation, T> {
    T bind(Class<T> cls, A a2);
}
