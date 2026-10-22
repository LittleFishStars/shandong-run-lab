package com.aliyun.gateway.spi;

import com.aliyun.gateway.spi.models.AttributeMap;
import com.aliyun.gateway.spi.models.InterceptorContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class Client {
    public abstract void modifyConfiguration(InterceptorContext interceptorContext, AttributeMap attributeMap) throws Exception;

    public abstract void modifyRequest(InterceptorContext interceptorContext, AttributeMap attributeMap) throws Exception;

    public abstract void modifyResponse(InterceptorContext interceptorContext, AttributeMap attributeMap) throws Exception;
}
