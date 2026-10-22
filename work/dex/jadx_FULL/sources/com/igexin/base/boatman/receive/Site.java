package com.igexin.base.boatman.receive;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class Site<Bag, V> {
    public abstract String getTag();

    public abstract V onArrived(Bag bag);

    public abstract void onArrived(Bag bag, IBoatResult<V> iBoatResult);
}
