package com.bun.miitmdid.interfaces;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface InnerIdProvider extends IdSupplier {
    boolean isSync();

    void shutDown();

    void startAction(IIdentifierListener iIdentifierListener);
}
