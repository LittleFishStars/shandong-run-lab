package com.aliyun.tea.interceptor;

import com.aliyun.tea.TeaResponse;
import com.aliyun.tea.utils.AttributeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ResponseInterceptor {
    TeaResponse modifyResponse(InterceptorContext interceptorContext, AttributeMap attributeMap);
}
