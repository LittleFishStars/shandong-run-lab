package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jr9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f42654a;

    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f17467a;

        public a(Subscriber subscriber) {
            this.f17467a = subscriber;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f17467a.isUnsubscribed()) {
                return;
            }
            this.f17467a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f42656a;

        public b(View.OnLayoutChangeListener onLayoutChangeListener) {
            this.f42656a = onLayoutChangeListener;
        }

        public void onUnsubscribe() {
            jr9.this.f42654a.removeOnLayoutChangeListener(this.f42656a);
        }
    }

    public jr9(View view) {
        this.f42654a = view;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b(aVar));
        this.f42654a.addOnLayoutChangeListener(aVar);
    }
}
