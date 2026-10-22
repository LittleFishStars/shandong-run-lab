package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface InterceptorService extends IProvider {
    void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback);
}
