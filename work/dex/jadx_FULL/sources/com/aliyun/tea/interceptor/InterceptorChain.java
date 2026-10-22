package com.aliyun.tea.interceptor;

import com.aliyun.tea.utils.AttributeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InterceptorChain implements AutoCloseable {
    private List<RuntimeOptionsInterceptor> runtimeOptionsInterceptors = new ArrayList();
    private List<RequestInterceptor> requestInterceptors = new ArrayList();
    private List<ResponseInterceptor> responseInterceptors = new ArrayList();

    private InterceptorChain() {
    }

    public static InterceptorChain create() {
        return new InterceptorChain();
    }

    public void addRequestInterceptor(RequestInterceptor requestInterceptor) {
        this.requestInterceptors.add(requestInterceptor);
    }

    public void addResponseInterceptor(ResponseInterceptor responseInterceptor) {
        this.responseInterceptors.add(responseInterceptor);
    }

    public void addRuntimeOptionsInterceptor(RuntimeOptionsInterceptor runtimeOptionsInterceptor) {
        this.runtimeOptionsInterceptors.add(runtimeOptionsInterceptor);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.runtimeOptionsInterceptors.clear();
        this.requestInterceptors.clear();
        this.responseInterceptors.clear();
    }

    public InterceptorContext modifyRequest(InterceptorContext interceptorContext, AttributeMap attributeMap) {
        Iterator<RequestInterceptor> it = this.requestInterceptors.iterator();
        while (it.hasNext()) {
            interceptorContext.setTeaRequest(it.next().modifyRequest(interceptorContext, attributeMap));
        }
        return interceptorContext;
    }

    public InterceptorContext modifyResponse(InterceptorContext interceptorContext, AttributeMap attributeMap) {
        Iterator<ResponseInterceptor> it = this.responseInterceptors.iterator();
        while (it.hasNext()) {
            interceptorContext.setTeaResponse(it.next().modifyResponse(interceptorContext, attributeMap));
        }
        return interceptorContext;
    }

    public InterceptorContext modifyRuntimeOptions(InterceptorContext interceptorContext, AttributeMap attributeMap) {
        Iterator<RuntimeOptionsInterceptor> it = this.runtimeOptionsInterceptors.iterator();
        while (it.hasNext()) {
            interceptorContext.setRuntimeOptions(it.next().modifyRuntimeOptions(interceptorContext, attributeMap));
        }
        return interceptorContext;
    }
}
