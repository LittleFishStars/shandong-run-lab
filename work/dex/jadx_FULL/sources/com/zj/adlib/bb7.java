package com.zj.adlib;

import android.widget.RatingBar;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bb7 implements Observable.OnSubscribe<ab7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RatingBar f40714a;

    public class a implements RatingBar.OnRatingBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15482a;

        public a(Subscriber subscriber) {
            this.f15482a = subscriber;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
            if (this.f15482a.isUnsubscribed()) {
                return;
            }
            this.f15482a.onNext(ab7.b(ratingBar, f, z));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            bb7.this.f40714a.setOnRatingBarChangeListener(null);
        }
    }

    public bb7(RatingBar ratingBar) {
        this.f40714a = ratingBar;
    }

    public void call(Subscriber<? super ab7> subscriber) {
        MainThreadSubscription.a();
        a aVar = new a(subscriber);
        subscriber.b(new b());
        this.f40714a.setOnRatingBarChangeListener(aVar);
        RatingBar ratingBar = this.f40714a;
        subscriber.onNext(ab7.b(ratingBar, ratingBar.getRating(), false));
    }
}
