package com.fl.saas.adx.base.manager.loader;

import androidx.annotation.NonNull;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.manager.api.ManagerLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BuilderAdLoader<T extends AdapterAPI> extends BaseLoader<T> {
    public BuilderAdLoader(@NonNull AdType adType, @NonNull ManagerLoader<T> managerLoader) {
        super(managerLoader, adType.getPos());
    }
}
