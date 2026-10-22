package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ApiContextBinder implements Binder<BindingApiContext, ApiContext> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ApiContext f24066a;

    public ApiContextBinder(ApiContext apiContext) {
        this.f24066a = apiContext;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public ApiContext bind(Class<ApiContext> cls, BindingApiContext bindingApiContext) {
        if (bindingApiContext.required() && this.f24066a == null) {
            throw new BindException("Required ApiContext but not inject!!!");
        }
        return this.f24066a;
    }
}
