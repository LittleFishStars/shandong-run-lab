package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class tq9 implements Observable.OnSubscribe<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44986a;

    public class a implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19887a;

        public a(Subscriber subscriber) {
            this.f19887a = subscriber;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (this.f19887a.isUnsubscribed()) {
                return;
            }
            this.f19887a.onNext(Boolean.valueOf(z));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            tq9.this.f44986a.setOnFocusChangeListener(null);
        }
    }

    public tq9(View view) {
        this.f44986a = view;
    }

    public void call(Subscriber<? super Boolean> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44986a.setOnFocusChangeListener(aVar);
        subscriber.onNext(Boolean.valueOf(this.f44986a.hasFocus()));
    }
}
