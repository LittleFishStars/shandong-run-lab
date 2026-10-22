package com.acse.ottn.io.reactivex.disposables;

import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DisposableSubscription implements Subscription {
    Disposable disposable;

    public DisposableSubscription(Disposable disposable) {
        this.disposable = disposable;
    }

    public boolean isUnsubscribed() {
        return this.disposable.isDisposed();
    }

    public void unsubscribe() {
        this.disposable.dispose();
    }
}
