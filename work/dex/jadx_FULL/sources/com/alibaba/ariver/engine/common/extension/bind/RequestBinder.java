package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RequestBinder<T> implements Binder<BindingRequest, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f24071a;

    public RequestBinder(JSONObject jSONObject) {
        this.f24071a = jSONObject;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public T bind(Class<T> cls, BindingRequest bindingRequest) {
        JSONObject jSONObject = this.f24071a;
        if (jSONObject == null) {
            throw new BindException("input JSON is null");
        }
        try {
            return (T) JSON.toJavaObject(jSONObject, cls);
        } catch (Throwable th) {
            throw new BindException(th.getMessage());
        }
    }
}
