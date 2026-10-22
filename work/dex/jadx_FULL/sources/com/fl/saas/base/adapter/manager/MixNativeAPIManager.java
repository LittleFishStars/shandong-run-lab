package com.fl.saas.base.adapter.manager;

import com.fl.saas.base.adapter.MixNativeAPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MixNativeAPIManager<T extends MixNativeAPI> extends APIManager<T> {
    public MixNativeAPIManager(Class<T> cls) {
        super(cls);
    }

    @Override // com.fl.saas.base.adapter.manager.APIManager
    public Class<?> registerClass() {
        return MixNativeAPI.class;
    }
}
