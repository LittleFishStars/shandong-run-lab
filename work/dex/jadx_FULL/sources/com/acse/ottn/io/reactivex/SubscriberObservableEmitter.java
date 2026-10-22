package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.disposables.Disposable;
import com.acse.ottn.io.reactivex.functions.Cancellable;
import rx.Subscriber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SubscriberObservableEmitter<T> implements ObservableEmitter<T>, Disposable {
    Disposable disposable;
    Subscriber<? super T> subscriber;

    public SubscriberObservableEmitter(Subscriber<? super T> subscriber) {
        this.subscriber = subscriber;
    }

    @Override // com.acse.ottn.io.reactivex.disposables.Disposable
    public void dispose() {
        Subscriber<? super T> subscriber = this.subscriber;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter, com.acse.ottn.io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.disposable;
        return disposable == null ? this.subscriber.isUnsubscribed() : disposable.isDisposed();
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onComplete() {
        this.subscriber.onCompleted();
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onNext(T t) {
        this.subscriber.onNext(t);
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public ObservableEmitter<T> serialize() {
        return this;
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public void setCancellable(Cancellable cancellable) {
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public boolean tryOnError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isDisposed()) {
            return false;
        }
        try {
            this.subscriber.onError(th);
            return true;
        } finally {
            dispose();
        }
    }
}
