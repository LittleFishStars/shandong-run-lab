package com.fl.saas.base.adapter.manager;

import com.fl.saas.base.base.AdapterAPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdapterAPIManager<T extends AdapterAPI> extends APIManager<T> {
    public AdapterAPIManager(Class<T> cls) {
        super(cls);
    }

    @Override // com.fl.saas.base.adapter.manager.APIManager
    public Class<?> registerClass() {
        return AdapterAPI.class;
    }
}
