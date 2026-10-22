package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ObservableOnSubscribe<T> extends Observable.OnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;

    default void call(Subscriber<? super T> subscriber) {
        try {
            subscribe(new SubscriberObservableEmitter(subscriber));
        } catch (Exception unused) {
        }
    }
}
