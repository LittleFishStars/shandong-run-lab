package com.fl.saas.adx.base.manager.api;

import android.content.Context;
import com.fl.saas.C1428p0;
import com.fl.saas.adx.base.base.AdapterAPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ManagerLoader<S extends AdapterAPI> extends FailedLoader {
    S bindAdapter(S s);

    Context getContext();

    C1428p0 getContextOpt();

    String getLinkId();
}
