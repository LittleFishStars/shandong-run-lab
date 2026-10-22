package com.igexin.sdk.router.boatman;

import com.igexin.sdk.router.boatman.receive.IBoatResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BoatBean {
    private Object bag;
    private IBoatResult listener;

    public BoatBean() {
    }

    public BoatBean(Object obj, IBoatResult iBoatResult) {
        this.bag = obj;
        this.listener = iBoatResult;
    }

    public Object getBag() {
        return this.bag;
    }

    public IBoatResult getListener() {
        return this.listener;
    }

    public void setBag(Object obj) {
        this.bag = obj;
    }

    public void setListener(IBoatResult iBoatResult) {
        this.listener = iBoatResult;
    }
}
