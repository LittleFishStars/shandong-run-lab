package com.zj.adlib;

import android.annotation.TargetApi;
import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(23)
public final class rr9 implements Observable.OnSubscribe<qr9> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44520a;

    public class a implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19403a;

        public a(Subscriber subscriber) {
            this.f19403a = subscriber;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            if (this.f19403a.isUnsubscribed()) {
                return;
            }
            this.f19403a.onNext(qr9.b(rr9.this.f44520a, i, i2, i3, i4));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            rr9.this.f44520a.setOnScrollChangeListener(null);
        }
    }

    public rr9(View view) {
        this.f44520a = view;
    }

    public void call(Subscriber<? super qr9> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44520a.setOnScrollChangeListener(aVar);
    }
}
