package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class NavCallback implements NavigationCallback {
    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public abstract void onArrival(Postcard postcard);

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onFound(Postcard postcard) {
    }

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onInterrupt(Postcard postcard) {
    }

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onLost(Postcard postcard) {
    }
}
