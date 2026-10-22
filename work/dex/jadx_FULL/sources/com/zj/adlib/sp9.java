package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class sp9 implements Observable.OnSubscribe<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44746a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19620a;

        public a(Subscriber subscriber) {
            this.f19620a = subscriber;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f19620a.isUnsubscribed()) {
                return;
            }
            this.f19620a.onNext((Object) null);
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            sp9.this.f44746a.setOnClickListener(null);
        }
    }

    public sp9(View view) {
        this.f44746a = view;
    }

    public void call(Subscriber<? super Void> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44746a.setOnClickListener(aVar);
    }
}
