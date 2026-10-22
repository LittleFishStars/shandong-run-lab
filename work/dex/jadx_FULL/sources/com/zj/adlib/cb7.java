package com.zj.adlib;

import android.widget.RatingBar;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cb7 implements Observable.OnSubscribe<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RatingBar f40939a;

    public class a implements RatingBar.OnRatingBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15779a;

        public a(Subscriber subscriber) {
            this.f15779a = subscriber;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
            if (this.f15779a.isUnsubscribed()) {
                return;
            }
            this.f15779a.onNext(Float.valueOf(f));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            cb7.this.f40939a.setOnRatingBarChangeListener(null);
        }
    }

    public cb7(RatingBar ratingBar) {
        this.f40939a = ratingBar;
    }

    public void call(Subscriber<? super Float> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f40939a.setOnRatingBarChangeListener(aVar);
        subscriber.onNext(Float.valueOf(this.f40939a.getRating()));
    }
}
