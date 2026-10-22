package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
