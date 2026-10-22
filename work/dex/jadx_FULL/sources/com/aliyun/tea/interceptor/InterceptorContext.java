package com.aliyun.tea.interceptor;

import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.TeaResponse;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InterceptorContext {
    private Map<String, Object> runtimeOptions;
    private TeaRequest teaRequest;
    private TeaResponse teaResponse;

    private InterceptorContext() {
    }

    public static InterceptorContext create() {
        return new InterceptorContext();
    }

    public InterceptorContext addRuntimeOptions(String str, Object obj) {
        this.runtimeOptions.put(str, obj);
        return this;
    }

    public InterceptorContext copy() {
        return create().setTeaRequest(this.teaRequest).setRuntimeOptions(this.runtimeOptions).setTeaResponse(this.teaResponse);
    }

    public Map<String, Object> runtimeOptions() {
        return this.runtimeOptions;
    }

    public InterceptorContext setRuntimeOptions(Map<String, Object> map) {
        this.runtimeOptions = map;
        return this;
    }

    public InterceptorContext setTeaRequest(TeaRequest teaRequest) {
        this.teaRequest = teaRequest;
        return this;
    }

    public InterceptorContext setTeaResponse(TeaResponse teaResponse) {
        this.teaResponse = teaResponse;
        return this;
    }

    public TeaRequest teaRequest() {
        return this.teaRequest;
    }

    public TeaResponse teaResponse() {
        return this.teaResponse;
    }
}
