package com.fl.saas.base.manager.api;

import android.content.Context;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.common.util.feature.Optional;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ManagerLoader<S extends AdapterAPI> extends FailedLoader {
    S bindAdapter(S s);

    Optional<Context> getContextOpt();
}
