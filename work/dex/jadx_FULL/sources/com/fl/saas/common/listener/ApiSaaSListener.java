package com.fl.saas.common.listener;

import com.fl.saas.common.saas.bean.AdPlace;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ApiSaaSListener {
    void onFailed(String str);

    void onSuccess(AdPlace adPlace);
}
