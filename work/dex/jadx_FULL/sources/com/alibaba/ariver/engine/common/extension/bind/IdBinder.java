package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IdBinder implements Binder<BindingId, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24068a;

    public IdBinder(String str) {
        this.f24068a = str;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public String bind(Class<String> cls, BindingId bindingId) {
        return this.f24068a;
    }
}
