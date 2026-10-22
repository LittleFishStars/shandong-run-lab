package com.igexin.sdk.router.boatman;

import com.igexin.sdk.router.boatman.receive.Site;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface IShips {
    boolean isRegistered(Site site);

    void register(Site site);

    void unRegister(Site site);
}
