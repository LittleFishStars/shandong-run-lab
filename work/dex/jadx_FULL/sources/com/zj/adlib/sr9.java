package com.zj.adlib;

import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class sr9 implements Observable.OnSubscribe<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f44760a;

    public class a implements View.OnSystemUiVisibilityChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f19633a;

        public a(Subscriber subscriber) {
            this.f19633a = subscriber;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if (this.f19633a.isUnsubscribed()) {
                return;
            }
            this.f19633a.onNext(Integer.valueOf(i));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            sr9.this.f44760a.setOnSystemUiVisibilityChangeListener(null);
        }
    }

    public sr9(View view) {
        this.f44760a = view;
    }

    public void call(Subscriber<? super Integer> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f44760a.setOnSystemUiVisibilityChangeListener(aVar);
    }
}
