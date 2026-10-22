package com.aliyun.tea.interceptor;

import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.AttributeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface RequestInterceptor {
    TeaRequest modifyRequest(InterceptorContext interceptorContext, AttributeMap attributeMap);
}
